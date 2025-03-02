## Annotations Used by Entity

---

1. @Entity
- Usage: Marks a class as a JPA entity representing a database table.
```
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
```

2. @Id
- Usage: Specifies the primary key of an entity.
```
@Id
private Long id;
```

3. @GeneratedValue
- Usage: Configures how the primary key is generated (e.g., auto-increment).
```
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
```

4. @Column
- Usage: Maps a field to a specific column in the database with additional customization.
```
@Column(name = "user_name", nullable = false)
private String name;
```

5. @OneToMany
- Usage: Defines a one-to-many relationship between two entities.
```
@OneToMany(mappedBy = "department")
private List<Employee> employees;
```

6. @ManyToOne
- Usage: Defines a many-to-one relationship.
```
@ManyToOne
@JoinColumn(name = "department_id")
private Department department;
```

## Annotations Used by Controller

---

1. @RestController
- Usage: Marks a class as a RESTful controller, combining @Controller and @ResponseBody.
```
@RestController
@RequestMapping("/api/users")
public class UserController {
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return new User();
    }
}
```

2. @RequestMapping
- Usage: Maps HTTP requests to handler methods or classes.
```
@RequestMapping("/api")
public class ApiController {
    // Methods
}
```

3. @GetMapping
- Usage: Shortcut for @RequestMapping with the HTTP GET method.
```
@GetMapping("/users")
public List<User> getAllUsers() {
    return List.of(new User());
}
```

4. @PostMapping
- Usage: Shortcut for @RequestMapping with the HTTP POST method.
```
@PostMapping("/users")
public User createUser(@RequestBody User user) {
    return user;
}
```

5. @PathVariable
- Usage: Binds a URI variable to a method parameter.
```
@GetMapping("/users/{id}")
public User getUser(@PathVariable Long id) {
    return new User();
}
```

6. @RequestBody
- Usage: Maps the body of an HTTP request to a Java object.
```
@PostMapping("/users")
public User createUser(@RequestBody User user) {
    return user;
}
```

7. @ExceptionHandler
- Usage: Handles exceptions within the controller.
```
@ExceptionHandler(Exception.class)
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public String handleException(Exception ex) {
    return ex.getMessage();
}
```

8. @ResponseStatus
- Usage: Sets the HTTP status code for the response.
```
@ResponseStatus(HttpStatus.CREATED)
public User createUser(@RequestBody User user) {
    return user;
}
```