# **User Microservice**

This project is a **User Microservice** built with **Spring Boot 3.4** and **PostgreSQL**. It provides RESTful APIs for managing user entities (create, read, update, and delete). The application uses **JPA** for database interaction, and all credentials are stored securely in an `.env` file, which is excluded from version control.

## **Table of Contents**
- [**User Microservice**](#user-microservice)
  - [**Table of Contents**](#table-of-contents)
  - [**Features**](#features)
  - [**Project Structure**](#project-structure)
  - [**Prerequisites**](#prerequisites)
  - [**Setup**](#setup)
    - [**Clone the repository**](#clone-the-repository)
    - [**Configure environment variables**](#configure-environment-variables)
    - [**Run PostgreSQL**](#run-postgresql)
    - [**Run the application**](#run-the-application)
  - [**API Documentation**](#api-documentation)
    - [**User API Endpoints**](#user-api-endpoints)
    - [**API Endpoints**](#api-endpoints)
    - [**Example POST Request (Create a User)**](#example-post-request-create-a-user)
    - [**Example GET Request (Get All Users)**](#example-get-request-get-all-users)
    - [**Example GET Request (Get a User by ID)**](#example-get-request-get-a-user-by-id)
    - [**Example DELETE Request (Delete a User by ID)**](#example-delete-request-delete-a-user-by-id)
  - [**Docker Setup (Optional)**](#docker-setup-optional)
    - [**Build Docker Image**](#build-docker-image)
    - [**Run the Docker Container**](#run-the-docker-container)

---

## **Features**
- REST API with CRUD operations for managing users.
- PostgreSQL integration using Spring Data JPA.
- Credentials and sensitive data stored in an `.env` file, excluded from version control.
- Configurable via `application.properties` or `application.yml`.
- Optional support for Docker containerization.

---

## **Project Structure**

```plaintext
user-microservice/
├── .env                      # Environment file for credentials (ignored in VCS)
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── usermicroservice/
│   │   │               ├── controller/          # REST API Controllers
│   │   │               ├── service/             # Business logic
│   │   │               ├── repository/          # Data access layer (Repositories)
│   │   │               ├── entity/              # Database entities
│   │   │               ├── config/              # Application configuration
│   ├── resources/
│   │   ├── application.properties               # Default configuration
│   │   └── application.yml                      # Alternative YAML configuration
├── .gitignore               # Ensures .env and target are ignored
├── pom.xml                  # Project dependencies (Maven)
├── Dockerfile               # Optional: For containerization
└── README.md                # Project documentation for GitHub

```



## **Prerequisites**

Ensure you have the following installed on your system:
- **Java 17** or later
- **Maven** (for dependency management)
- **PostgreSQL** (for database management)

---

## **Setup**

### **Clone the repository**

First, clone the repository to your local machine:

```bash
git clone https://github.com/yourusername/user-microservice.git
cd user-microservice

``` 
### **Configure environment variables**

Create an `.env` file at the root of the project and add your PostgreSQL credentials:

```bash
touch .env
``` 

### **Run PostgreSQL**

Ensure PostgreSQL is running and create a database:

```sql
CREATE DATABASE userdb;
```

### **Run the application**

Run the following Maven command to start the Spring Boot application:

```bash
mvn spring-boot:run
``` 

---

## **API Documentation**
### **User API Endpoints**

Here are the main endpoints for the User Microservice:

- **POST /api/users**: Create a new user.
- **GET /api/users**: Retrieves a list of all users.
- **GET /api/users/{id}**: Retrieves a user by ID.
- **DELETE /api/users/{id}**: Delete a user.
- **UPDATE /api/users/{id}**: Update a user by ID.

### **API Endpoints**

| Method | Endpoint             | Description                    | Request Body                                                        |
|--------|-----------------------|--------------------------------|--------------------------------------------------------------------|
| POST   | `/api/users`          | Create a new user              | `{ "name": "John", "email": "john@example.com", "password": "pass123" }` |
| GET    | `/api/users`          | Get all users                  | N/A                                                                |
| GET    | `/api/users/{id}`     | Get a user by ID               | N/A                                                                |
| DELETE | `/api/users/{id}`     | Delete a user by ID            | N/A                                                                |
| PUT    | `/api/users/{id}`     | Update a user by ID            | N/A

---



### **Example POST Request (Create a User)**

```bash
POST /api/users
Content-Type: application/json
{
  "name": "John Doe",
  "email": "john@example.com",
  "password": "securepass"
}
```

### **Example GET Request (Get All Users)**
```bash
GET /api/users
```
### **Example GET Request (Get a User by ID)**
```bash
GET /api/users/1
```
### **Example DELETE Request (Delete a User by ID)**
```bash
DELETE /api/users/1
```


## **Docker Setup (Optional)**

You can optionally containerize the application using **Docker**.

### **Build Docker Image**

1. Ensure Docker is installed.
2. Build the Docker image for the user microservice:

```bash
docker build -t user-microservice .
```

### **Run the Docker Container**

Run the container with the following command:

```bash
docker run -d -p 8080:8080 --env-file .env user-microservice
```
This will start the microservice in a Docker container, mapping it to port 8080.