# Services

## discovery-server

Service discovery server using Netflix Eureka.

Responsibilities:

* Register services
* Provide service lookup

Default Port: 8761

---

## api-gateway

Entry point for all client requests.

Responsibilities:

* Routing requests to services
* Security filtering
* Rate limiting

Default Port: 8080

---

## auth-service

Handles authentication and authorization.

Responsibilities:

* User registration
* Login
* JWT token generation
* Role management

Database: PostgreSQL

---

## course-service

Handles course content management.

Responsibilities:

* Create courses
* Manage lessons
* Query course structures

API Style: GraphQL
Database: MongoDB

---

## certificate-service

Responsible for generating certificates after course completion.

Responsibilities:

* Trigger certificate generation
* Call external SOAP service
* Handle retry logic

---

## certificate-soap-server

Mock external SOAP server representing an external government certificate system.
