# Annotations in Spring Boot


### `@Entity`
- Marks a class as a JPA entity (a table in the database).
- **Example:**
  ```java
  @Entity
  public class User {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;
      
      @Column(name = "username")
      private String username;
  }
  ```

### `@Table`
- Specifies the name of the database table associated with the entity.
- **Example:**
  ```java
  @Entity
  @Table(name = "users")
  public class User { ... }
  ```

### `@Column`
- Defines the column name and properties for an entity field.
- **Default column name:** The field name in Java class.
- **Example:**
  ```java
  @Column(name = "user_email", nullable = false, unique = true)
  private String email;
  ```

### `@Id`
- Specifies the primary key of the entity.
- **Example:**
  ```java
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  ```

### `@GeneratedValue`
- Specifies how the primary key should be generated.
- **Example:**
  ```java
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  ```


### `@RestController`
- Combines `@Controller` and `@ResponseBody`, used to define RESTful web services.
- **Example:**
  ```java
  @RestController
  @RequestMapping("/users")
  public class UserController {
      @GetMapping("/{id}")
      public User getUser(@PathVariable Long id) {
          return userService.getUserById(id);
      }
  }
  ```

### `@RequestMapping`
- Defines a base URL for all endpoints in a controller.
- **Example:**
  ```java
  @RequestMapping("/api")
  public class ApiController { ... }
  ```

### `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`
- Maps HTTP methods to specific handler methods.
- **Example:**
  ```java
  @GetMapping("/users/{id}")
  public User getUser(@PathVariable Long id) { ... }
  ```

### `@PathVariable`
- Extracts URL path parameters.
- **Example:**
  ```java
  @GetMapping("/users/{id}")
  public User getUser(@PathVariable("id") Long userId) { ... }
  ```

### `@RequestParam`
- Extracts query parameters from request URLs.
- **Example:**
  ```java
  @GetMapping("/users")
  public List<User> getUsers(@RequestParam Optional<String> name) { ... }
  ```

### `@RequestBody`
- Binds JSON request body to a Java object.
- **Example:**
  ```java
  @PostMapping("/users")
  public User createUser(@RequestBody User user) { ... }
  ```