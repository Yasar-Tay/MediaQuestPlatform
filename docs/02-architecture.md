# System Architecture

The platform follows a microservice architecture where each service is responsible for a specific business domain.

## High-Level Architecture

Client requests flow through the API Gateway which routes them to the appropriate services.

Architecture Flow:

Client → API Gateway → Microservices → Databases

## Core Components

### API Gateway

Handles:

* Routing
* Authentication validation
* Request filtering

### Service Discovery

The discovery server allows services to dynamically locate each other using service names instead of static addresses.

### Microservices

Each service owns its data and is responsible for its own business logic.

### External SOAP System

The certificate service communicates with a SOAP server simulating an external government certificate system.
