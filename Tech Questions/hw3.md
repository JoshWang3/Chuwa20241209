# HW3

1. Practice [collection](https://github.com/CTYue/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/exercise/collection)
2. What is the checked exception and unchecked exception in Java, could you give one example?
   - checked exception are checked at compile-time
   - unchecked exception are checked at runtime
3. Can there be multiple finally blocks?
   - no, can only have one finally block
4. When both catch and finally return values, what will be the final result?
   - the value return by finally
5. What is Runtime/unchecked exception? what is Compile/Checked Exception?
   - Runtime/Unchecked exception: exceptions occur during the runtime, e.g `NullPointerException`, `IndexOutOfBoundsException`
   - Compile/Checked exception: exceptions checked at compile time, e.g `IOException`
6. What is the difference between throw and throws?
   - throw: used to throw a exception
   - throws: declare exceptions that a method might throw
7. Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime
   exception before Exception ?
   - small first, then big (general)
8. What is optional? why do you use it? write an optional example.
   - Optional is a container object in Java that may or may not contain a non-null value.
   - It provides a safe way to handle null values.
9. Why finally always be executed ?
   - It designed for cleanup action.
10. What are the types of design patterns in Java ?
    1. Creational Patterns
    2. Structural Patterns
    3. Behavioral Patterns
11. What are the SOLID Principles ?
    - S: Single Responsibility Principle
    - O: Open-Closed Principle
    - L: Liskov Substitution Principle
    - I: Interface Segregation Principle
    - D: Dependency Inversion Principle
12. How can you achieve thread-safe singleton patterns in Java ?
    - Lazy Load
    - Eager Load
13. What do you understand by the Open-Closed Principle (OCP) ?
    - A class should be open for extension but closed for modification
14. Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be
        substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.
    1. It mean that if the object of type A can do something, the object of type B could also be able tp
       perform the same thing
    2. It means that all the objects of type A could execute all the methods present in its subtype B
    3. It means if a method is present in class A, it should also be present in class B so that the object of
       type B could substitute object of type A.
    4. It means that for the class B to inherit class A, objects of type B and objects of type A must be same.
    - Ans: i