## Write up Example code to demonstrate the three fundamental concepts of OOP. (reference Code Demo repo as example)
 
```java
// Encapsulation
class Person {
    private String name; // Private variable
    private int age; // Private variable

    // Public getter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Public setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Age cannot be negative.");
        }
    }
}

// Polymorphism
class Animal {
  public void animalSound() {
    System.out.println("The animal makes a sound");
  }
}

class Pig extends Animal {
  public void animalSound() {
    System.out.println("The pig says: wee wee");
  }
}

class Dog extends Animal {
  public void animalSound() {
    System.out.println("The dog says: bow wow");
  }
}

class Main {
  public static void main(String[] args) {
    Animal myAnimal = new Animal();  // Create an Animal object
    Animal myPig = new Pig();  // Create a Pig object
    Animal myDog = new Dog();  // Create a Dog object
    myAnimal.animalSound();
    myPig.animalSound();
    myDog.animalSound();
  }
}

// Inheritance
class Animal {
  public void animalSound() {
    System.out.println("The animal makes a sound");
  }
}

class Pig extends Animal {
  public void animalSound() {
    System.out.println("The pig says: wee wee");
  }
}

class Dog extends Animal {
  public void animalSound() {
    System.out.println("The dog says: bow wow");
  }
}
```
## What is wrapper class in Java and Why we need wrapper class?
    Wrapper classes are object representations of primitive types.
    Wrapper classes provide static methods. Wrapper classes allow automatic conversion between primitives and objects. Collections can only store wrapper class objects, not primitives.
## What is the difference between HashMap and HashTable?
    HashMap is not thread safe while HashTable is thread safe.
    HashMap allows one null key and multiple null values; HashTable does not all null keys or values.
## What is String pool in Java and why we need String pool?
    String Constant Pool is a special memory area in the Heap where String literals are stored in Java. 
    It reuses the same string so avoids creating duplicate objects, optimize memory usage and improve performance when working with Strings.
## What is Java garbage collection?
    Garbage collection automatically deletes objects that are on longer reachable to clear memory space.
## What are access modifiers and their scopes in Java?
    Access modifiers define the visibility or scope of classes, methods, variables, and constructors.
                Class	Same Package	Subclass (Different Package)	Everywhere
    public	    Y	    Y	            Y	                            Y
    protected	Y	    Y	            Y	                            N
    default	    Y	    Y	            N	                            N
    private	    Y	    N	            N	                            N
## What is final key word? (Filed, Method, Class)
    A modifier to impose restrictions on fields, methods, and classes.
    A final variable can be assigned only once, constant and cannot be changed.
    A final method cannot be overridden by subclasses.
    A final class cannot be extended.
## What is static keyword? (Filed, Method, Class). When do we usually use it?
    A modifier, if used then the memory for static members is allocated once at the class level and shared among all objects.
    1. A static variable is shared across all instances of a class, allocated only once during class loading.
    2. A static method belongs to the class and not to an object, can be called without creating an object of the class.
    3. A static nested class is a class declared inside another class using the static keyword, and does not have access to the instance variables or methods of the outer class.
    4. A static block is used to initialize static variables or execute code during class loading, and runs only once when the class is loaded into memory.
## What is the differences between overriding and overloading?
    1. Overriding: Runtime; Subclass provides a specific implementation of a method declared in its superclass.
    2. Overloading: Compile-time; Same method name with different parameters.
## What is the differences between super and this?
    1. Super: used in a derived (child) class to refer to the parent class.
    2. this: used to refer to the current class instance.
## What is the Java load sequence?
    It describes the process by which a class is loaded, initialized, and executed in memory. 
    It has severay stages:
    1. Loading: The class is loaded into memory by the Class Loader. The bytecode of the class (from the .class file) is read and converted into the method area.
    2. Linking: Connects the class bytecode with the JVM. Bytecode is verified, static variables are initialized to default values, and resolved.
    3. Initialization: happens only once per class and when the class is first used; Static blocks and static variables are executed.
    4. Object Instantiation: when creating objects using the new keyword, and constructors initialize the object.
## What is Polymorphism ? And how Java implements it ?
    The ability of an object to take on many forms. 
    It allows a single interface to represent different types, or when a super class references a sub class object.
    Compile-time (Method Overloading): Same method name with different parameters.
    Runtime (Method Overriding): Subclass provides a specific implementation of a method declared in its superclass.
```java
// Polymorphism
class Animal {
  public void animalSound() {
    System.out.println("The animal makes a sound");
  }
}

class Pig extends Animal {
  public void animalSound() {
    System.out.println("The pig says: wee wee");
  }
}

class Dog extends Animal {
  // run time Polymorphism  
  public void animalSound() {
    System.out.println("The dog says: bow wow");
  }
  
  // Compile time Polymorphism
  public String animalSound(String sound) {
        System.out.println("The dog says: " + sound);
        return "The dog says: " + sound;
    }
}

class Main {
  public static void main(String[] args) {
    Animal myAnimal = new Animal();  // Create an Animal object
    Animal myPig = new Pig();  // Create a Pig object
    Animal myDog = new Dog();  // Create a Dog object
    myAnimal.animalSound();
    myPig.animalSound();
    myDog.animalSound();
  }
}
```
## What is Encapsulation ? How Java implements it? And why we need encapsulation?
    Wrapping data (fields) and methods that operate on the data within a single unit (class). 
    It restricts direct access to some of an object's components for security and simplicity.
    Use private access modifiers to hide fields.
    In order to access private states safely, we have to provide public getter and setter methods
```java
// Encapsulation
class Person {
    private String name; // Private variable
    private int age; // Private variable

    // Public getter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Public setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Age cannot be negative.");
        }
    }
}
```
## What is Interface and what is abstract class? What are the differences between them?
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
## design a parking lot
    see holder Coding/hw20/parking_lot
## What are Queue interface implementations and what are the differences and when to use what?
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