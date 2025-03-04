# Homework 2
## Questions
### 1.Write up Example code to demonstrate the three foundmental concepts of OOP. (reference Code Demo repo as example)
#### 1. Encapsulation;
#### 2. Polymorphism;
#### 3. Inheritance;

### 2. What is wrapper class in Java and Why we need wrapper class?
In Java, wrapper classes are special classes that wrap a primitive data type within them so that they are compatible to use with other API like Collections. Java provides two mechanisms called "autoboxing" and "auto-unboxing" which take care of automatic creation of the correct wrapper object and vice versa.

### 3. What is the difference between HashMap and HashTable?
HashMap and HashTable differ mainly in how they handle synchronization and thread safety. 
- HashTable is synchronized while HashMap is not.
- HashTable is obsolete in Java 1.7 and does not allow null keys or values.
- HashMap does not guarantee the order of the map.

### 4. What is String pool in Java and why we need String pool?

String Pool in java is the speical memory region where strings are stored by the JVM to optimize memory allocations for String objects due to their immutability by storing only one copy of each literal.

### 5. What is Java garbage collection?

Garbage collection is the automated process of deleting code that is no longer needed or used by making sure that objects that are not referenced will be freed from memory. To determine which objects are no longer in use, the JVM intermittently aptly runs a process called "mark-and-sweep" algorithm.


### 6. What are access modifiers and their scopes in Java?

In Java, there are four access modifiers: "public", "protected", "private", and "default" which is package-private.

- "public" modifiers can be accessible from anywhere within the project.
_ "protected" modifiers can be accessible within the same package, by subclasses in any package, and within the class itself.
- "private" modifiers can only be accessible withing the same class.
- "default" modifiers are only accessbile within the same package and no explicit keyword is used.

### 7. What is final key word? (Filed, Method, Class)

The "final" keyword is a non-access modifier used for fields, methods and classes in order to make them non-changeable. It is primarily used when we want to assign a variable to always store the same value such as PI.

### 8. What is static keyword? (Filed, Method, Class). When do we usually use it?

The "static" keyword is a non-access modifier used for fields, methods and classes to signify that the member belong to the class itself, rather than to any instance of the class. It is mainly used when we need a variable that is shared across all instances of a class or for methods that don't require access to instance-specific data.

### 9. What is the differences between overriding and overloading?

- Method overriding is when a child class redefines the same method as a parent class with the same parameters. It happens at compile time.
- Method overloading is defining several methods in the same class, that accept different numbers and types of parameters. It happens at runtime.

### 10. What is the differences between super and this?

In Java, "this" and "super" are keywords that are used to reference different objects within a class hierarchy. 
- "this" keywords refers to the currenct object instance and it can be used to access the instance variables and methods of the current class.
- "super" keyword refers to the parent class of the current object and it is used to access the instance variables and methods of the parent class. 

### 11. What is the Java load sequence?

The Java load sequence is "loading", "linking", and "initializing". Class loaders are responsible for loading Java classes dynamically to the JVM.

### 12. What is Polymorphism? And how Java implements it ?

"Polymorphism" means "many forms", a concept that allows objects of different classes to be treated as objects of a common superclass.

Java implments polymorphism via two main mechanisms called "method overrriding" which is compile-time dependent and "method overloading" which happens at run-time.

### 13. What is Encapsulation? How Java implements it? And why we need encapsulation?

Encapsulation is a way of hiding the implementation details of a class from outside access and only exposing a public interface that can be used to interact with the class.

It can be implemented simply by declaring the instance variables or methods of a class with "private" access modifier keyword. 

They are primarily used to control limited access to the data and prevent unauthorized modifications.

### 14. What is Interface and what is abstract class? What are the differences between them?

- Interface is a blueprint for a class that defines a set of methods that a class must implment and it contains only method signatures without concrete implementation and constants. Inteface cannot be instantiated.

- An abstract class can contain both abstract methods and concrete methods, and can have member variables. In Java, class can only extend one abstract class.

### 15. design a parking lot (put the code to codingQuestions/coding1 folder,)
#### 1. If you have no ability to design it, please find the solution in internet, then understand it, and re-type it.(Do NOT just copy and paste)


### 16. What are Queue interface implementations and what are the differences and when to use what?

The Queue interface is a subtype of the Collection interface and represents a collection of elements in a specific order. The most common Queue implementations are LinkedList, ArrayDeque, and PriorityQueue.

These implemenation are primarily differ in performance, functionality and implmentation.

For large queues, ArrayDeque generally offers faster performance for add/remove operations than LinkedList. Implmentation-wise, LinkedList uses a linked list data structure, ArrayDeque uses a resizable array, and PriorityQueue uses a heap data structure
