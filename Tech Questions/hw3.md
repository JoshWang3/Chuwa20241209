# HW3
## Questions:
### 1. What is the checked exception and unchecked exception in Java,could you give one example?
**checked exception**: exceptions that are checked at compile time. The checked exceptions must be either caught or as part of the method using `throws`. e.g. FileNotFoundException 
**unchecked exception**: exceptions that are not checked at compile time like `Error` and `RuntimeException` classes, e.g. NullPointerException

### 2. Can there be multiple finally blocks?
No, there can be only one finally block.

### 3. When both catch and finally return values,what will be the final result?
If the finally block return values, it will override any other return result.

### 4. What is `Runtime/unchecked exception`? what is Compile/Checked Exception?
**Runtime/unchecked exception** represent invalid conditions in areas outside the immediate control of the program like FileNotFoundException, IOException

**Compile/Checked Exception** is an exception that is not checked at compile time like ArithmeticException, ArrayIndexOutOfBoundsException or NullPointerException 


### 5. What is the difference between throw and throws?
`throw` is used when it is required to throw an Exception inside the method logic.

`throws` is a keyword to have statements when functions have exceptions.


### 6. Run the below three pieces codes,Noticed the printed exceptions.why do we put the Null/Runtime exception before Exception ?
Null/Runtime exception is a subclass to the Exception class, otherwise if the order of Exception will make follow exceptions unseen.

### 7. What is optional? why do you use it? write an optional example.
The Optional class is to help dealing with null values. It provides a way to represent non-existance of a value, avoiding the NullPointerException.
```
Optional<String> str1 = Optional.of("It's str1 here");

// Check present
if (str1.isPresent()) {
    System.out.println("Value: " + str1.get()); // Value: It's str1 here
}

// For possible null value
Optional<String> str2 = Optional.ofNullable(null);

// Set a default value if null
String result = str2.orElse("Default Value for str2");
System.out.println("Result: " + result); // Result: Default Value for str2
```

### 8. Why finally always be executed?
It makes sure the finally block is executed even if resources goes out of scope or an unexpected exception occurs.

### 9. Practice collection problems here
Please check under MavenProject/

### 10. What are the types of design patterns in Java ?
1. Creational: provide solutions to instantiate an Object in the best possible way for specific situations. (Factory, Singleton)
2. Structural: provide ways to create a Class structure, like using inheritance and composition to create a large Object from small Objects. (Adapter, Composite, Proxy)
3. Behavioral: provide a better interaction between objects and loose-coupling and flexibility. (Template Method, Observer, State)

### 11. What are the SOLID Principles ?
1. Single Responsibility Principle - states that every class must have a single, focused responsibility, a single reason to change.
2. Open/Closed Principle - components must be open for extension, but closed for modification.
3. Liskov Substitution Principle - must be able to replace a superclass object with a subclass object without affecting the correctness of the program.
4. Interface Segregation Principle - build small or interfaces needed that do not force the client to implement other behaviors they don't need.
5. Dependency Inversion Principle - high-level modules should not depend on low-level modules; follow abstraction and ensure loose coupling.

### 12. How can you achieve thread-safe singleton patterns in Java ?
1. Create the instance variable at the time of class loading
2. use `getInstance()` method for the synchronization
3. use volatile variables


### 13. What do you understand by the Open-Closed Principle (OCP) ?
Open: For Extension purpose, be able to add new functionality to a class without changing the existing code.
Closed: for Modification purpose, it shouldn't modify the existing behavior of a class that is already working.


### 14. Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.

Answer:
1. It means that if the object of type A can do something, the object of type B could also be able to perform the same thing.

If B (Dog, Cat) is a subclass of A (Animal), then objects of type B can replace objects of type A in any situation where A is expected, and the behavior (makeSound) should remain consistent.

### 15. Watch the design pattern video, and type the code, submit it to MavenProject folder
Check MavenProject/
