### HW3 Exception

#### 1. Practice  collection

#### 2. What is the checked exception and unchecked exception in Java, could you give one example?

```
1. Checked Exceptions:
Checked exceptions are exceptions that are checked at compile-time. This means the compiler ensures that these exceptions are either
Handled using a try-catch block, or Declared in the method signature using the throws keyword.

Use Checked Exceptions when the exception represents a condition that the application can reasonably recover from,
such as file not found, network issues.

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;

	public class CheckedExceptionExample {
		public static void main(String[] args) {
			try {
				FileInputStream file = new FileInputStream("nonexistentfile.txt");
			} catch (FileNotFoundException e) {
				System.out.println("File not found: " + e.getMessage());
			}
		}
	}
	
FileNotFoundException is a checked exception. 
The compiler forces it to handle it using a try-catch block or declare it in the method signature.

2. Unchecked Exceptions:
	Unchecked exceptions are exceptions that are not checked at compile-time. 
	They are typically caused by programming errors, such as logic mistakes, invalid input, or improper use of APIs.

	Use Unchecked Exceptions for programming errors or conditions that should be fixed in the code, such as null references, invalid array access.
	
	Unchecked exceptions represent conditions that are usually unrecoverable and should be fixed in the code rather than handled at runtime.
	NullPointerException, ArrayIndexOutOfBoundsException, and ArithmeticException are common unchecked exceptions.

	public class UncheckedExceptionExample {
		public static void main(String[] args) {
			int[] numbers = {1, 2, 3};
			System.out.println(numbers[5]); // This will throw ArrayIndexOutOfBoundsException
		}
	}

3,
Feature			Checked Exceptions							Unchecked Exceptions
Checked at		Compile-time							Runtime
Handling	Must be handled or declared using throws	Optional (not enforced by the compiler)
Caused by	External factors (e.g., I/O, file access)	Programming errors (e.g., logic mistakes)
Recovery	Often recoverable							Often unrecoverable
Examples	IOException, SQLException					NullPointerException, ArithmeticException
```

#### 3. Can there be multiple finally blocks?

```
No, in Java, there cannot be multiple finally blocks for a single try block. 
A try block can have only one finally block, which is executed regardless of whether an exception is thrown or not. 
The finally block is designed to provide a single place to clean up resources or perform necessary actions that must always occur,
such as closing files, releasing locks, or cleaning up connections.

If we need to perform multiple cleanup actions, you can include all of them in the single finally block.

If we add multiple finally blocks to a single try block, the Java compiler will throw a compile-time error.
The compiler forces the rule of having only one finally block per try block.
```

#### 4. When both catch and finally return values, what will be the final result?
```
finally Overrides catch: If both catch and finally return values, the finally block's return value takes precedence.

The finally block is designed to always execute, regardless of whether an exception is thrown or caught. 
The finally block always executes, even if a return statement is encountered in the try or catch block.
This ensures that any cleanup or finalization code runs.

Returning a value from the finally block is discouraged because it can mask the original return value or exception.
This makes the code harder to understand and debug. 

```
#### 5. What is Runtime/unchecked exception? what is Compile/Checked Exception?

```
1, Runtime exceptions are exceptions that occur during the execution of a program (at runtime).
They are not checked at compile-time, meaning the compiler does not enforce handling or declaring these exceptions.

These exceptions are typically caused by programming errors, such as logic mistakes, invalid input, or improper use of APIs.
Handling runtime exceptions is optional. If not handled, they propagate up the call stack and may terminate the program.

Examples are NullPointerException, ArrayIndexOutOfBoundsException, ArithmeticException, IllegalArgumentException.

2, Checked exceptions are exceptions that are checked at compile-time. 
The compiler ensures that these exceptions are either Handled using a try-catch block, or
Declared in the method signature using the throws keyword.

Handling checked exceptions is mandatory. If not handled, the code will not compile.

Examples are IOException, SQLException, FileNotFoundException, ClassNotFoundException.
```

#### 6. What is the difference between throw and throws?

```
1, throw: Used to explicitly throw an exception within a method.  It is used within a method body to throw an exception object.
public class ThrowExample {
    public static void main(String[] args) {
        int age = -5;
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        System.out.println("Age is: " + age);
    }
}

2, throws: Used to declare that a method might throw one or more exceptions.
It does not throw the exception itself but indicates that the caller of the method must handle or propagate the declared exceptions.
The caller of the method must handle or propagate this exception.

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThrowsExample {
    public static void main(String[] args) {
        try {
            readFile("nonexistentfile.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    public static void readFile(String filename) throws FileNotFoundException {
        FileInputStream file = new FileInputStream(filename);
    }
}

3, We can use them both in a same method.
Example:
public class ThrowAndThrowsExample {
    public static void main(String[] args) {
        try {
            validateAge(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }

    public static void validateAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        System.out.println("Age is valid: " + age);
    }
}
```

