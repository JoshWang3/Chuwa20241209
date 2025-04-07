## 1. Write up Example code to demonstrate the three foundmental concepts of OOP. (reference Code Demo repo as example)

### 1. Encapsulation;

```
public class BankAccount {
    private String owner;
    private double balance;

    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}


// Example usage:
public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Alice", 100.0);
        account.deposit(50.0);
        account.withdraw(30.0);
        System.out.println("Balance: " + account.getBalance()); // Output: 120.0
    }
}

```

### 2. Polymorphism;

```
class Animal {
    public void speak() {
        System.out.println("Animal speaks");
    }
}

class Dog extends Animal {
    @Override
    public void speak() {
        System.out.println("Woof!");
    }
}

class Cat extends Animal {
    @Override
    public void speak() {
        System.out.println("Meow!");
    }
}

// Example usage:
public class Main {
    public static void main(String[] args) {
        Animal a1 = new Dog();
        Animal a2 = new Cat();

        a1.speak(); // Output: Woof!
        a2.speak(); // Output: Meow!
    }
}

```

### 3. Inheritance;

```
class Vehicle {
    protected String brand;

    public Vehicle(String brand) {
        this.brand = brand;
    }

    public void startEngine() {
        System.out.println(brand + " engine started.");
    }
}

class Car extends Vehicle {
    private int doors;

    public Car(String brand, int doors) {
        super(brand);
        this.doors = doors;
    }

    public void showDetails() {
        System.out.println(brand + " car with " + doors + " doors.");
    }
}

// Example usage:
public class Main {
    public static void main(String[] args) {
        Car myCar = new Car("Toyota", 4);
        myCar.startEngine();   // Output: Toyota engine started.
        myCar.showDetails();   // Output: Toyota car with 4 doors.
    }
}


```

## 2. What is wrapper class in Java and Why we need wrapper class?

- In Java, a **wrapper class** is an object representation of a primitive data type. Each primitive type has a corresponding wrapper class:

```
| Primitive Type | Wrapper Class  |
|----------------|----------------|
| `int`          | `Integer`      |
| `double`       | `Double`       |
| `char`         | `Character`    |
| `boolean`      | `Boolean`      |
| `long`         | `Long`         |
| `float`        | `Float`        |
| `short`        | `Short`        |
| `byte`         | `Byte`         |
```

- _Generics Support:_  
  Java Generics work only with objects, not primitives. Wrapper classes enable the use of generics with primitive values.
- _Utility Methods:_  
  Wrapper classes offer built-in methods that are useful for converting and manipulating data.
- _Generics Support:_  
  Java Generics work only with objects, not primitives. Wrapper classes enable the use of generics with primitive values.
- _Nullability:_
  Primitive types cannot hold null values, but wrapper objects can. This is useful in scenarios like database operations where a value might be missing or unknown.

## 3. What is the difference between HashMap and HashTable?

| Feature                  | HashMap                                                              | Hashtable                                                  |
| ------------------------ | -------------------------------------------------------------------- | ---------------------------------------------------------- |
| **Synchronization**      | Not synchronized (`non-thread-safe`)                                 | Synchronized (`thread-safe`)                               |
| **Null Keys and Values** | Allows one `null` key and multiple `null` values                     | Does **not** allow `null` keys or values                   |
| **Performance**          | Generally faster                                                     | Slower due to synchronization overhead                     |
| **Legacy**               | Part of Java Collections Framework                                   | Legacy class (pre-Java 1.2)                                |
| **Iterator**             | Fail-fast iterators (`Iterator`)                                     | Legacy enumerators (`Enumeration`)                         |
| **Subclasses**           | Can be extended (`LinkedHashMap`)                                    | Rarely extended; no commonly used subclasses               |
| **Thread Safety**        | Not thread-safe; requires external synchronization                   | Thread-safe by default                                     |
| **Use Cases**            | Single-threaded or manually synchronized multi-threaded environments | Generally not recommended; use `ConcurrentHashMap` instead |

## 4. What is String pool in Java and why we need String pool?

