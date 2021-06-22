
# Kodo Web Test Automation Assignment (Selenium WebDriver)

**Web Automation Framework**

**Type of framework:** Test Driven Hybrid (using Page Object Model (POM) design pattern)

--------------
**How to use this framework?**

- Clone the repository to your workspace.

- Open the 'data' folder under the src/test/resources folder.

- In the TestInformation sheet --> Choose the test cases you want to run by saying yes.

- In the SearchData sheet --> Choose the test data you want to pass to the testcase from excel sheet by saying yes.

- The data from the excel sheet will be passed to the test method as a HashMap.

- Run the testng.xml file always.

**Note:** *If you try to run individual tests as TestNG test, you will get NPE as the listeners are configured in testng.xml.*

You can add maven surefire plugin to trigger the testng.xml file from pom.xml or command prompt.

---
**How the framework works?**

- AnnotationTransformer class which implements IAnnotationTransformer is reponsible for reading the data from TestInformation sheet under data folder. It sets the annotation of the test methods like description, enabled, priority, dataprovider values read from the excel.

- Things to note: Test name in the first column of the excel sheet should match with atleast an @Test available in test classes mentioned in the testng.xml

- All the tests will have the same dataprovider in the DataProviderUtilities class. For example, the 'verifySearchPageFieldIsDisplayedTest_TC_008' in TestInformation sheet will take the data from SearchData sheet which has the row where the testname is 'verifySearchPageFieldIsDisplayedTest_TC_008'.

- If there are multiple rows with 'verifySearchPageFieldIsDisplayedTest_TC_008' as testname in the DataProvider sheet (SearchData), framework will consider it as this as multiple iterations for a test case.

- MethodInterceptor class which implements IMethodInterceptor intercepts the existing test methods and changes the annotation value at the run time.

- Listeners class is responsible for listening to the tests, capturing the events and logging the pass, fail, skip logs with or without screenshot.

---


**Other points:**

- TestCase description given in the excel sheet will be displayed in the extent reports.

- Data from excel sheet will be available as HashMap parameter to the tests.

- You can fetch the value using data.get("columnnameinexcel"). Refer the already existing tests for more details.

 
 
## Documentation
[Documentation](C:/Users/asus/eclipse-workspace/KodoAutomationAssignment/doc/index.html)

  
---
## Running Tests

Pre-requisites:

- Maven should be installed (Preferrably 3.6.3) and its home and path environment variables set in the system

- Java 8 or higher should be installed and its home and path environment variables set in the system

To run tests, run the following command in command prompt:

```bash
  mvn clean
  mvn compile
  mvn test
```


  
## Tech Stack

**Programming language:** Java 8

**Testing framework:** TestNG

**Web testing:** Selenium WebDriver API

**Build Automation tool:** Maven

**Reports:** Extent Reports

  