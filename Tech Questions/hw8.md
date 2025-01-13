### HW8: Springboot-post

##### 1, create a file to list all of the annotaitons you learned and known, and explain the usage and how do you
##### understand it. you need to update it when you learn a new annotation. Please organize those annotations
##### well, like annotations used by entity, annotations used by controller.
##### 1. File name: annotations.md
##### 2. you'd better also list a code example under the annotations.


##### 2, explain how the below annotaitons specify the table in database?

```
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;

@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;
```

```
The first annotation defines a name field: varchar(255) type, default value of 'John Snow'.
The second annotation specifies the studentName field, the column name is STUDENT_NAME in database table, the maximum length is 50 characters,
cannot be NULL, and doesn't enforce uniqueness
```

##### 3, What is the default column names of the table in database for @Column ?

```
@Column
private String firstName;
@Column
private String operatingSystem;
```

```
The default column name in database table matches the field name in the Java class: firstName, operatingSystem.

We can also override them: 

@Column(name = "FIRST_NAME")
private String firstName;

@Column(name = "OS")
private String operatingSystem;

```

##### 4, What are the layers in springboot application? what is the role of each layer?

```
Presentation Layer(Controllers): 	
	Responsible for handling HTTP requests and responses. It defines controllers that interact with the client-side.
	
Service Layer(Services): 
	Contains business logic.
	
Data Access Layer(Repositories): 
	Manages database interaction.
	
Model Layer: 
	Defines domain objects or entities.
	
Configuration Layer: 
	Manages Spring configuration and beans.
	
Exception Handling Layer: 
	Manages errors and exceptions in the application.

```

##### 5, Describe the flow in all of the layers if an API is called by Postman.

```
1, Postman sends an HTTP request to the Spring Boot server.
2, The request passes through the Servlet Filter Chain and HTTP Firewall for initial processing and security checks
3, The DispatcherServlet receives the request and consults the HandlerMapping to determine the appropriate controller
4, The Controller layer handles the request, with @RequestMapping or @PostMapping annotations routing it to the correct method
5, The Service layer processes business logic, performs validations, and manages transactions
6, The Repository (Data Access Layer) interacts with the database to persist or retrieve data
7, The Model layer defines the entity structure
8, The response flows back through the layers:
	Repository returns data to the Service layer
	Service layer processes the data
	Controller formats the response, usually wrapping it in a ResponseEntity
9, The DispatcherServlet sends the response back to Postman
10, ostman receives the response with the operation result
```

##### 6, What is the application.properties? do you know application.yml?

```
application.properties is Simple, flat configuration using key-value pairs. It is often preferred. It’s very easy to read and write.

application.yml is Structured, hierarchical or nested configuration with better readability for complex data.
YAML is better suited for representing configurations with more depth and structure, and it can be easier to maintain as the configuration grows.

```

##### 7, What’s the naming differences between GraphQL vs. REST ? Why is the differences ?

```
Their naming differences are:
	1, Endpoints vs. Single Endpoint
		REST: Uses multiple endpoints, each representing a resource.
		GraphQL: Uses a single endpoint for all queries and mutations.

	2, HTTP Methods vs. Query/Mutation
		REST: Utilizes HTTP methods (GET, POST, PUT, DELETE) to define operations.
		GraphQL: Uses "query" for fetching data and "mutation" for modifying data.

	3, Resources vs. Types
		REST: Organizes data around resources.
		GraphQL: Defines data using a type system and schema.

	4, URL-based vs. Query-based
		REST: Identifies resources through URLs.
		GraphQL: Specifies data requirements through queries.
	
These naming differences arise from the fundamental design philosophies:
	REST is an architectural style focused on resources and stateless communication. Its naming conventions reflect its resource-centric approach and use of standard HTTP methods.
	GraphQL is a query language and specification5. Its naming emphasizes its ability to query precisely what data is needed and its use of a strongly-typed schema.

	REST's multiple endpoints allow for clear resource separation, while GraphQL's single endpoint provides flexibility in data fetching.
	GraphQL's query/mutation terminology aligns with its focus on giving clients more control over data retrieval and modification.
```

##### 8, Provide 2 real-world examples of N+1 problem in REST that can be solved by GraphQL.

```
1, E-commerce Product Listing:
	A REST API for an e-commerce site might require multiple requests:
	If there are 100 products:
	1 call to GET /products to fetch a list of 100 products
	100 calls to GET /categories/{id} for each product's category
	100 calls to GET /inventory/{id} for each product's stock information	
	This needs 301 requests, where N is 100, the number of products. 

	GraphQL specifies exactly what data they need in a single request to the server. 
	It can solve this with a single query:
	
	query {
	  products {
		id
		name
		price
		category {
		  name
		}
		inventory {
		  inStock
		  quantity
		}
	  }
	}
```

