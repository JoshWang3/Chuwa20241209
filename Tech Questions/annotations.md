```java
//@Entity Marks a class as a JPA entity.
//@Table Specifies the table name in the database for the entity.
//@Id Specifies the primary key of an entity.
//@GeneratedValue Provides the generation strategy for the primary key.
//@Column Specifies the details of a column in the table.
//@Transient: Marks a field to be ignored by JPA and not persisted in the database.
//@NotNull: Ensures that the column is not null.

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_name", nullable = false)
	private String name;
    @Transient
    private String tempData;
    @NotNull
    private String title;
}

```

```java
//@OneToOne: Defines a one-to-one relationship between two entities.
//@OneToMany: Defines a one-to-many relationship.
//@ManyToOne: Defines a many-to-one relationship.
//@ManyToMany: Defines a many-to-many relationship.
//@JoinColumn: Specifies the foreign key column for a relationship.
//@JoinTable: Defines the join table for @ManyToMany relationships.

@Entity
public class UserProfile {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;
}

@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany
    @JoinTable(
        name = "post_tags",
        joinColumns = @JoinColumn(name = "post_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;
}

```

```java
//@Query: Defines custom JPQL or SQL queries directly in repository interfaces.
//@Modifying: Indicates a query method that modifies data (e.g., INSERT, UPDATE, or DELETE).

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("SELECT p FROM Post p WHERE p.title = :title")
    List<Post> findByTitle(@Param("title") String title);
    
    @Modifying
    @Query("UPDATE Post p SET p.title = :title WHERE p.id = :id")
    void updateTitle(@Param("id") Long id, @Param("title") String title);
}
```

```java
//@NamedQuery: Defines a named JPQL query at the entity level.
@Entity
@NamedQuery(
    name = "Post.findByTitle",
    query = "SELECT p FROM Post p WHERE p.title = :title"
)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
}

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query(name = "Post.findByTitle")
    List<Post> findByTitle(@Param("title") String title);
}

```

```java
//@NamedNativeQuery: Defines a named native SQL query at the entity level.
@Entity
@NamedNativeQuery(
    name = "Post.findByTitleNative",
    query = "SELECT * FROM posts WHERE title = :title",
    resultClass = Post.class
)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
}

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query(nativeQuery = true, name = "Post.findByTitleNative")
    List<Post> findByTitleNative(@Param("title") String title);
}
```



```java
//@RestController Combines @Controller and @ResponseBody, making the class a web controller that returns JSON/XML responses.
//@RequestMapping Maps HTTP requests to handler methods of MVC and REST controllers.
//@GetMapping, @PostMapping, @PutMapping, @DeleteMapping Specialized forms of @RequestMapping for HTTP methods GET, POST, PUT, and DELETE.
//@PathVariable Extracts values from the URI template.
//@RequestParam Binds request parameters to method parameters.
//@RequestBody Binds the body of the HTTP request to a method parameter.
//@ResponseStatus Marks a method or exception class with a status code to be returned.

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @GetMapping("/users/{id}")
	public User getUserById(@PathVariable Long id) {
    	return userService.findById(id);
	}
    @GetMapping("/users")
    public List<User> getUsersByRole(@RequestParam String role) {
        return userService.findByRole(role);
    }
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }
}

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

}

```

```java
//@SpringBootApplication Marks the main class of a Spring Boot application.
//@Component Indicates that a class is a Spring-managed component.
//@Service Specialized @Component annotation used for service-layer classes.
//@Repository Specialized @Component annotation used for DAO or repository classes.
@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}

@Component
public class MyComponent {

}
@Service
public class UserService {

}
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}

```