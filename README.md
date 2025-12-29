<div align="center">

# 🏨 Hotel Rating Microservices

### *Enterprise-Grade Spring Boot Microservices Architecture*

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?style=for-the-badge&logo=spring)
![Microservices](https://img.shields.io/badge/Architecture-Microservices-blue?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-yellow?style=for-the-badge)

**A production-ready microservices ecosystem demonstrating modern backend engineering practices, distributed system design, and cloud-native architecture patterns.**

[Features](#-key-features) • [Architecture](#-system-architecture) • [Getting Started](#-quick-start) • [Documentation](#-api-documentation)

---

</div>

## 📋 Table of Contents

- [Overview](#-overview)
- [System Architecture](#-system-architecture)
- [Microservices](#-microservices-breakdown)
- [Tech Stack](#-technology-stack)
- [Key Features](#-key-features)
- [Project Structure](#-project-structure)
- [Getting Started](#-quick-start)
- [API Documentation](#-api-documentation)
- [Future Roadmap](#-roadmap)
- [Contributing](#-contributing)
- [Author](#-author)

---

## 🎯 Overview

This project showcases a **real-world microservices architecture** built with Spring Boot, designed to manage Users, Hotels, and Ratings through independently deployable services. The system implements industry-standard patterns including service discovery, centralized configuration, API gateway routing, and inter-service communication.

> **Why This Matters:** This isn't a tutorial project—it's a demonstration of production-level system design that mirrors architectures used by companies like Netflix, Amazon, and Uber.

### 🎪 What Makes This Special

- ✨ **Production-Ready Architecture** - Not just theory, but practical implementation
- 🔐 **Security-First Design** - Integrated Spring Security at the gateway level
- 📊 **Scalable & Resilient** - Circuit breakers, fault tolerance, and service discovery
- 🎨 **Clean Code Principles** - Well-structured, maintainable, and documented
- 🚀 **Industry Standards** - Follows best practices used in Fortune 500 companies

---

## 🏗️ System Architecture

```
                                    ┌─────────────────┐
                                    │   API Gateway   │
                                    │   Port: 8084    │
                                    └────────┬────────┘
                                             │
                    ┌────────────────────────┼────────────────────────┐
                    │                        │                        │
                    ▼                        ▼                        ▼
         ┌──────────────────┐    ┌──────────────────┐    ┌──────────────────┐
         │  User Service    │    │  Hotel Service   │    │  Rating Service  │
         │  Port: 8081      │    │  Port: 8082      │    │  Port: 8083      │
         └────────┬─────────┘    └────────┬─────────┘    └────────┬─────────┘
                  │                       │                        │
                  └───────────────────────┼────────────────────────┘
                                          │
                                          ▼
                              ┌───────────────────────┐
                              │   Service Registry    │
                              │   (Eureka Server)     │
                              │   Port: 8761          │
                              └───────────┬───────────┘
                                          │
                                          ▼
                              ┌───────────────────────┐
                              │   Config Server       │
                              │   Port: 8085          │
                              └───────────────────────┘
```

### 🔄 Request Flow

```
1. Client Request → API Gateway (Authentication & Routing)
2. Gateway → Service Registry (Service Discovery)
3. Gateway → Target Microservice (Load Balanced)
4. Microservice → Database (Data Persistence)
5. Response ← Back to Client
```

---

## 🧩 Microservices Breakdown

<table>
<tr>
<td width="50%">

### 🌐 API Gateway
**Port:** `8084`

- Single entry point for all client requests
- Request routing and load balancing
- Authentication & authorization
- Rate limiting and throttling
- Cross-cutting concerns (logging, monitoring)

</td>
<td width="50%">

### 🗺️ Service Registry
**Port:** `8761`

- Netflix Eureka-based service discovery
- Dynamic service registration
- Health checks and heartbeat monitoring
- Load balancing metadata
- Real-time service availability tracking

</td>
</tr>
<tr>
<td width="50%">

### ⚙️ Config Server
**Port:** `8085`

- Centralized configuration management
- Git-backed configuration repository
- Environment-specific properties
- Dynamic configuration refresh
- Encrypted sensitive data

</td>
<td width="50%">

### 👤 User Service
**Port:** `8081`

- User registration and management
- User profile operations
- Aggregate user data with ratings
- Feign client integration
- RESTful API endpoints

</td>
</tr>
<tr>
<td width="50%">

### 🏨 Hotel Service
**Port:** `8082`

- Hotel catalog management
- Hotel CRUD operations
- Search and filtering
- Independent database
- Scalable data layer

</td>
<td width="50%">

### ⭐ Rating Service
**Port:** `8083`

- User ratings and reviews
- Rating aggregation
- Hotel-user relationship management
- Analytics-ready data structure
- RESTful endpoints

</td>
</tr>
</table>

---

## 💻 Technology Stack

<div align="center">

### Core Technologies

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Spring Cloud](https://img.shields.io/badge/Spring%20Cloud-2023.x-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)

### Microservices Components

![Eureka](https://img.shields.io/badge/Eureka-Service%20Discovery-00C7B7?style=for-the-badge)
![Spring Cloud Gateway](https://img.shields.io/badge/Gateway-API%20Gateway-6DB33F?style=for-the-badge)
![Feign](https://img.shields.io/badge/Feign-HTTP%20Client-blue?style=for-the-badge)
![Resilience4j](https://img.shields.io/badge/Resilience4j-Circuit%20Breaker-orange?style=for-the-badge)

### Additional Tools

![Spring Security](https://img.shields.io/badge/Security-Spring%20Security-6DB33F?style=for-the-badge)
![MySQL](https://img.shields.io/badge/Database-MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Git](https://img.shields.io/badge/VCS-Git-F05032?style=for-the-badge&logo=git&logoColor=white)

</div>

---

## ✨ Key Features

### 🎯 Architectural Excellence

- **Microservices Pattern** - Domain-driven design with loosely coupled services
- **Service Discovery** - Dynamic service registration and discovery with Eureka
- **API Gateway Pattern** - Centralized routing, security, and cross-cutting concerns
- **Configuration Management** - Externalized configuration with Config Server
- **Inter-Service Communication** - Declarative REST clients with Feign

### 🔐 Security & Resilience

- **Spring Security Integration** - JWT-based authentication and authorization
- **Circuit Breaker Pattern** - Fault tolerance with Resilience4j
- **Fallback Mechanisms** - Graceful degradation on service failures
- **Health Monitoring** - Actuator endpoints for service health checks

### 🎨 Code Quality

- **Clean Architecture** - Layered design (Controller → Service → Repository)
- **SOLID Principles** - Maintainable and extensible codebase
- **Exception Handling** - Global exception handlers with meaningful responses
- **API Versioning** - Forward-compatible API design

### 📊 Observability

- **Centralized Logging** - Structured logging across all services
- **Distributed Tracing** - Request tracking across service boundaries
- **Metrics & Monitoring** - Performance and health metrics

---

## 📂 Project Structure

```
hotel-rating-microservices/
│
├── 🌐 ApiGateway/
│   ├── src/main/java/com/gateway/
│   │   ├── config/
│   │   │   ├── SecurityConfig.java
│   │   │   └── GatewayConfig.java
│   │   └── ApiGatewayApplication.java
│   └── src/main/resources/
│       └── application.yml
│
├── 🗺️ ServiceRegistry/
│   ├── src/main/java/com/eureka/
│   │   └── EurekaServerApplication.java
│   └── src/main/resources/
│       └── application.yml
│
├── ⚙️ ConfigServer/
│   ├── src/main/java/com/config/
│   │   └── ConfigServerApplication.java
│   └── src/main/resources/
│       └── application.yml
│
├── 👤 UserService/
│   ├── src/main/java/com/user/
│   │   ├── controller/
│   │   │   └── UserController.java
│   │   ├── service/
│   │   │   ├── UserService.java
│   │   │   └── UserServiceImpl.java
│   │   ├── repository/
│   │   │   └── UserRepository.java
│   │   ├── entity/
│   │   │   └── User.java
│   │   ├── external/
│   │   │   ├── HotelService.java
│   │   │   └── RatingService.java
│   │   └── UserServiceApplication.java
│   └── src/main/resources/
│       └── application.yml
│
├── 🏨 HotelService/
│   ├── src/main/java/com/hotel/
│   │   ├── controller/
│   │   │   └── HotelController.java
│   │   ├── service/
│   │   │   ├── HotelService.java
│   │   │   └── HotelServiceImpl.java
│   │   ├── repository/
│   │   │   └── HotelRepository.java
│   │   ├── entity/
│   │   │   └── Hotel.java
│   │   └── HotelServiceApplication.java
│   └── src/main/resources/
│       └── application.yml
│
├── ⭐ RatingService/
│   ├── src/main/java/com/rating/
│   │   ├── controller/
│   │   │   └── RatingController.java
│   │   ├── service/
│   │   │   ├── RatingService.java
│   │   │   └── RatingServiceImpl.java
│   │   ├── repository/
│   │   │   └── RatingRepository.java
│   │   ├── entity/
│   │   │   └── Rating.java
│   │   └── RatingServiceApplication.java
│   └── src/main/resources/
│       └── application.yml
│
├── 📄 README.md
├── 📋 pom.xml
└── 🔧 .gitignore
```

---

## 🚀 Quick Start

### Prerequisites

Before you begin, ensure you have the following installed:

- ☕ **Java 17** or higher
- 📦 **Maven 3.8+**
- 🗄️ **MySQL 8.0+** (or preferred database)
- 🔧 **Git**
- 💻 **IDE** (IntelliJ IDEA, Eclipse, or VS Code)

### Installation Steps

#### 1️⃣ Clone the Repository

```bash
git clone https://github.com/KiranDaud221122/hotel-rating-microservices.git
cd hotel-rating-microservices
```

#### 2️⃣ Configure Databases

Create three databases for the services:

```sql
CREATE DATABASE user_service_db;
CREATE DATABASE hotel_service_db;
CREATE DATABASE rating_service_db;
```

#### 3️⃣ Update Configuration

Update `application.yml` in each service with your database credentials.

#### 4️⃣ Start Services in Order

**Important:** Services must be started in this specific order to ensure proper registration and dependency resolution.

```bash
# 1. Start Config Server (Port: 8085)
cd ConfigServer
mvn spring-boot:run

# 2. Start Service Registry (Port: 8761)
cd ../ServiceRegistry
mvn spring-boot:run

# 3. Start API Gateway (Port: 8084)
cd ../ApiGateway
mvn spring-boot:run

# 4. Start Business Services (can be started in parallel)
cd ../UserService
mvn spring-boot:run

cd ../HotelService
mvn spring-boot:run

cd ../RatingService
mvn spring-boot:run
```

#### 5️⃣ Verify Services

- **Eureka Dashboard:** http://localhost:8761
- **API Gateway:** http://localhost:8084
- **Config Server:** http://localhost:8085

All services should appear as **UP** in the Eureka dashboard.

---

## 📚 API Documentation

### Base URL

All API requests should go through the API Gateway:

```
http://localhost:8084
```

### User Service Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/users` | Get all users |
| GET | `/users/{id}` | Get user by ID with ratings |
| POST | `/users` | Create new user |
| PUT | `/users/{id}` | Update user |
| DELETE | `/users/{id}` | Delete user |

### Hotel Service Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/hotels` | Get all hotels |
| GET | `/hotels/{id}` | Get hotel by ID |
| POST | `/hotels` | Create new hotel |
| PUT | `/hotels/{id}` | Update hotel |
| DELETE | `/hotels/{id}` | Delete hotel |

### Rating Service Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/ratings` | Get all ratings |
| GET | `/ratings/{id}` | Get rating by ID |
| GET | `/ratings/users/{userId}` | Get all ratings by user |
| GET | `/ratings/hotels/{hotelId}` | Get all ratings for hotel |
| POST | `/ratings` | Create new rating |
| PUT | `/ratings/{id}` | Update rating |
| DELETE | `/ratings/{id}` | Delete rating |

### Example Request

```bash
# Get user with aggregated ratings
curl -X GET http://localhost:8084/users/1
```

---

## 🗺️ Roadmap

### Phase 1: Current Implementation ✅
- [x] Microservices architecture setup
- [x] Service discovery with Eureka
- [x] API Gateway routing
- [x] Feign client integration
- [x] Basic security implementation

### Phase 2: Enhanced Observability 🔄
- [ ] Distributed tracing with Zipkin
- [ ] Centralized logging with ELK Stack
- [ ] Metrics with Prometheus & Grafana
- [ ] Custom dashboards

### Phase 3: Containerization 📦
- [ ] Docker containerization
- [ ] Docker Compose orchestration
- [ ] Kubernetes deployment manifests
- [ ] Helm charts

### Phase 4: Advanced Features 🚀
- [ ] Message broker integration (RabbitMQ/Kafka)
- [ ] Event-driven architecture
- [ ] CQRS pattern implementation
- [ ] API documentation with Swagger/OpenAPI
- [ ] Rate limiting and throttling
- [ ] Caching with Redis

### Phase 5: Production Readiness 🏭
- [ ] CI/CD pipeline (GitHub Actions)
- [ ] Automated testing (Unit, Integration, E2E)
- [ ] Performance testing
- [ ] Security scanning
- [ ] Production deployment guide

---

## 🤝 Contributing

Contributions are always welcome! Here's how you can help:

1. **Fork** the repository
2. **Create** a feature branch (`git checkout -b feature/AmazingFeature`)
3. **Commit** your changes (`git commit -m 'Add some AmazingFeature'`)
4. **Push** to the branch (`git push origin feature/AmazingFeature`)
5. **Open** a Pull Request

Please ensure your PR follows the project's coding standards and includes appropriate tests.

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 👨‍💻 Author

<div align="center">

### **Kiran Daud**

*Backend Java Developer | Spring Boot Specialist | Microservices Architect*

[![GitHub](https://img.shields.io/badge/GitHub-KiranDaud221122-181717?style=for-the-badge&logo=github)](https://github.com/KiranDaud221122)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-Connect-0077B5?style=for-the-badge&logo=linkedin)](https://linkedin.com/in/kirandaud)
[![Email](https://img.shields.io/badge/Email-Contact-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:kiran.daud@example.com)

</div>

---

## 💡 What This Project Demonstrates

<table>
<tr>
<td width="33%">

### 🎯 Technical Skills
- Spring Boot ecosystem mastery
- Microservices architecture
- RESTful API design
- Database design & integration
- Cloud-native patterns

</td>
<td width="33%">

### 🏗️ System Design
- Distributed systems
- Service discovery
- Load balancing
- Fault tolerance
- Scalability patterns

</td>
<td width="33%">

### 💼 Industry Practices
- Clean code principles
- SOLID design patterns
- Security best practices
- Production-ready code
- Documentation standards

</td>
</tr>
</table>

---

<div align="center">

### ⭐ If you found this project helpful, please consider giving it a star!

**Built with ❤️ by [Kiran Daud](https://github.com/KiranDaud221122)**

*This project is designed for learning, portfolio demonstration, and interview preparation.*

---

![Visitor Count](https://visitor-badge.laobi.icu/badge?page_id=KiranDaud221122.hotel-rating-microservices)
![Last Commit](https://img.shields.io/github/last-commit/KiranDaud221122/hotel-rating-microservices?style=flat-square)
![Repo Size](https://img.shields.io/github/repo-size/KiranDaud221122/hotel-rating-microservices?style=flat-square)

</div>
