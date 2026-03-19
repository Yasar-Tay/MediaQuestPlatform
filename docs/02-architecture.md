# System Architecture

The platform follows a microservice architecture where each service owns a focused business responsibility.

## High-Level Flow

Client -> API Gateway -> Microservices -> Datastores

Planned guided-learning flow:

Client -> API Gateway -> Quest/Chat flow -> AI intent analysis -> Content lookup -> Progress tracking -> Certificate validation

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

### Future Quest Service

The planned `quest-service` will be responsible for:

* creating quests from interpreted user intent
* managing quest steps
* tracking user progress
* coordinating with content and certification services

### Future AI Service

The planned `ai-service` will be responsible for:

* chatbot-oriented intent extraction
* quest-outline generation
* summaries and recommendations
* future adaptive guidance features

### Certificate SOAP Services

The current certificate-related modules are planned to support SOAP-based certification workflows:

* `certificate-client-service`
  SOAP client integration used to request validation and certificate issuance
* `certificate-soap-server`
  SOAP server acting as the certification authority

Planned certificate SOAP responsibilities:

* validate quest completion
* issue completion certificates
* verify previously issued certificates
