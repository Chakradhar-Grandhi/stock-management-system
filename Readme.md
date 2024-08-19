# Stock Management System

The **Stock Management System** is a Spring Boot application designed to manage stock orders, incorporating modern technologies such as Kafka for messaging and GraphQL for flexible API queries. This application is structured for scalability, maintainability, and ease of deployment, making it suitable for both development and production environments. The system follows established design patterns like **Service**, **Repository**, and **Singleton** to ensure clean code architecture and maintainability.
## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
    - [Running the Application](#running-the-application)
- [API Documentation](#api-documentation)
- [Testing](#testing)
- [License](#license)

## Features
- **Real-Time Stock Data**: Fetches real-time stock data using the `Alpha Vantage` API to ensure up-to-date information for trading operations.
- **Stock Order Management**: Create, read, update, and delete stock orders.
- **Kafka Integration**: Utilizes Kafka for handling asynchronous messaging and order processing.
- **GraphQL API**: Offers flexible querying capabilities via GraphQL.
- **Docker Compose Support**: Easily deployable in a containerized environment using Docker.
- **In-memory Database**: Uses H2 for rapid development and testing.


## Technologies Used

- **Java 8+**
- **Spring Boot**
- **Spring Data JPA**
- **Kafka**
- **GraphQL**
- **Maven**
- **Docker & Docker Compose**
- **H2 Database**
- **JUnit**

## Getting Started

### Prerequisites

- **Java 8+** 
- **Maven** 
- **Docker** installed if you want to run the project in a containerized environment.

### Installation

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-username/stock-management-system.git
   cd stock-management-system
   ```

2. **Build Project**:
    ```bash
   ./mvnw clean install
   ```
3. **Run Unit Tests**:
 ```bash
    ./mvnw test
```

### Running the Application
1. **Using Maven**:
    ```bash
   ./mvnw spring-boot:run
    ```
2. **Ensuring Docker Compose**:
- Ensure Docker is running on your machine
- Start the application
    ```bash
   docker-compose up --build
    ```
## API Documentation

### Current REST Endpoints:
- GET /orders: Retrieve all stock orders.
- POST /orders: Create a new stock order.
- PUT /orders/{id}: Update an existing stock order.
- DELETE /orders/{id}: Delete a stock order.

## Testing

The project includes unit and integration tests to ensure functionality:

- **Unit Tests**: Located in the src/test/java directory, focusing on service and repository layers.
- **Integration Tests**: Tests that involve Kafka messaging and GraphQL queries.

## License
This project is licensed under the MIT License - see the LICENSE file for details.
