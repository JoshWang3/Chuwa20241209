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

4. 
JPA: Java Persistence API, a specification for object-relational mapping (ORM).
Hibernate: A popular JPA implementation offering additional features like caching and database independence.
5. Hikari: A high-performance JDBC connection pool library. It can optimize resource usage.
6. Relationship:
   @OneToMany: One entity related to multiple entities.
   @ManyToOne: Many entities related to one entity.
   @ManyToMany: Many-to-many relationship. 
7.  
    CascadeType.ALL: Propagates all operations to child entities.
    orphanRemoval = true: Deletes child entities removed from a collection.
8. Fetch types:
   Lazy: Loads related data on demand.
   Eager: Loads related data immediately.
9. Naming conventions:
   Method names should reflect query intentions

13. Java Persistence Query Language for interacting with entities.
14. 
    @NamedQuery: A pre-defined JPQL query with a name that can be reused throughout the application.:
    @NamedQuery(
    name = "Comment.findByPost",
    query = "SELECT c FROM Comment c WHERE c.post.id = :postId"
    )
    @NamedQueries: A container for multiple @NamedQuery annotations.
    @NamedQueries({
    @NamedQuery(name = "Comment.findByPost", query = "SELECT c FROM Comment c WHERE c.post.id = :postId"),
    @NamedQuery(name = "Comment.findByUser", query = "SELECT c FROM Comment c WHERE c.user.id = :userId")
    })
15. 
    @Query: Used to define custom queries (SQL or JPQL) in repository interfaces.
    @Query("SELECT c FROM Comment c WHERE c.post.id = :postId")
    List<Comment> findCommentsByPostId(@Param("postId") Long postId);
16. 
    HQL (Hibernate Query Language): A query language similar to SQL but operates on entity objects instead of database tables.
    Criteria Queries: A programmatic way to build queries in a type-safe manner
17. EntityManager: A JPA interface for managing entity lifecycle (e.g., persisting, removing, and querying entities).
18. 
    SessionFactory: A heavyweight Hibernate object responsible for creating Session instances. It's thread-safe and should be instantiated once per application.
    Session: A lightweight Hibernate object for interacting with the database (CRUD operations, transactions, etc.). It's not thread-safe and is short-lived.
19. 
    Transaction: A unit of work performed against a database that must be completed fully or rolled back if there is an error.
    Transaction Management: In Spring, transactions are managed using the @Transactional annotation.
20. 
    Hibernate Caching: Reduces database calls by storing frequently accessed data in memory.
    Mechanism:
      First-Level Cache: Default, session-level cache.
      Second-Level Cache: Optional, shared across sessions using third-party libraries like Ehcache, Redis, etc.
      Query Cache: Caches the results of queries.
21. Feature	        First-Level Cache	            Second-Level Cache
    Scope	        Per Session	                    Shared across SessionFactory
    Default	        Enabled by default	            Requires configuration
    Implementation	Built into Hibernate	        Requires third-party libraries
    Purpose	        Caches entities within session	Shares cache across sessions
22. @Transactional: Marks a method or class for transaction management. It ensures:
    All database operations within the scope are atomic (all succeed or all fail).
    Supports declarative transaction handling.
    Configurable properties (e.g., isolation level, propagation).
