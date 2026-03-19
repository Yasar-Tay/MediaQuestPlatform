# System Architecture

The platform follows a microservice architecture where each service owns a focused business responsibility.

## High-Level Flow

Client -> API Gateway -> Microservices -> Datastores

## Core Components

### API Gateway

Responsible for:

* routing
* gateway-level JWT validation
* protected vs public endpoint separation

### Service Discovery

The discovery server allows services to locate each other by service name.

### Auth Service

Responsible for:

* registration
* login
* JWT generation
* current-user lookup
* admin-only user management

### Content Prototype Service

The current `content-service` acts as a GraphQL prototype and is planned to evolve into a content-focused media service.

### Future Quest and AI Services

The current certificate-related modules are planned to be repurposed into:

* `quest-service`
* `ai-service`
