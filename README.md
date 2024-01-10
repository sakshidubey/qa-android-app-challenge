
# APPIUM CHALLENGE

This repository contains regression test cases for an Android APP. It is created by using Cucumber, Appium. It also generate HTML report at the end of the execution with screenshots.

- Framework Architecture Overview: 
	
	https://excalidraw.com/#json=AQ6nWdsx1lPAAOls4hbUQ,OTP6NgTWzPGVClhdf9EU_Q
	
## Framework Description

1. It is using BDD approach so that anyone can understand the intent of tests and also have tagging facility to separate our feature execution based on different tags (app_regression, @long_press etc based on feature)

2. Used Page Object Model to store page locators based on different screens of an APP.

3. JUnit4 is being used for running tests and creating assertions in tests.

4. It uses different properties file based on execution environment passed at runtime, getting load at runtime to get username and password of a (dev or prod)app and other properties too.

5. @Before hook intialize the driver and loads the respective properties file based on environment variable value.

6. It uses pico-container library for dependency injection.

7. Created MobileFunctionUtility class to have all generic function at a single place for the reusability purpose.

8. Created common page object and step definition class to place objects and steps that are going to common for all the screen.

For more, please refer the above link.


## Installation (pre-requisites)

    1. JDK 1.8+ (make sure Java class path is set)
    2. Maven (make sure .m2 class path is set)
    3. Appium java client (in this project used 7.2.0 version)
    4. Android emulator should be up and running (ABI should be x86 selected)
    5. Appium Server should be up and running
    
## Framework Setup

    1. git clone git@github.com:sakshidubey/qa-android-app-challenge.git
    2. git pull
    
## Running Tests

To run tests, run the following command

  - mvn clean install -DskipTests
  - mvn test -Denvironment=environment -Dappname=app-name -D"cucumber.filter.tags=@tagName"  
  - Example : mvn test -Denvironment=dev -Dappname=appiumChallenge -D"cucumber.filter.tags="@app_regression"


This framework used environment variable value to pick properties file for the execution, which consists information based on environment like user credentials :

    - prod
    - dev 

And used tagName to run specific tests:
	
	-@app_regression - Run both all the tests
	-@long_press - To run only test for a long press
	-other feature tag is also present
	-we can use sanity tag as well to run mutlitple feture tests that will be the subset of @app_regression tag
	

## Execution Report

At the end of the execution, the HTML report will be available on the following path :

    {/ExtentReports/SparkReport_/Reports/Spark.html}

Reports are generated based on timestamp.