#### 7. Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception ?

```




```



#### 7. What is optional? why do you use it? write an optional example.

```
Optional is a container class introduced in Java 8 as part of the java.util package. 
It is designed to handle situations where a value might be absent (i.e., null) in a more elegant and functional way. 
Instead of returning null and risking NullPointerException, return an Optional object that either contains a non-null value or is empty.






```

#### 8. Why finally always be executed ?

```
The finally block is guaranteed to always execute, regardless of whether an exception is thrown or not. 
It is used to perform some critical cleanup operations, such as releasing resources, closing files, or unlocking locks.

Avoid return in finally to prevent unexpected behavior. 
Because returning a value from the finally block can override the return value of the try or catch block.

Two special cases:
1, When there is a return Statement in try or catch, the finally block executes before the method returns.
Example:
public class FinallyExample {
    public static void main(String[] args) {
        System.out.println("Result: " + test());
    }

    public static String test() {
        try {
            System.out.println("Inside try block");
            return "Return from try";
        } finally {
            System.out.println("Inside finally block");
        }
    }
}

Output is:
Inside try block
Inside finally block
Result: Return from try

2, But when there is System.exit() in try or catch, the finally block does not execute because the program terminates immediately.

public class FinallyExample {
    public static void main(String[] args) {
        try {
            System.out.println("Inside try block");
            System.exit(0); // Terminates the program
        } finally {
            System.out.println("Inside finally block"); // This will not execute
        }
    }
}

Output is:
Inside try block
```

#### 9. Practice collection problems here: https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/exercise/collection

```
ArrayList
LinkedList
CopyOnWriteArrayList
HashSet
TreeSet
HashMap
TreeMap
LinkedHashMap
Additional Map
Arrays
Collections
```

#### /

```
There are three types of design patterns in Java:

Category	Purpose										Examples
1. Creational	Object creation							Singleton, Factory Method, Builder
2, Structural	Class and object composition			Adapter, Decorator, Facade, Proxy
3, Behavioral	Object interaction and responsibility	Observer, Strategy, Command, State

1, Creational:
Singleton: Ensures a single instance of a class.
Factory Method: Delegates object creation to subclasses.
Builder: Constructs complex objects step-by-step.

2, 
Adapter: Makes incompatible interfaces work together.
Decorator: Adds behavior to objects dynamically.
Proxy: Controls access to an object.

3, 
Observer: Notifies dependents of state changes.
Strategy: Encapsulates interchangeable algorithms.  

The benefits of using design patterns are:
	Reusability: Provides proven solutions to common problems.
	Maintainability: Makes code easier to understand and modify.
	Scalability: Helps structure code to handle growth and complexity.
	Best Practices: Encapsulates best practices for software design.
```

#### 11. What are the SOLID Principles ?

```
Principle							Key Idea
Single Responsibility (SRP)			A class should have only one reason to change.
Open/Closed (OCP)					Software should be open for extension but closed for modification.
Liskov Substitution (LSP)			Subclasses should be substitutable for their base classes.
Interface Segregation (ISP)			Create small, specific interfaces instead of large, general ones.
Dependency Inversion (DIP)			Depend on abstractions, not on concrete implementations.

1, Single Responsibility Principle (SRP)
A class should have only one reason to change, meaning it should have only one responsibility or job.
Ensures that a class is focused on a single task, making it easier to understand, test, and maintain.

2, Open/Closed Principle (OCP)
Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.
Example:
	Use abstraction, such as interfaces or abstract classes, to allow new implementations without modifying existing code.

3, Liskov Substitution Principle (LSP)
Objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program.
Ensures that a subclass can stand in for its superclass without breaking the application.

Example:
	A Bird class should not have a fly() method if not all birds can fly (e.g., penguins). Instead, create a FlyingBird subclass.

	class Bird {
		void eat() { System.out.println("Eating"); }
	}

	class FlyingBird extends Bird {
		void fly() { System.out.println("Flying"); }
	}

	class Penguin extends Bird {
		// Penguins cannot fly, so they don't inherit from FlyingBird
	}

4, Interface Segregation Principle (ISP)
Clients should not be forced to depend on interfaces they do not use. Instead, create small, specific interfaces.
Purpose: Prevents classes from implementing unnecessary methods, making the system more modular and easier to maintain.

Example:
	Instead of a single Worker interface with work() and eat() methods, split it into separate interfaces:

	interface Workable {
		void work();
	}

	interface Eatable {
		void eat();
	}

	class HumanWorker implements Workable, Eatable {
		public void work() { System.out.println("Working"); }
		public void eat() { System.out.println("Eating"); }
	}

	class RobotWorker implements Workable {
		public void work() { System.out.println("Working"); }
	}

5, Dependency Inversion Principle (DIP)
High-level modules should not depend on low-level modules. 
Both should depend on abstractions. Additionally, abstractions should not depend on details; details should depend on abstractions.
Reduces coupling between modules, making the system more flexible and easier to modify.

Example:
Instead of directly depending on a specific database implementation, depend on an abstraction, such as an interface.

interface Database {
    void save(String data);
}

class MySQLDatabase implements Database {
    public void save(String data) {
        System.out.println("Saving data to MySQL: " + data);
    }
}

class Application {
    private Database database;

    public Application(Database database) {
        this.database = database;
    }

    public void saveData(String data) {
        database.save(data);
    }
}
	

6, The benefits of following SOLID Principles are:
	Maintainability: Code is easier to understand, modify, and extend.
	Scalability: New features can be added with minimal changes to existing code.
	Testability: Smaller, focused classes are easier to test.
	Reusability: Modular code can be reused across different parts of the application.
	Flexibility: Changes in one part of the system have minimal impact on other parts.
```

