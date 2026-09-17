## 1. Resource lookup and authorization foundation

- [ ] 1.1 Add absence-aware circle and hangout lookup operations to the repository ports and persistence adapters, and verify persistence tests cover both existing and nonexistent identifiers.
- [ ] 1.2 Add application-service operations that resolve circle and hangout detail resources and check the signed-in user's membership against the owning circle, and verify unit or integration tests cover member and non-member outcomes.
- [ ] 1.3 Map absent resource lookups to HTTP 404 and failed membership checks to HTTP 403 without converting persistence failures into not-found responses, and verify controller tests assert both status codes.

## 2. Canonical detail routes

- [ ] 2.1 Replace circle name-based detail handling with `/circles/{circleId}`, resolve the route identifier before authorization, and verify a member can open a listed circle through its canonical URL.
- [ ] 2.2 Replace hangout name-and-circle detail handling with `/hangouts/{hangoutId}`, resolve the route identifier before authorization, and verify a member can open a created hangout through its canonical URL.
- [ ] 2.3 Update circle and hangout creation redirects and all relevant Thymeleaf links to use canonical ID-based URLs, and verify rendered links and post-create `Location` headers contain the saved identifiers.

## 3. Detail rendering and regression coverage

- [ ] 3.1 Pass resolved circle and hangout data to their detail templates and render the available detail fields, and verify successful detail responses include the requested resource data.
- [ ] 3.2 Add controller-level coverage for allowed member access, denied non-member access, and missing circle and hangout requests, and verify the focused test set passes.
- [ ] 3.3 Run `gradlew.bat test --no-daemon` with Java 21 configured in `JAVA_HOME`, and verify the complete existing test suite passes.
