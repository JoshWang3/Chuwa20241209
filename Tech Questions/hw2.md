**1. Write up Example code to demonstrate the three foundmental concepts of OOP. (reference Code Demo repo as example)**

	1. Encapsulation
```java
class BankAccount {
    private double balance;
    private String accountNumber;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}
```
	2. Polymorphism
	3. Inheritance
```java
// Inheritance - Parent class
class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public void makeSound() {
        System.out.println("Animal makes sound");
    }
}

// Inheritance - Child classes
class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    // Polymorphism - Method overriding
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}

// Inheritance - Child classes
class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

	// Polymorphism - Method overriding
    @Override
    public void makeSound() {
        System.out.println("Cat meows");
    }
}
```

**2. What is wrapper class in Java and Why we need wrapper class?**

A wrapper class can encapsulate a primitive data type within an object and then primitive values to be treated like objects.
We need wrapper class to use object-oriented features.

**3. What is the difference between HashMap and HashTable?**

HashMap is generally newer, non-synchronized, and allows one null key and multiple null values, 
while Hashtable is older, synchronized, and does not allow any null keys or values.

**4. What is String pool in Java and why we need String pool?**

The String pool is a JVM optimization feature that stores a single copy of each distinct string literal. 
We use it to reduce duplicate String objects, saving memory and improving runtime performance.

**5. What is Java garbage collection?**

It is  an automatic mechanism that saves developers from dealing with manual memory management.

**6. What are access modifiers and their scopes in Java?**

Access modifiers in Java are keywords that determine the visibility and accessibility of classes, methods, and variables.
- public: Accessible everywhere.
- protected: Accessible within the same package and subclasses.
- default (no modifier): Accessible only within the same package.
- private: Accessible only within the same class.

**7. What is final key word? (Filed, Method, Class)**

- final fields: Cannot be reassigned once they have been assigned a value.
- final methods: Cannot be overridden by subclasses.
- final classes: Cannot be subclassed, effectively finalizing behavior.

**8. What is static keyword? (Filed, Method, Class). When do we usually use it?**

- static fields: Shared by all instances; belong to the class.
- static methods: Accessible without an instance; useful for utility functionality.
- static nested classes: Grouped inside another class but without needing an outer instance.

**9. What is the differences between overriding and overloading?**

- Overloading: Multiple methods in the same class with the same name but different parameters.
- Overriding: A subclass provides a different implementation of a method that already exists in its superclass with the same signature.

**10. What is the differences between super and this?**

- `this` refers to the current object and is used within a class to access its own members or to invoke its own constructors.
- `super` refers to the superclass and is used within a subclass to access the superclass’s members or to invoke the superclass’s constructor.

**11. What is the Java load sequence?**

When the JVM needs a class for the first time, it finds the class file, loads it into memory, performs verification and preparation during linking, and then initializes the class’s static blocks and fields before making it available for use.

**12. What is Polymorphism? And how Java implements it?**

Polymorphism allows a single type reference to point to objects of different classes and call the correct method at runtime.
- Method Overriding (Runtime Polymorphism)
- Method Overloading (Compile-Time Polymorphism)

**13. What is Encapsulation? How Java implements it? And why we need encapsulation?**

Encapsulation means bundling data (fields) and the operations on that data (methods) into a single unit (class), and restricting direct access to some of the class’s components.

How Java Implements It:

- By using access modifiers to control what can be seen and modified outside the class.
- By providing getter and setter methods to safely access and update private fields.

Why We Need It:

- To protect data integrity by preventing illegal or unintended changes.
- To hide complexity, making the system easier to understand and maintain.
- To enhance modularity, allowing changes inside a class without affecting code that depends on it.

**14. What is Interface and what is abstract class? What are the differences between them?**

Interface:

- Pure abstract contract with no implementation
- Can have only abstract methods
- Supports multiple inheritance
- Only constants (public static final)
- No constructor

Abstract Class:

- Can have both abstract and concrete methods
- Single inheritance only
- Can have any type of fields
- Can have constructor
- Methods can have any access modifier

**15. design a parking lot (put the code to codingQuestions/coding1 folder)**


**16. What are Queue interface implementations and what are the differences and when to use what?**

1.LinkedList:
- Standard FIFO queue
- Not thread-safe
- Use for simple single-threaded scenarios

2.PriorityQueue:
- Heap-based, orders by priority
- Use when elements need priority processing

3.ArrayDeque:
- More efficient than LinkedList
- Double-ended queue
- Use for better memory usage and performance