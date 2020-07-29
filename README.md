# RegistrationSuiteTest
This Project is for testing the registration page of a specific website using automation framework.

# Installation 
The project used the following installations:
* Java 14.
* Eclipse java 2018-19.
* Selenium, Maven & TestNG plugin.
# Requirements
* The project requires to design an automation framework to test the registration process in PHPTravels [website](https://www.phptravels.net/register)
* The framework must be with an object-oriented design with no hard codes.
* It is required also to implement customized reports with screenshots of failures.
# Solution Concept
* The solution used an OOP design to simulate the user action on a specific page by creating classes and methods. Then, A test scenario is created to simulate the user behaviors on the pages. With the data driven techniques, dozens of test cases can be created easily.
* In designing test cases, positive and negative cases were taken in consideration to take care of all the requirements for the elements. Finally, Maven & TestNg were used to allow global and easier ways in the framework design
# Features
* The project is in data driven framework to allow easier way for creating or changing testcases
* The Project is OOP-based structured.
* Customized reports & Screenshoots is automatically generated
* All Assertions and Exceptions were recovered.
* The Framework can be work on any other website with only little customizations for the elements.
* Maven is used to make the project well-structured with all the libraries and drivers needed.
* TestNG is used to run the class contain the test suite.
# Limitations
* The project will run only with Chrome, Firefox, Internet Explorer (Chrome is the default).
* If you want to work with another browser u should add its driver in the driver folder and declare it in the TestBase class.
