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