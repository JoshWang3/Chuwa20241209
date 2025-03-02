### 1. explain how the below annotaitons specify the table in database?
```
   @Column(columnDefinition = "varchar(255) default 'John Snow'")
   private String name;
   @Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
   private String studentName;
```
`@Column(columnDefinition = "varchar(255) default 'John Snow'")`
- Define the column type explicitly as `varchar(255)`.
- Sets a default value of `'John Snow'`, which means if no value is provided for the `name` field, the database will use `'John Snow'`.
- Example SQL:
`name varchar(255) default 'John Snow';`

`@Column(name = "STUDENT_NAME", length = 50, nullable = false, unique = false)`
- Names the column as `STUDENT_NAME` in the database.
- Sets the maximum length of the column to 50 characters (`length = 50`).
- Specifies that the column cannot have `NULL` values (`nullable = false`), making it mandatory.
- Allows duplicate values since `unique = false`.
- Example SQL:
`STUDENT_NAME varchar(50) not null;`

### 2. What is the default column names of the table in database for @Column?
```
@Column
private String firstName;
@Column
private String operatingSystem;
```

The default column names in the database for the @Column annotation are derived directly from the field names in the class.

1. For the field firstName, the default column name will be `firstName`.
- If no specific name is provided in the `@Column` annotation, Hibernate/JPA uses the exact name of the field as the column name.

2. For the field `operatingSystem`, the default column name will be `operatingSystem`.
- Similarly, since the `@Column` annotation does not specify a `name` attribute, the field name is directly used as the column name.

### 3. What are the layers in springboot application? what is the role of each layer?
1. Controller Layer: Handles HTTP requests and responses. It maps client requests to specific endpoints.
- Example: @RestController.

2. Service Layer: Implements business logic and coordinates between controllers and repositories.
- Example: @Service.

3. Repository Layer: Manages database interactions using JPA or other frameworks.
- Example: @Repository.

4. Model Layer: Defines data structures and maps them to database tables.
- Example: @Entity.

This layered architecture ensures clear separation of concerns for better maintainability and scalability.

### 4. Describe the flow in all of the layers if an API is called by Postman.
1. Postman Request: Sends an HTTP request (e.g., POST with JSON body).
2. Controller Layer: Receives the request, maps it to a method, and passes data to the service layer.
3. Service Layer: Applies business logic and calls the repository for database operations.
4. Repository Layer: Interacts with the database to fetch or save data.
5. Response: Data flows back through the layers (Repository → Service → Controller) and is sent as a response to Postman.

### 5. What is the application.properties? do you know application.yml?
`application.properties`
- A configuration file in Spring Boot used to define key-value pairs for application settings (e.g., server port, database URL, etc.).
```
server.port=8080
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=root
spring.datasource.password=password

```

`application.yml`
- An alternative to `application.properties`, using a hierarchical structure for better readability.
```
server:
  port: 8080
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/mydb
    username: root
    password: password

```
- Key Points:
1. Both are used for configuration but application.yml is more structured and readable for complex settings.
2. Spring Boot supports both; you can use either based on preference.

### 6. What’s the naming differences between GraphQL vs. REST ? Why is the differences ?
1. GraphQL:

- Focuses on actions or queries (e.g., `getUser`, `createPost`, `deleteComment`).
- The API revolves around the schema defining types and relationships between data.
2. REST:

- Focuses on resources (e.g., `/users`, `/posts`, `/comments`).
- Uses HTTP methods (`GET`, `POST`, `PUT`, `DELETE`) to perform operations on resources.

Why the Difference?

- GraphQL: Built to provide flexibility and specific data retrieval, so it names operations based on functionality (query/mutation style).
- REST: Designed around resource-based architecture, aligning with HTTP semantics for simplicity and standardization.

### 7. Provide 2 real-world examples of N+1 problem in REST that can be solved by GraphQL.
1. Fetching Users and Their Orders

- REST Problem:
  - API 1: /users fetches a list of users.
  - API 2: /users/{id}/orders fetches orders for each user.
  - For 10 users, this requires 1 request for users + 10 additional requests for orders (N+1 problem).
- GraphQL Solution:
- A single query retrieves both users and their orders:
```
query {
  users {
    id
    name
    orders {
      id
      total
    }
  }
}

```

2. Fetching Articles and Their Comments

- REST Problem:
  - API 1: /articles fetches a list of articles.
  - API 2: /articles/{id}/comments fetches comments for each article.
  - For 5 articles, this requires 1 request for articles + 5 additional requests for comments.

- GraphQL Solution:
- A single query retrieves both articles and their comments:
```
query {
  articles {
    title
    content
    comments {
      author
      text
    }
  }
}

```








