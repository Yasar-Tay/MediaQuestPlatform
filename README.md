# 🎓 Smart Education Platform

A **Spring Boot microservice architecture** demonstrating modern distributed backend design including **REST, GraphQL, and SOAP integrations**.

The platform simulates an online education system where users can enroll in courses and receive certificates generated via a **mock e-government SOAP service**.

---

# 🧩 Architecture Overview

The system follows a **microservice architecture pattern** where each service owns its domain and database.

Client requests are routed through the API Gateway and distributed across services registered in the discovery server.

```
Client
   ↓
API Gateway
   ↓
-------------------------------------
| Auth Service (REST + PostgreSQL) |
| Course Service (GraphQL + Mongo) |
| Certificate Service              |
-------------------------------------
   ↓
Certificate SOAP Server (Mock External System)
```

---

# ⚙️ Technology Stack

## Backend

* Java 17
* Spring Boot
* Spring Cloud

## Microservice Infrastructure

* Eureka Service Discovery
* Spring Cloud Gateway
* Resilience4j Circuit Breaker

## Communication

* REST APIs
* GraphQL
* SOAP Web Services

## Databases

| Database   | Usage                 |
| ---------- | --------------------- |
| PostgreSQL | Users, authentication |
| MongoDB    | Courses, lessons      |

## DevOps

* Docker
* Docker Compose

---

# 🧠 Microservices

| Service                 | Description                  | Port |
| ----------------------- | ---------------------------- | ---- |
| discovery-server        | Service discovery (Eureka)   | 8761 |
| api-gateway             | Entry point for all requests | 8080 |
| auth-service            | Authentication and JWT       | 8081 |
| course-service          | Course management (GraphQL)  | 8082 |
| certificate-service     | Certificate generation       | 8083 |
| certificate-soap-server | Mock government SOAP service | 8084 |

---

# 🔄 Service Communication Flow

Course completion triggers certificate generation through a SOAP integration.

```
Course Service
     ↓
Certificate Service
     ↓
SOAP Server
```

Communication types used:

```
GraphQL → REST → SOAP
```

---

# 🗄️ Database Strategy

The platform follows the **database-per-service pattern**.

```
Auth Service → PostgreSQL
Course Service → MongoDB
```

Benefits:

* Service isolation
* Independent scalability
* Domain ownership

---

# 🚀 Running the Project

## Requirements

Install:

* Java 17
* Maven
* Docker
* Docker Compose

---

## Start the Platform

```bash
docker-compose up
```

Once started:

| Service          | URL                   |
| ---------------- | --------------------- |
| Eureka Dashboard | http://localhost:8761 |
| API Gateway      | http://localhost:8080 |

---

# 📂 Project Structure

```
smart-education-platform
│
├── discovery-server
├── api-gateway
├── auth-service
├── course-service
├── certificate-service
├── certificate-soap-server
│
├── docker-compose.yml
├── docs
└── README.md
```

---

# 📊 Architectural Concepts Demonstrated

This project demonstrates several enterprise architecture patterns:

* Microservice Architecture
* API Gateway Pattern
* Service Discovery
* Circuit Breaker Pattern
* Database per Service
* Integration with Legacy SOAP Systems

---

# 📈 Future Improvements

Potential enhancements:

* Kubernetes deployment
* CI/CD pipeline
* Centralized logging (ELK)
* Distributed tracing (OpenTelemetry + Jaeger)
* Event-driven communication with Kafka

---

# 👨‍💻 Author

This project was built as a **microservice architecture showcase** demonstrating modern backend development practices using the Spring ecosystem.

---
