
## 1. Learn Java generics by reading and practicing following code:
   https://github.com/CTYue/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t01_basic/generic

## 2. Read the follwoing code repo and type it one by one by yourself.
   https://github.com/CTYue/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t06_java8/features

## 3. Practice following stream API exercises at least 3 times
   https://github.com/gavinklfong/stream-api-exercises/blob/main/src/test/java/space/gavinklfong/demo/streamapi/StreamApiTest.java

## 4. Practice Optional methods at least 2 times
   https://github.com/CTYue/chuwa-eij-tutorial/blob/main/02-java-core/src/main/java/com/chuwa/tutorial/t6_java8/exercise/ShoppingCartUtil.java

## 5. Discuss best practices on nullptr exception prevention, provide code snippet for each practice that you mentioned.

## 6. Discuss Java 8 new features with code snippet.
- **Lambda Expressions**
- Lambda expressions allow you to write anonymous functions, making your code more concise and readable.
```
Runnable runnableLambda = () -> System.out.println("Hello from Lambda");
runnableLambda.run();
```
- Default Methods
- Default methods allow you to add new methods to interfaces without breaking existing implementations.
```
interface MyInterface {
    void existingMethod();
    
    // New default method
    default void newMethod() {
        System.out.println("This is a default method");
    }
}

class MyClass implements MyInterface {
    public void existingMethod() {
        System.out.println("Implemented existing method");
    }
}

public class DefaultMethodExample {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.existingMethod();
        obj.newMethod(); // Calls default method
    }
}
```
- **Functional Interfaces**
- Functional interfaces have only one abstract method and can be used with lambda expressions.
```
@FunctionalInterface
interface Calculator {
   int add(int a, int b);
}

public class FunctionalInterfaceExample {
   public static void main(String[] args) {
      Calculator calc = (a, b) -> a + b;
      System.out.println(calc.add(5, 3)); // Outputs: 8
   }
}
```
- **Method References**
- Method references provide a shorthand to use existing methods as lambda expressions.
```
public class MethodReferenceExample {
   public static void main(String[] args) {
      List<String> names = Arrays.asList("Alice", "Bob", "Charlie");   
         // Using method reference
         names.forEach(System.out::println);
      }
}
```
- **Optional Class**

- Optional helps handle null values more gracefully, reducing the risk of NullPointerException.
```
public class OptionalExample {
    public static void main(String[] args) {
        Optional<String> optional = Optional.ofNullable(getName());
        
        optional.ifPresent(name -> System.out.println("Name: " + name));
    }
    
    static String getName() {
        return "Java";
        // return null; // Try with null to see no output
    }
}
```

- **Date and Time API (java.time)**
- Date and time API  is for better handling of dates and times.
```
public class DateTimeExample {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDateTime now = LocalDateTime.now();
        
        System.out.println("Today: " + today);
        System.out.println("Now: " + now);
    }
}
```
## 7. What are the advantages of the Optional class?
- provides a clear and concise way to handle potential null values in your code, 
- significantly reducing the risk of NullPointerExceptions,
- leading to cleaner and more readable code with less boilerplate null checks.
## 8. Explain Functional Interface and Lambda with code samples.
- **Functional Interface** is an interface that has only one abstract method
- **Lambda** is a short way to write the implementation of a functional interface
```
@Functional Interface
Interface Greeting {
   void sayHello();
}
public class main {
   public static void main(String[] args) {
      // Lambda implementation of Greeting
      Greeting greet = () -> System.out.printIn("Hello World");
      greet.sayHello();
   }
}
```

