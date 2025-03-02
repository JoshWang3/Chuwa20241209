### create a file to list all of the annotaitons you learned and known, and explain the usage and how do you
   understand it. you need to update it when you learn a new annotation. Please organize those annotations
   well, like annotations used by entity, annotations used by controller.
- File name: annotations.md 
- you'd better also list a code example under the annotations. 

Please see the annotations.md for details.
### explain how the below annotaitons specify the table in database?
```
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;
@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;
```

For the first annotation: 

-  columnDefinition: This directly specifies the SQL column definition
-  It creates a VARCHAR column with maximum length of 255 characters
-  Sets a default value of 'John Snow' if now value is provided during insertion
-  The column name will be the same as the field name "name"

For the second annotation:

- name: Explicitly maps the field to a column named "STUDENT_NAME" in the database
- length: Limits the VARCHAR length to 50 characters
- nullable=false: Makes this a required field(NOT NULL constraint)
- unique=false: states that duplicate values are allowed in this column

### What is the default column names of the table in database for @Column ?
```
@Column
private String firstName;
@Column
private String operatingSystem;
```

- firstname: -> FIRST_NAME
- operatingSystem -> OPERATING_SYSTEM
### What are the layers in springboot application? what is the role of each layer?
- Presentation layer: entry point for handling HTTP requests and manages the interaction between the client and the application by processing requests and returning appropriate responses
- Service layer: core business logic of the application, orchestrating the flow of data between the controller and repository while implementing complex business rules and transactions
- Repository layer: provide a clean interface to interact with the database through methods that handle CRUD operations and custom queries.
- Model layer: define the structure of data through entity classes that represent database tables and STOs for data transfer.

### Describe the flow in all of the layers if an API is called by Postman.
- Postman sends HTTP POST request with JSON data → Request reaches Spring Boot application
- Spring Boot's DispatcherServlet receives the request → Routes to appropriate Controller based on URL
- Controller receives request → Converts JSON to DTO → Validates input → Calls Service layer
- Service layer implements business logic → Transforms DTO to Entity → Calls Repository layer
- Repository layer generates and executes SQL → Interacts with database
- Database performs operation → Returns result
- Repository receives database result → Returns to Service
- Service converts Entity back to DTO → Returns to Controller
- Controller wraps DTO in ResponseEntity → Returns HTTP response
- Postman receives JSON response
### What is the application.properties? do you know application.yml?
application.properties
```
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update

# Server Configuration
server.port=8080
server.servlet.context-path=/api

```
application.yml
```
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/mydb
    username: root
    password: root
  jpa:
    hibernate:
      ddl-auto: update

server:
  port: 8080
  servlet:
    context-path: /api
```
### What’s the naming differences between GraphQL vs. REST ? Why is the differences ?
- REST Naming Conventions

```
GET    /api/users               # Get all users
GET    /api/users/123          # Get specific user
POST   /api/users              # Create user
PUT    /api/users/123          # Update user
DELETE /api/users/123          # Delete user
GET    /api/users/123/posts    # Get user's posts
```
- GraphQL Naming Conventions
```
type Query {
  users: [User]        # Get all users
  user(id: ID): User   # Get specific user
}

type Mutation {
  createUser(input: CreateUserInput): User
  updateUser(id: ID, input: UpdateUserInput): User
  deleteUser(id: ID): Boolean
}

type User {
  id: ID
  name: String
  posts: [Post]        # Get user's posts
}  
```
### Provide 2 real-world examples of N+1 problem in REST that can be solved by GraphQL.
- E-commerce Product Reviews
```
// REST approach - causes N+1 problem
// First request
GET /api/products
[
  { id: 1, name: "iPhone" },
  { id: 2, name: "Samsung" }
]

// Then N additional requests for reviews
GET /api/products/1/reviews
GET /api/products/2/reviews

// GraphQL solution - single request
query {
  products {
    id
    name
    reviews {
      id
      rating
      comment
    }
  }
}
```
-  Social Media User Posts with Comments
```
// REST approach - causes N+1 problem
// First request
GET /api/users
[
  { id: 1, name: "John" },
  { id: 2, name: "Mary" }
]

// Then N requests for each user's posts
GET /api/users/1/posts
GET /api/users/2/posts

// Then N requests for each post's comments
GET /api/posts/1/comments
GET /api/posts/2/comments

// GraphQL solution - single request
query {
  users {
    id
    name
    posts {
      id
      content
      comments {
        id
        text
        author
      }
    }
  }
}
```
### Finish all the following API
   REST
   GET/PUT/DELETE post (with exception cases)
   POST/GET/PUT/DELETE comment (you need to design the table and its relation with Post)
   POST/GET/PUT/DELETE author (you need to design the table and its relation with Post)
   GraphQL
   Query postByID, getAllPost
   Mutation createPost, updatePost
