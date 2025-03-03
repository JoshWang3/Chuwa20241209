# HW2
## Questions:
### 1. Write up Example code to demonstrate the three foundmental concepts of OOP. (reference Code Demo repo as example)
Please check /Coding/HW2/hw20 for the concepts
### 2. What is wrapper class in Java and Why we need wrapper class?
Wrapper class gives a way to use primitive types as an object. Like Collection objects and its methods.

For example:
1. `Byte`: Wrapper class for byte
2. `Integer`: Wrapper class for int
3. `Character`: Wrapper class for char

### 3. What is the difference between HashMap and HashTable?
1. HashTable doesn’t allow null (not an object) and HashMap do allow
2. Hashtable is synchronized (slow but thread-safe) and HashMap is non-synchronized (fast but can’t be shared between many threads)


### 4. What is String pool in Java and why we need String pool?
**String Pool** is a place in heap memory where all the strings are stored. JVM will check here to look up the object, new objects will be created in the pool if not existed.


### 5. What is Java garbage collection?
Java Object created in the Heap, if objects are no longer needed, the garbage collector tracks and deletes.

- Automated process (can’t be forced)
- Can’t decide whether and when
- Make the variable null or reassign can help
- System.gc(), Runtime.getRuntime().gc(), finalize()



### 6. What are access modifiers and their scopes in Java?
1. **`public`**: Accessible from any other class.
2. **`protected`**: Accessible within the same **package** or all **subclasses**.
3. **`default`** (no modifier): Accessible only within the same **package**.
4. **`private`**: Accessible only within the same **class**.

### 7. What is `final` key word? (Filed, Method, Class)
The `final` keyword prevents modification. If applied to a variable, it can’t be changed; if applied to a method, it can’t be overridden; if applied to a class, it can’t be inherited.


### 8. What is `static` keyword? (Filed, Method, Class). When do we usually use it?
The `static` keyword allows using anything in the class(indicates the member belongs to the class itself) without creating an instance.

### 9. What is the differences between overriding and overloading?
- overriding occurs between superclass and subclass, overloading occurs in the same class between its own methods
- overriding has same signature (name, argument),  overloading has same name but different params
- overriding is "runtime polymorphism", overloading is "compile time polymorphism"

### 10. What is the differences between super and this?
1. `super`: a keyword used within a subclass to refer to the **superclass**.
2. `this`: is a reference variable that refers to the **current** object.


### 11. What is the Java load sequence?
1. Class loader (root, extension, application)
2. Static Block
3. Static Variable
4. Constructor (static variable -> non-static variable)

### 12. What is Polymorphism ? And how Java implements it ?
Polymorphism is a way to allow objects of different classes to be treated as objects of a common superclass. Java implements it using (1) Compile time (overloading) way or (2) Runtime way (overriding).


### 13. What is Encapsulation ? How Java implements it? And why we need encapsulation?
Encapsulation means setting restricts for direct access to an object’s data (fields) and provides controlled access through methods. This control improves code security(like bank account operation), integrity, and modularity. 


### 14. What is Interface and what is abstract class? What are the differences between them?
- **Interface**: An interface defines a contract for methods without any implementation. It allows multiple interfaces implementation.
- **Abstract class**: Abstract classes serve as blueprints for other classes and can contain both abstract (methods without implementation) and concrete methods. This forces subclasses to implement it.

Differences:
1. Abstraction makes class can inherit from only one abstract class. (IS-A relationship). While interface means a class can implement multiple interfaces.
2. Abstraction defines a **common** base for a hierarchy of related classes. Interface define a behavior that multiple unrelated classes can do or perform.

### 15. Design a parking lot
Please check /Coding/HW2/hw20/ParkingLot
Has not implemented fee calculation or payment way yet.

### 16. What are Queue interface implementations and what are the differences and when to use what?
1. PriorityQueue(class): when elements of the queue are needed to be processed according to the priority (e.g. heap sort)
2. Deque(interface)
   1. LinkedList(class): where the elements are not stored in contiguous locations and every element is a separate object with a data part and address part.
   2. ArrayDeque(class): Resizable-array implementation with double-end, most ArrayDeque operations run in amortized constant O(1) time. Exceptions include `remove`, `contains`