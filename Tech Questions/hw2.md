### HW2: Java Core

#### 1. Write up Example code to demonstrate the three foundmental concepts of OOP. (reference Code Demo repo as example)
	1. Encapsulation;
	2. Polymorphism;
	3. Inheritance;

```
1, Encapsulation hides internal details and provides controlled access to data.
It is the mechanism of wrapping data (variables) and code (methods) together as a single unit.
It also restricts direct access to some of an object's components.
It is achieved using access modifiers, such as private, protected, public.

2, Inheritance allows a class to inherit properties and behaviors from another class.
It promotes code reusability and establishes a relationship between the parent (superclass) and child (subclass) classes.
	
	class Animal {	// Superclass
		void eat() {
			System.out.println("This animal eats food.");
		}
	}

	
	class Dog extends Animal {	// Subclass inheriting from Animal
		void bark() {
			System.out.println("The dog barks.");
		}
	}

	public class InheritanceExample {
		public static void main(String[] args) {
			Dog dog = new Dog();
			dog.eat();  // Inherited method from Animal
			dog.bark(); // Method from Dog class
		}
	}


3, Polymorphism
Polymorphism allows objects of different classes to be treated as objects of a common superclass. 
It can be achieved through method overriding (runtime polymorphism) or method overloading (compile-time polymorphism).

Runtime Polymorphism = Method Overriding (decided at runtime based on actual object type).
Compile-time Polymorphism = Method Overloading (decided at compile-time based on method signature).


```

####  3, Polymorphism enables objects of different classes to be treated as objects of a common superclass.

```
In Java, it allows it allows a single interface.
There are two types of polymorphism in Java:
1,Compile-Time Polymorphism (Method Overloading):
	Achieved by defining multiple methods with the same name but different parameters in the same class.
	The method to be executed is determined at compile time based on the method signature.

2, 	Runtime Polymorphism (Method Overriding):
	Achieved by overriding a method in a subclass that is already defined in its superclass.
	The method to be executed is determined at runtime based on the actual object type.

```

#### 2. What is wrapper class in Java and Why we need wrapper class?

```
In Java, a wrapper class is a class that encapsulates (wraps) a primitive data type (e.g., int, char, boolean) into an object.

Primitive Type	Wrapper Class
byte		Byte
short		Short
int			Integer
long		Long
float		Float
double		Double
char		Character
boolean		Boolean

We need wrapper class for these reasons:
1. Wrapper classes are essential for using primitive types in object-oriented contexts.	
	Wrapper classes wrap primitive types into objects.
2, They provide utility methods, support null values, and enable features like collections and generics.
	They are used in collections, provide utility methods, support null values, and enable object-oriented features.
3, Autoboxing and unboxing make it easy to convert between primitives and wrapper classes.
```

#### 3. What is the difference between HashMap and HashTable?

```

Feature				HashMap											Hashtable
Synchronization	Not synchronized (not thread-safe).					Synchronized (thread-safe).
Null Keys/Values	Allows one null key and multiple null values.	Does not allow null keys or values.
Legacy	Part of the Java Collections Framework (modern).			Legacy class (outdated).
Iterator			Fail-fast.										Not fail-fast.
Performance			Faster.											Slower due to synchronization.
Inheritance			Extends AbstractMap.							Extends Dictionary.
Use Cases			Single-threaded applications.					Legacy code or thread-safe scenarios (rarely used).
```

#### 4. What is String pool in Java and why we need String pool?

```
The String Pool is a special memory area in the Java heap where String literals are stored. 
It is a mechanism used by Java to optimize memory usage and improve performance by reusing immutable String objects.

When you create a String using a literal, String s = "hello", Java checks the String Pool to see if an identical String already exists. 
If it does, the existing String object is reused. If not, a new String object is created and added to the pool.

We need String pool for these reasons:
1, Memory Efficiency:
Strings are immutable in Java, meaning their values cannot be changed after creation.
By reusing String objects from the pool, Java avoids creating multiple objects with the same value, saving memory.

2, Performance Improvement:
Reusing String objects reduces the overhead of creating new objects and garbage collecting unused ones.
String comparison using == is faster for pooled strings because it checks references rather than content.

3, Encourages Immutability:
The String Pool works because String objects are immutable. If String objects were mutable, reusing them could lead to unexpected behavior.

String s1 = "hello"; // "hello" is added to the String Pool
String s2 = "hello"; // Reuses the same "hello" from the String Pool
System.out.println(s1 == s2); // true (both refer to the same object in the pool)

String s3 = new String("hello"); // Creates a new object in the heap
String s4 = new String("hello"); // Creates another new object in the heap
System.out.println(s3 == s4); // false (different objects)

intern() can add a String to the pool.
String s5 = new String("hello").intern(); // Adds "hello" to the pool (if not already present)
String s6 = "hello"; // Reuses the same "hello" from the pool
System.out.println(s5 == s6); // true (both refer to the same object in the pool)
```

