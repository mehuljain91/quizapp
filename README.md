# Quiz Application

This is a Spring Boot application that allows users to create and participate in timed quizzes. It provides a RESTful API for managing quizzes.

## Features

- Create a quiz by sending a POST request to `/quizzes`.
- Retrieve the active quiz by sending a GET request to `/quizzes/active`.
- Retrieve the result of a quiz by its ID using the GET request `/quizzes/{id}/result`.
- Retrieve all quizzes using the GET request `/quizzes/all`.

## Technologies Used

- Java
- Spring Boot
- PostgreSQL

## Prerequisites

- Java 8 or higher
- PostgreSQL database
- Maven

## Getting Started

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/quiz-application.git

2. Configure the database connection in the application.properties file

3. Build the application:
    ```bash
    cd quizapp
    ./mvnw clean package
    
4. Run the application:
    ```bash
    ./mvnw spring-boot:run
    
5. The application will start running at http://localhost:8080.

## API Endpoints
- POST /quizzes: Create a new quiz.
- GET /quizzes/active: Retrieve the active quiz.
- GET /quizzes/{id}/result: Retrieve the result of a quiz by its ID.
- GET /quizzes/all: Retrieve all quizzes.