#### 12. How can you achieve thread-safe singleton patterns in Java ?

```
1, Enum Singleton:
Uses an enum to define the singleton. This is the most recommended approach by Joshua Bloch in Effective Java.


public enum EnumSingleton {
    INSTANCE;

    public void doSomething() {
        System.out.println("Singleton is doing something");
    }
}


2, Use Static inner Class:
Uses a static inner class to hold the singleton instance. The instance is created only when the inner class is loaded.

Pros: Thread-safe, lazy initialization, and no synchronization overhead.
Cons: Slightly more complex than eager initialization.

public class BillPughSingleton {
    private BillPughSingleton() {} // Private constructor

    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}





```


#### 13. What do you understand by the Open-Closed Principle (OCP) ?

```
1, Open for Extension: The behavior of a module can be extended to meet new requirements.
2, Closed for Modification: The source code of the module should not be modified to extend its behavior.

By using OCP, it is easier to adapt to changing requirements and less prone to bugs. 

The benefits of using OCP are:
	Maintainability: By avoiding changes to existing code, we reduce the risk of introducing bugs.
	Scalability: New functionality can be added without altering existing, tested code.
	Reusability: Existing modules can be reused and extended in new contexts.
	Flexibility: The system becomes more adaptable to changing requirements.

3, Use abstractions, inheritance, polymorphism, and design patterns to achieve OCP.
(1)Abstraction:	Use abstract classes or interfaces to define a contract for behavior.
New functionality can be added by creating new implementations of the abstraction without modifying existing code.

(2)Inheritance:	Extend existing classes to add new behavior.
However, prefer composition over inheritance to avoid tight coupling.

(3)Polymorphism:	Use polymorphism to allow different implementations of the same interface to behave differently.

(4)Design Patterns:	Use design patterns like Strategy, Decorator, or Factory Method to implement OCP.

Example: Using OCP, we can add new shapes without modifying existing code.
The AreaCalculator class is closed for modification but open for extension.

interface Shape {
    double area();
}

class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

class AreaCalculator { 
    public double calculateArea(Shape shape) {
        return shape.area();
    }
}
```

#### 14. Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be
substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.

1. It mean that if the object of type A can do something, the object of type B could also be able to
perform the same thing
2. It means that all the objects of type A could execute all the methods present in its subtype B
3. It means if a method is present in class A, it should also be present in class B so that the object of
type B could substitute object of type A.
4. It means that for the class B to inherit class A, objects of type B and objects of type A must be same.

```
The answer is 1.
The Liskov Substitution Principle (LSP) states that if class B is a subtype of class A, 
then objects of type A should be replaceable with objects of type B without altering the correctness of the program.

The subclass, Class B must be able to perform all the actions that class A can perform, and it should not introduce any unexpected behavior.
Class B should fully adhere to the contract defined by the superclass, class A.

Any behavior or functionality that class A provides should also be supported by class B.
The subclass should not break the expectations of the superclass.
 
This is important because:
	Consistency: Ensures that subclasses behave in a way that is consistent with the superclass.
	Reusability: Allows code that works with the superclass to also work with the subclass without modification.
	Maintainability: Reduces the risk of introducing bugs when extending or modifying classes.
```

#### 15. Watch the design pattern video, and type the code, submit it to MavenProject folder
singleton: https://www.bilibili.com/video/BV1Np4y1z7BU?p=22
Factory: https://www.bilibili.com/video/BV1Np4y1z7BU?p=35&vd_source=310561eab1216a27f7accf859bf7f6
d9
Builder: https://www.bilibili.com/video/BV1Np4y1z7BU?p=50&vd_source=310561eab1216a27f7accf859bf7f6
d9
Publisher_Subscriber: https://www.bilibili.com/video/BV1Np4y1z7BU?p=114&vd_source=310561eab1216a27f
7accf859bf7f6d9

```
See Coding/hw3
```