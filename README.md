# DocuAudit
An enterprise-grade audit logging backend service built with **Java 21** and **Spring Boot**. Designed with a clean three-tier architectural pattern to ensure strict separation of concerns between HTTP routing, business state handling, and data persistence.


## Tech Stack
* **Language:** Java 21 (LTS)
* **Framework:** Spring Boot 
* **Data Access:** Spring Data JPA / Hibernate (ORM)
* **Database:** H2 (In-memory relational database for rapid testing and development)
* **Build Tool:** Maven


## Architecture & Data Flow 🏛️
DocuAudit follows a standard enterprise **Controller-Repository-Model** pattern:
1. **Model (`AuditLog.java`)**: Represents the database entity and maps directly to the underlying relational schema using JPA annotations (`@Entity`, `@Table`).
2. **Repository (`AuditLogRepository.java`)**: Extends `JpaRepository` to leverage Spring Data's built-in data access methods without needing raw boilerplate SQL queries.
3. **Controller (`AuditController.java`)**: Exposes RESTful HTTP endpoints (`@RestController`) to safely accept incoming web traffic and return serialized JSON payloads.


## API Endpoints 📡

| Method | Endpoint | Description |
| --- | --- | --- |
| **GET** | `/api/audit` | Retrieves a list of all recorded audit log entries. |
| **POST** | `/api/audit` | Creates and saves a new audit log entry. |


## Getting Started & Running Locally ⚙️

### Prerequisites
* **Java Development Kit (JDK) 21** installed on your machine.

### Instructions
1. Clone this repository:
   ```bash
   git clone 
   cd docuaudit
   ```