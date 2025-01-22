## 1. List all of the annotations you learned from class and homework to annotaitons.md
    see Tech\ Question/spring_annotations.md
## 2. Type out the code for the Comment feature of the class project.
    see Coding/hw9/redbook
## 3. In postman, call all of the APIs in PostController and CommentController.
    see Coding/hw9/redbook/src/main/resources/postman/Redbook.postman_collection.json
## 4. What is JPA? and what is Hibernate?
    1. JPA: JPA is a standard of Object Relational Mapping. It is an interface that defines a set of annotations for creating the object relational mapping
    2. Hibernate: Hibernate is the most popular ORM framework.
        - Key features of Hibernate include:
            JPA Provider: Implements JPA, allowing developers to use JPA's annotations and EntityManager.
            Native APIs: Offers its own APIs for advanced functionality not covered by JPA.
            Lazy/Eager Loading: Manages when data from related entities is loaded from the database.
            Caching: Includes first-level (session) and second-level (shared) caching to optimize performance.
            Automatic Schema Generation: Can generate database schemas based on entity mappings.
            HQL (Hibernate Query Language): A powerful query language similar to JPQL, with some additional features.
    The benefit of using JPA instead of Hibernate is that JPA is a standard and one can switch to any other implementation later.
## 5. What is Hiraki? what is the benefits of connection pool?
    1. Hiraki: HikariCP is a high-performance, lightweight, and reliable connection pool library for Java. It is widely used in applications requiring database connectivity due to its efficiency, simplicity, and low resource usage.
    2. Benefits of Connection Pooling
        A connection pool, like HikariCP, offers several benefits:
           1. Performance Improvement
              Creating and closing database connections is expensive and time-consuming. By reusing existing connections, the connection pool significantly reduces this overhead.
           2. Reduced Resource Usage
              It limits the number of connections to the database, ensuring efficient resource utilization and preventing connection flooding.
           3. Scalability
              A connection pool can handle a large number of requests efficiently by maintaining a balance between the number of available connections and application demand.
           4. Faster Response Time
              Applications can immediately use an available connection from the pool rather than waiting for a new connection to be established.
           5. Connection Management
              Connection pools automatically manage connections by:
              Closing idle or unused connections.
              Validating and recycling broken connections.
              Monitoring and optimizing connection usage.
           6. Thread Safety
              Connection pools like HikariCP are thread-safe and can manage concurrent requests efficiently, allowing multiple threads to use pooled connections simultaneously.
    3. Config:        
        spring.datasource.hikari.maximum-pool-size=10
        spring.datasource.hikari.minimum-idle=5
        spring.datasource.hikari.idle-timeout=30000
        spring.datasource.hikari.max-lifetime=1800000
## 6. What is the @OneToMany, @ManyToOne, @ManyToMany ? write some examples.
```java
/**
 * @OneToOne
 * Represents a one-to-one relationship, where one entity is associated with exactly one instance of another entity.
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profile profile;

    // Getters and Setters
}

@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bio;

    @OneToOne(mappedBy = "profile")
    private User user;

    // Getters and Setters
}

/**
 * @OneToMany
 * Represents a one-to-many relationship, where one entity is associated with multiple instances of another entity.
 * Example: A Department has many Employees.
 * @ManyToOne
 * Represents a many-to-one relationship, where multiple entities are associated with one instance of another entity.
 * Example: Many Employees belong to a same Department
 */
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employees = new ArrayList<>();

    // Getters and Setters
}

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    // Getters and Setters
}

/**
 * @ManyToMany
 * Represents a many-to-many relationship, where multiple entities can be associated with multiple instances of another entity.
 * Example: A Student can enroll in many Courses, and each Course can have many Students.
 */
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses = new ArrayList<>();

    // Getters and Setters
}

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();

    // Getters and Setters
}
```
## 7. What is the cascade = CascadeType.ALL, orphanRemoval = true ? and what are the other CascadeType and their features? In which situation we choose which one?
    1. CascadeType.PERSIST
          Use when child entities are created along with the parent, and you want them persisted automatically.
          Example: Saving an Order and its associated OrderItems.
    2. CascadeType.MERGE
          Use when you need to update both parent and child entities together.
          Example: Updating a Project and its related Tasks.
    3. CascadeType.REMOVE
          Use when you want child entities to be deleted when the parent entity is deleted.
          Example: Deleting a User and automatically deleting their Address.
    4. CascadeType.REFRESH
          Use when you want to reload both parent and child entities to ensure the latest state from the database.
          Example: When changes might have occurred outside the application, and consistency is critical.
    5. CascadeType.DETACH
          Use when you want to detach both parent and child entities from the persistence context.
          Example: Avoiding accidental updates to both parent and child entities in a long-running transaction.
    6. CascadeType.ALL
          Use when you want the parent to completely manage the lifecycle of the child entities.
          Example: Fully dependent relationships, such as Order ↔ OrderItems.
    7. orphanRemoval = true
          Use when you want to automatically delete child entities if they are removed from the parent collection.
          Example: Managing a ShoppingCart and automatically deleting CartItems when they are no longer in the cart.
