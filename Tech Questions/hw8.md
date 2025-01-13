# HW8
## Questions:

### 1. See annotations.md
### 2. Explain how the below annotations specify the table in the database.
(1) The column `name` in db will have a type of VARCHAR(255) and default value `'John Snow'`

(2) Column `STUDENT_NAME` with maximum Length 50 and not Nullable/ not Unique

### 3. What are the default column names of the table in the database for @Column?
Will match the field name in the Java class in snake case.

### 4. What are the layers in a Spring Boot application? What is the role of each layer?
Presentation Layer: A JSON structure is made up of viewpoints. It interprets JSON and handles authentication and HTTP requests. After authentication, it enters the business layer for further processing.

Business Layer: It manages all of the business decisions and performs the business validation and consent. 

Persistence Layer: All of the storage logic in this program, including database.

Database Layer: The HTTP request or internet requests are handled by the Controllers from the demonstration layer. Databases may be managed by many databases.

### 5. Describe the flow in all of the layers if an API is called by Postman.
Controller Layer -> Service Layer
Receives the HTTP request (e.g., GET, POST) from Postman.

Service Layer <-> Repository Layer
Executes database queries and Sends data back to the Service Layer.

Controller Layer Sends the final response back to Postman (JSON, XML, ... )

### 6. What is the application.properties file? Do you know application.yml?
`application.properties` is a configuration file in Spring Boot used to define application settings.
`application.yml` is an alternative configuration file using YAML syntax. It is more structured and easier to read

### 7. What’s the naming difference between GraphQL and REST? Why is there a difference?
GraphQL Uses a single endpoint while REST uses multiple endpoints based on resources and HTTP request methods.

### 8. Provide 2 real-world examples of the N+1 problem in REST that can be solved by GraphQL.
In a blog website, retrieve article posts and author information. Need N queries on authors and one additional on posted articles. GraphQL can fetch these 2 at the same time.

In a e-shopping site, need a query for shopping orders and N queries on the items needed on every order. GraphQL can get them at once.

### 9. Finish all the following API
See Coding folder

10. Create a Project, name it with mongo-blog, write a POST API for mongo-blog, change database to
    MongoDB;
11. https://www.mongodb.com/compatibility/spring-boot