## 1. Practice collection

## 2. What is the checked exception and unchecked exception in Java, could you give one example?

## 17. What is a Checked Exception and Unchecked Exception in Java? Could you give one example?

- **Checked Exception:**  
  A checked exception is an exception that is **checked at compile time**. The Java compiler forces you to handle these exceptions using `try-catch` blocks or by declaring them with the `throws` keyword. They typically represent **recoverable** conditions, such as file I/O errors or database access issues.

  - **Examples:** `IOException`, `SQLException`

  - **Code Example:**

    ```java
    import java.io.*;

    public class Example {
        public static void main(String[] args) throws IOException {
            FileReader reader = new FileReader("file.txt"); // Checked exception
        }
    }
    ```

---

- **Unchecked Exception:**  
  An unchecked exception occurs **at runtime** and is **not checked by the compiler**. These usually result from programming mistakes like accessing a null object or invalid array indices. Unchecked exceptions extend `RuntimeException`.

  - **Examples:** `NullPointerException`, `ArrayIndexOutOfBoundsException`

  - **Code Example:**
    ```java
    public class Example {
        public static void main(String[] args) {
            String text = null;
            System.out.println(text.length()); // Unchecked exception
        }
    }
    ```

---

## 3. Can there be multiple finally blocks?

-**No,** Java does not allow multiple `finally` blocks** for a single `try` block.  
 A `try` block can be followed by **at most one `finally` block\*\*, which is used to execute cleanup code (like closing resources), regardless of whether an exception was thrown or caught.

## 4. When both catch and finally return values, what will be the final result?

- In Java, if both the `catch` block and the `finally` block have return statements, **the return value from the `finally` block will override the one from `catch`**.

- This is because the `finally` block is always executed after `try` or `catch`, and if it contains a return statement, it **overrides any previous return**.

## 5. What is Runtime/unchecked exception? what is Compile/Checked Exception?

- **Runtime (Unchecked) Exception:**  
  These exceptions occur **at runtime** and are **not checked by the compiler**. They are usually caused by logical errors in the program, such as accessing a null object or dividing by zero. All unchecked exceptions are subclasses of `RuntimeException`.

  - **Examples:** `NullPointerException`, `ArithmeticException`, `ArrayIndexOutOfBoundsException`

  - **Characteristics:**
    - Not required to handle with `try-catch` or `throws`.
    - Program may compile fine but crash during execution.

---

- **Compile-Time (Checked) Exception:**  
  These exceptions are checked by the **compiler at compile time**, meaning the code must handle them using `try-catch` blocks or by declaring them with `throws`. They usually represent situations that are beyond the programmer’s control, like file handling or database access errors.

  - **Examples:** `IOException`, `SQLException`, `FileNotFoundException`

  - **Characteristics:**
    - Must be handled explicitly, or compilation will fail.
    - Used for **recoverable** conditions.

---

## 6. What is the difference between throw and throws?

- **`throw`:**  
  The `throw` keyword is used to **manually throw an exception** in the code. It is followed by an instance of a class that inherits from `Throwable`.

  - **Usage:** Inside a method or block to trigger an exception.
  - **Example:**
    ```java
    throw new IllegalArgumentException("Invalid input");
    ```

---

- **`throws`:**  
  The `throws` keyword is used in a **method signature** to declare that the method might throw one or more exceptions. It informs the caller to handle or propagate the exception.

  - **Usage:** In method declarations to specify expected exceptions.
  - **Example:**
    ```java
    public void readFile() throws IOException {
        // code that might throw IOException
    }
    ```

## 7. Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception ?

```
 public class Main {
    public static void main(String[] args) {
        int a = 0;
        int b = 3;
        String s = null;
        try {
            System.out.println(b / a);
            System.out.println(s.equals("aa"));
            throw new RuntimeException();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.getMessage();
        }
        System.out.println("End ...");
    }
 }
```

java.lang.ArithmeticException: / by zero
at Main.main(Main.java:7)

```
 public class Main {
    public static void main(String[] args) {
        int a = 0;
        int b = 3;
        String s = null;
        try {
            // System.out.println(b / a);
            System.out.println(s.equals("aa"));
            throw new RuntimeException();
        } catch (ArithmeticException e) {
            e.printStackTrace();
                   } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.getMessage();
        }
        System.out.println("End ...");
    }
 }
```

