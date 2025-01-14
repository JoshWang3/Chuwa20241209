## Annotations

### Entity Annotations

1. **@Entity**
   - **Usage**: Specifies that the class is an entity and is mapped to a database table.
   - **Code Example:**
     ```java
     @Entity
     public class Post {
         @Id
         @GeneratedValue(strategy = GenerationType.IDENTITY)
         private Long id;
     }
     ```

2. **@Table**
   - **Usage**: Specifies the table in the database associated with the entity.
   - **Code Example:**
     ```java
     @Entity
     @Table(name = "posts")
     public class Post {
         // fields
     }
     ```

3. **@Column**
   - **Usage**: Specifies the mapped column for a persistent property or field.
   - **Code Example:**
     ```java
     @Column(name = "title", nullable = false, unique = true)
     private String title;
     ```

4. **@Id**
   - **Usage**: Specifies the primary key.
   - **Code Example:**
     ```java
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     ```

5. **@GeneratedValue**
   - **Usage**: Provides the generation strategy for primary keys.
   - **Code Example:**
     ```java
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;
     ```

### Controller Annotations

1. **@RestController**
   - **Usage**: Combines `@Controller` and `@ResponseBody` to handle web requests.
   - **Code Example:**
     ```java
     @RestController
     public class PostController {
         @GetMapping("/posts")
         public List<Post> getAllPosts() {
             return new ArrayList<>();
         }
     }
     ```

2. **@GetMapping**
   - **Usage**: Maps HTTP GET requests to specific handler methods.
   - **Code Example:**
     ```java
     @GetMapping("/posts/{id}")
     public Post getPostById(@PathVariable Long id) {
         return new Post();
     }
     ```

3. **@PostMapping**
   - **Usage**: Maps HTTP POST requests to specific handler methods.
   - **Code Example:**
     ```java
     @PostMapping("/posts")
     public Post createPost(@RequestBody Post post) {
         return post;
     }
     ```

4. **@DeleteMapping**
   - **Usage**: Maps HTTP DELETE requests to specific handler methods.
   - **Code Example:**
     ```java
     @DeleteMapping("/posts/{id}")
     public void deletePost(@PathVariable Long id) {
         // delete logic
     }
     ```

### Layers in Spring Boot Application

1. **Controller Layer**
   - Handles HTTP requests and responses.
   - Example: `PostController`.

2. **Service Layer**
   - Contains business logic.
   - Example: `PostService`.

3. **Repository Layer**
   - Handles database interactions.
   - Example: `PostRepository`.

### Flow in Layers when API is Called by Postman
1. **Client sends request via Postman**.
2. **Controller Layer**: Receives the request.
3. **Service Layer**: Processes business logic.
4. **Repository Layer**: Interacts with the database.
5. **Response returned to Postman**.

### application.properties vs. application.yml
- **application.properties**: Key-value pairs.
- **application.yml**: Hierarchical structure, more readable.

### Naming Differences Between GraphQL vs. REST
- GraphQL uses a hierarchical naming convention.
- REST uses HTTP verbs.
- **Reason**: GraphQL provides flexibility in querying specific data, while REST relies on predefined endpoints.

### Real-World N+1 Problems in REST Solved by GraphQL
1. Fetching posts and their comments:
   - **REST**: Multiple calls to fetch posts and then comments for each post.
   - **GraphQL**: Single query to fetch posts along with comments.
2. Fetching authors and their posts:
   - **REST**: Separate calls for authors and their posts.
   - **GraphQL**: Single query to fetch authors with their posts.

### API Endpoints

#### REST
1. **Post APIs**:
   ```java
   @RestController
   @RequestMapping("/posts")
   public class PostController {
       @GetMapping
       public List<Post> getAllPosts() {}

       @PostMapping
       public Post createPost(@RequestBody Post post) {}

       @PutMapping("/{id}")
       public Post updatePost(@PathVariable Long id, @RequestBody Post post) {}

       @DeleteMapping("/{id}")
       public void deletePost(@PathVariable Long id) {}
   }
   ```

2. **Comment APIs**:
   ```java
   @RestController
   @RequestMapping("/comments")
   public class CommentController {
       @GetMapping
       public List<Comment> getAllComments() {}

       @PostMapping
       public Comment createComment(@RequestBody Comment comment) {}

       @PutMapping("/{id}")
       public Comment updateComment(@PathVariable Long id, @RequestBody Comment comment) {}

       @DeleteMapping("/{id}")
       public void deleteComment(@PathVariable Long id) {}
   }
   ```

3. **Author APIs**:
   ```java
   @RestController
   @RequestMapping("/authors")
   public class AuthorController {
       @GetMapping
       public List<Author> getAllAuthors() {}

       @PostMapping
       public Author createAuthor(@RequestBody Author author) {}

       @PutMapping("/{id}")
       public Author updateAuthor(@PathVariable Long id, @RequestBody Author author) {}

       @DeleteMapping("/{id}")
       public void deleteAuthor(@PathVariable Long id) {}
   }
   ```

#### GraphQL
```graphql
query {
  postById(id: "1") {
    title
  }
  getAllPosts {
    id
    title
  }
}

mutation {
  createPost(input: {title: "New Post"}) {
    id
  }
}
```

### Mongo Blog Project

#### Setup MongoDB Configuration
```yaml
spring:
  data:
    mongodb:
      database: mongo-blog
      uri: mongodb://localhost:27017/mongo-blog
```

#### Create a POST API for Mongo Blog
```java
@RestController
@RequestMapping("/mongo-blog")
public class BlogController {
    @Autowired
    private BlogRepository blogRepository;

    @PostMapping
    public Blog createBlog(@RequestBody Blog blog) {
        return blogRepository.save(blog);
    }
}
```
