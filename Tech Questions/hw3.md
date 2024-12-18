## HW3

### What is the checked exception and unchecked exception in Java, could you give one example?  
**Checked Exceptions**:  
Exceptions that are checked at **compile-time**. The compiler ensures that the programmer handles these exceptions (e.g., by using try-catch blocks or declaring them in the throws clause of a method).    
Examples:  
- IOException: Occurs during input/output operations, such as reading a file that does not exist.
``` java
public class CheckedExceptionExample {
    public static void main(String[] args) {
        try {
            FileReader file = new FileReader("nonexistent.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
```
**Unchecked Exceptions**:  
Exceptions that are not checked at compile-time. They occur at **runtime**, and the compiler does not require the programmer to handle or declare them.  
Examples:  
- NullPointerException: Happens when trying to access an object reference that is null.
``` java
public class UncheckedExceptionExample {
    public static void main(String[] args) {
        String text = null;
        System.out.println(text.length()); // Throws NullPointerException
    }
}
``` 

### Can there be multiple finally blocks?
In Java, there cannot be multiple finally blocks for a single try block. A try block can have only one finally block.

### When both catch and finally return values, what will be the final result?  
In Java, if both the catch block and finally block contain return statements, the return value from the **finally block will override** the return value from the catch (or try) block.  

### What is Runtime/unchecked exception? what is Compile/Checked Exception?  
Runtime/unchecked exception:
- These exceptions occur during runtime and are usually caused by programming errors, such as logical mistakes or improper use of an API.
- The programmer is not required to handle these exceptions explicitly, but doing so is considered good practice.

Compile/Checked Exception:  
- Checked exceptions are checked by the compiler at compile time.
- The programmer is required to handle these exceptions explicitly using a try-catch block or by declaring them in the method signature with throws.

### What is the difference between throw and throws?  
**throw**:  
- Purpose: Used to explicitly throw an exception from a method or block of code.
- Context: Typically used inside a method or a block of code.
- Usage: Followed by an instance of an exception.  

**throws**:
- Purpose: Used in the method signature to declare that a method might throw an exception. It informs the caller of the method about the potential exceptions it may need to handle.
- Context: Used in a method declaration.
- Usage: Followed by the class name(s) of the exception(s) that might be thrown, separated by commas if there are multiple.

### Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception ?  
- NullPointerException and RuntimeException are subclasses of Exception. Since NullPointerException is more specific, it should be caught before the broader Exception class.
- If we put the Exception catch block before the more specific exceptions, the program would never reach the specific catch blocks because the Exception block would catch the exceptions first (since Exception is a parent class of NullPointerException and RuntimeException).

### What is optional? why do you use it? write an optional example.  
Optional is a container object which may or may not contain a non-null value. It was introduced in Java 8 to handle situations where you might encounter null values, making it easier to write more robust and readable code by avoiding NullPointerException.

Why Use Optional?
- Avoid NullPointerException: Optional helps in avoiding null checks and NullPointerException.
- Express Intent: It clearly expresses that a value may or may not be present.
- Functional Programming: It provides a more functional way to handle nullable values, promoting cleaner and more readable code.
``` java
public class OptionalExample {
    public static void main(String[] args) {
        Optional<String> optionalString = Optional.ofNullable(null);

        // Using ifPresent to check if value is present
        optionalString.ifPresent(value -> System.out.println("Value: " + value));
        
        // Using orElse to provide a default value
        String result = optionalString.orElse("Default Value");
        System.out.println(result); // Output: Default Value

        // Using orElseThrow to throw an exception if value is not present
        String result2 = optionalString.orElseThrow(() -> new IllegalArgumentException("Value is missing"));
    }
}
``` 
### Why finally always be executed?  
The finally block is always executed in Java, regardless of whether an exception was thrown or not. This ensures that cleanup activities such as releasing resources (e.g., closing files, database connections) happen even if an exception is thrown.

### What are the types of design patterns in Java ?
1. **Creational Patterns**  
   Creational design patterns deal with the process of object creation. These patterns provide mechanisms that create objects in a manner suitable to the situation, often decoupling the client from the object creation process.

- Singleton Pattern: Ensures a class has only one instance and provides a global point of access to it.
- Factory Method Pattern: Defines an interface for creating objects, but the actual object creation is left to subclasses.
- Abstract Factory Pattern: Provides an interface for creating families of related or dependent objects without specifying their concrete classes.
- Builder Pattern: Allows the construction of a complex object step by step, isolating the construction process from the final object.
- Prototype Pattern: Creates new objects by copying an existing object, known as the prototype, instead of creating new ones from scratch.
2. **Structural Patterns**  
   Structural design patterns deal with object composition and the structure of classes or objects. They help ensure that classes and objects are organized and can work together efficiently.

