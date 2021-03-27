Developed and Tested on :
FireFox : 78.9.0esr (64-bit)
Chrome : Version 89.0.4389.90 (Official Build) (64-bit)
Operating System : Windows 10


How to run:

Clone the repo and navigate to GlassLewisUITestware 

mvn clean install   
->Will run test cases in both chrome and firefox in head mode.

mvn clean install -Dheadless=true 
->Will run test cases in both chrome and firefox in headless mode.

mvn clean install -Dsurefire.suiteXmlFiles=src/main/resources/suites/RegressionSuite_CHROME.xml
->Will run test cases in chrome

mvn clean install -Dsurefire.suiteXmlFiles=src/main/resources/suites/RegressionSuite_FIREFOX.xml
->Will run test cases in firefox