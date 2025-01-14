# Homework 8
## Springboot POST 

### 1. create a file to list all of the annotaitons you learned and known, and explain the usage and how do you understand it. you need to update it when you learn a new annotation. Please organize those annotations well, like annotations used by entity, annotations used by controller.
#### 1. File name: annotations.md
#### 2. you'd better also list a code example under the annotations.
- see annotations.md

### 2. explain how the below annotaitons specify the table in database?
- The @Column annotation customizes the mapping of a field to a database column. columnDefinition specifies the SQL data type and default value for the column. This allows the database to enforce the data type and default value at the schema level. The column will be created with the specified type and a default value of 'John Snow' if no value is provided when inserting data.

- A column named STUDENT_NAME will be created with a maximum length of 50, cannot accept NULL values, and does not require unique values.
1. `name` specifies the exact name of the column in the database.
2. `length = 50` sets the maximum length of the column to 50 characters.
3. `nullable = false` ensures the column cannot be null (enforced by the database).
4. `unique = false` indicates that the column does not enforce uniqueness.

### 3. What is the default column names of the table in database for @Column?
- If no attributes are specified in the @Column annotation, the database column name defaults to the field name in the Java class. The case and exact name are retained as they appear in the field unless a naming strategy is configured in the persistence settings. In this example, `firstName` will be mapped to a column named "firstName". The field `operatingSystem` will be mapped to a column named "operatingSystem".

### 4. What are the layers in springboot application? what is the role of each layer?
- The main layers in springboot applciation are: 
1. Presentation Layer: focuses on request/response handling
2. Service Layer: handles business logic
3. Data Access Layer: deals with database interactions
4. Model Layer: defines the data structure and relationships

- When a request is made to the application, it is handled in the following sequence. T

### 5. Describe the flow in all of the layers if an API is called by Postman.
- The flow of a request begins with Postman sending the API call, which is handled by the Controller Layer. The Presentation Layer receives the HTTP request and delegates it to the Service Layer. The Service Layer processes the business logic and interacts with the Data Access Layer to fetch or manipulate data. The Data Access Layer performs database operations and returns the result to the Service Layer. The Service Layer processes the result and sends it back to the Presentation Layer, which then formats it as an HTTP response to the client. The result flows back through these layers and is returned to Postman as a formatted response. This layered architecture ensures a clean separation of concerns, making the application maintainable and scalable.

### 6. What is the application.properties? do you know application.yml?
- `application.properties` is a key-value pair configuration file commonly used in Spring Boot projects. It is simple and easy to use, making it ideal for basic configurations. It is used to configure various aspects of the application, such as server properties (e.g., port, context path), database connection details, logging levels, and custom application properties.

- `application.yml` is an alternative configuration format in Spring Boot. It uses YAML syntax, which is hierarchical and more human-readable, especially for complex configurations. The properties are defined using a nested, hierarchical structure. It allows grouping of properties, making configurations more concise and easier to manage and supports profiles (spring.profiles) for environment-specific configurations.

### 7. What's the naming differences between GraphQL vs. REST? Why is the differences ?
- In REST, naming revolves around resources, with endpoints typically representing entities or collections of entities. The endpoint names reflect the resource being acted upon, and the specific operation (e.g., GET, POST, PUT, or DELETE) is determined by the HTTP method rather than the endpoint name. REST follows a hierarchical structure for URLs to represent relationships between resources. For example, GET /users fetches all users, GET /users/{id} retrieves a specific user, and POST /users creates a new user. This resource-oriented naming aligns with REST’s stateless and standardized nature, focusing on simplicity and clarity for CRUD operations.

- In contrast, GraphQL uses a single endpoint (typically /graphql) and focuses on operations rather than resources. The naming conventions in GraphQL describe the specific queries or mutations being performed, such as getUser, createUser, or updateUser. GraphQL’s schema-driven design allows clients to define the exact data they need, minimizing over-fetching or under-fetching. For example, a query like query { user(id: "1") { name, email } } retrieves only the name and email fields of the specified user. This action-based naming reflects GraphQL’s flexibility and client-driven approach, making it suitable for applications with complex data needs.

- The difference in naming exists because REST emphasizes resources and relies on HTTP methods to define operations, while GraphQL emphasizes actions and empowers clients to structure their data requests dynamically. REST’s resource-based naming works well for CRUD operations on fixed resources, while GraphQL’s action-based naming is better suited for scenarios where flexibility and efficiency are critical, such as applications with complex relationships or varying client data requirements.

### 8. Provide 2 real-world examples of N+1 problem in REST that can be solved by GraphQL.

- The N+1 problem in REST APIs occurs when an application makes one initial query to fetch a list of resources and then N additional queries to fetch related data for each resource. This results in inefficient and redundant API calls, which can significantly impact performance. GraphQL solves this issue by allowing clients to retrieve all the required data in a single query using nested structures. The server processes the query, resolves the relationships, and returns all the requested data in a single response. This approach not only improves performance but also reduces the complexity of making multiple API calls, making it particularly effective in scenarios involving complex relationships or large datasets.

- One example of the N+1 problem is fetching users and their posts. In REST, we might first call GET /users to retrieve all users. Then, for each user, we would make an additional call, such as GET /users/1/posts and GET /users/2/posts, to fetch their respective posts. If there are 100 users, this results in 101 API calls (1 for users and 100 for posts). In GraphQL, you can address this problem with a single query like query { users { id name posts { id title } } }. This query retrieves all users and their posts in one request, eliminating the need for multiple follow-up calls.

- Another example is fetching products and their reviews in an e-commerce application. Using REST, we might first call GET /products to retrieve the product list and then make additional requests, such as GET /products/1/reviews and GET /products/2/reviews, for each product's reviews. If there are 50 products, this leads to 51 API calls. In contrast, a single GraphQL query like query { products { id name reviews { id comment } } } retrieves all products and their associated reviews in one call, solving the N+1 problem.

### 9. Finish all the following API
REST
GET/PUT/DELETE post (with exception cases)
POST/GET/PUT/DELETE comment (you need to design the table and its relation with Post)
POST/GET/PUT/DELETE author (you need to design the table and its relation with Post)
GraphQL
Query postBylD, getAllPost
Mutation createPost, updatePost
- see projects/hw8

### 10. Create a Project, name it with mongo-blog, write a POST API for mongo-blog, change database to MongoDB;
### 11. https://www.mongodb.com/compatibility/spring-boot
- see projects/hw8