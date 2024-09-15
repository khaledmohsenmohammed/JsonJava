# Business Database Project

## Project Overview

This project demonstrates the creation of a simple database for managing customer purchase information for different courses. The database tracks the course name, purchase date, amount, and customer location. The SQL script provided will help set up the database, create a table, and populate it with sample data.

## Prerequisites

Before running the SQL commands, ensure you have:

- A MySQL or compatible relational database management system (RDBMS) installed.
- Basic knowledge of SQL.
  
## Instructions

### 1. Setting up the Database

Use the following SQL command to create the database `Business`:

```sql
CREATE DATABASE Business;
USE Business;
````
## 2. Creating the `CustomerInfo` Table

After creating the database, create the `CustomerInfo` table, which will store information about customer purchases:

```sql
CREATE TABLE CustomerInfo
(
  CourseName varchar(50),
  PurchasedDate date,
  Amount int(50),
  Location varchar(50)
);
```
## 3. Inserting Sample Data
Insert sample records into the CustomerInfo table:

```sql
INSERT INTO CustomerInfo VALUES ("selenium", CURRENT_DATE(), 120, 'Africa');
INSERT INTO CustomerInfo VALUES ("Protractor", CURRENT_DATE(), 45, 'Africa');
INSERT INTO CustomerInfo VALUES ("Appium", CURRENT_DATE(), 99, 'Asia');
INSERT INTO CustomerInfo VALUES ("WebServices", CURRENT_DATE(), 21, 'Asia');
INSERT INTO CustomerInfo VALUES ("Jmeter", CURRENT_DATE(), 76, 'Asia');
```
## 4. Running Queries
To view all the data in the CustomerInfo table, use the following query:
```sql
SELECT * FROM CustomerInfo;
```
To filter data by location and purchase date, use the following query:
```sql
SELECT * FROM CustomerInfo WHERE Location = 'Asia' AND PurchasedDate = CURDATE();
```

##5. Advanced Query Examples
To view all the data in the CustomerInfo table, use the following query:
To fetch a specific record for purchases made in Asia on a given date, replace the PurchasedDate with the appropriate date (e.g., 2024-09-13):

```sql
SELECT * FROM CustomerInfo WHERE Location = 'Asia' AND PurchasedDate = '2024-09-13';
```
You can also limit the results to only one record:
```sql
SELECT * FROM CustomerInfo WHERE Location = 'Asia' AND PurchasedDate = '2024-09-13' LIMIT 1;
```




