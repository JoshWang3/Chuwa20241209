## 1. Create a file to list all of the annotations you learned and known, and explain the usage and how do you understand it.
    see Tech\ Questions/spring_annotations.md
## 2. Explain how the below annotations specify the table in database?
```java
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name; // specify column called name in Database with type varchar(255) and default value "John Snow"

@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName; // specify column called STUDENT_NAME in Database with type char(50), not null, and can have the same value"
```
## 3. What is the default column names of the table in database for @Column?
```java
@Column
private String firstName; // Column name: firstName -- case-sensitive 
@Column
private String operatingSystem; // Column name: operatingSystem -- case-sensitive 
```
## 4. What are the layers in springboot application? what is the role of each layer?
    1. Controller: Model and View Controller, accpet api calls.
    2. Service: Business logic
    3. Repository: Interact with database
    4. Entity: Interact with repository
    5. Payload: Interact with api calls
## 5. Describe the flow in all of the layers if an API is called by Postman.
    Postman(api call with some payloads) -> Controller(accept api call and payloads) -> Service(accept payloads and do business logic and change payload to entity) 
    -> Repository(use Entity to do database interaction) -> Service(result back to payload) -> Contoller(result back) -> Postman.
## 6. What is the application.properties? do you know application.yml?
    1. application.properties: file to config springboot applications (e.g., database connection, graphql, services)
    2. application.yml: same functionality as application.properties but in different format.
## 7. What’s the naming differences between GraphQL vs. REST? Why is the differences?
    1. Resource-Centric vs. Operation-Centric Naming
    REST: Resource-Centric Naming
    REST is based on resources, and the naming focuses on nouns that represent the resources being acted upon.
    The endpoints in REST typically represent specific entities (e.g., users, orders, products) or collections of entities.
    Actions are inferred by the HTTP methods (GET, POST, PUT, DELETE).
    2. GraphQL: Operation-Centric Naming
    GraphQL is focused on queries and mutations rather than specific resources. The naming conventions are based on actions or operations that describe the purpose of the request.
    GraphQL operations are explicitly defined in terms of query, mutation, or subscription, and the operation name often describes the desired outcome or action.
    3. Why differences?
    Philosophy:
        REST adheres to the principles of resource orientation and the idea of a web of resources.
        GraphQL focuses on data needs, making the API flexible and tailored to the client's specific requirements.
    Client-Driven Design:
        REST provides fixed endpoints and responses, leaving little room for the client to specify its needs.
        GraphQL allows clients to define exactly what data they want, leading to operation-based naming.
    Flexibility:
        REST endpoints are rigid and often require additional endpoints for new use cases.
        GraphQL’s single endpoint and dynamic queries eliminate the need for adding new paths, enabling flexibility and ease of evolution.
    Conclusion
        REST emphasizes resources, leading to noun-based, endpoint-specific naming.
        GraphQL emphasizes operations, resulting in action- or intent-based names defined within a flexible schema.
## 8. Provide 2 real-world examples of N+1 problem in REST that can be solved by GraphQL.
    1. In the bank application, query balances of checking and saving account
    2. Social Media application, query posts and comments.
## 9. Finish all the following API
    see Coding/hw40/redbook
## 10. Create a Project, name it with mongo-blog, write a POST API for mongo-blog, change database to MongoDB;
    see Coding Coding/hw40/redbook