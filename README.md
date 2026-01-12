![Java](https://img.shields.io/badge/Java-8+-orange)
![Maven](https://img.shields.io/badge/Maven-Build-blue)
![Selenium](https://img.shields.io/badge/Selenium-WebDriver-green)
![TestNG](https://img.shields.io/badge/TestNG-Framework-red)
![CI](https://img.shields.io/badge/CI-Jenkins-brightgreen)
![Status](https://img.shields.io/badge/Build-Passing-success)



# E-Commerce Website Automation Framework

This project is a Selenium WebDriver-based automation framework built to validate end-to-end user workflows of an e-commerce web application.  
It is designed with scalability, maintainability, and CI/CD readiness in mind.

🔗 Application Under Test: https://rahulshettyacademy.com/client

---

## 🚀 Project Overview

The framework automates critical e-commerce scenarios including:
- User authentication
- Product listing validation
- Add-to-cart functionality
- Checkout and order placement
- Order confirmation validation

It follows industry best practices such as Page Object Model (POM), explicit waits, configuration-driven execution, and CI integration.

---

## 🛠 Tech Stack

- **Programming Language:** Java  
- **Automation Tool:** Selenium WebDriver  
- **Test Framework:** TestNG  
- **Build Tool:** Maven  
- **CI/CD:** Jenkins  
- **Reporting:** Extent Reports  
- **Version Control:** Git & GitHub  

---

## 🧩 Framework Design

- Page Object Model (POM) for clean separation of test logic and UI locators
- Reusable utility classes for waits, configuration management, and common actions
- TestNG annotations for structured execution, grouping, and retries
- Classpath-based configuration loading for CI-safe execution

---

## 🧪 Test Coverage

The framework includes the following test suites:

- **Smoke Tests**
  - Login functionality
  - Product visibility validation

- **Regression Tests**
  - Add-to-cart validation
  - Cart and checkout flow

- **End-to-End (E2E) Tests**
  - Complete purchase flow from login to order confirmation

---

###  Jenkins Pipeline

The project includes a Jenkinsfile for pipeline-as-code implementation.

Pipeline features:
- Parameterized build for dynamic suite selection
- Maven-based test execution
- Automated HTML report publishing
- GitHub-based source control integration

---

## 📸 Sample Report

Extent Report generated after execution, showing test steps, status, and screenshots on failure.

---

## 📁 Project Structure

```text
src
├── main
│   └── java
│       └── utilities
├── test
│   ├── java
│   │   ├── base
│   │   ├── pages
│   │   ├── tests
│   │   └── listeners
│   └── resources
│       └── config.properties


