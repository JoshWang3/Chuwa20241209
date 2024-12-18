## HW2
### 1. Write up Example code to demonstrate the three foundmental concepts of OOP. (reference Code Demo repo as example)
Please refer to repo/Coding/ood_example
### 2. What is wrapper class in Java and Why we need wrapper class?
A wrapper class in Java provides an object representation for primitive data types (e.g., int → Integer).  

Why Need:
- Enables use in collections (e.g., List<Integer>).
- Provides utility methods (e.g., parsing).
- Supports autoboxing/unboxing.
### 3. What is the difference between HashMap and HashTable?
HashMap: Not synchronized(not thread-safe), allows one null key and multiple null values.  
HashTable: Synchronized(thread-safe), does not allow null keys or values.
### 4. What is String pool in Java and why we need String pool?
A String pool is a memory area in the JVM where immutable string literals are stored to **save memory** and **improve performance** by reusing existing string objects.
### 5. What is Java garbage collection?
Garbage collection is the process of automatically reclaiming memory occupied by objects no longer in use, **preventing memory leaks**.
### 6. What are access modifiers and their scopes in Java?
- Public: Accessible everywhere.
- Private: Accessible only within the same class.
- Protected: Accessible in the same package and subclasses.
- Default (no modifier): Accessible only in the same package.
### 7. What is final key word? (Filed, Method, Class)
- Field: Value cannot be changed.  
- Method: Cannot be overridden.  
- Class: Cannot be subclassed.  
### 8. What is static keyword? (Filed, Method, Class). When do we usually use it?
- Field: Shared by all instances.  
- Method: Can be called without creating an object.  
- Class (nested): Belongs to outer class without requiring an instance.  

When to use static variables:  
- To represent class-wide data that should be shared across all instances (e.g., a count of all instances).  
- When you need a constant value that doesn't change across instances (typically in combination with final).
### 9. What is the differences between overriding and overloading?
- Overloading: Same method name, different parameters (compile-time).  
- Overriding: Same signature. Subclass method replaces superclass method (runtime).  
### 10. What is the differences between super and this?
- this: Refers to the current class object.  
- super: Refers to the immediate superclass.
### 11. What is the Java load sequence?
1. Static members: Loaded and initialized first.  
2. Instance members: Initialized during object creation.  
3. Constructors: Executed after instance initialization.  
### 12. What is Polymorphism ? And how Java implements it ?
Polymorphism allows a single interface to represent multiple types.
- Compile-time: Method **overloading**.
- Runtime: Method **overriding** via inheritance.
### 13. What is Encapsulation ? How Java implements it? And why we need encapsulation?
Encapsulation: where the internal details of an object are hidden from the outside world. It allows an object to control its own data and provide controlled access through methods, typically using **getters** and **setters**.  

How Java Implements Encapsulation:  
- Private Variables: Data members of a class are made private, which prevents direct access from outside the class.
- Public Methods: Accessor (getter) and mutator (setter) methods are provided to read and update the private variables, offering controlled access.

Why Encapsulation is Needed:
- Data Protection: Encapsulation helps protect an object's state by preventing unauthorized access or modification.  
- Flexibility and Maintainability: Changes to the internal implementation of a class can be made without affecting other parts of the program, as long as the external interface remains the same.
- Control over Data: Through setters and getters, we can add logic for validation, logging, or other checks before modifying the state of an object.
### 14. What is Interface and what is abstract class? What are the differences between them?
Interface:  
An interface in Java is a contract that defines a set of methods without implementation. Any class that implements an interface must provide implementations for all its methods. Interfaces can be used to represent common behavior that can be shared across different classes.

Abstract Class:  
An abstract class in Java is a class that cannot be instantiated directly. It can have both abstract methods (without implementation) and concrete methods (with implementation). Abstract classes are used to represent common characteristics for a group of related classes.

Differences:  
- Method Implementation: Interfaces have no implementation, while abstract classes can have partial implementations.
- Inheritance: A class can implement multiple interfaces but can inherit only one abstract class.
- Constructor: Interfaces do not have constructors, while abstract classes can have constructors.
### 15. Design a parking lot (put the code to codingQuestions/coding1 folder, ) If you have no ability to design it, please find the solution in internet, then understand it, and re-type it.(Do NOT just copy and paste)
Please refer to repo/Coding/ParkingLot
### 16. What are Queue interface implementations and what are the differences and when to use what?
Queue Interface Implementations:  
1. LinkedList:  
- Implements both Queue and Deque interfaces.
- Provides FIFO (First-In-First-Out) order.
- Allows adding/removing elements from both ends (head and tail).
- Use when: You need a flexible queue that supports operations at both ends (e.g., dequeuing from front and adding to the back).
2. PriorityQueue:  
- Implements Queue and orders elements based on their natural ordering or a custom comparator.
- Not FIFO, but rather based on priority.
- Use when: You need elements to be processed based on priority (e.g., priority scheduling in tasks).
3. ArrayDeque:
- Implements Deque and Queue.
- Supports adding/removing elements from both ends with better performance than LinkedList in most cases.
- Use when: You need a queue with fast access to both ends and don't require random access like a list.
