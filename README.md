# Spring Boot REST CRUD
<p align="justify">
This project is built with Spring Boot and demonstrates the creation of a simple REST API performing CRUD (Create, Read, Update, Delete) operations. It focuses on building RESTful endpoints using @RestController, connecting to a MySQL database with Spring Data JPA, and managing entities through standard HTTP methods.
</p>

Initially, I explored and tested the system using the DAO pattern to understand the core concepts, before transitioning to JPA Repositories for simpler, cleaner, and more efficient code.

Eventually, I further optimized the project by adopting Spring Data REST, which automatically exposes repository-based REST endpoints, reducing the need to manually define controllers and service layers. As part of this transition, I removed the custom services and rest controller packages

## Features

- REST API with CRUD functionality
- REST API design practices
- Deepens learning of java spring boot core
- API testing using **Postman**

## Dependencies

The project uses the following main dependencies:

- **Spring Boot Starter Web** – for building REST APIs.
- **Spring Boot Starter Data JPA** – for database operations.
- **Spring Boot DevTools** – for automatic restarts during development.
- **MySQL Driver** – for MySQL database connectivity.

## MYSQL WORKBENCH

**SCRIPT**
```sql
CREATE DATABASE  IF NOT EXISTS `employee_directory`;
USE `employee_directory`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

INSERT INTO `employee` VALUES 
	(1,'Leslie','Andrews','leslie@luv2code.com'),
	(2,'Emma','Baumgarten','emma@luv2code.com'),
	(3,'Avani','Gupta','avani@luv2code.com'),
	(4,'Yuri','Petrov','yuri@luv2code.com'),
	(5,'Juan','Vega','juan@luv2code.com');




