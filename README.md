# 🚀 Flipkart Automation Testing Framework

![Build Status](https://img.shields.io/badge/build-passing-brightgreen) ![Coverage](https://img.shields.io/badge/coverage-90%25-yellowgreen)

---

## 📖 Project Description

Automates testing of the Flipkart e-commerce website using **Selenium WebDriver**, **Java**, **TestNG**, and **Maven**, employing the **Page Object Model (POM)** design pattern.  
This framework delivers maintainable, scalable, and robust automation for critical Flipkart flows.

---

## 🏗️ Architecture Overview

<img width="301" height="811" alt="Screenshot 2025-08-31 103859" src="https://github.com/user-attachments/assets/cd266662-50ac-4e7d-8395-7585ffdbdeeb" />


## ✅ Test Case Coverage

### 🔐 Login Module
- Valid login with phone number and password/OTP
- Invalid phone number login attempt
- Verification of Login UI elements for presence and functionality

### 🔎 Product Search & Details
- Searching for electronic items
- Applying filters: RAM size, brand, price range
- Sorting results by popularity or price
- Viewing product details and verifying specifications
- Handling searches without keywords

### 🛒 Cart & Checkout
- Adding products to cart
- Modifying quantity, verifying updates
- Removing items and confirming removal
- Proceeding to buy and verifying address/payment pages
- Attempting to place order without selecting address/payment methods

---

## 🛠 Technology Stack

- Java 1.8+
- Maven
- Selenium WebDriver
- TestNG
- ExtentReports
- Chrome, Firefox, Edge Browsers
1. Clone the repository:  
git clone https://github.com/MONDALaritra/TTP2SPCRM2535_Flipkart.git

text
2. Navigate to the project folder and install dependencies:  
mvn clean install

text
3. Configure WebDriver executables in the `config/` directory or update your system PATH variables.
4. Run the tests using the TestNG suite:  
mvn test -DsuiteXmlFile=testng.xml

text

---

## 🚦 How to Use

- Modify `testng.xml` to select/deselect test scenarios.
- View test reports and logs in the `test-output/` folder.
- Utilize Excel files or config properties for data-driven testing.

---

## 📊 Reporting

- Generates HTML reports through ExtentReports.
- Takes screenshots automatically on test failures.
- Comprehensive logs generated for every test run.
