# 📝 Task Tracker API

A **job-ready Task Tracker REST API** built using **Spring Boot**, **Spring Data JPA**, **DTO + Validation**, and **MySQL (Railway)**.

This project follows **industry best practices** such as layered architecture, DTO-based API contracts, validation at the API boundary, and cloud-ready configuration using environment variables.

---

## 🚀 Features

- RESTful Task Management API
- DTO-based request & response models
- Bean Validation (`@NotBlank`, `@Size`)
- Service-layer architecture (Controller → Service → Repository)
- MySQL integration using JPA & Hibernate
- Railway-ready deployment
- Environment-variable–based configuration

---

## 🧱 Tech Stack

- **Java 17+**
- **Spring Boot 3.x**
- **Spring Data JPA (Hibernate)**
- **MySQL 8 (Railway)**
- **Maven**
- **Jakarta Bean Validation**

---

## 📂 Project Structure

```
src/main/java/com/demo
├── controller
│   └── TaskController.java
├── service
│   └── TaskService.java
├── repository
│   └── TaskRepository.java
├── model
│   └── Task.java
├── dto
│   ├── TaskRequestDto.java
│   └── TaskResponseDto.java
└── RailwayDemoApplication.java
```

---

## 🔐 API Design Principle

- **Entities are never exposed directly**
- **Controllers accept & return DTOs only**
- **Validation is applied at API boundary**
- **Business logic lives in Service layer**

This keeps the API secure, maintainable, and scalable.

---

## 📦 API Endpoints

### ➕ Create Task

**POST** `/tasks`

Request Body:
```json
{
  "title": "Learn Spring Boot"
}
```

Validation Rules:
- `title` must not be blank
- length: 3–100 characters

---

### 📄 Get All Tasks

**GET** `/tasks`

Response:
```json
[
  {
    "id": 1,
    "title": "Learn Spring Boot",
    "completed": false
  }
]
```
## API Documentation
Swagger UI is available at:
http://localhost:8080/swagger-ui/index.html

---

## ⚙️ Configuration

The application uses **environment variables** for database configuration.

### `application.properties`

```properties
spring.datasource.url=jdbc:mysql://${MYSQL_HOST}:${MYSQL_PORT}/${MYSQL_DATABASE}?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
spring.datasource.username=${MYSQL_USER}
spring.datasource.password=${MYSQL_PASSWORD}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=${PORT:8080}
```

---

## 🧪 Run Locally (PowerShell)

```powershell
$env:MYSQL_HOST="<HOST>"
$env:MYSQL_PORT="<PORT>"
$env:MYSQL_DATABASE="<DB_NAME>"
$env:MYSQL_USER="<USERNAME>"
$env:MYSQL_PASSWORD="<PASSWORD>"

mvn spring-boot:run
```

---

## ☁️ Deploy on Railway

1. Push project to GitHub
2. Create Railway project
3. Add MySQL plugin
4. Set environment variables in Railway dashboard
5. Deploy 🚀

Railway automatically detects Spring Boot applications.

---

## 🧠 What This Project Demonstrates (Interview Ready)

- Clean REST API design
- DTO usage instead of exposing entities
- Bean Validation with meaningful error handling
- Cloud-ready configuration
- Real-world Spring Boot architecture

---

## 🔮 Next Enhancements

- Global Exception Handling (`@RestControllerAdvice`)
- Pagination & Sorting
- Spring Security (JWT)
- Docker support
- Swagger/OpenAPI documentation

---

## 👨‍💻 Author

**Aayush**  
Backend Developer | Java | Spring Boot

---

⭐ If you find this project helpful, give it a star and feel free to extend it!