#### 5. What is Java garbage collection?

```
Java Garbage Collection is an automatic memory management process that helps in reclaiming memory by identifying and removing objects 
that are no longer in use by the application. 

It is a key feature of the Java Runtime Environment (JRE) that ensures efficient memory utilization and prevents memory leaks.

Java Garbage Collection Works like this:
	Object Creation: 
		When we create an object in Java, it is allocated memory in the heap.
	Object Usage: 
		The object is used by the application as long as it is reachable (i.e., referenced by other objects or variables).
	Unreachable Objects: 
		When an object is no longer referenced by any part of the application, it becomes unreachable and eligible for garbage collection.
	Garbage Collection Process: 
		The garbage collector identifies and removes these unreachable objects, freeing up memory for future use.

Benefits of Garbage Collection:
	Automatic Memory Management: 
		Developers don’t need to manually allocate or deallocate memory.
	Prevents Memory Leaks: 
		Unused objects are automatically cleaned up.
	Improves Application Stability: 
		Reduces the risk of out-of-memory errors.
```

#### 6. What are access modifiers and their scopes in Java?

```
1. public
Scope: The public access modifier has the widest scope. 
A public class, method, constructor, or field can be accessed from any other class in the same package or from a different package.

2, protected
Scope: The protected access modifier allows access within the same package and by subclasses (even if they are in different packages).

3, default (Package-Private)
Scope: If no access modifier is specified, it is considered default (package-private). 
A default class, method, constructor, or field can only be accessed within the same package.

4, private
Scope: The private access modifier has the narrowest scope. 
A private method, constructor, or field can only be accessed within the same clas.

Access Modifier	|Same Class	|Same Package  | Subclasses (Inheritance)   |	Different Package
	public			Yes			Yes				Yes								Yes
	protected		Yes			Yes				Yes								No
	default			Yes			Yes				No								No
	private			Yes			No				No								No

Use cases:
Use private for encapsulation: 			Hide internal implementation details and expose only necessary methods/fields.
Use public for APIs: 					Expose methods/fields that are part of the public interface.
Use protected for inheritance: 			Allow subclasses to access or override methods/fields.
Use default for package-level access: 	Restrict access to classes within the same package.
```

#### 7. What is final key word? (Filed, Method, Class)

```
The final keyword in Java is used to restrict the modification of classes, methods, and variables.

1, final variables: 
	Must be initialized either at the time of declaration or in the constructor (for instance variables). 
	Once assigned, their value cannot be changed.

2, final methods: 
	Cannot be overridden in subclasses, ensuring consistent behavior.

3, final classes: 
	Cannot be extended, making them immutable in terms of inheritance.

4, Use Cases:
Immutability: Use final to create immutable objects (e.g., String class in Java is final).
Constants: Use final for constants that should not change during the program's execution.
Security: Prevent subclassing or method overriding to ensure the integrity of critical classes or methods.
Performance: The final keyword can sometimes help the compiler optimize code.

```

#### 8. What is static keyword? (Filed, Method, Class). When do we usually use it?

```
The static keyword in Java is used to define class-level members, such as fields, methods, and nested classes, that belong to the class itself 
rather than to any specific instance of the class.

It means that static members are shared across all instances of the class and can be accessed without creating an object of the class.

Use cases are:
	Constants: Use static fields for constants: public static final double PI = 3.14159;
	Utility Methods: Use static methods for utility functions that do not depend on instance-specific data.  Math.sqrt()
	Shared Data: Use static fields for data that needs to be shared across all instances of a class, such as counters, caches
	One-Time Initialization: Use static blocks for complex initialization of static fields.
	Nested Classes: Use static nested classes for grouping related classes or creating utility classes.

Key points are:
	Accessing static Members: Use the class name to access static fields and methods, (e.g., ClassName.staticField).
	No this Reference: static methods cannot use this or super because they do not operate on instance-specific data.
	Memory Efficiency: static members are stored in a single memory location, making them memory-efficient for shared data.
```

#### 9. What is the differences between overriding and overloading?

```
1, Method overriding occurs when a subclass provides a specific implementation of a method that is already defined in its superclass. 
It is used to achieve runtime polymorphism.
@Override is commonly used.

Same Method Signature: 
	The method in the subclass must have the same name, return type, and parameters as the method in the superclass.
Access Modifier: 
	The overriding method cannot have a more restrictive access modifier than the overridden method. 
Runtime Binding: 
	The method to be executed is determined at runtime based on the object's type (dynamic polymorphism).

2, Method overloading occurs when multiple methods in the same class have the same name but different parameters. 
It is used to achieve compile-time polymorphism.

Same Class: 
	Overloading happens within the same class.
Different Parameters: 
	The methods must have different parameter lists (different number of parameters, different types, or both).
Return Type: 
	The return type can be the same or different, but it does not affect overloading.
Compile-Time Binding: 
	The method to be executed is determined at compile time based on the method signature.

3, Use cases:
	Use Overriding:
		When you want to provide a specific implementation of a method in a subclass.
		When you need runtime polymorphism (e.g., calling a subclass method using a superclass reference).
	
	Use Overloading:
		When you want to define multiple methods with the same name but different parameters.
		When you need compile-time polymorphism (e.g., providing multiple ways to perform a task).
```

