# Homework 8

## 1. Create a file to list all of the annotaitons you learned and known, and explain the usage and how do you understand it. you need to update it when you learn a new annotation. Please organize those annotations well, like annotations used by entity, annotations used by controller.

- Entity-Related Annotations

    - @Entity: Marks a class as a JPA Entity, which means objects of this class will be mapped to a database table.
    ```
    @Entity
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String username;
        // ...
    }
    ```

    - @Table: Used to specify the table name in the database if you don't want to use the default name (which is usually the class name).
    ```
    @Entity
    @Table(name = "TBL_USER")
    public class User {
        // ...
    }
    ```

    - @Column: Used to customize the mapping of a specific column. You can specify properties like name, length, nullable, unique, and columnDefinition.
    ```
    @Entity
    public class Book {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(length = 100, nullable = false)
        private String title;
    }
    ```

    - @ManyToOne / @OneToMany / @OneToOne / @ManyToMany: Specify different kinds of relationships between entities (e.g., one-to-many, many-to-one, one-to-one, many-to-many).
    ```
    @Entity
    public class Order {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        private Customer customer;

        // ...
    }
    ```

- Controller-Related Annotations
    - @RestController: A specialized annotation that combines @Controller and @ResponseBody. It indicates that the class handles REST API endpoints.

    - @RequestMapping: Maps HTTP requests to handler methods. Can be placed at both the class and method level.
    ```
    @RestController
    @RequestMapping("/api/users")
    public class UserController {

        @GetMapping("/{id}")
        public User getUser(@PathVariable Long id) {
            // ...
        }
    }
    ```

    - @GetMapping / @PostMapping / @PutMapping / @DeleteMapping: Shorthand annotations for handling specific HTTP methods (GET, POST, PUT, DELETE).

- Other Common Annotations
    - @Autowired: Injects a bean (component) automatically by type.
    - @Service: Indicates that the annotated class holds the business logic.
    - @Repository: Indicates that the annotated class is a repository (usually data access objects).
    - @Configuration: Indicates that a class declares one or more @Bean methods. It can be processed by the Spring container to generate bean definitions.
    - @Bean: Indicates that a method produces a bean to be managed by the Spring container.

## 2. explain how the below annotaitons specify the table in database?
```
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;
@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;
```
- @Column(columnDefinition = "varchar(255) default 'John Snow'" )
    - columnDefinition directly provides the SQL definition for the column.
    - Here, it specifies a VARCHAR(255) column with a default value of "John Snow".
    - If no value is set for name upon insertion, it defaults to "John Snow".
    - By default, if name is the field name, the column will also be named name in the table.

- @Column(name = "STUDENT_NAME", length = 50, nullable = false, unique = false)
    - name="STUDENT_NAME" tells JPA to use "STUDENT_NAME" as the column name in the database instead of studentName.
    - length=50 sets the VARCHAR length to 50.
    - nullable=false enforces a NOT NULL constraint, making the field required.
    - unique=false allows duplicate values in the column.

## 3. What is the default column naming convention for @Column?
- When you simply use @Column without specifying the column name, the default naming strategy typically takes the field name and applies a certain convention. By default:
```
@Column
private String firstName;       // Maps to a column: FIRST_NAME
@Column
private String operatingSystem; // Maps to a column: OPERATING_SYSTEM
```
- Spring (through JPA’s default naming strategy) often transforms camelCase field names into snake_case uppercase columns. For example, firstName becomes FIRST_NAME and operatingSystem becomes OPERATING_SYSTEM in most default configurations.

## 4. What are the layers in springboot application? what is the role of each layer?
- **Presentation Layer (Controller Layer)**: 
    - Entry point for handling HTTP requests.
    - Manages interaction between clients and the application by receiving requests, calling the service layer, and returning responses.
- **Service Layer (Business Logic Layer)**: 
    - Contains the core business logic of the application.
    - Orchestrates data flow between the controller and repository, applying business rules and handling transactions.
- **Repository Layer (Data Access Layer)**: 
    - Encapsulates data persistence logic. 
    - Provides methods for CRUD operations and custom queries.
