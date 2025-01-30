## Controller Annotations
```java
// Controller
/**
 * @Controller
 * Marks a class as a Spring MVC controller.
 * It indicates that the class is a web controller and is capable of handling HTTP requests.
 */
@Controller
public class MyController {
    // Web apis call
    @RequestMapping("/hello-world")
    public String helloWorld() {
        return "helloWorld"; // Returns helloWorld
    }
}

/**
 * @RestController
 * Combines @Controller and @ResponseBody, simplifying the creation of RESTful web services.
 * Used for creating RESTful web services, returning data directly as JSON or XML rather than views.
 */
@RestController
public class MyRestController {
    // Web apis call
    @GetMapping("/api/data")
    public String getData() {
        return "Hello, World!"; // Response body as plain text or JSON
    }
}

/**
 * @RequestMapping
 * Maps HTTP requests to handler methods or a class.
 * Can specify the path, HTTP method, headers, or params to handle.
 */
@Controller
@RequestMapping("/api")
public class ApiController {
    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public String getItems() {
        return "items"; // Returns a view name
    }
}

/**
 * @GetMapping, @PostMapping, @PutMapping, @DeleteMapping, @PatchMapping
 * Shortcuts for @RequestMapping with specific HTTP methods.
 */
@RestController
@RequestMapping("/api/v1")
public class MyRestController {
    @GetMapping("/users")
    public List<String> getUsers() {
        return List.of("User1", "User2");
    }

    @PostMapping("/users")
    public String addUser(@RequestBody String user) {
        return "User added: " + user;
    }

    @DeleteMapping("/users/{id}")
    public String removeUser(@PathVariable Long id) {
        return "User removed: " + id;
    }

    @PutMapping("/users/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody String user) {
        return "User updated: " + user;
    }
    
    @PatchMapping("/users/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody String user) {
        return "User updated: " + user;
    }
}

/**
 * Parameter Binding Annotations
 * 1. @RequestParam - Binds query parameters or form data to method parameters.
 * 2. @PathVariable - Binds URI path variables to method parameters.
 * 3. @RequestBody - Binds the body of an HTTP request to a method parameter.
 * 4. @ModelAttribute - Binds form data to an object and adds it to the model.
 * 5. @RequestHeader - Binds HTTP header values to method parameters.
 * 6. @CookieValue - Binds cookie values to method parameters.
 */
@GetMapping("/search")
public String search(@RequestParam String query) {
    return "Searching for: " + query;
}

@GetMapping("/users/{id}")
public String getUser(@PathVariable String id) {
    return "User ID: " + id;
}

@PostMapping("/users")
public String createUser(@RequestBody User user) {
    return "User created: " + user.getName();
}

@PostMapping("/register")
public String register(@ModelAttribute User user) {
    return "User registered: " + user.getName();
}

@GetMapping("/header")
public String headerInfo(@RequestHeader("User-Agent") String userAgent) {
    return "User-Agent: " + userAgent;
}

@GetMapping("/cookie")
public String cookieInfo(@CookieValue("sessionId") String sessionId) {
    return "Session ID: " + sessionId;
}

/**
 * Response Management Annotations
 * 1. @ResponseBody -Indicates that the return value of a method should be written directly to the HTTP response body (as JSON, XML, or plain text).
 * 2. @ResponseStatus - Sets the HTTP status code for a response.
 * 3. @ExceptionHandler - Handles exceptions thrown by controller methods.
 */
@Controller
public class MyController {
    @GetMapping("/data")
    @ResponseBody
    public String getData() {
        return "Hello, World!";
    }
}

@PostMapping("/users")
@ResponseStatus(HttpStatus.CREATED)
public void createUser(@RequestBody User user) {
    // User creation logic
}

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return new ResponseEntity<>("Error: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

/**
 * Miscellaneous Annotations
 * 1. @CrossOrigin - Enables Cross-Origin Resource Sharing (CORS) for a controller or specific method.
 * 2. @SessionAttributes - Specifies which attributes should be stored in the HTTP session.
 * 3. @InitBinder - Customizes data binding for web request parameters
 * 4. @ControllerAdvice - Provides global configurations and exception handling for controllers.
 */
@RestController
@CrossOrigin(origins = "http://example.com")
public class MyRestController {
    @GetMapping("/data")
    public String getData() {
        return "CORS enabled!";
    }
}

@Controller
@SessionAttributes("user")
public class MyController {
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }
}

@Controller
public class MyController {
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
    }
}

@ControllerAdvice
public class GlobalControllerAdvice {
    @ModelAttribute("globalMessage")
    public String globalMessage() {
        return "This is a global message.";
    }
}
```

