# Annotations Used in Entities

## @Entity
- Marks a class as a JPA entity, which means it will be mapped to a database table.
- Used in JPA to define the class as a persistent entity.

## @Id
- Marks a field as the primary key of the entity.

## @Table
- Specifies the database table name for the entity. If not specified, the table name defaults to the class name.
- name (optional) specifies the table name explicitly.

## @GeneratedValue
- Specifies the generation strategy for the primary key. Common strategies include AUTO, IDENTITY, SEQUENCE, and TABLE.

## @NotNull, @Size, @Email
- Used to validate fields of a model.

```java
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;
    @Size(min = 2, max = 30)
    private String name;
}
```

# Annotations Used in Controllers

## @RestController
- A specialized version of @Controller that combines @Controller and @ResponseBody. It is used to create RESTful web services.

## @RequestMapping
- Maps HTTP requests to handler methods of MVC and REST controllers. Can be applied at the class or method level.
- Value specifies the URL path, method specifies the HTTP method.

## @GetMapping, @PostMapping, @PutMapping, @DeleteMapping
- Shorthand for @RequestMapping with specific HTTP methods (GET, POST, PUT, DELETE).

```java
@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/users")
    public String getUsers() {
        return "List of users";
    }

    @PostMapping("/users")
    public String createUser() {
        return "User created";
    }
}

```

# Annotations Used for Dependency Injection

## @Autowired
- Used for automatic dependency injection by type.

## @Qualifier
- Used to specify which bean to inject when multiple beans of the same type are available.

## @Resource
- Similar to @Autowired, but resolves dependencies by name first, then by type.

```java
@Service
public class UserService {

    @Autowired / @Resource(name = "userRepository")
    @Qualifier("userRepositoryV1")
    private UserRepository userRepository;
}
```