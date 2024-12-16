### 1. Write up Example code to demonstrate the three foundmental concepts of OOP. (reference Code Demode as example)

```
class Book {
    protected String title;
    protected String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void info() {
        System.out.println("Book: " + title + " by " + author );
    }
}

// Inheritance
class EnglishBook extends Book {
    private int price; 
    
    public EnglishBook(String title, String author, int price) {
        super(title, author); 
        this.price = price;
    }

    // Polymorphism
    @Override
    public void info() {
        System.out.println("Book: " + title + " author " + author + " price " + price);
    }
}
```


### 2. What is wrapper class in Java and Why we need wrapper class?
```
1.object representation for primitive type
2.allow primitive values to be treated as objects
```

### 3. What is the difference between HashMap and HashTable?
```
HashMap is not thread safe,	HashTable is thread-safe
```

### 4. What is String pool in Java and why we need String pool?
```
The String Pool is a special memory area in Java’s heap that stores unique string, optimizing memory usage and improving performance by reusing strings
```

### 5. What is Java garbage collection?
```
Java Garbage Collection is an automatic memory management that removes unreferenced objects from the heap memory and preventing memory leaks
```

### 6. What are access modifiers and their scopes in Java?
```
Access modifiers in Java control the accessibility of classes, methods, and variables
```

### 7. What is `final` key word? (Filed, Method, Class)
```
in variables: cannot not be changed after init
in methods: cannot not be overridden
in classes: cannot not be extended
```

### 8. What is `static` keyword? (Filed, Method, Class). When do we usually use it?
```
The static is a keyword Can be modified Filed, Method, Class. It’s used for shared resources, utility methods
```

### 9. What is the differences between overriding and overloading?
```
Overriding is redefining a method in a subclass, maintaining the same signature
Overloading is defining multiple methods in the same class with different parameter lists
```

### 10. What is the differences between super and this?
```
this refers to current instance
super refers to parent instance
```

### 11. What is the Java load sequence?
```
Class loading
Static variables/blocks
Instance variables/blocks
Constructor
```

### 12. What is Polymorphism ? And how Java implements it ?
```
Polymorphism allows a method to perform differently based on the object
Through overloading (compile-time) and overriding (runtime)
```

### 13. What is Encapsulation ? How Java implements it? And why we need encapsulation?
```
Encapsulation is bundling data and methods into a class
Java implements it with private fields and get/set method
It ensures data security and modularity
```

### 14. What is Interface and what is abstract class? What are the differences between them?
```
Interface defines methods without implementation
Abstract class can have both abstract and concrete methods
Interfaces support multiple inheritance, abstract classes do not
```

### 15. design a parking lot (put the code to codingQuestions/coding1 folder)
1. If you have no ability to design it, please find the solution in internet, then understand it, and re-type it.(Do NOT just copy and paste)

### 16. What are Queue interface implementations and what are the differences and when to use what?
```
LinkedList: doubly linked list, good performance for insert and delete
PriorityQueue: for prioritized ordering
ArrayDeque: resizable queue good performance for query
ConcurrentLinkedQueue: thread safe for concurrency
```
