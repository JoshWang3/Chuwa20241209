# HW2

---

### 1. Write up Example code to demonstrate the three fundamental concepts of OOP. (reference Code Demode as example)

1. Encapsulation
```java
class Person {
    private String name;
    private int age;
    
    // Getter and setter methods for name
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    // Getter and setter methods for age
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
}
```

2. Polymorphism

```java
class Animal {
    // Overloaded methods
    public void eat() {
        System.out.println("Animal eats food");
    }
    
    public void eat(String food) {
        System.out.println("Animal is eating " + food);
    }
    
    // Method to be overriden by subclasses
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

// subclass
class Dog extends Animal {
    // Overriding method
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}
```

3. Inheritance
```java
class Vehicle {
    protected int speed;
    // Constructor
    public Vehicle(int speed) {
        this.speed = speed;
    }
    
    // Method
    public void move() {
        System.out.println("Vehicle is moving at speed: " + speed);
    }
}

class Car extends Vehicle {
    private String color;
    // Constructor
    public Car(int speed, String color) {
        super(speed);
        this.color = color;
    }
    
    // Method
    public void displayCarColor() {
        System.out.println("Car color: " + color);
    }
    
    // Overriding method
    @Override
    public void move() {
        System.out.println("Car is moving at speed: " + speed);
    }
}
```

### 2. What is wrapper class in Java and Why we need wrapper class?

- Wrapper class provides object representation for primitive types (Integer for int, Float for float, etc.).  
- We need wrapper class because wrapper classes bridge the gap between primitives and objects. For instance, we can 
use primitive types in collections, and we can use wrapper classes to convert primitive types to objects.

### 3. What is the difference between HashMap and HashTable?

- HashMap is not synchronized, while HashTable is synchronized.
- HashMap allows one null key and multiple null values, while HashTable does not allow null key or value.
- HashMap is not thread-safe, while HashTable is thread-safe.

### 4. What is String pool in Java and why we need String pool?

String pool is a storage area in Java heap memory where all the string literals are stored. We need string pool because
it saves memory by reusing the same string literals. For instance, if we create two string objects with the same value,
they will point to the same memory location in the string pool.

### 5. What is Java garbage collection?

Java garbage collection is the process of automatically managing memory in Java. It identifies and removes objects that 
are no longer needed by the program, freeing up memory for other objects. The garbage collector runs in the background 
and automatically cleans up memory by removing unreferenced objects.

### 6. What are access modifiers and their scopes in Java?

Access modifiers control the visibility and accessibility of classes, methods, and fields in Java. There are four types 
of access modifiers in Java: public, protected, default (no modifier), and private. 

- Public: accessible from any class.
- Protected: accessible within the same package and subclasses.
- Default (no modifier): accessible within the same package.
- Private: accessible only within the same class.

### 7. What is `final` key word? (Field, Method, Class)

- Final field: a final field cannot be changed after it is initialized.
- Final method: a final method cannot be overridden by subclasses.
- Final class: a final class cannot be subclassed.

### 8. What is `static` keyword? (Filed, Method, Class). When do we usually use it?

- Static field: a static field belongs to the class itself, not to instances of the class. It is shared among all instances of the class.
- Static method: a static method belongs to the class itself, not to instances of the class. It can be called without creating an instance of the class.
- Static class: a static class is a nested class that is associated with the outer class, not with instances of the outer class.

### 9. What is the differences between overriding and overloading?

- Overriding: Overriding occurs when a subclass provides a specific implementation of a method that is already defined in its superclass. The method 
in the subclass has the same name, return type, and parameters as the method in the superclass.
- Overloading: Overloading occurs when a class has multiple methods with the same name but different parameters. The methods have the same name but different 
signatures (different number or types of parameters).

### 10. What is the differences between super and this?

- Super: super is a keyword in Java that refers to the superclass of the current object. It is used to access superclass methods, fields, and constructors.
- This: this is a keyword in Java that refers to the current object. It is used to access instance variables, methods, and constructors of the current object.

### 11. What is the Java load sequence?

1. Static blocks and static variables are loaded and initialized.
2. Instance variables and instance blocks are loaded and initialized.
3. Constructors are called.

### 12. What is Polymorphism ? And how Java implements it ?

Polymorphism is the ability of an object to take on multiple forms. In Java, polymorphism is achieved through method 
overloading and method overriding. Method overloading allows a class to have multiple methods with the same name but 
different parameters, while method overriding allows a subclass to provide a specific implementation of a method that is 
already defined in its superclass.

### 13. What is Encapsulation ? How Java implements it? And why we need encapsulation?

Encapsulation is the process of bundling data (fields) and methods that operate on the data into a single unit (class). 
In Java, encapsulation is achieved by declaring fields as private and providing public getter and setter methods to access 
and modify the fields. Encapsulation helps to protect the data from unauthorized access and modification, and it also 
promotes code reusability and maintainability.

### 14. What is Interface and what is abstract class? What are the differences between them?

- Interface: An interface in Java is a reference type that can contain only abstract methods, default methods, static methods, and constants. 
- Abstract class: An abstract class in Java is a class that cannot be instantiated and may contain abstract methods, concrete methods, and fields. 
The differences between interface and abstract class are:
- An interface can only contain abstract methods, while an abstract class can contain both abstract and concrete methods.
- A class can implement multiple interfaces, but it can only extend one abstract class.
- An interface can be used to achieve multiple inheritance in Java, while an abstract class cannot.
- Interface means "can do", while abstract class means "is a".

### 15. design a parking lot (put the code to codingQuestions/coding1 folder)

### 16. What are Queue interface implementations and what are the differences and when to use what?

- Commonly used queue interface implementations in Java: LinkedList, PriorityQueue, ArrayDeque.
- Differences:
  - LinkedList: a doubly linked list implementation of the Queue interface. It allows null elements and maintains insertion order.
  - PriorityQueue: a priority queue implementation of the Queue interface. It orders elements based on their natural order or a custom comparator.
  - ArrayDeque: a resizable array implementation of the Queue interface. It allows null elements and provides fast insertion and removal operations.

