## 1. Write up Example code to demonstrate the three foundmental concepts of OOP. (reference Code Demo repo as example)
 ### 1. Encapsulation; 
```
public class person {
    private String name;
    private int age;
    
    public person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setAge(int age) {
        if (age > 0) {
            return age;
        } else {
            throw new IllegalArgumentException("Age must above 0!");
        }
    }
    
    public int getAge() {
        return age;
    }
}
```


 ### 2. Polymorphism; 
```
public class animal {
    public void eat() {
        System.out.printIn("Animal is eating");
    }
}

public class dog extends animal {
    public boid bark() {
        System.out.printIn("Dog is Barking!");
    }
}
```

 ### 3. Inheritance;  
```
public class Animal {
    public void makeSound() {
        System.out.println("Animal's sound");
    }
}

public class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof Woof");
    }
}

```

## 2. What is wrapper class in Java and Why we need wrapper class? 
- Wrapper classes in Java are classes that encapsulate (wrap) primitive data types into objects. Each primitive type has a corresponding wrapper class:
```
int → Integer
double → Double 
char → Character
boolean → Boolean
long → Long
float → Float
short → Short
byte → Byte
```
- *Object Manipulation:*  
Collections like ArrayList cannot store primitive types directly. Wrapper classes allow primitives to be stored as objects.
- *Utility Methods:*  
Wrapper classes provide useful methods for converting and manipulating data, such as parsing strings to numbers.
- *Generics Support:*  
Java Generics work with objects, not primitives. Wrapper classes enable the use of generics with primitive data types.
- *Nullability:*
Unlike primitive types, wrapper objects can be null, which is useful in certain scenarios like database operations where a value might be missing.
## 3. What is the difference between HashMap and HashTable?
| Feature               | HashMap                        | Hashtable                        |
|-----------------------|--------------------------------|----------------------------------|
| **Synchronization**   | Not synchronized (`non-thread-safe`) | Synchronized (`thread-safe`)   |
| **Null Keys and Values** | Allows one `null` key and multiple `null` values | Does **not** allow `null` keys or values |
| **Performance**       | Generally faster               | Slower due to synchronization overhead |
| **Legacy**            | Part of Java Collections Framework | Legacy class (pre-Java 1.2)     |
| **Iterator**          | Fail-fast iterators (`Iterator`) | Legacy enumerators (`Enumeration`) |
| **Subclasses**        | Can be extended (`LinkedHashMap`) | Rarely extended; no commonly used subclasses |
| **Thread Safety**     | Not thread-safe; requires external synchronization | Thread-safe by default           |
| **Use Cases**         | Single-threaded or manually synchronized multi-threaded environments | Generally not recommended; use `ConcurrentHashMap` instead |

## 4. What is String pool in Java and why we need String pool? 
- The String Pool is a special memory region in the Java Virtual Machine (JVM) that stores String literals. It is designed to optimize memory usage by reusing immutable String objects.
- **Why Do We Need the String Pool?**  
  - *Memory Efficiency:*  
  *Avoiding Redundancy:* By reusing String literals, the JVM prevents the creation of multiple identical String objects, thereby saving memory.
  Performance Optimization:  
  - *Faster Comparisons:*  
  Since identical String literals reference the same object in the pool, comparing them using == is faster as it compares memory addresses instead of actual content.
  Thread Safety:  
  - *Immutable Objects:*   
  String objects in the pool are inherently thread-safe due to their immutability, allowing safe sharing across multiple threads without synchronization.

## 5. What is Java garbage collection?
- **Garbage Collection** is the process by which the JVM automatically identifies and disposes of objects that are no longer needed by a program, freeing up memory resources. This automatic memory management eliminates the need for developers to manually release memory, reducing the risk of memory leaks and other related issues.
## 6. What are access modifiers and their scopes in Java? 
- Access modifiers in Java are keywords that determine the visibility and accessibility of classes, methods, and variables. They play a crucial role in implementing encapsulation, one of the core principles of Object-Oriented Programming (OOP).
- Java provides four primary access modifiers:
  - private
  - default (no explicit modifier)
  - protected
  - public
## 7. What is final key word? (Filed, Method, Class)
The **final** keyword is used to indicate that a variable, method, or class cannot be modified or extended.
- final variable -> to create constant variable
- final methods -> prevent method override
- final -> prevent inheritance
## 8. What is static keyword? (Filed, Method, Class). When do we usually use it?
The **static** keyword is used to share the same variable or method of a given class.

