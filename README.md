# 🚀 Microservices Architecture with Spring Cloud Gateway & Eureka

## Overview
This project demonstrates a **Microservices Architecture** using **Spring Cloud Gateway**, **Eureka Server**, and **Eureka Clients**. It enables dynamic service discovery, API routing, and efficient payload management for scalable and resilient systems.

## 🏗️ Tech Stack
- **Spring Boot** (Microservices development)
- **Spring Cloud Gateway** (API Gateway for routing & filtering)
- **Eureka Server** (Service discovery & registration)
- **Eureka Clients** (Microservices registering dynamically)
- **Spring WebFlux** (For reactive API handling)

## ⚙️ Architecture
```
                           +-------------------+
                           |   API Gateway     |
                           | (Spring Gateway)  |
                           +-------------------+
                                      |
            ---------------------------------------------------
            |                     |                           |
+------------------+  +------------------+  +------------------+
|  Question Service   |  |  Quiz Service    |  | Server-Registry    |
| (Eureka Client) |  | (Eureka Client)  |  | (Eureka Server)  |
+------------------+  +------------------+  +------------------+
```

## 🚀 Getting Started

### 1️⃣ Clone the Repository
```sh
git clone https://github.com/meetmodeon/microservices-project.git
cd microservices-project
```

### 2️⃣ Run Eureka Server
```sh
cd eureka-server
mvn spring-boot:run
```

### 3️⃣ Run Microservices (Eureka Clients)
```sh
cd user-service  # or quiz-service, auth-service
mvn spring-boot:run
```

### 4️⃣ Run API Gateway
```sh
cd api-gateway
mvn spring-boot:run
```

## 📌 API Gateway Configuration (`application.yml`)
```yaml
server:
  port: 8083

spring:
  application:
    name: API-GATEWAY
  cloud:
    gateway:
      routes:
        - id: QUIZ-SERVICE
          uri: lb://QUIZ-SERVICE
          predicates:
            - Path=/quiz/**,/quiz-test/**

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
    register-with-eureka: true
    fetch-registry: true
```

## 📌 Eureka Server Configuration (`application.yml`)
```yaml
server:
  port: 8761

spring:
  application:
    name: EUREKA-SERVER

eureka:
  client:
    register-with-eureka: false
    fetch-registry: false
```

## 🛠️ Features
✅ **Dynamic Routing** with Spring Cloud Gateway  
✅ **Service Discovery** with Eureka Server  
✅ **Load Balancing** using Eureka Clients  
✅ **Payload Transformation** for structured data flow  
✅ **Scalability & Fault Tolerance**  

## 💡 Contributing
1. Fork the repository.
2. Create a new branch (`feature-xyz`).
3. Commit your changes.
4. Push to the branch and submit a PR.

## 📜 License
This project is open-source and available under the MIT License.

---

🔥 **Let's build scalable and distributed systems!** 🔥  
#Microservices #SpringBoot #Eureka #APIGateway #PayloadManagement
