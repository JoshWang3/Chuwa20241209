1-3. In code

4.  What is JPA? and what is Hibernate?

    > JPA is a Spring data interface for the application to interact with SQL database, mapping java objects to tables in the database. Hibernate is an implementation of the interface. It provides additional features, such as caching and custom query support.

5.  What is Hiraki? what is the benefits of connection pool?

    > It's a jdbc connection pool that reduces the overhead of creating and closing of database connections. Improve performance by reusing connections(borrow and return a connection from the pool). Manage connection limits efficiently to prevent resource exhaustion.
    > Common Default Values:
    > PostgreSQL: Typically 100 connections.  
    > MySQL: Usually around 151 connections (but this can vary based on the specific MySQL version and configuration).  
    > SQL Server: The default depends on the edition and hardware but can be quite high (e.g., thousands).

6.  What is the @OneToMany, @ManyToOne, @ManyToMany ? write some examples.
    relationship between two entities.
    @OneToMany, manager to employees
    @ManyToOne, employees to manager
    @ManyToMany, students and courses, authors and books, employee and projects

7.  What is the cascade = CascadeType.ALL, orphanRemoval = true ? and what are the other CascadeType
    and their features? In which situation we choose which one?

    > CascadeType.ALL means all operations(persist, merge, remove, refresh, detach) applied to the parent is cascaded to child entities. Use this if you want full control over child through the parent.
    > OrphanRemoval means removing child entities if they are removed from the parent's collection. Use this when the child entity should not exist independently.
    > persist: save child entity when saving the parent.
    > remove: delete child when deleting the parent.
    > detach: detach child when the parent is detached.
    > merge: update child when updating the parent.
    > refresh: reload child when the parent is refreshed.

8.  What is the fetch = FetchType.LAZY, fetch = FetchType.EAGER ? what is the difference? In which
    situation you choose which one?

    > Lazy - data is loaded when accessed. Default for collections.
    > eager - data is loaded when the parent is fetched. Default for single relationshp.(@OneToOne, @ManyToOne)

9.  What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list.
    some examples?

    > CamelCase for field names while underscore for column names. yes. findByPostId()

10. Try to use JPA advanced methods in your class project. In the repository layer, you need to use the naming
    convention to use the method provided by JPA.
    '''
    @Repository
    public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Post> findByPostId(Long postId);
    }

        public interface CustomerRepository extends JpaRepository<Customer, Long> {

        @Query("SELECT c FROM Customer c WHERE c.name LIKE %:name%")
        List<Customer> findCustomersByNameLike(@Param("name") String name);

        @Query("SELECT COUNT(c) FROM Customer c")
        long countAllCustomers();

        @Query("SELECT c.name FROM Customer c WHERE c.id = :id")
        String findCustomerNameById(@Param("id") Long id);

    }
    '''

11. (Optional) Check out a new branch(https://github.com/TAIsRich/springboot-redbook/tree/hw02_01_jdbcT
    emplate) from branch 02_post_RUD, replace the dao layer using JdbcTemplate.
12. type the code, you need to checkout new branch from branch 02_post_RUD, name the new branch with h
    ttps://github.com/TAIsRich/springboot-redbook/tree/hw05_01_slides_JPQL.
13. What is JPQL?
    > JPQL (Java Persistence Query Language) is a SQL-like language used in JPA to interact with databases.
14. What is @NamedQuery and @NamedQueries?

    > Used to define static queries at the entity level.

15. What is @Query? In which Interface we write the sql or JPQL?

    > @Query is an annotation used in repository interfaces to write custom queries. You can write either JPQL queries (which operate on entities) or native SQL queries (which operate directly on database tables).

16. What is HQL and Criteria Queries?

    > HQL (Hibernate Query Language) is an object-oriented query language for Hibernate.
    > Programmatic API: Criteria Queries provide a programmatic way to build queries using Java objects and methods. They are type-safe and don't involve writing strings of HQL or SQL.
    > ???

17. What is EnityManager?

    > The EntityManager in JPA is the primary interface through which an application interacts with the Persistence Context, which is responsible for managing the lifecycle of entity objects and their persistence in the database. The EntityManager provides a set of APIs for performing CRUD (Create, Read, Update, Delete) operations on the database using the entity objects.

18. What is SessionFactory and Session?

    > A session is an object that maintains the connection between Java object application and database. Session also has methods for storing, retrieving, modifying or deleting data from database using methods like persist(), load(), get(), update(), delete(), etc. Additionally, It has factory methods to return Query, Criteria, and Transaction objects.
    > SessionFactory provides an instance of Session. It is a factory class that gives the Session objects based on the configuration parameters in order to establish the connection to the database.
    > As a good practice, the application generally has a single instance of SessionFactory. The internal state of a SessionFactory which includes metadata about ORM is immutable, i.e once the instance is created, it cannot be changed.This also provides the facility to get information like statistics and metadata related to a class, query executions, etc. It also holds second-level cache data if enabled. This cache is maintained at the SessionFactory level and shared among all sessions in Hibernate.

19. What is Transaction? how to manage your transaction?

    > A transaction is a sequence of database operations that must be executed as a unit.

20. What is hibernate Caching? Explain Hibernate caching mechanism in detail.
21. What is the difference between first-level cache and second-level cache?
22. How do you understand @Transactional? (https://github.com/TAIsRich/tutorial-transaction)

Hibernate core interfaces are:

Configuration
SessionFactory
Session: First Level Cache is local to the Session object and cannot be shared between multiple sessions.
Criteria
Query
Transaction