- A static method belongs to the class rather than the object of a class.
- A static method can be invoked without the need for creating an instance of a class.
- A static method can access static data members and can change their value of it.
## 9. What is the differences between overriding and overloading?
| **Feature**                                        | **Method Overloading**                                                                 | **Method Overriding**                                                                           |
|----------------------------------------------------|----------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------|
| **Binding Time**                                   | Happens at **compile time**                                                           | Happens at **runtime**                                                                           |
| **Performance**                                    | **Better performance** because binding is done at compile time                        | **Less performance** because binding is done at runtime                                         |
| **Method Accessibility**                           | `private` and `final` methods **can be overloaded**                                  | `private` and `final` methods **cannot be overridden**                                         |
| **Return Type**                                    | **Does not matter**                                                                    | **Must be the same** as the method in the superclass                                            |
| **Arguments**                                      | **Must be different** (different method signatures)                                   | **Must be the same** (same method signatures)                                                   |
| **Classes Involved**                               | **Same class**                                                                        | **Different classes**: Requires base and derived (child) classes                               |
| **Purpose**                                        | **Increase readability** of the code                                                   | **Provide specific implementation** of a method already defined in the base class               |
| **Inheritance Requirement**                        | **Not required**                                                                       | **Required**: Must be in a subclass                                                            |
| **Usage Scenario**                                 | When methods perform similar functions with different parameters                        | When a subclass needs to provide a specific implementation of a method defined in the superclass|
## 10. What is the differences between super and this?
| **Feature**         | **`this`**                                 | **`super`**                               |
|---------------------|--------------------------------------------|--------------------------------------------|
| **Reference**       | Current object instance                    | Superclass of the current object           |
| **Purpose**         | Access members of the current class        | Access members of the superclass           |
| **Constructor Call**| `this()` calls a constructor in the same class | `super()` calls the superclass constructor |
## 11. What is the Java load sequence?
| **Phase**        | **Description**                                                                 |
|------------------|---------------------------------------------------------------------------------|
| **Loading**      | The Class Loader reads the `.class` file and loads its binary data into the JVM. |
| **Linking**      | Prepares the class for use by verifying, preparing, and resolving references.    |
| **Initialization** | Initializes static variables and executes static blocks to set up the class for execution. |
## 12. What is Polymorphism ? And how Java implements it ? 
- **Polymorphism** allows objects to take multiple forms, enhancing flexibility and integration in Java programs.
- **Compile-Time Polymorphism** is achieved through method **overloading**, where multiple methods share the same name but differ in parameters.
- **Runtime Polymorphism** is achieved through method **overriding**, where a subclass provides a specific implementation of a method defined in its superclass.
## 13. What is Encapsulation ? How Java implements it? And why we need encapsulation? 
- Encapsulation is that bundles data and the methods that operate on that data into a class, while restricting direct access to some of the object's components.
- In Java, private fields combined with **public getter and setter methods** are the primary means of implementing encapsulation.
- Encapsulation is essential for building **robust**, **maintainable**, and **secure** Java applications.
## 14. What is Interface and what is abstract class? What are the differences between them?

| **Feature**              | **Abstract Class**                                                                                             | **Interface**                                                                                          |
|--------------------------|----------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------|
| **Definition**           | Cannot be instantiated; contains both abstract (without implementation) and concrete methods (with implementation) | Specifies a set of methods a class must implement; methods are abstract by default.                     |
| **Implementation Method**| Can have both implemented and abstract methods.                                                                 | Methods are abstract by default; Java 8 can have default and static methods.                           |
| **Inheritance**          | A class can inherit from only one abstract class.                                                               | A class can implement multiple interfaces.                                                            |
| **Access Modifiers**     | Methods and properties can have any access modifier (public, protected, private).                               | Methods and properties are implicitly public.                                                          |
| **Variables**            | Can have member variables (final, non-final, static, non-static).                                              | Variables are implicitly public, static, and final (constants).                                        |
## 15. design a parking lot (put the code to codingQuestions/coding1 folder, )
### 1. If you have no ability to design it, please find the solution in internet, then understand it, and re-typeit.(Do NOT just copy and paste)

###16. What are Queue interface implementations and what are the differences and when to use what?
| **Queue Implementation** | **Description & When to Use**                                                                                   |
|--------------------------|------------------------------------------------------------------------------------------------------------------|
| **LinkedList**           | Implements a doubly-linked list supporting FIFO operations, ideal for general-purpose queues with frequent insertions and deletions. |
| **PriorityQueue**        | Orders elements based on priority rather than insertion order, suitable for scenarios where higher priority elements need to be processed first. |
| **ArrayDeque**           | Provides a resizable-array implementation for efficient FIFO and LIFO operations, best used for high-performance stack and queue operations. |