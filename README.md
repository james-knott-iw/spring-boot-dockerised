# spring-boot-dockerised

This repository contains two versions of Spring Boot applications that can be Dockerised.

## System Requirements

- Java JDK17+
- Maven
- Docker

## Hello World

To begin, enter the `/hello-world` directory within the repository:

```bash
cd hello-world
```

The next step is to package the spring boot application into a `.jar` file which will be located at `/target/hello-world-0.0.1.jar`:

```bash
mvn clean package
```

To build the Docker image using the Dockerfile located in the `/hello-world` directory:


```bash
docker build --tag=hello-world:latest .
```

To run the Docker image of the Spring Boot application:


```bash
docker run -d -p8080:8080 hello-world:latest
```

To verify the Spring Boot application is running. Either go to [http://localhost:8080](http://localhost:8080) in your web browser or perform the following curl command:

```bash
curl http://localhost:8080
```
Check that the response content is - `Hello World!`.