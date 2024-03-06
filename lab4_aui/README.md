# Lab 4: Introduction to Microservices

## Overview

In this fourth laboratory work of the "Internet Services Architectures" course, students are introduced to the basic concepts of decomposing a monolithic application into stand-alone modules based on a microservices architecture. The project continues from the previous labs, transitioning into a microservices-based structure.

## Objectives

1. **Splitting into Microservices:** Divide the original Spring Boot project into two separate projects, each representing a stand-alone application: one for category management and another for elements management. Both applications should use their own private in-memory H2 databases. The category management application handles only category-related operations, while the elements management application deals with elements and maintains a simplified category management system.
2. **Inter-Application Communication:** Implement event-based communication between the two applications. When a category is added or removed, the elements management application should be notified to correspondingly update its records.
3. **Spring Cloud Gateway Integration:** Develop a new Spring Boot application with Spring Cloud Gateway, containing routing rules for both the category and elements management applications. Ensure that this gateway properly routes requests to the respective microservice.

## Technologies Used

- Microservices Architecture
- Spring Boot
- Spring Cloud Gateway
- RESTful Services for inter-service communication
- H2 Database 
