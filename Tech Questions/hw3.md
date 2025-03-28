
## 1. Practice  collection
## 2. What is the checked exception and unchecked exception in Java, could you give one example?
- **Checked Exception:** Exceptions that are checked at compile time. The programmer must handle them using try-catch or declare them with throws.
  **Example:** IOException (e.g., when working with file input/output).
- **Unchecked Exception:** Exceptions that occur at runtime and are not checked at compile time. They are usually caused by programming errors.
  **Example:** NullPointerException (e.g., accessing a null object).
## 3. Can there be multiple finally blocks?
-**No,** in Java, each try block can have only one finally block。
## 4. When both catch and finally return values, what will be the final result?
- The finally block's return value will override any return value from the try or catch block.
## 5. What is Runtime/unchecked exception? what is Compile/Checked Exception?
- **Checked Exceptions:** Handled at compile time and represent recoverable conditions, e.g., file not found.
- **Unchecked Exceptions:** Occur at runtime, often caused by programming errors, e.g., null references or invalid array indices.
## 6. What is the difference between throw and throws?
- throw is used to throw an exception in the code.
```
throw e; // 'e' is an exception object
```
- throws is used to declare that a method might throw exceptions.
(It is used in the method declaration to indicate that the method may throw specific exceptions.)
```
public void doA(int a) throws Exception1, Exception3 {
// method body

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
- This is because Exception is the parent class of all checked exceptions, and RuntimeException (including NullPointerException and ArithmeticException) is a subclass of Exception. 
- If Exception is placed first, it will catch all exceptions, making the subsequent catch blocks for specific exceptions unreachable.
## 7. What is optional? why do you use it? write an optional example.
- Optional is a container object introduced in Java 8 to represent a value that may or may not be present (i.e., null). It is part of the java.util package.

- The main purpose of Optional is to avoid null pointer exceptions and improve code readability by handling null values explicitly.
```
import java.util.Optional;

public class WithOptional {
    public static void main(String[] args) {
        Optional<String> name = getName();

        // If the value is present, print it in uppercase
        name.ifPresentOrElse(
            n -> System.out.println(n.toUpperCase()), 
            () -> System.out.println("Name is not present")
        );
    }

