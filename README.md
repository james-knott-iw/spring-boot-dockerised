# spring-boot-dockerised

This repository contains demonstrations of two versions of Spring Boot applications that can be Dockerised. The first, [Hello World](#hello-world) is a simple hello world application. The second, [Demo API](#demo-api) is an API that allows you to create an Person entities and Pet entities. Where one Person can have many Pets.

## System Requirements

- Java JDK17+
- Maven
- Docker

## Starting off

First you need to clone the repository.

This can be done by HTTPS, SSH or GitHubCLI.

### HTTPS

```
git clone https://github.com/IntegrationWorks/spring-boot-dockerised.git
```

### SSH

```
git clone git@github.com:IntegrationWorks/spring-boot-dockerised.git
```

### GitHubCLI
```
gh repo clone IntegrationWorks/spring-boot-dockerised
```

Open the `/spring-boot-dockerised` directory in a terminal or IDE and follow the next instructions in [Hello World](#hello-world) or [Demo Api](#demo-api).


## Hello World

To begin, enter the [/hello-world](/hello-world) directory:

```bash
cd hello-world
```

The next step is to package the Spring Boot application into a `.jar` file which will be located at `/target/hello-world-0.0.1.jar`:

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
### Tests
To verify the Spring Boot application is running. Either go to [http://localhost:8080](http://localhost:8080) in your web browser or perform the following curl command:

```bash
curl http://localhost:8080
```
Check that the response content is - `Hello World!`.

## Demo API

To begin, enter the [/demo-api](/demo-api) directory:

```bash
cd demo-api
```

The next step is to package the Spring Boot application into a `.jar` file which will be located at `/target/demo-api-0.0.1.jar`:

```bash
mvn clean package
```

To build the Docker image using the Dockerfile located in the `/demo-api` directory:


```bash
docker build --tag=demo-api:latest .
```

To run the Docker container of the Spring Boot application:


```bash
docker run -d -p8080:8080 demo-api:latest
```
### Tests
- To test the Demo API, import the Postman requests JSON file [Person Requests.postman_collection.json](/demo-api/Demo%20API%20Requests.postman_collection.json). This Postman collection contains requests to perform CRUD on Person and Pet Entities.  
- There is also an Open API Schema using Swagger UI at [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html).
