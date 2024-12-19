1. Practice collection

Add the code to `/Coding/Collection`

2. What is the checked exception and unchecked exception in Java, could you give one example?

**Checked exceptions** are exceptions that are checked by the compiler at compile time.
The compiler forces you to handle these exceptions, either by using a `try-catch` block or by declaring them in the method signature using the `throws` keyword.

```java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CheckedExceptionExample {
    public static void main(String[] args) {
        try {
            File file = new File("nonexistent.txt");
            Scanner scanner = new Scanner(file); // This can throw FileNotFoundException
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
```


**Unchecked exceptions** are exceptions that occur at runtime, and the compiler does not check whether you handle these exceptions.
These exceptions typically result from programming errors or logic mistakes, such as dividing by zero or accessing a `null` reference.

```java
public class UncheckedExceptionExample {
    public static void main(String[] args) {
        String str = null;
        try {
            System.out.println(str.length()); // This throws NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        }
    }
}
```

3. Can there be multiple finally blocks?

No, there cannot be multiple finally blocks in a single try-catch structure in Java.

4. When both catch and finally return values, what will be the final result?

The `finally` block's return value takes precedence and overrides the return value of the `catch` or `try` block.

5. What is Runtime/unchecked exception? what is Compile/Checked Exception?

**Checked exceptions** are exceptions that are checked by the compiler at compile time.
The compiler forces you to handle these exceptions, either by using a `try-catch` block or by declaring them in the method signature using the `throws` keyword.

**Unchecked exceptions** are exceptions that occur at runtime, and the compiler does not check whether you handle these exceptions.
These exceptions typically result from programming errors or logic mistakes, such as dividing by zero or accessing a `null` reference.

6. What is the difference between throw and throws?

The `throw` keyword is used to explicitly throw an exception from a method or block of code.

The `throws` clause declares exceptions that a method may throw.

7. Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime
exception before Exception ?
```java
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

Specific exceptions are caught first. If none of the specific exceptions match, the general Exception catch block handles the remaining cases.
This ordering ensures exceptions are handled appropriately and avoids compiler errors.

7. What is optional? why do you use it? write an optional example.

`Optional` is a container for values that may or may not be present.
It helps avoid `NullPointerException` and makes code cleaner.

```java
import java.util.Optional;

public class OptionalShortExample {
    public static void main(String[] args) {
        // Create an Optional with a null value
        String name = null;
        Optional<String> optionalName = Optional.ofNullable(name);

        // Use orElse to provide a default value
        String finalName = optionalName.orElse("Default Name");

        System.out.println("Name: " + finalName);
    }
}
```

8. Why finally always be executed ?

To ensure that cleanup actions (such as releasing resources, closing files, or restoring states) are performed consistently.

9. Practice collection problems here: https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/exercise/collection

Add the code to `/Coding/Collection`

10. What are the types of design patterns in Java ?

| **Type**          | **Purpose**                                          | **Examples**                                  |
|--------------------|-----------------------------------------------------|----------------------------------------------|
| **Creational**     | Object creation                                      | Singleton, Factory Method, Builder           |
| **Structural**     | Composition and relationships                       | Adapter, Composite, Proxy, Facade            |
| **Behavioral**     | Interaction and communication between objects       | Observer, Strategy, Command, Chain of Responsibility |


11. What are the SOLID Principles ?

| **Principle**                  | **Definition**                                                                                         | **Purpose**                                 |
|--------------------------------|-------------------------------------------------------------------------------------------------------|---------------------------------------------|
| **Single Responsibility (SRP)**| A class should have only one reason to change.                                                        | Promotes cohesion and easier maintenance.   |
| **Open/Closed (OCP)**          | Classes should be open for extension but closed for modification.                                     | Enables adding new features safely.         |
| **Liskov Substitution (LSP)**  | Subtypes must be substitutable for their base types without breaking functionality.                   | Ensures proper use of inheritance.          |
| **Interface Segregation (ISP)**| Classes should not be forced to implement interfaces they do not use.                                 | Reduces implementation burdens.             |
| **Dependency Inversion (DIP)** | High-level modules should depend on abstractions, not concrete implementations.                       | Decouples dependencies and improves testability. |


12. How can you achieve thread-safe singleton patterns in Java ?

We need to ensure that only one instance of the class is created, even when multiple threads attempt to access it simultaneously.

13. What do you understand by the Open-Closed Principle (OCP) ?

The Open-Closed Principle (OCP) is one of the five SOLID principles of object-oriented design.
Software entities (such as classes, modules, and functions) should be open for extension but closed for modification.
                     
14. Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be
    substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.
    1. It means that if the object of type A can do something, the object of type B could also be able tp
       perform the same thing
    2. It means that all the objects of type A could execute all the methods present in its subtype B
    3. It means if a method is present in class A, it should also be present in class B so that the object of
       type B could substitute object of type A.
    4. It means that for the class B to inherit class A, objects of type B and objects of type A must be same.

I choose answer 1. 

The Liskov Substitution Principle (LSP) states that subtypes must be substitutable for their base types. This means:

- Any instance of a subclass (B) should be able to replace an instance of its superclass (A) without altering the correctness or functionality of the program.
- A subclass (B) should honor the behavior and guarantees provided by the superclass (A).

15. Watch the design pattern video, and type the code, submit it to MavenProject folder

Add the code to `/Projects`