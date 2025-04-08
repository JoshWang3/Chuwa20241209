### 1. List all of the annotations you learned from class and homework to annotaitons.md

### 2. Type out the code for the Comment feature of the class project.

### 3. In postman, call all of the APIs in PostController and CommentController.

### 4. What is JPA? and what is Hibernate?

#### JPA (Java Persistence API):

- JPA is a **specification** (i.e., a set of rules and interfaces) for managing relational data in Java applications.
- It defines **how** Java objects should be mapped to database tables.
- JPA is **part of the Java EE (Jakarta EE)** standard.
- It provides annotations like `@Entity`, `@Id`, `@OneToMany`, etc.
- JPA does **not** provide the actual implementation—it just defines how things should work.

#### Hibernate:

- Hibernate is a **JPA implementation**—a concrete library that follows the JPA specification.
- It is the **most popular JPA provider** in the Java ecosystem.
- In addition to supporting all JPA features, Hibernate provides **extra features** like:
  - Caching
  - Lazy loading
  - Dirty checking
  - Custom SQL support

#### Analogy:

- JPA is like a **contract or interface**.
- Hibernate is like a **class that implements the contract**.

---

### 5. What is Hiraki? what is the benefits of connection pool?

#### What is Hikari?

- **HikariCP** is a **high-performance JDBC connection pool**.
- It is the **default connection pool used by Spring Boot** (since version 2.0).
- It manages and optimizes database connections efficiently.
- Hikari is known for its **speed, reliability, and low memory usage**.

---

#### What is a Connection Pool?

- A **connection pool** is a cache of database connections that can be reused.
- Instead of opening a new DB connection for every request (which is slow and resource-heavy), the pool **reuses existing connections**.
- When a request needs to access the database:
  - It **borrows** a connection from the pool.
  - After the request is done, the connection is **returned** to the pool.

---

### Benefits of Using a Connection Pool:

1. **Performance Boost**

   - Reusing connections avoids the cost of repeatedly opening and closing DB connections.

2. **Resource Efficiency**

   - Limits the number of open connections, preventing DB overload.

3. **Faster Response Time**

   - Reduces latency in serving database operations.

4. **Connection Management**
   - Handles connection timeouts, validation, and error recovery.

---

### 6. What is the @OneToMany, @ManyToOne, @ManyToMany ? write some examples.

These annotations are used in JPA to define **relationships between entities** (i.e., how tables relate to each other in the database).

---

### 1. @OneToMany

- Represents a **one-to-many** relationship.
- One entity (e.g., User) can have many related entities (e.g., Posts).

#### Example:

```java
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;
}
```

```java
@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
```

---

### 2. @ManyToOne

- Represents a **many-to-one** relationship.
- Many entities (e.g., Posts) belong to one parent entity (e.g., User).
- This is the inverse of `@OneToMany`.

#### Example (same as above):

```java
@ManyToOne
@JoinColumn(name = "user_id")
private User user;
```

---

### 3. @ManyToMany

- Represents a **many-to-many** relationship.
- Many entities from both sides can relate to each other.
- Usually requires a **join table**.

#### Example:

```java
@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany
    @JoinTable(
        name = "student_course",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;
}
```

```java
@Entity
public class Course {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;
}
```

---

### 7. What is the cascade = CascadeType.ALL, orphanRemoval = true ? and what are the other CascadeType and their features? In which situation we choose which one?

- Propagates operations like `persist`, `merge`, `remove` from parent to children.
- `orphanRemoval = true` will delete child entities when they are removed from the parent’s collection.

### CascadeTypes:

- `PERSIST` – Save children when parent is saved.
- `MERGE` – Update children when parent is updated.
- `REMOVE` – Delete children when parent is deleted.
- `REFRESH` – Refresh children when parent is refreshed from DB.
- `DETACH` – Detach children when parent is detached from persistence context.

```

### 8. What is the fetch = FetchType.LAZY, fetch = FetchType.EAGER ? what is the difference? In which situation you choose which one?

- `FetchType.LAZY`: Loads related entities **only when accessed** (on-demand).
- `FetchType.EAGER`: Loads related entities **immediately** with the parent entity.

### Difference:
- LAZY is **more efficient** for large data or when related data is not always needed.
- EAGER is **convenient** when you always need the related data right away.

### When to Use:
- Use **LAZY** by default for `@OneToMany` and `@ManyToMany` to avoid performance issues.
- Use **EAGER** when the relationship is essential for every use case (e.g., `@ManyToOne` like `Post → Author`).
```

### 9. What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?

- JPA (via Spring Data JPA) allows you to define **query methods by following naming conventions**.
- You do **not** need to implement them manually—Spring will auto-generate the query based on the method name.

### Common Rules:

- Start with keywords like `findBy`, `countBy`, `deleteBy`
- Followed by entity field names (case-sensitive to the field)
- Combine with keywords like `And`, `Or`, `Between`, `In`, `Like`, `OrderBy`, etc.

### Examples:

```java
List<User> findByName(String name);
List<User> findByEmailAndStatus(String email, String status);
List<User> findByAgeGreaterThan(int age);
List<User> findByNameContaining(String keyword);
List<User> findByCreatedAtBetween(Date start, Date end);
List<User> findByRoleIn(List<String> roles);
List<User> findByIsActiveTrueOrderByCreatedAtDesc();
```

### 10. Try to use JPA advanced methods in your class project. In the repository layer, you need to use the naming convention to use the method provided by JPA.

