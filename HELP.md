# Getting Started

### Build and Run (Maven)
- Build the project:
  - `mvn clean package`
- Run the application:
  - `mvn spring-boot:run`
  - or `java -jar target/hive-be-0.0.1-SNAPSHOT.jar`
- Run tests:
  - `mvn test`

### Technology Stack
- Spring Boot: 4.0.0
- Java: 25 (the build enforces JDK 25)
- Build tool: Maven
- Lombok: annotation processing for DTOs and responses

### API Quick Start
- `POST /ask`
  - Headers: `userId: <some-user-id>`
  - Body example: `{ "question": "What is 2+2?" }`

### Project Notes
- The project has been fully migrated from Gradle to Maven.
- Gradle files/wrapper have been removed and `.gitignore` prevents them from being reintroduced.
- If your IDE cached Gradle metadata, you can safely delete any local `.gradle/`, `gradle/`, or `build/` directories.

### Reference Documentation (Maven)
- Maven: https://maven.apache.org/guides/
- Spring Boot Maven Plugin: https://docs.spring.io/spring-boot/docs/current/maven-plugin/reference/html/
- Spring Boot Reference: https://docs.spring.io/spring-boot/docs/current/reference/html/

