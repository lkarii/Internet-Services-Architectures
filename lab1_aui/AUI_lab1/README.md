# Lab 1: Java SE and Stream API Exploration

## Overview

This is the first laboratory work of the "Internet Services Architectures" course, focusing on Java SE and Stream API. The primary goal is to develop a basic application with a specific domain model involving entities with a 1:N relationship. Key tasks include implementing entity classes with robust comparison mechanisms, creating DTO classes, and exploring Java's Stream API for various operations.

## Objectives

1. **Entity Implementation:** Develop entity classes with appropriate comparison mechanisms (hash and natural ordering) and text representation. Implement DTO class for the element class with a builder pattern.
2. **Initial Data Creation:** At application startup, create a collection of categories filled with elements and print them using nested for each lambda in the original order.
3. **Stream API Utilization:** Utilize Stream API to create a Set collection of elements from all categories and print it.
4. **Filtering and Sorting:** Filter and sort the elements collection using Stream API, based on selected properties.
5. **DTO Transformation and Sorting:** Transform elements into DTO objects, sort using natural order, and collect into a List using Stream API. Print the resulting list.
6. **Serialization:** Store the collection of categories in a binary file, then read and print them.
7. **Parallel Streams with Custom Thread Pool:** Execute a task on each category using Stream API parallel pipelines and a custom thread pool, observing the results with different pool sizes.

## Technologies Used

- Java SE
- Apache Maven
- Stream API
- Project Lombok 