## Service Layer
```java
/**
 * @Service
 * Marks a class as a service component.
 * It is a specialized form of @Component, used specifically for service-layer logic.
 * Spring automatically detects and registers classes annotated with @Service during component scanning.
 */
@Service
public class MyService {
    public String processData() {
        return "Processing data in Service Layer";
    }
}

/**
 * Dependency Injection
 * 1. @Autowired -- Automatically injects a dependency into a service class (It can be used on fields, constructors, or setter methods.)
 * 2. @Qualifier -- Used with @Autowired to specify which bean to inject when multiple beans of the same type are available.
 * 3. @Value -- Injects values from properties files or environment variables.
 */
@Service
public class MyService {
    @Autowired
    private MyRepository myRepository;

    public void performOperation() {
        myRepository.saveData();
    }
}

@Service
public class MyService {
    @Autowired
    @Qualifier("specialRepository")
    private MyRepository myRepository;
}

@Service
public class MyService {
    @Value("${service.timeout}")
    private int timeout;

    public int getTimeout() {
        return timeout;
    }
}

/**
 * Transactional Management
 * @Transactional
 *  - Declares that a method or class should be executed within a transaction.
 *  - Ensures atomicity, consistency, isolation, and durability (ACID) of operations.
 *  Attributes of @Transactional:
 *      - readOnly: Optimize read-only operations. Example: @Transactional(readOnly = true)
 *      - propagation: Defines how transactions are propagated. Example: @Transactional(propagation = Propagation.REQUIRED)
 *      - isolation: Sets the isolation level for the transaction. Example: @Transactional(isolation = Isolation.READ_COMMITTED)
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Value("${service.defaultRole}")
    private String defaultRole;

    public User createUser(@Valid User user) {
        user.setRole(defaultRole);
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }
}


/**
 * Aspect-Oriented Programming (AOP)
 * Annotations used for cross-cutting concerns like logging, security, or monitoring in the service layer.
 * 1. @Aspect -- Declares a class as an aspect in AOP.
 * 2. @Before, @After, @Around, @AfterReturning, @AfterThrowing -- Define advice for specific join points in AOP.
 */
@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* com.example.service.*.*(..))")
    public void logBefore() {
        System.out.println("Logging before method execution");
    }
}

@Aspect
public class AuditAspect {
    @Around("execution(* com.example.service.*.*(..))")
    public Object audit(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Before executing method: " + joinPoint.getSignature().getName());
        Object result = joinPoint.proceed();
        System.out.println("After executing method: " + joinPoint.getSignature().getName());
        return result;
    }
}

/**
 * Validation - Annotations for input validation in service classes.
 * @Valid - Validates an object against constraints specified in the model class.
 * @Validated - Enables validation on the service class or methods.
 */
@Service
public class MyService {
    public void validateUser(@Valid User user) {
        // Service logic
    }
}

@Service
@Validated
public class MyService {
    public void validateData(@Min(1) int value) {
        // Validation logic
    }
}

/**
 * Miscellaneous Annotations
 * 1. @Scope - Defines the scope of a service bean, such as singleton, prototype, etc.
 * 2. @PostConstruct and @PreDestroy - Lifecycle callbacks for initialization and destruction of service beans.
 */
@Service
@Scope("prototype")
public class MyService {
    public void execute() {
        // Business logic
    }
}

@Service
public class MyService {
    @PostConstruct
    public void init() {
        System.out.println("Service initialized");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Service destroyed");
    }
}
```

