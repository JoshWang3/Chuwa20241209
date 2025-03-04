# Spring Data Homework

## 1. List all of the annotations you learned from class and homework to annotaitons.md

- `@Entity`
- `@Table`
- `@Id`
- `@GeneratedValue`
- `@Column`
- `@OneToOne`
- `@OneToMany`
- `@ManyToOne`
- `@ManyToMany`
- `@JoinColumn`
- `@JoinTable`
- `@MappedSuperclass`
- `@Embeddable`
- `@Embedded`
- `@Transient`
- `@Query`
- `@NamedQuery`
- `@NamedQueries`
- `@Transactional`

## 2. Type out the code for the Comment feature of the class project

```
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
```

- In postman, call all of the APIs in PostController and CommentController

- Steps:
  - **Get all posts**
    - Endpoint: `GET /api/posts`
  - **Get a single post by ID**
    - Endpoint: `GET /api/posts/{id}`
  - **Create a new post**
    - Endpoint: `POST /api/posts`
    - Body:
      ```json
      {
        "title": "Sample Post",
        "content": "This is a sample post content."
      }
      ```
  - **Update a post**
    - Endpoint: `PUT /api/posts/{id}`
    - Body:
      ```json
      {
        "title": "Updated Title",
        "content": "Updated content."
      }
      ```
  - **Delete a post**
    - Endpoint: `DELETE /api/posts/{id}`
  - **Get all comments for a post**
    - Endpoint: `GET /api/posts/{id}/comments`
  - **Add a comment to a post**
    - Endpoint: `POST /api/posts/{id}/comments`
    - Body:
      ```json
      {
        "content": "This is a comment."
      }
      ```
  - **Delete a comment**
    - Endpoint: `DELETE /api/comments/{id}`

## 5. What is JPA? and what is Hibernate?

- **JPA (Java Persistence API):** A specification for managing relational data in Java applications.
- **Hibernate:** An implementation of JPA, providing additional features like caching, query capabilities, and more.

## What is Hiraki? what is the benefits of connection pool?

- **Hikari:** A high-performance JDBC connection pool.
- **Benefits:**
    - Reduces overhead of creating and closing connections.
    - Improves application performance.

## 6. What is the @OneToMany, @ManyToOne, @ManyToMany ? write some examples.

### `@OneToMany` and `@ManyToOne`
```
@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();
}

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Post post;
}
```

### `@ManyToMany`
```
@Entity
public class Author {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany
    @JoinTable(name = "author_book",
               joinColumns = @JoinColumn(name = "author_id"),
               inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> books;
}

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany(mappedBy = "books")
    private List<Author> authors;
}
```

## 7. What is the cascade = CascadeType.ALL, orphanRemoval = true ? and what are the other CascadeType and their features? In which situation we choose which one?

- **Cascade:** Propagates operations like persist, merge, remove, etc., from parent to child.
    - Types: `ALL`, `PERSIST`, `MERGE`, `REMOVE`, `REFRESH`, `DETACH`
- **Orphan Removal:** Deletes child entities when they are removed from the parent collection.

## What is the fetch = FetchType.LAZY, fetch = FetchType.EAGER ? what is the difference? In which situation you choose which one?

- **`FetchType.LAZY` (default for collections):** Data is fetched only when accessed.
- **`FetchType.EAGER` (default for entities):** Data is fetched immediately.
- **Use `LAZY` for large data sets to improve performance.**

## 9. What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?

- **Method Naming**: Methods in `JpaRepository` or `CrudRepository` should follow the pattern:
  - `findBy`, `countBy`, `deleteBy` followed by a property name.
  - Example: `findByName`, `deleteById`, `countByStatus`.

- **Property Mapping**: Method names must match entity property names.
  - Example: If the entity has a `username` field, the method should be `findByUsername`.

- **Operators**: Support for conditional keywords like `And`, `Or`, `Between`, `LessThan`, `Like`, etc.
  - Example: `findByAgeGreaterThan`, `findByFirstNameAndLastName`.

### Implementing Methods
- **Custom Queries**: If the method name cannot represent a complex query, use `@Query` annotation or a custom repository.
- **No Manual Implementation Required**: For standard queries, JPA automatically generates implementations based on the method name.

### Examples
```
// Entity: User { id, username, age }
List<User> findByUsername(String username);
List<User> findByAgeGreaterThan(int age);
List<User> findByUsernameAndAge(String username, int age);
// Custom Query
@Query("SELECT u FROM User u WHERE u.username = :username")
User findCustomUsername(@Param("username") String username);
```

