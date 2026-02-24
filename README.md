# Java Advanced Training Workspace

![Java](https://img.shields.io/badge/Java-17+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-5.6-59666C?style=for-the-badge&logo=hibernate&logoColor=white)
![Spring](https://img.shields.io/badge/Spring-5.x-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-14+-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-8+-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3.6+-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![JUnit5](https://img.shields.io/badge/JUnit5-5.11-25A162?style=for-the-badge&logo=junit5&logoColor=white)
![Mockito](https://img.shields.io/badge/Mockito-5+-C5D9C8?style=for-the-badge)

A comprehensive collection of Maven projects covering advanced Java concepts — from raw **JDBC** and **JUnit 5** unit testing through **Hibernate ORM**, **JPA entity relationships**, **Hibernate caching**, **Mockito** mocking, and **Spring Core** dependency injection.

---

## Assignments

Chronological list of all graded assignments, each building on concepts from the learning modules:

| Date | Assignment Title | Entities / Focus | Key Tech |
|:-----|:------------|:-----------|:-------------|
| **10 Feb 2026** | Product Management | `Product` — full Hibernate CRUD + `ProductCrudTest` (JUnit 5) | ![Hibernate](https://img.shields.io/badge/Hibernate-ORM-59666C?style=for-the-badge&logo=hibernate&logoColor=white) ![JUnit5](https://img.shields.io/badge/JUnit_5-Testing-25A162?style=for-the-badge&logo=junit5&logoColor=white) |
| **11 Feb 2026** | Passport System | `Person` + `Passport` — `@OneToOne` mapping, `PersonCrudTest` + `PassportCrudTest` | ![Hibernate](https://img.shields.io/badge/Hibernate-ORM-59666C?style=for-the-badge&logo=hibernate&logoColor=white) ![JUnit5](https://img.shields.io/badge/JUnit_5-Testing-25A162?style=for-the-badge&logo=junit5&logoColor=white) |
| **12 Feb 2026** | Student DAO (JDBC) | `Student` + `StudentDao` — DAO pattern over raw JDBC, `StudentDaoTest` | ![JDBC](https://img.shields.io/badge/JDBC-Raw_SQL-007396?style=for-the-badge&logo=java&logoColor=white) ![JUnit5](https://img.shields.io/badge/JUnit_5-Testing-25A162?style=for-the-badge&logo=junit5&logoColor=white) |
| **13 Feb 2026** | Student Relationships | `Student` + `AadharCard` + `HostelRoom` — chained `@OneToOne` JPA associations | ![Hibernate](https://img.shields.io/badge/Hibernate-ORM-59666C?style=for-the-badge&logo=hibernate&logoColor=white) ![JPA](https://img.shields.io/badge/JPA-%40OneToOne-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white) |
| **13 Feb 2026** | Price Service Testing | `PriceService` + `DiscountRepository` — service-layer isolation with `PriceServiceTest` | ![Mockito](https://img.shields.io/badge/Mockito-Mocking-C5D9C8?style=for-the-badge&logoColor=black) ![JUnit5](https://img.shields.io/badge/JUnit_5-Testing-25A162?style=for-the-badge&logo=junit5&logoColor=white) |
| **14 Feb 2026** | E-Commerce System | `User`, `Profile`, `PurchaseOrder`, `Payment` — DAOs + `EcommerceServiceTest` | ![Hibernate](https://img.shields.io/badge/Hibernate-ORM-59666C?style=for-the-badge&logo=hibernate&logoColor=white) ![MySQL](https://img.shields.io/badge/MySQL-Database-4479A1?style=for-the-badge&logo=mysql&logoColor=white) |
| **14 Feb 2026** | Hospital Management | `Doctor`, `Patient`, `Appointment`, `MedicalRecord` — domain-driven JPA + `HospitalServiceTest` | ![Hibernate](https://img.shields.io/badge/Hibernate-ORM-59666C?style=for-the-badge&logo=hibernate&logoColor=white) ![MySQL](https://img.shields.io/badge/MySQL-Database-4479A1?style=for-the-badge&logo=mysql&logoColor=white) |
| **16 Feb 2026** | Social Media Posts | `Users`, `Post`, `Comments` — `@OneToMany` modelling a social feed | ![Hibernate](https://img.shields.io/badge/Hibernate-ORM-59666C?style=for-the-badge&logo=hibernate&logoColor=white) ![JPA](https://img.shields.io/badge/JPA-%40OneToMany-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white) |
| **21 Feb 2026** | CRM Sales Management | `Customer`, `Lead`, `SalesEmployee`, `Product`, `Order`, `SupportTicket` — full service-layer with `CustomerService`, `LeadService`, `OrderService`, `TicketService`, `ReportService` | ![Hibernate](https://img.shields.io/badge/Hibernate-ORM-59666C?style=for-the-badge&logo=hibernate&logoColor=white) ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-316192?style=for-the-badge&logo=postgresql&logoColor=white) |
| **21 Feb 2026** | Hospital Management ERP | `Patient`, `MedicalRecord`, `Department`, `Doctor`, `Appointment`, `Prescription` — **all 5 JPA mapping types** covered across `CRUDTest1` through `CRUDTest5` | ![Hibernate](https://img.shields.io/badge/Hibernate-ORM-59666C?style=for-the-badge&logo=hibernate&logoColor=white) ![JPA](https://img.shields.io/badge/JPA-All_5_Mappings-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white) ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-316192?style=for-the-badge&logo=postgresql&logoColor=white) |

---

## Learning Modules

Standalone modules, one concept per project:

---

### Module 1 — Raw JDBC `learnjdbc`

![JDBC](https://img.shields.io/badge/JDBC-007396?style=flat-square&logo=java&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=flat-square&logo=postgresql&logoColor=white)

Direct database connectivity using `DriverManager` and `PreparedStatement` — no ORM.

| File | Purpose |
|:-----|:--------|
| `StepsToConnectDatabase.java` | Basic `DriverManager` connection setup |
| `FetchEmployeeData.java` | `ResultSet` iteration over `Employee` records |
| `FetchStudentData.java` | `ResultSet` iteration over `Student` records |
| `EmployeeCRUD_operations.java` | Full Create / Read / Update / Delete via `PreparedStatement` |

---

### Module 2 — Unit Testing `basicsofjdbc`

![JUnit5](https://img.shields.io/badge/JUnit5-25A162?style=flat-square&logo=junit5&logoColor=white)
![Java](https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=openjdk&logoColor=white)

Core Java logic classes each backed by a JUnit 5 test suite.

| Source File | Test File | What Is Tested |
|:------------|:----------|:---------------|
| `Calculator.java` | `CalculatorTest.java` | Arithmetic operations |
| `Factorial.java` | `FactorialTest.java` | Recursive and iterative factorial |
| `Palindrome.java` | `PalindromeTest.java` | String palindrome check |
| `Employee.java` | `EmployeeNameTest.java` | Employee name formatting |
| `User.java` | — | User model utility |

---

### Module 3 — Hibernate Basics `basicsofhibernate`

![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=flat-square&logo=hibernate&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=flat-square&logo=postgresql&logoColor=white)

CRUD operations using `EntityManager` and JPA annotations, with JUnit 5 coverage.

| Package | Files | Focus |
|:--------|:------|:------|
| `com.product` | `Product`, `ProductCRUD`, `ProductMain` | Basic entity persist / find / merge / remove |
| `com.assessments` | `Person`, `PersonCRUD`, `Passport`, `PassportCRUD` | `@OneToOne` and entity lifecycle |
| `com.practice` | `Student`, `Demo1AddStudent` … `Demo4GetStudent` | Step-by-step CRUD demos |
| `com.programs` | `Programs` | Miscellaneous programs (`ProgramsTest`) |

---

### Module 4 — One-to-One (Unidirectional) `one_to_one_mapping`

![JPA](https://img.shields.io/badge/JPA-%40OneToOne-ED8B00?style=flat-square&logo=openjdk&logoColor=white)

| Entity | Relationship |
|:-------|:-------------|
| `Car` | owns FK to `Engine` via `@JoinColumn` — unidirectional |
| `User` | standalone entity used for persistence demos |

---

### Module 5 — One-to-One (Bidirectional) `one_to_one_bidirectional_mapping`

![JPA](https://img.shields.io/badge/JPA-%40OneToOne%20Bi-ED8B00?style=flat-square&logo=openjdk&logoColor=white)

| Entity | Side |
|:-------|:-----|
| `Person` | owner — holds `passport_id` FK |
| `Passport` | inverse — `mappedBy = "passport"` |

---

### Module 6 — One-to-Many `one_to_many_mapping`

![JPA](https://img.shields.io/badge/JPA-%40OneToMany-ED8B00?style=flat-square&logo=openjdk&logoColor=white)

| Entity | Relationship |
|:-------|:-------------|
| `College` | one college has many `Student` records |
| `Student` | many-side, holds `college_id` FK |
| `CollegeDao`, `StudentDao` | DAO layer for both entities |

---

### Module 7 — Many-to-One `many_to_one_mapping`

![JPA](https://img.shields.io/badge/JPA-%40ManyToOne-ED8B00?style=flat-square&logo=openjdk&logoColor=white)

| Entity | Relationship |
|:-------|:-------------|
| `Employee` | many employees belong to one `Department` — holds `department_id` FK |
| `Department` | one side, no back-reference |

---

### Module 8 — Many-to-Many (Unidirectional) `many_to_many_mapping`

![JPA](https://img.shields.io/badge/JPA-%40ManyToMany%20Uni-ED8B00?style=flat-square&logo=openjdk&logoColor=white)

| Entity | Detail |
|:-------|:-------|
| `Student` | owner — defines `@JoinTable` |
| `Subject` | referenced — no back-reference |
| `Dao` | persistence helper |

---

### Module 9 — Many-to-Many (Bidirectional) `many_to_many_bidirectional_mapping`

![JPA](https://img.shields.io/badge/JPA-%40ManyToMany%20Bi-ED8B00?style=flat-square&logo=openjdk&logoColor=white)

| Entity | Side |
|:-------|:-----|
| `Student` | owner — `@JoinTable` + helper methods |
| `Subject` | inverse — `mappedBy = "subjects"` |

---

### Module 10 — Hibernate Caching `caching`

![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=flat-square&logo=hibernate&logoColor=white)
![Ehcache](https://img.shields.io/badge/Ehcache-L2Cache-lightgrey?style=flat-square)

| Sub-package | Entity | Cache Level |
|:------------|:-------|:------------|
| `first_level_caching` | `Product` | L1 — session-scoped, automatic, default in Hibernate |
| `second_level_caching` | `Item` | L2 — `SessionFactory`-scoped, shared across sessions using **Ehcache** |

---

### Module 11 — Mockito Testing `mockito_practice`

![Mockito](https://img.shields.io/badge/Mockito-C5D9C8?style=flat-square)
![JUnit5](https://img.shields.io/badge/JUnit5-25A162?style=flat-square&logo=junit5&logoColor=white)

Full service-layer unit testing with Mockito mocks.

| File | Role |
|:-----|:-----|
| `UserService.java` | Service under test — depends on `UsersDao` |
| `UsersDao.java` | DAO interface — mocked in tests |
| `Users.java` | Model class |
| `CalculatorService.java` | Service wrapping `Calculator` — also mocked |
| `Calculator.java` | Arithmetic dependency |
| `UserServiceTest.java` | Tests using `when().thenReturn()`, `verify()`, argument matchers |

---

### Module 12 — Mockito Fundamentals `mockitotest`

![Mockito](https://img.shields.io/badge/Mockito-C5D9C8?style=flat-square)
![JUnit5](https://img.shields.io/badge/JUnit5-25A162?style=flat-square&logo=junit5&logoColor=white)

Foundational Mockito syntax practice isolated in its own project.

| File | Role |
|:-----|:-----|
| `UsersService.java` | Service under test |
| `UsersDao.java` | DAO — mocked |
| `Users.java` | Model class |
| `userServiceTest.java` | Basic Mockito annotation and stubbing practice |

---

### Module 13 — Spring Core Basics `basicsofspring`

![Spring](https://img.shields.io/badge/Spring-6DB33F?style=flat-square&logo=spring&logoColor=white)

XML-based Spring IoC container using `ClassPathXmlApplicationContext`.

| File | Purpose |
|:-----|:--------|
| `Person.java` | Spring bean configured in `config.xml` |
| `Employee.java` | Spring bean — retrieved and printed via IoC |
| `Main.java` | Bootstraps `ApplicationContext` from `config.xml`, retrieves beans |

---

### Module 14 — Spring Class-Level Configuration `class_level_config_spring`

![Spring](https://img.shields.io/badge/Spring-6DB33F?style=flat-square&logo=spring&logoColor=white)

Annotation-based Spring IoC using `@Configuration` + `AnnotationConfigApplicationContext`.

| File | Purpose |
|:-----|:--------|
| `DemoConfiguration.java` | `@Configuration` class — defines all beans with `@Bean` methods |
| `Employee.java` | Bean wired through configuration class |
| `Person.java` | Bean with a `Mobile` dependency injected |
| `Mobile.java` | Nested dependency bean |
| `Main.java` | Bootstraps `AnnotationConfigApplicationContext`, retrieves and prints beans |

---

## Technologies Used

| Technology | Purpose | Badge |
|:-----------|:--------|:------|
| **Java 17+** | Core language | ![Java](https://img.shields.io/badge/Java-17+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white) |
| **Hibernate ORM 5.6** | JPA implementation, entity mapping, session management | ![Hibernate](https://img.shields.io/badge/Hibernate-5.6-59666C?style=for-the-badge&logo=hibernate&logoColor=white) |
| **JPA 2.1** | Standard annotations: `@Entity`, `@OneToOne`, `@OneToMany`, `@ManyToMany` | ![JPA](https://img.shields.io/badge/JPA-2.1-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white) |
| **Spring Core 5.x** | IoC container, XML config (`ClassPathXmlApplicationContext`), annotation config (`@Configuration`) | ![Spring](https://img.shields.io/badge/Spring-5.x-6DB33F?style=for-the-badge&logo=spring&logoColor=white) |
| **PostgreSQL 14+** | Primary database for Hibernate and JDBC modules | ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-14+-316192?style=for-the-badge&logo=postgresql&logoColor=white) |
| **MySQL 8+** | Database for Case Study and Social Media assignments | ![MySQL](https://img.shields.io/badge/MySQL-8+-4479A1?style=for-the-badge&logo=mysql&logoColor=white) |
| **Apache Maven 3.6+** | Build tool, dependency management | ![Maven](https://img.shields.io/badge/Maven-3.6+-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white) |
| **JUnit 5** | Unit testing framework | ![JUnit5](https://img.shields.io/badge/JUnit5-5.11-25A162?style=for-the-badge&logo=junit5&logoColor=white) |
| **Mockito 5+** | Mock objects for service-layer testing | ![Mockito](https://img.shields.io/badge/Mockito-5+-C5D9C8?style=for-the-badge) |
| **Ehcache** | Second-level Hibernate cache provider | ![Ehcache](https://img.shields.io/badge/Ehcache-2.10-lightgrey?style=for-the-badge) |
| **Eclipse IDE** | Primary development environment | ![Eclipse](https://img.shields.io/badge/Eclipse-2024+-2C2255?style=for-the-badge&logo=eclipseide&logoColor=white) |

---

## How to Run Any Project

### Prerequisites

- ![Java](https://img.shields.io/badge/JDK-17+-ED8B00?style=flat-square&logo=openjdk&logoColor=white) JDK 17+
- ![Maven](https://img.shields.io/badge/Maven-3.6+-C71A36?style=flat-square&logo=apachemaven&logoColor=white) Apache Maven 3.6+
- ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=flat-square&logo=postgresql&logoColor=white) PostgreSQL (for JDBC and Hibernate projects)
- ![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=mysql&logoColor=white) MySQL (for 14-Feb and 16-Feb assignments)

### Steps

```bash
# 1. Navigate to any project
cd 21-Feb-Assignment-hospitalManagementSystemERP

# 2. Update DB credentials in persistence.xml (Hibernate) or source file (JDBC) first

# 3. Compile
mvn clean compile

# 4. Run a specific main class
mvn exec:java -Dexec.mainClass="main.CRUDTest1"

# 5. Run unit tests (where applicable)
mvn test
```

---

## Full Workspace Structure

```
java-advanced-workspace/
|
|-- 10-Feb-2026-Assignment/                    Assignment — Product CRUD (Hibernate + JUnit 5)
|-- 11-Feb-2026-Assignment/                    Assignment — Person/Passport @OneToOne (Hibernate + JUnit 5)
|-- 12-Feb-2026-Assignment/                    Assignment — Student DAO (JDBC + JUnit 5)
|-- 13-Feb-Assignment-OneToOne/                Assignment — Student/AadharCard/HostelRoom @OneToOne
|-- 13-Feb-2026-Assignment-Mockito/            Assignment — PriceService (Mockito + JUnit 5)
|-- 14-Feb-Assignment-CaseStudy1/              Assignment — E-Commerce System (Hibernate + MySQL)
|-- 14-Feb-Assignment-CaseStudy2/              Assignment — Hospital Management (Hibernate + MySQL)
|-- 16-Feb-Assignment/                         Assignment — Social Media Posts (Hibernate + MySQL)
|-- 21-Feb-Assignment-crm_sales_management_system/    Assignment — CRM Sales ERP (Hibernate + PostgreSQL)
|-- 21-Feb-Assignment-hospitalManagementSystemERP/    Assignment — Hospital ERP, all 5 JPA mappings (Hibernate + PostgreSQL)
|
|-- learnjdbc/                                 Module 1  — Raw JDBC: connect, fetch, CRUD
|-- basicsofjdbc/                              Module 2  — Logic + JUnit 5: Calculator, Factorial, Palindrome
|-- basicsofhibernate/                         Module 3  — Hibernate CRUD + JPA lifecycle + JUnit 5
|-- one_to_one_mapping/                        Module 4  — @OneToOne unidirectional: Car/Engine
|-- one_to_one_bidirectional_mapping/          Module 5  — @OneToOne bidirectional: Person/Passport
|-- one_to_many_mapping/                       Module 6  — @OneToMany: College/Student + DAOs
|-- many_to_one_mapping/                       Module 7  — @ManyToOne: Employee/Department
|-- many_to_many_mapping/                      Module 8  — @ManyToMany unidirectional: Student/Subject
|-- many_to_many_bidirectional_mapping/        Module 9  — @ManyToMany bidirectional: Student/Subject
|-- caching/                                   Module 10 — Hibernate L1 and L2 Caching (Ehcache)
|-- mockito_practice/                          Module 11 — Mockito: UserService, CalculatorService testing
|-- mockitotest/                               Module 12 — Mockito: foundational syntax practice
|-- basicsofspring/                            Module 13 — Spring Core: XML IoC container
|-- class_level_config_spring/                 Module 14 — Spring Core: @Configuration annotation-based IoC
|
`-- README.md
```

---

*Java Advanced Training — Capgemini | Updated February 2026*
