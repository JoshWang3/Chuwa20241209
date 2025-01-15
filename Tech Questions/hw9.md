# HW9
## Questions:

### 1. Please check annotations.md

### 2. Check HW9/redbook/ files

### 3. Call all APIs in PostController and CommentController using Postman
- Post
1. Get all content: `GET /api/posts`; `GET /api/posts/comments`
2. Get by ID: `GET /api/posts/ {id}`; `GET /api/posts/{id}/comments`
3. Create/POST/comment: `POST /api/posts`; `POST /api/posts/{id}/comments`
   Body:
    ```
    {
    "content": "Introducing our new product!",
    "create_date_time": "2025-01-01 11:59:59",
    "description": "Brief details of the product launch.",
    "title": "New Product Launch",
    "update_date_time": "2025-01-01 01:01:01"
    }
    ```
   
    Body:
    ```
   {
        "content": "New releases!."
      }
   
    ```
4. Update/PUT: `PUT /api/posts/{id}`
    Body:
   ```
       {
    "content": "Introducing our new product part II!",
    "create_date_time": "2025-01-02 11:59:59",
    "description": "Product launch part II promotion.",
    "title": "New Product Launch 2",
    "update_date_time": "2025-01-02 01:01:01"
    }
   ```

### 4. What is JPA? What is Hibernate?
- JPA: Java Persistence API is interfaces for ORM (Object-Relational Mapping), providing mapping between Java class and databases tables.

- Hibernate: is an ORM library for Java on mapping application domain objects to the relational databese.

### 5. What is HikariCP? What are the benefits of a connection pool?
- HikariCP: is a connection pool library in Spring Boot
Benefits of a connection pool are 1. great performance by reusing database connections 2. Limit active connections to prevent databases overload 3. Manage connections in multi-threaded environments


### 6. What are `@OneToMany`, `@ManyToOne`, and `@ManyToMany`? Write some examples.
There're annotations for entities object models and database attributes.

`@OneToMany`
```
@Entity
@Table(name = "university")
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "university", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Student> students;
}
```

`@ManyToOne`
```

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;

}
```

`@ManyToMany`
```

@Entity
@Table(name="course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double fee;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;v
@Entity
@Table(name="course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double fee;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;

  
@Entity
@Table(name="course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double fee;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;

  
@Entity
@Table(name="course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double fee;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;

  
@Entity
@Table(name="course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double fee;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;

}
```

### 7. What is `cascade = CascadeType.ALL`, `orphanRemoval = true`? What are the other CascadeTypes and their features?
Propagate operation like persist, merge, remove from parent to children
orphanRemoval will delete children entities when it removed from parent entities
CascadeTypes: `PERSIST`, `MERGE`, `REMOVE`, `REFRESH`, `DETACH`

### 8. What is the `fetch = FetchType.LAZY` and `fetch = FetchType.EAGER`?
LAZY: Data is loaded when accessed, delaying database queries (especially for large collections or data not frequently used)
EAGER: Data loaded immediately along with parent entity

### 9. What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?
Usually it start with `findBy`, `queryBy`, `countBy`, `deleteBy` then combine field names with operation (And, Or, Between, GreaterThan) ex: `findByName(String name)`, `findByAgeGreaterThan(int age)`, `findByEmailOrPhoneNumber(String email, String phoneNumber)`
Don't need to implement the methods by ourselves because JPA will provide the implementation based on method names, or use `@Query` annotations for complex queries.

### 10. Try to use JPA advanced methods in your class project. In the repository layer, you need to use the naming convention to use the method provided by JPA.
Check CommentRepository.java
### 11. (Optional) Check out a new branch(https://github.com/TAIsRich/springboot-redbook/tree/hw02_01_jdbcTemplate) from branch 02_post_RUD, replace the dao layer using JdbcTemplate.

### 12. type the code, you need to checkout new branch from branch 02_post_RUD, name the new branch with https://github.com/TAIsRich/springboot-redbook/tree/hw05_01_slides_JPQL.
Check HW9/redbook in dao/
### 13. What is JPQL?
Java Persistence Query Language is a language similar to SQL but use class names and fields; and operates on entity objects instead of database tables.

### 14. What is `@NamedQuery` and `@NamedQueries`?
- `@NamedQuery`: Defines a static, pre-defined JPQL query with a name.
- `@NamedQueries`: Allows multiple @NamedQuery annotations to be defined.


### 15. What is `@Query`? In which interface do we write SQL or JPQL?
`@Query` Defines a JPQL or SQL query directly in a repository method. It can be used in Spring Data JPA repository interfaces.

### 16. What is HQL and Criteria Queries?
- Hibernate Query Language is a language in object oriented syntax, operating on Hibernate entities

- Criteria Queries applies different filters and logical conditions to manipulate objects from db tables.

### 17. What is `EntityManager`?
EntityManager is a JPA interface for managing entities and performing database operations. Like `persist()`, `merge()`, `remove()`, `find()`

### 18. What is `SessionFactory` and `Session`?
- `SessionFactory`: Hibernate interface used to create Session instances.
- `Session`: The unit of work to perform CRUD operations

### 19. What is a Transaction? How do you manage your transaction?
Transaction is a series of actions or operations in a unit of working. All operations must be out of the state of application if part of transaction failed. It helps to secure ACID (Atomicity, Consistency, Isolation, Durability) 

### 20. What is Hibernate Caching? Explain Hibernate caching mechanisms in detail.
Hibernate caching improves the performance of the application by pooling the object in the cache.

1. First Level Cache
Associate with Session object and holds the cache data. It's enabled by default and the cache data will not be available to entire application. An application can use many session object.

2. Second Level Cache
SessionFactory object holds the second level cache data. The data will be available to entire application. But it needs to enable it explicitely. Popular implementations: Redis

### 21. What is the difference between first-level cache and second-level cache?
First-Level Cache: exist in per `Session` object; enabled by default; don't need configuration
Second-Level Cache: shared across `Session` object; not enabled by default; need setup or configuration

### 22. How do you understand `@Transactional`?
`@Transactional` annotation is used to for manage transactions in Spring Boot (can be applied to the class level or method level).
It will roll back if exceptions happened;  it indicates that the particular method should be executed within the context of that transaction. It defines transaction isolation levels.