## 10. Try to use JPA advanced methods in your class project. In the repository layer, you need to use the naming convention to use the method provided by JPA.

```
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByTitleContaining(String keyword);
}
```

## 13. What is JPQL?
- **Definition**: An object-oriented query language in JPA for querying entities and their relationships.
- **Key Features**:
  - Operates on entities, not tables.
  - Platform-independent and similar to SQL.
- **Examples**:
  ```
  @Query("SELECT u FROM User u WHERE u.username = :username")
  User findByUsername(@Param("username") String username);

  @Modifying
  @Query("UPDATE User u SET u.status = 'ACTIVE' WHERE u.id = :id")
  int activateUser(@Param("id") Long id);
  ```

## 14. What is @NamedQuery and @NamedQueries?

- **`@NamedQuery:`** Defines static queries.
- **`@NamedQueries:`** Groups multiple named queries.

## 15. What is @Query? In which Interface we write the sql or JPQL?
- **Definition**:  
  An annotation in Spring Data JPA to define custom SQL or JPQL queries directly in the repository.

- **Usage**:  
  Placed on methods within repository interfaces like `JpaRepository` or `CrudRepository`.

- **Examples**:
  ```
  @Query("SELECT u FROM User u WHERE u.username = :username")
  User findByUsername(@Param("username") String username);

  @Query(value = "SELECT * FROM users WHERE age > ?1", nativeQuery = true)
  List<User> findUsersOlderThan(int age);
  ```
- **Interface**: Write SQL or JPQL in Spring Data JPA repository interfaces like JpaRepository.

## 16. What is HQL and Criteria Queries?
- **HQL**:  
  An object-oriented query language in Hibernate, similar to JPQL but specific to Hibernate.
- **Features**:  
  Operates on entity objects and their properties, not database tables.
- **Example**:
  ```
  Query query = session.createQuery("FROM User WHERE username = :username");
  query.setParameter("username", "John");
  List<User> users = query.list();
  ```
- **Criteria Queries**:  
  A type-safe, programmatic way to build dynamic queries in JPA or Hibernate using the `Criteria API`.

- **Key Features**:  
  - Eliminates the need for hardcoded queries.
  - Offers flexibility for building dynamic query conditions.
  - Ensures type safety with compile-time checks.

- **Example**:
  ```
  CriteriaBuilder cb = entityManager.getCriteriaBuilder();
  CriteriaQuery<User> cq = cb.createQuery(User.class);
  Root<User> root = cq.from(User.class);
  cq.select(root).where(cb.equal(root.get("username"), "John"));
  List<User> users = entityManager.createQuery(cq).getResultList();
  ```

- **Use Case**: Ideal for scenarios where query structure is dynamic or built based on user input.

## 17. What is EnityManager?
- **Definition**:  
  A JPA interface used to interact with the persistence context, manage entity lifecycle, and execute database operations.

- **Key Responsibilities**:
  - **CRUD Operations**: Persist, remove, update, and find entities.
  - **Transaction Management**: Synchronizes entities with the database within transactions.
  - **Query Execution**: Create and execute JPQL or native SQL queries.
  - **Persistence Context Management**: Manages a set of entity instances and their state.

- **Example**:
  ```
  @PersistenceContext
  private EntityManager entityManager;

  public User findUserById(Long id) {
      return entityManager.find(User.class, id);
  }
  
  public void saveUser(User user) {
      entityManager.persist(user);
  }
  ```
- **Use Case**: EntityManager is commonly used in JPA-based applications for fine-grained control over persistence and entity management.

## 18. What is SessionFactory and Session?
- **SessionFactory**:  
  A Hibernate object responsible for creating and managing `Session` instances, providing a connection to the database.
- **Key Features**:
  - Heavyweight, designed to be instantiated once per application.
  - Thread-safe and shared across the application.
- **Example**:
  ```
  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
  ```

- **Session**:  
  A Hibernate interface representing a single-threaded unit of work with the database.

- **Key Features**:
  - Provides methods for CRUD operations (`save`, `update`, `delete`, etc.).
  - Manages the persistence context (cache of entity objects).
  - Used within a transaction for a specific operation.
  - Not thread-safe; meant for use per transaction or request.

- **Example**:
  ```
  Session session = sessionFactory.openSession();
  session.beginTransaction();

  // Perform database operations
  User user = session.get(User.class, 1L);
  session.save(new User("John", "Doe"));

  session.getTransaction().commit();
  session.close();
  ```
- **Use Case**: A Session is used to interact with the database in a controlled, transactional context.