- The String Pool is a special memory region in the Java Virtual Machine (JVM) that stores String literals. It is designed to optimize memory usage by reusing immutable String objects.
- **Why Do We Need the String Pool?**
  - _Memory Efficiency:_  
    _Avoiding Redundancy:_ By reusing String literals, the JVM prevents the creation of multiple identical String objects, thereby saving memory.
    Performance Optimization:
  - _Faster Comparisons:_  
    Since identical String literals reference the same object in the pool, comparing them using == is faster as it compares memory addresses instead of actual content.
    Thread Safety:
  - _Immutable Objects:_  
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

| **Feature**                 | **Method Overloading**                                           | **Method Overriding**                                                                            |
| --------------------------- | ---------------------------------------------------------------- | ------------------------------------------------------------------------------------------------ |
| **Binding Time**            | Happens at **compile time**                                      | Happens at **runtime**                                                                           |
| **Performance**             | **Better performance** because binding is done at compile time   | **Less performance** because binding is done at runtime                                          |
| **Method Accessibility**    | `private` and `final` methods **can be overloaded**              | `private` and `final` methods **cannot be overridden**                                           |
| **Return Type**             | **Does not matter**                                              | **Must be the same** as the method in the superclass                                             |
| **Arguments**               | **Must be different** (different method signatures)              | **Must be the same** (same method signatures)                                                    |
| **Classes Involved**        | **Same class**                                                   | **Different classes**: Requires base and derived (child) classes                                 |
| **Purpose**                 | **Increase readability** of the code                             | **Provide specific implementation** of a method already defined in the base class                |
| **Inheritance Requirement** | **Not required**                                                 | **Required**: Must be in a subclass                                                              |
| **Usage Scenario**          | When methods perform similar functions with different parameters | When a subclass needs to provide a specific implementation of a method defined in the superclass |

## 10. What is the differences between super and this?

| **Feature**          | **`this`**                                     | **`super`**                                |
| -------------------- | ---------------------------------------------- | ------------------------------------------ |
| **Reference**        | Current object instance                        | Superclass of the current object           |
| **Purpose**          | Access members of the current class            | Access members of the superclass           |
| **Constructor Call** | `this()` calls a constructor in the same class | `super()` calls the superclass constructor |

## 11. What is the Java load sequence?

| **Phase**          | **Description**                                                                            |
| ------------------ | ------------------------------------------------------------------------------------------ |
| **Loading**        | The Class Loader reads the `.class` file and loads its binary data into the JVM.           |
| **Linking**        | Prepares the class for use by verifying, preparing, and resolving references.              |
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

| **Feature**               | **Abstract Class**                                                                                                 | **Interface**                                                                       |
| ------------------------- | ------------------------------------------------------------------------------------------------------------------ | ----------------------------------------------------------------------------------- |
| **Definition**            | Cannot be instantiated; contains both abstract (without implementation) and concrete methods (with implementation) | Specifies a set of methods a class must implement; methods are abstract by default. |
| **Implementation Method** | Can have both implemented and abstract methods.                                                                    | Methods are abstract by default; Java 8 can have default and static methods.        |
| **Inheritance**           | A class can inherit from only one abstract class.                                                                  | A class can implement multiple interfaces.                                          |
| **Access Modifiers**      | Methods and properties can have any access modifier (public, protected, private).                                  | Methods and properties are implicitly public.                                       |
| **Variables**             | Can have member variables (final, non-final, static, non-static).                                                  | Variables are implicitly public, static, and final (constants).                     |

## 15. design a parking lot (put the code to codingQuestions/coding1 folder, )

### 1. If you have no ability to design it, please find the solution in internet, then understand it, and re-typeit.(Do NOT just copy and paste)

###16. What are Queue interface implementations and what are the differences and when to use what?
| **Queue Implementation** | **Description & When to Use** |
|--------------------------|------------------------------------------------------------------------------------------------------------------|
| **LinkedList** | Implements a doubly-linked list supporting FIFO operations, ideal for general-purpose queues with frequent insertions and deletions. |
| **PriorityQueue** | Orders elements based on priority rather than insertion order, suitable for scenarios where higher priority elements need to be processed first. |
| **ArrayDeque** | Provides a resizable-array implementation for efficient FIFO and LIFO operations, best used for high-performance stack and queue operations. |
=======

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

