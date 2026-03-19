# Media Quest Platform

A Spring Boot microservice project evolving from a classic education showcase into a guided learning and media discovery platform.

The current direction is:

* users describe what they want to learn or explore
* a chatbot captures that request in natural language
* the AI layer extracts user intent from the message
* the platform turns that intent into a guided quest
* media content is recommended and organized into steps
* progress is tracked over time
* completed quests can be validated for certification

## Current Architecture

The platform currently contains these modules:

* `discovery-server`
* `api-gateway`
* `auth-service`
* `content-service`
  This is the current GraphQL content prototype and is planned to evolve into a `content-service`
* `certificate-client-service`  
  Planned to act as the SOAP client integration for certificate and completion validation
* `certificate-soap-server`  
  Planned to act as the SOAP server for certificate issuance and verification

Planned next service additions:

* `quest-service`
  Will manage quests, quest steps, and user progress
* `ai-service`
  Will support chatbot intent extraction, quest-outline generation, summaries, and recommendations

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

## Example GraphQL Content Flow

The content model is now centered around:

* `provider`
* `mediaType`

Example mutation:

```graphql
mutation CreateContent {
  createContent(
    input: {
      id: "mc-101"
      title: "Guitar Chords for Beginners"
      description: "A simple introduction to first-position guitar chords."
      provider: YOUTUBE
      mediaType: VIDEO
      mediaUrl: "https://youtube.com/watch?v=example"
      thumbnailUrl: "https://img.youtube.com/vi/example/maxresdefault.jpg"
      tags: ["guitar", "music", "beginner"]
      difficulty: BEGINNER
      durationSeconds: 900
      creatorName: "Media Quest"
    }
  ) {
    id
    title
    provider
    mediaType
  }
}
```

Example query:

```graphql
query GetContents {
  contents {
    id
    title
    provider
    mediaType
    difficulty
  }
}
```

Typical endpoints during development:

* direct service endpoint: `http://localhost:8082/graphql`
* gateway endpoint: `http://localhost:8080/content-graphql`

## Planned Product Direction

The target concept is a **Media Quest Platform**:

1. the user tells the chatbot what they want to learn or explore
2. the AI layer extracts intent from the message
3. a quest or roadmap is generated from that intent
4. media content is attached to each step
5. progress is tracked during the journey
6. completed quests can trigger completion validation and certification
7. the chatbot can continue guiding the user through the flow

## Planned Service Direction

| Current Module | Planned Direction |
| --- | --- |
| `auth-service` | stays as auth-service |
| `api-gateway` | stays as api-gateway |
| `content-service` | `content-service` |
| `certificate-client-service` | SOAP client for certificate validation and issuance |
| `certificate-soap-server` | SOAP certificate authority for validation, issuance, and verification |
| future `quest-service` | quest creation, steps, and progress |
| future `ai-service` | chatbot intent extraction and AI assistance |

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
3. introduce `quest-service` for quest generation and progress tracking
4. introduce `ai-service` for chatbot and intent extraction
5. evolve the certificate-related modules into SOAP-based completion validation and certificate issuance services
