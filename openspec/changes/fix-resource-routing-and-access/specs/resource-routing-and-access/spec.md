## Purpose

Provide dependable direct links to circle and hangout resources while ensuring
only their circle members can view their private details.

## ADDED Requirements

### Requirement: Canonical circle detail routing
The system SHALL expose each circle detail page at `/circles/{circleId}`, where
`circleId` is that circle's stable identifier. Every circle detail link and
post-creation redirect SHALL use this canonical route.

#### Scenario: Member opens a listed circle
- **WHEN** a signed-in member selects a circle from their circles overview
- **THEN** the system navigates to `/circles/{circleId}` and displays that circle's details

#### Scenario: Creator is redirected after creating a circle
- **WHEN** a user successfully creates a circle
- **THEN** the system redirects the user to `/circles/{circleId}` for the newly created circle

### Requirement: Canonical hangout detail routing
The system SHALL expose each hangout detail page at `/hangouts/{hangoutId}`,
where `hangoutId` is that hangout's stable identifier. Every hangout detail
link and post-creation redirect SHALL use this canonical route.

#### Scenario: Creator is redirected after creating a hangout
- **WHEN** a user successfully creates a hangout
- **THEN** the system redirects the user to `/hangouts/{hangoutId}` for the newly created hangout

### Requirement: Membership-gated resource access
The system SHALL allow a signed-in user to view a circle or hangout detail page
only when the user is a member of the circle that owns the requested resource.
For an existing resource the user is not permitted to view, the system SHALL
return an HTTP 403 response.

#### Scenario: Circle member views circle details
- **WHEN** a signed-in user who belongs to a requested circle opens `/circles/{circleId}`
- **THEN** the system displays the requested circle's details

#### Scenario: Circle member views hangout details
- **WHEN** a signed-in user who belongs to the circle for a requested hangout opens `/hangouts/{hangoutId}`
- **THEN** the system displays the requested hangout's details

#### Scenario: Non-member requests a private resource
- **WHEN** a signed-in user who is not a member of the owning circle requests an existing circle or hangout detail page
- **THEN** the system returns HTTP 403 without displaying the resource details

### Requirement: Missing resource handling
The system SHALL return HTTP 404 for a circle or hangout detail request whose
identifier does not resolve to an existing resource.

#### Scenario: Requested circle does not exist
- **WHEN** a signed-in user requests `/circles/{circleId}` for an identifier with no corresponding circle
- **THEN** the system returns HTTP 404

#### Scenario: Requested hangout does not exist
- **WHEN** a signed-in user requests `/hangouts/{hangoutId}` for an identifier with no corresponding hangout
- **THEN** the system returns HTTP 404
