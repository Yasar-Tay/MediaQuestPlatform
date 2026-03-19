# Media Quest Platform

A Spring Boot microservice project evolving from a classic education showcase into a more modern, youth-oriented platform for guided media discovery.

The current direction is:

* users describe what they want to learn or explore
* the platform turns that intent into a guided quest
* media content is recommended and organized into steps
* a chatbot and AI service can later assist with roadmap generation, summaries, and recommendations

## Current Architecture

The platform currently contains these modules:

* `discovery-server`
* `api-gateway`
* `auth-service`
* `content-service`
  This is the current GraphQL content prototype and is planned to evolve into a `content-service`
* `certificate-client-service`  
  Planned to evolve into a `quest-service`
* `certificate-soap-server`  
  Planned to evolve into an `ai-service`

## Current Running Services

| Service | Purpose | Port |
| --- | --- | --- |
| `discovery-server` | Eureka service discovery | `8761` |
| `api-gateway` | Entry point and JWT-protected routing | `8080` |
| `auth-service` | Authentication, registration, JWT, user management | `8081` |
| `content-service` | GraphQL CRUD prototype for content-like data | `8082` |

## Current Auth Flow

Implemented:

* register
* login
* JWT generation
* `/auth/me`
* admin-only `/users/**`
* gateway-level JWT validation

## Current GraphQL Flow

The current GraphQL prototype in `content-service` supports:

* `courses`
* `courseById`
* `createCourse`
* `updateCourse`
* `deleteCourse`

This service is still in an in-memory prototype stage and is expected to be reshaped into a media/content service.

## Planned Product Direction

The target concept is a **Media Quest Platform**:

1. the user says what they want to learn or explore
2. the platform understands the request
3. a quest or roadmap is generated
4. media content is attached to each step
5. progress is tracked
6. a chatbot can guide the user through the flow

## Planned Service Direction

| Current Module | Planned Direction |
| --- | --- |
| `auth-service` | stays as auth-service |
| `api-gateway` | stays as api-gateway |
| `content-service` | `content-service` |
| `certificate-client-service` | `quest-service` |
| `certificate-soap-server` | `ai-service` |

## Local Development

Requirements:

* Java 17
* Maven
* Docker
* Docker Compose

Current local setup:

* PostgreSQL runs in Docker
* application services can run locally

`docker-compose.yml` currently provides PostgreSQL only.

## Immediate Next Steps

The most likely next technical steps are:

1. rename the content domain from `Course` to `MediaContent`
2. keep evolving `content-service` into the media/content backbone of the platform
3. introduce quest generation and progress tracking
4. evolve the certificate-related modules into quest and AI services