### 11. (Optional) Check out a new branch(https://github.com/TAIsRich/springboot-redbook/tree/hw02_01_jdbcTemplate) from branch 02_post_RUD, replace the dao layer using JdbcTemplate.

### 12. type the code, you need to checkout new branch from branch 02_post_RUD, name the new branch with https://github.com/TAIsRich/springboot-redbook/tree/hw05_01_slides_JPQL.

### 13. What is JPQL?

- JPQL stands for **Java Persistence Query Language**.
- It is an **object-oriented** query language used in JPA.
- Unlike SQL, JPQL queries **entity objects and fields**, not database tables and columns.

### 14. What is @NamedQuery and @NamedQueries?

- `@NamedQuery`: Defines a **static JPQL query** with a name, placed on an entity class.
- `@NamedQueries`: Container for multiple `@NamedQuery` annotations.

### Purpose:

- Predefine queries for reuse.
- Improves readability and performance (can be compiled at startup).

### 15. What is @Query? In which Interface we write the sql or JPQL?

- `@Query` is used to define **custom JPQL or native SQL queries** inside repository interfaces.

### Where to Use:

- Inside interfaces that **extend `JpaRepository`**, `CrudRepository`, or `PagingAndSortingRepository`.

### 16. What is HQL and Criteria Queries?

#### HQL (Hibernate Query Language):

- Similar to JPQL, but specific to **Hibernate**.
- Uses **entity names and fields**, not table or column names.

#### Criteria Queries:

- A **type-safe**, **programmatic** way to build dynamic queries using Java code.
- Useful when query conditions change at runtime.

### 17. What is EnityManager?

- `EntityManager` is the **main interface in JPA** for interacting with the database.
- It manages the lifecycle of entity objects and handles operations like **persist, find, merge, remove**.

### Common Methods:

- `persist(entity)` → Save a new entity.
- `find(EntityClass.class, id)` → Find an entity by ID.
- `merge(entity)` → Update an existing entity.
- `remove(entity)` → Delete an entity.
- `createQuery(...)` → Run JPQL or Criteria queries.

### Example:

```java
@PersistenceContext
private EntityManager entityManager;

User user = entityManager.find(User.class, 1L);
```

### 18. What is SessionFactory and Session?

#### SessionFactory:

- A **Hibernate object** used to create `Session` instances.
- It is **heavyweight** and created only **once** per application (usually at startup).
- Responsible for managing database configurations and caching metadata.

#### Session:

- A **lightweight, single-threaded** object used to perform CRUD and query operations.
- Obtained from `SessionFactory`.
- Similar to `EntityManager` in JPA.

### 19. What is Transaction? how to manage your transaction?

#### What is a Transaction?

- A **transaction** is a sequence of operations that are **executed as a single unit**.
- It follows the **ACID** properties:
  - **A**tomic: all or nothing
  - **C**onsistent: keeps data valid
  - **I**solated: no interference
  - **D**urable: changes persist

#### How to Manage Transactions in Spring Boot?

1. **Declarative (Recommended)**

- Use `@Transactional` to wrap a method in a transaction.

```java
@Service
public class UserService {

  @Transactional
  public void createUser(User user) {
    userRepository.save(user);
    // other operations
  }
}
```

2. **Programmatic**

- Manually begin and commit using `EntityManager` or `TransactionTemplate` (less common).

### 20. What is hibernate Caching? Explain Hibernate caching mechanism in detail.

#### What is Hibernate Caching?

- Hibernate caching is a way to **reduce database access** by storing frequently accessed data in memory.
- It helps improve performance by **avoiding repeated queries** for the same data.

---

### Levels of Caching in Hibernate:

#### 1. First-Level Cache (Session Cache)

- Built-in and **enabled by default**.
- Works per Hibernate `Session` object.
- Caches entities within the same session.
- Example: Repeated `session.get()` for the same ID does not hit the DB again.

#### 2. Second-Level Cache

- Works across sessions.
- Needs to be **explicitly enabled** and configured using providers like:
  - EhCache
  - Infinispan
  - Caffeine
- Shared between sessions in the same application.

#### 3. Query Cache (Optional)

- Caches the **results of queries**, not just entities.
- Must be enabled separately.

```properties
hibernate.cache.use_query_cache=true
```

### 21. What is the difference between first-level cache and second-level cache?

```
### 21. What is the Difference Between First-Level Cache and Second-Level Cache?

| Feature              | First-Level Cache            | Second-Level Cache             |
|----------------------|------------------------------|---------------------------------|
| Scope                | Per `Session`                | Across multiple `Session`s     |
| Default              | Enabled by default           | Must be manually enabled       |
| Configuration        | No config needed             | Requires setup (e.g., EhCache) |
| Storage              | In-memory (per session)      | In-memory (shared region)      |
| Shared across sessions | ❌ No                      | ✅ Yes                          |
| Used for             | Repeated access in one session | Reuse across sessions         |

### Summary:
- **First-Level Cache**: Auto-enabled, per session.
- **Second-Level Cache**: Optional, shared across sessions, good for read-heavy apps.
```

### 22. How do you understand @Transactional? (https://github.com/TAIsRich/tutorial-transaction)

- `@Transactional` is a Spring annotation used to **manage database transactions**.
- It wraps a method so that **all DB operations inside it run in a single transaction**.

### Key Features:

- If the method completes successfully, changes are **committed**.
- If an exception occurs, changes are **rolled back automatically**.
- Helps maintain **data consistency**.

```

```
