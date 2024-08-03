# Task Management System API

This project is a RESTful API for a task management system built with Java Spring Boot. It provides user authentication, task CRUD operations, task assignment, and advanced filtering and searching capabilities.

## Features

- User Registration and Authentication
- CRUD operations for tasks
- Task assignment to users
- Filtering and searching tasks
- Dockerized application

## Technologies Used

- Java 17
- Spring Boot
- MySQL
- Hibernate ORM
- Docker

## Requirements

1. User Registration and Authentication
   - Register with username and password
   - Secure password hashing

2. Task Management
   - Task fields: id, title, description, status, priority, due date, created at, updated at, user id
   - CRUD operations for tasks
   - Task assignment to users

3. Filtering and Searching
   - Filter tasks by status, priority, and due date
   - Search tasks by title or description

4. Dockerization
   - Dockerfile for containerization
   - docker-compose.yml for easy setup

5. Database
   - MySQL for data storage
   - Hibernate ORM for database operations

## Prerequisites

- Java 17
- Maven
- Docker
- Docker Compose

## Getting Started

### Clone the Repository

git clone https://github.com/sparshvarun/taskapp.git
cd taskapp

Build the Application
mvn clean install

Run the Application with Docker Compose
docker-compose up --build

Access the Application
Open your browser and navigate to http://localhost:8090.

Additional Information
The application will be accessible on port 8090.
The MySQL database will be accessible on port 3306.