- Adapter Pattern: Allows incompatible interfaces to work together by creating an adapter class that converts one interface to another.
- Bridge Pattern: Decouples an abstraction from its implementation so that both can vary independently.
- Composite Pattern: Allows you to compose objects into tree-like structures to represent part-whole hierarchies.
- Decorator Pattern: Allows behavior to be added to individual objects without affecting the behavior of other objects from the same class.
- Facade Pattern: Provides a simplified interface to a complex subsystem, hiding its complexities.
- Flyweight Pattern: Reduces the memory usage by sharing common data among similar objects rather than creating new objects.
- Proxy Pattern: Provides a surrogate or placeholder to another object to control access to it.
3. **Behavioral Patterns**  
   Behavioral design patterns deal with object interaction and communication between objects. They focus on how objects interact and distribute responsibility among them.

- Observer Pattern: Allows a subject to notify its observers about changes in its state, providing a one-to-many dependency.
- Strategy Pattern: Defines a family of algorithms and makes them interchangeable. It allows the algorithm to be selected at runtime.
- Command Pattern: Encapsulates a request as an object, thereby allowing for parameterization of clients with queues, requests, and operations.
- Chain of Responsibility Pattern: Passes a request along a chain of handlers, where each handler either handles the request or passes it to the next handler.
- State Pattern: Allows an object to change its behavior when its internal state changes, appearing as if the object changed its class.
- Template Method Pattern: Defines the skeleton of an algorithm in a method, allowing subclasses to implement specific steps of the algorithm.
- Iterator Pattern: Provides a way to access the elements of a collection without exposing its underlying structure.
- Mediator Pattern: Defines an object that mediates communication between different objects, reducing direct dependencies between them.
- Memento Pattern: Allows for the saving and restoring of an object's state, enabling undo/redo functionality.
- Visitor Pattern: Allows adding new operations to existing classes without modifying them, by defining new operations in separate visitor classes.

### What are the SOLID Principles ?
The SOLID principles are a set of five design principles that help developers create more maintainable, understandable, and flexible software.
- Single Responsibility Principle (SRP): A class should have only one reason to change.
- Open/Closed Principle (OCP): Software entities should be open for extension but closed for modification.
- Liskov Substitution Principle (LSP): Subtypes should be replaceable for their base types without affecting the correctness of the program.
- Interface Segregation Principle (ISP): Clients should not be forced to depend on interfaces they do not use.
- Dependency Inversion Principle (DIP): High-level modules should depend on abstractions, not on concrete implementations.

### How can you achieve thread-safe singleton patterns in Java ?
Achieving a thread-safe singleton pattern in Java ensures that only one instance of a class is created, even in multithreaded environments.  
1. Eager Initialization (Static Block Initialization)  
   In this method, the instance of the singleton is created when the class is loaded. It is thread-safe because the instance is created during class loading and the class loading mechanism is thread-safe in Java.
2. Lazy Initialization (Thread-Safe using synchronized keyword)  
   This method creates the singleton instance only when it's needed. However, it requires synchronization to ensure that only one thread can create the instance.  
3. Double-Checked Locking (Using synchronized inside if statement)  
   To reduce the overhead of synchronization, the double-checked locking pattern is used. It checks if the instance is already created without synchronization, and only synchronizes when the instance is null.  
4. Bill Pugh Singleton Design (Static Inner Class)  
   This is the most efficient and thread-safe method. It leverages the class loading mechanism to initialize the singleton instance. The instance is created when the singleton class is loaded and only when it’s needed.  


### What do you understand by the Open-Closed Principle (OCP) ?
The Open-Closed Principle (OCP) is one of the SOLID principles of object-oriented design.  
- Open for extension: This means that the behavior of a software module (such as a class or function) can be extended to accommodate new functionality without changing the existing code. You can add new features or behaviors by adding new code, rather than modifying the existing, tested, and deployed code.
- Closed for modification: This means that once a module or class is implemented, it should not be altered directly for future changes. Modifying the existing code could introduce bugs and affect other parts of the system, especially in large or complex applications. Instead, you should extend the system with new code, leaving the existing code intact.

### Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.
1. It mean that if the object of type A can do something, the object of type B could also be able tp
   perform the same thing
2. It means that all the objects of type A could execute all the methods present in its subtype B
3. It means if a method is present in class A, it should also be present in class B so that the object of
   type B could substitute object of type A.
4. It means that for the class B to inherit class A, objects of type B and objects of type A must be same.  

**Answer**:
   Option 1 is correct because it reflects the core idea of LSP: if class B is a subtype of class A, an object of class B should be able to perform the same operations as an object of class A. Substituting an object of type A with an object of type B should not break the program or lead to unexpected behavior.

