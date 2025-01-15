### 1. List all of the annotations you learned from class and homework to annotaitons.md

### 2. Type out the code for the Comment feature of the class project.

### 3. In postman, call all of the APIs in PostController and CommentController.

### 4. What is JPA? and what is Hibernate?
```
`JPA is only a specification, it is not an implementation.
  It is a set of rules and guidelines to set interfaces for implementing object-relational mapping, .
  It needs a few classes and interfaces.
  It supports simple, cleaner, and assimilated object-relational mapping.
  It supports polymorphism and inheritance.
  Dynamic and named queries can be included in JPA.
```

```
Hibernate is an implementation of JPA guidelines. 
It helps in mapping Java data types to SQL data types. 
It is the contributor of JPA.
```

### 5. What is Hiraki? what is the benefits of connection pool?
```
Hikari is a high-performance, lightweight, and widely adopted connection pooling library for Java applications. 
```
```
Improved Performance: By reusing connections instead of creating new ones every time, overhead is minimized and response times are faster.
Resource Optimization: A shared pool means fewer total connections are needed, preventing the database from hitting its maximum connection limit too quickly.
Connection Management: Pooling solutions offer features like connection validation and timeout handling, ensuring reliable, stable connections and controlled lifecycles.
```
### 6. What is the @OneToMany, @ManyToOne, @ManyToMany ? write some examples.
- @OneToMany indicates that one entity can be associated with many instances of another entity.
- A Customer can have multiple Orders.
```
@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    // One customer -> Many orders
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orders;

    // Getters, setters (omitted for brevity)
}

@Entity
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    private String productName;

    // Many orders -> One customer
    @ManyToOne
    private Customer customer;

    // Getters, setters (omitted for brevity)
}
```
- @ManyToOne relationship means that many instances of an entity relate to one instance of another entity.
- Scenario: multiple Orders can have a customer.
```
@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    // One customer -> Many orders
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orders;

    // Getters, setters (omitted for brevity)
}

@Entity
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    private String productName;

    // Many orders -> One customer
    @ManyToOne
    private Customer customer;

    // Getters, setters (omitted for brevity)
}
```
- @ManyToMany indicates that each entity can relate to multiple instances of the other entity.
- A Student can enroll in multiple Courses, and each Course can have multiple Students.
``` 
@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    // Many students -> Many courses
    @ManyToMany
    private List<Course> courses;

    // Getters, setters (omitted for brevity)
}

@Entity
public class Course {
    @Id
    @GeneratedValue
    private Long id;
    private String title;