## 8. What is the fetch = FetchType.LAZY, fetch = FetchType.EAGER ? what is the difference? In which situation you choose which one?
    FetchType:    
        There are two ways in which data is loaded: eager and lazy. Eager fetch means that when a record is fetched from the database, all the associated records from related tables are also fetched. 
        So if we fetch a tournament record, all the registrations for the tournament are also fetched.
        Eager fetch is the default fetch type used by Hibernate but it is not always the most efficient.
        Lazy fetch on the other hand, fetches the records only when they are needed
    FetchType.Lazy:
        If we don't need data from comment, JPA doesn't fetch it only if fetch data from post when we need data from comment, then JPA fecth comment data
    FetchType.Eager:
        when we fetch post, JPA also fetch comment at the same time.
## 9. What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?
    JPA defines some naming conventions for mapping entity attributes to database columns and class names to table names. These conventions make the code and database schema easier to read and maintain.
    1. Default Naming Conventions
        1.1 Entity Names (Class to Table)
        By default, the name of an entity class is mapped to a table with the same name in lowercase.
        Example:
```java
@Entity
public class Employee { }
```
        Default Table Name: employee
        1.2 Attribute Names (Field to Column)
        Entity attributes are mapped to columns with the same name in lowercase by default.
        Example:
```java
@Entity
public class Employee { 
    private String firstName;
}
```
        Default Column Name: first_name
        1.3 Camel Case to Snake Case
        JPA converts camel-case names to snake-case column names when mapping fields to columns.
        Example:
        Field firstName → Column first_name
        Field employeeId → Column employee_id
    2. Custom Naming (Using Annotations)
        If the default naming conventions do not suit your schema, you can override them using annotations.
        2.1 Custom Table Name
            Use the @Table annotation to specify a custom table name.
```java
@Entity
@Table(name = "tbl_employee")
public class Employee { }
```
        2.2 Custom Column Name
            Use the @Column annotation to customize column names for attributes.
```java
@Entity
public class Employee {
@Column(name = "emp_first_name")
private String firstName;

    @Column(name = "emp_last_name")
    private String lastName;
}
```
        2.3 Custom Join Table and Join Column Names
            Use @JoinTable and @JoinColumn for relationships.
```java
@ManyToOne
@JoinColumn(name = "dept_id")
private Department department;
```
    3. Should You Implement Methods for JPA?
        JPA provides methods like find(), persist(), merge(), remove(), etc., via the EntityManager or repositories in Spring Data JPA. 
        These methods cover most CRUD operations, so you typically don't need to implement them yourself.
        However, there are cases where you might implement methods:
            Custom Queries: For complex queries, you can use JPQL, Native SQL, or Criteria API.
            Custom Business Logic: Implement specific business logic that combines multiple database operations.
        Examples:
            Custom JPQL Query
```java
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
@Query("SELECT e FROM Employee e WHERE e.firstName = :firstName")
List<Employee> findByFirstName(@Param("firstName") String firstName);
}
```           
            Custom Native Query

```java
@Query(value = "SELECT * FROM tbl_employee WHERE emp_first_name = :firstName", nativeQuery = true)
List<Employee> findByFirstNameNative(@Param("firstName") String firstName);
```
    4. Summary of When to Customize
        Scenario Solution
        4.1 Default behavior is sufficient	Use JPA naming conventions (class name → table, field name → column).
        4.2 Schema differs from conventions	Use @Table, @Column, @JoinColumn, etc., to customize mappings.
        4.3 Custom logic or complex queries	Write JPQL, native SQL, or Criteria API queries.
        4.4 Dynamic behavior is needed	Implement repository or business service methods.
## 10. Try to use JPA advanced methods in your class project. In the repository layer, you need to use the naming convention to use the method provided by JPA.
    see Coding/hw9/redbook/src/main/java/com/chuwa/redbook/dao/UserRepository.java
