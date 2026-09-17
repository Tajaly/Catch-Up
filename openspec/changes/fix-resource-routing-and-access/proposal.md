## Why

Circle and hangout pages identify resources by display names while their controllers authorize access using an optional, unbound `id` parameter. This makes legitimate navigation unreliable and prevents the application from enforcing access control against the resource actually requested.

## What Changes

- Replace name-derived circle and hangout detail routes with routes that use stable database identifiers.
- Resolve each requested circle or hangout from its route identifier before rendering it.
- Restrict circle and hangout detail access to members of the associated circle.
- Return a user-facing not-found response when a requested resource does not exist instead of allowing repository lookup failures to surface as server errors.
- Update generated links and redirects to use the new canonical routes.

## Capabilities

### New Capabilities

- `resource-routing-and-access`: Provides stable identifier-based routes and membership-aware access control for circle and hangout detail resources.

### Modified Capabilities

- None.

## Impact

- Affects the circle and hangout controllers, application service, repository ports and adapters, and their Thymeleaf templates.
- Changes the externally visible detail-page URL format; legacy name-based detail URLs will no longer be canonical.
- Adds focused controller and service/integration coverage for route resolution, authorization, and absent resources.
