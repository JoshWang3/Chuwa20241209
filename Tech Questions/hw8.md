2. explain how the below annotaitons specify the table in database?  

```sql
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;

columnDefinition: the name column should be of type varchar with a length of 255 characters, and the default value for the column should be 'John Snow'.

@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;

name: the column in the table will be named STUDENT_NAME instead of the default name studentName
length: the STUDENT_NAME column can store up to 50 characters.
nullable: this column cannot have NULL values; it must always have a value
unique: there is no uniqueness constraint on this column.
```

3. What is the default column names of the table in database for @Column ?  

```sql
@Column
private String firstName;
@Column
private String operatingSystem;

firstName will be converted to first_name.
operatingSystem will be converted to operating_system.
```

4. What are the layers in springboot application? what is the role of each layer?  

```
Presentation Layer (Controller Layer):
Handles HTTP requests and responses.
Contains REST controllers or GraphQL resolvers.
Maps user requests to the appropriate service.

Service Layer (Business Logic Layer):
Contains business logic and application rules.
Processes data received from the controller and interacts with the repository layer.
Acts as a bridge between the presentation and repository layers.

Repository Layer (Data Access Layer):
Interacts with the database.
Contains repository interfaces or classes that manage CRUD operations and queries.
Uses JPA, Hibernate, or other persistence frameworks.

Model Layer (Domain Layer):
Defines the core business entities and domain models.
Represents the data structure of the application.
```

5. Describe the flow in all of the layers if an API is called by Postman.  

```
The controller receives the HTTP request from Postman.
It processes the request, validates input, and maps it to a method, in which it calls the corresponding service method.

The service processes the data and may call other services or utility classes for additional processing. Within the method it calls the repository to interact with the database.

The repository performs the necessary CRUD operations or queries.

The data is often transferred between layers using models or DTOs.
The retrieved or modified data is wrapped in these objects and being sent back to the previously mentioned layers.

The service returns the processed data to the controller.
The controller formats the response like in JSON and sends it back to Postman as the HTTP response.
```

6. What is the application.properties? do you know application.yml?  

```
application.properties: a configuration file in Spring Boot used to define application settings.
application.yml: an alternative configuration file using YAML syntax. It is more structured and easier to read
```

7. What’s the naming differences between GraphQL vs. REST ? Why is the differences ?  

```
REST:
Uses endpoint-based naming.
Each resource is identified by a unique URL (e.g., /users, /orders).
Different HTTP methods (GET, POST, PUT, DELETE) indicate actions on the resources.

GraphQL:
Uses schema-based naming.
Single endpoint (/graphql) handles all queries and mutations.
Queries and mutations are named based on the operation (e.g., getUser, createOrder) and are defined in the schema.

Why different:
REST relies on multiple URLs to represent different resources and actions.
GraphQL uses a single endpoint and a schema to describe data operations, focusing on the structure of the request rather than the endpoint.
```

8.  Provide 2 real-world examples of N+1 problem in REST that can be solved by GraphQL.  

```
Fetching Users and Their Posts
1 request GET /users to fetch all users.
+ n requests: GET /users/{id}/posts to fetch posts for each user
GraphQL:
{
  users {
    id
    name
    posts {
      id
      title
    }
  }
}

Fetching Products and Their Reviews
1 request GET /products to fetch all products.
+ n requests: GET /products/{id}/reviews to fetch reviews for each product.
GraphQL:
{
  products {
    id
    name
    reviews {
      id
      comment
    }
  }
}
```

9-10. In project folder