# 🚀 Spring Boot BlogApp

A RESTful API for a blog application built with Spring Boot 2.5. This application allows users to create accounts, publish articles, and interact through comments.

## ✨ Features

- 👥 User registration and authentication
- 📝 Article creation and management
- 💬 Commenting system
- 🔌 RESTful API endpoints
- 📚 Swagger UI for API documentation

## 🛠️ Technologies Used

- 🍃 Spring Boot 2.5
- 💾 H2 Database (in-memory)
- 🔄 Spring Data JPA
- 🔒 Spring Security
- 📋 Swagger UI for API documentation

## 📋 Prerequisites

- ☕ Java JDK 8 or higher
- 🔨 Maven
- 💻 IntelliJ IDEA (recommended) or any other Java IDE

## 🏁 Getting Started

### Clone the repository

```bash
git clone https://github.com/yash1648/BlogApp.git
cd BlogApp
```

### Run the application

Using IntelliJ IDEA:
1. Open the project in IntelliJ IDEA
2. Wait for Maven to download all dependencies
3. Run the main application class (BlogAppApplication.java)

Using Maven:
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## 💾 Database

This project uses H2 in-memory database, which means data will be lost when the application is restarted.

To access the H2 console:
1. Go to `http://localhost:8080/h2-console`
2. JDBC URL: `jdbc:h2:mem:blogapp` (or as configured in application.properties)
3. Username: `sa` (default)
4. Password: leave empty (default)

## 📚 API Documentation

The API documentation is available via Swagger UI at `http://localhost:8080/swagger-ui.html`

## 🔌 API Endpoints

### 👥 Users

- `POST /users` - Register a new user
- `POST /users/login` - Authenticate a user

### 📝 Articles

- `GET /articles` - Get all articles
- `GET /articles/{id}` - Get a specific article
- `POST /articles` - Create a new article
- `PUT /articles/{id}` - Update an article
- `DELETE /articles/{id}` - Delete an article

### 💬 Comments

- `GET /articles/{articleId}/comments` - Get all comments for an article
- `POST /articles/{articleId}/comments` - Add a comment to an article
- `PUT /articles/{articleId}/comments/{commentId}` - Update a comment
- `DELETE /articles/{articleId}/comments/{commentId}` - Delete a comment

## ⚙️ Configuration

The application can be configured through the `application.properties` file:

```properties
# Server port
server.port=8080

# H2 Database configuration
spring.datasource.url=jdbc:h2:mem:blogapp
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

# Enable H2 console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# Swagger configuration
springdoc.api-docs.path=/api-docs
```

## 📄 License

[MIT License](LICENSE)