## 11. (Optional) Check out a new branch(https://github.com/TAIsRich/springboot-redbook/tree/hw02_01_jdbcTemplate) from branch 02_post_RUD, replace the dao layer using JdbcTemplate.
## 12. type the code, you need to checkout new branch from branch 02_post_RUD, name the new branch with https://github.com/TAIsRich/springboot-redbook/tree/hw05_01_slides_JPQL.
    see Coding/hw9/redbook/src/main/java/com/chuwa/redbook/dao/PostJPQLRepository.java
## 13. What is JPQL?
    JPQL (Java Persistence Query Language) is a query language used in Java EE (Enterprise Edition) and Jakarta EE applications to interact with databases in the context of the Java Persistence API (JPA). It is a platform-independent, object-oriented query language designed to query and manipulate data stored in relational databases, using the JPA entity model instead of directly referencing database tables and columns.
    Key Features of JPQL:
        Object-Oriented Queries:
            Instead of dealing with tables and columns, JPQL queries work with entities, their attributes, and relationships (e.g., one-to-many or many-to-many).
            Queries are expressed in terms of the Java classes and their fields.
        Similar to SQL:
            JPQL's syntax is somewhat similar to SQL, but it operates on entity objects instead of tables.
            For example, you use the SELECT statement in JPQL, but you query entity objects, not database rows.
        Database-Agnostic:
            JPQL is database-independent, meaning the JPA provider (e.g., Hibernate, EclipseLink) translates JPQL queries into the appropriate native SQL for the underlying database.
        Dynamic and Named Queries:
            JPQL supports both dynamic queries, which are constructed at runtime, and named queries, which are predefined and stored within entity classes or XML configuration files.
## 14. What is @NamedQuery and @NamedQueries?
        @NamedQuery
            - Used to define a single named JPQL query. It allows you to give a query a name so it can be referenced later in your application.
        @NamedQueries
            - Used to group multiple @NamedQuery annotations together when an entity needs multiple predefined queries.
## 15. What is @Query? In which Interface we write the sql or JPQL?
    The @Query annotation is used in Spring Data JPA to define custom queries, either in SQL or JPQL. It allows you to write and execute database queries directly in your repository interface, providing flexibility to customize the logic beyond the default query methods provided by Spring Data JPA.
    Where to Write the Query?
        The @Query annotation is written in a Spring Data JPA repository interface, which extends JpaRepository, CrudRepository, or similar interfaces.
        These repository interfaces act as the Data Access Layer in your application.
```java
@Query("SELECT e FROM Employee e WHERE e.salary > ?1 AND e.department = ?2")
List<Employee> findBySalaryAndDepartment(Double salary, String department);
```
## 16. What is HQL and Criteria Queries?
    1. HQL (Hibernate Query Language)
        HQL is an object-oriented query language similar to SQL but works with Hibernate entities and their attributes instead of tables and columns.
        It is database-independent, as it abstracts the SQL layer.
        HQL queries are written as strings and are translated by Hibernate into native SQL.
```java
String hql = "SELECT e.name, d.name FROM Employee e JOIN e.department d WHERE d.name = :deptName";
Query query = session.createQuery(hql);
query.setParameter("deptName", "Finance");
List<Object[]> results = query.list();
```
    2. Criteria Queries
        - Criteria Queries are a programmatic, type-safe, and object-oriented way to build queries in Hibernate.
        - Instead of writing queries as strings, you use the Hibernate Criteria API (pre-JPA 2.0) or the JPA Criteria API (JPA 2.0+).
```java
Criteria criteria = session.createCriteria(Employee.class);
criteria.add(Restrictions.eq("department", "IT"));
        criteria.addOrder(Order.asc("name"));
        criteria.setFirstResult(0); // Offset
criteria.setMaxResults(10); // Limit
List<Employee> employees = criteria.list();
```
## 17. What is EnityManager?
    The EntityManager is the central interface in Java Persistence API (JPA) for managing the lifecycle of entities and interacting with the underlying database. 
    It serves as the bridge between your application and the persistence context (the set of managed entities in memory).
    Key Responsibilities of EntityManager:
        - Persisting Entities: Saves new entities to the database.
        - Finding Entities: Retrieves entities from the database using primary keys or JPQL queries.
        - Updating Entities: Synchronizes changes made to managed entities with the database.
        - Removing Entities: Deletes entities from the database.
        - Managing Transactions: Works in conjunction with transactions to ensure data consistency.
        - Query Execution: Executes JPQL or native SQL queries.
    Lifecycle of EntityManager:
        The EntityManager operates in a persistence context, which is a managed environment where entities are tracked. There are three main states for an entity:
            - New (Transient): The entity is not associated with the persistence context and is not yet stored in the database.
                - Example: A new instance of an entity class.
            - Managed (Persistent): The entity is associated with the persistence context and changes are synchronized with the database.
                - Example: Entities retrieved by find() or persisted using persist().
            - Detached: The entity is no longer associated with the persistence context.
                - Example: After the EntityManager is closed.