java.lang.NullPointerException
at Main.main(Main.java:8)

```
 public class Main {
    public static void main(String[] args) {
        int a = 0;
        int b = 3;
        String s = null;
        try {
            // System.out.println(b / a);
            // System.out.println(s.equals("aa"));
            throw new RuntimeException();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.getMessage();
        }
        System.out.println("End ...");
    }
 }
```

java.lang.RuntimeException
at Main.main(Main.java:10)

- Exceptions like ArithmeticException, NullPointerException, and RuntimeException are all subclasses of Exception. If catch (Exception e) is placed before these, they will never be reached — the compiler will throw an "unreachable code" error. This is why Java requires catch blocks to be ordered from most specific to most general.

## 7. What is optional? why do you use it? write an optional example.

- **What is `Optional`?**  
  `Optional` is a class introduced in Java 8, found in the `java.util` package. It is a **container object** which may or may not contain a non-null value. It is used to represent **optional values** instead of using `null`.

- **Why Do We Use `Optional`?**
  - To **avoid `NullPointerException`**.
  - To make the code **more readable and intentional**, especially when a method might return a missing or absent value.
  - To provide **clear alternatives** like `orElse()`, `orElseGet()`, and `ifPresent()` for handling missing values.

---

### ✅ Basic Example of Using `Optional`:

```java
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Optional<String> name = Optional.ofNullable(getName());

        // Handle the optional value
        name.ifPresent(System.out::println); // Prints if not null
        System.out.println(name.orElse("No Name Provided")); // Fallback value
    }

    public static String getName() {
        // return "Alice";
        return null; // Simulate absence of value
    }
}
```

## 8. Why finally always be executed ?

- - The `finally` block in Java is designed to **always execute**, regardless of whether an exception was thrown or caught. Its main purpose is to ensure that **cleanup code** (like closing files, releasing resources, or disconnecting from a database) **always runs**.

## 9. Practice collection problems here: https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/exercise/collection

## 10. What are the types of design patterns in Java ?

Design patterns in Java are **proven solutions to common design problems**. They are categorized into **three main types**, each serving a different purpose in object-oriented software design.

---

### 1. Creational Patterns

These patterns focus on **how objects are created**, aiming to make object creation more flexible and reusable.

- **Examples:**
  - `Singleton` – Ensures a class has only one instance.
  - `Factory Method` – Delegates object instantiation to subclasses.
  - `Abstract Factory` – Provides an interface to create families of related objects.
  - `Builder` – Constructs complex objects step-by-step.
  - `Prototype` – Clones objects instead of creating new ones.

---

### 2. Structural Patterns

These patterns deal with the **structure and relationships** of classes and objects, making it easier to compose large structures.

- **Examples:**
  - `Adapter` – Converts one interface into another expected by the client.
  - `Bridge` – Separates abstraction from its implementation.
  - `Composite` – Treats a group of objects the same way as a single object.
  - `Decorator` – Adds new behavior to objects dynamically.
  - `Facade` – Simplifies a complex system by providing a unified interface.
  - `Flyweight` – Reduces memory usage by sharing common data.
  - `Proxy` – Acts as a substitute for another object to control access.

---

### 3. Behavioral Patterns

These patterns are concerned with **how objects interact and communicate**, helping to define clear object responsibilities.

- **Examples:**
  - `Observer` – Defines a one-to-many dependency to notify changes.
  - `Strategy` – Defines a family of algorithms and makes them interchangeable.
  - `Command` – Encapsulates a request as an object.
  - `State` – Allows an object to change its behavior when its state changes.
  - `Template Method` – Defines a program skeleton and lets subclasses customize parts.
  - `Mediator` – Centralizes communication between components.
  - `Iterator` – Provides a way to access elements sequentially.
  - `Chain of Responsibility` – Passes a request along a chain of handlers.

---

### Summary Table

| Design Pattern Type | Purpose                          | Examples                    |
| ------------------- | -------------------------------- | --------------------------- |
| Creational          | Object creation                  | Singleton, Factory, Builder |
| Structural          | Object composition and structure | Adapter, Decorator, Facade  |
| Behavioral          | Communication and interaction    | Observer, Strategy, Command |

