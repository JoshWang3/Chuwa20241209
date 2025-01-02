# HW4
____

### 5. Discuss best practices on nullptr exception prevention, provide code snippet for each practice that you mentioned.

- check for null explicitly
```java
public void printLength(String str) {
    if (str != null) {
        System.out.println("Length: " + str.length());
    } else {
        System.out.println("String is null");
    }
}
```

- use *Optional* tp handle nullable references
```java
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

- Ensure objects are initialized before use
```java
public void printLength(String str) {
    String value = str == null ? "" : str;
    System.out.println("Length: " + value.length());
}
```

### 6. Discuss Java 8 new features with code snippet.

- Lambda Expressions
A concise way to express a single-method interface (functional interface) using an inline implementation.

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

// Filtering and printing numbers greater than 2
numbers.stream()
       .filter(n -> n > 2)
       .forEach(System.out::println);
```

- Optional Class
Optional helps handle null values more gracefully.
```java
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

- Functional Interfaces
Interfaces with a single abstract method (SAM) can be annotated with @FunctionalInterface, can use lambda expressions.

```java
@FunctionalInterface
interface Calculator {
    int add(int a, int b);
}

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        Calculator calculator = (a, b) -> a + b;
        System.out.println("Sum: " + calculator.add(5, 3));
    }
}
```

- Method References
Method references are a feature in Java 8 that provide a shorthand, clean syntax for calling methods by referring to them directly without invoking them.

```java
public class ArbitraryInstanceMethodReference {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        
        // Using method reference for an arbitrary instance
        names.forEach(String::toUpperCase);
    }
}
```

### 7. What are the advantages of the Optioanl class?
- Avoid NullPointerException
- Improved code readability
- Safe null handling

### 8. Explain Functional Interface and Lambda with code samples.

- Functional Interface: An interface with a single abstract method (SAM) is called a functional interface. It can have multiple default or static methods, but only one abstract method.
- Lambda Expression: A concise way to express a single-method interface (functional interface) using an inline implementation.

```java
@FunctionalInterface
interface Calculator {
    // Single abstract method
    int add(int a, int b);
}

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        // Functional Interface uses Lambda Expression
        Calculator calculator = (a, b) -> a + b;
        System.out.println("Sum: " + calculator.add(5, 3));
    }
}
```

### 9. Explain Method Reference with code samples?
- Method references provide a shorthand to use existing methods as lambda expressions.

```java
public class MethodReferenceExample {
   public static void main(String[] args) {
      List<String> names = Arrays.asList("Alice", "Bob", "Charlie");   
         // Using method reference
         names.forEach(System.out::println);
      }
}
```

### 10. Explain "Lambda can use unchanged variable outside of lambda", with code snippet.

```java
public class LambdaExample {
    public static void main(String[] args) {
        int number = 10; // This is an effectively final variable

        Runnable lambda = () -> {
            System.out.println("Number: " + number);
        };

        // Executing the lambda expression
        lambda.run(); // Number: 10

        // Uncommenting the below line will cause a compilation error
        // because `number` would no longer be effectively final.
        // number = 20;
    }
}

```

### 11. Can a functional interface extend/inherit another interface?
Yes, a functional interface in Java can extend or inherit another interface, provided that the inherited interface does not introduce additional abstract methods. If it does, the extending interface will no longer qualify as a functional interface because it will have more than one abstract method.

### 12. What are Intermediate and Terminal operations?
- Intermediate operations: These operations are used to process the stream elements and return a new stream as a result. Examples include filter(), map(), and distinct().
- Terminal operations: These operations are used to trigger the processing of the stream and produce a result. Examples include forEach(), collect(), and reduce().
- Intermediate operations transform a stream into another stream, while terminal operations produce a result.

### 13. Demontrate the most commonly used Intermediate operations in Stream API, with code snippet.
- filter(): Filters the elements of a stream based on a given predicate.
```java
public class FilterExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
        names.stream()
             .filter(name -> name.startsWith("A")) // Filters names starting with "A"
             .forEach(System.out::println);        // Terminal operation
    }
}
// output: Alice
```

- map(): Transforms the elements of a stream using a given function.
```java
public class MapExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        names.stream()
             .map(String::toUpperCase) // Converts each name to uppercase
             .forEach(System.out::println);
    }
}
// output: ALICE, BOB, CHARLIE
```

- distinct(): Removes duplicate elements from a stream.
```java
public class DistinctExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        numbers.stream()
               .distinct() // Removes duplicates
               .forEach(System.out::println);
    }
}
// output: 1, 2, 3, 4, 5
```

- sorted(): Sorts the elements of a stream.
```java
public class SortedExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 3);
        numbers.stream()
               .sorted() // Sorts in natural order
               .forEach(System.out::println);
    }
}
// output: 1, 2, 3, 5, 8
```

- flatMap(): Flattens a stream of streams into a single stream.
```java
public class FlatMapExample {
    public static void main(String[] args) {
        List<List<String>> nestedList = Arrays.asList(
            Arrays.asList("Alice", "Bob"),
            Arrays.asList("Charlie", "David")
        );

        nestedList.stream()
                  .flatMap(List::stream) // Flattens the nested lists
                  .forEach(System.out::println);
    }
}
// output: Alice, Bob, Charlie, David
```

### 14. How are Collections different from Stream?
- Collections focus on storing and managing elements in memory, while streams focus on processing elements in a functional style.
- Collections are eager, meaning they store all elements in memory, while streams are lazy, meaning they process elements on-demand.
- Collections are mutable, while streams are immutable.

### 15. Implement Stream API's filter and map methods by your self.
```java
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class CustomStreamAPI {
    
    // Custom filter method
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> filteredList = new ArrayList<>();
        for (T element : list) {
            if (predicate.test(element)) {
                filteredList.add(element);
            }
        }
        return filteredList;
    }

    // Custom map method
    public static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {
        List<R> mappedList = new ArrayList<>();
        for (T element : list) {
            mappedList.add(mapper.apply(element));
        }
        return mappedList;
    }

    public static void main(String[] args) {
        // Example usage
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // Filter: Keep only even numbers
        List<Integer> evenNumbers = filter(numbers, n -> n % 2 == 0);
        System.out.println("Filtered (even numbers): " + evenNumbers);

        // Map: Multiply each number by 2
        List<Integer> doubledNumbers = map(numbers, n -> n * 2);
        System.out.println("Mapped (doubled numbers): " + doubledNumbers);
    }
}

```




















