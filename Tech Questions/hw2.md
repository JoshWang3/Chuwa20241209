# Homework 2
1. Write up Example code to demonstrate the three fundamental concepts of OOP. (reference Code Demo
   repo as example)
   - Encapsulation:
   ```java
   public class Person {
       private String name;
       private int age;
   
       // Constructor
       public person(String name, Int age) {
           this.name = name;
           this.age = age;
       }
       
       // Setter
       public void setName(String name) {
           this.name = name;
       }
   
       public void setAge(int age) {
           this.age = age;
       }
       
       // Getter
       public void getName() {
           return name;
       }
   
       public void getAge() {
           return age;
       }
   }  
   ```
   - Polymorphism:
     - overriding (runtime polymorphism)
     - overloading (compile polymorphism)
   ```java
   class Animal {
       public void speak() {
           System.out.println("Animal makes sounds!");
       }
   }
   
   class Dog extends Animal {
       @Override 
       public void speak() {
           System.out.println("The dog bark!");
       }    
   }
   
   class Shape {
       public int getArea(int a) {
           return a * a;
       }
       
       public int getArea(int a, int b) {
           return a * b;
       }
   }
   ```
   - Inheritance:
   ```java
   class Vehicle {
       private String brand;
       
       public Vehicle(String brand) {
           this.brand = brand;
       }
   }
   
   class Car extends Vehicle {
       private int doors;
   
       public Car(string brand, int doors) {
           super(brand);
           this.doors = doors;
       }
   }
   ```
2. What is wrapper class in Java and Why we need wrapper class?
   - To wrap primitive data types into an object, Java is an object-oriented language, many features work only with objects.
   - int -> Integer
   - double -> Double
   - char -> Character
3. What is the difference between HashMap and HashTable?
   - HashMap is not thread-safe, faster
   - HashTable is thread-safe, slower due to synchronization overhead
4. What is String pool in Java and why we need String pool?
   - String pool is a memory area where String are stored.
   - Avoid creating duplicates String objects.
5. What is Java garbage collection?
   - Java will do GC automatically. 
6. What are access modifiers and their scopes in Java?
   - default: accessible within the same package
   - private: only accessible within the class
   - public: everyone can access
   - protected: accessible within the same package and subclass
7. What is final key word? (Field, Method, Class)
   - Field: make it a constant, avoid any incorrect change happens
   - Method: prevent overriding
   - Class: prevent inheritance
8. What is static keyword? (Field, Method, Class). When do we usually use it?
   - Field: belong to class, not instances. For example, a global counter
   - Method: Can be called without creating an object. For example, some tools.
   - Class: Inner static class don't need to be instantiated until needed.
9. What is the differences between overriding and overloading?
   - Overriding happens in run time
   - Overloading happens in compile time
10. What is the differences between super and this?
    - super: parent class
    - this: current object
11. What is the Java load sequence?
    - Static blocks and fields
    - Instance blocks and fields
    - Constructor
12. What is Polymorphism ? And how Java implements it ?
    - allow one interface to be used by different types
13. What is Encapsulation ? How Java implements it? And why we need encapsulation?
    - wrapping data into a class to avoid direct access
14. What is Interface and what is abstract class? What are the differences between them?
    - They are like blueprints for classes, abstract class can have implemented methods but interface can't.
15. design a parking lot (put the code to codingQuestions/coding1 folder)
    1. If you have no ability to design it, please find the solution in internet, then understand it, and re-type it.(Do NOT just copy and paste)
16. What are Queue interface implementations and what are the differences and when to use what?
    - Priority Queue: if you need to get min/max of the elements. 
    - LinkedList: basic functionality
    - ArrayDeque: if you need to access from both end