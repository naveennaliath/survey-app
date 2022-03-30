# Survey App

Survey App provides RESTful APIs for the following use cases.

1. Create a Survey
2. Create/Update/Delete questions against a survey
3. Delete a Survey
4. Read all questions
5. Read all questions with answers
6. Respond to a survey
7. Get the relative distribution of answers for questions in a Survey

The details of the APIs can be found at "/swagger-ui/index.html" once the application is started.

## Prerequisites

- Java 11
- Maven 3

## Tech Stack

- Development Framework :	Spring Boot 2.6.3
- Testing Framework : Junit 5
- Database  :	H2
- Build Tool: Maven 3

## Assumptions/To-Do

- Havent created separate microservices due to the time constraint. But the code has been organised in such a way that it can be moved to separate micro-services like survey-config, survey-submission, survey-report

Also was not able to implement following items

- Separate profiles can be created for Dev, Test, Prod etc.
- Have not covered all test cases. But has created few test cases for testing each layer
- Have not added comments for all the classes/methods
- Static code analyzers not integrated to build

## Architecture


_Application Layer_
The application is developed using Spring Framework. It is organized in a layered architecture. Inside each layer, packages has been further split as config, submission and report which represent the potential microservices.

- API         : All the APIs are defined in this layer. Only this layer is exposed to client systems.‎
- Service     : APIs invoke the service layer to fulfill the requirements. All the business logic is applied in this layer 
- Persistence : This layer is responsible for DB operations

_Database_
The database used is H2. There entities are as below

Configuration
1. SurveyConfig    - Stores survey configuration
2. QuestionConfig - Stores question and answer configuration. Answer is stored as a JSON column

Submission
1. SurveySubmission- Stores survey name, submitted person, date etc
2. SurveySubmissionDetail- Stores question
3. SurveySubmissionAnswer - Stores answer

The entities are splitted as SurveySubmissionDetail and SurveySubmissionAnswer for the convenience of generating reports


_Logging_
Logback is used internally for logging under the hood of Slf4j


## Horizontal Scalability

As explained above the application can be split as separate micro-services namely survey-config, survey-submission, survey-report

1. survey-config- APIs for survey/question configuration
2. survey-submission- APIs for survey submission
3. survey-report- APIs for survey submission. This can point to the reader endpoints of survey-submission DB

All the above modules are independent and can be scaled as per requirements

![image](https://user-images.githubusercontent.com/75239469/160891951-be4141c2-2222-4453-82bd-2788accbcdaf.png)

To start the application use any of the commands



```bash
mvn spring-boot:run
```
OR

```bash
java -jar survey-app-1.0.jar
```
## Testing

Please access http://localhost:8080/swagger-ui/index.html via browser to view the API information

Use any of the REST Clients(eg:Postman) to access the API endpoints.

The log file is available by default in the "logs" folder outside of the folder having application jar.