- **Model Layer (Entity Layer)**: 
    - Defines the structure of the data with entity classes representing database tables.
    - Often includes DTOs (Data Transfer Objects) for transferring data between layers.

## 5. Describe the flow in all of the layers if an API is called by Postman.
- Client (Postman) sends HTTP request (e.g., POST /api/users) with JSON data.
- Spring Boot DispatcherServlet receives the request and routes it to the appropriate controller based on URL and method.
- Controller
    - Accepts the request.
    - Converts the incoming JSON payload to a DTO or entity.
    - Validates the input.
    - Calls methods in the Service layer.
- Service layer
    - Implements the business logic.
    - Transforms DTOs to Entities as needed.
    - Interacts with the Repository layer to perform data operations.
- Repository layer
    - Executes the actual queries (CRUD operations) against the database.
    - Returns the results to the Service layer.
- Database
    - Persists or retrieves the requested data and returns it to the repository.
- Service layer
    - Receives the results from the repository.
    - Applies further business rules if needed.
    - Converts Entities back to DTOs (if using DTOs).
- Controller
    - Receives the final result from the service layer.
    - Wraps it in an appropriate HTTP response (e.g., ResponseEntity).
- Client (Postman)
    - Receives the JSON response from the server.

## 6. What is the application.properties? do you know application.yml?
In Spring Boot, configuration properties can be placed in either application.properties or application.yml. Both formats serve the same purpose: to configure database connections, server ports, and other environment-specific settings.

Example application.properties:
```
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update

# Server Configuration
server.port=8080
server.servlet.context-path=/api
```
Example application.yml:
```
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/mydb
    username: root
    password: root
  jpa:
    hibernate:
      ddl-auto: update

server:
  port: 8080
  servlet:
    context-path: /api
```

## 7. What’s the naming differences between GraphQL vs. REST ? Why is the differences ? 
REST Naming Conventions: Typically uses nouns and HTTP verbs in a URL path
```
GET    /api/users               # Get all users
GET    /api/users/{id}          # Get specific user
POST   /api/users               # Create user
PUT    /api/users/{id}          # Update user
DELETE /api/users/{id}          # Delete user
GET    /api/users/{id}/posts    # Get user's posts
```
GraphQL Naming Conventions: Uses a schema with types, queries, and mutations
```
type Query {
  users: [User]
  user(id: ID): User
}

type Mutation {
  createUser(input: CreateUserInput): User
  updateUser(id: ID, input: UpdateUserInput): User
  deleteUser(id: ID): Boolean
}

type User {
  id: ID
  name: String
  posts: [Post]
}
```
Why the difference?
- In REST, the focus is on resources and endpoints. Each endpoint corresponds to a resource (e.g., /users) and an HTTP method indicates the type of operation.
- In GraphQL, you define a strongly-typed schema and ask for exactly the data you need via queries and mutations. There is only one endpoint (usually /graphql), and the queries or mutations specify the data you want or the changes you need to make.

## 8. Provide 2 real-world examples of N+1 problem in REST that can be solved by GraphQL. 
- E-commerce product reviews
    - REST Example (N+1 Problem)
    ```
    GET /api/products
    [
      { id: 1, name: "iPhone" },
      { id: 2, name: "Samsung" }
    ]

    # For each product returned, make additional requests for reviews:
    GET /api/products/1/reviews
    GET /api/products/2/reviews
    ```
    - GraphQL Solution
    ```
    query {
      products {
        id
        name
        reviews {
          id
          rating
          comment
        }
      }
    }
    ```
    - A single GraphQL request can fetch both product and related reviews at once, avoiding multiple round trips.

- Social media user posts with comments
    - REST Example (N+1 Problem)
    ```
    GET /api/users
    [
      { id: 1, name: "John" },
      { id: 2, name: "Mary" }
    ]

    # Then for each user:
    GET /api/users/1/posts
    GET /api/users/2/posts

    # And for each post:
    GET /api/posts/1/comments
    GET /api/posts/2/comments
    ```
    - GraphQL Solution
    ```
    query {
      users {
        id
        name
        posts {
          id
          content
          comments {
            id
            text
            author
          }
        }
      }
    }
    ```
    - Again, one query can pull users, their posts, and comments in a single round trip, eliminating the N+1 overhead.
























