# Twitter

This Application is created to test Twitter, it has used cucumber BDD framework and Selenium Jars.
 
## Project Location

 - Git URI : https://github.com/palashjain71/com.twitter.app.git

## Requirements

In order to utilise this project you need to have the following installed locally:

- Maven 3.5.0
- Java 1.8

### Advised working environment

- Eclipse / IntelliJ
- Git
- Maven

## Tools

- Maven
- JUnit
- Selenium
- Git

## Usage

To run all test case present in modules, navigate to your com.twitter.app directory and run on command prompt :

To Run Smoke test case 

`mvn clean test -DbrowserName='chrome' -Durl='twitter_prod'`

To Run Specific test case 

`mvn clean test -DbrowserName='chrome' -Durl='twitter_prod' -Dcucumber.options='--tags @executeThese' `

## Reporting

Reports for test run will generated in target folder with name 'cucumber.html' directories after a successful/failure run.
