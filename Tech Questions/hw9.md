# Homework 9
## Spring Data 

### 1. List all of the annotations you learned from class and homework to annotaitons.md
- see annotations.md

### 2. Type out the code for the Comment feature of the class project.
- see projects/hw8/redbook

### 3. In postman, call all of the APls in PostController and CommentController.
POST {{baseURL}}/api/v2/posts
GET {{baseURL}}/api/v2/posts
GET {{baseURL}}/api/v2/posts/{id}
PUT {{baseURL}}/api/v2/posts/{id}
DELETE {{baseURL}}/api/v2/posts/{id}

POST {{baseURL}}/api/v2/posts/{postId}/comments
GET {{baseURL}}/api/v2/posts/{postId}/comments
GET {{baseURL}}/api/v2/posts/{postId}/comments/{id}
PUT {{baseURL}}/api/v2/posts/{postId}/comments/{id}
DELETE {{baseURL}}/api/v2/posts/{postId}/comments/{id}

### 4. What is JPA? and what is Hibernate?

- JPA, Java Persistence API, is a standard of Object Relational Mapping. It is an interface that defines a set of annotations for creating the object relational mapping. This allows us to interact with a relational database using Java objects, reducing the need to write raw SQL queries.

- Hibernate is an ORM framework that implements the JPA specification. It is one of the most popular and widely used JPA providers, offering additional features beyond the JPA standard.

### 5. What is Hiraki? what is the benefits of connection pool?

- Hikari, Japanese word for light, is a high-performance JDBC connection pool library for Java. It is designed to be lightweight, fast, and efficient, making it a popular choice for managing database connections in Java applications. It uses efficient algorithms to manage connections, minimize contention, and ensure threads acquire connections quickly.

- A connection pool is a cache of database connections that are maintained and reused rather than being created and destroyed for each database request. When an application needs to access a database, it can borrow a connection from the pool, use it, and then return it to the pool for reuse. Common benefits are faster acquisition and release of connections, optimized query execution time due to reduced connection overhead, and minimal configuration to achieve high performance.

### 6. What is the @OneToMany, @ManyToone, @ManyToMany? write some examples.

- `@OneToMany` defines a one-to-many relationship between two entities. This means one record in the "parent" entity is related to multiple records in the "child" entity.

- `@ManyToOne` defines a many-to-one relationship. This means multiple records in the "child" entity relate to one record in the "parent" entity.

- `@ManyToMany` defines a many-to-many relationship. This means multiple records in one entity can relate to multiple records in another entity.

```java
@Entity
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "students", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Student> students = new ArrayList<>();
}

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "classroom_id") 
    private Classroom classroom;

    @ManyToMany
    @JoinTable(
        name = "student_course",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses = new HashSet<>();

}

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();

}
```

### 7. What is the cascade = CascadeType.ALL, orphanRemoval = true? and what are the other CascadeType and their features? In which situation we choose which one?

- The cascade attribute defines operations that should automatically propagate from a parent entity to its related child entities. CascadeType.ALL means all lifecycle operations such as PERSIST, MERGE, REMOVE, etc. performed on the parent will also be applied to the associated child entities.

- The orphanRemoval attribute ensures that if a child entity is removed from the parent entity's collection, it will be automatically deleted from the database.

- We can choose the cascade types based on the relationship and dependency between your entities. For strong dependency, use ALL with orphanRemoval = true, meanwhile for independent entities, use specific cascade types like PERSIST or MERGE.
1. PERSIST propagates the persist() operation from parent to child entities.
2. MERGE propagates the merge() operation from parent to child entities.
3. REMOVE propagates the remove() operation from parent to child entities, deleting associated entities.
4. REFRESH propagates the refresh() operation to synchronize child entities with the database state.
5. DETACH propagates the detach() operation, detaching both parent and child entities from the persistence context.
6. ALL combines all of the above cascade types.

### 8. What is the fetch = FetchType.LAZY, fetch = FetchType. EAGER? what is the difference? In which situation you choose which one?

- Eager fetch means that when a record is fetched from the database, all the associated records from related tables are also fetched (Default for @OneToOne and @ManyToOne). The best use case is when related data is rarely accessed. For example, User entity with a list of LoginHistory. 

- In lazy fetch, related entities are not loaded immediately when the parent entity is loaded (Default for @OneToMany and @ManyToMany). Instead, they are loaded on demand. The best use case is when related data is always required or the relationships are small in size. For instnace,a Student and his Courses.

### 9. What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?

- Spring’s default naming convention is regarding table and column names. It uses lower snake case by default, which means it uses only lowercase letters and separates words with underscores.It implemented its version of Hibernate’s PhysicalNamingStrategy: SpringImplicitNamingStrategy.

- As for query methods, Spring Data JPA automatically generates the corresponding SQL queries based on the method name, which means we generally don't need to manually implement these methods ourselves, as the framework handles the translation based on the naming convention. For examples: `List<User> findByEmail(String email)`, `List<Product> findByCategoryAndPriceGreaterThan(String category, double price)`, and etc. 

### 10. Try to use JPA advanced methods in your class project. In the repository layer, you need to use the naming convention to use the method provided by JPA.
- see Projects

### 11. (Optional) Check out a new branch(https://github.com/TAlsRich/springboot-redbook/tree/hw02_01_jdbcTemplate) from branch 02_post_RUD, replace the dao layer using JabcTemplate.

### 12. type the code, you need to checkout new branch from branch 02_post_RUD, name the new branch with h ttps://github.com/TAlsRich/springboot-redbook/tree/hw05_01_slides_JPQL.

### 13. What isJPQL?