## 11. What are the SOLID Principles ?

The **SOLID principles** are a set of five design principles intended to make object-oriented software **more maintainable, scalable, and robust**. Each letter in "SOLID" stands for one principle.

---

### S – Single Responsibility Principle (SRP)

- **Definition:** A class should have only **one reason to change** — it should do only **one thing**.
- **Why:** Improves modularity and makes the code easier to understand and maintain.

---

### O – Open/Closed Principle (OCP)

- **Definition:** Software entities (classes, modules, functions) should be **open for extension**, but **closed for modification**.
- **Why:** Encourages writing code that can be extended without altering existing code.

---

### R – Liskov Substitution Principle (LSP)

- **Definition:** Subclasses should be **substitutable** for their base classes without altering the correctness of the program.
- **Why:** Ensures inheritance is used properly and that polymorphic behavior remains reliable.

---

### U – Interface Segregation Principle (ISP)

- **Definition:** Clients should **not be forced to depend** on interfaces they do not use.
- **Why:** Promotes small, specific interfaces rather than large, general-purpose ones.

---

### U– Dependency Inversion Principle (DIP)

- **Definition:** High-level modules should **not depend on low-level modules**. Both should depend on **abstractions**.
- **Why:** Reduces coupling between components and promotes flexibility.

---

### Summary Table

| Principle | Meaning                                              | Benefit                               |
| --------- | ---------------------------------------------------- | ------------------------------------- |
| SRP       | One class = one responsibility                       | Easier to understand & maintain       |
| OCP       | Open to extend, closed to change                     | Safe to add features without breaking |
| LSP       | Subtypes must be substitutable                       | Reliable inheritance & polymorphism   |
| ISP       | Small, client-specific interfaces                    | Avoids bloated interfaces             |
| DIP       | Depend on abstractions, not concrete implementations | Flexible and decoupled architecture   |

## 12. How can you achieve thread-safe singleton patterns in Java ?

The **Singleton pattern** ensures that only **one instance** of a class is created and provides a global point of access to it. In multi-threaded environments, it's important to implement the singleton in a **thread-safe** manner to avoid multiple instances being created.

- 1. Eager Initialization (Thread-Safe by Default)
- 2. Synchronized Method
- 3. Double-Checked Locking with volatile
- 4. Bill Pugh Singleton (Using Static Inner Class)

## 13. What do you understand by the Open-Closed Principle (OCP) ?

- **Definition:**  
  The **Open-Closed Principle (OCP)** is one of the SOLID principles of object-oriented design. It states that:

  > "Software entities (classes, modules, functions, etc.) should be **open for extension but closed for modification**."

- **Meaning:**  
  You should be able to add new functionality to a class **without changing its existing code**. This is typically done through **abstraction**, **inheritance**, or **interfaces**.

- **Why It’s Important:**
  - Encourages adding new code rather than changing existing logic.
  - Reduces the risk of introducing bugs in working code.
  - Makes the system easier to maintain and scale.

---

## 14. Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.

### 1. It mean that if the object of type A can do something, the object of type B could also be able tp perform the same thing

### 2. It means that all the objects of type A could execute all the methods present in its subtype B

### 3. It means if a method is present in class A, it should also be present in class B so that the object of type B could substitute object of type A.

### 4. It means that for the class B to inherit class A, objects of type B and objects of type A must be same.

- Answer is 1.

### 15. Watch the design pattern video, and type the code, submit it to MavenProject folder

    singleton:
    https://www.bilibili.com/video/BV1Np4y1z7BU?p=22
    Factory:
    https://www.bilibili.com/video/BV1Np4y1z7BU?p=35&vd_source=310561eab1216a27f7accf859bf7f6
    d9
    Builder:
    https://www.bilibili.com/video/BV1Np4y1z7BU?p=50&vd_source=310561eab1216a27f7accf859bf7f6
    d9
    Publisher_Subscriber:
    https://www.bilibili.com/video/BV1Np4y1z7BU?p=114&vd_source=310561eab1216a27f
    7accf859bf7f6d9

=======