## 18. What is SessionFactory and Session?
    SessionFactory and Session are core components that manage the interaction between your Java application and the database
    1. SessionFactory
        The SessionFactory is a thread-safe, immutable object responsible for creating Session objects.
        It serves as the central point for Hibernate’s configuration and connection to the database.
        Typically, a single SessionFactory is created at the beginning of the application’s lifecycle and used throughout the application.
        It is designed to be used across multiple threads and is expensive to create, so you typically create it once during application startup and reuse it during the life of the application.
        Key functions of SessionFactory:
            - Creating Sessions: It provides a method to open a Session (via openSession()).
            - Configuration: It holds all the Hibernate configuration settings (e.g., database connection details, caching settings, and entity mappings).
            - Caching: It maintains the first-level cache, and it can be configured to use second-level caching for better performance.
            - Building Hibernate’s Metadata: It is responsible for interpreting Hibernate configuration files and generating entity mappings.
```java
Configuration configuration = new Configuration();
configuration.configure("hibernate.cfg.xml"); // Load configuration from XML
SessionFactory factory = configuration.buildSessionFactory();
```
    2. Session
        The Session is a single-threaded, lightweight object that represents a "conversation" between your Java application and the database.
        It is used to perform CRUD operations (Create, Read, Update, Delete) and to query the database.
        Session provides methods for loading, saving, updating, and deleting persistent objects.
        It is not thread-safe and should be used by a single thread at a time. Typically, a new Session is created for each transaction and is closed once the transaction is completed.
        Key functions of Session:
            - Saving/Updating Entities: Use methods like save(), update(), saveOrUpdate(), and merge() to persist or update entities in the database.
            - Fetching Entities: Use get() or load() to retrieve entities based on their primary key.
            - Querying: Use createQuery() or createCriteria() to create queries to fetch data from the database.
            - Transaction Management: You typically begin a transaction (beginTransaction()) and commit it (commit()) or roll it back (rollback()) using the Session.
```java
Session session = factory.openSession(); // Open a session from SessionFactory
Transaction transaction = session.beginTransaction(); // Start transaction

// Create a new entity and save it
MyEntity entity = new MyEntity();
session.save(entity);

transaction.commit(); // Commit the transaction
session.close(); // Close the session
```
## 19. What is Transaction? how to manage your transaction?
    A Transaction in the context of a database is a sequence of operations performed as a single logical unit of work. Transactions ensure data consistency, integrity, and reliability by adhering to the ACID properties:
    ACID Properties of a Transaction:
        - Atomicity: All operations in a transaction are performed completely or not at all. If one operation fails, the entire transaction is rolled back.
        - Consistency: A transaction takes the database from one valid state to another, maintaining all defined rules, constraints, and relationships.
        - Isolation: Transactions are executed independently of one another, ensuring that one transaction does not affect others.
        - Durability: Once a transaction is committed, the changes are permanent, even in the event of a system crash.
    1. Transaction Management in Hibernate
        Hibernate provides programmatic and declarative transaction management.
        Programmatic Transaction Management:
        You can manage transactions explicitly using Hibernate's Session and Transaction objects.
```java
Session session = sessionFactory.openSession();
Transaction transaction = null;
try {
    transaction = session.beginTransaction(); // Start transaction

    // Perform database operations
    MyEntity entity = new MyEntity();
    session.save(entity);

    transaction.commit(); // Commit transaction
} catch (Exception e) {
    if (transaction != null) transaction.rollback(); // Rollback on failure
    e.printStackTrace();
} finally {
    session.close(); // Close the session
}

// Declarative Transaction Management (Spring + Hibernate):
// In Spring, you can manage transactions declaratively using the @Transactional annotation.
@Service
@Transactional
public class MyService {
    @Autowired
    private MyRepository myRepository;

    public void performTransaction() {
        // Perform multiple database operations as a single transaction
        myRepository.save(new MyEntity());
        myRepository.updateAnotherEntity();
    }
}
```
    2.Spring Transaction Management
    Spring provides a powerful abstraction for transaction management, supporting both declarative and programmatic approaches.
        - Declarative Transactions: Using @Transactional to define transactional boundaries at the class or method level.
        - Programmatic Transactions: Using the TransactionTemplate or PlatformTransactionManager API for finer control.
