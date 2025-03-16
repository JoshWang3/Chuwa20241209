# Homework 2
## 1. Write up Example code to demonstrate the three foundmental concepts of OOP. (reference Code Demo repo as example)
- ### **Encapsulation：**
```
public class EncapsulationDemo {
    public static class EncapTest {
        private String name;
        private String idNum;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIdNum() {
            return idNum;
        }

        public void setIdNum(String idNum) {
            this.idNum = idNum;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    public static void main(String[] args) {
        EncapTest encap = new EncapTest();

        encap.setName("James");
        encap.setAge(20);
        encap.setIdNum("12343ms");

        System.out.println("Name : " + encap.getName() + " Age : " + encap.getAge());
    }
}
```
- **Polymorphism：**
```
class Animal {
    public void move(){
        System.out.println("Animals move.");
    }
}

class Cat extends Animal{
    @Override
    public void move(){
        System.out.println("Cats run.");
    }
}

class Bird extends Animal{
    @Override
    public void move(){
        System.out.println("Birds fly.");
    }
}

public class PolymorphismDemo{
    public static void main(String[] args) {
        Animal animal;
        
        animal = new Cat();
        animal.move();
        
        animal = new Bird();
        animal.move();
    }
}
```
- **Inheritance：**
```
class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public void move(){
        System.out.println(name + "is moving.");
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    public void sound() {
        System.out.println("miao miao miao");
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        Cat cat = new Cat("Ketty");
        cat.move();
        cat.sound();
    }
}
```

## 2. What is wrapper class in Java and Why we need wrapper class?
- **What is wrapper class:**
    - A Wrapper Class is a class that wraps a primitive data type into an object. Each primitive type has a corresponding wrapper class.
- **Why we need wrapper class:**
    - **Collections Framework:** 
        - Collections like ArrayList, HashMap, etc., can only store objects, not primitive types.
    - **Autoboxing and Unboxing:** 
        - Java automatically converts between primitives and wrapper classes.
    - **Utility Methods:** 
        - Wrapper classes provide useful methods to perform operations (e.g., parsing, comparisons).
    - **Null Representation:** 
        - Wrapper classes can represent null, but primitive types cannot.

## 3. What is the difference between HashMap and HashTable?
- **Thread-Safety:** 
    - HashMap is not synchronized, but Hashtable is thread-safe.
- **Null Values:** 
    - HashMap allows one null key and multiple null values; Hashtable does not allow null at all.
- **Performance:** 
    - HashMap is faster because it doesn’t have synchronization overhead.
- **Legacy:** 
    - Hashtable is legacy code, while HashMap is modern and preferred in new applications. Use ConcurrentHashMap instead of Hashtable for thread-safe environments, as it is more efficient.

## 4. What is String pool in Java and why we need String pool?
- **What is String Pool:**
    - The String Pool in Java is a special memory region in the Heap where String literals are stored. When you create a String literal, Java checks the String Pool to see if it already exists. If it exists, the reference to the existing String is returned. If it doesn’t exist, a new String object is created in the pool.
- **Why Do We Need the String Pool?**
    - **Memory Efficiency:** As strings are immutable in Java, by reusing existing strings from the pool, we avoid creating duplicate objects and save memory. String literals like "example" are reused wherever possible, ensuring no redundant objects.
    - **Performance Optimization:** Comparing Strings using == is faster because it checks references instead of content when they come from the pool.

## 5. What is Java garbage collection?
- **What is Java garbage collection:** 
    - Java Garbage Collection (GC) is a process that automatically manages memory by reclaiming unused objects to free up heap space. It ensures that objects no longer in use are removed, preventing memory leaks and improving application efficiency.

- **Why Do We Need Garbage Collection:** 
    - **Automatic Memory Management:** Reduces developer effort to manage memory.
    - **Prevents Memory Leaks:** Removes unused objects, freeing up memory.
    - **Improves Application Performance:** Ensures efficient memory usage.

- **Key Points:**
    - **Automatic Memory Management:** The JVM takes care of memory management using GC.
    - **Working Mechanism** The GC identifies objects that are no longer reachable or referenced by the program and deletes them.
    - **Garbage Collection Process:** GC primarily works in the heap memory, where objects are created. It runs periodically to clean up unused objects.

## 6. What are access modifiers and their scopes in Java?
- **What are access modifiers:**
    - Access Modifiers are keywords used to control the visibility of classes, methods, variables, and constructors. They determine how other classes can access a member.
