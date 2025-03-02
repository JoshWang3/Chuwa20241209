### Short Questions

#### 5. Discuss best practices on nullptr exception prevention, provide code snippet for each practice that you mentioned  

~~~java
//use Optional
Optional<String> optionalStr = Optional.ofNullable(str);
// Using ifPresent to avoid null check
optionalStr.ifPresent(s -> System.out.println(s.length()));

//null checks
String name = null;
if (name != null) {
    System.out.println(name.length()); 
} else {
    System.out.println("Name is null");
}

//use annotation
public void printMessage(@NotNull String message) {
    System.out.println(message);
}
~~~

#### 6. Discuss Java 8 new features with code snippet.   

```java
//lambda
// Traditional anonymous class
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
names.forEach(new Consumer<String>() {
    public void accept(String name) {
        System.out.println(name);
    }
});

// Lambda expression
names.forEach(name -> System.out.println(name));

//functional interface
@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}

public class Main {
    public static void main(String[] args) {
        Greeting greeting = (name) -> System.out.println("Hello, " + name);
        greeting.sayHello("World");
    }
}

//stream api
List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
long count = names.stream()
                  .filter(name -> name.length() > 3)
                  .count();
System.out.println(count);  // Output: 3

//default method
interface MyInterface {
    default void printMessage() {
        System.out.println("Default Message");
    }
}

class MyClass implements MyInterface {}

public class Main {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.printMessage();  // Output: Default Message
    }
}

//Method References
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
names.forEach(System.out::println); 

//optional class
Optional<String> name = Optional.ofNullable("Alice");
name.ifPresent(System.out::println);  // Output: Alice

Optional<String> emptyName = Optional.empty();
System.out.println(emptyName.orElse("No Name"));  // Output: No Name

```

#### 7. What are the advantages of the Optional class?  

```
Avoids NullPointerException
Improves Readability
Cleaner Null Checks
Prevents Returning Null
Chainable Operations
Default Values
```

#### 8. Explain Functional Interface and Lambda with code samples  

```java
//functional interface is an interface with exactly one abstract method, making it eligible for lambda expressions or method references.
@FunctionalInterface
interface Greet {
    void sayHello(String name);  // Single abstract method
}

public class Main {
    public static void main(String[] args) {
        Greet greet = name -> System.out.println("Hello, " + name);  // Lambda expression
        greet.sayHello("Alice");  // Output: Hello, Alice
    }
}

//lambda expression is a shorthand for defining an instance of a functional interface. It allows you to pass behavior (functions) as parameters to methods.
// Lambda expression to calculate sum
BinaryOperator<Integer> sum = (a, b) -> a + b;
System.out.println(sum.apply(5, 3));  // Output: 8

```

#### 9. Explain Method Reference with code samples?   

```java
//a shorthand syntax to call a method in place of a lambda expression. It is used when you already have an existing method and want to refer to it directly using the :: syntax.
class Utils {
    public static void printMessage(String msg) {
        System.out.println(msg);
    }
}

public class Main {
    public static void main(String[] args) {
        // Method reference to a static method
        List<String> list = Arrays.asList("Alice", "Bob", "Charlie");
        list.forEach(Utils::printMessage);  // Output: Alice Bob Charlie
    }
}

```

#### 10.Explain "Lambda can use unchanged variable outside of lambda", with code snippet  
```java
//lambdas can access variables from their surrounding environment. However, the key restriction is that only final or effectively final variables can be accessed inside a lambda expression.
public class LambdaExample {
    public static void main(String[] args) {
        int outerVar = 10;  // Effectively final variable
        // outerVar = 20; //cannot modify otherwise compiletime error
        
        // Lambda using the variable from the outer scope
        Runnable r = () -> System.out.println("Outer variable value: " + outerVar);
        r.run();  // Output: Outer variable value: 10
    }
}

```

#### 11. Can a functional interface extend/inherit another interface?  

```
yes, the extended interface must also be a functional interface (with exactly one abstract method), and the child interface must not add more abstract methods.
```

#### 12. What are Intermediate and Terminal operations?  

```
Intermediate operations are operations that return a new stream and allow for the chaining of multiple operations. These operations are lazy and do not execute until a terminal operation is invoked.
filter(): Filters elements based on a condition.
map(): Transforms elements using a function.
distinct(): Removes duplicate elements.
sorted(): Sorts elements.
limit():Limits the number of elements in the stream.

Terminal operations are operations that produce a non-stream result (such as a value, collection, or side effect) and terminate the stream pipeline.
collect(): Collects elements into a collection (e.g., List, Set).
forEach(): Iterates over the elements and performs an action on each element.
reduce(): Combines elements into a single result.
count(): Counts the number of elements.
```

#### 13. Demontrate the most commonly used Intermediate operations in Stream API, with code snippet.  

```java
//filter
List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

List<String> filteredNames = names.stream()
                                  .filter(name -> name.length() > 3) 
                                  .collect(Collectors.toList());

System.out.println(filteredNames);  // Output: [Alice, Charlie, David]

//map
List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

List<String> upperCaseNames = names.stream()
                                   .map(String::toUpperCase)  
                                   .collect(Collectors.toList());

System.out.println(upperCaseNames);  // Output: [ALICE, BOB, CHARLIE, DAVID]

//sort
List<Integer> numbers = Arrays.asList(5, 3, 1, 4, 2);

List<Integer> sortedNumbers = numbers.stream()
                                     .sorted()
                                     .collect(Collectors.toList());

System.out.println(sortedNumbers);  // Output: [1, 2, 3, 4, 5]

```

#### 14. How are Collections different from Stream?  

```
Collection is a data structure that stores data, like List and Set
Stream represents a sequence of elements that can be processed in a functional style. It does not store data; instead, it provides a pipeline for operations on the data. Stream operations are typically lazy. Streams are immutable
```

#### 




