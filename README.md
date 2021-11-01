# RITS - Back End

This is the back end for the RITS project. For the front end you can go here.

[https://github.com/ryanmohler17/RIT-Front-End](https://github.com/ryanmohler17/RIT-Front-End)

## Project Description

RITS (Revasture Issue Tracking Software) is an enterprise level tracking tool designed track and manage software/product issues during the different stages of development. The application will allow a reporter (end user or developer) to submit description of issue/bug to be resolved. The System will assign a schedule for follow ups and resolution, and will allow periodic updates on status of case, which will be available to the reporter.

## Technologies Used

* Jenkins
* Linux
* SendGrid
* Java 8
* Angular
* Spring
* Hibernate
* HTML
* CSS
* JavaScript
* TypeScript
* Docker
* PostgreSql
* JUnit
* Lombok
* Log4j
* Maven
* Jackson
* Mockito

## Features
### Implemented
* Ability to report issues
* Ability to edit a SCRUM board
* Ability to log in

### TODO
* Fix dounble adding of issues onto a scrum board
* Implement an issue view page
    * Ability to follow up on issues
    * Comment System on issues
* Allow creation of SCRUM Boards
* Email
* Registration

## Getting Started

To get started with the backend you're going to need maven, and java 8 installed. You'll also need a postgresql server.

You'll also need to log into your postgresql server and run the `RITS.sql` file.

To get started with the backend you want to clone the repo
```
git clone https://github.com/ryanmohler17/RIT-Backend.git
```
After that you'll want to enter the directory you just cloned and compile the project.
```
mvn package
```
Now before we continue you'll want to set some enviorment variables. I'll list them all out as well as there purpose bellow
```
SENDGRID_KEY: Sendgrid api key for sneding emails
DB_URL: jdbc url for accessing your databse
DB_USERNAME: username for the databse
DB_PASSWORD: password for the databse
```
Or alternitavly you can edit these values in the `src/main/resources/application.yaml` file

Then you can run the program
```
java -jar target/rit-0.0.1-SNAPSHOT.jar
```
[After you get the backend going you can then start the front end.](https://github.com/ryanmohler17/RIT-Front-End)

## Contributors

> Ryan Mohler

> Jordan Perez

> Jorge Ferreira

> Alberto