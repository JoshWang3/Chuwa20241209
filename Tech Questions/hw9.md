# Spring Data Homework

## 1. List all of the annotations you learned from class and homework

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

## 2. Code for the Comment feature of the class project

```java
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

## 3. Call all APIs in PostController and CommentController using Postman

### Steps:
1. **Get all posts**
    - Endpoint: `GET /api/posts`
2. **Get a single post by ID**
    - Endpoint: `GET /api/posts/{id}`
3. **Create a new post**
    - Endpoint: `POST /api/posts`
    - Body:
      ```json
      {
        "title": "Sample Post",
        "content": "This is a sample post content."
      }
      ```
4. **Update a post**
    - Endpoint: `PUT /api/posts/{id}`
    - Body:
      ```json
      {
        "title": "Updated Title",
        "content": "Updated content."
      }
      ```
5. **Delete a post**
    - Endpoint: `DELETE /api/posts/{id}`
6. **Get all comments for a post**
    - Endpoint: `GET /api/posts/{id}/comments`
7. **Add a comment to a post**
    - Endpoint: `POST /api/posts/{id}/comments`
    - Body:
      ```json
      {
        "content": "This is a comment."
      }
      ```
8. **Delete a comment**
    - Endpoint: `DELETE /api/comments/{id}`

## 4. What is JPA and Hibernate?

- **JPA (Java Persistence API):** A specification for managing relational data in Java applications.
- **Hibernate:** An implementation of JPA, providing additional features like caching, query capabilities, and more.

## 5. What is Hikari? What are the benefits of connection pooling?

- **Hikari:** A high-performance JDBC connection pool.
- **Benefits:**
    - Reduces overhead of creating and closing connections.
    - Improves application performance.

## 6. Relationship Annotations Examples

### `@OneToMany` and `@ManyToOne`
```java
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
```java
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

## 7. Cascade and Orphan Removal

- **Cascade:** Propagates operations like persist, merge, remove, etc., from parent to child.
    - Types: `ALL`, `PERSIST`, `MERGE`, `REMOVE`, `REFRESH`, `DETACH`
- **Orphan Removal:** Deletes child entities when they are removed from the parent collection.

## 8. Fetch Types

- **`FetchType.LAZY` (default for collections):** Data is fetched only when accessed.
- **`FetchType.EAGER` (default for entities):** Data is fetched immediately.
- **Use `LAZY` for large data sets to improve performance.**

## 9. JPA Naming Conventions

- Method names in repositories should match query intents:
    - `findByName(String name)`
    - `findByAgeGreaterThan(int age)`

## 10. Use JPA Advanced Methods

```java
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByTitleContaining(String keyword);
}
```

## 13. What is JPQL?

Java Persistence Query Language: A query language for JPA entities.

## 14. `@NamedQuery` and `@NamedQueries`

- **`@NamedQuery:`** Defines static queries.
- **`@NamedQueries:`** Groups multiple named queries.

## 15. What is `@Query`?

Custom JPQL or SQL queries in repository interfaces.

## 16. HQL and Criteria Queries

- **HQL:** Hibernate Query Language, object-oriented.
- **Criteria Queries:** Programmatic query construction.

## 17. EntityManager

JPA interface for interacting with the persistence context.

## 18. SessionFactory and Session

Hibernate interfaces for managing sessions and transactions.

## 19. Transactions

Manage database operations as a single unit. Use `@Transactional` for management.

## 20. Hibernate Caching

- Mechanism to reduce database access.
- Levels:
    - First-level: Session-specific.
    - Second-level: Application-wide.

## 22. Understanding `@Transactional`

Manages transactions declaratively, ensuring data integrity.
