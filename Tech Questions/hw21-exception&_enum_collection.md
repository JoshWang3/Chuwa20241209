## Practice Problem
    See coding folder: Coding/hw21/collection
## What is the checked exception and unchecked exception in Java, could you give one example?
    Checked Exceptions: are exceptions that are checked at compile-time. This means the compiler verifies whether the code handles these exceptions, either by catching them using a try-catch block or by declaring them using throws. -- IOException, FileNotFoundException, SQLException
    Unchecked Exceptions: are exceptions that are not checked at compile time. -- NullPointerException, ArrayIndexOutOfBoundException.
## Can there be multiple finally blocks?
    No. You can have multiple catch blocks. But only one finally block is allowed.
## When both catch and finally return values, what will be the final result?
    The returned value is from the finally block.
## What is Runtime/unchecked exception? what is Compile/Checked Exception?
    Runtime or Unchecked Exception: in Java is something that has gone wrong with the program and is unrecoverable. -- NullPointerException
    Compile or Checked Exception: is exception that occurs during the compilation phase before th program is executed. -- IOException
## What is the difference between throw and throws?
    throw:
	    purpose: used to explicitly throw an exception within a method or block of code. 
        e.g. 
```java 
    throw new Exception("Error Message")
```
    throws:
        purpose: used in the method signature to declare that the method might throw a specific exception. 
        e.g. 
```java 
public void someMethod() throw IOException {
}
```
## Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception ?
    Exception is the father of all other exceptions. Putting the Null/Runtime exception before Exception will let the program catch specific exceptions before Exception.
## What is optional? why do you use it? write an optional example. 
    Define:
        represents a value which may or may not be present, essentially allowing you to explicitly handle cases where a value could be "null" without needing to constantly check for it. It helps prevent NullPointerExceptions by providing methods to gracefully handle the empty state.
    Example:
```java 
public Optional<String> getUserName(User user) {
    if (user != null) {
		return Optional.of(user.getName());
    } else {
        return Optional.empty();
	}
}

Optional<String> name = getUserName(currentUser);

if (name.isPresent()) String userName = name.get();
else // handle the case where user is null;
```
## Why finally always be executed ? 
    The finally block always executes when the try block exists. This ensures that the finally block is executed even if an unexpected exception occurs.
## Practice collection problems.
    See coding folder: Coding/hw21/collection
## What are the types of design patterns in Java ? 
    Creational: Focuses on how objects are created. -- Singleton, prototype, builder, factory_method, abstract_factory.
    Structural: Focuses on how classes and objects are composed to form larger structures. -- proxy, flyweight, facade, composite, bridge, adapter.
    Behavioral: Focuses on how objects interact and communicate with each other. -- chain_of_responsibility, command, observer, state, strategy, visitor, template_method, memento, iterator, mediator.
## What are the SOLID Principles ? 
    The SOLID principles are five essential guidelines that enhance software design, making code more maintainable and scalable. They include:
    1. Single Responsibility Principle: this principle states that "A class should have only one reason to change" which means every class should have a single responsibility or single job or single purpose.
    2. Open/Closed Principle: this principle states that "Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification" which means you should be able to extend a class behavior, without modifying it.
    3. Liskov's Substitution Principle: this principle stats that "Derived or child classes must be substitutable for their base or parent classes". This principle ensures that any class that is the child of a parent class should be usable in place of its parent without any unexpected behavior.
    4. Interface Segregation Principle: this principle states that "do not force any client to implement an interface which irrelevant to them".
    5.Dependency Inversion Principle: this principle states that "High-level modules should not depend on low-level modules. Both should depend on abstractions". In simpler terms, the DIP suggests that classes should rely on abstractions (e.g., interfaces or abstract classes) rather than concrete implementations.
    The SOLID principle helps in reducing tight coupling.
## How can you achieve thread-safe singleton patterns in Java ? 
    Eager Initialization:
    -- the instance is created when the class is loaded, ensuring thread safety.
    e.g.,
```java 
public class EagerSingleton {
private static final EagerSingleton INSTANCE = new EagerSingleton();
private EagerSingleton() {}

	public static EagerSingleton getInstance() {
		return INSTANCE;
	}
}
```
    Lazy Initialization:
    --the instance is created only when it's first requested.
    e.g.,
```java 
public class LazySingleton {
private static LazySingleton instance;
private LazySingleton() {}

	public static LazySingleton getInstance() {
		if (instance == null) {
			instance = new LazySingleton();
		}	
		return instance;
	}
}
```
## What do you understand by the Open-Closed Principle (OCP) ?
    Open/Closed Principle: this principle states that "Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification" which means you should be able to extend a class behavior, without modifying it.
## Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.
     A. It mean that if the object of type A can do something, the object of type B could also be able to perform the same thing
     B. It means that all the objects of type A could execute all the methods present in its subtype B 
     C. It means if a method is present in class A, it should also be present in class B so that the object of type B could substitute object of type A.
     D. It means that for the class B to inherit class A, objects of type B and objects of type A must be same.
     -- C
## Watch the design pattern video, and type the code, submit it to MavenProject folder.
    1. singleton: https://www.bilibili.com/video/BV1Np4y1z7BU?p=22
    2. Factory: https://www.bilibili.com/video/BV1Np4y1z7BU?p=35&vd_source=310561eab1216a27f7accf859bf7f6d9
    3. Builder: https://www.bilibili.com/video/BV1Np4y1z7BU?p=50&vd_source=310561eab1216a27f7accf859bf7f6d9
    4. Publisher_Subscriber: https://www.bilibili.com/video/BV1Np4y1z7BU?p=114&vd_source=310561eab1216a27f7accf859bf7f6d9