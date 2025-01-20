## HW9

### What is JPA? and what is Hibernate?
- JPA: A Java specification for mapping Java objects to relational databases and performing database operations using annotations and JPQL.
- Hibernate: A popular ORM framework and implementation of JPA, providing extended features like caching, lazy loading, and custom SQL support.
### What is Hiraki? what is the benefits of connection pool?
HikariCP: A high-performance JDBC connection pool library for Java, known for its simplicity, reliability, and speed.

Benefits of a Connection Pool:
- Performance: Reuses existing connections instead of creating new ones, reducing overhead.
- Resource Management: Controls the number of database connections, preventing exhaustion.
- Scalability: Handles high traffic efficiently by pooling and managing connections.
- Latency Reduction: Minimizes connection creation time, speeding up requests.

### What is the @OneToMany, @ManyToOne, @ManyToMany ? write some examples.
- @OneToMany: Defines a one-to-many relationship between two entities (one parent entity associated with multiple child entities).
- @ManyToOne: Defines a many-to-one relationship (multiple child entities associated with one parent entity).
- @ManyToMany: Defines a many-to-many relationship (multiple entities related to multiple entities).
```
@Entity
public class Author {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();
}

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}

```
### What is the cascade = CascadeType.ALL, orphanRemoval = true ? and what are the other CascadeType and their features? In which situation we choose which one?  
CascadeType.ALL and orphanRemoval = true
- CascadeType.ALL: Applies all cascade operations (persist, merge, remove, refresh, detach) to the associated entity. When an operation is performed on the parent, the same is applied to its children.
- orphanRemoval = true: Automatically deletes child entities when they are removed from the parent’s collection or reference is set to null.

Other Cascade Types and Their Features
- CascadeType.PERSIST:
Propagates the persist operation.
Example: Saves child entities automatically when saving the parent.
CascadeType.MERGE:

- Propagates the merge operation.
Example: Updates child entities when the parent is updated.
CascadeType.REMOVE:

- Propagates the remove operation.
Example: Deletes child entities when the parent is deleted.
CascadeType.REFRESH:

- Propagates the refresh operation.
Example: Synchronizes child entities with the database when refreshing the parent.
CascadeType.DETACH:

- Propagates the detach operation.
Example: Detaches child entities from the persistence context when the parent is detached.
```
@Entity
public class Parent {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Child> children = new ArrayList<>();
}

@Entity
public class Child {
    @Id
    @GeneratedValue
    private Long id;
}
```
### What is the fetch = FetchType.LAZY, fetch = FetchType.EAGER ? what is the difference? In which situation you choose which one?

1. **FetchType.LAZY**:
    - Data is loaded only when explicitly accessed (on demand).
    - Default for `@OneToMany` and `@ManyToMany` relationships.

2. **FetchType.EAGER**:
    - Data is loaded immediately with the parent entity.
    - Default for `@ManyToOne` and `@OneToOne` relationships.

**Difference**
- **LAZY**:
    - Reduces initial query load by not fetching related entities.
    - Uses proxy objects to load data when accessed.
- **EAGER**:
    - Fetches all related entities in a single query.
    - Can lead to unnecessary data loading and performance issues.


### **Choosing FetchType**
- **LAZY**:
    - Use when related data is not always needed (e.g., loading a `Category` without its `Products`).
- **EAGER**:
    - Use when related data is always required (e.g., loading an `Order` with its `Customer`).

### What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?
1. **Entity Names**:
    - Class names should follow camel case (e.g., `Customer`, `OrderDetail`).
    - Singular form for entity names (e.g., `User` instead of `Users`).

2. **Table Names**:
    - Use `@Table` to specify table names if different from the entity name.
    - Use snake case for table names (e.g., `order_details`).

3. **Column Names**:
    - Use `@Column` to specify column names if different from the field name.
    - Use snake case for column names (e.g., `created_at`).

4. **Primary Key**:
    - Use `id` as the default primary key field or customize with `@Id`.


**Custom Methods in JPA**
- JPA provides default CRUD methods via the repository.
- You can implement custom methods using:
    - JPQL (`@Query`).
    - Native SQL (`@Query(nativeQuery = true)`).
    - Method naming conventions in Spring Data JPA.

```java
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "user_name")
    private String name;
}
```
### What is JPQL?
- JPQL is a query language defined by JPA for interacting with databases using entity objects instead of database tables.
- It is object-oriented and works with entity attributes, not table columns.
**Features of JPQL**
1. **Entity-based**: Queries are written using entity names and their fields.
2. **Database Independence**: Queries are abstracted from the underlying database schema.
3. **Similar to SQL**: Syntax is similar to SQL, but JPQL works with objects and their relationships.

