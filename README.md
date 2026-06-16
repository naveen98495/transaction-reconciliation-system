## 🚀 Enterprise Transaction Reconciliation Platform

A full-stack enterprise-grade transaction reconciliation platform designed to automate transaction validation, reconciliation, monitoring, and reporting between uploaded transaction records.

The system enables organizations to efficiently manage financial transactions, identify mismatches, analyze reconciliation results, and monitor transaction health through an interactive dashboard.

---

## 📌 Project Highlights

✔ Secure JWT Authentication & Authorization

✔ CSV Transaction Upload & Processing

✔ Automated Transaction Reconciliation

✔ Advanced Transaction Search

✔ Reconciliation Analytics Dashboard

✔ RESTful API Architecture

✔ Swagger API Documentation

✔ PostgreSQL Database Integration

✔ Responsive React Frontend

---

## 🎯 Business Problem

Organizations often receive transaction records from multiple sources. Manually validating and reconciling these records is time-consuming and prone to errors.

This platform automates the reconciliation process by validating uploaded transaction data, identifying mismatches, generating reconciliation summaries, and providing real-time visibility through an interactive dashboard.

---

## 🏗 System Architecture

React Frontend
       │
       ▼
Spring Boot REST APIs
       │
       ▼
PostgreSQL Database

---

## ✨ Features

Authentication Module

- User Registration
- User Login
- JWT Token Generation
- Protected APIs
- Role-Based Access Control

Transaction Management

- Upload Transactions via CSV
- View Transaction Records
- Search Transactions
- Update Transactions
- Delete Transactions

Reconciliation Engine

- Automatic Transaction Matching
- Reconciliation Summary Generation
- Transaction Validation
- Exception Identification

Dashboard & Analytics

- Reconciliation Overview
- Transaction Statistics
- Monitoring Dashboard
- Search & Filtering

---

## 🛠 Technology Stack

Backend

- Java 17
- Spring Boot
- Spring Security
- JWT Authentication
- PostgreSQL
- Maven
- Swagger OpenAPI

Frontend

- React JS
- JavaScript
- HTML5
- CSS3

Development Tools

- IntelliJ IDEA
- VS Code
- Postman
- Git
- GitHub

---

## 📂 Repository Structure

transaction-reconciliation-system
│
├── backend
│   ├── controller
│   ├── service
│   ├── repository
│   ├── entity
│   ├── dto
│   ├── config
│   └── security
│
├── frontend
│   ├── src
│   ├── public
│   └── components
│
├── screenshots
│
├── docker-compose.yml
├── Dockerfile
├── pom.xml
└── README.md

---

## 📸 Application Screenshots

Dashboard

"Dashboard" (screenshots/dashboard.png)

Transaction Search

"Transaction Search" (screenshots/Search%20transactions.png)

Transaction Records

"Transaction Records" (screenshots/transaction%20records.png)

CSV Upload

"CSV Upload" (screenshots/Csv%20file%20upload_Edited.png)

Swagger Documentation

"Swagger" (screenshots/swagger%20page.png)

---

## 🎥 Project Demonstration

Demo Video

"▶ Watch Full Project Demo" (https://drive.google.com/file/d/1IFQcNwG1xnjCal4EXbDajM6WUZ8TruD0/view?usp=drivesdk)

---

## 📑 API Documentation

Swagger UI:

http://localhost:9091/swagger-ui/index.html

---

## 🔐 Authentication APIs

Register User

POST /auth/register

Login User

POST /auth/login

---

## 💳 Transaction APIs

Upload Transactions

POST /transactions/upload

Get Transactions

GET /transactions

Search Transactions

GET /transactions/search

Reconciliation Summary

GET /transactions/reconciliation-summary

---

## 🔒 Security Features

- JWT Token Authentication
- Role-Based Access Control (RBAC)
- Secure API Endpoints
- Password Encryption
- Authentication Filters
- Global Exception Handling

---

## ⚙ Backend Setup

cd backend
mvn clean install
mvn spring-boot:run

Backend URL

http://localhost:9091

---

## 🎨 Frontend Setup

cd frontend
npm install
npm start

Frontend URL

http://localhost:3000

---

## 🚀 Future Enhancements

- Export Reports to Excel
- Email Notifications
- Audit Logging
- Cloud Deployment
- Advanced Analytics Dashboard
- Multi-Tenant Support
- Microservices Architecture

---

## 👨‍💻 Author

Naveen Amalakanti

## 📧 Email

naveenamalakanti07@gmail.com

## 🔗 LinkedIn

https://www.linkedin.com/in/naveen-amalakanti

## 💻 GitHub

https://github.com/naveen98495

---

## 📄 License

This project is developed for educational, portfolio, and demonstration purposes.