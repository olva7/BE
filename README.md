# 💼 MI – Banking Marketplace

MI is a banking marketplace platform allowing different types of users (Administrator, Dealer, Client) to manage and consult products, make financial requests, and track their status in real-time.

---

## 🔧 Backend – Spring Boot

### 🔨 API & Architecture
- Modular monolithic architecture using **Clean Architecture** principles 
- RESTful API built with **Spring Boot**
- Security managed via **Spring Security** and **JWT**
- Seamless integration with databases using **Spring Data JPA** (PostgreSQL) and **Spring Data Cassandra**

### 🛡️ Authentication & Security
- Authentication based on **JWT tokens**
- Role-based authorization:
  - 👨‍💼 **Administrator**: manages users, products, statistics, and requests
  - 🚗 **Dealer**: adds and manages products
  - 👤 **Client**: creates and tracks requests
- Passwords secured using **BCrypt hashing**

### 💾 Polyglot Persistence
- **PostgreSQL**: for structured and relational data (users, products, requests…)
- **Cassandra**: for unstructured or historical data (logs, tracking history…)


### 🐳 Deployment & Containerization
- Fully **Dockerized** using `Dockerfile` and `docker-compose`
- Ready for deployment on **Kubernetes** and other container orchestration platforms

### 🗃️ Tech Stack
- **Spring Boot**, **Spring Security**, **Spring Data (JPA & Cassandra)**
- **MapStruct**, **Lombok**
- **PostgreSQL**, **Cassandra**
- **Docker**
- 
## 🔧 Frontend 
https://github.com/olva7/frontend
