1. OOP implementation:
   1. Encapsulation:"class Pet{ 
       private String name; 
       public Pet(String name) { this.name = name;} 
       public String getName() { return this.name;}
       public String speak() {return "";}
      }"
   2. Polymorphism: "class Dog extends Pet {
       @Override
       public String speak() {return "Bark.";}
      }"
   3. Inheritance: "
        Dog myDog = new Dog("A");
        String name = myDog.getName(); // name = "A" (inherited from the parent class)
      "
2. Wrapper class:
   1. Wrapper classes are object representations of primitive types. 
   2. Wrapper classes provide static methods. Wrapper classes allow automatic conversion between primitives and objects.
      Collections can only store wrapper class objects, not primitives. 
3. HashMap vs HashTable:
   1. HashMap is not thread safe while HashTable is thread safe.
   2. HashMap allows one null key and multiple null values; HashTable does not all null keys or values. 
4. String pool:
   1. String pool is a memory area in the heap where java stores string literals. It avoids creating duplicate strings,
      since strings are used a lot.
5. GC:
   1. Garbage collection automatically deletes objects that are on longer reachable to clear memory space. 
6. Access modifiers:
   1. public: open to class, package, subclass, outside
   2. protected: not to outside;
   3. private: only to class;
7. final:
   1. value will be immutable;
   2. methods can not be overridden;
   3. class can not be extended;
8. static:
   1. field will be shared among all instances of a class
   2. methods belong to the class
9. overriding vs overloading:
   1. overiding is the process of redefining a method in a subclass; overloading is different method implementation with the same method name but with different parameters.
10. super vs this:
    1. super: refers to the parent class
    2. this: refers to the current class
11. java load sequence:
    1. static block
    2. instance variables
    3. constructor
12. polymorphism:
    1. one interface to be used for different types
    2. through method overloading and overriding
13. encapsulation:
    1. hides the details of implementation and protects the object's state via access modifiers;
    2. private fields with public methods;
14. interface vs abstract:
    1. interface is blueprint that what a class must do but no implementations; abstract class provides partial implementation and can include abstract and concrete methods;
15. parking lot
16. queue:
    1. LinkedList: generic FIFI operations.
    2. PriorityQeue: sorting by priority
    3. ArrayDeque: double-ended queue which allows deque or stack functionality. 