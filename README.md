# API Testing Framework

A robust and scalable API testing framework built with **TestNG**, **Gradle**, and **RestAssured**, designed for reliability and parallel execution.

## 📌 Features
- **RestAssured-powered** - Fluent API testing with built-in assertions
- **Multi-threaded execution** - Run tests in parallel (configurable thread count)
- **Environment-flexible** - Test against different base URLs
- **TestNG integration** - Full support for TestNG features (data providers, groups, etc)
- **Gradle build system** - Easy dependency management and task configuration

## 🚀 Quick Start

### Prerequisites
- Java JDK 11+
- Gradle 8.12+

### Installation
1. Clone the repository:
   git clone https://github.com/AndreyLysov/s-test-task.git
   cd s-test-task

### Running Tests
2. Run all tests

   ./gradlew test

   Run with custom config

   ./gradlew test -Purl=https://127.0.0.1/ -PthreadCount=666

### Reporting
3. Generate Allure report

   allure generate && allure open