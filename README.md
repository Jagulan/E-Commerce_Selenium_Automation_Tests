# Automated Web Testing and Performance Analysis for JPetStore

![Selenium Logo](https://img.shields.io/badge/Selenium-43B02A?style=for-the-badge&logo=selenium&logoColor=white)
![Java Badge](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white)
![JUnit Badge](https://img.shields.io/badge/JUnit-25A162?style=for-the-badge&logo=junit5&logoColor=white)
![Maven Badge](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![JMeter Badge](https://img.shields.io/badge/Apache%20JMeter-555555?style=for-the-badge&logo=apache-jmeter&logoColor=white)

## 💡 Overview

This repository showcases a comprehensive approach to web application testing, integrating **Selenium WebDriver** for functional automation and **Apache JMeter** for performance analysis. The project focuses on ensuring the quality and responsiveness of the JPetStore demo application.

It demonstrates proficiency in designing and executing various test types, analyzing performance metrics, and reporting findings, all within an Agile (Test-Driven Development) mindset. This project was completed as part of an academic assignment, providing practical experience in robust testing methodologies.

## ✨ Key Features & Methodologies

### Functional Automation with Selenium & JUnit

* **Core Scenarios Automated:** Implemented automated tests for critical user flows including:
    * **User Registration:** Covers new user sign-up, including filling out all account details and preference settings.
    * **Account Updates:** Tests the modification of user account details like email and phone number.
    * **Product Checkout:** Simulates the process of signing in, selecting a pet (e.g., Persian cat), adding to cart, and completing the checkout process.
    * **Stock Verification:** Tracks and asserts changes in product stock levels before and after a purchase.
* **Test-Driven Development (TDD):** Functional tests were designed with a TDD approach, ensuring testability and coverage.
* **Robust Element Locators:** Utilized various Selenium locators (link text, name, XPath) for reliable element identification.
* **Assertions with JUnit:** Employed JUnit assertions for validating expected outcomes in test cases, ensuring test integrity.

### Performance Testing with Apache JMeter

* **Load Simulation:** Conducted performance tests with varying user loads (1, 10, 50, and 100 virtual users) to assess system behavior under stress.
* **Key Performance Indicators (KPIs) Monitored:** Analyzed average response times, median, 90th, 95th, and 99th percentile lines, minimum/maximum times, error rates, and throughput for critical pages (home, register, sign-in, product pages, cart).
* **Detailed Reporting:** Generated comprehensive JMeter analysis reports showcasing performance trends and identifying potential bottlenecks.

## 🚀 Technologies Used

* **Java:** Primary programming language for Selenium test automation.
* **Selenium WebDriver:** For automating browser interactions and functional testing.
* **JUnit 5:** Testing framework for structuring and executing automated test cases.
* **Apache Maven:** Build automation tool for dependency management and project compilation.
* **Apache JMeter:** Open-source software used for load testing and performance measurement.
* **`WebDriverManager` (Optional, but implemented):** Streamlines browser driver setup, enhancing test portability and ease of execution.
* **JPetStore Demo Application:** The web application under test (`https://petstore.octoperf.com/`).

## 🛠️ Installation & Setup

To set up and run the automated tests and analyze performance reports locally:

### Prerequisites

* Java Development Kit (JDK) 11 or higher.
* Apache Maven.
* Google Chrome browser (or other browsers if you wish to extend the tests).
* (Optional for performance analysis) Apache JMeter.

### Steps

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/Jagulan/Selenium_Web_Automation_Testing.git](https://github.com/Jagulan/Selenium_Web_Automation_Testing.git)
    ```
2.  **Navigate to the project directory:**
    ```bash
    cd Selenium_Web_Automation_Testing
    ```
3.  **Build the project and download dependencies:**
    ```bash
    mvn clean install
    ```
    *(`WebDriverManager` will automatically handle browser driver downloads for Selenium.)*
4.  **Run Selenium Functional Tests:**
    * From your IDE (e.g., IntelliJ IDEA, Eclipse), right-click on the `src/test/java/org/example` directory and select "Run Tests" or run individual test classes (e.g., `RegisterUserTest.java`, `ProcceedToCheckoutTest.java`, `updateAccountTest.java`, `updateStockTest.java`).
    * Alternatively, from the terminal in the project root:
        ```bash
        mvn test
        ```
    * **Important Note:** The `RegisterUserTest.java` test creates a user with `s3881257` username and `RMIT1` password. For `ProcceedToCheckoutTest` and `updateAccountTest` to pass consistently, this user needs to be registered beforehand. Consider updating the `RegisterUserTest` to ensure it passes before other tests are run or managing test data more robustly.

## 📊 Test Results & Reports

Detailed reports generated from this project are available in the repository.

* **Selenium Test Reports (`s3881287-Selenium-Report.pdf`):**
    * These reports provide a comprehensive overview of functional test execution, including pass/fail status, test case details, and requirement coverage.
    * Individual test case reports confirm execution status ("Passed" for most, some "Failed" with stack traces indicating element location issues, which is valuable for debugging).
    * Requirement coverage shows how tests map to user stories (e.g., "user wants to check how to buy a fish and buy a fish", "Registering a new user", "update Account details", "Order and checkout", "Update Stock" ).

* **JMeter Performance Analysis (`s3881257-Jmeter_Analaysis.pdf`):**
    * Provides raw data and aggregated results from load tests with 1, 10, 50, and 100 users.
    * Key metrics captured include:
        * **Average Response Time:** Indicating the typical time taken for a request.
        * **Throughput:** Requests per second, demonstrating system capacity.
        * **Error Rate:** (0% for all reported tests, which is excellent for a functional perspective).
        * **Percentile Lines:** Showing the response times for a given percentage of requests (e.g., 90% of requests completed within X ms).

## 📞 Contact

Feel free to reach out if you have any questions, want to discuss test automation strategies, or are looking to collaborate!

* **LinkedIn:** [linkedin.com/in/jagulans](https://linkedin.com/in/jagulans)
* **Email:** `gsjagulan@outlook.com`

