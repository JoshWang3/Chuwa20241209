### Short Questions

#### 1. Write up Example code to demonstrate the three foundmental concepts of OOP. (reference Code Demo repo as example)  

~~~java
// Encapsulation:
class Shape {
    private String color; 
    public Shape(String color) {this.color = color;}
    public String getColor() {return color;}
    public void setColor(String color) {this.color = color;}
    public double calculateArea() {return 0;} 
// Inheritance:
class Circle extends Shape {
    private double radius;
    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }
    public double getRadius() {return radius;}
    public void setRadius(double radius) {this.radius = radius;}
    @Override
    public double calculateArea() {return Math.PI * radius * radius;}  
// Polymorphism:
class Rectangle extends Shape {
    private double length, width;
    public Rectangle(String color, double length, double width) {
        super(color);
        this.length = length;
        this.width = width;
    }
	@Override
    public double calculateArea() {return length * width;}
}
public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle("Red", 5.0);
        Shape rectangle = new Rectangle("Green", 4.0, 6.0);
        circle.calculateArea();
        rectangle.calculateArea();
    }
}
~~~

#### 2. What is wrapper class in Java and Why we need wrapper class?    

```
An object representation of primitive data types.
Why? 
1. when object is required to interact with Java libraries or frameworks like Collections cannot store primitive types directly; 
2. when we need utility methods for parsing, conversion, and handling primitives like Integer.parseInt(String s)
3. when we want to allow null values like Integer x = null
```

#### 3. What is the difference between HashMap and HashTable?  

```
HashMap is not thread-safe, faster, extends AbstractMap and implements the Map interface and allows one null key and multiple null values.
Hashtable is Synchronized (thread-safe), slower, extends the Dictionary class and implements the Map interface, does not allow null keys or values and deprecated. 
```

#### 4. What is String pool in Java and why we need String pool?  

```
String Constant Pool is a special memory area in the Heap where String literals are stored in Java. 
It reuses the same string so avoids creating duplicate objects, optimize memory usage and improve performance when working with Strings.
```

#### 5. What is Java garbage collection?    

```
It is the process of automatically identifying and removing unused objects from memory to free up resources and prevent memory leaks. JVM manages object lifecycle. If objects are unreachable, they are flagged for GC.
```

#### 6. What are access modifiers and their scopes in Java?    

```
Access modifiers define the visibility or scope of classes, methods, variables, and constructors.
```

|           | Class | Same Package | Subclass (Different Package) | Everywhere |
| --------- | ----- | ------------ | ---------------------------- | ---------- |
| public    | Y     | Y            | Y                            | Y          |
| protected | Y     | Y            | Y                            | N          |
| default   | Y     | Y            | N                            | N          |
| private   | Y     | N            | N                            | N          |

#### 7. What is final key word? (Filed, Method, Class)   
```
A modifier to impose restrictions on fields	, methods, and classes.
A final variable can be assigned only once, constant and cannot be changed.
A final method cannot be overridden by subclasses.
A final class cannot be extended.
```

#### 8. What is static keyword? (Filed, Method, Class). When do we usually use it?  

```
A modifier, if used then the memory for static members is allocated once at the class level and shared among all objects.
1. A static variable is shared across all instances of a class, allocated only once during class loading.
2. A static method belongs to the class and not to an object, can be called without creating an object of the class.
3. A static nested class is a class declared inside another class using the static keyword, and does not have access to the instance variables or methods of the outer class.
4. A static block is used to initialize static variables or execute code during class loading, and runs only once when the class is loaded into memory.
```

#### 9. What is the differences between overriding and overloading?  

```
Method Overloading: Compile-time; Same method name with different parameters.
Method Overriding: Runtime; Subclass provides a specific implementation of a method declared in its superclass.
```

#### 10. What is the differences between super and this?  

```
this keyword is used to refer to the current class instance.
It is used to differentiate between instance variables and method parameters with the same name, or to call another constructor of the same class, or to pass the current object as an argument.

super keyword is used in a derived (child) class to refer to the parent class.
It is used to access parent class fields or methods when they are overridden in the subclass, or to call the parent class constructor, or to differentiate between parent and child class members when there is a naming conflict.
```

#### 11. What is the Java load sequence?  

```
It describes the process by which a class is loaded, initialized, and executed in memory. 
It has severay stages:
1. Loading: The class is loaded into memory by the Class Loader. The bytecode of the class (from the .class file) is read and converted into the method area.
2. Linking: Connects the class bytecode with the JVM. Bytecode is verified, static variables are initialized to default values, and resolved.
3. Initialization: happens only once per class and when the class is first used; Static blocks and static variables are executed.
4. Object Instantiation: when creating objects using the new keyword, and constructors initialize the object.
```

#### 12. What is Polymorphism ? And how Java implements it ?  

```
The ability of an object to take on many forms. 
It allows a single interface to represent different types, or when a super class references a sub class object.
Compile-time (Method Overloading): Same method name with different parameters.
Runtime (Method Overriding): Subclass provides a specific implementation of a method declared in its superclass.
```

```java
// Compile-time polymorphism
	int add(int a, int b, int c) {
        return a + b + c;
    }
    double add(double a, double b) {
        return a + b;
    }
```

```java
// Runtime polymorphism
class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}
class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}
public class Main {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        Animal myCat = new Cat();
        myDog.sound(); // Dog barks
        myCat.sound(); // Cat meows
    }
}
```

#### 13. What is Encapsulation ? How Java implements it? And why we need encapsulation?  
```
Wrapping data (fields) and methods that operate on the data within a single unit (class). It restricts direct access to some of an object's components for security and simplicity.
Use private access modifiers to hide fields.
In order to access private states safely, we have to provide public getter and setter methods
```

```java
class Shape {
    private String color; 
    public Shape(String color) {this.color = color;}
    public String getColor() {return color;}
    public void setColor(String color) {this.color = color;}
    public double calculateArea() {return 0;} 
```

#### 14. What is Interface and what is abstract class? What are the differences between them?  

```
Abstract Class:
Represents a common base with shared code for related classes.
Used when classes share common behavior or state and a hierarchical relationship.
Can have abstract methods and concrete methods.
Can have instance variables (with or without initialization). Allows access modifiers (e.g., private, protected).
A class can inherit only one abstract class.

Interface:
Defines a contract or capability that a class must implement. usually across unrelated classes. For defining APIs or extending multiple behaviors.
Focuses on what a class should do (not how).
All methods are abstract by default (until Java 7). Since Java 8, supports default and static methods with implementation.
Only constants (static and final by default).
A class can implement multiple interfaces (multiple inheritance).
```

#### 15. design a parking lot (put the code to codingQuestions/coding1 folder, )  

#### 16. What are Queue interface implementations and what are the differences and when to use what?  

```
1. LinkedList implements both the Queue and Deque interfaces, meaning it can be used as a queue (FIFO) or a deque (double-ended queue).
offer(E e) – Inserts the element at the end of the queue.
poll() – Retrieves and removes the front element of the queue.
peek() – Retrieves the front element without removing it.
when: need to implement a queue with fast insertion and removal from both ends.

2. PriorityQueue implements Queue that stores elements in a priority order.
offer(E e) – Adds an element to the queue, ensuring it maintains priority order.
poll() – Retrieves and removes the element with the highest priority.
peek() – Retrieves but does not remove the element with the highest priority.
when: need to process elements based on priority rather than the order in which they were added.

ArrayBlockingQueue/LinkedBlockingQueue/ConcurrentLinkedQueue/PriorityBlockingQueue: thread-safe
```

