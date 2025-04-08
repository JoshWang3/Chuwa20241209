# Homework 8

## 1. Create a file to list all of the annotaitons you learned and known, and explain the usage and how do you understand it. you need to update it when you learn a new annotation. Please organize those annotations well, like annotations used by entity, annotations used by controller.

This document lists the annotations I have learned and organizes them based on their usage in different layers of a Spring Boot application. I will update this list as I learn more annotations.

---

## Entity Layer Annotations (JPA / Hibernate)

- `@Entity`

  - Marks a class as a JPA entity that maps to a database table.
  - Think of this as the class that holds database row data.

- `@Table(name = "table_name")`

  - Specifies the database table name if different from the class name.

- `@Id`

  - Marks the primary key of the entity.

- `@GeneratedValue(strategy = GenerationType.IDENTITY)`

  - Configures how the primary key is generated (auto-increment, sequence, etc).

- `@Column(name = "column_name", nullable = false, unique = true)`

  - Customizes the mapping between the class field and database column.

- `@ManyToOne`, `@OneToMany`, `@OneToOne`, `@ManyToMany`

  - Define relationships between entities.
  - Example: `@ManyToOne` means many entities relate to one of another type.

- `@JoinColumn(name = "foreign_key_column")`

  - Specifies the foreign key column used in relationships.

- `@Transient`
  - Tells JPA to ignore this field when persisting to the database.

---

## Service Layer Annotations

- `@Service`

  - Marks a class as a service layer bean, used for business logic.
  - Allows Spring to auto-detect it for dependency injection.

- `@Transactional`
  - Wraps the method or class in a database transaction.
  - Ensures that DB operations either fully succeed or fully fail together.

---

## Controller Layer Annotations (Spring MVC)

- `@RestController`

  - Combines `@Controller` and `@ResponseBody`.
  - Indicates the class handles REST API requests and responses as JSON.

- `@RequestMapping("/api")`

  - Maps HTTP requests to controller methods.
  - Can be used at class or method level.

- `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`

  - Specialized versions of `@RequestMapping` for specific HTTP methods.

- `@PathVariable`

  - Binds a URI template variable to a method parameter.
  - Example: `/users/{id}` → `@PathVariable Long id`.

- `@RequestParam`

  - Extracts query parameters from the URL.
  - Example: `/search?name=John` → `@RequestParam String name`.

- `@RequestBody`
  - Binds the incoming JSON request body to a method parameter.

---

## Test Layer Annotations

- `@SpringBootTest`

  - Starts the full Spring application context for integration testing.

- `@WebMvcTest(controllers = YourController.class)`

  - Focuses on controller layer, doesn't start the full context.

- `@MockBean`
  - Replaces a bean in the application context with a Mockito mock.

---

## Miscellaneous Annotations

- `@Autowired`

  - Automatically injects dependencies into a class.

- `@Component`

  - Marks a class as a Spring-managed component.

- `@Configuration`

  - Indicates a class contains Spring configuration methods.

- `@Bean`
  - Declares a method that returns a Spring bean to be managed by the Spring container.

```

## 2. explain how the below annotaitons specify the table in database?
```

@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;
@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;

### 1. `@Column(columnDefinition = "varchar(255) default 'John Snow'")`

- This annotation is customizing the exact SQL that will be used to define the column.
- `columnDefinition` allows you to specify the full column type manually.
- In this case:
  - The column will be of type `varchar(255)`
  - Its default value will be `'John Snow'`
- This is useful when you want precise control over how the column is created in the database.

### 2. `@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)`

- This annotation allows fine-grained control over the column properties:
  - `name="STUDENT_NAME"`: Sets the column name to `STUDENT_NAME` instead of using the Java field name.
  - `length=50`: Limits the maximum length of the string to 50 characters.
  - `nullable=false`: The column cannot be null (i.e., it is required).
  - `unique=false`: Duplicate values are allowed in this column.

In summary, these annotations are part of the JPA (Java Persistence API) and allow you to define how the class fields should be mapped to columns in the database table, including name, type, length, constraints, and default values.

````
## 3. What is the default column naming convention for @Column?
- When you use `@Column` without specifying a `name`, JPA uses a default naming convention based on the field name.

### Default Behavior:
- The field name in camelCase is typically converted to **SNAKE_CASE** for the database column.
- This conversion depends on the **JPA naming strategy** being used.

### Examples:
```java
@Column
private String firstName;
// Maps to column: FIRST_NAME

@Column
private String operatingSystem;
// Maps to column: OPERATING_SYSTEM
````

## 4. What are the layers in springboot application? what is the role of each layer?

```

A typical Spring Boot application follows a layered architecture. The main layers are:

---

### 1. Controller Layer (Presentation Layer)
- **Role**: Handles incoming HTTP requests and returns responses.
- **Responsibility**: Acts as the interface between the client and the server-side application.
- **Common annotations**: `@RestController`, `@RequestMapping`, `@GetMapping`, `@PostMapping`, etc.
- **Example**:


---

### 2. Service Layer (Business Logic Layer)
- **Role**: Contains the core business logic of the application.
- **Responsibility**: Handles operations that don't directly involve the database but require processing.
- **Common annotations**: `@Service`, `@Transactional`
- **Example**:


---

### 3. Repository Layer (Data Access Layer)
- **Role**: Interacts with the database.
- **Responsibility**: Encapsulates the logic required to access data sources.
- **Common annotations**: `@Repository`, `@Query`
- **Typically uses**: Spring Data JPA or other persistence tools.
- **Example**:


---

