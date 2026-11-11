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

## Quick Start
- [API Endpoints](#api-endpoints-)
- [Running Locally](#running-locally-️)
- [Testing the API via Terminal (curl)](#testing-the-api-via-terminal-curl-)
- [Roadmap & Future Improvements](#roadmap--future-improvements-)


## API Endpoints 📡

| Method | Endpoint | Description |
| --- | --- | --- |
| **GET** | `/api/audit` | Retrieves a list of all recorded audit log entries. |
| **POST** | `/api/audit` | Creates and saves a new audit log entry. |


## Running Locally 🖥️

### Prerequisites
* **Java Development Kit (JDK) 21** installed on your machine.

### Instructions
1. Clone this repository:
   ```bash
   git clone https://github.com/cristianxdesantis/docuaudit.git
   cd docuaudit
   ```

2. Set your JAVA_HOME path (if not already configured):
    ```bash
    export JAVA_HOME="/usr/lib/jvm/java-21-openjdk-amd64"
    export PATH=$JAVA_HOME/bin:$PATH
    ```

3. Run the application using the Maven wrapper:
    ```bash
    ./mvnw spring-boot:run
    ```

4. The embedded Tomcat server will spin up on port 8080 of localhost (http://localhost:8080)


## Testing the API via Terminal (curl) 🧪

1. Check the server health (GET):
    ```bash
    curl http://localhost:8080/api/audit
    ```
*This should output empty square brackets, since there are no audit log entries yet.*


2. Create a new audit log entry (POST):
    ```bash
    curl -X POST http://localhost:8080/api/audit \
    -H "Content-Type: application/json" \
    -d '{"documentId": "doc-123", "action": "UPLOADED", "performedBy": "Marco"}'
    ```
*You can execute this command multiple times to create multiple log entries (you can see the `id` gradually increment every time you create an entry).*

3. Retrieve all logs (GET):
    ```bash
    curl http://localhost:8080/api/audit
    ```
*Depending on how many entries you added, this will output them all together.*


## Roadmap & Future Improvements 🏃
- Swap the in-memory H2 database for PostgreSQL for persistent enterprise storage.

- Introduce a dedicated Service Layer to handle complex business logic and validation rules.

- Implement global exception handling for cleaner API error responses.