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