### 4. Model Layer (Entity Layer)
- **Role**: Defines the structure of the data.
- **Responsibility**: Maps Java objects to database tables using JPA.
- **Common annotations**: `@Entity`, `@Table`, `@Id`, `@Column`, etc.
- **Example**:


---

### Summary:
- **Controller Layer** → Handles HTTP requests and routes them to the service.
- **Service Layer** → Handles business logic and calls the repository.
- **Repository Layer** → Handles database operations.
- **Model Layer** → Maps to the actual database schema.

This layered architecture promotes separation of concerns, making the codebase more maintainable and testable.
```

## 5. Describe the flow in all of the layers if an API is called by Postman.

````
## 5. Describe the Flow in All of the Layers if an API Is Called by Postman

When you send an API request (e.g., a POST or GET request) using Postman, the request goes through the following layers in a Spring Boot application:

---

### Step-by-Step Flow:

1. **Client (Postman) Sends HTTP Request**
   - Example: A GET request to `http://localhost:8080/api/users/1`
   - The request includes headers, parameters, and optionally a JSON body.

---

2. **Controller Layer (Presentation Layer)**
   - The request hits a controller method mapped to the URL.
   - Spring Boot uses annotations like `@GetMapping`, `@PostMapping`, etc., to match the request.
   - The controller extracts inputs (`@PathVariable`, `@RequestBody`, etc.) and delegates the call to the service layer.



---

3. **Service Layer (Business Logic Layer)**
   - The controller calls a method in the service class.
   - The service class processes any business logic (e.g., validation, calculations, conditional logic).
   - It then calls the repository layer to fetch or modify data.


---

4. **Repository Layer (Data Access Layer)**
   - The service calls a repository interface (usually extending `JpaRepository`).
   - Spring Data JPA automatically generates the query or uses custom `@Query` if defined.
   - The repository communicates with the database and returns the result to the service layer.


---

5. **Model Layer (Entity Layer)**
   - The repository fetches or saves `@Entity` objects mapped to a database table.
   - These entity objects represent the actual data stored in the database.

---

6. **Response Back to Controller**
   - The repository returns data to the service layer.
   - The service layer returns data (or a DTO) to the controller.
   - The controller returns a response (typically JSON) to Postman.

---

7. **Postman Receives HTTP Response**
   - The client sees the HTTP status (200 OK, 201 Created, 404 Not Found, etc.).
   - The body contains the JSON response with data or error details.

---

### Summary:

**Postman → Controller → Service → Repository → Database → Entity → Repository → Service → Controller → Postman**

Each layer has a clear responsibility, and this structure helps keep code clean, maintainable, and testable.

```



## 6. What is the application.properties? do you know application.yml?
```

### `application.properties`:
- This is the **default configuration file** used in Spring Boot to define application-level settings.
- It is placed in the `src/main/resources` folder.
- Settings in this file control things like:
  - Server port
  - Database connection
  - Logging levels
  - Custom application values
- Example:
```properties
server.port=8081
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=root
spring.datasource.password=secret
logging.level.org.springframework=DEBUG
```

---

### `application.yml`:
- An **alternative to `application.properties`** using YAML (YAML Ain’t Markup Language) syntax.
- It is also placed in `src/main/resources`.
- Preferred by some developers for its **nested structure and readability**.
- Example (equivalent to the above):
```yaml
server:
  port: 8081

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/mydb
    username: root
    password: secret

logging:
  level:
    org.springframework: DEBUG
```

---

### Summary:
- Both files serve the same purpose: configuring your Spring Boot app.
- Use **`.properties`** for simplicity and **`.yml`** for structured, hierarchical configs.
- You can use either one, but avoid mixing both to keep things consistent.
```


## 7. What’s the naming differences between GraphQL vs. REST ? Why is the differences ?

```


### Naming Differences:

#### REST:
- **Resource-oriented naming**.
- Uses **nouns** to represent resources and **HTTP methods** to perform actions.
- Example endpoints:
  - `GET /users` → Get list of users
  - `GET /users/1` → Get user with ID 1
  - `POST /users` → Create a new user
  - `PUT /users/1` → Update user with ID 1
  - `DELETE /users/1` → Delete user with ID 1

#### GraphQL:
- **Action-oriented naming**.
- Uses **fields and types**, usually grouped under **queries** or **mutations**.
- Example operations:
```graphql
# Query
{
  user(id: 1) {
    id
    name
    email
  }
}

# Mutation
mutation {
  createUser(name: "Alice", email: "alice@example.com") {
    id
    name
  }
}
```
- Each field name (like `createUser`, `user`) is descriptive of the operation.

---

### Why the Difference?

#### REST:
- Designed around resources and HTTP verbs.
- Relies on **standard HTTP operations** (GET, POST, PUT, DELETE).
- URL path defines **what resource** is being accessed.
- Emphasizes separation of client and server, with rigid endpoint structures.

#### GraphQL:
- Designed for **flexibility and efficiency**.
- Client **asks exactly for the data it needs**, all in a single endpoint (`/graphql`).
- Focuses on **actions and queries**, not URL paths or HTTP verbs.
- Encourages **descriptive function-style naming** to express what the client wants.

---

### Summary:
| Aspect           | REST Naming                 | GraphQL Naming                    |
|------------------|-----------------------------|-----------------------------------|
| Structure        | Resource-based (nouns)       | Action-based (functions/fields)   |
| Example          | `GET /users/1`              | `user(id: 1)`                      |
| Request format   | URL paths + HTTP verbs       | Queries/Mutations in request body |
| Endpoint count   | Many (one per action)        | One (`/graphql`)                  |

The naming difference exists because **REST is protocol-driven**, while **GraphQL is schema-driven** and designed to let clients control the structure of responses.
```
````
