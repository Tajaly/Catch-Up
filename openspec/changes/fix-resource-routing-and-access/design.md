## Context

See `proposal.md` for motivation and
`specs/resource-routing-and-access/spec.md` for required behavior. The current
web controllers use display names in route paths but depend on an unbound
request `id` to fetch and authorize circles and hangouts. Repository methods
throw when no resource exists, and templates generate URLs that pair a name path
with an identifier query parameter.

The application is a server-rendered Spring Boot application using GitHub OAuth
to identify the signed-in user. Circle membership is already persisted and is
the authorization boundary for private circle and hangout data.

## Goals / Non-Goals

**Goals:**

- Make every displayed circle and hangout refer to one stable, unambiguous URL.
- Resolve a requested resource before applying membership authorization.
- Provide predictable 403 and 404 HTTP behavior for protected detail pages.
- Keep authorization rules centralized enough to avoid divergent controller logic.

**Non-Goals:**

- Supporting legacy name-based detail URLs or redirects from them.
- Adding circle invitations, membership management, event RSVPs, editing, or
  deletion.
- Changing OAuth provider setup, user onboarding, or the database schema.
- Designing a general role/permission model beyond existing circle membership.

## Decisions

### Use plural, ID-based resource routes

Circle details will use `/circles/{circleId}` and hangout details will use
`/hangouts/{hangoutId}`. Controller mappings, Thymeleaf links, and successful
creation redirects will be updated together.

Stable identifiers avoid ambiguity from duplicate or changed display names and
make the URL itself provide the identifier required for retrieval and
authorization. Plural route names align detail pages with the existing
collection endpoints.

Alternatives considered:

- Keep name paths and pass IDs as query parameters: leaves identity split
  between the path and query string and retains broken controller binding.
- Use name-only lookup: names are not constrained as unique and are editable
  domain data.
- Preserve existing routes through compatibility redirects: not required for
  this unreleased prototype and expands the authorization surface.

### Resolve resources through optional lookup ports

Repository interfaces will offer lookup methods that represent absence without
exceptions for circles and hangouts. The application service will resolve
resources from these lookups and expose a focused membership check that accepts
the resolved circle identifier. Controllers convert absence into HTTP 404
before attempting authorization.

This distinguishes ordinary missing-resource behavior from persistence failures
and avoids using exceptions as control flow for a user-supplied identifier.

Alternative considered:

- Catch `NoSuchElementException` around existing throwing repository methods:
  conflates expected absence with implementation errors and makes accidental
  failures appear as 404 responses.

### Enforce membership after existence resolution

For a resolved circle, authorization uses that circle's identifier. For a
resolved hangout, authorization uses its owning circle identifier. A non-member
receives HTTP 403; missing resources receive HTTP 404.

This ordering lets the application safely load the resource association needed
for authorization while retaining explicit semantics for both conditions.

Alternative considered:

- Redirect non-members to home: hides the access failure from clients and
  prevents callers and tests from distinguishing forbidden access.

### Render resolved resources in detail templates

The circle and hangout controllers will pass the resolved domain object to their
templates. Detail templates can then render their actual data without doing
additional persistence lookups.

## Risks / Trade-offs

- [Existing bookmarks use old routes] -> This prototype will intentionally not
  support them; the URL change is documented as a breaking behavior change.
- [Spring Data JDBC aggregate mapping may make hangout lookups unreliable] ->
  Add focused persistence coverage for the optional lookup and correct only the
  affected query or mapping if it fails.
- [Duplicate membership rows can make membership queries inefficient] ->
  This change preserves current schema scope; add a uniqueness constraint as a
  separate data-integrity change.
- [Returning 403 reveals a resource exists] -> This is accepted to provide the
  explicit authorization contract; access still reveals no resource details.

## Migration Plan

1. Deploy the application with canonical routes, updated links, and access
   behavior as one release.
2. No data migration is required because the canonical route uses existing
   persisted identifiers.
3. If rollback is needed, redeploy the prior application version; the database
   schema and stored data remain compatible.
