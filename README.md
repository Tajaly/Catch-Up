# Catch-Up

Catch-Up is a social web application designed to help users organize events easily within their social circles. The platform simplifies the management of multiple social groups and facilitates activity planning for each of them.

## Features
- Users can create and manage social circles.
- Users can invite others to join their circles.
- Circle members can organize meetings ("Catch-Ups") and invite others.
- Members can provide feedback on invitations (accept/decline).

## Quality Goals
- **Security:** Implementation of OAuth2 authentication.
- **Scalability:** Designed to support a growing number of users.

## Possible Future Enhancements
- **Google Maps Integration** for event location display.
- **Calendar View** for better event management.
- **Multilingual Support** (e.g., German).

## Solution Strategy
The project is built with a focus on simplicity, expandability, and maintainability. The following technologies and methodologies are used:

### Tech Stack
- **Language:** Java
- **Build Tool:** Gradle
- **Version Control:** GitHub

### Quality Assurance
To ensure functionality and compliance with architectural rules:
- **Unit Testing:** JUnit
- **Architecture Rules Compliance:** ArchUnit
- **Code Quality:** Checkstyle (Google Standard), SpotBugs
- **Accessibility:** Screen Reader Support

### Architecture & Development Approach
- **Domain-Driven Design (DDD)** for structured modeling.
- **Onion Architecture** for a well-layered, maintainable system.
- **Layered Architecture** to support modular development.
- **Incremental and Iterative Development** for continuous improvements.

## Open Source
The project is planned to be released as an open-source application on GitHub.

---

Feel free to contribute and help improve Catch-Up!
