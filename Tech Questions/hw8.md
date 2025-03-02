# HW8
____
### 2. explain how the below annotations specify the table in database
```java
@Column(columnDefinition = "VARCHAR(255) default 'John Snow")
private String name;

@Column(name = "STUDENT_NAME", length=50, nullable = false, unique=false)
private String studentName;
```
Column `name` is defined as a `VARCHAR` type with a default value of `John Snow`. Column `studentName` is defined as a `VARCHAR` type with a length of 50, not nullable, and not unique.

### 3. What is the default column names of the table in database for @Column
```java
@Column
private String firstName;
@Column
private String operatingSystem;
```

The default column names for the table in the database for `firstName` and `operatingSystem` are `first_name` and `operating_system` respectively.

### What are the layers in Spring Boot application? What is the role of each layer?
- **Controller Layer**: handles incoming HTTP requests and sends responses back to the client.
- **Service Layer**: contains business logic and acts as a bridge between the controller and the repository layer.
- **Repository Layer**: interacts with the database and performs CRUD operations.
- **Model Layer**: contains the domain objects or entities that represent the data in the application.

### 5. Describe the flow in all of the layers if an API is called by Postman
- The request is sent from Postman to the Controller Layer.
- The Controller Layer receives the request and processes it.
- The Controller Layer calls the appropriate method in the Service Layer.
- The Service Layer performs the necessary business logic and may call methods in the Repository Layer.
- The Repository Layer interacts with the database and performs CRUD operations.
- The Repository Layer returns the data to the Service Layer, which then returns it to the Controller Layer.
- The Controller Layer sends the response back to Postman.

### 6. What is the application.properties? Do you know application.yml?
- application.properties: a file used to configure the properties of a Spring Boot application. It can be used to set database configurations, server port, logging levels, etc.
- application.yml: an alternative to application.properties that uses YAML syntax for configuration. It provides a more human-readable format for configuration properties.

### 7. What is the naming differences between GraphQL and REST? Why?
- In REST, the endpoints are typically named based on the resources they represent, such as `/users` or `/products`.
- In GraphQL, the endpoints are not predefined and are instead defined by the client in the query. The client specifies the fields and relationships it wants to retrieve in a single request.
- This difference exists because REST follows a resource-oriented approach, while GraphQL follows a query-oriented approach that allows clients to request only the data they need.

### 8. Provide 2 real-world examples of N+1 problem in REST that can be solved by GraphQL
1. **Fetching a list of users and their associated posts**: In a REST API, if you fetch a list of users and then need to fetch the posts for each user, you may encounter the N+1 problem. This would result in multiple requests to fetch posts for each user, leading to performance issues. With GraphQL, you can fetch the users and their posts in a single query, avoiding the N+1 problem.
2. **Fetching a list of products and their categories**: In a REST API, if you fetch a list of products and then need to fetch the categories for each product, you may encounter the N+1 problem. This would result in multiple requests to fetch categories for each product, leading to performance issues. With GraphQL, you can fetch the products and their categories in a single query, avoiding the N+1 problem.

9. Finish all the following API

REST: 

- GET/PUT/DELETE post (with exception cases)
```java
@RestController
@RequestMapping("/posts")
public class PostController {
    
        @Autowired
        private PostService postService;
    
        @GetMapping("/{id}")
        public ResponseEntity<Post> getPost(@PathVariable Long id) {
            try {
                Post post = postService.getPost(id);
                return ResponseEntity.ok(post);
            } catch (PostNotFoundException e) {
                return ResponseEntity.notFound().build();
            }
        }
    
        @PutMapping("/{id}")
        public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post post) {
            try {
                Post updatedPost = postService.updatePost(id, post);
                return ResponseEntity.ok(updatedPost);
            } catch (PostNotFoundException e) {
                return ResponseEntity.notFound().build();
            }
        }
    
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletePost(@PathVariable Long id) {
            try {
                postService.deletePost(id);
                return ResponseEntity.noContent().build();
            } catch (PostNotFoundException e) {
                return ResponseEntity.notFound().build();
            }
        }
}
```

- POST/GET/PUT/DELETE comment (you need to design the table and its relation with Post)
```mysql
CREATE TABLE Comment (
    id INT PRIMARY KEY AUTO_INCREMENT,
    post_id INT NOT NULL,
    content VARCHAR(255) NOT NULL,
    author_id INT NOT NULL,
    FOREIGN KEY (post_id) REFERENCES Post(id),
    FOREIGN KEY (author_id) REFERENCES User(id)
)
```

```java
@RestController
@RequestMapping("/api/v1/posts/{postId}/comments")
public class CommentController {
        
    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity<Comment> createComment(@PathVariable Long postId, @RequestBody Comment comment) {
        try {
            Comment createdComment = commentService.createComment(postId, comment);
            return ResponseEntity.ok(createdComment);
        } catch (PostNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getComment(@PathVariable Long postId, @PathVariable Long id) {
        try {
            Comment comment = commentService.getComment(postId, id);
            return ResponseEntity.ok(comment);
        } catch (CommentNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long postId, @PathVariable Long id, @RequestBody Comment comment) {
        try {
            Comment updatedComment = commentService.updateComment(postId, id, comment);
            return ResponseEntity.ok(updatedComment);
        } catch (CommentNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long postId, @PathVariable Long id) {
        try {
            commentService.deleteComment(postId, id);
            return ResponseEntity.noContent().build();
        } catch (CommentNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
```

- POST/GET/PUT/DELETE author (you need to design the table and its relation with Post and Comment)
```mysql
CREATE TABLE Author (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE Post (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    content VARCHAR(255) NOT NULL,
    author_id INT NOT NULL,
    FOREIGN KEY (author_id) REFERENCES Author(id)
);
```

```java
@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {
        
        @Autowired
        private AuthorService authorService;
    
        @PostMapping
        public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
            Author createdAuthor = authorService.createAuthor(author);
            return ResponseEntity.ok(createdAuthor);
        }
    
        @GetMapping("/{id}")
        public ResponseEntity<Author> getAuthor(@PathVariable Long id) {
            try {
                Author author = authorService.getAuthor(id);
                return ResponseEntity.ok(author);
            } catch (AuthorNotFoundException e) {
                return ResponseEntity.notFound().build();
            }
        }
    
        @PutMapping("/{id}")
        public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author author) {
            try {
                Author updatedAuthor = authorService.updateAuthor(id, author);
                return ResponseEntity.ok(updatedAuthor);
            } catch (AuthorNotFoundException e) {
                return ResponseEntity.notFound().build();
            }
        }
    
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
            try {
                authorService.deleteAuthor(id);
                return ResponseEntity.noContent().build();
            } catch (AuthorNotFoundException e) {
                return ResponseEntity.notFound().build();
            }
        }
}
```

GraphQL:

- Query postByID, getAllPosts
```graphql
query {
    postById(id: 1) {
        id
        title
        content
    }
    allPosts {
        id
        title
        content
    }
}
```

- Mutation createPost, updatePost
```graphql
mutation {
    createPost(title: "New Post", content: "This is a new post") {
        id
        title
        content
    }
    updatePost(id: 1, title: "Updated Post", content: "This post has been updated") {
        id
        title
        content
    }
}
```



























