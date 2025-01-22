## Annotations for Controllers
### 1. @RestController
Usage: Combine @Controller and @ResponseBody to handle HTTP request
Example:
```
@RestController
@RequestMapping("/api/v2/posts")
public class PostController {
  
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
```
### 2. @RequestMapping
Usage: Define the mapping of HTTP requests to handler methods or classes.
Example: see above
### 3. @GetMapping, @PostMapping, @PutMapping, @DeleteMapping
Usage: specific HTTP methods
Example:
```
    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable Long id) {
        return ResponseEntity.ok(postService.getPost(id));
    }

    @PostMapping
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO post) {
        PostDTO response = postService.createPost(post);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO post, @PathVariable Long id) {
        PostDTO response = this.postService.updatePost(id, post);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable Long id) {
        postService.deletePost(id);
        return new ResponseEntity<>("deleted",HttpStatus.OK);
    }

```
### 4. @PathVariable
Usage: Binds a URI template variable to a method parameter.
Example:
```
    @GetMapping("/partial/{id}")
    public ResponseEntity<PostDTO2nd> getPost2ndById(@PathVariable Long id) {
        return ResponseEntity.ok(postService.getPost2nd(id));
    }
```

### 5. @RequestBody
Usage: Binds the HTTP request body to a method parameter.
Example:
```
@PostMapping
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO post) {
        PostDTO response = postService.createPost(post);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
```

### 6. @Controller
Usage: Marks a class as a controller in the MVC architecture.
Example:
```
@Controller
public class PostGraphQLController {
    private PostService postService;

    public PostGraphQLController(PostService postService) {
        this.postService = postService;
    }
```

### 7. @ResponseStatus
Usage: Sets the HTTP status code for a response.
Example:
```
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private String resourceName;
    private String fieldName;
    private long fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
        super(String.format("Resource %s not found", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
...
}    
```


## Annotations for Entity
### 1. @Entity
Usage: Marks a class as a JPA entity, mapping it to a database table.
Example:
```
@Entity
@Table(
        name = "posts",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = {"title"})
        }
)
```

### 2. @Table
Usage: Specifies the database table name for an entity.
Example: See above

### 3. @Id
Usage: Marks a field as the primary key.
Example:
```
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
```

### 4. @GeneratedValue
Usage: Specifies the strategy for generating primary key values.
Example: See @Id

### 5. @Column
Usage: Maps a field to a specific database column. Optional if the column name matches the field name.
Example:
```
@Column(name = "title", nullable = false)
    private String title;
    @Column(name = "content", nullable = false)
    private String content;
```

### 6. @CreationTimestamp
Usage: Automatically populates a field with the creation timestamp when the entity is persisted.
Example:
```
@CreationTimestamp
private LocalDateTime createDateTime;
```

### 7. @UpdateTimestamp
Usage: Automatically updates a field with the current timestamp whenever the entity is updated.
Example:
```
@UpdateTimestamp
private LocalDateTime updateDateTime;

```

## Global Spring Annotations
### 1. @SpringBootApplication
Usage:
Example:

```
@SpringBootApplication
public class RedbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedbookApplication.class, args);
	}
}
```


## Annotations for GraphQL
### 1. @QueryMapping
Usage: Marks a method as a GraphQL query resolver.
Example:

```
@QueryMapping
    public PostDTO postById(@Argument Long id) {
        return this.postService.getPost(id);
    }
```


### 2. @MutationMapping
Usage: Marks a method as a GraphQL mutation resolver.
Example:

```
@MutationMapping
    public PostDTO createPost(@Argument String title, @Argument String content, @Argument String description){
        PostDTO postDTO = new PostDTO();

        postDTO.setTitle(title);
        postDTO.setContent(content);
        postDTO.setDescription(description);

        return this.postService.createPost(postDTO);
    }
```


## Annotations for Service
### 1. @Service
Usage: Marks a class as a service layer component. It contains the business logic of the application.
Example:

```
@Service
public class PostServiceImpl implements PostService{
    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

...

```

### 2. @Autowired
Usage: Injects dependencies into fields, constructors, or methods.
Example:

```
@Autowired
private PostService postService;
```

## Annotations for Bean Management or Lifecycle
### 1. @Component
Usage: Marks a class as a Spring-managed bean.

### 2. @Bean
Usage: Declares a bean in a Spring @Configuration class.

### 3. @Scope
Usage: Defines the scope of a bean (e.g., singleton, prototype

### 4. @Primary
Usage: Specifies the default bean to inject when multiple beans of the same type exist.

### 5. @Lazy
Usage: It is specifically used to control lazy initialization of beans. Works with both singleton and prototype scoped beans.


## Annotations for Configuration Annotations
### 1. @ComponentScan
Usage: Scans for Spring-managed components and registers them in the application context.

## Annotations for Persistence Layer Annotations
### 1. @Repository
Usage: Marks a class as a DAO, enabling database-related operations and exception translation.


## Annotations forDependency Injection Annotations
### 1. @Qualifier
Usage: Resolves ambiguity when multiple beans of the same type exist.

### 2. @Resource
Usage: Injects beans by name (and optionally by type).

### 3. @Inject
Usage: General-purpose Java EE/CDI injection annotation, similar to @Autowired
