

## Introduction

 - The Framework  is written in Java , using Maven and Selenium Webdriver .
 - Page object model design pattern  is used to seperate page and test classes
 - Supports Chrome , Firefox and Edge browsers ( both headless and non headless mode )
 - Tests capture screenshots of failures
 - Testing configuration settings can be passed as environment variables 
 - Tests can be configured to run on various browser
 - Logging , Retry and WebEvent listener included

## Dependencies used
 - Selenium webdriver,testng,slf4j,apache commons,commons io

## Developed and Tested on 
 - FireFox : 78.9.0esr (64-bit)
 - Chrome : Version 89.0.4389.90 (Official Build) (64-bit)
 - Edge : Version 89.0.774.63 (Official build) (64-bit)

   Operating System : Windows 10

## How to run:

Clone / download the repo , Open command line and navigate to GlassLewisUITestware folder

```
$ mvn clean install 
```
- Will run test cases in Chrome, Firefox and Edge in head mode.

```
$ mvn clean install -Dheadless=true 
```
- Will run test cases in  Chrome,Firefox and Edge in headless mode.

```
$ mvn clean install -Dsurefire.suiteXmlFiles=src/main/resources/suites/RegressionSuite_CHROME.xml
```
- Will run test cases in Chrome browser

```
$ mvn clean install -Dsurefire.suiteXmlFiles=src/main/resources/suites/RegressionSuite_FIREFOX.xml
```
- Will run test cases in Firefox browser 

```
$mvn clean install -Dsurefire.suiteXmlFiles=src/main/resources/suites/RegressionSuite_EDGE.xml
```
- Will run test cases in Edge browser
