💼 Java Employee Database App (JDBC + MySQL)

📌 Description

A simple Java console application to manage an employee database using JDBC and MySQL.

This app demonstrates:
- Java JDBC connectivity with MySQL
- Use of `Connection`, `PreparedStatement`, `ResultSet`
- Full CRUD operations: Add, View, Update, Delete employees


🧰 Tools & Technologies

- Java (JDK 11+)
- MySQL Server & MySQL Workbench
- MySQL Connector/J (`mysql-connector-java-X.X.X.jar`)
- IntelliJ IDEA / VS Code / Eclipse
- Terminal / Command Prompt

✨ Features

✅ Add Employee

🔍 View All Employees

✏️ Update Employee Details

❌ Delete Employee Record



💾 Database Setup

1️⃣ Create Database & Table

sql
CREATE DATABASE EmployeeDB;

USE EmployeeDB;

CREATE TABLE Employee (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  department VARCHAR(100),
  salary DOUBLE
);

2️⃣ Add some test data (optional)

INSERT INTO Employee (name, department, salary)
VALUES ('Alice', 'Engineering', 75000.00);

🔗 JDBC Connection Details
DB_URL  = jdbc:mysql://localhost:3306/EmployeeDB
DB_USER = root
DB_PASS = YOUR_MYSQL_PASSWORD

Make sure:

MySQL is running
mysql-connector-java-X.X.X.jar is added to your project libraries (Project Structure > Libraries).

👨‍💻 Author
Nanda Kumar V — Java Developer Intern