    // Many courses -> Many students
    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    // Getters, setters (omitted for brevity)
}
``` 
### 7. What is the cascade = CascadeType.ALL, orphanRemoval = true ? and what are the other CascadeType and their features? In which situation we choose which one?
- Propagate operation like persist, merge, remove from parent to children orphanRemoval will delete children entities when it removed from parent entities CascadeTypes: PERSIST, MERGE, REMOVE, REFRESH, DETACH
### 8. What is the fetch = FetchType.LAZY, fetch = FetchType.EAGER ? what is the difference? In which situation you choose which one?
- LAZY: Data is loaded when accessed, delaying database queries (especially for large collections or data not frequently used) 
- EAGER: Data loaded immediately along with parent entity
### 9. What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?
- **Prefixes:**
- Use prefixes like "findBy", "getBy", "readBy" or "queryBy" to indicate a query method.
- **Property names:**
- After the prefix, directly use the property names of your entity to specify the search criteria.
- **Logical operators:**
- You can combine property names with keywords like "LessThan", "GreaterThan", "Between", "Like", "IsNull", etc. to create more complex queries.
- We generally don't need to implement these methods ourselves

```List<User> findByUsername(String username);```
```List<Product> findByCategoryAndPriceGreaterThan(String category, double price);```
```List<Order> findByStatusAndCreatedDateBetween(OrderStatus status, LocalDate startDate, LocalDate endDate);```
### 10. Try to use JPA advanced methods in your class project. In the repository layer, you need to use the naming convention to use the method provided by JPA.

### 11. (Optional) Check out a new branch(https://github.com/TAIsRich/springboot-redbook/tree/hw02_01_jdbcTemplate) from branch 02_post_RUD, replace the dao layer using JdbcTemplate.

### 12. type the code, you need to checkout new branch from branch 02_post_RUD, name the new branch with https://github.com/TAIsRich/springboot-redbook/tree/hw05_01_slides_JPQL.

### 13. What is JPQL?
- JPQL is Java Persistence Query Language defined in JPA specification. It is used to create queries against entities to store in a relational database. JPQL is developed based on SQL syntax. But it won’t affect the database directly.

- JPQL can retrieve information or data using SELECT clause, can do bulk updates using UPDATE clause and DELETE clause. EntityManager.createQuery() API will support for querying language.
### 14. What is @NamedQuery and @NamedQueries?
- The following @NamedQuery annotation defines a query whose name is "Country.findAll" that retrieves all the Country objects in the database:
```
@NamedQuery(name="Country.findAll", query="SELECT c FROM Country c")
```
- The @NamedQuery annotation contains four elements - two of which are required and two are optional. The two required elements, name and query define the name of the query and the query string itself and are demonstrated above. The two optional elements, lockMode and hints, provide static replacement for the setLockMode and setHint methods.
```
@Entity
@NamedQueries({
    @NamedQuery(name="Country.findAll",
                query="SELECT c FROM Country c"),
    @NamedQuery(name="Country.findByName",
                query="SELECT c FROM Country c WHERE c.name = :name"),
}) 
public class Country {
  ...
}
```
### 15. What is @Query? In which Interface we write the sql or JPQL?
- @Query is an annotation used to define custom JPQL (Java Persistence Query Language) or native SQL queries directly within a repository interface
### 16. What is HQL and Criteria Queries?
- HQL is to perform both select and non-select operations on the data, but Criteria is only for selecting the data. HQL is suitable for executing Static Queries, where as Criteria is suitable for executing Dynamic Queries.
### 17. What is EnityManager?
- An EntityManager is an API that manages the lifecycle of entity instances in a relational database. It's used to create, remove, find, and query entities.
### 18. What is SessionFactory and Session?
- The SessionFactory is a thread safe object and used by all the threads of an application. 
- A Session is used to get a physical connection with a database.
### 19. What is Transaction? how to manage your transaction?
Transaction is a series of actions or operations in a unit of working. All operations must be out of the state of application if part of transaction failed. It helps to secure ACID (Atomicity, Consistency, Isolation, Durability)
### 20. What is hibernate Caching? Explain Hibernate caching mechanism in detail.
- Hibernate caching improves the performance of the application by pooling the object in the cache.

- First Level Cache Associate with Session object and holds the cache data. It's enabled by default and the cache data will not be available to entire application. An application can use many session object.

- Second Level Cache SessionFactory object holds the second level cache data. The data will be available to entire application. But it needs to enable it explicitely. Popular implementations: Redis
### 21. What is the difference between first-level cache and second-level cache?
- **First-level cache**
- Hibernate first-level is associated with a Hibernate session , entity instances stored in a session can
be considered as "cached" inside session object, it is enabled by default, there's no way to disable it.
Session provides methods through which we can persist, merge, remove, and find entity instances
inside the "cache" (session). Objects cached in session will NOT be visible to other sessions, so
Hibernate first-level cache only works within a session.
- **Second-level cache**
- Second-level cache is NOT enabled unless configured explicitly.
- Second-level cache works across sessions, in sessionFactory level.
- Hibernate itself does NOT implement second-level cache, instead, it relies on third party caching
providers such as Redis, Ehcache, etc.

### 22. How do you understand @Transactional? (https://github.com/TAIsRich/tutorial-transaction)
- @Transactional annotation is used to for manage transactions in Spring Boot (can be applied to the class level or method level). It will roll back if exceptions happened; it indicates that the particular method should be executed within the context of that transaction. It defines transaction isolation levels.