# Java Advanced Training Workspace

Welcome to the **Java Advanced Training Workspace**! This repository serves as a comprehensive collection of projects demonstrating advanced Java concepts, specifically focusing on **Database Connectivity**, **Unit Testing**, and **Object-Relational Mapping (ORM)**.

---

## Overview

This workspace is designed to guide developers through the essential layers of enterprise Java application development. Starting from core logic and unit testing, moving into direct database interaction with JDBC, and finally abstracting data persistence with Hibernate ORM.

---

## Project Structure

The workspace is organized into three main Maven modules:

```text
java-advanced-workspace
 ├── basicsofjdbc       # Java Logic, Algorithms & JUnit Testing
 ├── learnjdbc          # Pure JDBC Connectivity with PostgreSQL
 └── basicsofhibernate  # Hibernate ORM, Entity Mapping & CRUD
```

---

## Technologies Used

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![JUnit5](https://img.shields.io/badge/JUnit5-25A162?style=for-the-badge&logo=junit5&logoColor=white)
![Eclipse](https://img.shields.io/badge/Eclipse-2C2255?style=for-the-badge&logo=eclipseide&logoColor=white)

---

## Detailed Project Breakdown

### Java Basics & Testing (`basicsofjdbc`)

**Focus:** Java Core Logic & Unit Testing

Despite the name, this module currently serves as the foundation for writing robust Java logic and validating it with JUnit 5. It includes algorithmic challenges and domain logic examples.

- **Key Components:**
  - `Calculator.java`: Mathematical operations utility.
  - `Factorial.java`: Logic for calculating factorials.
  - `Palindrome.java`: String manipulation and verification.
  - `User.java`: Entry point for testing various logic.
- **Testing:**
  - Comprehensive unit tests using **JUnit 5**.
  - Demonstrates assertions and test lifecycle management.

### JDBC Implementation (`learnjdbc`)

**Focus:** Direct Database Connectivity (JDBC)

This module bridges the gap between Java applications and the Database. It uses raw JDBC to execute SQL queries, handle connections, and manage result sets.

- **Key Components:**
  - `StepsToConnectDatabase.java`: Guide and implementation of the database connection lifecycle.
  - `FetchStudentData.java`: Retrieving records from the database.
  - `EmployeeCRUD_operations.java`: Full Create, Read, Update, Delete operations on Employee data.
- **Tech Stack:**
  - **PostgreSQL Driver** (`42.6.0`): For connecting to the Postgres database.
  - **JUnit 5**: For testing logic where applicable.

### Hibernate ORM (`basicsofhibernate`)

**Focus:** Enterprise ORM with Hibernate

The most advanced module in this workspace, moving away from raw SQL to Object-Relational Mapping. It manages data as Java objects (Entities).

- **Key Components:**
  - **CRUD Operations**:
    - `Demo1AddStudent.java` to `Demo4GetStudent.java`: Step-by-step CRUD examples.
    - `ProductCRUD.java` & `PersonCRUD.java`: Domain-specific data management.
  - **Entity Mapping**:
    - `Student.java`, `Product.java`, `Passport.java`, `Person.java`: Java classes mapped to database tables using JPA annotations.
  - **Relationships**:
    - Demonstrates One-to-One and other mapping strategies (e.g., `Person` ↔ `Passport`).
- **Tech Stack:**
  - **Hibernate Core** (`5.6.15.Final`): The ORM engine.
  - **PostgreSQL Driver**: Underlying database connectivity.

---

## Getting Started

### Prerequisites

Ensure you have the following installed on your system:

- **Java Development Kit (JDK) 17+**
- **Apache Maven 3.6+**
- **PostgreSQL Database**

### Installation & Execution

1.  **Clone the Repository**
    ```bash
    git clone https://github.com/mohansaivenkat/java-advanced-training.git
    cd java-advanced-workspace
    ```

2.  **Build a Module**
    Navigate to any project directory and build using Maven:
    ```bash
    cd basicsofhibernate
    mvn clean install
    ```

3.  **Run Locally**
    - Ensure your PostgreSQL database is running.
    - Update `hibernate.cfg.xml` or JDBC connection strings in the source code with your local DB credentials.
    - Run the `main` method in any of the logic or demo files (where applicable).

---
*Happy Coding!*