Although both `HashMap` and `Hashtable` are used for storing key-value pairs in Java, they differ in behavior, performance, and recommended usage.

### Concurrency

- `HashMap` is not thread-safe — it does **not synchronize** its methods, making it faster but unsuitable for concurrent use unless you add synchronization manually.
- `Hashtable`, on the other hand, uses **synchronized methods** internally, making it thread-safe but slower due to the locking overhead.

### Null Support

- `HashMap` supports **one null key** and allows multiple values to be null.
- `Hashtable` is more restrictive and **throws an exception** if you try to insert a null key or value.

### Speed

- Since `HashMap` skips synchronization, it's generally **faster** and more efficient in single-threaded applications.
- `Hashtable` tends to be **slower** because synchronization affects performance, especially under heavy use.

### Modern Usage

- `Hashtable` is an older class from before Java 1.2 and is now considered **legacy**.
- `HashMap` belongs to the **Java Collections Framework** and is widely used in modern codebases.
- If thread safety is required in newer applications, **`ConcurrentHashMap`** is a much better alternative to `Hashtable` — it offers **fine-grained concurrency** and better performance.

## 4. What is String pool in Java and why we need String pool?

- **What is String Pool:**
  In Java, the **String Pool** is a dedicated area in the Heap memory where **String literals** are stored and managed. When a String is created using double quotes (e.g., `"hello"`), the JVM checks if an identical String already exists in the pool:

- If it does, Java **reuses the existing object** by returning a reference to it.
- If not, the JVM **adds the new String** to the pool.

This mechanism only applies to Strings created as literals, not with the `new` keyword.

- **Why Do We Need the String Pool?**
  - **Efficient Memory Usage:** Since Strings are immutable in Java, storing duplicate copies of the same content is wasteful. The String Pool helps eliminate redundancy by sharing instances of common strings across the program.
  - **Faster Comparisons:** When Strings are pooled, checking equality using == becomes faster because it compares memory addresses, not character-by-character content — which boosts performance in many cases.

## 5. What is Java garbage collection?

- **What is Java garbage collection:**

  - Java Garbage Collection (GC) is an automatic process that the Java Virtual Machine (JVM) uses to manage memory. It identifies and removes **objects that are no longer in use**, freeing up memory space and preventing memory leaks.

- **How Does It Work?:**

- Java programs create many objects during execution.
- Some objects become **unreachable** over time — for example, if a variable goes out of scope or is reassigned.
- The garbage collector scans the heap memory and removes these unreachable objects.
- This helps keep your application **efficient** and prevents the program from using up too much memory.

- **Why Is Garbage Collection Important?:**

1. **Automatic Memory Management**  
   Developers don’t need to manually deallocate memory — the JVM handles it for you.

2. **Prevents Memory Leaks**  
   By clearing unused objects, GC helps avoid memory buildup that could crash the program.

3. **Improves Performance & Stability**  
   With less manual memory handling, your application becomes more stable and less error-prone.

## 6. What are access modifiers and their scopes in Java?

- **What are access modifiers:**
  - Access Modifiers are are keywords used to set the visibility (or accessibility) of classes, methods, constructors, and variables. They define **where** a member of a class can be accessed from — within the same class, package, or other classes.

Java provides **four** main access modifiers:

- **Scopes:**

  - **public:**

    - Accessible **everywhere**, across all classes and packages.
    - Commonly used for APIs and utility methods that are meant to be widely available.

  - **protected:**

    - Accessible within the **same package** and in **subclasses** (even in different packages).
    - Often used in inheritance scenarios.

  - **(default):**
    - Accessible **only within the same package**.
    - Cannot be accessed from a subclass in another package.
  - **private:**
    - Accessible **only within the same class**.
    - Ideal for hiding internal data or implementation details.

## 7. What is final key word? (Filed, Method, Class)

