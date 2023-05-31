# Spring Boot Todo List App

This is a simple Todo List application built with Java and Spring Boot. It allows you to add, edit, and delete tasks. The tasks are stored in an in-memory database and secured by Spring Security.

## Project Structure

The project mainly consists of a model (Task), a repository (TaskRepository), a controller (TaskController), and a security configuration (SecurityConfig).

* The Task model represents a task with details and a due date.
* The TaskRepository extends CrudRepository for data persistence.
* The TaskController handles the web requests. It uses the TaskRepository to persist the tasks data.
* The SecurityConfig class is used to configure the Spring Security for the application.

## Features

* Secure User Authentication: Using Spring Security, the application ensures secure access with an authenticated user. The current configuration allows access via an in-memory user, but this can be extended to different authentication and authorization methods.
* Task Management: Allows users to create, view, edit, and delete tasks. Each task includes details and a due date, enabling users to organize their activities effectively.
* Exception Handling: The application gracefully handles exceptions, like accessing a task with an invalid ID, improving reliability.

## Images
<img width="1432" alt="Screenshot 2023-05-31 at 1 40 03 AM" src="https://github.com/samehjadda/todo/assets/106566093/58cceb46-bac8-484a-bb85-da032a490c31">
<img width="1433" alt="Screenshot 2023-05-31 at 1 40 22 AM" src="https://github.com/samehjadda/todo/assets/106566093/897ce1bd-115b-45c6-baac-4fdfa6dce377">
<img width="1434" alt="Screenshot 2023-05-31 at 1 41 36 AM" src="https://github.com/samehjadda/todo/assets/106566093/90303291-312e-45bf-9ebf-17e0d915a075">