- JPQL, Java Persistence Query Language, is a query language defined in JPA used to interact with relational databases. It operates on entities, their fields, and relationships, rather than directly on database tables and columns. JPQL is object-oriented and uses an SQL-like syntax.
Example:
```java
@Query("SELECT e FROM Employee e WHERE e.department.name = :deptName")
List<Employee> findEmployeesByDepartment(@Param("deptName") String departmentName);
```

### 14. What is @NamedQuery and @NamedQueries?

- `@NamedQuery` is used to define a single JPQL query, and it is defined at the class level of an entity.
The query can be executed by referencing its name.
```java
@Entity
@NamedQuery(
    name = "Employee.findByName",
    query = "SELECT e FROM Employee e WHERE e.name = :name"
)
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Double salary;

}

// usage in servcie layer
List<Employee> employees = entityManager.createNamedQuery("Employee.findByName", Employee.class)
                                        .setParameter("name", "John")
                                        .getResultList();
```

- `@NamedQueries` is used to define multiple named queries for an entity. It's a container for grouping multiple @NamedQuery annotations.
```java
@Entity
@NamedQueries({
    @NamedQuery(
        name = "Employee.findByName",
        query = "SELECT e FROM Employee e WHERE e.name = :name"
    ),
    @NamedQuery(
        name = "Employee.findBySalaryGreaterThan",
        query = "SELECT e FROM Employee e WHERE e.salary > :salary"
    )
})
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Double salary;
}
```

### 15. What is @Query? In which Interface we write the sql or JPQL?

- `@Query` is used to define custom JPQL or SQL queries directly within repository interfaces. It allows us to write complex queries without the need to define named queries or write native database queries in separate files. 
- The queries are written in a Repository Interface, typically extending one of the repository types such as `JpaRepository` or `CrudRepository`.
```java
@Query("SELECT e FROM Employee e WHERE e.name = :name")
List<Employee> findByName(@Param("name") String name);
```

### 16. What is HQL and Criteria Queries?

- HQL is an object-oriented query language similar to SQL but operates on Hibernate's entity objects and their relationships rather than directly on database tables and columns.
```java
String hql = "FROM Employee";
List<Employee> employees = session.createQuery(hql, Employee.class).list();
```

- Criteria API in Hibernate is a programmatic way to build queries dynamically at runtime using Java code, without writing HQL strings.
```java
CriteriaBuilder cb = session.getCriteriaBuilder();
CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
Root<Employee> root = cq.from(Employee.class);
cq.select(root);
List<Employee> employees = session.createQuery(cq).list();
```

### 17. What is EnityManager?

- `EntityManager` is a core interface in JPA that provides the primary means of interacting with the persistence context. It acts as a bridge between the Java application and the database, and provides methods that perform SELECT, INSERT, UPDATE, and DELETE queries.

### 18. What is SessionFactory and Session?

- A Session is a lightweight, single-threaded, non-thread-safe object used to interact with the database. It represents a connection to the database and provides methods for CRUD operations, queries, and transaction management.

- SessionFactory is a factory for Session objects. It is a heavyweight object that is thread-safe and designed to be shared across the application. It is responsible for initializing Hibernate and providing database connection settings.

### 19. What is Transaction? how to manage your transaction?

- A transaction in Hibernate is a mechanism for grouping a set of database CRUD operations together to ensure data consistency and integrity by following ACID principle. A transaction allows for multiple database operations to be treated as a single unit of work, ensuring that:
1. either all operations are successfully completed (commit), or
2. if an error occurs, none of the operations are applied to the database (rollback).
- Transactions are critical for ensuring that the database remains in a consistent state, especially in cases of failure, errors, or system crashes.

### 20. What is hibernate Caching? Explain Hibernate caching mechanism in detail.

- Hibernate caching is a mechanism used to improve performance by reducing the number of database queries required for frequently accessed data. It leverages the idea of storing the results of database queries or entities in memory, so that the next time the same data is requested, it can be retrieved directly from the cache rather than querying the database.

- There are two types of caching in Hibernate.
1. First-Level Cache (Session Cache): The first-level cache is associated with the Hibernate Session object. It is the default cache that Hibernate uses to store entities and collections during the lifecycle of a Session. This cache is enabled by default and is a mandatory cache. It is used to avoid repeated database queries during the same session, thereby reducing the need for unnecessary database calls.

2. Second-Level Cache (SessionFactory Cache): The second-level cache is an optional cache that is shared across multiple Session objects. It is not tied to a specific session but instead to the SessionFactory. The second-level cache caches data that can be reused across multiple sessions, helping avoid querying the database for the same entities in different sessions. Hibernate itself does NOT implement second-level cache, instead, it relies on third party caching providers such as Redis, Ehcache etc.

### 21. What is the difference between first-level cache and second-level cache?

First-level cache
- This is local to the Session object and cannot be shared between multiple sessions. The purpose is to minimize database visit. 
- This cahce is enabled by default and there is no way to disable it.
- The first level cache is available only until the session is open, once the session is closed, the first level cache is destroyed.

Second-level cache
- This cache is maintained at the SessionFactory level and shared among all sessions in Hibernate. It is for cross-session use.
- This is disabled by default, but we can enable it through configuration.
- The second-level cache is available through the application's life cycle, it is only destroyed and recreated when an application is restarted.

### 22. How do you understand @Transactional? (https://github.com/TAlsRich/tutorial-transaction)

- `@Transactional` annotation is a powerful tool in Java and Spring applications for managing database transactions declaratively. By using `@Transactional`, we can ensure that our application’s data remains consistent and database operations are executed atomically. It is particularly useful for methods that need to perform multiple operations or handle failures gracefully through rollback. Proper configuration and understanding of its attributes such as propagation, isolation, and rollback, can help ensure that our transactions behave as expected and improve the overall performance and reliability of the application.