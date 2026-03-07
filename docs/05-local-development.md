# Local Development

## Requirements

Install the following tools:

* Java 17
* Maven
* Docker
* Docker Compose

## Running the System

Clone the repository:

```bash
git clone https://github.com/your-repo/smart-education-platform
```

Start services:

```bash
docker-compose up
```

## Service Ports

| Service                 | Port |
| ----------------------- | ---- |
| discovery-server        | 8761 |
| api-gateway             | 8080 |
| auth-service            | 8081 |
| course-service          | 8082 |
| certificate-service     | 8083 |
| certificate-soap-server | 8084 |
