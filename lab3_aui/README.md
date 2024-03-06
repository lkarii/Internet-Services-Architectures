# Lab 3: Introduction to Spring MVC and REST Services

## Overview

This third laboratory work in the "Internet Services Architectures" course introduces students to the basics of Spring MVC, particularly focusing on the implementation of REST services. The project builds upon the code and concepts developed in the previous laboratories.

## Objectives

1. **DTO Class Implementation:** Develop DTO classes for creating/updating and reading all entity classes. Create separate DTOs for reading collections, with DTOs for creation/updating containing only modifiable fields and DTOs for reading collections focusing on identifiers and user-friendly information.
2. **REST Controllers Implementation:** Implement `@RestController` for each entity class, ensuring these controllers utilize services for business operations and handle the translation between business entities and DTO objects. Controllers should support creating/updating, deleting, and reading of elements and categories, as well as handling entire collections with well-structured RESTful endpoints and appropriate HTTP methods and response codes.
3. **HTTP Requests Documentation and Testing:** Document and test all HTTP requests using standard `.http` files, compatible with tools like IntelliJ IDEA HTTP Client or Visual Studio Code REST Client.

## Technologies Used

- Spring MVC
- RESTful Services
- Spring Boot
- DTO Pattern
- JPA for database interactions
- IntelliJ IDEA or Visual Studio Code for testing
