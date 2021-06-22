
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

- The tests are triggered through the testng.xml file (via IDE) which also has details about the listeners and dataprovider in order to trigger them.
Alternatively, Maven build tool calls the testng.xml file through surefire plugin (provided in the pom.xml file) to run the tests via command prompt.

- MethodInterceptor class which implements IMethodInterceptor intercepts the existing test methods and changes the annotation value at the run time which is fetched from the TestInformation excel sheet (header part).

- AnnotationTransformer class which implements IAnnotationTransformer is reponsible for reading the data from TestInformation sheet under data folder. It sets the annotation of the test methods like testname, description, execute, dataprovider values read from the excel.
Things to note: Test name in the first column of the excel sheet should match with at least an @Test available in test classes mentioned in the testng.xml

- All the tests will have the same dataprovider in the DataProviderUtilities class. For example, the 'verifySearchPageFieldIsDisplayedTest_TC_008' in TestInformation sheet will take the data from SearchData sheet which has the row where the testname is 'verifySearchPageFieldIsDisplayedTest_TC_008'.
If there are multiple rows with 'verifySearchPageFieldIsDisplayedTest_TC_008' as testname in the DataProvider sheet (SearchData), framework will consider it as this as multiple iterations for a test case.

- Listeners class is responsible for listening to the tests, capturing the events and logging the pass, fail, skip logs with or without screenshot.

- User defined exceptions are implemented for throwing run time exceptions.

- The tests triggered through testng.xml file call the web pages class methods to fetch and interact with the web elements. After the values are retrieved and required operations are performed, the tests perform the assertions.

- Each test result along with the logs and screenshots (if configured as Yes) is captured and shown through Extent Reports after all the tests are run.
---


**Other points:**

- TestCase description given in the excel sheet will be displayed in the extent reports.

- Data from excel sheet will be available as HashMap parameter to the tests.

- You can fetch the value using data.get("columnnameinexcel"). Refer the already existing tests for more details.

 
 
## Documentation
[Documentation] Refer the index.html under the doc folder of the project.

  
---
## Running Tests

Pre-requisites:

- Maven should be installed (Preferably 3.6.3) and its home and path environment variables set in the system

- Java 8 or higher should be installed and its home and path environment variables set in the system

- Open command prompt and go to the path where the project is available (After downloading/cloning it)

To run tests, run the following command in command prompt:

```bash
  mvn compile
  mvn test
```


  
## Tech Stack

**Programming language:** Java 8

**Testing framework:** TestNG

**Web testing:** Selenium WebDriver API

**Build Automation tool:** Maven

**Reports:** Extent Reports

  