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

Default Port: `8082`

---

## certificate-client-service

Currently a placeholder module.

Planned direction:

* become `quest-service`
* manage quests, quest steps, and user progress

---

## certificate-soap-server

Currently a placeholder module from the earlier concept.

Planned direction:

* become `ai-service`
* support intent parsing, roadmap generation, summaries, and recommendations
