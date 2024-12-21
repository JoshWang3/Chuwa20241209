### Short Questions

#### 2. What is the checked exception and unchecked exception in Java, could you give one example?  

~~~java
1. Checked Exceptions
   - Compile-time exceptions.
   - Must be declared with throws or handled in try-catch.
   - Example: IOException, SQLException.
2. Unchecked Exceptions
   - Runtime exceptions.
   - Do not need explicit handling.
   - Example: NullPointerException, ArithmeticException.
~~~

#### 3. Can there be multiple finally blocks?    

```
No, only one finally block in one same try-catch statement
```

#### 4. When both catch and finally return values, what will be the final result?  

```
the value returned from the finally block will take precedence over the one returned from the catch block. the finally block is always executed last, and its return value will override any return value from the catch block.
```

#### 5. What is Runtime/unchecked exception? what is Compile/Checked Exception?  

```
Runtime exceptions are exceptions that are not checked at compile time, occur during the execution (runtime) of the program, do not need to be declared in the method signature using throws.
Checked exceptions are exceptions that must be either caught or declared to be thrown in the method signature using throws. They are checked at compile time by the Java compiler.
They are usually caused by external factors, such as network errors, file I/O issues, or database failures.
```

#### 6. What is the difference between throw and throws?  

```
throw: explicitly throw an exception, Used inside methods, constructors, or blocks
throws: declare that a method can throw an exception, Used in method declarations
```

#### 7.Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception ?  
```
specific exceptions should come before general exceptions
```

#### 7. What is optional? why do you use it? write an optional example  

```
It is a container class, representing a value that can either be present or absent. It provides methods to safely handle null values without explicitly checking for null
```

```java
Optional<String> object = Optional.ofNullable(null);
object.ifPresent(System.out::println); 
```

#### 8. Why finally always be executed ?  

```
finally is designed to ensure that essential cleanup operations or final steps are performed, regardless of what happens in the try or catch blocks.
```

#### 10. What are the types of design patterns in Java ?  

```
Creational, Structural, and Behavioral patterns.
```

#### 11. What are the SOLID Principles ?  

```
Single Responsibility Principle
Open-Closed Principle
Liskov Substitution Principle
Interface Segregation Principle
Dependency Inversion Principle
```

#### 12. How can you achieve thread-safe singleton patterns in Java ?  

```java
public static synchronized Singleton getInstance() {
    if (instance == null) {
        instance = new Singleton();
    }
    return instance;
}
```

```java
public static Singleton getInstance() {
    if (instance == null) { // First check (without locking)
        synchronized (Singleton.class) {
            if (instance == null) { // Second check (with locking)
                instance = new Singleton();
            }
        }
    }
    return instance;
}
```

#### 13. What do you understand by the Open-Closed Principle (OCP) ?  

```
open for extension but closed for modification.
```

#### 14. Liskov’s substitution principle  
```
Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be
substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.  

choose 1

1. It mean that if the object of type A can do something, the object of type B could also be able to perform the same thing
2. It means that all the objects of type A could execute all the methods present in its subtype B
3. It means if a method is present in class A, it should also be present in class B so that the object of type B could substitute object of type A.
4. It means that for the class B to inherit class A, objects of type B and objects of type A must be same.
```



