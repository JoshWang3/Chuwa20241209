### 2. What is the checked exception and unchecked exception in Java, could you give one example?

- Checked exceptions are exceptions that the compiler forces you to handle, either by using a try-catch block or by declaring them in the method signature with the throws keyword.
  - IOException
  - SQLException
- Unchecked exceptions are exceptions that are not checked by the compiler. The programmer is not required to handle or declare them.
  - NullPointerException
  - ArrayIndexOutOfBoundsException

### 3. Can there be multiple finally blocks?

No. One try block can have at most one finally block.

### 4. When both catch and finally return values, what will be the final result?

The value returned by the finally block will be the final result.

### 5. What is Runtime/unchecked exception? what is Compile/Checked Exception?

- Checked exceptions are checked at compile time by the JVM and its related to resources(files/db/stream/socket etc). The motive of checked exception is that at compile time if the resources are not available the application should define an alternative behaviour to handle this in the catch/finally block.

- Unchecked exceptions are purely programmatic errors, wrong calculation, null data or even failures in business logic can lead to runtime exceptions. It is fine not to handle/catch unchecked exceptions in our code.

### 6. What is the difference between throw and throws?

- throw: throw keyword is used to throw an exception explicitly. It is used to throw an exception from a method or any block of code.
- throws: throws keyword is used to declare an exception. It doesn't throw an exception. It specifies that there may occur an exception in the method. It is always used with the method signature.

### 7. Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception?

The order of "catch" blocks follows the "most specific to most general" principle in exception handling. Since "NullPointerException" is a more specific type that extends "RuntimeException" which, in turn, extends "Exception", it must be caught first to ensure it gets handled by its specific catch block. If "Exception" or "RuntimeException" came first, it would catch all its subtypes (including "NullPointerException"), preventing specific exception handling.

### 7. What is optional? Why use it? Write an optional example.

Optional is a class introduced in Java 8 as part of the java.util package. It is a container object used to represent a value that may or may not be present. It helps to avoid NullPointerException by explicitly dealing with the absence of a value.

Why use optional:
- To avoid NullPointerException
- Clearer Code
- Safe Null Handling

Example:
```java

public class WithOptional {
  public static void main(String[] args) {
    Optional<String> optionalValue = getOptionalValue();

    // Check if value is present
    if (optionalValue.isPresent()) {
      System.out.println("Value: " + optionalValue.get());
    } else {
      System.out.println("Value is null");
    }

    // Using orElse
    String result = optionalValue.orElse("Default Value");
    System.out.println("Result: " + result);

    // Using ifPresent
    optionalValue.ifPresent(value -> System.out.println("Processed Value: " + value));
  }

  public static Optional<String> getOptionalValue() {
    return Optional.ofNullable(null); // Simulating a nullable value
  }
}
```

### 8. Why finally always be executed?

The "finally" block is always executed because it is used to ensure that the necessary cleanup code is executed regardless of whether an exception is thrown or not. It is typically used to release resources like closing files, database connections, etc.

### 10. What are the types of design patterns in Java ?

Design patterns are standard solutions to common software design problems. In Java, design patterns are broadly categorized into three main types:
- Creational Patterns: These patterns deal with object creation mechanisms, trying to create objects in a manner suitable to the situation.
- Structural Patterns: These patterns deal with object composition and typically identify simple ways to realize relationships between different objects.
- Behavioral Patterns: These patterns are concerned with algorithms and the assignment of responsibilities between objects.

### 11. What are the SOLID principles in Java?

SOLID is an acronym for the first five object-oriented design (OOD) principles by Robert C. Martin. These principles are:
- Single Responsibility Principle (SRP): A class should have only one reason to change.
- Open/Closed Principle (OCP): Software entities should be open for extension but closed for modification.
- Liskov Substitution Principle (LSP): Objects of a superclass should be replaceable with objects of its subclasses without affecting the functionality.
- Interface Segregation Principle (ISP): A client should never be forced to implement an interface that it doesn't use or clients shouldn't be forced to depend on methods they do not use.
- Dependency Inversion Principle (DIP): High-level modules should not depend on low-level modules. Both should depend on abstractions. Abstractions should not depend on details. Details should depend on abstractions.

### 12. How can you achieve thread-safe singleton patterns in Java?

There are several ways to achieve thread-safe singleton patterns in Java:
1. Create the instance variable at the time of class loading
2. Synchronize the getInstance() method
3. Use synchronized block inside the if loop and volatile variable

### 13. What do you understand by the Open-Closed Principle (OCP)?

The open–closed principle (OCP) states that an entity can allow its behaviour to be extended without modifying its source code. That means we should put new code in new classes/modules. Existing code should be modified only for bug fixing. New classes can reuse existing code via inheritance.

### 14. Liskov's substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA) choose your answer.
1. It means that if the object of type A can do something, the object of type B could also be able to perform the same thing
2. It means that all the objects of type A could execute all the methods present in its subtype B
3. It means if a method is present in class A, it should also be present in class B so that the object of type B could substitute object of type A.
4. It means that for the class B to inherit class A, objects of type B and objects of type A must be same.

Answer: 1



























