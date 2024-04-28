BDDFrameworkNaukri
Cucumber BDD Selenium Framework

What all tools are used in this project?

Cucumber
TestNG
Maven
Page Object Model design pattern
Extent Report
Cucumber Reporting (custom)
Packages Hierarchy - Main package: Utils --> DriverManager = contains driver initialization and other commonly used functions

Pages --> Page classes - Contains locators and getter/setters for each webpage

Test package:

Runner - Helps to run the test classes

Steps - Actual Code mapping for each feature

Feature - Contains feature files with respect to each test plan (or scenario preparation)

Resources - Contains basics cucumber report mappings and extent reports mapping.

TestNG.xml = can be used for execution or for parallel testing

POM.xml - heart of project - contains all the dependencies required by the project.

NOTE1 = Runner file is mapped for parallel testing so use it as required.

# Run tests
    mvn clean test 
    -Ddriver=chrome
    -Dglobal.username="username"
    -Dglobal.password="password

# Maven params
    driver: chrome or firefox