```
2, Fetching Users and Their Posts
	GET /users – Fetch a list of users.
	GET /users/{id}/posts – Fetch posts for each user.
	
	If there are 50 users, this results in 51 API calls — 1 call for users + 50 calls for posts.
	
	In GraphQL, we can request both users and their posts in a single query.
	It retrieves nested data in a structured way, so you can fetch both users and their posts in one go, thus eliminating the N+1 problem.
	
	{
	  users {
		id
		name
		posts {
		  id
		  title
		}
	  }
	}

	One request to the server will return all the necessary data for both users and their posts, significantly improving performance and reducing load.
```

##### 9, Finish all the following API

###### REST:

```
	GET/PUT/DELETE post (with exception cases)

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

```
	POST/GET/PUT/DELETE comment (you need to design the table and its relation with Post)

	CREATE TABLE Comment (
		id BIGINT PRIMARY KEY AUTO_INCREMENT,
		post_id BIGINT NOT NULL,
		content TEXT NOT NULL,
		author_id BIGINT NOT NULL,
		created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
		FOREIGN KEY (post_id) REFERENCES Post(id),
		FOREIGN KEY (author_id) REFERENCES User(id)
	);
	
	@RestController
	@RequestMapping("/api/posts/{postId}/comments")
	public class CommentController {

		@Autowired
		private CommentService commentService;

		@PostMapping
		public ResponseEntity<Comment> createComment(@PathVariable Long postId, @RequestBody CommentRequest request) {
			Comment comment = commentService.createComment(postId, request);
			return ResponseEntity.status(HttpStatus.CREATED).body(comment);
		}

		@GetMapping("/{commentId}")
		public ResponseEntity<Comment> getComment(@PathVariable Long postId, @PathVariable Long commentId) {
			Comment comment = commentService.getComment(postId, commentId);
			return ResponseEntity.ok(comment);
		}

		@GetMapping
		public ResponseEntity<List<Comment>> getCommentsByPost(@PathVariable Long postId) {
			List<Comment> comments = commentService.getCommentsByPostId(postId);
			return ResponseEntity.ok(comments);
		}

		@PutMapping("/{commentId}")
		public ResponseEntity<Comment> updateComment(@PathVariable Long postId, @PathVariable Long commentId, @RequestBody CommentRequest request) {
			Comment updatedComment = commentService.updateComment(postId, commentId, request);
			return ResponseEntity.ok(updatedComment);
		}

		@DeleteMapping("/{commentId}")
		public ResponseEntity<Void> deleteComment(@PathVariable Long postId, @PathVariable Long commentId) {
			commentService.deleteComment(postId, commentId);
			return ResponseEntity.noContent().build();
		}
	}

```

```
	POST/GET/PUT/DELETE author (you need to design the table and its relation with Post)

	CREATE TABLE Author (
		id BIGINT PRIMARY KEY AUTO_INCREMENT,
		name VARCHAR(255) NOT NULL,
		email VARCHAR(255) UNIQUE NOT NULL,
		bio TEXT,
		created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
	);

	CREATE TABLE Post (
		id BIGINT PRIMARY KEY AUTO_INCREMENT,
		title VARCHAR(255) NOT NULL,
		content TEXT NOT NULL,
		author_id BIGINT NOT NULL,
		created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
		FOREIGN KEY (author_id) REFERENCES Author(id)
	);

	@RestController
	@RequestMapping("/api/authors")
	public class AuthorController {

		@Autowired
		private AuthorService authorService;

		@PostMapping
		public ResponseEntity<Author> createAuthor(@RequestBody AuthorRequest request) {
			Author author = authorService.createAuthor(request);
			return ResponseEntity.status(HttpStatus.CREATED).body(author);
		}

		@GetMapping("/{id}")
		public ResponseEntity<Author> getAuthor(@PathVariable Long id) {
			Author author = authorService.getAuthor(id);
			return ResponseEntity.ok(author);
		}

		@PutMapping("/{id}")
		public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody AuthorRequest request) {
			Author updatedAuthor = authorService.updateAuthor(id, request);
			return ResponseEntity.ok(updatedAuthor);
		}

		@DeleteMapping("/{id}")
		public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
			authorService.deleteAuthor(id);
			return ResponseEntity.noContent().build();
		}

		@GetMapping("/{id}/posts")
		public ResponseEntity<List<Post>> getAuthorPosts(@PathVariable Long id) {
			List<Post> posts = authorService.getAuthorPosts(id);
			return ResponseEntity.ok(posts);
		}
	}
```

###### GraphQL

```
	Query postByID, getAllPost
	
	query {
	  postById(id: 1) {
		id
		title
		content
		author {
		  name
		}
	  }
	}
	
	query {
	  getAllPosts {
		id
		title
		content
		author {
		  name
		}
	  }
	}
```
	
```	
	Mutation createPost, updatePost

	mutation {
	  createPost(title: "New Post", content: "This is the content of the new post.", authorId: 1) {
		id
		title
		content
		createdAt
		updatedAt
		author {
		  name
		}
	  }
	}

	mutation {
	  updatePost(id: 1, title: "Updated Post Title", content: "This is the updated content of the post.") {
		id
		title
		content
		updatedAt
	  }
	}

```

##### 10, Create a Project, name it with mongo-blog, write a POST API for mongo-blog, change database to MongoDB;


##### 11, https://www.mongodb.com/compatibility/spring-boot