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

# Annotations Used for Spring IOC (Inversion of Control) 

## @Component
- Marks a class as a Spring-managed component.

## @Service
- Marks a class as a service component in the application.

## @Controller
- Indicates a class is a Spring MVC controller.

## @RestController
- Combines @Controller and @ResponseBody for REST APIs.

## @Scope
- Defines the scope of a Spring bean (e.g., singleton, prototype).

## @Value
- Injects values from properties files or environment variables.

## @Configuration
- Indicates a class has Spring bean definitions.

## @Bean
- Declares a method as a Spring bean definition.

## @Primary
- Indicates a bean should be preferred when multiple candidates are present.

## @Profile
- Activates beans only for specified profiles.

# Annotations Used for Spring DI (Dependency Injection) 

## @Lazy
- Marks a bean to be lazily initialized. The bean is only created when it is first accessed, not during application startup.