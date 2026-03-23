#  E-Commerce Backend System

A professional backend system for an e-commerce application built using Spring Boot.  
The project follows modern backend architecture principles including layered design, security, and clean code practices.

---

##  Features

###  Authentication & Security
- JWT-based authentication (Login & Register)
- Role-based authorization (USER / ADMIN)
- Secure password hashing using BCrypt
- Protected APIs using Spring Security

---

###  Architecture & Design
- Layered architecture:
  - Controller
  - Service
  - Repository
  - DTO
- Clean separation of concerns
- DTO pattern to prevent exposing entities

---

###  Database & Persistence
- Spring Data JPA
- Entity relationships:
  - User ↔ Customer (One-to-One)
  - Customer ↔ Order (One-to-Many)
  - Order ↔ OrderItem (One-to-Many)
  - OrderItem ↔ Product (Many-to-One)

---

###  CRUD Operations
- Full CRUD for:
  - Products
  - Customers
  - Orders

---

###  Business Logic
- Order total calculation
- Stock management for products
- Service layer handles all business rules

---

### ⚡ AOP (Aspect-Oriented Programming)
- Logging system for service layer
- Tracks:
  - Method execution
  - Returned results
  - Exceptions
- Performance monitoring (execution time)

---

###  Advanced Features
- Custom queries using Spring Data JPA
- Filtering and sorting support
- Exception handling using Global Exception Handler
- Consistent API response structure

---

##  Technologies Used

- Java 17+
- Spring Boot
- Spring Security
- Spring Data JPA
- JWT (JSON Web Token)
- Lombok
- PostgreSQL
- Maven

---

##  API Endpoints

### Auth
- `POST /auth/register`
- `POST /auth/login`

### Products
- `GET /products`
- `GET /products/{id}`
- `POST /products`
- `PUT /products/{id}`
- `DELETE /products/{id}`

### Orders
- `POST /orders`
- `GET /orders`

### Customers
- `GET /customers`
- `POST /customers`

---

##  Authentication Flow

1. User registers
2. Password is encrypted
3. User logs in
4. JWT token is generated
5. Token is used to access protected APIs

---

##  Example Request (Login)

```json
{
  "email": "user@test.com",
  "password": "123456"
}
```
---

##  Example Response

```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

##  Project Structure

```code
com.ecommerce
│
├── controller
├── service
├── repository
├── model
├── dto
├── security
├── config
├── aop
├── exception
└── strategy / factory
```

 ## Testing
 
-	Tested using Postman
-	Covers authentication and CRUD operations
- Handles error cases using global exception handling



##  Future Improvements
-	Swagger API documentation
-	Refresh token mechanism
-	Role-based access control enhancements
-	Microservices architecture
-	Docker support



## Author

Ali Hayek

Developed as part of a full backend learning journey focusing on real-world architecture and best practices.
