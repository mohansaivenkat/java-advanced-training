# ☕ Java Advanced Training Workspace

Welcome to the **Java Advanced Training Workspace** — a comprehensive collection of Maven projects covering advanced Java concepts from raw **JDBC** and **JUnit 5** testing all the way through **Hibernate ORM**, **entity relationships**, **Hibernate caching**, and **Mockito** mocking.

---

## Highlighted Assignments

Key assignments showcasing practical implementation of learned concepts, in chronological order:

| Date | Folder | Project | Key Entities / Focus | Tech Stack |
| :--- | :--- | :--- | :--- | :--- |
| **10 Feb 2026** | `10-Feb-2026-Assignment` | **Product Management** | `Product` — Full CRUD with **JUnit 5** tests (`ProductCrudTest`) | ![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=flat-square&logo=hibernate&logoColor=white) ![JUnit5](https://img.shields.io/badge/JUnit5-25A162?style=flat-square&logo=junit5&logoColor=white) |
| **11 Feb 2026** | `11-Feb-2026-Assignment` | **Passport System** | `Person` ↔ `Passport` — **One-to-One** mapping, CRUD + tests (`PersonCrudTest`, `PassportCrudTest`) | ![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=flat-square&logo=hibernate&logoColor=white) ![JPA](https://img.shields.io/badge/JPA-ED8B00?style=flat-square&logo=openjdk&logoColor=white) |
| **12 Feb 2026** | `12-Feb-2026-Assignment` | **Student DAO (JDBC)** | `Student` — **DAO pattern** over raw JDBC with `StudentDaoTest` | ![JDBC](https://img.shields.io/badge/JDBC-007396?style=flat-square&logo=java&logoColor=white) ![JUnit5](https://img.shields.io/badge/JUnit5-25A162?style=flat-square&logo=junit5&logoColor=white) |
| **13 Feb 2026** | `13-Feb-Assignment-OneToOne` | **Student Relationships** | `Student` ↔ `AadharCard` ↔ `HostelRoom` — **One-to-One** JPA associations | ![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=flat-square&logo=hibernate&logoColor=white) ![JPA](https://img.shields.io/badge/JPA-ED8B00?style=flat-square&logo=openjdk&logoColor=white) |
| **13 Feb 2026** | `13-Feb-2026-Assignment-Mockito` | **Price Service Testing** | `PriceService` + `DiscountRepository` — service-layer isolation with **Mockito** (`PriceServiceTest`) | ![Mockito](https://img.shields.io/badge/Mockito-yellow?style=flat-square) ![JUnit5](https://img.shields.io/badge/JUnit5-25A162?style=flat-square&logo=junit5&logoColor=white) |
| **14 Feb 2026** | `14-Feb-Assignment-CaseStudy1` | **E-Commerce System** | `User`, `Profile`, `PurchaseOrder`, `Payment` — complex JPA relationships + `EcommerceServiceTest` | ![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=flat-square&logo=hibernate&logoColor=white) ![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=mysql&logoColor=white) |
| **14 Feb 2026** | `14-Feb-Assignment-CaseStudy2` | **Hospital Management** | `Doctor`, `Patient`, `Appointment`, `MedicalRecord` — domain-driven JPA design + `HospitalServiceTest` | ![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=flat-square&logo=hibernate&logoColor=white) ![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=mysql&logoColor=white) |
| **16 Feb 2026** | `16-Feb-Assignment` | **Social Media Posts** | `Users`, `Post`, `Comments` — **One-to-Many** relationships modelling a social feed | ![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=flat-square&logo=hibernate&logoColor=white) ![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=mysql&logoColor=white) |
| **21 Feb 2026** | `21-Feb-Assignment-crm_sales_management_system` | **CRM Sales Management** | `Customer`, `Lead`, `SalesEmployee`, `Product`, `Order`, `SupportTicket` — full **Service-layer** CRM with `EmployeeService`, `LeadService`, `OrderService`, `TicketService`, `ReportService` | ![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=flat-square&logo=hibernate&logoColor=white) ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=flat-square&logo=postgresql&logoColor=white) |

---

## Core Learning Modules

The workspace is also structured into standalone learning modules, each isolating a single concept:

### 1. Pure JDBC (`learnjdbc`)
**Focus:** Direct Database Connectivity without any ORM layer.

| File | Purpose |
| :--- | :--- |
| `StepsToConnectDatabase.java` | Basic `DriverManager` connection setup |
| `FetchEmployeeData.java` | `ResultSet` reading for `Employee` records |
| `FetchStudentData.java` | `ResultSet` reading for `Student` records |
| `EmployeeCRUD_operations.java` | Full **Create / Read / Update / Delete** via `PreparedStatement` |

- **Tech:** ![Java](https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=openjdk&logoColor=white) ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=flat-square&logo=postgresql&logoColor=white) ![JDBC](https://img.shields.io/badge/JDBC-007396?style=flat-square&logo=java&logoColor=white)

---

### 2. Logic & Unit Testing (`basicsofjdbc`)
**Focus:** Core Java algorithms backed by JUnit 5 test suites.

| File | Purpose |
| :--- | :--- |
| `Calculator.java` | Arithmetic operations — tested by `CalculatorTest` |
| `Factorial.java` | Recursive & iterative factorial — tested by `FactorialTest` |
| `Palindrome.java` | String palindrome check — tested by `PalindromeTest` |
| `Employee.java` | Employee name formatting — tested by `EmployeeNameTest` |
| `User.java` | User model utility |

- **Tech:** ![Java](https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=openjdk&logoColor=white) ![JUnit5](https://img.shields.io/badge/JUnit5-25A162?style=flat-square&logo=junit5&logoColor=white)

---

### 3. ORM & Hibernate (`basicsofhibernate`)
**Focus:** Entity persistence using JPA annotations and `EntityManager`.

- CRUD operations on `Product`, `Person`, and `Passport` entities via `EntityManager`.
- Test coverage via `ProductCrudTest`, `PersonCrudTest`, `PassportCrudTest`, and `ProgramsTest`.
- **Tech:** ![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=flat-square&logo=hibernate&logoColor=white) ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=flat-square&logo=postgresql&logoColor=white)

---

### 4.  Entity Relationship Mapping

Deep-dive modules, one per relationship type:

| Module | Entities | Relationship |
| :--- | :--- | :--- |
| `one_to_one_mapping` | `Car` ↔ `Engine`, `User` | **@OneToOne** — unidirectional |
| `one_to_one_bidirectional_mapping` | `Person` ↔ `Passport` | **@OneToOne** — bidirectional |
| `one_to_many_mapping` | `College` → `Student` (+ DAOs) | **@OneToMany / @ManyToOne** |
| `many_to_one_mapping` | `Employee` → `Department` | **@ManyToOne** |
| `many_to_many_mapping` | `Student` ↔ `Subject` (with `Dao`) | **@ManyToMany** — unidirectional, join table |
| `many_to_many_bidirectional_mapping` | `Student` ↔ `Subject` | **@ManyToMany** — bidirectional |

- **Tech:** ![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=flat-square&logo=hibernate&logoColor=white) ![JPA](https://img.shields.io/badge/JPA-ED8B00?style=flat-square&logo=openjdk&logoColor=white) ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=flat-square&logo=postgresql&logoColor=white)

---

### 5. Hibernate Caching (`caching`)
**Focus:** Performance optimisation using Hibernate's caching layers.

| Sub-package | Entities | Focus |
| :--- | :--- | :--- |
| `first_level_caching` | `Product` | Default L1 (Session) cache — automatic, per `EntityManager` |
| `second_level_caching` | `Item` | L2 (SessionFactory) cache using **Ehcache** — shared across sessions |

- **Tech:** ![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=flat-square&logo=hibernate&logoColor=white) ![Ehcache](https://img.shields.io/badge/Ehcache-L2Cache-lightgrey?style=flat-square) ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=flat-square&logo=postgresql&logoColor=white)

---

### 6.  Mockito Testing

Two projects exploring service-layer unit testing with Mockito:

| Module | Classes | Focus |
| :--- | :--- | :--- |
| `mockito_practice` | `UserService`, `UsersDao`, `CalculatorService`, `Calculator` → `UserServiceTest` | **Mocking DAO** layer; `when().thenReturn()`, `verify()`, argument matchers |
| `mockitotest` | `UsersService`, `UsersDao`, `Users` → `userServiceTest` | Foundational Mockito syntax practice |

- **Tech:** ![Mockito](https://img.shields.io/badge/Mockito-yellow?style=flat-square) ![JUnit5](https://img.shields.io/badge/JUnit5-25A162?style=flat-square&logo=junit5&logoColor=white)

---

##  Technologies Used

| Technology | Version | Badge |
| :--- | :--- | :--- |
| **Java** | 17+ | ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white) |
| **PostgreSQL** | 14 / 15+ | ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white) |
| **MySQL** | 8+ | ![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white) |
| **Hibernate ORM** | 5.6 / 6.4 | ![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white) |
| **Apache Maven** | 3.6+ | ![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white) |
| **JUnit 5** | 5.10 / 5.11 | ![JUnit5](https://img.shields.io/badge/JUnit5-25A162?style=for-the-badge&logo=junit5&logoColor=white) |
| **Mockito** | 5+ | ![Mockito](https://img.shields.io/badge/Mockito-yellow?style=for-the-badge) |
| **Ehcache** | 2.10 | ![Ehcache](https://img.shields.io/badge/Ehcache-L2Cache-lightgrey?style=for-the-badge) |
| **Eclipse IDE** | 2024+ | ![Eclipse](https://img.shields.io/badge/Eclipse-2C2255?style=for-the-badge&logo=eclipseide&logoColor=white) |

---

##  Getting Started

### Prerequisites

Ensure the following are installed:

- ![Java](https://img.shields.io/badge/JDK-17+-ED8B00?style=flat-square&logo=openjdk&logoColor=white) **Java Development Kit (JDK) 17+**
- ![Maven](https://img.shields.io/badge/Maven-3.6+-C71A36?style=flat-square&logo=apachemaven&logoColor=white) **Apache Maven 3.6+**
- ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=flat-square&logo=postgresql&logoColor=white) **PostgreSQL** (for Hibernate/JDBC projects)
- ![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=mysql&logoColor=white) **MySQL** (for 14-Feb & 16-Feb assignments)

### Build & Run

1. **Clone the Repository**
    ```bash
    git clone https://github.com/mohansaivenkat/java-advanced-training.git
    cd java-advanced-workspace
    ```

2. **Navigate to any project and build**
    ```bash
    cd 21-Feb-Assignment-crm_sales_management_system
    mvn clean compile
    ```

3. **Run a project**
    ```bash
    mvn exec:java -Dexec.mainClass="main.Main"
    ```

4. **Run unit tests**
    ```bash
    mvn test
    ```

> **Note:** Update `src/main/resources/META-INF/persistence.xml` (Hibernate projects) or JDBC connection strings in the source files with your local database credentials before running.

---

##  Full Workspace Structure

```
java-advanced-workspace/
│
├── 📂 10-Feb-2026-Assignment/         # Product CRUD (Hibernate + JUnit 5)
├── 📂 11-Feb-2026-Assignment/         # Person ↔ Passport One-to-One (Hibernate + JUnit 5)
├── 📂 12-Feb-2026-Assignment/         # Student DAO (JDBC + JUnit 5)
├── 📂 13-Feb-Assignment-OneToOne/     # Student ↔ AadharCard ↔ HostelRoom (JPA)
├── 📂 13-Feb-2026-Assignment-Mockito/ # PriceService + DiscountRepository (Mockito)
├── 📂 14-Feb-Assignment-CaseStudy1/   # E-Commerce System (Hibernate + MySQL)
├── 📂 14-Feb-Assignment-CaseStudy2/   # Hospital Management (Hibernate + MySQL)
├── 📂 16-Feb-Assignment/              # Social Media Posts (Hibernate + MySQL)
├── 📂 21-Feb-Assignment-crm_sales_management_system/  # CRM Sales System (Hibernate + PostgreSQL)
│
├── 📂 basicsofjdbc/                   # Logic & JUnit 5 tests (Calculator, Factorial, Palindrome)
├── 📂 basicsofhibernate/              # Hibernate CRUD + JUnit 5 tests
├── 📂 learnjdbc/                      # Raw JDBC: connect, fetch, CRUD
├── 📂 caching/                        # Hibernate L1 & L2 Caching (Ehcache)
│
├── 📂 one_to_one_mapping/             # @OneToOne — Car ↔ Engine (unidirectional)
├── 📂 one_to_one_bidirectional_mapping/ # @OneToOne — Person ↔ Passport (bidirectional)
├── 📂 one_to_many_mapping/            # @OneToMany — College → Students
├── 📂 many_to_one_mapping/            # @ManyToOne — Employee → Department
├── 📂 many_to_many_mapping/           # @ManyToMany — Student ↔ Subject (unidirectional)
├── 📂 many_to_many_bidirectional_mapping/ # @ManyToMany — Student ↔ Subject (bidirectional)
│
├── 📂 mockito_practice/               # Mockito: UserService, CalculatorService testing
├── 📂 mockitotest/                    # Mockito: Foundational practice
│
└── 📄 README.md
```

---

*Happy Coding!*
