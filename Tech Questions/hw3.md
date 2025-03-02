# hw3

---

### 1. What is the checked exception and unchecked exception in Java, could you give one example?
- **Checked Exception**: Exceptions checked at compile-time. Example: `IOException`.
- **Unchecked Exception**: Exceptions that occur at runtime. Example: `NullPointerException`.

### 2. Can there be multiple finally blocks?
- No, a `try` block can have only one `finally` block.

### 3. When both catch and finally return values, what will be the final result?
- The value returned in the `finally` block will override the value in the `catch` block.

### 4. What is Runtime/unchecked exception? what is Compile/Checked Exception?
- **Runtime/Unchecked Exception**: Occurs during program execution, not checked at compile-time. Example: `ArithmeticException`.
- **Compile/Checked Exception**: Checked at compile-time; requires handling with `try-catch` or `throws`. Example: `FileNotFoundException`.

### 5. What is the difference between throw and throws?
- `throw`: Used to explicitly throw an exception. Example: `throw new Exception()`;
- `throws`: Declares exceptions a method might throw. Example: `public void method() throws IOException`.

### 6. Why do we put the Null/Runtime exception before Exception?
- Because exceptions are checked in order, and specific exceptions (like `NullPointerException`) should be caught before the general `Exception`, or the specific ones will never execute.

### 7. What is optional? why do you use it? write an optional example.
- `Optional` is a container for handling nullable values and avoiding `NullPointerException`.
```
Optional<String> name = Optional.ofNullable(null);
name.ifPresent(System.out::println); // Does nothing as value is null.
```

### 8. Why finally always be executed?
- `finally` block ensures resource cleanup and is executed **regardless of whether an exception occurs or not**.

### 9. What are the types of design patterns in Java?
- Creational, Structural, and Behavioral patterns.

### 10. What are the SOLID Principles?
- **S**: Single Responsibility Principle
- **O**: Open-Closed Principle
- **L**: Liskov Substitution Principle
- **I**: Interface Segregation Principle
- **D**: Dependency Inversion Principle

### 11. How can you achieve thread-safe singleton patterns in Java?
- Use synchronized methods, double-checked locking, or `Enum` singleton.

### 12. What do you understand by the Open-Closed Principle (OCP)?
- Software entities should be open for extension but closed for modification.

### 13. Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.
1. It mean that if the object of type A can do something, the object of type B could also be able tp
   perform the same thing✅
2. It means that all the objects of type A could execute all the methods present in its subtype B
3. It means if a method is present in class A, it should also be present in class B so that the object of
   type B could substitute object of type A.
4. It means that for the class B to inherit class A, objects of type B and objects of type A must be same.