```java
// Declarative Example:
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public void executeBusinessLogic() {
    // Transaction begins here
    myRepository.method1();
    myRepository.method2();
    // Transaction ends here (commit or rollback based on success/failure)
}

// Programmatic Example
@Autowired
private PlatformTransactionManager transactionManager;

public void executeTransaction() {
    TransactionTemplate template = new TransactionTemplate(transactionManager);

    template.execute(status -> {
        try {
            // Perform database operations
            myRepository.save(new MyEntity());
            myRepository.updateAnotherEntity();
        } catch (Exception e) {
            status.setRollbackOnly(); // Rollback on failure
            throw e;
        }
        return null;
    });
}
```
    3. JPA 
        JPA allows transaction management via the EntityManager interface and @Transactional annotations.
```java
EntityManager em = entityManagerFactory.createEntityManager();
EntityTransaction transaction = em.getTransaction();

try {
    transaction.begin(); // Start transaction

    // Perform database operations
    MyEntity entity = new MyEntity();
    em.persist(entity);

    transaction.commit(); // Commit transaction
} catch (Exception e) {
    transaction.rollback(); // Rollback on failure
    e.printStackTrace();
} finally {
    em.close();
}

@Service
@Transactional
public class MyService {
    @PersistenceContext
    private EntityManager entityManager;

    public void performTransaction() {
        MyEntity entity = new MyEntity();
        entityManager.persist(entity);
    }
}
```
## 20. What is hibernate Caching? Explain Hibernate caching mechanism in detail.
    Hibernate Caching is a mechanism in Hibernate that improves application performance by reducing database access. 
    By caching frequently accessed data, Hibernate minimizes the number of database queries required, speeding up application response times and reducing load on the database.
    Hibernate supports two levels of caching:
    1.  First-Level Cache (Session Cache)
        Scope: This is built into Hibernate and operates at the Session level.
            Lifecycle: The cache is associated with the Session object and lasts only as long as the session is open. Once the session is closed, the cache is destroyed.
        Behavior:
            Hibernate automatically enables the first-level cache.
            When you retrieve an entity using session.get() or session.load(), Hibernate first checks the session cache. If the entity is not found, it queries the database and stores the result in the session cache.
            Any subsequent requests for the same entity within the same session will retrieve the entity from the cache instead of querying the database again.
```java
Session session = sessionFactory.openSession();
Transaction transaction = session.beginTransaction();

// First query: Hits the database and caches the result in the session
MyEntity entity = session.get(MyEntity.class, 1);

// Second query for the same entity: Retrieved from the session cache
MyEntity sameEntity = session.get(MyEntity.class, 1);

transaction.commit();
session.close();
```
    2. Second-Level Cache
        Scope: This operates at the SessionFactory level, meaning it is shared across sessions. It allows caching of entities, collections, and queries for reuse across multiple sessions.
        Lifecycle: The second-level cache persists even after the session is closed, making it a more powerful and flexible caching mechanism than the first-level cache.
        Configuration: Unlike the first-level cache, the second-level cache must be explicitly configured and enabled.
        Hibernate supports various third-party caching providers for the second-level cache, such as:
            EHCache
            Infinispan
            Redis
            Hazelcast
            How It Works:
        When an entity is queried, Hibernate first checks the second-level cache.
            If the entity is found in the cache, it is returned.
            If the entity is not in the cache, Hibernate queries the database, retrieves the result, and stores it in the second-level cache for future use.
```java
// <property name="hibernate.cache.use_second_level_cache">true</property>
// <property name="hibernate.cache.region.factory_class">org.hibernate.cache.ehcache.EhCacheRegionFactory</property>
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MyEntity {
    @Id
    private int id;
    private String name;
    // Getters and setters
}
```
## 21. What is the difference between first-level cache and second-level cache?
    Feature	                First-Level Cache	Second-Level Cache
    Scope	                Session	            SessionFactory
    Default                 Availability	    Always enabled	Requires explicit configuration
    Shared Across Sessions	No	                Yes
    Configuration Needed	No	                Yes
    Lifecycle	            Per session	        Application-wide
## 22. How do you understand @Transactional? (https://github.com/TAIsRich/tutorial-transaction)
    Spring provides a powerful abstraction for transaction management, supporting both declarative and programmatic approaches.
    Declarative Transactions: Using @Transactional to define transactional boundaries at the class or method level.