- **Scopes:**
    - **public:** Accessible from anywhere (Class, Method, Field, Constructor).
    - **protected:** Accessible within the same package and by subclasses even in different packages (Method, Field, Constructor).
    - **(default):** Accessible within the same package only (Class, Method, Field, Constructor). 
    - **private:** Accessible only within the same class (Method, Field, Constructor).

## 7. What is final key word? (Filed, Method, Class)
- **final with Fields:** (Cannot be reassigned) When a field is declared as final, it cannot be reassigned once initialized. For primitive types, the value cannot change. For reference types, the reference cannot change, but the object’s content can be modified. 
- **Blank Final Variables:** Final variables can be initialized in the constructor.
- **final with Methods:** (Cannot be overridden) When a method is declared as final, it cannot be overridden by subclasses.
- **final with Classes:** (Cannot be inherited) When a class is declared as final, it cannot be inherited.

- **Why Use the final Keyword:**
    - **With Fields:** 
        - To create constants (ensure immutability).
    - **With Methods:**
        - To prevent overriding critical methods, ensuring consistent behavior.
    - **With Classes:**
        - To prevent inheritance where subclassing may compromise security or logic.

## 8. What is static keyword? (Filed, Method, Class). When do we usually use it?
- **What is static keyword:** 
    - The static keyword is a modifier used to indicate that a member (field, method, or nested class) belongs to the class rather than to any specific instance. It allows shared behavior or data across all instances of the class.
- **static with Fields:** 
    - When a field is declared as static, it is shared by all instances of the class. There is only one copy of the field, regardless of how many objects are created. We use static final when sharing data like configurations, counters, and constants.
- **static with Methods:** 
    - A static method belongs to the class and can be called without creating an instance. It cannot access non-static members directly. It can call only other static methods or access static fields and cannot use the this or super keyword. We use it to create utility methods, such as Math.max(), or helper functions that do not depend on instance data.
- **static with Classes:**
    - A static class is a nested class that is independent of the outer class instance. It is used to logically group related operations or data. It is used to encapsulate related logic that is independent of the enclosing class's instance.

## 9. What is the differences between overriding and overloading?
|**Aspect**             |**Overriding**                                                                                 |**Overloading**                                                                                |
|-----------------------|-----------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------|
|**Definition**         |A subclass provides a specific implementation of a method defined in its superclass.           | Methods in the same class (or subclass) have the **same name** but **different parameters**.  |
|**Class Relationship** |Happens between **parent and child classes** (inheritance).                                    |Happens **within the same class** (or subclass).                                               |
|**Method Signature**   |Must have the **same method name, return type, and parameters**.                               |Must have the **same method name** but **different parameter lists** (number, type, or order). |
|**Behavior**           |Provides a **specific implementation** of a method to modify its behavior in a subclass.       |Adds **flexibility** to the same method name by allowing different parameter variations.       |
|**Access Modifiers**   |Cannot reduce visibility of the overridden method (e.g., `public` cannot become `protected`).  |No restriction on access modifiers for overloaded methods.                                     |
|**Return Type**        | Must be the **same** or a **covariant type**.                                                 | Can have **different return types**.                                                          |
|**Static Methods**     | Cannot override static methods (`hides` instead).                                             | Can overload static methods.                                                                  |
|**When Resolved**      | Determined at **runtime** (dynamic binding).                                                  |Determined at **compile-time** (static binding).                                               |

## 10. What is the differences between super and this?
- **this:** Refers to the current class instance and is used for accessing current class variables, methods, and constructors.
- **super:** Refers to the parent class instance and is used for accessing parent class variables, methods, and constructors.

## 11. What is the Java load sequence?
**Class → Static → Instance → Constructor**
- **C - Class Loading:**
  - The class is loaded by the ClassLoader when it's first referenced.
  - Static members and blocks are prepared but not yet initialized.
- **S - Static Initialization:**
  - Static variables and static blocks are initialized in the order they appear.
  - Happens only once, when the class is loaded.
- **I - Instance Initialization:**
  - Instance variables and instance initializer blocks are initialized in the order they appear.
  - Happens every time an object is created.
- **C - Constructor Execution:**
  - After the instance initialization, the constructor of the class is executed.
  - The parent class constructor is called first, followed by the current class constructor.

## 12. What is Polymorphism? And how Java implements it?
- **What is Polymorphism:**
  - Polymorphism means "one name, many forms." It allows one method or object to act differently based on the context.
