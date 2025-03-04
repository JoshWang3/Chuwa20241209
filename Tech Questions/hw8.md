### 1. create a file to list all of the annotaitons you learned and known, and explain the usage and how do you understand it. you need to update it when you learn a new annotation. Please organize those annotations.well, like annotations used by entity, annotations used by controller.
**1. File name: annotations.md**
**2. you'd better also list a code example under the annotations.**

### 2. explain how the below annotaitons specify the table in database?
```
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name; // specify column called name in Database with type varchar(255) and default value "John Snow"
@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;// specify column called STUDENT_NAME in Database with type char(50), not null, and can have the same value"
```

### What is the default column names of the table in database for @Column ?
```
@Column
private String firstName; Column name: firstName --case-sensitive
@Column
private String operatingSystem; Column name: operatingSystem --case-sensitive
```
### 4. What are the layers in springboot application? what is the role of each layer?
- 1. Controller: Model and View Controller, accpet api calls.
- 2. Service: Business logic
- 3. Repository: Interact with database
- 4. Entity: Interact with repository
- 5. Payload: Interact with api calls
### 5. Describe the flow in all of the layers if an API is called by Postman.
- Postman (api call with some payloads) -> Controller (accept api call and payloads) -> Service (accept payloads, do business logic, and convert payloads to Entity) -> Repository (use Entity to interact with the database) -> Service (convert result back to payload) -> Controller (return result) -> Postman.
### 6. What is the application.properties? do you know application.yml?
- In a Spring Boot application, application.properties is a default properties file used to configure various settings such as server port, database connections, logging, and more.
- You can define key-value pairs (e.g., server.port=8080) to specify how the application should run.
- application.yml serves the same purpose as application.properties but uses YAML syntax instead of simple key-value pairs.
### 7. What’s the naming differences between GraphQL vs. REST ? Why is the differences ?
- **Naming in REST**

- **Resource-centric:** Endpoints typically use plural nouns to represent resources (e.g., /users, /orders), and HTTP verbs (GET, POST, PUT, DELETE) define the action.
- **Multiple URLs:** You often have distinct URLs for different operations or nested resources, like /users/{id}/posts.
Naming in GraphQL

- **Schema-centric:** You define types (e.g., User, Order) and fields (e.g., name, price), then access them via queries or mutations in a single endpoint (usually /graphql).
- **Single URL:** Operations (queries/mutations) are identified by the type and field names rather than separate endpoints.
- **Why the Differences?**

- **REST** is designed around resources and uses distinct endpoints for different operations.
- **GraphQL** is designed around a type system, allowing clients to specify exactly what data (fields) they need from a single endpoint. This schema-based approach changes how we name and organize data—focusing on fields and types rather than nouns and URLs.
### 8. Provide 2 real-world examples of N+1 problem in REST that can be solved by GraphQL.
- Example 1: Blog Posts & Authors
- In a REST setup, you might call /posts to get a list of posts, then for each post call /authors/{id} to fetch the author’s details, causing multiple round trips (N+1 calls). 

- Example 2: Orders & Items
- In an e-commerce REST API, you’d first call /orders to get all orders, then for each order call /items/{id} repeatedly to fetch item details. 