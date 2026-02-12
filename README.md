# ☕ Java Advanced Training Workspace

Welcome to the **Java Advanced Training Workspace**! This repository is a curated collection of Maven projects designed to master advanced Java concepts, with a strong focus on **Database Connectivity** and **Object-Relational Mapping (ORM)**.

---

## 📂 Project Structure

This workspace is organized into three distinct modules, each targeting a specific layer of enterprise Java development:

```text
📦 java-advanced-workspace
 ┣ 📂 basicsofjdbc       # 🏗️ Core JDBC concepts & foundation
 ┣ 📂 learnjdbc          # 🚀 Practical JDBC implementation with Postgres
 ┗ 📂 basicsofhibernate  # 🦁 Hibernate ORM with Entity Mapping
```

---

## 🚀 Projects & Dependencies

Here is a detailed breakdown of each module and the libraries that power them:

### 1️⃣ **basicsofjdbc**
*Focus: Fundamentals of Java Database Connectivity.*

| Dependency | Version | Scope | Description |
| :--- | :--- | :--- | :--- |
| **JUnit 5 API** | `5.11.4` | `test` | Framework for writing and running unit tests. |

### 2️⃣ **learnjdbc**
*Focus: Hands-on JDBC implementation connecting to a real-world database.*

| Dependency | Version | Scope | Description |
| :--- | :--- | :--- | :--- |
| **PostgreSQL Driver** | `42.6.0` | `compile` | JDBC driver for PostgreSQL database connectivity. |
| **JUnit 5 API** | `5.11.4` | `test` | Framework for unit testing database interactions. |

### 3️⃣ **basicsofhibernate**
*Focus: Enterprise-grade ORM using Hibernate.*

| Dependency | Version | Scope | Description |
| :--- | :--- | :--- | :--- |
| **Hibernate Core** | `5.6.15.Final` | `compile` | The core ORM framework for mapping Java objects to relation tables. |
| **PostgreSQL Driver** | `42.6.0` | `compile` | JDBC driver to allow Hibernate to talk to PostgreSQL. |
| **JUnit 5 API** | `5.11.4` | `test` | Core testing framework. |
| **JUnit 5 Params** | `5.10.2` | `test` | Support for parameterized tests. |

---

## 🛠️ Technologies Stack

This workspace is built using a modern, robust Java stack:

*   ☕ **Java**: The bedrock of our applications.
*   🐘 **PostgreSQL**: Advanced open-source relational database.
*   🪄 **Hibernate**: Powerful ORM framework for data persistence.
*   🔌 **JDBC**: Standard Java API for database connectivity.
*   📦 **Maven**: Dependency management and build automation.
*   ✅ **JUnit 5**: The next generation of programmer-friendly testing frameworks.

---

## 🏁 Getting Started

Follow these steps to set up the workspace locally:

### Prerequisites
Ensure you have the following installed:
*   [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/)
*   [Apache Maven](https://maven.apache.org/download.cgi)
*   [PostgreSQL](https://www.postgresql.org/download/)

### 🔨 Build Instructions

Each project is a standalone Maven module. To build a project, navigate to its directory and run:

```bash
cd basicsofhibernate  # or learnjdbc, basicsofjdbc
mvn clean install
```

Happy Coding! 🎉