## 9. Explain Method Reference with code samples?
- Method references provide a shorthand to use existing methods as lambda expressions.
```
public class MethodReferenceExample {
   public static void main(String[] args) {
      List<String> names = Arrays.asList("Alice", "Bob", "Charlie");   
         // Using method reference
         names.forEach(System.out::println);
      }
}
```
## 10. Explain "Lambda can use unchanged variable outside of lambda", with code snippet.
- Lambdas can use variables from outside their scope as long as those variables are unchanged (effectively final).
```
public class Example {
    public static void main(String[] args) {
        int number = 10; // This variable is effectively final

        Runnable task = () -> {
            System.out.println("Number is: " + number);
        };

        task.run(); // Outputs: Number is: 10

        // number = 20; // You can change it here, but not inside the lambda
    }
}
```
## 11. Can a functional interface extend/inherit another interface?
- Yes,it can extend another interface as long as the contract of having a single abstract method is upheld.
## 12. What are Intermediate and Terminal operations?
- Intermediate operations transform a stream into another stream, while terminal operations produce a result or side effect
```
public class TerminalExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Stream with intermediate operations
        numbers.stream()
               .filter(n -> n > 2)   // Intermediate
               .map(n -> n * 2)      // Intermediate
               .forEach(System.out::println); // Terminal: Prints 6, 8, 10
    }
}
```
## 13. Demontrate the most commonly used Intermediate operations in Stream API, with code snippet.
- filter: Filters elements from a stream based on a condition.
```
List<Integer> evenNumbers = numbers.stream()

    .filter(n -> n % 2 == 0) // Filter for even numbers

    .collect(Collectors.toList()); 
```
- map: Applies a function to each element in a stream, transforming it into a new element.
```
List<String> upperCaseNames = names.stream()

    .map(String::toUpperCase) // Convert to uppercase

    .collect(Collectors.toList());
```
- sorted: Sorts the elements in a stream based on a comparator.
```
List<Integer> sortedNumbers = numbers.stream()

    .sorted() // Sort in ascending order

    .collect(Collectors.toList()); 
```
- distinct: Removes duplicate elements from a stream.
```
List<String> uniqueWords = words.stream()

    .distinct() // Remove duplicates

    .collect(Collectors.toList()); 
```
- flatMap: Creates a new stream by flattening nested elements from a stream of streams.
```
List<String> flattenedList = nestedList.stream()

    .flatMap(innerList -> innerList.stream()) // Flatten the nested lists

    .collect(Collectors.toList()); 
```

## 14. How are Collections different from Stream?
- Collections are about data and streams are about computations.
## 15. Implement Stream API's filter and map methods by your self.
```
class MyStream<T> {
    private List<T> items;

    // Constructor
    public MyStream(List<T> items) {
        this.items = items;
    }

    // Filter method
    public MyStream<T> filter(Predicate<T> predicate) {
        List<T> filtered = new ArrayList<>();
        for (T item : items) {
            if (predicate.test(item)) {
                filtered.add(item);
            }
        }
        return new MyStream<>(filtered);
    }

    // Map method
    public <R> MyStream<R> map(Function<T, R> function) {
        List<R> mapped = new ArrayList<>();
        for (T item : items) {
            mapped.add(function.apply(item));
        }
        return new MyStream<>(mapped);
    }
}
```
=======
# Homework 4

## 5. Discuss best practices on nullptr exception prevention, provide code snippet for each practice that you mentioned.
- **Always Null Check:** First Ensure the object is not null before accessing its methods or properties.
    ```
    String str = null;
    if (str != null) {
        System.out.println(str.length());
    } else {
        System.out.println("String is null.");
    }
    ```

- **Null Check from Parent to Nested Objects:** For nested objects, validate each parent object before accessing child objects.
    ```
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
        System.out.println("One of the nested objects is null.");
    }
    ```

- **Use Optional to Handle Potential Null Values**
    ```
    import java.util.Optional;

    String str = null;
    Optional<String> optionalStr = Optional.ofNullable(str);
    System.out.println(optionalStr.orElse("Default Value"));
    ```

- **Use Objects.requireNonNull for Immediate Null Validation:** This utility ensures that critical objects are not null and throws an exception with a custom message if they are.
    ```
    import java.util.Objects;

    public void process(String input) {
        input = Objects.requireNonNull(input, "Input cannot be null");
        System.out.println(input.toUpperCase());
    }
    ```

- **Prefer Safe Methods for Comparisons:** Avoid calling methods on potential null values. Use safe alternatives like comparing with constants first.
    ```
    String str = null;
    if ("Chuwa".equals(str)) {
        System.out.println("Strings match!");
    } else {
        System.out.println("Strings do not match or string is null.");
    }
    ```