- **Relationship**:
  - SessionFactory: Global, heavyweight object used to create Session.
  - Session: Local, lightweight object used for database operations.
## 19. What is Transaction? how to manage your transaction?

- **Definition**:  
  A sequence of database operations that are executed as a single unit of work, ensuring **ACID** properties:
  - **Atomicity**: All operations succeed or none do.
  - **Consistency**: Data remains valid before and after the transaction.
  - **Isolation**: Transactions do not interfere with each other.
  - **Durability**: Changes are permanent after transaction commit.

- **Managing Transactions In Hibernate**:  
  Use the `Transaction` interface within a `Session`.
  ```
  Session session = sessionFactory.openSession();
  Transaction tx = session.beginTransaction();
  try {
      // Perform database operations
      session.save(new User("John", "Doe"));
      tx.commit(); // Commit transaction
  } catch (Exception e) {
      tx.rollback(); // Rollback on failure
  } finally {
      session.close();
  }
  ```

- **In Spring**: Use the @Transactional annotation for declarative transaction management.
  ```
  @Service
  public class UserService {
      @Transactional
      public void saveUser(User user) {
          userRepository.save(user);
      }
  }
  ```
- **Best Practices**:
  - Use @Transactional for declarative management in Spring applications.
  - Handle transactions programmatically only for fine-grained control.
  - Always ensure proper rollback in case of errors.

## 20. What is hibernate Caching? Explain Hibernate caching mechanism in detail

**Definition**:  
Hibernate caching is a mechanism to reduce database access by storing frequently used data in memory, improving application performance.


1. **First-Level Cache**:
   - **Scope**: Session-specific.
   - **Default**: Always enabled in Hibernate.
   - **Usage**: Data is cached in the persistence context, reducing redundant queries within the same session.
   - **Example**:
     ```java
     Session session = sessionFactory.openSession();
     User user1 = session.get(User.class, 1L); // Fetches from DB
     User user2 = session.get(User.class, 1L); // Fetches from cache
     ```

2. **Second-Level Cache**:
   - **Scope**: Shared across sessions.
   - **Configuration**: Requires explicit setup.
   - **Backends**: Supports third-party caching providers like Ehcache, Infinispan, etc.
   - **Usage**:
     ```xml
     <property name="hibernate.cache.use_second_level_cache" value="true"/>
     <property name="hibernate.cache.region.factory_class" value="org.hibernate.cache.ehcache.EhCacheRegionFactory"/>
     ```

3. **Query Cache**:
   - **Scope**: Caches query results, not entities.
   - **Dependency**: Requires second-level cache.
   - **Configuration**:
     ```xml
     <property name="hibernate.cache.use_query_cache" value="true"/>
     ```

- **Benefits**:
  - Reduces database access, improving performance.
  - Optimizes query execution by caching results.
  - Enhances scalability by reducing load on the database.



- **Example of Caching Mechanism**:
  ```
  // Enable Second-Level Cache in Entity
  @Entity
  @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
  public class User {
      @Id
      private Long id;
      private String name;
  }
  ```

- **Best Practices**:
  - Use caching for read-mostly data.
  - Select appropriate caching strategies (READ_ONLY, NONSTRICT_READ_WRITE, etc.).
  - Avoid caching frequently changing data.

## 21. What is the difference between first-level cache and second-level cache?

| Aspect              | First-Level Cache                        | Second-Level Cache                          |
|---------------------|------------------------------------------|---------------------------------------------|
| **Scope**           | Per Session                             | Shared across Sessions                      |
| **Storage Location**| Session (Hibernate’s Session Object)    | SessionFactory (Shared Cache Region)        |
| **Lifetime**        | Lasts until the session is closed       | Persists across multiple sessions           |
| **Configuration**   | Enabled by default in Hibernate         | Requires explicit configuration             |
| **Purpose**         | Reduces database calls within a session | Reduces database calls across sessions      |


## 22. How do you understand @Transactional? (https://github.com/TAIsRich/tutorial-transaction
- **Purpose**: Manages database transactions declaratively, ensuring ACID properties.
- **Key Features**:
  - **Propagation**: Controls transaction behavior (e.g., `REQUIRED`, `REQUIRES_NEW`).
  - **Isolation**: Handles data visibility among concurrent transactions.
  - **Rollback**: Rolls back on unchecked exceptions by default.
- **Usage**:
  ```java
  @Transactional
  public void performOperation() {
      // transactional code
  }
- **Best Practices**: Apply at the service layer; avoid using directly on DAO methods.