- **how Java implements it:**
  - **Overloading (Decided at compile time):**
    - Same method name, but different parameters.
  - **Overriding (Decided at runtime):**
    - A subclass provides a specific implementation of a method defined in its superclass.
- **Why Do We Need Polymorphism:**
  - Polymorphism is essential in OOP because it enables flexibility, code reusability, and scalability.

## 13. What is Encapsulation? How Java implements it? And why we need encapsulation?
- **What is Encapsulation:**
  - Encapsulation is the process of bundling fields and methods into a single unit, typically a class. It restricts direct access to the data and ensures that it can only be accessed or modified through well-defined methods.
- **How Java implements it:**
  - Java uses access modifiers (private, protected, public, and default) to control access to class fields and methods.
- **Why we need encapsulation:**
  - **Data Hiding:**
    - Prevents unauthorized access to sensitive fields.
  - **Improved Code Maintainability:**
    - If internal logic changes, it doesn’t affect external code as long as the getter/setter interface remains consistent.
  - **Loose Coupling:**
    - Encapsulation reduces dependency by exposing only the necessary details and hiding the implementation details.

## 14. What is Interface and what is abstract class? What are the differences between them?
- **What is an Interface:**
  - An interface is a blueprint for a class that defines a set of methods that the class must implement. It contains only method declarations (before Java 8) or default/static methods (from Java 8 onwards). Fields in an interface are implicitly public, static, and final.
- **What is abstract class:**
  - An abstract class is a class that cannot be instantiated and is designed to be extended by subclasses. It can have abstract methods (without implementation) and non-abstract methods (with implementation). It can also have fields with any access modifier (private, protected, public).
- **What are the differences between them:**

| **Feature**               | **Interface**                                                                         |**Abstract Class**                                                            |
|---------------------------|---------------------------------------------------------------------------------------|------------------------------------------------------------------------------|
| **Definition**            | A blueprint specifying what a class must do.                                          | A partially implemented class meant to be extended.                          |
| **Methods**               | Only abstract methods (until Java 7); default/static methods (from Java 8 onwards).   | Can have both abstract and concrete methods.                                 |
| **Fields**                | Only `public static final` (constants).                                               | Can have instance variables with any access modifier.                        |
| **Multiple Inheritance**  | A class can implement multiple interfaces.                                            | A class can inherit only one abstract class.                                 |
| **Constructors**          | Interfaces do not have constructors.                                                  | Abstract classes can have constructors (to initialize fields).               |
| **Default Implementation**| Default methods allowed from Java 8.                                                  | Can have non-abstract methods by default.                                    |
| **Use Case**              | Use for defining behavior that multiple classes should implement.                     | Use for shared code and inheritance in related classes.                      |

## 16. What are Queue interface implementations and what are the differences and when to use what?
| **Implementation**            | **Behavior**                                                                  | **Thread-Safe**  | **Allows Null?** | **When to Use**                                                                                 |
|-------------------------------|-------------------------------------------------------------------------------|------------------|------------------|-------------------------------------------------------------------------------------------------|
| **PriorityQueue**             | Orders elements based on natural ordering or custom comparator.               | No               | No               | When elements need to be processed based on priority, not insertion order.                      |
| **LinkedList**                | Standard FIFO queue, also supports `Deque`.                                   | No               | Yes              | For simple, standard FIFO queue behavior.                                                       |
| **ArrayDeque**                | Faster double-ended queue (FIFO or LIFO) operations.                          | No               | No               | When you need a high-performance queue or stack replacement.                                    |
| **ConcurrentLinkedQueue**     | Thread-safe, non-blocking queue using CAS operations.                         | Yes              | No               | For thread-safe, high-performance queues in multi-threaded environments.                        |
| **ArrayBlockingQueue**        | Fixed-size blocking queue.                                                    | Yes              | No               | For producer-consumer patterns with bounded capacity (blocks when full or empty).               |
| **LinkedBlockingQueue**       | Optionally bounded blocking queue.                                            | Yes              | No               | For producer-consumer scenarios needing an optionally bounded, thread-safe queue.               |
| **PriorityBlockingQueue**     | Thread-safe version of `PriorityQueue`.                                       | Yes              | No               | When elements need priority processing in a multi-threaded environment.                         |
| **DelayQueue**                | Processes elements after a delay; elements must implement `Delayed`.          | Yes              | No               | When elements need to be processed only after a specific delay (e.g., scheduled tasks).         |






























