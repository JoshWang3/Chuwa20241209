### 2. explain how the below annotaitons specify the table in database?  
- @Column(columnDefinition = "varchar(255) default 'John Snow'")： Defines a column with type VARCHAR(255) and a default value of 'John Snow'. The default value applies when no explicit value is provided for this field during insertion.  
- @Column(name="STUDENT_NAME", length=50, nullable=false, unique=false): Specifies that the column should be named "STUDENT_NAME" in the database. 
- @Column without parameters (@Column private String firstName;): The default column name is derived from the field name (firstName).  

### 3. What is the default column names of the table in database for @Column ?  
```
@Entity
public class User {
    @Column
    private String firstName; // Column name: first_name
}
```

### What are the layers in springboot application? what is the role of each layer?  
1. **Controller Layer** - Handles HTTP requests.
2. **Service Layer** - Contains business logic.
3. **Repository Layer** - Handles database operations.


### Describe the flow in all of the layers if an API is called by Postman.  
1. A client (Postman) makes an HTTP request.
2. The controller handles the request and calls the service layer.
3. The service layer processes business logic and calls the repository.
4. The repository interacts with the database and returns data.
5. The service layer formats the response and sends it back through the controller.
6. The controller sends the final response to the client.

### What is the application.properties? do you know application.yml?
- `application.properties` and `application.yml` store configuration settings.
- **Example (application.properties):**
  ```properties
  spring.datasource.url=jdbc:mysql://localhost:3306/mydb
  ```
- **Example (application.yml):**
  ```yaml
  spring:
    datasource:
      url: jdbc:mysql://localhost:3306/mydb
  ```

### What’s the naming differences between GraphQL vs. REST ? Why is the differences ?
- **REST:** Uses URL endpoints (`/users/{id}`).
- **GraphQL:** Uses query names (`query { user(id: 1) { name } }`).

### Provide 2 real-world examples of N+1 problem in REST that can be solved by GraphQL.
- **Example 1:** Fetching posts and their comments.
- **Example 2:** Fetching authors and their posts.
- **Solution:** GraphQL allows batch fetching using nested queries.



