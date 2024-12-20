## HW4

### Discuss best practices on nullptr exception prevention, provide code snippet for each practice that you mentioned.  
1. Always null check first  
``` java
String str1 = null;
if (str1 != null && str1.equals("Chuwa")) {
    System.out.println("Correct");
} else {
    System.out.println("Null or not correct");
}
``` 
2. Null check from parent object to nested/inner object
``` java
class Address {
    String city;
}

class Person {
    Address address;
}

Person person = new Person();
if (person != null && person.address != null && person.address.city != null) {
    System.out.println(person.address.city);
} else {
    System.out.println("City is null");
}
``` 
3. try catch
``` java
String str1 = null;
try {
    System.out.println(str1.equals("Chuwa"));
} catch (NullPointerException e) {
    System.out.println("Null Pointer Exception: " + e.getMessage());
}
``` 
4. Avoid equals on Null
``` java
String str1 = null;
// Safer way
if ("Chuwa".equals(str1)) {
    System.out.println("Correct");
} else {
    System.out.println("Null or not correct");
}
``` 
5. Use Optional
``` java
String str1 = null;
Optional<String> optionalStr = Optional.ofNullable(str1);
optionalStr.ifPresentOrElse(
    value -> System.out.println("Value: " + value),
    () -> System.out.println("Value is null")
);
``` 

### Discuss Java 8 new features with code snippet.  
1. Lambda Expressions  
   Lambda expressions provide a concise way to write anonymous functions, enabling functional-style programming.  

**Traditional Way**
``` java
List<String> strings = Arrays.asList("apple", "banana", "cherry");

// Using anonymous class to implement Comparator
strings.sort(new Comparator<String>() {
    @Override
    public int compare(String s1, String s2) {
        return Integer.compare(s1.length(), s2.length());
    }
});

System.out.println(strings); // Output: [apple, banana, cherry]
``` 
**Using Lambda Expression**
``` java
List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

// Using s1.length() - s2.length() (can cause overflow in extreme cases)
strings.sort((s1, s2) -> s1.length() - s2.length());
System.out.println("Sorted using length difference: " + strings);

// Safer alternative using Integer.compare
strings.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
System.out.println("Sorted using Integer.compare: " + strings);
``` 

2. Functional Interfaces  
   A functional interface is an interface with a single abstract method. Java 8 introduced the @FunctionalInterface annotation to ensure this constraint.  
``` java
@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}

public class Main {
    public static void main(String[] args) {
        Greeting greeting = name -> System.out.println("Hello, " + name);
        greeting.sayHello("Java 8");
    }
}
``` 
3. Stream API  
   The Stream API allows functional-style operations on collections or sequences of elements, such as filtering, mapping, and reducing.  
``` java
public static void main(String[] args) {
    List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

    // Filter and print names starting with 'C'
    names.stream()
         .filter(name -> name.startsWith("C"))
         .forEach(System.out::println); // Output: Charlie
}
``` 
4. Default Methods in Interfaces  
   Java 8 allows interfaces to have default methods with implementation.  
``` java
interface Vehicle {
    default void start() {
        System.out.println("Vehicle is starting");
    }
}

class Car implements Vehicle {}

public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car();
        car.start(); // Output: Vehicle is starting
    }
}
``` 
5. Optional  
   The Optional class is used to handle null values gracefully, reducing the chances of NullPointerException.  
``` java
public class Main {
    public static void main(String[] args) {
        Optional<String> optional = Optional.ofNullable(null);

        // If present, print the value; otherwise, provide a default
        System.out.println(optional.orElse("Default Value")); // Output: Default Value
    }
}
``` 

### What are the advantages of the Optional class?
- Prevents NullPointerException: Forces explicit handling of null values, reducing runtime errors.
- Improves Code Readability: Clearly indicates that a value may be absent, improving code clarity.
- Reduces Boilerplate: Eliminates repetitive null checks, making the code cleaner and more concise.
- Supports Method Chaining: Enables functional-style handling of values through methods like map(), flatMap(), and filter().  

### Explain Functional Interface and Lambda with code samples.  
**Relationship**:
- A functional interface defines a method signature.
- A lambda expression is used to implement the single abstract method of that interface.
``` java
@FunctionalInterface
public interface MathOperation {
    int operate(int a, int b);  // Single abstract method
}

public class Main {
    public static void main(String[] args) {
        // Using a lambda to implement the MathOperation interface
        MathOperation addition = (a, b) -> a + b;  // Lambda expression
        
        // Using the lambda to perform the operation
        System.out.println("Result: " + addition.operate(5, 3));  // Output: 8
    }
}
``` 

### Explain Method Reference with code samples
A Method Reference is a shorthand notation of a lambda expression to call a method. Instead of writing the lambda expression to invoke a method, you can directly refer to the method using the :: operator.
``` java
public class MathOperations {
    // Static method
    public static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        // Using method reference to refer to static method
        MathOperation addition = MathOperations::add;
        
        // Invoking the method using the reference
        System.out.println(addition.operate(5, 3));  // Output: 8
    }
}

@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);  // Abstract method
}
``` 