```java
@Query("SELECT u FROM User u WHERE u.name = :name")
List<User> findByName(@Param("name") String name);
```
### What is @NamedQuery and @NamedQueries?
- **@NamedQuery**: Defines a static JPQL query with a name that can be reused across the application.
- **@NamedQueries**: A container annotation for grouping multiple `@NamedQuery` annotations.

 **Features**
1. Queries are defined at the entity level and can be executed via the EntityManager.
2. Promotes reusability and improves query readability.
3. Parsed and validated at application startup, reducing runtime errors.

```java
@Entity
@NamedQuery(name = "User.findByName", query = "SELECT u FROM User u WHERE u.name = :name")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
```
### What is @Query? In which Interface we write the sql or JPQL?
- **@Query**: Annotation used in Spring Data JPA to define custom SQL or JPQL queries directly in repository interfaces.
- Allows precise control over database operations with custom logic.
**Where to Write SQL or JPQL**
- Queries are written in **Spring Data JPA Repository Interfaces**, typically extending `JpaRepository` or `CrudRepository`.
```java
@Query("SELECT u FROM User u WHERE u.name = :name")
List<User> findByName(@Param("name") String name);
```
### What is HQL and Criteria Queries?
**HQL (Hibernate Query Language)**
- HQL is an object-oriented query language in Hibernate, similar to SQL but works with entity objects instead of database tables.
- Syntax is similar to SQL but uses entity names and their attributes.
**Features of HQL**:
1. Queries entity objects, not tables.
2. Supports joins, aggregations, and subqueries.
3. Database-independent.
```java
Query query = session.createQuery("FROM User u WHERE u.name = :name");
query.setParameter("name", "John");
List<User> users = query.list();
```
### What is EnityManager?
- **EntityManager** is the primary JPA interface for interacting with the persistence context.
- It is used to manage the lifecycle of entities (persist, find, update, remove) and execute queries.
**Key Responsibilities**
1. **Persistence Context**: Maintains a cache of managed entities, ensuring a single instance per transaction.
2. **CRUD Operations**:
    - `persist()`: Save a new entity.
    - `find()`: Retrieve an entity by its primary key.
    - `merge()`: Update an entity.
    - `remove()`: Delete an entity.
3. **Transaction Management**: Works with transactions for database operations.
4. **JPQL/Native Queries**: Allows execution of custom JPQL or SQL queries.
```java
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
```
### What is SessionFactory and Session?
 **SessionFactory**
- A **SessionFactory** is a heavyweight object in Hibernate that creates and manages database connections and `Session` objects.
- It is thread-safe and typically created once per application (often at startup).

 **Features**:
1. Maintains Hibernate configuration and mappings.
2. Provides `Session` objects for database operations.
3. Optimized for performance, reusing database connections.

##### **Example**:
```java
SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
```
### What is Transaction? how to manage your transaction?
- A **Transaction** in Hibernate/JPA represents a unit of work that ensures multiple database operations are executed as a single, atomic operation.
- It guarantees **ACID** properties:
    1. **Atomicity**: All operations are completed or none are applied.
    2. **Consistency**: Maintains database integrity.
    3. **Isolation**: Transactions do not interfere with each other.
    4. **Durability**: Changes are permanent once committed.

### What is hibernate Caching? Explain Hibernate caching mechanism in detail.
- Hibernate caching is a mechanism to reduce database access and improve application performance by storing frequently accessed data in memory.
- Caching minimizes the number of database queries, resulting in faster response times and reduced database load.
- **Default Cache**: Enabled by default and tied to the Hibernate `Session`.
- **Scope**: Exists only within a single session.
- **Features**:
    - Stores entities, collections, and relationships read or written during a session.
    - No explicit configuration required.
- **Limitations**:
    - Not shared across sessions.
    - Data is lost once the session is closed.
### What is the difference between first-level cache and second-level cache?
| **Aspect**            | **First-Level Cache**                     | **Second-Level Cache**                     |
|------------------------|-------------------------------------------|--------------------------------------------|
| **Scope**             | Per `Session` (session-specific).         | Global (shared across multiple sessions).  |
| **Enabled By Default**| Yes, always enabled.                      | No, must be explicitly configured.         |
| **Purpose**           | Caches entities within a single session.  | Caches entities across multiple sessions.  |
| **Persistence**       | Cleared when the session is closed.        | Persists until explicitly cleared or evicted. |
| **Configuration**     | No configuration required.                | Requires a caching provider (e.g., Ehcache, Infinispan). |
| **Use Case**          | Temporary caching during session lifespan.| Long-term caching for frequently accessed data. |
| **Customization**     | Cannot be customized.                     | Highly configurable (e.g., TTL, eviction policies). |
| **Caching Levels**    | Caches entities, collections, and relationships. | Extends to query results when query cache is enabled. |
