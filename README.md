# 🚀 Transaction Reconciliation System

«A full-stack transaction reconciliation platform built with Spring Boot 3, React, PostgreSQL, JWT Authentication, Docker, and Swagger/OpenAPI to automate financial transaction processing, validation, and reconciliation.»

"Java" (https://img.shields.io/badge/Java-17-orange)
"Spring Boot" (https://img.shields.io/badge/Spring%20Boot-3.3.5-brightgreen)
"PostgreSQL" (https://img.shields.io/badge/PostgreSQL-Neon-blue)
"React" (https://img.shields.io/badge/React-Frontend-61DAFB)
"JWT" (https://img.shields.io/badge/JWT-Authentication-red)
"Docker" (https://img.shields.io/badge/Docker-Containerization-2496ED)
"Swagger" (https://img.shields.io/badge/Swagger-OpenAPI-green)
"License" (https://img.shields.io/badge/License-MIT-lightgrey)

---

## 📖 Overview

Transaction reconciliation is a critical process in banking, fintech, payment gateways, and enterprise financial systems. Organizations receive transaction records from multiple sources, making manual verification slow, repetitive, and prone to human error.

This project automates that workflow by providing secure REST APIs to upload transaction data, store it in PostgreSQL, retrieve records, and expose documented APIs through Swagger. The application also includes JWT-based authentication and a responsive React frontend for interacting with the backend.

The project demonstrates modern backend development practices using Spring Boot, REST APIs, database integration, authentication, Docker, and API documentation.

---

## 🎯 Business Problem

Financial organizations process thousands of transactions every day. Verifying these transactions manually is inefficient and can lead to inconsistencies, duplicate entries, and reconciliation delays.

This system helps automate transaction processing by:

- Uploading transaction records through CSV files
- Storing transaction data in PostgreSQL
- Providing secure APIs for transaction management
- Protecting endpoints using JWT Authentication
- Documenting APIs using Swagger/OpenAPI
- Providing a React-based user interface for easy interaction

---

### ⭐ Key Features

Authentication & Security

- Secure User Registration
- Secure User Login
- JWT Authentication
- Password Encryption
- Protected REST APIs
- Spring Security Integration

Transaction Management

- Upload Transactions using CSV
- Store Transactions in PostgreSQL
- View Uploaded Transactions
- Retrieve Transaction Records
- RESTful CRUD APIs

API Documentation

- Swagger/OpenAPI Integration
- Interactive API Testing
- API Documentation Interface

Frontend

- Responsive React Application
- CSV Upload Interface
- Transaction Listing
- REST API Integration

DevOps

- Docker Support
- Docker Compose Configuration
- Environment Variable Configuration
- Maven Build System

---

## 🏗️ System Architecture

                React Frontend
                      │
                      ▼
          Spring Boot REST APIs
                      │
      Spring Security + JWT Authentication
                      │
                      ▼
          PostgreSQL (Neon Database)

---

## 🌟 Project Highlights

- Built using Spring Boot 3 and Java 17
- Secure JWT-based authentication
- PostgreSQL database integration
- CSV transaction upload functionality
- RESTful API architecture
- Interactive Swagger documentation
- Dockerized application setup
- Responsive React frontend
- Clean layered architecture (Controller → Service → Repository → Database)

---
## 🛠️ Technology Stack

### Backend

- Java 17
- Spring Boot 3.3.5
- Spring Security
- Spring Data JPA
- JWT Authentication
- PostgreSQL (Neon Database)
- Maven
- Swagger / OpenAPI

### Frontend

- React.js
- JavaScript (ES6+)
- HTML5
- CSS3
- Axios

## DevOps & Tools

- Docker
- Docker Compose
- Git
- GitHub
- Postman
- VS Code
- IntelliJ IDEA

---

### 📂 Project Structure

```text
transaction-reconciliation-system/
├── backend/
│   ├── src/main/java/
│   │   ├── config/
│   │   ├── controller/
│   │   ├── dto/
│   │   ├── entity/
│   │   ├── exception/
│   │   ├── repository/
│   │   ├── service/
│   │   └── ReconciliationSystemApplication.java
│   └── src/main/resources/
│       └── application.yml
├── frontend/
│   ├── public/
│   └── src/
├── screenshots/
├── docker-compose.yml
├── Dockerfile
├── pom.xml
├── README.md
└── .env.example
```

---

## ⚙️ Backend Setup

Clone the repository

git clone https://github.com/naveen98495/transaction-reconciliation-system.git

Move into the project

cd transaction-reconciliation-system/backend

Install dependencies

mvn clean install

Run the application

mvn spring-boot:run

Backend runs at:

http://localhost:8080

---

## 🎨 Frontend Setup

Open a new terminal

cd frontend

Install dependencies

npm install

Start React

npm start

Frontend runs at

http://localhost:3000

---

## 🐳 Docker Setup

Build and start all services

docker compose up --build

Stop containers

docker compose down

---

### 🌐 API Documentation

Swagger UI

http://localhost:8080/swagger-ui/index.html

Open the above URL after starting the backend to explore and test all available REST APIs interactively.

---
## 📑 REST API Endpoints

### Authentication APIs

Method| Endpoint| Description
POST| "/auth/register"| Register a new user
POST| "/auth/login"| Authenticate user and generate JWT token

---

### Transaction APIs

Method| Endpoint| Description
POST| "/csv/upload"| Upload transaction records using CSV
GET| "/csv/all"| Retrieve all uploaded transactions
POST| "/transactions"| Create a transaction
GET| "/transactions/paged"| Retrieve paginated transaction records

---

## 🔒 Security Features

- JWT Authentication
- Spring Security
- Password Encryption
- Protected REST APIs
- Authentication Filter
- Global Exception Handling
- Secure Endpoint Configuration

---

## 🗄️ Database

The application uses PostgreSQL (Neon Cloud Database) for persistent transaction storage.

Key entities include:

- User
- TransactionRecord
- BankTransaction

Spring Data JPA and Hibernate handle ORM and database operations.

---

## 📸 Application Screenshots

![Dashboard](screenshots/dashboard.png)

![CSV Upload](screenshots/Csv%20file%20upload_Edited.png)

![Transaction Records](screenshots/transaction%20records.png)

![Transaction Search](screenshots/Search%20transactions.png)

![Swagger Documentation](screenshots/swagger%20page.png)

---

### 🎥 Project Demonstration

Google Drive Demo

https://drive.google.com/file/d/1IFQcNwG1xnjCal4EXbDajM6WUZ8TruD0/view

---

### 💼 Project Use Cases

This project demonstrates practical backend development concepts including:

- Secure Authentication using JWT
- REST API Development
- Database Integration
- CSV File Processing
- API Documentation with Swagger
- Dockerized Deployment
- Full-stack Integration with React

It is suitable as a portfolio project for backend and full-stack software engineering roles.

---
## 🚀 Future Enhancements

The following features are planned for future releases:

- Bank Transaction Upload Module
- Automated Transaction Reconciliation Engine
- Matched / Unmatched Transaction Reports
- Reconciliation Dashboard & Analytics
- Export Reports (Excel / PDF)
- Email Notifications
- Audit Logging
- Role-Based Access Control (RBAC)
- Cloud Deployment (AWS / Azure)
- CI/CD Pipeline using GitHub Actions
- Microservices Architecture

---

## 🤝 Contributing

Contributions are welcome.

If you'd like to improve this project:

1. Fork the repository.
2. Create a feature branch.
3. Commit your changes.
4. Push your branch.
5. Open a Pull Request.

---

## 📌 Learning Outcomes

This project helped strengthen practical knowledge of:

- Java 17
- Spring Boot 3
- Spring Security
- JWT Authentication
- Spring Data JPA
- PostgreSQL
- REST API Development
- Swagger/OpenAPI
- Docker
- React Integration
- Git & GitHub
- Layered Backend Architecture

---

## 👨‍💻 Author

Naveen Amalakanti

B.Tech – Information Technology
MVGR College of Engineering

## 📧 Email

naveenamalakanti07@gmail.com

## 💼 LinkedIn

https://www.linkedin.com/in/naveen-amalakanti

## 💻 GitHub

https://github.com/naveen98495

---

## 📜 License

This project is licensed under the MIT License.

You are free to use, modify, and distribute this project for educational and learning purposes.

---

## ⭐ Support

If you found this project useful:

- ⭐ Star this repository
- 🍴 Fork the repository
- 🐞 Report issues
- 💡 Suggest improvements

---

## 🙏 Acknowledgements

Special thanks to the open-source community and the Spring Boot, PostgreSQL, React, Docker, and Swagger ecosystems for providing the tools and libraries used in this project.

---

## 📈 Project Status

Current Status: Active Development

## Completed

- ✅ Spring Boot Backend
- ✅ PostgreSQL Integration
- ✅ JWT Authentication
- ✅ Spring Security Configuration
- ✅ Swagger/OpenAPI Documentation
- ✅ CSV Upload API
- ✅ CSV Transaction Storage
- ✅ Docker Support
- ✅ React Frontend Integration

## Planned

- 🔄 Bank Transaction Upload
- 🔄 Reconciliation Engine
- 🔄 Dashboard Analytics
- 🔄 Matched / Unmatched Reports
- 🔄 Production Deployment

---

«If this project helped you or you found it interesting, please consider giving it a ⭐ on GitHub.»