` **Use Try-Catch for Unexpected Null Scenarios:** While not ideal, try-catch can handle unexpected null values when you cannot validate the input in advance.
    ```
    try {
        String str = null;
        System.out.println(str.length());
    } catch (NullPointerException e) {
        System.out.println("Caught NullPointerException: " + e.getMessage());
    }
    ```

- **Initialize Variables Properly:** Ensure variables are initialized with default values to avoid null references.
    ```
    class User {
        String name = "";
    }

    User user = new User();
    System.out.println(user.name.length());
    ```

- **Use Annotations and Static Analysis Tools:** Leverage tools like @NonNull, @Nullable, or static analysis tools like SpotBugs or SonarQube to identify potential null risks.
    ```
    public void greet(@NonNull String name) {
        System.out.println("Hello, " + name);
    }
    ```

## 6. Discuss Java 8 new features with code snippet.
- **ambda Expressions:** Enables functional programming by allowing concise expressions for single-method interfaces.
    ```
    import java.util.Arrays;
    import java.util.List;

    public class LambdaExample {
        public static void main(String[] args) {
            List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
            names.forEach(name -> System.out.println(name));
        }
    }
    ```

- **Stream API:** Simplifies processing collections of data in a functional style.
    ```
    import java.util.Arrays;
    import java.util.List;

    public class StreamExample {
        public static void main(String[] args) {
            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
            numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .forEach(System.out::println);
        }
    }
    ```

- **Optional:** Provides a container to handle null values safely and avoid NullPointerException.
    ```
    import java.util.Optional;

    public class OptionalExample {
        public static void main(String[] args) {
            Optional<String> optional = Optional.ofNullable(null);
            System.out.println(optional.orElse("Default Value"));
        }
    }
    ```

- **Default Methods in Interfaces:** Allows methods with default implementations in interfaces.
    ```
    interface Vehicle {
        default void start() {
            System.out.println("Vehicle is starting");
        }
    }

    class Car implements Vehicle {}

    public class DefaultMethodExample {
        public static void main(String[] args) {
            Car car = new Car();
            car.start();
        }
    }
    ```

- **Method References:** Provides a shorthand for lambda expressions when referring to existing methods.
    ```
    import java.util.Arrays;
    import java.util.List;

    public class MethodReferenceExample {
        public static void main(String[] args) {
            List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
            names.forEach(System.out::println);
        }
    }
    ```

- **Date and Time API:** Introduced a new API for handling date and time.
    ```
    import java.time.LocalDate;
    import java.time.LocalTime;
    import java.time.LocalDateTime;

    public class DateTimeExample {
        public static void main(String[] args) {
            LocalDate date = LocalDate.now();
            LocalTime time = LocalTime.now();
            LocalDateTime dateTime = LocalDateTime.now();

            System.out.println("Date: " + date);
            System.out.println("Time: " + time);
            System.out.println("DateTime: " + dateTime);
        }
    }
    ```

- **Functional Interfaces:** Interfaces with a single abstract method, such as Runnable, Callable, or Comparator, are treated as functional interfaces.
    ```
    import java.util.function.Predicate;

    public class FunctionalInterfaceExample {
        public static void main(String[] args) {
            Predicate<String> isLongerThan5 = str -> str.length() > 5;
            System.out.println(isLongerThan5.test("Hello"));
            System.out.println(isLongerThan5.test("Hello, World!"));
        }
    }
    ```

- **Streams Parallel Processing:** Processes data streams in parallel for improved performance.
    ```
    import java.util.Arrays;
    import java.util.List;

    public class ParallelStreamExample {
        public static void main(String[] args) {
            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
            numbers.parallelStream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);
        }
    }
    ```

## 7. What are the advantages of the Optional class?
- **Avoids NPE:** The Optional class explicitly forces you to handle the possibility of null, reducing the risk of unintentional NPEs.
    ```
    Optional<String> optional = Optional.ofNullable(null);
    optional.ifPresent(System.out::println); // Does nothing if null, avoiding NPE
    ```
- **Improves Code Readability:** By explicitly showing that a value may be absent, it makes code more understandable and self-documenting.
- **Simplifies Null Checking:** It provides convenient methods like isPresent() ,orElse(), orElseGet() and orElseThrow() to handle nulls concisely.
    ```
    String result = Optional.ofNullable(null).orElse("Default Value");
    System.out.println(result); // Output: Default Value
    ```
- **Encourages Functional Programming:** Optional works seamlessly with Java's functional programming features, such as lambda expressions and the Stream API.
    ```
    Optional<String> name = Optional.ofNullable("Alice");
    System.out.println(Optional.ofNullable("Alice").map(String::toUpperCase).orElse("DEFAULT"));
    ```

## 8. Explain Functional Interface and Lambda with code samples.
- **Functional Interface:** A functional interface is an interface that contains exactly one abstract method. ```(parameters) -> {body}```
- **Examples:** Runnable, Callable, Comparator, and the interfaces in java.util.function package (like Predicate, Function, etc.).
- **Lambda Expression:** A lambda expression is a concise way to represent an implementation of a functional interface.
    ```
    @FunctionalInterface
    interface Greeting {
        void sayHello(String name); // Single abstract method
    }

    public class FunctionalInterfaceExample {
        public static void main(String[] args) {
            Greeting greeting = name -> System.out.println("Hello, " + name);
            greeting.sayHello("Alice"); // Output: Hello, Alice
        }
    }
    ```

## 9. Explain Method Reference with code samples?
A method reference is a shorthand notation for invoking a method through a lambda expression. 
**The essence of method references is to bind a method, which matches the abstract method signature of a functional interface, to an instance of that interface.**
    ```
    public class StaticMethodReference {
        public static void print(String s) {
            System.out.println(s);
        }

        public static void main(String[] args) {
            List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
            names.forEach(StaticMethodReference::print); // Method reference
        }
    }
    ```

## 10. Explain "Lambda can use unchanged variable outside of lambda", with code snippet.
- Lambda expressions in Java can capture variables from their enclosing scope, but only under certain rules. Specifically, the variable used in the lambda expression must be effectively final. This means the variable’s value cannot be modified after it has been initialized.
- **Why this Restriction:** This ensures thread safety and avoids ambiguity in concurrent execution. Lambdas may execute asynchronously, so allowing variable modifications could lead to inconsistent results.
- **Workaround for Mutable Variables:** If you need to modify variables within a lambda, use a mutable wrapper like an array or a collection:
    ```
    import java.util.concurrent.atomic.AtomicInteger;

    public class MutableVariableExample {
        public static void main(String[] args) {
            AtomicInteger number = new AtomicInteger(10); // Mutable wrapper

            Runnable lambda = () -> {
                number.set(20); // Modifying the value
                System.out.println("Number: " + number.get());
            };

            lambda.run(); // Output: Number: 20
        }
    }
    ```

## 11. Can a functional interface extend/inherit another interface?
Yes, a functional interface can extend another interface as long as it adheres to the functional interface rule: it must have exactly one abstract method.


## 12. What are Intermediate and Terminal operations?
- **Intermediate Operations** are used to process data and return a new stream. They are lazy, meaning they are not executed immediately but only when a terminal operation is invoked.
    ```
    filter(Predicate)
    map(Function)
    flatMap(Function)
    sorted(Comparator)
    distinct()
    limit(long)
    skip(long)
    ```
- **Terminal Operations** trigger the processing of the stream pipeline. They produce a result (either a value or a side effect) and terminate the stream pipeline.
    ```
    forEach(Consumer)
    collect(Collector)
    reduce(BinaryOperator)
    count()
    anyMatch(Predicate)
    allMatch(Predicate)
    noneMatch(Predicate)
    findFirst()
    findAny()
    ```

## 13. Demontrate the most commonly used Intermediate operations in Stream API, with code snippet.
```
public class StreamIntermediateOperations {
    public static void main(String[] args) {
        // Sample data
        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("Alice", "Bob", "Charlie"),
                Arrays.asList("David", "Alice", "Eve"),
                Arrays.asList("Frank", "George", "Alice")
        );

