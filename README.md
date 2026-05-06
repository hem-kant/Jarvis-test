# Balanced Authentication System

A demonstration project showcasing a balanced authentication system.

## Features
- Project structure setup
- Core data model definition
- Shared utilities creation
- User login functionality
- Personalized home page post-login
- Page navigation
- Code quality, security hardening, and accessibility audit

## Tech Stack
- Java
- Spring Boot
- Maven
- HTML

## Setup/Installation
1. Clone the repository
2. Ensure you have Java and Maven installed
3. Run `mvn install` to download dependencies

## Running Locally
1. Execute `mvn spring-boot:run` to start the application
2. Open your browser and navigate to `http://localhost:8080`

## Project Structure
```
demo-demo/
├── index.html
├── home.html
├── layout.html
├── pom.xml
├── login.html
├──.github/
│   └── workflows/
│       ├── maven.yml
│       └── deploy-pages.yml
└── src/
    └── main/
        ├── resources/
        │   ├── templates/
        │   │   ├── home.html
        │   │   ├── layout.html
        │   │   └── login.html
        │   └── application.properties
        └── java/
            └── com/
                └── example/
                    └── demo/
                        ├── repository/
                        │   └── UserRepository.java
                        ├── util/
                        │   └── SecurityUtils.java
                        ├── security/
                        │   └── SecurityConfig.java
                        ├── controller/
                        │   └── HomeController.java
                        ├── model/
                        │   └── User.java
                        └── DemoApplication.java
```
