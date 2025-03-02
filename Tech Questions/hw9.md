4. What is JPA? and what is Hibernate?  

```
Java Persistence API: Java specification for managing relational data in Java applications. It provides a standard for object-relational mapping (ORM).
ORM: An implementation of JPA, providing ORM tools and capabilities for mapping Java objects to database tables.
```

5. What is Hiraki? what is the benefits of connection pool?  

```
 A high-performance JDBC connection pool used for managing database connections.
 benefits: Reduces the overhead of repeatedly opening and closing database connections, improves application performance by reusing established connections.
```

6. What is the @OneToMany, @ManyToOne, @ManyToMany ? write some examples  

```
@OneToMany: A one-to-many relationship between two entities
@ManyToOne: A many-to-one relationship
@ManyToMany: A many-to-many relationship.
example in annotation.md
```

7. What is the cascade = CascadeType.ALL, orphanRemoval = true ? and what are the other CascadeType
   and their features? In which situation we choose which one?  

```
CascadeType.ALL: Propagates all persistence operations (like persist, merge, remove) to related entities.
orphanRemoval = true: Automatically removes entities from the database when they are no longer referenced.
Other CascadeTypes: PERSIST, MERGE, REMOVE, REFRESH, DETACH.
```

8. What is the fetch = FetchType.LAZY, fetch = FetchType.EAGER ? what is the difference? In which
   situation you choose which one?  

```
LAZY: Loads the related entity only when accessed (default).
EAGER: Loads the related entity immediately when the parent is loaded.
Use LAZY for performance optimization; use EAGER when the related entity is always needed.
```

9. What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?  

```
should follow pattern: findBy<AttributeName>, countBy, deleteBy
findByName()
deleteById()
countByStatus()
```

13. What is JPQL?  

```
Java Persistence Query Language: A query language similar to SQL but operates on entity objects rather than database tables.
```

14. What is @NamedQuery and @NamedQueries?  

```java
//@NamedQuery: Defines a static, pre-defined JPQL query on an entity.
@NamedQuery(name = "Post.findByTitle", query = "SELECT p FROM Post p WHERE p.title = :title")

//@NamedQueries: A container for multiple @NamedQuery annotations.
```

15. What is @Query? In which Interface we write the sql or JPQL?  

```java
//@Query: Specifies a custom SQL or JPQL query on a repository method
//write in Spring Data JPA repository interfaces

@Query("SELECT p FROM Post p WHERE p.title = :title")
List<Post> findByTitle(@Param("title") String title);

```

16. What is HQL and Criteria Queries?  

```
Hibernate Query Language: Similar to JPQL, but specific to Hibernate.
Criteria Queries: A type-safe way to create dynamic queries using the Criteria API in Java.
```

17. What is EnityManager?  

```
The JPA interface used for managing entities and performing CRUD operations in the persistence context.
```

18. What is SessionFactory and Session?  

```
SessionFactory: A factory for creating Hibernate Session objects, responsible for managing the lifecycle of entities.
Session: A single-threaded unit of work that interacts with the database.
```

19. What is Transaction? how to manage your transaction?  

```
Transaction: A sequence of operations executed as a single unit of work. It ensures consistency, isolation, and atomicity.
@Transactional to manage transactions automatically in Spring.
```

20. What is hibernate Caching? Explain Hibernate caching mechanism in detail.  

```
A mechanism to store objects in memory to reduce database calls.
It has First-level cache (Session cache) and Second-level cache (SessionFactory-wide cache).
```

21. What is the difference between first-level cache and second-level cache?  

```
First-level cache: Session-based, automatically managed, scoped to a single session.
Second-level cache: Configurable, can be shared across sessions, managed by the SessionFactory.
```

22. How do you understand @Transactional?   

```
 Marks a method or class to be executed within a transaction. Spring manages the beginning, commit, and rollback of the transaction.
```