    public static Optional<String> getName() {
        String value = null; // Simulating a value that might be null
        return Optional.ofNullable(value); // Wrap the value in Optional
    }
}
```
## 8. Why finally always be executed ?
- Because it is specifically designed to perform cleanup operations, such as releasing resources, closing files, or ensuring that critical code runs regardless of exceptions.
## 9. Practice collection problems here: https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/exercise/collection
## 10. What are the types of design patterns in Java ?
| **Type**       | **Purpose**                             | **Examples**                     |
|-----------------|-----------------------------------------|----------------------------------|
| **Creational** | Manages object creation.               | Singleton, Factory, Builder      |
| **Structural** | Manages relationships between objects. | Adapter, Decorator, Facade       |
| **Behavioral** | Manages communication between objects. | Observer, Strategy, Command      |
## 11. What are the SOLID Principles ?
| **Principle**                  | **Description**                                      | **Purpose**                     |
|--------------------------------|------------------------------------------------------|---------------------------------|
| **S - Single Responsibility**  | A class should have only one reason to change.       | Improves maintainability.       |
| **O - Open/Closed**            | Open for extension, closed for modification.         | Enhances flexibility.           |
| **L - Liskov Substitution**    | Subclasses should replace base classes without issues.| Ensures consistency.            |
| **I - Interface Segregation**  | Split large interfaces into smaller, specific ones.  | Reduces unnecessary dependencies. |
| **D - Dependency Inversion**   | Depend on abstractions, not on concrete implementations.| Reduces tight coupling.        |
## 12. How can you achieve thread-safe singleton patterns in Java ?
- Create the instance variable at the time of class loading.
- Synchronize the getInstance() method.
- Use synchronized block inside the if loop and volatile variable.

## 13. What do you understand by the Open-Closed Principle (OCP) ?
- The Open-Closed Principle (OCP) in software design states that software entities (like classes, modules, or functions) should be "open for extension, but closed for modification," meaning you should be able to add new functionality to a component without changing its existing code, promoting flexibility and maintainability by allowing for new features to be added without disrupting existing codebases.
## 14. Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.
### 1. It mean that if the object of type A can do something, the object of type B could also be able tp perform the same thing
### 2. It means that all the objects of type A could execute all the methods present in its subtype B
### 3. It means if a method is present in class A, it should also be present in class B so that the object of type B could substitute object of type A.
### 4. It means that for the class B to inherit class A, objects of type B and objects of type A must be same.
- My answer is 1.
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
# Homework 3

## 2. What is the checked exception and unchecked exception in Java, could you give one example?
- **What is the checked exception:**
    - These are exceptions that are checked at compile-time. The programmer is required to handle them explicitly using try-catch blocks or declare them in the method signature using throws.
    ```
    import java.io.FileReader;
    import java.io.IOException;

    public class CheckedExample {
        public static void main(String[] args) {
            try {
                FileReader reader = new FileReader("file.txt"); // May throw IOException
            } catch (IOException e) {
                System.out.println("File not found: " + e.getMessage());
            }
        }
    }
    ```
- **What is unchecked exception:**
    - These are exceptions that are not checked at compile-time, meaning the programmer does not need to handle them explicitly. They occur due to logical errors in the program.
    ```
    public class UncheckedExample {
        public static void main(String[] args) {
            int result = 10 / 0; // Throws ArithmeticException
        }
    }
    ```

## 3. Can there be multiple finally blocks? 
No, a try block can have only one finally block, which is optional and executed after the try block, regardless of whether an exception is thrown.

## 4. When both catch and finally return values, what will be the final result?
The value returned by the finally block will override the value returned by the catch block. This is because the finally block is always executed after the catch block, even if a return statement is executed in the catch.

## 5. What is Runtime/unchecked exception? what is Compile/Checked Exception?
Same as question 2.

## 6. What is the difference between throw and throws?
| Aspect       | `throw`                                                    | `throws`                                                                              |
|--------------|------------------------------------------------------------|---------------------------------------------------------------------------------------|
| **Purpose**  | Used to **explicitly throw an exception**.                 | Used to **declare exceptions** in a method signature.                                 |
| **Usage**    | Inside the method or block of code.                        | In the method signature, after the parameter list.                                    |
| **Execution**| Used to trigger an exception at runtime.                   | Indicates the possibility of an exception occurring, but does not execute anything.   |
| **Syntax**   | `throw new ExceptionType("message");`                      | `public void methodName() throws ExceptionType {}`                                    |
| **Scope**    | Affects the flow of execution by throwing the exception.   | Alerts the caller that the method may throw the specified exception(s).               |

- **Example of throw:**
```
public class ThrowExample {
    public static void main(String[] args) {
        int num = -5;
        if (num < 0) {
            throw new IllegalArgumentException("Number must be positive!"); // Throw an exception
        }
    }
}
```
- **Example of throws:**
```
import java.io.IOException;

public class ThrowsExample {
    public static void main(String[] args) throws IOException {
        readFile();
    }

