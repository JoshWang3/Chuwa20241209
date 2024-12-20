## Learn Java Generics

https://github.com/CTYue/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t01_basic/generic

## Reading repo

https://github.com/CTYue/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t06_java8/features

## Practice stream API

https://github.com/gavinklfong/stream-api-exercises/blob/main/src/test/java/space/gavinklfong/demo/streamapi/StreamApiTest.java

## Practice Optional Method

https://github.com/CTYue/chuwa-eij-tutorial/blob/main/02-java-core/src/main/java/com/chuwa/tutorial/t06_java8/exercise/ShoppingCartUtil.java

## Null Pointer Exception prevention practice  

```
//Always Null Check First
public class NullCheckExample {
    public static void main(String[] args) {
        String name = null;

        // Null check before accessing the object
        if (name != null) {
            System.out.println(name.length());
        } else {
            System.out.println("Name is null");
        }
    }
}

//Null CHeck from parent object
public class NullCheckExample {
    public static void main(String[] args) {
        String name = null;

        // Null check before accessing the object
        if (name != null) {
            System.out.println(name.length());
        } else {
            System.out.println("Name is null");
        }
    }
}

//Use try-catch
public class TryCatchExample {
    public static void main(String[] args) {
        String data = null;

        try {
            // Code that might throw NullPointerException
            System.out.println(data.length());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        }
    }
}
```
## Java 8 new features with code snippet  

### Lambda Expressions
```
import java.util.Arrays;
import java.util.List;

public class LambdaExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // Using Lambda Expression
        names.forEach(name -> System.out.println("Hello, " + name));
    }
}
```
### Stream API
```
import java.util.Arrays;
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Filter even numbers and print
        numbers.stream()
               .filter(num -> num % 2 == 0)
               .forEach(System.out::println);
    }
}
```
### Functional Interface
```
import java.util.function.Predicate;

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        Predicate<Integer> isEven = num -> num % 2 == 0;

        System.out.println(isEven.test(4)); // true
        System.out.println(isEven.test(5)); // false
    }
}
```
## What are the advantages of the optional class?  

The optional class in Java 8 provides a container object that may or may not contain a non-null value, helping to avoid NullPointerException.  

## explain functional interface and lambda with code samples  

A functional interface in Java is an interface with exactly one abstract method. It can have default and static methods but must have only one abstract method. These interfaces are often used with lambda expressions for concise and functional-style programming.
```
//create a functional interface
@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}

//using a lambda expression with functional interface
@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}
```
## explain method reference with code samples
```
ClassName::staticMethodName

import java.util.function.Function;

public class StaticMethodReferenceExample {
    public static void main(String[] args) {
        // Lambda Expression
        Function<String, Integer> lambda = str -> Integer.parseInt(str);

        // Method Reference to a static method
        Function<String, Integer> methodRef = Integer::parseInt;

        System.out.println(methodRef.apply("123")); // Output: 123
    }
}
```
## Explain lambda can usean  unchanged variable outside of lambda with a code snippet
```
import java.util.function.Consumer;

public class LambdaEffectivelyFinalExample {
    public static void main(String[] args) {
        // A local variable outside the lambda
        String greeting = "Hello";

        // Lambda expression accessing the local variable
        Consumer<String> sayHello = name -> System.out.println(greeting + ", " + name);

        // Using the lambda
        sayHello.accept("Alice"); // Output: Hello, Alice
        sayHello.accept("Bob");   // Output: Hello, Bob
    }
}
```
## can a functional interface extend/inherit another interface?  

Yes, a functional interface in Java can extend (inherit) another interface, including another functional interface. 
```
@FunctionalInterface
interface ParentInterface {
    void parentMethod();
}

@FunctionalInterface
interface ChildInterface extends ParentInterface {
    // Inherits parentMethod() from ParentInterface
}

public class FunctionalInterfaceInheritance {
    public static void main(String[] args) {
        // Using ChildInterface with a lambda
        ChildInterface child = () -> System.out.println("Implementing parentMethod");
        child.parentMethod();
    }
}
```

## what are intermediate and terminal operations  

In Java's Stream API, operations on streams are classified into intermediate and terminal operations based on their behavior and purpose. 
```
import java.util.Arrays;
import java.util.List;

public class IntermediateExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Intermediate operations: filter, map
        numbers.stream()
               .filter(num -> num % 2 == 0) // Filters even numbers
               .map(num -> num * num)       // Squares the remaining numbers
               .forEach(System.out::println); // Terminal operation
    }
}
```
## demonstrate the most commonly used intermediate operations in stream API with code snippet

```
import java.util.Arrays;
import java.util.List;

public class FilterExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        numbers.stream()
               .filter(num -> num % 2 == 0) // Keep even numbers
               .forEach(System.out::println); // Terminal operation
    }
}
```

## how are Collections different from stream?

```
// Imperative with Collections
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
List<Integer> evens = new ArrayList<>();
for (int num : numbers) {
    if (num % 2 == 0) {
        evens.add(num);
    }
}
System.out.println(evens); // [2, 4]

// Declarative with Streams
List<Integer> evenNumbers = numbers.stream()
                                    .filter(num -> num % 2 == 0)
                                    .collect(Collectors.toList());
System.out.println(evenNumbers); // [2, 4]
```
## Implement stream API's filter and map method.

```

//filter
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CustomFilter {
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T element : list) {
            if (predicate.test(element)) {
                result.add(element);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // Use custom filter method
        List<Integer> evens = filter(numbers, num -> num % 2 == 0);

        System.out.println(evens); // Output: [2, 4, 6]
    }
}

//map

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CustomMap {
    public static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {
        List<R> result = new ArrayList<>();
        for (T element : list) {
            result.add(mapper.apply(element));
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie");

        // Use custom map method
        List<Integer> lengths = map(names, String::length);

        System.out.println(lengths); // Output: [5, 3, 7]
    }
}
```








