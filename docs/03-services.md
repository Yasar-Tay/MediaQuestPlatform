# Services

## discovery-server

Service discovery using Netflix Eureka.

Responsibilities:

* service registration
* service lookup

Default Port: `8761`

---

## api-gateway

Entry point for client requests.

Responsibilities:

* routing
* JWT validation at the gateway
* protecting non-public routes

Default Port: `8080`

---

## auth-service

Authentication and user management service.

Responsibilities:

* user registration
* login
* JWT token generation
* current-user endpoint
* admin-only user management

Database: PostgreSQL

Default Port: `8081`

---

## content-service

Current GraphQL prototype service.

Responsibilities today:

* GraphQL CRUD
* in-memory content-like data

Planned direction:

* become `content-service`
* manage media metadata
* support discovery and recommendation flows

Current content modeling direction:

* use `provider` to represent where content comes from
* use `mediaType` to represent the format of the content
* evolve from course-shaped sample data into reusable `MediaContent` records

Default Port: `8082`

---

## certificate-client-service

Planned SOAP client integration service.

Responsibilities:

* call the certificate SOAP server
* request quest completion validation
* request certificate issuance
* forward certificate verification requests when needed

---

## certificate-soap-server

Planned SOAP server for certification workflows.

Responsibilities:

* validate quest completion eligibility
* issue completion certificates
* verify certificate authenticity

---

## future quest-service

Planned REST service for guided learning flows.

Responsibilities:

* create quests from interpreted user requests
* manage quest steps and states
* track user progress
* coordinate with content and certificate services

---

## future ai-service

Planned REST service for AI-assisted learning flows.

Responsibilities:

* interpret chatbot messages
* extract structured learning intent
* generate quest outlines
* support summaries and recommendations