### Explain "Lambda can use unchanged variable outside of lambda", with code snippet.  
lambda expressions can access variables from the surrounding scope, but these variables must be **final** or **effectively final**.  
``` java
public class LambdaExample {
    public static void main(String[] args) {
        // Unchanged (effectively final) String variable
        String greeting = "Hello";

        // Lambda expression accessing the String variable
        Runnable task = () -> {
            System.out.println(greeting + " World!");  // Accessing the String variable inside lambda
        };

        task.run();  // Output: Hello World!
    }
}
```
### Can a functional interface extend/inherit another interface?  
Yes, a functional interface in Java can extend or inherit another interface, as long as the inheritance follows the functional interface rule, meaning it must have exactly one abstract method.
``` java
@FunctionalInterface
interface Parent {
    void parentMethod();
}

@FunctionalInterface
interface Child extends Parent {
    void childMethod();
}
``` 

### What are Intermediate and Terminal operations?
**Intermediate Operations**:   
Intermediate operations are operations that transform a stream into another stream. They are lazy, meaning they are not executed until a terminal operation is invoked. Intermediate operations can be chained together, as they return a new stream each time.  

Examples of Intermediate Operations:  
- filter(): Filters elements based on a condition.
- map(): Transforms each element in the stream.
- flatMap(): Flattens nested streams into a single stream.
- distinct(): Removes duplicate elements.
- sorted(): Sorts elements.
- peek(): Allows for operations on the stream's elements (mainly for debugging).

**Terminal Operations**:  
Terminal operations are operations that consume the stream and produce a result or a side effect. Once a terminal operation is invoked, the stream is closed, and no further operations can be performed on it.  

Examples of Terminal Operations:  
- forEach(): Performs an action for each element of the stream (side effect).
- collect(): Collects the elements of the stream into a collection (e.g., List, Set).
- reduce(): Reduces the elements of the stream to a single value by repeatedly applying a function.
- count(): Counts the number of elements in the stream.
- anyMatch(): Returns true if any element matches the condition.
- allMatch(): Returns true if all elements match the condition.
- noneMatch(): Returns true if no element matches the condition.

### Demontrate the most commonly used Intermediate operations in Stream API, with code snippet.
1. filter()  
   The filter() method is used to exclude elements that do not match a certain condition.
``` java
public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    
    // Filtering even numbers
    numbers.stream()
           .filter(n -> n % 2 == 0)  // Keep only even numbers
           .forEach(System.out::println);  // Output: 2, 4, 6, 8
}
``` 
2. map()  
   The map() method applies a function to each element of the stream, transforming it into a new form.  
``` java
public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

    // Doubling each number
    numbers.stream()
           .map(n -> n * 2)  // Transform numbers by doubling
           .forEach(System.out::println);  // Output: 2, 4, 6, 8, 10
}
``` 

### How are Collections different from Stream?
In Java, Collections and Streams are both used for working with data, but they have fundamental differences in how they manage and process data.  

Key Differences:  
- Storage:  
  - Collection: Stores data directly.
  - Stream: Does not store data, represents a sequence of elements.
- Mutability:
  - Collection: Mutable (elements can be added, removed, modified).
  - Stream: Immutable (operations produce new streams).
- Evaluation:
  - Collection: Eager evaluation (operations executed immediately).
  - Stream: Lazy evaluation (operations are executed only when a terminal operation is invoked).
- Processing:
  - Collection: Iterative approach (loops or explicit methods).
  - Stream: Functional style (using operations like map(), filter(), reduce()).
- Parallel Processing:
  - Collection: Typically not parallel.
  - Stream: Can be processed in parallel (parallel()).
- Use Cases:
  - Collection: Used for storing and accessing data.
  - Stream: Used for processing data in a pipeline (transformation, filtering, aggregation).

### Implement Stream API's filter and map methods by your self.
``` java
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyStream<T> {
    private List<T> data;

    public MyStream(List<T> data) {
        this.data = data;
    }

    public MyStream<T> filter(Predicate<T> predicate) {
        List<T> filteredData = new ArrayList<>();
        for (T item : data) {
            if (predicate.test(item)) {
                filteredData.add(item);
            }
        }
        return new MyStream<>(filteredData);
    }

    public <R> MyStream<R> map(Function<T, R> function) {
        List<R> mappedData = new ArrayList<>();
        for (T item : data) {
            mappedData.add(function.apply(item));
        }
        return new MyStream<>(mappedData);
    }

    public void forEach() {
        for (T item : data) {
            System.out.println(item);
        }
    }

    public static <T> MyStream<T> of(List<T> list) {
        return new MyStream<>(list);
    }
}
``` 