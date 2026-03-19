# Local Development

## Requirements

Install:

* Java 17
* Maven
* Docker
* Docker Compose

## Current Local Setup

At the moment:

* PostgreSQL is run through Docker
* services can be started locally from the IDE or terminal

## Active Service Ports

| Service | Port |
| --- | --- |
| `discovery-server` | `8761` |
| `api-gateway` | `8080` |
| `auth-service` | `8081` |
| `content-service` | `8082` |

## Notes

The current `docker-compose.yml` is intentionally minimal and mainly supports the database layer during local development.
