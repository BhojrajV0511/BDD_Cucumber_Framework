**BDD_Cucumber_Selenium_Java_TestNG Framework**

**Requirements**
* Java
* IntelliJ Idea
* Maven
* Dependencies : 
    1) Cucumber-java
    2) Cucumber-testng
    3) Testng
    4) Selenium-java
    5) WebDiverManager
* Plugins :
    1) maven-surefire-plugin

**Framework Structure**

BDD_Cucumber_Selenium_Java_TestNG Framework
    - src 
        - main
            -java
                - pageObjects
                - util
                    - BaseClass
                    - Utility
                    - Wait
        - test
            - java
                - com
                    - step definitions
                - runner
                    - runner classes
            - resources
                - suites
    - pom.xml
    - testng.xml

* pageObjects :
    - It contains separate class for each webpage.
    - Each class contains WebElement and Methods present on webpage

* util :
    - BaseClass : Methods to perform -
        - Driver initialization
        - Quites driver
        - ThreadLocal is used to manage driver configurations for parallel execution
    - Utility : It contains reusable methods
    - Wait : It contains wait methods for conditions

* step definitions : 
  - It contains implementation methods for feature file

* resources : It contains feature files

* pom.xml : It contains dependencies & plugins

* testng.xml :
    - It is used to execute test scripts
    - We can perform parallel execution using testng.xml