#### 10. What is the differences between super and this?

```
Feature						this																		super
Refers To				Current instance of the class.												Superclass (parent class) of the current object.
Usage in Constructors	Calls another constructor in the same class (this()).						Calls the superclass constructor (super()).
Accessing Members	Accesses instance variables, methods, and constructors of the current class.	Accesses superclass fields, methods, and constructors.
Purpose	Resolves ambiguity between instance variables and parameters, enables constructor chaining.	Accesses superclass members, enables constructor chaining in inheritance.
First Statement Rule	Must be the first statement in a constructor (if used).						Must be the first statement in a constructor (if used).

Use case:
Use this:
	To resolve ambiguity between instance variables and parameters.
	To call another constructor in the same class (constructor chaining).
	To pass the current object as a parameter.

Use super:
	To access superclass members (fields, methods, or constructors).
	To call the superclass constructor from the subclass constructor.
```

#### 11. What is the Java load sequence?

```
The load sequence can be divided into two main phases:
	Class Loading and Initialization (when the class is first loaded into memory).
	Object Instantiation and Initialization (when an object of the class is created).

1. Class Loading and Initialization
When a class is first referenced in a program, the JVM loads the class into memory and initializes its static components.
This phase occurs only once per class.

2. Object Instantiation and Initialization
When an object of a class is created using the new keyword, the JVM initializes the instance components of the class.

Steps in Object Instantiation and Initialization:
	Memory Allocation:
		Memory is allocated for the object's instance variables.
	Default Initialization:
		Instance variables are initialized to their default values (e.g., 0, null, false).
	Instance Initialization Blocks:
		Instance blocks ({}) are executed in the order they appear in the class.
	Constructor Execution:
		The constructor is executed to complete the object initialization.
```

#### 12. What is Polymorphism ? And how Java implements it ?

```
Polymorphism allows objects of different classes to be treated as objects of a common superclass.
Two types:
	Compile-Time Polymorphism is achieved through method overloading.
	Runtime Polymorphism is achieved through method overriding and dynamic method dispatch.
Polymorphism promotes code reusability, flexibility, and simplicity in Java programs.


How Java Implements Polymorphism
1. Compile-Time Polymorphism (Method Overloading)
	Method overloading allows multiple methods in the same class to have the same name but different parameters.

	class Calculator {
		// Method 1: Adds two integers
		int add(int a, int b) {
			return a + b;
		}

		// Method 2: Adds three integers (overloaded)
		int add(int a, int b, int c) {
			return a + b + c;
		}

		// Method 3: Adds two doubles (overloaded)
		double add(double a, double b) {
			return a + b;
		}
	}

	public class Main {
		public static void main(String[] args) {
			Calculator calc = new Calculator();
			System.out.println(calc.add(5, 10)); // Calls Method 1, Output: 15
			System.out.println(calc.add(5, 10, 15)); // Calls Method 2, Output: 30
			System.out.println(calc.add(5.5, 10.5)); // Calls Method 3, Output: 16.0
		}
	}


2, Runtime Polymorphism (Method Overriding)
Method overriding allows a subclass to provide a specific implementation of a method that is already defined in its superclass. 
The method to be executed is determined at runtime based on the object's type.

	class Animal {
		void makeSound() {
			System.out.println("Animal makes a sound");
		}
	}

	class Dog extends Animal {
		@Override
		void makeSound() { // Overriding the makeSound method
			System.out.println("Dog barks");
		}
	}

	class Cat extends Animal {
		@Override
		void makeSound() { // Overriding the makeSound method
			System.out.println("Cat meows");
		}
	}

	public class Main {
		public static void main(String[] args) {
			Animal myDog = new Dog(); // Polymorphism
			Animal myCat = new Cat(); // Polymorphism

			myDog.makeSound(); // Output: Dog barks (runtime binding)
			myCat.makeSound(); // Output: Cat meows (runtime binding)
		}
	}

3,Benefits of Polymorphism are:
	Code Reusability:
		Polymorphism allows you to write generic code that works with objects of different classes.
	Flexibility:
		You can extend functionality by adding new subclasses without modifying existing code.
	Simplified Code:
		A single interface can be used to represent multiple forms, making the code easier to understand and maintain.

```