## Repository
```java
/**
 * Key Annotations for Repositories
 * @Repository
 *  - Marks a class as a repository, indicating it is part of the persistence layer.
 *  - It is a specialization of @Component, allowing Spring to detect and register it during component scanning.
 *  - It also provides automatic exception translation for database-related exceptions (e.g., converting SQLException into DataAccessException).
 */
@Repository
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> findAllUsers() {
        return jdbcTemplate.query("SELECT * FROM users", new UserRowMapper());
    }
}

/**
 * Annotations for Spring Data JPA Repositories
 * 1. @Query - Defines custom JPQL or SQL queries for repository methods.
 * 2. @Modifying - Used with @Query for update or delete operations in the database.
 * 3. @Param - Maps method parameters to named parameters in custom queries.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.age > :age")
    List<User> findUsersOlderThan(@Param("age") int age);
}

@Modifying
@Query("UPDATE User u SET u.status = :status WHERE u.id = :id")
void updateUserStatus(@Param("id") Long id, @Param("status") String status);

/**
 * Transaction Management
 * @Transactional 
 *  - Ensures that methods in the repository execute within a transactional context.
 *  - If applied at the class level, it applies to all methods in the class.
 */
@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
    @Modifying
    @Query("DELETE FROM User u WHERE u.lastLogin < :timestamp")
    void deleteInactiveUsers(@Param("timestamp") LocalDateTime timestamp);
}

/**
 * Pagination and Sorting
 * Pageable and Sort - Used to pass pagination and sorting parameters to repository methods.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Page<User> findByAgeGreaterThan(int age, Pageable pageable);
}

/**
 * Caching Annotations
 * 1. @Cacheable - Caches the result of a method so subsequent calls with the same parameters are faster.
 * 2. @CacheEvict - Clears cache entries when specific conditions are met.
 * 3. @CachePut - Updates the cache with the result of a method.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Cacheable("users")
    List<User> findAll();
}

@CacheEvict(value = "users", allEntries = true)
void deleteById(Long id);

@CachePut(value = "users", key = "#user.id")
User save(User user);

/**
 * Custom Repository Implementations
 * 1. @EnableJpaRepositories - Enables JPA repository support and scans for repository interfaces in specified packages.
 * 2. @NoRepositoryBean - ndicates that a repository interface is not meant to be instantiated directly. Used for creating base repository interfaces.
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.example.repository")
public class JpaConfig {
}

@NoRepositoryBean
public interface BaseRepository<T, ID> extends JpaRepository<T, ID> {
    void refresh(T entity);
}

// Example:
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Custom query
    @Query("SELECT u FROM User u WHERE u.lastName = :lastName")
    List<User> findByLastName(@Param("lastName") String lastName);

    // Modifying query with transaction management
    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.status = :status WHERE u.id = :id")
    void updateStatus(@Param("id") Long id, @Param("status") String status);

    // Pagination and sorting
    Page<User> findByAgeGreaterThan(int age, Pageable pageable);

    // Caching
    @Cacheable("users")
    List<User> findAll();
}
```

