# Banking API

Banking API implementation, Banking API for opening accounts and handling transactions,
with endpoints for viewing customer details and balances. 
Includes separate account and transaction management, basic frontend, 
and CI/CD integration for streamlined development.

# Prerequisites

To run the application, you need to have:
1. JDK 17 (https://www.oracle.com/java/technologies/downloads/)
2. Maven 3.8.6 (https://maven.apache.org/download.cgi).
3. Git (https://git-scm.com/downloads)
   You also need to configure your user and system path variables for both java and maven.
   You also need to have git installed to clone the project.

### Run it locally

1. Open terminal and clone the repo:
```shell
git clone https://github.com/IGDERZEN-Zakaria/Banking-Application.git
```

2. Make sure you are in the project directory to build and package the application with the following Cmd Command:
```shell
mvn clean install
```

3. Go to /target inside TicTacToe and run the following command to lunch the application:
```shell
java -jar TicTacToe-0.0.1-SNAPSHOT.jar
```

## Data Base

This application has H2 Database;
It is an embedded in-memory database that means it only lasts as the application is running

You can access it by browsing: http://localhost:8090/h2-console

User Name = user

Password = popcorn

### Console H2 Config

## API Documentation

The documentation of the API is made by OpenAPI 3.0, it shows all the Endpoints of the application

You can access after running the application it in to http://localhost:8090/swagger-ui.html

