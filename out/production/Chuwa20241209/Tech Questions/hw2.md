## Short Questions

### Write up Example code to demonstrate the three foundmental concepts of OOP. (reference Code Demo repo as example)
Please refer to the Coding Repository for the Encapsulation, Polymorphism, and Inheritance classes.

### What is wrapper class in Java and Why we need wrapper class?
**Wrapper classes** convert primitive data type into objects.
Wrapper classes are needed for the following reasons
- Wrapper classes can work with Collections objects, such as ArrayList, where primitive types cannot be used.
- Since primitive data types can't be given a null value.
### What is the difference between HashMap and HashTable?
- HashMap is **not thread-safe**, but HashTable is **thread-safe**
- HashMap allows **one null key and multiple null values** HashTable does not allow **null key or null value**.
- HashMap is **fast**. Hashtable is **slow**.

### What is String pool in Java and why we need String pool?
String pool is a **storage area** in the Java Heap where string literals store.

It helps to **save memory** by avoiding the creation of unnecessary string objects, because JVM can return a reference to an existing string object.

### What is Java garbage collection?
Garbage collection in Java is the automated process of deleting code that’s no longer needed or used. 
This automatically frees up memory space and ideally makes coding Java apps easier for developers. 

### What are access modifiers and their scopes in Java?
**Access modifiers** determine the accessibility or scope of classes, methods and variables.

- **_Private_**: Accessible only in the same class.

- **_Default_**: Accessible only in the same class and same package.

- **_Protected_**: Accessible only in the same class, same package and subclasses.

- **_Public_**: Can be accessed from anywhere in the program.

### What is final key word? (Filed, Method, Class)
The **final** keyword is used to indicate that a variable, method, or class cannot be modified or extended.
- final variable -> to create constant variable
- final methods -> prevent method override
- final -> prevent inheritance

### What is static keyword? (Filed, Method, Class). When do we usually use it?
The **static** keyword is used to share the same variable or method of a given class.

- A static method belongs to the class rather than the object of a class.
- A static method can be invoked without the need for creating an instance of a class.
- A static method can access static data members and can change their value of it.
  
There are the following two main restrictions for the static method.
- The static method cannot use non-static data members or call a non-static method directly.
- this and super keyword cannot be used in static context.

### What is the differences between overriding and overloading?
- override implements **runtime** polymorphism, overload implements **compile time** polymorphism
- override occurs between **superclass and subclass**, overload occurs between methods in the **same class**
- override has the **same signature**(name and method arguments)， overload has the same name, but the parameters are **different**

### What is the differences between super and this?
- **_super_** is used to call parent class's constructor
- **_this_** is used to call current class's constructor

### What is the Java load sequence?
- **Class loading**: loads the class files into memory
- **Static Block Execution**: Any static blocks in the class are executed.
- **Static Variable Initialization**: Static variables are initialized in the order they are declared.
- **Constructor Execution**: The constructor of the class is executed.

### What is Polymorphism ? And how Java implements it ?
Polymorphism is that we can perform a single action in different ways.

- **Method Overload**: Define multiple methods within the same name but different parameters within the same class.

- **Method Override**: Allow subclasses to provide specific implementations of methods defined in their superclass

### What is Encapsulation ? How Java implements it? And why we need encapsulation?
Encapsulation is that bundles data and the methods that operate on that data into a class, while restricting direct access to some of the obkect's components.

See the coding example.

- We can prevent direct access to data members. 
- We can change internal implementation without affecting other code.

### What is Interface and what is abstract class? What are the differences between them?
**Interface**: Interface specifies what a class must do and not how. It is the blueprint of the class.

**Abstract**: Abstract classes are classes with a generic concept, not related to a specific class.

**Differences**:
- abstract: subclasses **extends** abstract class, interface: subclasses **implements** interfaces 
- abstract **doesn't support multiple inheritance**, interface supports multiple inheritance
- abstract **can** have constructors, interface **cannot** have constructors

### Design a parking lot

### What are Queue interface implementations and what are the differences and when to use what?
The Queue interface is present in jva.util package and extends the Collection interface is used to hold the elements about to be processed in FIFO order.
```angular2html
public interface Queue extends Collection
```

1. **PriorityQueue(class)**
- Doesn't allow null elements
- Data structure: Binary heap

    When to use: Ordered processing
2. **LinkedList(class)**
- Allowed null elements
- Data structure: Doubly-linked list

  When to use: Add/remove from both ends
3. **ArrayQueue(class)**
- Doesn't allow null elements
- Data structure: Resizable circular array

  When to use: Best performance needs