#### 13. What is Encapsulation ? How Java implements it? And why we need encapsulation?

```
Encapsulation hides the internal details of how an object works and exposes only what is necessary through a well-defined interface.

Java implements encapsulation using access modifiers and getter/setter methods.

1. Access Modifiers
Java provides four access modifiers to control the visibility of class members (fields, methods, constructors):
By marking fields as private, you prevent direct access from outside the class.

2. Getter and Setter Methods
To allow controlled access to private fields, Java uses getter (accessor) and setter (mutator) methods. 
These methods provide a way to read and modify the values of private fields while enforcing validation or constraints.

We need Encapsulation for these reasons:
1, data Binding
2, control over data
3, Improved Maintainability
4, Enhanced Security
5, Code Reusability
```

#### 14. What is Interface and what is abstract class? What are the differences between them?

```
1, Interface:
An interface in Java is a reference type that defines a contract for classes to implement.
It contains abstract methods (methods without a body) and constants (static final variables).
Interfaces are used to achieve abstraction and multiple inheritance in Java.

	Defines a contract with abstract methods and constants.
	Supports multiple inheritance.
	Cannot have constructors or instance variables.
	
Abstract Methods:
	All methods in an interface are implicitly public and abstract (no implementation).
Constants:
	All variables in an interface are implicitly public, static, and final.
No Constructors:
	Interfaces cannot have constructors because they cannot be instantiated directly.
A class can implement multiple interfaces.
Interfaces can have default methods (with implementation) and static methods.

2, Abstract Class:
An abstract class in Java is a class that cannot be instantiated directly. 
It is used as a blueprint for other classes and can contain both abstract methods (without implementation) 
and concrete methods (with implementation).

	Provides a common base for subclasses with both abstract and concrete methods.
	Supports single inheritance.
	Can have constructors, instance variables, and static variables.

	Abstract Methods:
		Abstract methods have no body and must be overridden by subclasses.
	Concrete Methods:
		Abstract classes can have fully implemented methods.
	Constructors:
		Abstract classes can have constructors, which are called when a subclass is instantiated.
	Fields:
		Abstract classes can have instance variables, static variables, and constants.
	Single Inheritance:
		A class can extend only one abstract class.
	
Use cases:
Use an Interface When we want to:
	define a contract that multiple unrelated classes can implement.
	achieve multiple inheritance.
	define a behavior that can be shared across different class hierarchies.
	provide default implementations for methods (using default methods).

Use an Abstract Class When we want to:
	Share code among related classes.
	Define a common base class with some implemented methods.
	Provide a default implementation for some methods while leaving others abstract.
	Define non-static or non-final fields.
```

#### 15. design a parking lot (put the code to codingQuestions/coding1 folder, )
1. If you have no ability to design it, please find the solution in internet, then understand it, and re-type it.(Do NOT just copy and paste)

```
See Coding/hw2/

```

#### 16. What are Queue interface implementations and what are the differences and when to use what?

```
The Queue interface in Java is part of the java.util package and represents a collection designed for holding elements prior to processing. 
It follows the FIFO (First-In-First-Out) principle, meaning the first element added is the first one to be removed.

1, LinkedList:  A doubly-linked list implementation of the Queue interface.
	Allows null elements.
	Not thread-safe.
	Supports all queue operations (e.g., add, remove, peek).
Use Case:
	When we need a simple, flexible, and non-thread-safe queue.
	Suitable for small to medium-sized queues.

2, PriorityQueue:  A priority-based queue where elements are ordered based on their natural ordering or a custom comparator.
	Does not allow null elements.
	Not thread-safe.
	Elements are retrieved in sorted order (not FIFO).
Use case:
	When need to process elements based on priority.

3, ArrayDeque:	A resizable-array implementation of the Deque interface, which extends Queue.
	Does not allow null elements.
	Not thread-safe.
	Faster than LinkedList for most operations.
	Supports both FIFO and LIFO (stack) operations.

Use Case:
	When need a high-performance, non-thread-safe queue or stack.

4, USe cases:
	LinkedList:
		Use for simple, non-thread-safe queues.
		Suitable for small to medium-sized queues.
	PriorityQueue:
		Use when elements need to be processed based on priority.
		Suitable for task scheduling or priority-based systems.
	ArrayDeque:
		Use for high-performance queues or stacks.
		Suitable for scenarios requiring both FIFO and LIFO operations.

5, Comparison:
Implementation		Thread-Safe			Null Allowed	Blocking	Ordering			Use Case
LinkedList				No				Yes				No			FIFO				Simple, non-thread-safe queues.
PriorityQueue			No				No				No			Sorted (priority)	Priority-based processing.
ArrayDeque				No				No				No			FIFO/LIFO			High-performance queues or stacks.
```