The `final` keyword in Java can be used with **fields**, **methods**, and **classes** to impose restrictions that help make your code more secure, predictable, and maintainable.

---

### `final` with Fields (Variables)

- Once a field is marked as `final`, it can be **assigned only once**.
- For **primitive types**, the value itself becomes fixed.
- For **object references**, the reference can't point to another object — but the contents of the object can still be changed.

---

### Blank Final Variables

- These are `final` fields that are **not initialized at declaration** but are instead assigned a value **inside the constructor**.
- This is especially useful when each object needs a different value for a field that shouldn't change after construction.

---

### `final` with Methods

- A method declared as `final` **cannot be overridden** in any subclass.
- This guarantees that the original implementation remains intact, which is useful for ensuring consistent or sensitive logic.

---

### `final` with Classes

- When a class is marked as `final`, it **cannot be extended or subclassed**.
- This is often used to **lock down a class** and prevent any modifications through inheritance.

---

### Why Use the `final` Keyword?

#### On Fields:

- To define **constants** or enforce **immutability** of important values.

#### On Methods:

- To **prevent alteration** of key behaviors by child classes.

#### On Classes:

- To **protect the class design** from being extended, especially when subclassing could introduce bugs or violate business rules.

## 8. What is static keyword? (Filed, Method, Class). When do we usually use it?

- **What is static keyword:**

  - The `static` keyword in Java is used to indicate that a member belongs to the **class itself**, rather than to instances of the class. It can be applied to **fields**, **methods**, **blocks**, and even inner classes.

- **static with Fields:**

  - A `static` field is **shared across all instances** of the class. It belongs to the class, not to any specific object. All instances access the same copy of the variable. Often used for constants or values common to all objects.

- **static with Methods:**
  - A static method can be called without creating an object of the class. Can only directly access static fields and other static methods. Cannot use this or super keywords. Commonly used for utility or helper methods.
- **static with Classes:**
  - Only nested inner classes can be declared static. A static nested class can be instantiated without creating an instance of the outer class. Used to logically group classes that are only used by their outer class.

## 9. What is the differences between overriding and overloading?

**Overriding** and **overloading** are two common concepts in Java that deal with methods — but they serve very different purposes.

---

### Method Overriding

**Overriding** occurs when a subclass provides a specific implementation of a method that is already defined in its superclass.

#### Key Characteristics:

- Happens **between two classes** (inheritance).
- Method **signature must be exactly the same** (name, parameters).
- The subclass method **replaces** the superclass method.
- Enables **runtime polymorphism** (dynamic binding).
- Use `@Override` annotation for clarity and error checking.

#### Example:

````java
class Animal {
    void speak() {
        System.out.println("Animal speaks");
    }
}

class Dog extends Animal {
    @Override
    void speak() {
        System.out.println("Dog barks");
    }
}

##  Method Overloading

**Method overloading** occurs when multiple methods in the same class share the **same name** but have **different parameter lists**. It allows a class to define multiple behaviors under a common method name, depending on the arguments passed.

---

###  Key Characteristics of Overloading

- Takes place **within the same class**.
- Methods must differ in:
  - Number of parameters
  - Type of parameters
  - Order of parameters
- Return type can be different, but it **does not affect overloading resolution**.
- Enables **compile-time polymorphism** (also called static binding).
- Helps improve **code readability** and **flexibility**.

---

###  Example:

