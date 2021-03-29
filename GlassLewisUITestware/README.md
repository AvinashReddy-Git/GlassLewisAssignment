*************************************************************************************************
The artifact has room for optimisation , but this is the best i can come up with in a short time frame , open for suggestions

**************************************************************************************************

**Introduction** :
This is a java selenium maven project.
This framework is built using page object model design pattern,
 Cross-Browser Automation Testing ( Chrome and Firefox) , runs on windows OS,with logging and screen shot on test failure , WebEvenListner ,screen shot on failure functionality.
It supports both head and headless mode .
Testing configuration settings are passed as environment variables.
Tests can be configured to run on various browser
 
**Dependencies used:**
selenium
testng
slf4j
apache commons
commons io

**Developed and Tested on :**
FireFox : 78.9.0esr (64-bit)
Chrome : Version 89.0.4389.90 (Official Build) (64-bit)
Operating System : Windows 10

**How to run:**

Clone the repo and navigate to GlassLewisUITestware 

mvn clean install   
->Will run test cases in both chrome and firefox in head mode.

mvn clean install -Dheadless=true 
->Will run test cases in both chrome and firefox in headless mode.

mvn clean install -Dsurefire.suiteXmlFiles=src/main/resources/suites/RegressionSuite_CHROME.xml
->Will run test cases in chrome

mvn clean install -Dsurefire.suiteXmlFiles=src/main/resources/suites/RegressionSuite_FIREFOX.xml
->Will run test cases in firefox
