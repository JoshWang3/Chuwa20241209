### Learn Java generics by reading and practicing following code:
https://github.com/CTYue/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t01_basic/generic
### Read the follwoing code repo and type it one by one by yourself.
   https://github.com/CTYue/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t06_java8/features
### Practice following stream API exercises at least 3 times
   https://github.com/gavinklfong/stream-api-exercises/blob/main/src/test/java/space/gavinklfong/demo/streamapi/StreamApiTest.java
### Practice Optional methods at least 2 times
   https://github.com/CTYue/chuwa-eij-tutorial/blob/main/02-java-core/src/main/java/com/chuwa/tutorial/t06_java8/exercise/ShoppingCartUtil.java
### Discuss best practices on nullptr exception prevention, provide code snippet for each practice that you mentioned.
- Use Optional to Handle Nullable Values
```
import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        Optional<String> optionalValue = Optional.ofNullable(getValue());
        System.out.println(optionalValue.orElse("Default Value")); // Output: Default Value
    }

    private static String getValue() {
        return null; // Simulating a nullable value
    }
}

```

- Avoid Returning or Accepting null

```
import java.util.Collections;
import java.util.List;

public class AvoidNullExample {
    public static void main(String[] args) {
        List<String> names = getNames();
        System.out.println(names.size()); // Output: 0
    }

    private static List<String> getNames() {
        return Collections.emptyList(); // Return empty list instead of null
    }
}

```

### Discuss Java 8 new features with code snippet.
- Functional interface
``` 
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println(isEven.test(4)); // Output: true
    }
}

```

- Lambda Expressions
```
import java.util.Arrays;
import java.util.List;

public class LambdaExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        names.forEach(name -> System.out.println("Hello, " + name));
    }
}

```
- Stream API
``` 
import java.util.Arrays;
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream().filter(n -> n % 2 == 0).mapToInt(n -> n).sum();
        System.out.println("Sum of even numbers: " + sum); // Output: 6
    }
}

```

- Optional Class
```
import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        Optional<String> optional = Optional.ofNullable(null);
        System.out.println(optional.orElse("Default Value")); // Output: Default Value
    }
}

```

### What are the advantages of the Optional class?
- Avoids NullPointerException:
- Encourages Functional Programming:

### Explain Functional Interface and Lambda with code samples.
Functional interface in Java is an interface that has exactly one abstract method.

Lambda expression is a concise way to represent a functional interface implementation.

They are working together to simplify the code.
```
@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}

public class LambdaExample {
    public static void main(String[] args) {
       
        Calculator add = (a, b) -> a + b;

        Calculator multiply = (a, b) -> a * b;

        System.out.println("Addition: " + add.calculate(5, 3));       // Output: 8
        System.out.println("Multiplication: " + multiply.calculate(5, 3)); // Output: 15
    }
}

```

### Explain Method Reference with code samples?
**_Method references_** are a shorthand for writing lambda expressions that call an existing method.

- Reference to a Static Method

- Syntax: **_ClassName::methodName_**
```
import java.util.function.Function;

public class StaticMethodReference {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {
        Function<String, String> upperCase = String::toUpperCase;
        System.out.println(upperCase.apply("hello")); // Output: HELLO
    }
}
```
- Reference to an Instance Method of a Particular Object

- Syntax: **_object::methodName_**
```
import java.util.function.Consumer;

public class InstanceMethodReference {
    public void display(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {
        InstanceMethodReference obj = new InstanceMethodReference();
    }
}   

import java.util.function.Consumer;

public class InstanceMethodReference {
    public void display(String message) {
        System.out.println("Message: " + message);
    }

    public static void main(String[] args) {
        InstanceMethodReference obj = new InstanceMethodReference();

        // Reference to an instance method of a particular object
        Consumer<String> printer = obj::display;

        printer.accept("Hello, World!"); // Output: Message: Hello, World!
    }
}

```
- Reference to an Instance Method of an Arbitrary Object of a Particular Type

- Syntax: **_ClassName::methodName_**
```
import java.util.Arrays;
import java.util.List;

public class ArbitraryObjectMethodReference {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // Reference to an instance method of an arbitrary object (toString)
        names.forEach(System.out::println);
    }
}
```

- Reference to a Constructor

- Syntax: **_ClassName::new_**
```
import java.util.function.Supplier;

class Person {
    public Person() {
        System.out.println("Person created!");
    }
}

public class ConstructorReference {
    public static void main(String[] args) {
        // Reference to a constructor
        Supplier<Person> personSupplier = Person::new;

        // Creates a new Person object
        Person person = personSupplier.get(); // Output: Person created!
    }
}

```


### Explain "Lambda can use unchanged variable outside of lambda", with code snippet.
Lambda expressions can access variables from their surrounding scope. However, these variables must be effectively final,
meaning their value cannot be modified after they are assigned. This restriction ensures thread safety when lambdas are executed in parallel or asynchronous environments.
```
public class Hello {
    public static void main(String[] args) {
        String greeting = "Hello"; // Effectively final

        Runnable lambda = () -> System.out.println(greeting); 

        lambda.run(); // Output: Hello
    }
}

```

### Can a functional interface extend/inherit another interface?
Yes. When a functional interface extends another functional interface, the abstract method from the parent interface becomes part of the child interface.
The child interface can add default or static methods but must not add more abstract methods.

### What are Intermediate and Terminal operations?
- Intermediate operations:
  - These operations transform the elements of a stream and return a new _**stream**_ as a result. 
  - Intermediate operations do not produce a final result directly. they are usually combined using method chaining. 
  - Examples of some common intermediate operations are _filter, map, sorted, distinct, limit, flatMap, skip,_ etc.
- Terminal operations:
  - Terminal operations produce a _**result**_ such as a value or a collection. 
  - Examples of some common terminal operations are _collect, forEach, reduce, count, anyMatch, allMatch, noneMatch,_ etc.

### Demonstrate the most commonly used Intermediate operations in Stream API, with code snippet.
- filter(Predicate<T> predicate)
```
import java.util.Arrays;
import java.util.List;

public class FilterExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
        names.stream()
             .filter(name -> name.startsWith("A"))
             .forEach(System.out::println); // Output: Alice
    }
}

```

- map(Function<T, R> mapper)
```
import java.util.Arrays;
import java.util.List;

public class MapExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        names.stream()
             .map(String::toUpperCase)
             .forEach(System.out::println); 
        // Output: ALICE, BOB, CHARLIE
    }
}

```

### How are Collections different from Stream?
- Collection: 
  - Data structure holds all the data elements
  - External Iteration
  - Can be processed any number of times
  - Elements are easy to access
  - Is a data store
- Stream:
  - No data is stored. Have the capacity to process an infinite number of elements on demand
  - Internal Iteration
  - Traversed only once
  - No direct way of accessing specific elements
  - Is an API to process the data
  
### Implement Stream API's filter and map methods by your self.
```
import java.util.Arrays;
import java.util.List;

public class CombinedOperationsExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Bob");

        names.stream()
             .filter(name -> name.length() > 3)  // Keep names longer than 3 characters
             .distinct()                        // Remove duplicates
             .sorted()                          // Sort alphabetically
             .map(String::toUpperCase)          // Convert to uppercase
             .forEach(System.out::println);     // Output each name
        // Output: ALICE, CHARLIE, DAVID
    }
}

```