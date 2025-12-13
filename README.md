# Hotel Rating Microservices Project

 🔥 Project Overview

This project is a **real-world Spring Boot Microservices architecture** built to demonstrate backend engineering skills, 
system design understanding, and production-style service separation.
The system manages **Users, Hotels, and Ratings** using independent microservices with centralized configuration,
service discovery, and secure API routing.

This is not a toy project. It reflects how modern backend systems are structured in industry.

---------------------------------------------------------------------------------------------------------------------------------------------------

## 🧩 Microservices Included

| Service                       | Responsibility                        |
| ----------------------------- | ------------------------------------- |
| API Gateway                   | Single entry point, routing, security |
| Service Registry (Eureka)     | Service discovery                     |
| Config Server                 | Centralized configuration management  |
| User Service                  | User management & aggregation         |
| Hotel Service                 | Hotel data management                 |
| Rating Service                | Ratings & reviews management          |

----------------------------------------------------------------------------------------------------------------------------------------------------

 🏗️ Architecture Flow

Client
  ↓
API Gateway
  ↓
Service Registry (Eureka)
  ↓
User / Hotel / Rating Services
  ↓
Databases

* All services register with **Eureka Server**
* API Gateway routes requests dynamically
* Configuration is fetched from **Config Server**
* Inter-service communication handled using **Feign Client**

----------------------------------------------------------------------------------------------------------------------------------------------------

🛠️ Tech Stack (ATS Friendly)

* Java 17
* Spring Boot
* Spring Cloud (Eureka, Config Server, Gateway)
* Spring Security
* Feign Client
* RESTful APIs
* Maven
* Git & GitHub
* Microservices Architecture

🚀 Key Features

* Modular microservices architecture
* Centralized configuration management
* Service discovery with Eureka
* Secure API Gateway routing
* Global exception handling
* Clean layered architecture (Controller → Service → Repository)
* Production-ready project structure

----------------------------------------------------------------------------------------------------------------------------------------------------

▶️ How to Run Locally
1️⃣ Start Services in Order

1. Config Server
2. Service Registry (Eureka)
3. API Gateway
4. User Service
5. Hotel Service
6. Rating Service

2️⃣ Access Eureka Dashboard
http://localhost:8761

3️⃣ Access APIs via Gateway
http://localhost:8084
----------------------------------------------------------------------------------------------------------------------------------------------------

📂 Project Structure

SpringBoot Microservices Project
 ├── ApiGateway
 ├── ConfigServer
 ├── ServiceRegistry
 ├── UserService
 ├── HotelService
 └── RatingService


Each service is independently deployable and follows clean coding standards.


💡 What This Project Demonstrates

* Strong understanding of **backend system design**
* Practical knowledge of **Spring Boot & Microservices**
* Ability to design scalable and maintainable systems
* Industry-relevant coding practices
* Circuit breaker (Resilience4j)

📌 Future Enhancements

* Docker & Docker Compose
* Centralized logging (ELK Stack)
* API documentation (Swagger / OpenAPI)

👤 Author

Kiran Daud
Backend Java Developer | Spring Boot | Microservices

GitHub: [https://github.com/KiranDaud221122](https://github.com/KiranDaud221122)

----------------------------------------------------------------------------------------------------------------------------------------------------

⚠️ *This project is intentionally designed for learning, interviews, and real-world backend exposure.*
