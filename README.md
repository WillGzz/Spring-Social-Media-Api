# Project: Spring Social Media App API

## Background 

This project serves as the backend API for a social media application, built using the Spring Boot framework. It focuses on managing user accounts and the messages they submit to the platform. The backend is implemented using Spring Boot and Spring Web, with support for dependency injection, RESTful endpoints, and proper HTTP status handling. It is responsible for delivering the data required to display user-generated content and processing core actions such as user registration, login authentication, message creation, updating, retrieval, and deletion.

## Features

- **User Account Management**: Register, login, and authenticate users.
- **Message Management**: Create, update, and delete messages.
- **User Message Retrieval**: View all messages posted by a particular user or view all messages on the platform.
- **Data Persistence**: Store and retrieve user data and messages from a relational database.

The project follows a **three-layer architecture**, consisting of:

- **Controller Layer**: Handles HTTP requests and routes them to appropriate service methods.
- **Service Layer**: Contains the business logic for processing data and interacting with the DAO layer.
- **Repository (DAO) Layer**: Interfaces with the database using Spring Data JPA.

## Technologies Used


**Language:**  
- Java  
- SQL

**Frameworks & Libraries:**  
- Spring Boot  
- Spring Web (MVC)  
- Spring Data JPA  
- Hibernate (via JPA)  
- Jackson (for JSON serialization/deserialization)

**Database:**  
- H2 (in-memory database)

**Testing & Development:**  
- Spring Boot Test  
- JUnit  
- Maven