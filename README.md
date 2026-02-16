# ☕ Java Advanced Training Workspace

Welcome to the **Java Advanced Training Workspace**! This repository serves as a comprehensive collection of projects demonstrating advanced Java concepts, specifically focusing on **Database Connectivity**, **Unit Testing**, and **Object-Relational Mapping (ORM)**.

---

## Highlighted Assignments

Here are the key assignments showcasing practical implementation of learned concepts:

| Date | Project | Description | Tech Stack |
| :--- | :--- | :--- | :--- |
| **10 Feb 2026** |  **Product Management** | Full **CRUD** implementation for `Product` entities. Understands entity lifecycle and transaction management. | ![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=flat-square&logo=hibernate&logoColor=white) ![JPA](https://img.shields.io/badge/JPA-ED8B00?style=flat-square&logo=openjdk&logoColor=white) |
| **11 Feb 2026** |  **Passport System** | Implements a **One-to-One Mapping** between `Person` and `Passport`.  Demonstrates relationship handling in ORM. | ![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=flat-square&logo=hibernate&logoColor=white) ![Relationships](https://img.shields.io/badge/Relation-111111?style=flat-square&logo=git&logoColor=white) |
| **12 Feb 2026** |  **Student DAO** | A **Data Access Object (DAO)** pattern implementation for managing `Student` records. Focuses on clean architecture. | ![JDBC](https://img.shields.io/badge/JDBC-007396?style=flat-square&logo=java&logoColor=white) ![DAO](https://img.shields.io/badge/Pattern-DAO-blue?style=flat-square) |
| **13 Feb 2026** |  **Student Relationships** | **One-to-One** mapping between `Student`, `AadharCard`, and `HostelRoom`. Focuses on JPA associations. | ![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=flat-square&logo=hibernate&logoColor=white) ![JPA](https://img.shields.io/badge/JPA-ED8B00?style=flat-square&logo=openjdk&logoColor=white) |
| **13 Feb 2026** |  **Service Testing** | Unit testing service layers using **Mockito** to mock dependencies. Focuses on behavior verification. | ![Mockito](https://img.shields.io/badge/Testing-Mockito-yellow?style=flat-square) ![JUnit5](https://img.shields.io/badge/JUnit5-25A162?style=flat-square&logo=junit5&logoColor=white) |
| **14 Feb 2026** |  **E-Commerce System** | Manages `User`, `Profile`, `Orders`, and `Payment`. Demonstrates complex entity relationships. | ![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=flat-square&logo=hibernate&logoColor=white) ![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=mysql&logoColor=white) |
| **14 Feb 2026** |  **Hospital Management** | Healthcare system modeling `Doctors`, `Patients`, and `Appointments`. Focuses on domain-driven design. | ![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=flat-square&logo=hibernate&logoColor=white) ![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=mysql&logoColor=white) |

---

## Core Modules

The workspace is structured into five main learning tracks:

### 1.  Logic & Testing (`basicsofjdbc`)
**Focus:** Pure Java Logic & JUnit 5 Testing

Foundational module for writing robust Java code and validating it.
- **Key Concepts**: Algorithms, String Manipulation, Mathematical Logic.
- **Testing**: Comprehensive Unit Tests with **JUnit 5**.
- **Tech**: ![Java](https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=openjdk&logoColor=white) ![JUnit5](https://img.shields.io/badge/JUnit5-25A162?style=flat-square&logo=junit5&logoColor=white)

### 2. Pure JDBC (`learnjdbc`)
**Focus:** Direct Database Connectivity

Bridges the gap between Java applications and the Database using raw SQL.
- **Key Concepts**: Connection Lifecycle, `Statement` vs `PreparedStatement`, `ResultSet` handling.
- **Features**: Full CRUD operations on `Employee` and `Student` data.
- **Tech**: ![Java](https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=openjdk&logoColor=white) ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=flat-square&logo=postgresql&logoColor=white) ![JDBC](https://img.shields.io/badge/JDBC-007396?style=flat-square&logo=java&logoColor=white)

### 3.  ORM & Hibernate (`basicsofhibernate`)
**Focus:** Enterprise Data Persistence

Advanced module moving away from raw SQL to Object-Relational Mapping (ORM).
- **Key Concepts**: Entity Mapping, JPA Annotations, HQL/JPQL, Lifecycle.
- **Features**: CRUD operations using `EntityManager`, Transaction Management.
- **Tech**: ![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=flat-square&logo=hibernate&logoColor=white) ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=flat-square&logo=postgresql&logoColor=white)

### 4. Advanced Entity Mapping (`*_mapping`)
**Focus:** Complex Database Relationships

Deep dive into modeling real-world relationships between entities.
- **Key Concepts**: Cardinality strategies (`OneToOne`, `OneToMany`, `ManyToOne`), Cascading, Fetch Types (Lazy vs Eager).
- **Projects**: Dedicated modules for each mapping type to isolate complexity.
- **Tech**: ![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=flat-square&logo=hibernate&logoColor=white) ![JPA](https://img.shields.io/badge/JPA-ED8B00?style=flat-square&logo=openjdk&logoColor=white)

### 5. Mocking & Isolation (`mockito_practice`)
**Focus:** Isolated Unit Testing

Techniques for testing service layers in isolation by simulating external dependencies.
- **Key Concepts**: Test Doubles, Mocking behaviors (`when(...).thenReturn(...)`), Verification (`verify()`), Argument Matchers.
- **Tech**: ![Mockito](https://img.shields.io/badge/Mockito-Testing-yellow?style=flat-square) ![JUnit5](https://img.shields.io/badge/JUnit5-25A162?style=flat-square&logo=junit5&logoColor=white)

---

## Technologies Used

| Technology | Badge |
| :--- | :--- |
| **Java 17+** | ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white) |
| **PostgreSQL** | ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white) |
| **Hibernate** | ![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white) |
| **Maven** | ![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white) |
| **JUnit 5** | ![JUnit5](https://img.shields.io/badge/JUnit5-25A162?style=for-the-badge&logo=junit5&logoColor=white) |
| **Mockito** | ![Mockito](https://img.shields.io/badge/Mockito-yellow?style=for-the-badge&logo=mockito&logoColor=black) |
| **Eclipse IDE** | ![Eclipse](https://img.shields.io/badge/Eclipse-2C2255?style=for-the-badge&logo=eclipseide&logoColor=white) |

---

## Getting Started

### Prerequisites

Ensure you have the following installed on your system:

-  **Java Development Kit (JDK) 17+**
-  **Apache Maven 3.6+**
-  **PostgreSQL Database**

### Installation & Execution

1.  **Clone the Repository**
    ```bash
    git clone https://github.com/mohansaivenkat/java-advanced-training.git
    cd java-advanced-workspace
    ```

2.  **Build a Project**
    Navigate to any project directory (e.g., an assignment) and build:
    ```bash
    cd 10-Feb-2026-Assignment
    mvn clean install
    ```

3.  **Run Locally**
    - Ensure your **PostgreSQL** database is running.
    - Update `hibernate.cfg.xml` or JDBC connection strings in `src/main/resources` or logic files.
    - Run the `main` method in the respective `Main` or `CRUD` class.

---
*Happy Coding!* 
