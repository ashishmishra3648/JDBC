# Student Management System

A simple Java console application for managing student records (CRUD operations) using PostgreSQL as the database. This project demonstrates the use of JDBC for connecting Java applications to relational databases, with robust input validation.

---

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Setup Instructions](#setup-instructions)
- [How to Run](#how-to-run)
- [Usage](#usage)
- [Troubleshooting](#troubleshooting)
- [License](#license)

---

## Features

- **Add Student:** Input student ID, name, and age, and save to the database.
- **Update Student:** Update existing student information by ID.
- **View All Students:** Fetch and display all student records.
- **Delete Student:** Delete a student record by ID.
- **Input Validation:** Handles invalid inputs gracefully.
- **Database Connection Management:** Proper closing of database connections.

---

## Technologies Used

- Java SE (JDK 17+ recommended)
- PostgreSQL Database
- JDBC API (Java Database Connectivity)

---

## Project Structure
school/
├── entity/
│ └── Student.java
├── service/
│ └── StudentService.java
└── driver/
└── StudentDriver.java


- `Student.java` — Entity class representing the student record.
- `StudentService.java` — Handles all database operations via JDBC.
- `StudentDriver.java` — Main class providing a console-based interactive menu.

---

## Setup Instructions

### 1. Install Java

Download and install Java JDK 17 or higher from [Oracle](https://www.oracle.com/java/technologies/javase-downloads.html) or [AdoptOpenJDK](https://adoptium.net/).

### 2. Install PostgreSQL

Set up PostgreSQL from [here](https://www.postgresql.org/download/) and ensure the server is running.

### 3. Add PostgreSQL JDBC Driver

- **Maven:**

### 4. Create Database and Table : 
CREATE DATABASE school;
\c school
CREATE TABLE student1 (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    age INT
);


### 5. Output :
WELCOME TO TECHNO SCHOOL

Enter 1 to Save Student data

Enter 2 to Update Student data

Enter 3 to Fetch All Student data

Enter 4 to Delete Student data

Enter 5 to Close application

Enter your choice:

