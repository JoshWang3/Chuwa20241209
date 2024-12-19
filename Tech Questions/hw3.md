# Homework 3
## Questions
### 1. Practice collection

### 2. What is the checked exception and unchecked exception in Java, could you give one example?
- In Java, most application-level exceptions are checked, which means that any method that throws one must declare with a special "throws" clause in its definition. The "throws" clause tells the compiler that a method is a possible source of that type of checked exception and that anyone calling that method must be prepared to deal with it. The caller must then either use a try/catch block to handle it or, in turn, declare that it can throw the exception from itself. For example: missing files and unavailable network hosts. 
```
void readFile(String s) throws IOException, InterruptedException {
    // do some I/O work
  }
```

- Unchecked exceptions are intended for system-level problems, such as “array index out of bounds.” They are subclasses of either the class `java.lang.RuntimeException` or the class `java.lang.Error` and we are not necessarily required to catch them since they are the problems from which we would not normally expect our software to recover.  

### 3. Can there be multiple finally blocks?

No, for one 'try' statement, there can only be one finally block. But, we can have multiples of `try`(1)-`catch`(0 or more)-`finally`(0 or 1) combinations.


### 4. When both catch and finally return values, what will be the final result?

When catch and finally block both return value, method will ultimately return value returned by "finally" block irrespective of value returned by catch block.

### 5. What is Runtime/unchecked exception? what is Compile/Checked Exception?

- Checked exceptions are checked at compile time by the JVM and its related to resources(files/db/stream/socket etc). The motive of checked exception is that at compile time if the resources are not available the application should define an alternative behaviour to handle this in the catch/finally block.

- Unchecked exceptions are purely programmatic errors, wrong calculation, null data or even failures in business logic can lead to runtime exceptions. It is fine not to handle/catch unchecked exceptions in our code.

### 6. What is the difference between throw and throws?

The keyword "throws" is used when writing methods, to declare that the method in question throws the specified (checked) exception, while the keyword "throw" is a statement to throw object `t` where `t` the instance of `java.lang.Throwable` must be true.

### 7. Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception?

The order of "catch" blocks follows the "most specific to most general" principle in exception handling. Since "NullPointerException" is a more specific type that extends "RuntimeException" which, in turn, extends "Exception", it must be caught first to ensure it gets handled by its specific catch block. If "Exception" or "RuntimeException" came first, it would catch all its subtypes (including "NullPointerException"), preventing specific exception handling.

### 7. What is optional? why do you use it? write an optional example.

In Java, the "Optional" is a special container class that is used to explicitly indicate whether a value is present or absent. It's a way to represent the potential absence of a value, providing a safer alternative to null checks and reducing the risk of 'NullPointerExceptions'. It also improves readability. 

```
String name = "John";
Optional<String> optionalName = Optional.of(name);

// Check if value is present
if (optionalName.isPresent()) {
    System.out.println("Name: " + optionalName.get());
} else {        
    System.out.println("Name is not present.");
}
```

### 8. Why finally always be executed?

Any statements in the body of the finally clause are guaranteed to be executed no matter how control leaves the try body, whether an exception is thrown or not. It is typically used for cleanup tasks, such as closing files, releasing resources, or resetting variables to ensure that these tasks are performed even if the code encounters an error.

### 9. Practice collection problems here: https://github.com/TAlsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/exercise/collection

### 10. What are the types of design patterns in Java ?

Generally, there are three categories of design patterns in software development namely "creational", "structural", and "behavioral" design patterns. Most common Java design patterns are the sigleton, factory, adapter, observer, decorator, and strategy pattern. 

### 11. What are the SOLID Principles?

"SOLID" is an acronym for the first five object-oriented design (OOD) principles proposed by Robert C. Martin. The individual letter stands for:
- Single-responsibility Principle
- Open-closed Principle
- Liskov Substitution Principle
- Interface Segregation Principle
- Dependency Inversion Principle

### 12. How can you achieve thread-safe singleton patterns in Java?

There are three ways through which we can achieve thread safety in Singleton patterns.
1. Create the instance variable at the time of class loading
2. Synchronize the getInstance() method
3. Use synchronized block inside the if loop and volatile variable

### 13. What do you understand by the Open-Closed Principle (OCP)?

The open–closed principle (OCP) states that an entity can allow its behaviour to be extended without modifying its source code. That means we should put new code in new classes/modules. Existing code should be modified only for bug fixing. New classes can reuse existing code via inheritance.

### 14. Liskov's substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA) choose your answer.
#### 1. It mean that if the object of type A can do something, the object of type B could also be able tp perform the same thing
#### 2. It means that all the objects of type A could execute all the methods present in its subtype B
#### 3. It means if a method is present in class A, it should also be present in class B so that the object of type B could substitute object of type A.
#### 4. It means that for the class B to inherit class A, objects of type B and objects of type A must be same.

The answer is # 1.

### 15. Watch the design pattern video, and type the code, submit it to MavenProject folder