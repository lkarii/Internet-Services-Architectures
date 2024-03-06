# Lab 2: Spring Framework and Spring Data Introduction

## Overview

In this second laboratory of the "Internet Services Architectures" course, the focus is on understanding the basic components of the Spring Framework and Spring Data. The lab involves enhancing a Maven Spring Boot project (initially generated via Spring Initializer) with components like repositories, services, and implementing the concept of dependency injection and inversion of control. The lab builds upon the entity classes developed in the previous lab.

## Objectives

1. **Enhancing Business Classes with JPA:** Apply JPA annotations to all business classes. Use plural form for table names and snake_case for tables and columns. Implement bidirectional relationships and UUID as primary keys.
2. **JPA Repositories Implementation:** Create JPA repositories for each business class as Spring `@Repository`. Include querying capabilities in the repository for elements by category.
3. **Service Layer Implementation:** Develop services for each business class as Spring `@Service`, utilizing repository instances provided by the Spring container.
4. **Data Initializer Component:** Implement a data initializer as a Spring `@Component` that runs automatically after startup, using service instances from the Spring container.
5. **Command Line Runner Implementation:** Create a command-line runner as a Spring `@Component`. It should interact with the user through standard input/output, offering functionalities like listing commands, categories, elements, adding or deleting elements, and stopping the application.

## Technologies Used

- Spring Framework
- Spring Data
- Maven
- Spring Boot
- JPA
- H2 Database (in-memory)
