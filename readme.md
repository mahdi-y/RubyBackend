# Ruby — E-Shop Microservices

![Java](https://img.shields.io/badge/Java-1.8-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.6.6-brightgreen)
![Postgres](https://img.shields.io/badge/Postgres-15.0-blue)
![Docker](https://img.shields.io/badge/Docker-Compose-blue)
![CI/CD](https://img.shields.io/badge/CI/CD-Jenkins-blue)

---

## 🚀 Overview

**Ruby** is a modular E-Shop platform built with a Spring Boot microservices architecture.  
It features user management, product catalog, order processing, stock management, delivery, and more — all orchestrated via Eureka and an API Gateway.

---

## 🗂️ Project Structure

```
.
├── APIGateway-Service/
├── DTO/
├── EurekaServer/
├── Livraison-Service/
├── Order-Service/
├── Panier-Service/
├── Produit-Service/
├── Reclamation-Service/
├── Stock-Service/
├── User-Service/
├── docker-compose.yml
├── pom.xml
└── readme.md
```

---

## 🧩 Modules

- **APIGateway-Service**: API Gateway for routing
- **DTO**: Shared data transfer objects
- **EurekaServer**: Service discovery
- **Livraison-Service**: Delivery management
- **Order-Service**: Order processing
- **Panier-Service**: Shopping cart management
- **Produit-Service**: Product catalog
- **Reclamation-Service**: Customer support & complaints
- **Stock-Service**: Inventory management
- **User-Service**: User authentication & management

---

## ⚡ Quick Start

### Prerequisites

- Java 1.8+
- Maven
- Docker & Docker Compose
- Postgres 15.0

### Running the Project

1. **Clone the repository**
    ```sh
    git clone <your-repo-url>
    cd RubyBackend
    ```

2. **Set up the database**
    - Create a Postgres database named `assignmentBD`.

3. **Build all services**
    ```sh
    ./mvnw clean install
    ```

4. **Start all services with Docker Compose**
    ```sh
    docker-compose up --build
    ```

5. **Access Eureka Dashboard**
    - Visit [http://localhost:8761](http://localhost:8761)

---

## 🛠️ CI/CD Pipeline

- Jenkins pipeline automates build, test, and deployment.
- Backend images are built and pushed to DockerHub.
- Services are deployed via `docker-compose.yml`.

---

## 📝 License

This project is licensed under the **MIT License**. See the [LICENSE](./LICENSE.md) file for details.

---