- Database entities and relationships
```
@Entity
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments;
}

@Entity
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}

@Entity
public class Author {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    
    @OneToMany(mappedBy = "author")
    private List<Post> posts;
}
```
- REST APIs
```
@RestController
@RequestMapping("/api")
public class PostController {
    @Autowired
    private PostService postService;
    
    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> getPost(@PathVariable Long id) {
        return postService.getPost(id)
            .map(ResponseEntity::ok)
            .orElseThrow(() -> new ResourceNotFoundException("Post not found"));
    }
    
    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post post) {
        if (!postService.exists(id)) {
            throw new ResourceNotFoundException("Post not found");
        }
        return ResponseEntity.ok(postService.updatePost(id, post));
    }
    
    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        if (!postService.exists(id)) {
            throw new ResourceNotFoundException("Post not found");
        }
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}

@RestController
@RequestMapping("/api")
public class CommentController {
    @Autowired
    private CommentService commentService;
    
    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<Comment> createComment(@PathVariable Long postId, @RequestBody Comment comment) {
        return ResponseEntity.ok(commentService.createComment(postId, comment));
    }
    
    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity<List<Comment>> getComments(@PathVariable Long postId) {
        return ResponseEntity.ok(commentService.getCommentsByPost(postId));
    }
    
    @PutMapping("/comments/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long id, @RequestBody Comment comment) {
        return ResponseEntity.ok(commentService.updateComment(id, comment));
    }
    
    @DeleteMapping("/comments/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }
}

@RestController
@RequestMapping("/api")
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    
    @PostMapping("/authors")
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        return ResponseEntity.ok(authorService.createAuthor(author));
    }
    
    @GetMapping("/authors/{id}")
    public ResponseEntity<Author> getAuthor(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.getAuthor(id));
    }
    
    @PutMapping("/authors/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author author) {
        return ResponseEntity.ok(authorService.updateAuthor(id, author));
    }
    
    @DeleteMapping("/authors/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }
}
```

- GraphQL Schema
```
type Post {
    id: ID!
    title: String!
    content: String!
    author: Author!
    comments: [Comment]!
}

type Author {
    id: ID!
    name: String!
    email: String!
    posts: [Post]!
}

type Comment {
    id: ID!
    content: String!
    post: Post!
}

type Query {
    postById(id: ID!): Post
    getAllPosts: [Post]!
}

type Mutation {
    createPost(title: String!, content: String!, authorId: ID!): Post!
    updatePost(id: ID!, title: String, content: String): Post!
}
```

- GraphQL Resolvers:
```
@Component
public class PostResolver {
    @Autowired
    private PostService postService;
    
    @QueryMapping
    public Post postById(@Argument Long id) {
        return postService.getPost(id)
            .orElseThrow(() -> new GraphQLException("Post not found"));
    }
    
    @QueryMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }
    
    @MutationMapping
    public Post createPost(@Argument String title, @Argument String content, @Argument Long authorId) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        return postService.createPost(post, authorId);
    }
    
    @MutationMapping
    public Post updatePost(@Argument Long id, @Argument String title, @Argument String content) {
        return postService.updatePost(id, title, content)
            .orElseThrow(() -> new GraphQLException("Post not found"));
    }
}
```
### Create a Project, name it with mongo-blog, write a POST API for mongo-blog, change database to MongoDB;
### https://www.mongodb.com/compatibility/spring-boot