## Entity
```java
// In Spring, the Entity Layer represents the application's data model and is mapped to database tables. 
// This layer leverages annotations from Java Persistence API (JPA) and Hibernate (a common JPA implementation) 
// to define the structure of the entities, their relationships, and various configurations for persistence.

/**
 * Core Entity Annotations
 * 1. @Entity - Marks a class as a JPA entity, mapping it to a database table.
 * 2. @Table - Specifies the table name and schema for the entity in the database.
 */
@Entity
@Table(name = "users", schema = "public")
public class User {
    @Id
    private Long id;
    private String name;
}

/**
 * Annotations for Primary Key
 * 1. @Id - Marks a field as the primary key for the entity.
 * 2. @GeneratedValue - Specifies how the primary key is generated (e.g., auto-increment, sequence, UUID).
 * 3. @SequenceGenerator - Defines a sequence generator for GenerationType.SEQUENCE
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_sequence", allocationSize = 1)
    private Long id;
}

/**
 * Column-Level Annotations
 * 1. @Column - Maps a field to a specific column in the table. Allows configuration of the column's properties (e.g., name, nullable, length, unique).
 * 2. @Transient - Excludes a field from being persisted in the database.
 * 3. @Lob - Maps a field to a large object (LOB), such as text (CLOB) or binary (BLOB).
 * 4. @Enumerated - Maps an enum field to a database column, stored as either ordinal (integer) or string.
 * 5. @Temporal - Maps a Date or Calendar field to a specific database temporal type (DATE, TIME, or TIMESTAMP).
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "full_name", nullable = false, length = 100, unique = true)
    private String name;

    @Transient
    private int temporaryValue;

    @Lob
    private String largeText;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
}

/**
 * Relationship Annotations
 * -- Used to define relationships between entities.
 * 1. @OneToOne - Specifies a one-to-one relationship.
 * 2. @OneToMany - Specifies a one-to-many relationship.
 * 3. @ManyToOne - Specifies a many-to-one relationship.
 * 4. @ManyToMany - Specifies a many-to-many relationship.
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "full_name", nullable = false, length = 100, unique = true)
    private String name;

    @OneToOne
    @JoinColumn(name = "profile_id")
    private UserProfile profile;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToMany
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;
}

/**
 * Auditing Annotations
 * 1. @CreatedDate - Automatically sets the field with the entity's creation date.
 * 2. @LastModifiedDate - Automatically sets the field with the last modification date.
 * 3. @CreatedBy - Automatically sets the field with the user who created the entity.
 * 4. @LastModifiedBy - Automatically sets the field with the user who last modified the entity.
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "full_name", nullable = false, length = 100, unique = true)
    private String name;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    @CreatedBy
    private String createdBy;

    @LastModifiedBy
    private String lastModifiedBy;
}

/**
 * Validation Annotations
 * 1. @NotNull
 * 2. @Size
 * 3. @Min and @Max
 * 4. @Pattern - Ensures the field matches a specific regular expression.
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_sequence", allocationSize = 1)
    private Long id;

    @NotNull
    private String name;

    @Size(min = 3, max = 50)
    private String name;

    @Min(18)
    @Max(100)
    private int age;

    @Pattern(regexp = "^[A-Za-z0-9]*$")
    private String username;
}


// Example
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false, length = 100)
    @NotNull
    @Size(min = 2, max = 100)
    private String name;

    @Column(unique = true)
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders;

    @PrePersist
    public void onPrePersist() {
        this.createdDate = new Date();
    }
}
```

## Exception Handling
```java
/**
 * @ExceptionHandler - Used to define a method in a controller or a class annotated with @ControllerAdvice to handle specific exceptions.
 */
@RestController
public class UserController {

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        return new User(); // Replace with actual logic
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}

/**
 * @ControllerAdvice
 * Marks a class as a centralized exception handler for one or more controllers.
 * Works in combination with @ExceptionHandler
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
    }
}

/**
 * @RestControllerAdvice
 */
@RestControllerAdvice
public class GlobalRestExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body("Invalid argument: " + ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
    }
}
```

## Config
```java
/**
 * @Configuration
 * Marks a class as a source of bean definitions for the Spring container.
 * Classes annotated with @Configuration can define beans using the @Bean annotation.
 */
@Configuration
public class AppConfig {

    @Bean
    public MyService myService() {
        return new MyServiceImpl();
    }
}
```