        // Stream pipeline demonstrating all intermediate operations
        List<String> result = nestedList.stream()
                .flatMap(List::stream)           // Flatten nested lists
                .filter(name -> name.startsWith("A")) // Filter names starting with "A"
                .map(String::toUpperCase)        // Convert names to uppercase
                .distinct()                      // Remove duplicates
                .sorted()                        // Sort alphabetically
                .skip(1)                         // Skip the first element
                .limit(2)                        // Limit to 2 elements
                .collect(Collectors.toList());   // Collect into a List

        // Print the result
        System.out.println(result);
    }
}
```

## 14. How are Collections different from Stream?
| Feature        | Collections                          | Streams                                          |
|----------------|--------------------------------------|--------------------------------------------------|
| **Storage**    | Stores elements in memory            | No storage; processes elements on-the-fly        |
| **Nature**     | Eager                                | Lazy                                             |
| **Mutability** | Mutable                              | Immutable                                        |
| **Reusability**| Can be reused                        | Cannot be reused after terminal operation        |
| **Parallelism**| Requires manual setup                | Built-in with `parallelStream()`                 |
| **Operations** | Imperative (e.g., loops)             | Declarative (e.g., lambdas)                      |

## 15. Implement Stream API's filter and map methods by your self.
```
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class CustomStream<T> {
    private List<T> data;

    // Constructor
    public CustomStream(List<T> data) {
        this.data = data;
    }

    // Filter method
    public CustomStream<T> filter(Predicate<? super T> predicate) {
        List<T> filteredData = new ArrayList<>();
        for (T element : data) {
            if (predicate.test(element)) {
                filteredData.add(element);
            }
        }
        return new CustomStream<>(filteredData);
    }

    // Map method
    public <R> CustomStream<R> map(Function<? super T, ? extends R> mapper) {
        List<R> mappedData = new ArrayList<>();
        for (T element : data) {
            mappedData.add(mapper.apply(element));
        }
        return new CustomStream<>(mappedData);
    }

    // Terminal operation: collect into a List
    public List<T> collect() {
        return new ArrayList<>(data);
    }

    // Print method for demonstration
    public void forEach() {
        for (T element : data) {
            System.out.println(element);
        }
    }

    // Main method to test
    public static void main(String[] args) {
        // Example input list
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // Custom Stream Usage
        List<String> result = new CustomStream<>(numbers)
            .filter(n -> n % 2 == 0)               // Keep only even numbers
            .map(n -> "Number: " + n)             // Convert to String with a prefix
            .collect();                           // Collect the result into a List

        // Print the result
        System.out.println(result);
    }
}
```













