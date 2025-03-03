5. Discuss best practices on nullptr exception prevention, provide code snippet for each practice that you mentioned.

- Perform Explicit Null Checks
```java
public class ExplicitNullCheckExample {
    public static void main(String[] args) {
        String name = null;

        if (name != null) {
            System.out.println(name.toUpperCase());
        } else {
            System.out.println("Name is null");
        }
    }
}
```
- Use try-catch as a Fallback
```java
public class TryCatchExample {
    public static void main(String[] args) {
        String name = null;

        try {
            System.out.println(name.toUpperCase());
        } catch (NullPointerException e) {
            System.out.println("Caught a NullPointerException! Name was null.");
        }
    }
}
```
- Use Optional Instead of null
```java
public class OptionalExample {
    public static void main(String[] args) {
        Optional<String> name = getName();
        
        String result = name.orElse("Default Name");
        System.out.println(result); 

        name.ifPresent(System.out::println); 
    }

    public static Optional<String> getName() {
        return Optional.empty(); 
    }
}

```

6. Discuss Java 8 new features with code snippet.

- Lambda Expressions

Lambda expressions provide a clear and concise way to represent a method interface using an expression.
```java
public class LambdaExample {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie");
        
        names.forEach(name -> System.out.println("Hello, " + name));
    }
}
```

- Functional Interfaces

An interface with a single abstract method. 
```java
public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        Predicate<Integer> isEven = number -> number % 2 == 0;

        System.out.println(isEven.test(4));
        System.out.println(isEven.test(5));
    }
}
```
- Stream API

Streams provide a declarative way to process collections of data.
```java
public class StreamAPIExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        
        numbers.stream()
               .filter(num -> num % 2 == 0)
               .map(num -> num * num)
               .forEach(System.out::println);
    }
}
```

- Default Methods

Interfaces can now have default and static methods with implementations.
```java
interface Greeting {
    default void sayHello() {
        System.out.println("Hello from the interface!");
    }
}

class CustomGreeting implements Greeting {
    @Override
    public void sayHello() {
        System.out.println("Hello from the custom implementation!");
    }
}

public class Main {
    public static void main(String[] args) {
        CustomGreeting custom = new CustomGreeting();
        custom.sayHello();
    }
}
```

- Optional Class

A container object to avoid NullPointerException. It represents the presence or absence of a value.
```java
public class OptionalExample {
    public static void main(String[] args) {
        Optional<String> name = Optional.ofNullable("Alice");
        
        System.out.println(name.orElse("No name")); 

        name.ifPresent(System.out::println); 
    }
}
```

7. What are the advantages of the Optional class?

   1. Avoids NullPointerException
   2. Improves Code Readability and Intent
   3. Reduces Boilerplate Code
   4. Safely Handle Null Values

8. Explain Functional Interface and Lambda with code samples.

- Lambda Expressions

Lambda expressions provide a clear and concise way to represent a method interface using an expression.
```java
public class LambdaExample {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie");
        
        names.forEach(name -> System.out.println("Hello, " + name));
    }
}
```

- Functional Interfaces

An interface with a single abstract method.
```java
public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        Predicate<Integer> isEven = number -> number % 2 == 0;

        System.out.println(isEven.test(4));
        System.out.println(isEven.test(5));
    }
}
```

9. Explain Method Reference with code samples?

A Method Reference in Java is a shorthand syntax for a lambda expression that executes just one method. 
It's a way to pass a method as a parameter to a function.

- Static Method Reference: `ClassName::staticMethodName`
- Instance Method Reference (Particular Object): `instance::instanceMethodName`
- Instance Method Reference (Arbitrary Object): `ClassName::instanceMethodName`
- Constructor Reference: `ClassName::new`

10. Explain "Lambda can use unchanged variable outside of lambda", with code snippet.
- Lambdas can use variables declared outside their scope if those variables are effectively final.
- Once a variable is assigned a value, you cannot reassign it if it's used in a lambda.
```java
public class LambdaVariableScopeExample {
    public static void main(String[] args) {
        String greeting = "Hello, ";
        
        Consumer<String> greeter = name -> System.out.println(greeting + name);
        
        greeter.accept("Alice"); 
    }
}
```

11. Can a functional interface extend/inherit another interface?

Yes, a functional interface in Java can extend another interface, including both functional and non-functional interfaces. 
However, for the extending interface to remain a functional interface, it must still have exactly one abstract method after inheriting all abstract methods from its parent interfaces.

12. What are Intermediate and Terminal operations?

- Intermediate Operations: Transform the stream but don't execute until a terminal operation is called.
- Terminal Operations: Trigger execution of the stream pipeline and produce a result.

13. Demonstrate the most commonly used Intermediate operations in Stream API, with code snippet.

- filter
```java
public class FilterExample {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie", "David");
        
        names.stream()
             .filter(name -> name.startsWith("B"))
             .forEach(System.out::println); 
    }
}
```

- map
```java
public class MapExample {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie");
        
        names.stream()
             .map(String::toUpperCase)
             .forEach(System.out::println); 
    }
}
```

14. How are Collections different from Stream?

- Collections are data storage structures, designed for CRUD operations.
- Streams are designed for functional, declarative, and pipeline-based processing of data.

15. Implement Stream API's filter and map methods by your self.

```java
import java.util.*;
public class CustomStream<T> {
    private final List<T> elements;

    public CustomStream(List<T> elements) {
        this.elements = elements;
    }

    public static <T> CustomStream<T> of(List<T> elements) {
        return new CustomStream<>(elements);
    }

    public CustomStream<T> filter(Predicate<? super T> predicate) {
        List<T> filtered = new ArrayList<>();
        for (T element : elements) {
            if (predicate.test(element)) {
                filtered.add(element);
            }
        }
        return new CustomStream<>(filtered);
    }

    public <R> CustomStream<R> map(Function<? super T, ? extends R> mapper) {
        List<R> mapped = new ArrayList<>();
        for (T element : elements) {
            mapped.add(mapper.apply(element));
        }
        return new CustomStream<>(mapped);
    }

    public List<T> collect() {
        return elements;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        List<Integer> result = CustomStream.of(numbers)
                .filter(n -> n % 2 == 0) 
                .map(n -> n * n)        
                .collect();

        System.out.println(result); 
    }
}
```