## Spring Security
```java
/**
 * 1. @EnableWebSecurity
 * Enables Spring Security for a web application and allows customization of the security configuration.
 * Typically used on a configuration class that extends WebSecurityConfigurerAdapter (or implements SecurityFilterChain in modern Spring versions).
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override // Overrides the configure method to define custom security rules.
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests() // Begins defining rules for request authorization.
                .antMatchers("/public/**").permitAll() // Allows unrestricted access to any URL that starts with "/public/".
                .anyRequest().authenticated() // Requires authentication for all other requests.
                .and() // Ends the current configuration block and allows chaining additional configurations.
                .formLogin(); // Enables default form-based login for authentication.
    }
}

/**
 * 2. @EnableGlobalMethodSecurity
 * Enables method-level security annotations like @PreAuthorize and @PostAuthorize.
 * Commonly used with securedEnabled, jsr250Enabled, or prePostEnabled attributes.
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {
}

/**
 * 3. @PreAuthorize
 * Used to specify authorization rules before a method is invoked.
 * Typically used with Spring Expression Language (SpEL) to define access conditions.
 */
@Service
public class MyService {

    @PreAuthorize("hasRole('ADMIN')")
    public void adminMethod() {
        // Only accessible by users with ADMIN role
    }

    @PreAuthorize("#user.name == authentication.name")
    public void updateUser(User user) {
        // Accessible only if the authenticated user's name matches the user's name
    }
}

/**
 * 4. @PostAuthorize
 * Similar to @PreAuthorize, but the authorization rule is applied after the method has been executed.
 * Useful for applying rules based on the method's return value.
 */
@Service
public class MyService {

    @PostAuthorize("returnObject.owner == authentication.name")
    public Resource getResource(Long id) {
        // Only returns resources owned by the authenticated user
        return resourceRepository.findById(id).orElseThrow();
    }
}

/**
 * 5. @Secured
 * Used to specify that a method requires specific roles.
 * Unlike @PreAuthorize, it doesn't support SpEL expressions.
 */
@Service
public class MyService {

    @Secured("ROLE_ADMIN")
    public void performAdminTask() {
        // Only accessible by users with ADMIN role
    }
}

/**
 * 6. @RolesAllowed
 * Similar to @Secured, but follows the JSR-250 standard.
 */
@Service
public class MyService {

    @RolesAllowed("ROLE_USER")
    public void userTask() {
        // Only accessible by users with USER role
    }
}

/**
 * 7. @PermitAll and @DenyAll
 * These annotations are part of the JSR-250 standard.
 * @PermitAll allows unrestricted access to a method, while @DenyAll restricts all access.
 */
@Service
public class MyService {

    @PermitAll
    public void openMethod() {
        // Accessible to everyone
    }

    @DenyAll
    public void restrictedMethod() {
        // Accessible to no one
    }
}

/**
 * @CrossOrigin (Spring Security with CORS)
 * Used to enable Cross-Origin Resource Sharing (CORS) for specific methods or controllers.
 */
@RestController
@CrossOrigin(origins = "http://example.com")
public class MyController {

    @GetMapping("/api/data")
    public String getData() {
        return "Secure Data";
    }
}
```

## Spring AOP
```java
/**
 * @Aspect
 * Marks a class as an aspect, which contains advice (code) to be applied to specific join points.
 */
@Aspect
@Component
public class LoggingAspect {
    // Advice methods go here
}

/**
 * @Before
 * Defines advice that runs before a matched method execution.
 */
@Before("execution(* com.example.service.*.*(..))")
public void logBeforeMethod(JoinPoint joinPoint) {
    System.out.println("Executing: " + joinPoint.getSignature());
}

/**
 * @After
 * Defines advice that runs after a matched method execution, regardless of its outcome (success or exception).
 */
@After("execution(* com.example.service.*.*(..))")
public void logAfterMethod(JoinPoint joinPoint) {
    System.out.println("Completed: " + joinPoint.getSignature());
}

/**
 * @AfterReturning
 * Defines advice that runs after a method returns successfully.
 */
@AfterReturning(pointcut = "execution(* com.example.service.*.*(..))", returning = "result")
public void logAfterReturning(JoinPoint joinPoint, Object result) {
    System.out.println("Method returned: " + result);
}

/**
 * @AfterThrowing
 * Defines advice that runs if a method throws an exception.
 */
@AfterThrowing(pointcut = "execution(* com.example.service.*.*(..))", throwing = "ex")
public void logAfterThrowing(JoinPoint joinPoint, Throwable ex) {
    System.out.println("Exception thrown: " + ex.getMessage());
}

/**
 * @Around
 * Defines advice that runs before and after the method execution. 
 * It provides the most control because you can decide whether to proceed with the method execution.
 */
@Around("execution(* com.example.service.*.*(..))")
public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
    System.out.println("Before method: " + joinPoint.getSignature());
    Object result = joinPoint.proceed(); // Proceed with method execution
    System.out.println("After method: " + joinPoint.getSignature());
    return result;
}

/**
 * @Pointcut
 * Defines reusable pointcut expressions. This allows you to use the same expression in multiple advice methods.
 */
@Pointcut("execution(* com.example.service.*.*(..))")
public void serviceMethods() {
    // This is a pointcut definition
}

@Before("serviceMethods()")
public void logBeforeServiceMethods() {
    System.out.println("Executing service method");
}

/**
 * Example:
 */
// Marks this class as an Aspect for AOP functionality
@Aspect

// Marks this class as a Spring-managed component so it can be autowired into the application context
@Component
public class LoggingAspect {

    // Defines a reusable pointcut expression for all method executions within the com.example.service package and its sub-packages
    @Pointcut("execution(* com.example.service.*.*(..))")
    public void serviceLayer() {}

    // Advice to log a message before methods matching the serviceLayer() pointcut are executed
    @Before("serviceLayer()")
    public void logBeforeMethod(JoinPoint joinPoint) {
        // Logs the name of the method being executed
        System.out.println("Executing: " + joinPoint.getSignature().getName());
    }

    // Advice to log a message after methods matching the serviceLayer() pointcut return successfully
    @AfterReturning(pointcut = "serviceLayer()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        // Logs the name of the method and the result it returned
        System.out.println("Method returned: " + result);
    }

    // Advice to log a message when a method matching the serviceLayer() pointcut throws an exception
    @AfterThrowing(pointcut = "serviceLayer()", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable ex) {
        // Logs the name of the method and the exception message
        System.out.println("Exception thrown: " + ex.getMessage());
    }

    // Advice to log messages both before and after methods matching the serviceLayer() pointcut are executed
    @Around("serviceLayer()")
    public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        // Logs the method name before execution
        System.out.println("Before method: " + joinPoint.getSignature().getName());

        // Proceeds with the method execution and captures the result
        Object result = joinPoint.proceed();

        // Logs the method name after execution
        System.out.println("After method: " + joinPoint.getSignature().getName());

        // Returns the result of the method execution
        return result;
    }
}
```

