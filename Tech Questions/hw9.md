# HW9
____
### 2. Type out the code for the Comment feature of the class project

### 3. In postman, call all the APIs in PostController and CommentController

### 4. What is JPA? What is Hibernate?
- JPA uses JDBC to CRUD database, and also transfer result from database to Java Entities.
- Hibernate is a JPA implementation, providing features like ORM, caching, and transaction management.

### 5. What is Hikari? What are the benefits of connection pooling?
- Hikari is a high-performance JDBC connection pool library for Java.
- Benefits of connection pooling:
  - Reduces the overhead of creating and closing database connections.
  - Improves application performance by reusing existing connections.
  - Prevents exhausting database resources by limiting the number of connections.

### 6. What is the @OneToMany, @ManyToOne, @ManyToMany? Write some examples.

@OneToMany and @ManyToOne
```java
@Entity
public class Post {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    
    @OneToMany(mappedBy = "post")
    private List<Comment> comments;
    
    // getters and setters
}

@Entity
public class Comment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String content;
    
    @ManyToOne
    private Post post;
    
    // getters and setters
}
```

@ManyToMany
```java
@Entity
public class Post {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    
    @ManyToMany
    private List<Tag> tags;
    
    // getters and setters
}

@Entity
public class Tag {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    @ManyToMany(mappedBy = "tags")
    private List<Post> posts;
    
    // getters and setters
}
```

### 7. What is the `cascade = CascadeType.ALL, orphanRemoval = true`? What are the other CascadeType and their features? In which situation we choose which one?

`cascade = CascadeType.ALL` means that when an operation is performed on an entity, the same operation will be cascaded to its related entities. 
`orphanRemoval = true` means that when an entity is removed from the relationship, it will be deleted from the database.

### 8. What is the `fetch = FetchType.LAZY, fetch = FetchType.EAGER`? What is the difference? In which situation we choose which one?

`fetch = FetchType.LAZY` means that the related entities are loaded only when they are accessed.  
`fetch = FetchType.EAGER` means that the related entities are loaded immediately when the parent entity is loaded.

Eager fetch is the default fetch type used by Hibernate, but when dealing with large datasets, it can lead to performance issues. Lazy fetch is preferred in such cases to avoid loading unnecessary data.

### 9. What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?

- JPA naming convention:
    - Entity class names should be the same as table names.
    - Field names should be the same as column names.

No need to implement CRUD operations manually, as JPA provides built-in methods for these operations.

### 10. Use JPA advanced methods.

```java
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByTitle(String title);
}
```

### 13. What is JPQL?

JPQL (Java Persistence Query Language) is a query language used to perform database operations on entities in JPA. It is similar to SQL but operates on entities rather than tables.

### 14. What are @NamedQuery and @NameQueries?

@NamedQuery is used to define a single named query in an entity class.  
@NamedQueries is used for multiple @NamedQuery annotations in an entity class.

### 15. What is @Query? In which interface we write the sql or JPQL?

@Query is an annotation in JPA used to define custom SQL or JPQL queries in a repository interface.

### 16. What is HQL and Criteria Queries?

- HQL: Hibernate Query Language, a query language similar to SQL but operates on Hibernate objects.
- Criteria Queries: A type-safe and object-oriented way to query entities using the Criteria API.

### 17. What is EntityManager?

EntityManager is a JPA interface used to interact with persistence context, allowing you to manage entity objects, execute queries, and handle database transactions.

### 18. What is SessionFactory and Session?

- SessionFactory: A factory class used to create Session objects in Hibernate.
- Session: an object that provides an interface between the application and data stored in the database

### 19. What is Transaction? How to manage your transaction?

Transaction is a sequence of operations that are treated as a single unit of work, it follows ACID properties. If transaction succeeds then commit, else then rollback.

### 20. What is hibernate Caching? Explain Hibernate caching mechanism?

Hibernate caching is a mechanism used to store frequently accessed data in memory to improve application performance. It reduces the number of database queries by storing the results of queries in memory.

### 21. What is the difference between first-level and second-level cache?

- First-level cache is mandatory and session-specific.
- Second-level cache is optional and session factory specific.

### 22. How do you understand @Transactional?

@Transactional is an annotation to manage transactions declaratively. It ensures that a method is executed within a transaction context.




