```java
public class Printer {

    // Method 1
    void print(String message) {
        System.out.println("Printing string: " + message);
    }

    // Method 2
    void print(int number) {
        System.out.println("Printing integer: " + number);
    }

    // Method 3
    void print(String message, int copies) {
        System.out.println("Printing " + copies + " copies of: " + message);
    }
}


## 10. What is the difference between `super` and `this`?

- **`this`:** Refers to the current object of the class. It's used to access the current class's fields, methods, and constructors — especially when local variables shadow instance variables, or when calling another constructor within the same class.

- **`super`:** Refers to the immediate parent class. It's used to access superclass variables, methods, and constructors — often to call overridden methods or the parent class's constructor from a subclass.


## 11. What is the Java Load Sequence?

- **Class Loading:** The class loader loads the `.class` file into memory when it's first referenced.
- **Static Initialization:** Static blocks and static variables are initialized **once** when the class is loaded.
- **Object Creation:** When an object is created using `new`, memory is allocated and the constructor is called.
- **Instance Initialization:** Instance variables and instance initializer blocks are run **before** the constructor.
- **Constructor Execution:** Finally, the constructor runs to complete the object creation process.


## 12. What is Polymorphism? And how does Java implement it?

- **Polymorphism:** Polymorphism means "many forms". In Java, it allows one interface to be used for different data types or objects, enabling the same method name to behave differently based on the object that is calling it.

- **Compile-Time Polymorphism (Method Overloading):** Achieved by defining multiple methods with the same name but different parameter lists in the same class.

- **Runtime Polymorphism (Method Overriding):** Achieved when a subclass provides a specific implementation of a method defined in its superclass. The method that gets executed is determined at runtime based on the actual object type.


## 13. What is Encapsulation? How Java implements it? And why we need encapsulation?


- **Encapsulation:** Encapsulation is the concept of wrapping data (variables) and methods that operate on the data into a single unit, typically a class. It restricts direct access to some of the object’s components.

- **How Java Implements It:** Java achieves encapsulation by:
  - Declaring class variables as `private`.
  - Providing `public` getter and setter methods to access and modify those variables.

- **Why We Need Encapsulation:**
  - **Data Protection:** Prevents unauthorized access and modification of sensitive data.
  - **Control Access:** Allows controlled access through getters and setters.
  - **Improved Maintainability:** Internal implementation can change without affecting external code.
  - **Better Code Organization:** Groups related data and behavior together.


## 14. What is Interface and what is abstract class? What are the differences between them?



- **Interface:** An interface is a reference type in Java that defines a contract with abstract methods (and optionally default/static methods). It cannot have instance fields or constructors. A class implements an interface to provide behavior.

- **Abstract Class:** An abstract class is a class that cannot be instantiated and may contain both abstract (unimplemented) and concrete (implemented) methods. It can have fields, constructors, and methods with access modifiers.

- **Differences Between Interface and Abstract Class:**
  - **Multiple Inheritance:** A class can implement multiple interfaces but can only extend one abstract class.
  - **Method Types:** Interfaces can only have abstract, default, or static methods; abstract classes can have any type of method.
  - **Fields:** Interfaces can only have `public static final` constants; abstract classes can have instance variables.
  - **Constructors:** Interfaces cannot have constructors; abstract classes can.
  - **Use Case:** Use interfaces for defining capabilities; use abstract classes for base class behavior with shared code.


## 16. What are Queue interface implementations and what are the differences and when to use what?
````

## 16. What are Queue interface implementations and what are the differences and when to use what?

- **Queue Interface:** The `Queue` interface in Java represents a collection designed for holding elements prior to processing, following **FIFO** (First-In-First-Out) order.

- **Common Implementations:**

  - **LinkedList:** Implements both `Queue` and `Deque`. Allows null elements. Suitable for general-purpose queue operations and double-ended queue use.
  - **PriorityQueue:** Elements are ordered based on their natural ordering or a custom comparator. Does **not** allow `null` elements. Useful when elements must be processed by priority rather than insertion order.
  - **ArrayDeque:** Resizable array-based implementation of `Deque`. Faster than `LinkedList` for stack and queue operations. Does **not** allow `null` elements. Ideal for both FIFO (queue) and LIFO (stack) operations.
  - **ConcurrentLinkedQueue:** A thread-safe, non-blocking queue for concurrent use. Best for **multi-threaded** environments where high performance is needed.

- **When to Use What:**
  - Use **LinkedList** when you need a simple FIFO queue or double-ended queue.
  - Use **PriorityQueue** when element ordering matters (e.g., task scheduling by priority).
  - Use **ArrayDeque** for fast and efficient stack or queue operations without thread safety needs.
  - Use **ConcurrentLinkedQueue** in **multi-threaded** applications for non-blocking, thread-safe access.