## Spring Task
```java
/**
 * @EnableScheduling: Enables Spring's scheduled task execution capability.
 * @EnableAsync: Enables Spring's asynchronous method execution capability.
 * @Async: Used to mark a method for asynchronous execution. The method runs in a separate thread provided by a task executor.
 */
@Configuration
@EnableAsync
@EnableScheduling
public class TaskConfig {

    @Bean
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(25);
        executor.setThreadNamePrefix("AsyncExecutor-");
        executor.initialize();
        return executor;
    }
}

@Service
public class AsyncService {

    @Async
    public void performTask() {
        System.out.println("Executing task in thread: " + Thread.currentThread().getName());
    }
}

/**
 * @Scheduled
 * Used to define scheduled tasks.
 * Supports fixed rate, fixed delay, and cron expressions.
 */
@Service
public class ScheduledTask {

    // Runs every 5 seconds
    @Scheduled(fixedRate = 5000)
    public void runAtFixedRate() {
        System.out.println("Fixed rate task: " + System.currentTimeMillis());
    }

    // Runs 5 seconds after the last execution finishes
    @Scheduled(fixedDelay = 5000)
    public void runAtFixedDelay() {
        System.out.println("Fixed delay task: " + System.currentTimeMillis());
    }

    // Runs at 8:00 AM every day
    @Scheduled(cron = "0 0 8 * * ?")
    public void runWithCron() {
        System.out.println("Cron-based task: " + System.currentTimeMillis());
    }
}

```

## Spring Batch
```java
/**
 * @EnableBatchProcessing
 * Enables Spring Batch features in your application and provides a base configuration for setting up batch jobs.
 */
@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Bean
    public Job exampleJob(JobBuilderFactory jobBuilderFactory, Step exampleStep) {
        return jobBuilderFactory.get("exampleJob")
                .start(exampleStep)
                .build();
    }

    @Bean
    public Step exampleStep(StepBuilderFactory stepBuilderFactory, ItemReader<String> reader,
                            ItemProcessor<String, String> processor, ItemWriter<String> writer) {
        return stepBuilderFactory.get("exampleStep")
                .<String, String>chunk(5)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    @Bean
    @StepScope
    public FlatFileItemReader<String> reader(@Value("#{jobParameters['inputFile']}") String inputFile) {
        FlatFileItemReader<String> reader = new FlatFileItemReader<>();
        reader.setResource(new FileSystemResource(inputFile));
        return reader;
    }

    @Bean
    public ItemProcessor<String, String> processor() {
        return item -> item.toUpperCase();
    }

    @Bean
    public ItemWriter<String> writer() {
        return items -> items.forEach(System.out::println);
    }
}
```