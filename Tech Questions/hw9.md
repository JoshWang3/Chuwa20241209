#### HW9 - Spring-Data

##### 1. List all of the annotations you learned from class and homework to annotaitons.md

##### 2. Type out the code for the Comment feature of the class project.



##### 3. In postman, call all of the APIs in PostController and CommentController.



##### 4. What is JPA? and what is Hibernate?

```
JPA is a standard specification for object-relational mapping (ORM) in Java.
It provides a way to map Java objects to database tables, so you can interact with a relational database using Java objects instead of SQL queries. 
JPA defines how Java objects are stored and retrieved from a relational database.

Hibernate is an implementation of JPA, which also provides extra features beyond JPA.
```

##### 5. What is Hiraki? what is the benefits of connection pool?

```
HikariCP (Hikari Connection Pool) is a high-performance JDBC connection pool for Java applications.

HikariCP is widely used for managing database connections in applications, including in frameworks like Spring Boot.
Connection pooling helps improve performance, resource management, concurrency, and scalability by reusing database connections, reducing the need to constantly open and close connections.

```

##### 6. What is the @OneToMany, @ManyToOne, @ManyToMany ? write some examples.

```
@OneToMany: define a one-to-many relationship between two entities.

import javax.persistence.*;
import java.util.List;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // One Department has many Employees
    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

}
```

```

@ManyToOne: many instances of an entity are associated with a single instance of another entity.

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Many Employees belong to one Department
    @ManyToOne
    @JoinColumn(name = "department_id")  // Foreign key column in the Employee table
    private Department department;

}
```


```
@ManyToMany: many instances of one entity are associated with many instances of another entity.

import javax.persistence.*;
import java.util.List;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Many Departments have many Employees
    @ManyToMany
    @JoinTable(
      name = "department_employee",  // Join table name
      joinColumns = @JoinColumn(name = "department_id"),  // Foreign key to Department
      inverseJoinColumns = @JoinColumn(name = "employee_id")  // Foreign key to Employee
    )
    private List<Employee> employees;

}

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Many Employees belong to many Departments
    @ManyToMany(mappedBy = "employees")  // Inverse side of the relationship
    private List<Department> departments;

}
```

##### 7. What is the cascade = CascadeType.ALL, orphanRemoval = true ? and what are the other CascadeType and their features? In which situation we choose which one?

```
CascadeType.ALL: Applies all possible cascade operations (PERSIST, MERGE, REMOVE, REFRESH, DETACH).

orphanRemoval = true: Ensures child entities are deleted when they are removed from the parent’s collection.

CascadeType.PERSIST: If the parent entity is saved, the associated child entities will also be persisted automatically.

CascadeType.MERGE:  If the parent entity is updated, the associated child entities will also be merged (updated) automatically.

CascadeType.REMOVE:	 If the parent entity is removed, the associated child entities will be removed automatically.

CascadeType.REFRESH: If the parent entity is refreshed, the associated child entities will be refreshed automatically.

CascadeType.DETACH:	 If the parent entity is detached, the associated child entities will also be detached.

CascadeType.ALL: Enables all of the above cascade types: PERSIST, MERGE, REMOVE, REFRESH, DETACH.

```

##### 8. What is the fetch = FetchType.LAZY, fetch = FetchType.EAGER ? what is the difference? In which situation you choose which one?

```
Fetch refers to the strategy used to load related entities (associations) from the database.

FetchType.LAZY:
The associated entities (related objects) are not fetched immediately when the parent entity is retrieved. 
They are loaded only when they are accessed
It is often used for large or complex relationships.
The associated entities are loaded immediately when the parent entity is retrieved.
```

##### 9. What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?

```
Java Class (Entity) are usually singular.
Database Table uses lowercase and snake_case.

Java fields should follow standard camelCase naming conventions, such as firstName.
Database Columns are usually converted to lowercase and snake_case, words separated by underscores.
Relationships Between Entities uses snake_case.
The primary key field 

Spring Data JPA automatically generates the queries based on the method names in the repository interfaces. 
It will create queries for standard operations like find, count, delete, and more using the naming conventions.

For examples: 

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Automatically generated query: SELECT * FROM employee WHERE first_name = ?
    List<Employee> findByFirstName(String firstName);

    // Automatically generated query: SELECT * FROM employee WHERE last_name = ? AND department_id = ?
    List<Employee> findByLastNameAndDepartment(String lastName, Department department);

    // Custom query using @Query
    @Query("SELECT e FROM Employee e WHERE e.firstName = :firstName AND e.department.name = :departmentName")
    List<Employee> findByFirstNameAndDepartmentName(@Param("firstName") String firstName, @Param("departmentName") String departmentName);
}
```

##### 10. Try to use JPA advanced methods in your class project. In the repository layer, you need to use the naming convention to use the method provided by JPA.



##### 11. (Optional) Check out a new branch(https://github.com/TAIsRich/springboot-redbook/tree/hw02_01_jdbcTemplate) from branch 02_post_RUD, replace the dao layer using JdbcTemplate.



##### 12. type the code, you need to checkout new branch from branch 02_post_RUD, name the new branch with https://github.com/TAIsRich/springboot-redbook/tree/hw05_01_slides_JPQL.



##### 13. What is JPQL?

