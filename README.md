# Employee-Management-System# 🚀 Employee Management System (EMS)

A full-stack **Employee Management System** built using **Spring Boot**, **JWT Authentication**, and **MySQL**. This project demonstrates secure REST API development with role-based access control.

---

## 📌 Features

* 🔐 JWT-based Authentication & Authorization
* 👤 User Registration & Login
* 🧑‍💼 Employee CRUD Operations (Create, Read, Update, Delete)
* 🛡️ Role-Based Access Control (ADMIN / USER)
* 🗄️ MySQL Database Integration

---

## 🛠️ Tech Stack

* **Backend:** Spring Boot, Spring Security, JWT
* **Database:** MySQL
* **Build Tool:** Maven
* **API Testing:** Postman

---

## 📂 Project Structure

```
com.stackly.ems
│
├── config          # Security configurations
├── controller      # REST controllers
├── dto             # Data Transfer Objects
├── entity          # JPA entities
├── repository      # JPA repositories
├── service         # Business logic
├── security        # JWT & filters
```

---

## 🔐 Authentication Flow

1. User registers via `/auth/register`
2. User logs in via `/auth/login`
3. JWT token is generated
4. Token must be passed in headers:

   ```
   Authorization: Bearer <token>
   ```
5. Access secured APIs

---

## 📡 API Endpoints

### 🔑 Auth APIs

| Method | Endpoint         | Description       |
| ------ | ---------------- | ----------------- |
| POST   | `/auth/register` | Register new user |
| POST   | `/auth/login`    | Login & get JWT   |

---

### 🧑‍💼 Employee APIs

| Method | Endpoint              | Access | Description        |
| ------ | --------------------- | ------ | ------------------ |
| POST   | `/api/employees`      | ADMIN  | Add employee       |
| GET    | `/api/employees`      | ADMIN  | Get all employees  |
| GET    | `/api/employees/{id}` | ADMIN  | Get employee by ID |
| PUT    | `/api/employees/{id}` | ADMIN  | Update employee    |
| DELETE | `/api/employees/{id}` | ADMIN  | Delete employee    |

---

## 🗄️ Database Schema

### 👤 User

* id (PK)
* username
* password
* role

### 🧑‍💼 Employee

* id (PK)
* name
* email
* department
* salary

---

## ⚙️ Setup Instructions

### 1️⃣ Clone Repository

```
git clone https://github.com/your-username/ems-project.git
cd ems-project
```

### 2️⃣ Configure Database

Update `application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/ems_db
spring.datasource.username=root
spring.datasource.password=your_password
```

### 3️⃣ Run Application

```
mvn spring-boot:run
```

---

## 🧪 Testing with Postman

1. Register user
2. Login → get JWT token
3. Add token in headers
4. Test secured APIs

---

## 🔥 Sample Request

### Create Employee

```
POST /api/employees
```

```json
{
  "name": "Nikhil",
  "email": "nikhil@email.com",
  "department": "IT",
  "salary": 50000
}










