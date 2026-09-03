# 🍔 QuickBites – Food Ordering Microservices

QuickBites is a Spring_boot based food-ordering application built using microservices architecture.

The project has been built incrementally in order to understand how individual services may communicate, discover and scale as part of a distributed application.

                 ┌─────────────────────┐
                 │     API GATEWAY     │
                 │       :9091         │
                 └──────────┬──────────┘
                            │
                            ▼
                 ┌─────────────────────┐
                 │   EUREKA SERVER     │
                 │       :8761         │
                 │  Service Registry   │
                 └──────────┬──────────┘
                            │
          ┌─────────────────┼─────────────────┐
          │                 │                 │
          ▼                 ▼                 ▼
   ┌─────────────┐   ┌─────────────┐   ┌─────────────┐
   │    USERS    │   │   ORDERS    │   │  RESTURANT  │
   │    :8080    │──▶│    :8081    │──▶│    :8082    │
   └─────────────┘   └─────────────┘   └─────────────┘
          │                 │                 │
          └─────────────────┴─────────────────┘
                    Service Registration

## 🚀 Microservices

### Users

Port: 8080
Features:
- User registration
- Password encryption (BCrypt)

- User authentication (Spring Security)
- User details management

- Communicates with Orders service
### Orders
Port: 8081
Features:
- Fetch menu
- Place order
- Calculate total price
- Store order
- Communicates with Resturant (OpenFeign)
### Resturant
Port: 8082
Features:
- Add menu items
- Fetch menu items
- Communicates with Orders (Feign)
### EurekaServer
Port: 8761
Features:
- Register and discover services
- Maintain a registry of all available microservices
In place of hardcoded locations, the services register themselves with Eureka.
### API Gateway
Port: 9091
Features:
- Ingress to microservices
- Currently makes use of Eureka discovery
Example:
Client
↓
API Gateway
↓
Users
↓
Orders
↓
Resturant
## 🔗 Inter-service Communication
Currently utilizing OpenFeign for inter-service communication.
Users ──Feign──> Orders
Orders ──Feign──> Resturant
Feign works in tandem with:
- Eureka Service Discovery
- Spring Cloud LoadBalancer
By utilizing Feign + Eureka, services are able to communicate using service names as opposed to relying on hardcoded IP:PORT combination.
## 🔐 Security
Project makes use of simple Spring Security currently to secure the services.
The projects make use of BCryptPasswordEncoder for storing passwords.
JWT based authentication hasn't been implemented, however it's a future roadmap feature.
## 🗄 Databases
Currently utilizing:
- MySQL
- Spring Data JPA
- Hibernate
## 🛠 Technologies Used
Java
Spring Boot
Spring Data JPA
Hibernate
Spring Security
MySQL
OpenFeign
Spring Cloud Eureka
Spring Cloud LoadBalancer
Spring Cloud Gateway
Maven
IntelliJ IDEA
## ▶ Running the Application
Start the following services:
EurekaServer → 8761
Resturant  → 8082
Orders    → 8081
Users    → 8080
GATEWAY   → 9091
Eureka Dashboard:
http://localhost:8761
The services should be able to register with Eureka.

## 🔮 Future Enhancements

### Resilience4j
Will add features such as:
- Circuit Breaker
- Retry
- Rate Limiter
- Timeout
- Fallback
This will help increase robustness of communication between the microservices.
### JWT Authentication
Replace simple Spring Security with JWT based implementation.
### Apache Kafka
Add Kafka messaging system to the mix in order to perform asynchronous communication between services.
### Redis
Utilize Redis for caching purposes in order to reduce strain on the database and increase application's performance (e.g. caching menu data)
## 🎯 Learning Goals
The purpose of this project is to gain experience with:
Microservices architecture
Service discovery
API Gateway
Inter-service communication
OpenFeign
Load balancer
Spring Security
Databases
Fault tolerance
Async communication
## 📌 Project Status
### ✅ Completed
Users Service
Orders Service
Resturant Service
MySQL + JPA
Simple Spring Security
OpenFeign Communication
Eureka Service Registry
Eureka Service Discovery
Spring Cloud LoadBalancer
API Gateway
Gateway Service Discovery
### 🛠 Future Enhancements
1.Resilience4j
2.JWT Authentication
3.Apache Kafka / Async
4.Redis
