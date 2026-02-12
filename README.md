# Java Advanced Training Workspace

This workspace contains a collection of Maven projects designed for learning and practicing advanced Java concepts, specifically focusing on database connectivity and Object-Relational Mapping (ORM).

## Project Overview

The workspace is divided into three main modules, each targeting a specific area of Java database programming:

1.  **basicsofjdbc**: Covers the fundamental concepts of Java Database Connectivity (JDBC).
2.  **learnjdbc**: A practical module for implementing JDBC with a PostgreSQL database.
3.  **basicsofhibernate**: A module dedicated to learning Hibernate ORM, including configuration and entity mapping with PostgreSQL.

## Project Structure

```text
/Users/jami/java-advanced-workspace
├── basicsofhibernate/  - Hibernate basics with PostgreSQL and JUnit 5
├── basicsofjdbc/       - Core JDBC concepts and testing
└── learnjdbc/          - Practical JDBC implementation with PostgreSQL
```

## Technologies Used

*   **Java**: Core language for all projects.
*   **Maven**: Build automation and dependency management.
*   **JDBC**: Java API for database connectivity.
*   **Hibernate**: ORM framework for mapping Java classes to database tables.
*   **PostgreSQL**: Relational database management system.
*   **JUnit 5**: Testing framework used across all modules.

## Getting Started

To get started with these projects, ensure you have the following installed:
*   Java Development Kit (JDK)
*   Apache Maven
*   PostgreSQL Database

### Build Instructions

You can build each project individually using Maven. Navigate to the project directory and run:

```bash
mvn clean install
```