    public static void readFile() throws IOException { // Declares an exception
        throw new IOException("File not found!"); // Throws an exception
    }
}
```

## 7. Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception ?
Exception handling follows the principle of specific to general. More specific exceptions must be caught before more general exceptions, or the code will result in a compilation error.

## 7. What is optional? why do you use it? write an optional example. 
- **What is optional:**
    - Optional is a container class introduced in Java 8 to represent a value that may or may not be null.
- **Why Use Optional:*
    - **Avoid NullPointerException:** Provides safe handling of null values.
    - **Improves Code Readability:** Makes it clear when a value might be absent.
    - **Encourages Functional Programming:** Use methods like map(), filter(), and ifPresent() for clean and fluent code.
- **Example of Using Optional:**
    ```
    import java.util.Optional;

    public class OptionalExample {
        public static void main(String[] args) {
            // Example: Getting a value that might be null
            String name = null; 
            
            // Using Optional to handle null safely
            Optional<String> optionalName = Optional.ofNullable(name);
            
            // Example 1: Check and print if present
            optionalName.ifPresent(n -> System.out.println("Name: " + n));
            
            // Example 2: Provide a default value if name is null
            String safeName = optionalName.orElse("Default Name");
            System.out.println("Safe Name: " + safeName);
            
            // Example 3: Transform the value using map
            optionalName.map(String::toUpperCase)
                        .ifPresent(n -> System.out.println("Uppercase Name: " + n));
        }
    ```

## 8. Why finally always be executed ?
- The finally block in Java always executes because its primary purpose is to ensure that essential cleanup code runs, regardless of whether an exception occurs or not.

- **When Will finally Not Execute:**
    - System.exit(0): Terminates the JVM.
    - Infinite Loop or JVM Crash: If the JVM crashes or the program hangs.
    - Fatal Errors: Such as OutOfMemoryError or StackOverflowError.

## 10. What are the types of design patterns in Java?
Design patterns in Java are reusable solutions to common software design problems. They are broadly classified into three main categories:
- **Creational Design Patterns:** These patterns deal with object creation mechanisms, making the system more flexible and reusable.

    | Pattern               | Description                                                                                               | Example                          |
    |-----------------------|-----------------------------------------------------------------------------------------------------------|----------------------------------|
    | **Singleton**         | Ensures only one instance of a class exists.                                                              | `Runtime` class in Java.         |
    | **Factory Method**    | Provides an interface to create objects but lets subclasses decide the class type.                        | `Calendar.getInstance()` method. |
    | **Abstract Factory**  | Provides an interface to create families of related objects without specifying their concrete classes.    | GUI toolkits like Swing or AWT.  |
    | **Builder**           | Separates object construction from representation for creating complex objects step by step.              | `StringBuilder` in Java.         |
    | **Prototype**         | Creates a new object by cloning an existing object.                                                       | `Object.clone()` method.         |

- **Structural Design Patterns:** These patterns deal with class and object composition, ensuring that parts of a system work together efficiently.

    | Pattern       | Description                                                                       | Example                                   |
    |---------------|-----------------------------------------------------------------------------------|-------------------------------------------|
    | **Adapter**   | Converts one interface into another that clients expect.                          | `InputStreamReader`, `OutputStreamWriter`.|
    | **Bridge**    | Separates abstraction from implementation so they can evolve independently.       | Remote APIs, JDBC drivers.                |
    | **Composite** | Composes objects into tree structures to represent part-whole hierarchies.        | `java.awt.Container`, `Component`.        |
    | **Decorator** | Adds additional functionality to objects dynamically.                             | `BufferedReader`, `BufferedWriter`.       |
    | **Facade**    | Provides a simplified interface to a complex subsystem.                           | `javax.faces.context.FacesContext`.       |
    | **Flyweight** | Reduces memory usage by sharing objects.                                          | String pooling in Java.                   |
    | **Proxy**     | Provides a placeholder for another object to control access.                      | `java.lang.reflect.Proxy`.                |

- **Behavioral Design Patterns:** These patterns focus on how objects communicate and behave.

    | Pattern                       | Description                                                                                       | Example                                   |
    |-------------------------------|---------------------------------------------------------------------------------------------------|-------------------------------------------|
    | **Observer**                  | Allows one-to-many dependency between objects, so changes in one object notify others.            | `java.util.Observer`, Listeners.          |
    | **Strategy**                  | Defines a family of algorithms and selects one at runtime.                                        | `Comparator` interface in Collections.    |
    | **Command**                   | Encapsulates a request as an object.                                                              | `Runnable` interface, `Executor`.         |
    | **Template Method**           | Defines the skeleton of an algorithm, letting subclasses fill in specific steps.                  | `java.util.AbstractList`.                 |
    | **Iterator**                  | Provides a way to access elements sequentially without exposing underlying structure.             | `Iterator` in Collections.                |
    | **Mediator**                  | Centralizes communication between objects to reduce dependencies.                                 | Chat applications, event managers.        |
    | **Chain of Responsibility**   | Passes a request along a chain of handlers.                                                       | Servlet filters in Java.                  |
    | **Memento**                   | Captures an object's state for restoration later.                                                 | Undo functionality.                       |
    | **State**                     | Allows an object to change behavior when its state changes.                                       | State machines.                           |
    | **Visitor**                   | Separates algorithms from object structures.                                                      | XML parsers.                              |

## 11. What are the SOLID Principles ?
- The SOLID Principles are five design principles that help create maintainable, scalable, and robust software. 
    - Single Responsibility Principle (SRP)  
        - A class should have only one reason to change.  
        - **Example**: A `User` class handles user data, while a `UserService` handles business logic.

    - Open/Closed Principle (OCP)  
        - Classes should be open for extension but closed for modification.  
        - **Example**: Use interfaces or abstract classes to extend behavior without modifying existing code.

    - Liskov Substitution Principle (LSP)  
        - Subclasses should be replaceable for their parent classes without breaking functionality.  
        - **Example**: If `Rectangle` is a subclass of `Shape`, all `Shape` logic should work with `Rectangle` too.

    - Interface Segregation Principle (ISP)  
        - No client should be forced to implement methods it doesn't use.  
        - **Example**: Instead of one large `Animal` interface, use `Flyable` and `Walkable` for specific behaviors.

    - Dependency Inversion Principle (DIP)  
        - High-level modules should not depend on low-level modules. Both should depend on abstractions.  
        - **Example**: Use dependency injection frameworks like Spring to inject dependencies.

## 12. How can you achieve thread-safe singleton patterns in Java ?
- **Using `synchronized` Method**  
   - Use a synchronized block inside the `getInstance()` method to ensure only one thread can access it at a time.  
   - **Code Example**:
     ```java
     public class Singleton {
         private static Singleton instance;
         private Singleton() {}
         public static synchronized Singleton getInstance() {
             if (instance == null) {
                 instance = new Singleton();
             }
             return instance;
         }
     }
     ```

- **Double-Checked Locking**  
   - Reduces overhead by synchronizing only the first time the instance is created.  
   - **Code Example**:
     ```java
     public class Singleton {
         private static volatile Singleton instance;
         private Singleton() {}
         public static Singleton getInstance() {
             if (instance == null) {
                 synchronized (Singleton.class) {
                     if (instance == null) {
                         instance = new Singleton();
                     }
                 }
             }
             return instance;
         }
     }
     ```

- **Eager Initialization**  
   - Create the instance when the class is loaded. Thread-safe by default.  
   - **Code Example**:
     ```java
     public class Singleton {
         private static final Singleton instance = new Singleton();
         private Singleton() {}
         public static Singleton getInstance() {
             return instance;
         }
     }
     ```

- **Bill Pugh Singleton Design**  
   - Uses a static inner helper class for lazy initialization.  
   - **Code Example**:
     ```java
     public class Singleton {
         private Singleton() {}
         private static class SingletonHelper {
             private static final Singleton INSTANCE = new Singleton();
         }
         public static Singleton getInstance() {
             return SingletonHelper.INSTANCE;
         }
     }
     ```

- **Enum Singleton**  
   - Simplest and thread-safe by default.  
   - **Code Example**:
     ```java
     public enum Singleton {
         INSTANCE;
         public void someMethod() {
             // Add logic here
         }
     }
     ```

## 13. What do you understand by the Open-Closed Principle (OCP) ?
Software entities (classes, modules, functions) should be open for extension but closed for modification.

## 14. Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.

Correct Answer: It mean that if the object of type A can do something, the object of type B could also be able tp
perform the same thing.

