```
JPQL (Java Persistence Query Language) is a powerful, object-oriented query language for JPA. 
JPQL supports complex querying capabilities such as joins, grouping, and filtering.
 
For example, SELECT e FROM Employee e JOIN e.department d WHERE d.name = :departmentName
```

##### 14. What is @NamedQuery and @NamedQueries?

```
@NamedQuery: Defines a single, static query that can be referenced by name.

import javax.persistence.*;

@Entity
@NamedQuery(
    name = "Employee.findByDepartment", 
    query = "SELECT e FROM Employee e WHERE e.department.name = :departmentName"
)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    
}
```

```
@NamedQueries: Defines multiple @NamedQuery annotations to be defined.

import javax.persistence.*;

@Entity
@NamedQueries({
    @NamedQuery(name = "Employee.findByFirstName", query = "SELECT e FROM Employee e WHERE e.firstName = :firstName"),
    @NamedQuery(name = "Employee.findByLastName", query = "SELECT e FROM Employee e WHERE e.lastName = :lastName"),
    @NamedQuery(name = "Employee.findByDepartmentName", query = "SELECT e FROM Employee e WHERE e.department.name = :departmentName")
})
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

}
```

##### 15. What is @Query? In which Interface we write the sql or JPQL?

```
@Query is used to define custom JPQL or native SQL queries directly in the repository interface.

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // JPQL Query
    @Query("SELECT e FROM Employee e WHERE e.department.name = :departmentName")
    List<Employee> findEmployeesByDepartment(@Param("departmentName") String departmentName);

    // Native SQL Query
    @Query(value = "SELECT * FROM employee WHERE department_name = :departmentName", nativeQuery = true)
    List<Employee> findEmployeesByDepartmentNative(@Param("departmentName") String departmentName);
}

The Repository Interface is where we define these queries, and the Service Layer or Controller Layer calls these repository methods to execute them.
```

##### 16. What is HQL and Criteria Queries?

```
HQL is a query language similar to SQL. It operates on entity objects instead of database tables. 

String hql = "FROM Employee e WHERE e.department.name = :departmentName";
Query query = session.createQuery(hql);
query.setParameter("departmentName", "Sales");
List<Employee> employees = query.list();

The Criteria Queries(Criteria API) is a programmatic way of constructing queries in JPA (and Hibernate) using a type-safe approach.
It allows build queries dynamically through Java code instead of writing them as string literals.

```

##### 17. What is EnityManager?

```
The EntityManager is a fundamental part of JPA and is used to interact with the persistence context.
It provides various methods to manage the lifecycle of entities, perform CRUD operations, execute queries, and handle transactions.

Common methods available in the EntityManager interface are: persist(), find(), merge(), remove(), flush(), clear()

	@PersistenceContext
	private EntityManager entityManager;
	
The lifecycle states of an entity are: Transient, Managed, Detached, Removed
```

##### 18. What is SessionFactory and Session?

```
SessionFactory: Hibernate interface used to create Session instances.
SessionFactory is a heavy object responsible for creating Session objects and managing configuration.

It is typically created once during application startup and shared throughout the application's lifetime.

Session: IT is a lightweight, non-thread-safe object that represents a unit of work within a database transaction, 
responsible for performing operations (e.g., insert, update, delete) on entities. 

It is opened and closed within each request or transaction scope.
```

##### 19. What is Transaction? how to manage your transaction?

```
Transaction is a fundamental concept in Hibernate and JPA that groups multiple operations into a single, atomic unit of work.

Proper transaction management ensures that the database remains in a consistent state and that operations are either fully committed or fully rolled back in the case of failure.

Spring's @Transactional annotation simplifies transaction management by automatically handling commit and rollback.
```

##### 20. What is hibernate Caching? Explain Hibernate caching mechanism in detail.

```
Hibernate Caching is a mechanism that helps improve the performance of Hibernate-based applications by reducing the number of database queries and the associated overhead.

It allows Hibernate to store the results of previously executed queries or entity objects in memory, so that subsequent requests can retrieve the data from the cache rather than making expensive database queries.

Hibernate offers two levels of caching:

First-level cache (Session Cache): 
	It is enabled by default. 
	It is automatically managed by Hibernate.
	It is not shared across sessions.
	It is per-session. Each session has its own cache. Only visible within the same session.	
	It is a write-through cache. Data is directly written to the cache as soon as it is fetched or updated.	
	
Second-level cache (SessionFactory Cache):
	Caches query results (not entities).
	Requires second-level cache to be enabled.
	Useful for frequently executed queries that return the same result set over time.	
```

##### 21. What is the difference between first-level cache and second-level cache?

```
first-level cache:
	Always enabled.
	Session-specific.
	No configuration required.
	Cached data is cleared once the session is closed.

second-level cache:
	Optional, requires explicit configuration.
	Shared across multiple sessions.
	Can persist data beyond a single session.
	Reduces the number of queries made to the database, especially for read-heavy applications.
```

##### 22. How do you understand @Transactional? (https://github.com/TAIsRich/tutorial-transaction)

```
@Transactional is used to define a method or class that runs within a transaction boundary.
It ensures atomicity, consistency, isolation, and durability (ACID properties) for database operations.
We can configure propagation, isolation level, timeout, and rollback rules using the attributes of @Transactional.
It simplifies transaction management.
Read-only transactions and nested transactions can also be handled efficiently with @Transactional.

With @Transactional, the database operations are well-managed, consistent, and can be rolled back in case of errors.
```