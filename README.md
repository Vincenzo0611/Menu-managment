# Microservices Project with Angular and Spring Boot

## Project Description
The project consists of three microservices written in Spring Boot and a frontend application built with Angular. The entire system is managed using Docker and Docker Compose.

### Directory Structure
- **API_Gateway** – API gateway handling traffic to microservices
- **category-management** – microservice managing categories
- **elements-management** – microservice managing elements
- **menu-management** – Angular frontend application
- **docker-compose.yml** – Docker Compose configuration file

## Requirements
- Docker and Docker Compose
- Java 17+
- Node.js 16+
- Angular CLI

## Installation and Running

### 1. Clone the Repository
```sh
 git clone https://github.com/Vincenzo0611/Menu-managment.git
 cd Menu-managment
```

### 2. Build the Backend Applications
Each microservice needs to be built before running Docker.
```sh
 cd API_Gateway
 mvn clean install
 cd ../category-management
 mvn clean install
 cd ../elements-management
 mvn clean install
```

### 3. Build the Frontend Application
```sh
 cd menu-management
 npm install
 ng build --configuration=production
```

### 4. Start the Entire System with Docker Compose
```sh
 cd ..
 docker-compose up --build
```

### 5. Access the Application
- **Angular Frontend:** [http://localhost:4200](http://localhost:4200)
- **API Gateway:** [http://localhost:8080](http://localhost:8080)

## Stopping Services
To stop the containers, use:
```sh
 docker-compose down
```

