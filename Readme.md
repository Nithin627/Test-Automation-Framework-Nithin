
# Test Automation Framework – Java + TestNG

This project is a Java-based test automation framework designed for scalable, maintainable, and efficient UI/API testing. It supports data-driven testing, cloud execution, and headless execution to optimize performance and flexibility. The framework is built using modern tools and best practices to simulate real-world enterprise-level automation solutions.


## 🚀 About Me
Hi, My name is Nithin P and I have 3 years of experience in Automation Testing using technologies like Selenium WebDriver, RestAssured.

My major experties in Java programming Languge.


## Authors

- [@Nithin](https://github.com/Nithin627/)
- EmailAddress : nithinpadyur@gmail.com


## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/Nithin627/)

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](www.linkedin.com/in/nithinp2000)



## Prerequisites

Before setting up and running the framework, ensure the following tools and configurations are available on your system:

- **Java Development Kit (JDK) 11**
- **Apache Maven** - Used for dependency management and test execution  
  - Download Link: https://maven.apache.org/download.cgi
- **Web Browsers** - 
    - Google Chrome 
    - Mozilla Firefox 
- **IDE** 
    - IntelliJ IDEA / Eclipse for development and debugging
- **Environment Variables (For LambdaTest)** 
    - To execute tests on cloud using LambdaTest
- **Optional Dependencies**
    - Git
- **OpenCV Setup** 
    - Required if image-based testing is used, Ensure native libraries are configured properly

## Features
- **Data-Driven Testing** 
    - Supports test data from
        - Excel files (Apache POI)
        - JSON files (Gson)
    - Dynamic test execution using external datasets
- **Cloud Execution (LambdaTest)**
    - Run tests on multiple browsers and OS combinations
    - Scalable cross-browser testing
- **Headless Execution**
    - Faster test execution without UI rendering
    - Useful for CI/CD pipelines
- **Configurable Execution via CLI**
    - Supports runtime parameters:
       - browser
       - isLambdaTest
       - isHeadless
- **Logging & Reporting**
    - Extent Reports → Detailed HTML reports (reports.html)
    - Log4j Logs → Stored under /logs directory
- **Fake Data Generation**
    - Uses Faker library for dynamic and realistic test data

## Technologies used
  - Java 11
  - TestNG
  - OpenCSV
  - Gson
  - Apache POI
  - Faker
  - LambdaTest
  - Log4j
  - Extent Reports
## Setup Instructions

**Clone the repository**

```bash
  git clone https://github.com/Nithin627/Test-Automation-Framework-Nithin.git

  cd Test-Automation-Framework-Nithin
```

**Cloud Execution (LambdaTest)**

```bash
  mvn clean test -Dbrowser=chrome -DisLambdaTest=true -DisHeadless=false -X
```

**Local Execution (Headless)**

```bash
  mvn clean test -Dbrowser=chrome -DisLambdaTest=false -DisHeadless=true -X
```


## Reports
 - **Extent Report**
    - Generated after execution
    - File: reports.html
    - Contains:
        - Test steps
        - Screenshots 
        - Pass/Fail status
- **Logs** 
    - Location: /logs
    - Captures:
          - Execution flow
          - Errors & debugging info


## Integrated Project with github Actions 
   - This automation framework is integrated with the GitHub Actions
   - The test will be executed at 11:30 PM IST every single day
   - The reports will be archived in gh-pages branch
   - We can view the html report at: https://nithin627.github.io/Test-Automation-Framework-Nithin/report.html
   
