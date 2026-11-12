# ADR-001 — Adoption of a Modular Monolith

**Status:** Accepted

## Context

The ERP is in its initial development phase, focusing on user management, companies, user-company relationships, and access control. At this stage, we need to establish the domain model, implement role-based access control (RBAC), and define auditing mechanisms.

The project also aims to build practical knowledge of software architecture and eventually evolve into a SaaS product.

Starting with microservices would introduce challenges involving inter-service communication, deployment, failure handling, and distributed data consistency. This additional effort would increase initial complexity and could reduce the attention devoted to business rules and system organization.

## Decision

The ERP will be developed as a modular monolith using Java and Spring Boot, organized into modules with clearly defined responsibilities and boundaries.

The application will be deployed as a single unit. Communication between modules must respect their interfaces and avoid direct access to other modules’ internal implementation details.

This structure will allow us to start with simpler operations while preserving the possibility of extracting modules into independent services if justified by future needs.

## Positive Consequences

- Lower initial complexity in development, deployment, and operations.
- More attention to domain modeling, business rules, RBAC, and auditing.
- Easier local execution and debugging.
- An opportunity to refine module boundaries before considering distribution across services.

## Negative Consequences

- Deployment and scaling will initially apply to the entire application.
- Failures in one module may affect other modules within the application.
- Maintaining module boundaries will require discipline to prevent excessive coupling.
- Future extraction into microservices will require adaptations; modularization alone does not eliminate this work.

## Future Evolution

**Learning:** There will be at least one hands-on exercise involving microservices and distributed communication.

**Product:** The adoption of microservices in production will depend on technical justification, rather than educational goals alone.

An interest in learning about distributed systems may also motivate experiments. However, introducing microservices into the product must take into account whether their benefits outweigh the costs of communication, distributed consistency, observability, and operations.
