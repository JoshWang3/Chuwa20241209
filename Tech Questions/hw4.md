## 1. Learn Java generics by reading and practicing following code:

https://github.com/CTYue/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t01_basic/generic

## 2. Read the follwoing code repo and type it one by one by yourself.

https://github.com/CTYue/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t06_java8/features

## 3. Practice following stream API exercises at least 3 times

https://github.com/gavinklfong/stream-api-exercises/blob/main/src/test/java/space/gavinklfong/demo/streamapi/StreamApiTest.java

## 4. Practice Optional methods at least 2 times

https://github.com/CTYue/chuwa-eij-tutorial/blob/main/02-java-core/src/main/java/com/chuwa/tutorial/t6_java8/exercise/ShoppingCartUtil.java

## 5. Discuss best practices on nullptr exception prevention, provide code snippet for each practice that you mentioned.

## 5. Discuss Best Practices on `NullPointerException` Prevention

### (with Code Snippets for Each Practice)

A `NullPointerException` (NPE) occurs when an object reference that is `null` is accessed or modified. Below are five best practices to prevent NPEs in Java applications.

---

### 1. Use `Objects.requireNonNull()` to Validate Inputs Early

Fail fast by validating that method parameters are not null.

```java
import java.util.Objects;

public void setName(String name) {
    this.name = Objects.requireNonNull(name, "Name must not be null");
}
```

---

### 2. Use `Optional` for Potentially Missing Values

`Optional` is a container that may or may not contain a non-null value. It forces developers to handle absence explicitly.

```java
import java.util.Optional;

public Optional<String> getUsername(User user) {
    return Optional.ofNullable(user.getName());
}

// Usage
Optional<String> name = getUsername(user);
System.out.println(name.orElse("Guest"));
```

---

### 3. Use Null-Safe Comparisons

Avoid calling methods on potentially null objects. Instead, use a constant or utility method to perform the comparison.

```java
// Not safe: might throw NullPointerException
if (name.equals("Admin")) {
    // ...
}

// Safe: calls equals on the constant string
if ("Admin".equals(name)) {
    // ...
}
```

---

### 4. Check for Null Before Accessing Object Members

Always check if an object is null before accessing its fields or methods, especially with chained access.

```java
if (user != null && user.getProfile() != null) {
    System.out.println(user.getProfile().getEmail());
}
```

---

### 5. Use Constructors or Builders to Enforce Non-Null Fields

Ensure that important fields are initialized and validated during object creation to prevent null usage later.

```java
public class Employee {
    private final String name;

    public Employee(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name cannot be null");
        }
        this.name = name;
    }
}
```

---

By applying these best practices, you can greatly reduce the likelihood of encountering `NullPointerException` in your Java code, and write more robust, readable, and error-resistant programs.

## 6. Discuss Java 8 new features with code snippet.

Java 8 introduced several powerful features that enable functional-style programming and improve code readability and efficiency. Below are some of the key features with examples.

---

### 1. Lambda Expressions

Lambdas allow you to write concise and functional-style code, especially when working with collections or functional interfaces.

```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

names.forEach(name -> System.out.println("Hello, " + name));
```

---

### 2. Functional Interfaces

A functional interface is an interface with a single abstract method. Java 8 provides built-in ones like `Predicate`, `Function`, and `Consumer`.

```java
@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}

Greeting greet = (name) -> System.out.println("Hi " + name);
greet.sayHello("Java");
```

---

### 3. Stream API

Stream API is used for processing collections in a declarative and functional way.

```java
List<String> list = Arrays.asList("apple", "banana", "cherry");

list.stream()
    .filter(s -> s.startsWith("b"))
    .map(String::toUpperCase)
    .forEach(System.out::println); // Output: BANANA
```

---

### 4. Default and Static Methods in Interfaces

Interfaces can now contain method implementations using `default` or `static` keywords.

```java
interface Vehicle {
    default void start() {
        System.out.println("Vehicle is starting");
    }

    static void stop() {
        System.out.println("Vehicle stopped");
    }
}

class Car implements Vehicle {}

Car car = new Car();
car.start(); // Vehicle is starting
Vehicle.stop(); // Vehicle stopped
```

---

### 5. Optional Class

`Optional` helps handle null values safely and clearly.

```java
Optional<String> name = Optional.ofNullable(getName());
System.out.println(name.orElse("Guest"));

public static String getName() {
    return null;
}
```

---

### 6. Method References

A shorthand for lambda expressions when calling an existing method.

```java
List<String> names = Arrays.asList("Tom", "Jerry", "Spike");

names.forEach(System.out::println); // Instead of names.forEach(name -> System.out.println(name));
```

---

### 7. Date and Time API (`java.time`)

Java 8 introduced a modern, immutable, and thread-safe date/time API.

```java
LocalDate today = LocalDate.now();
LocalDate birthday = LocalDate.of(2000, Month.JANUARY, 1);

System.out.println("Today: " + today);
System.out.println("Birthday: " + birthday);
```

---

By incorporating these features, Java 8 enables more concise, expressive, and robust coding practices.

## 7. What are the advantages of the Optional class?

- **Avoids NullPointerException:** Makes it safer to handle potentially missing values.
- **Improves Code Clarity:** Clearly indicates that a value may or may not be present.
- **Provides Safe API Methods:** Offers methods like `orElse()`, `ifPresent()`, `map()` for better null handling.
- **Supports Functional Style:** Works well with lambdas and stream pipelines.
- **Promotes Better API Design:** Encourages returning `Optional` instead of `null`, making code more predictable.

```java
Optional<String> name = Optional.ofNullable(getName());
System.out.println(name.orElse("Guest")); // Output: Guest if null
```

## 8. Explain Functional Interface and Lambda with code samples.

## 8. Explain Functional Interface and Lambda with Code Samples

### Functional Interface:

A **functional interface** is an interface that has **exactly one abstract method**. It can have default and static methods too.

- Annotated with `@FunctionalInterface` for clarity.
- Used as the target for **lambda expressions**.

```java
@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}
```

---

### Lambda Expression:

A **lambda expression** is a shorthand way to implement a functional interface using concise syntax.

```java
Greeting greet = (name) -> System.out.println("Hello, " + name);
greet.sayHello("Java");
```

---

### Built-in Functional Interfaces (from `java.util.function`):

- `Consumer<T>` – takes input, returns nothing.
- `Function<T, R>` – takes input, returns output.
- `Predicate<T>` – takes input, returns boolean.
- `Supplier<T>` – takes no input, returns value.

```java
Predicate<String> isLong = str -> str.length() > 5;
System.out.println(isLong.test("Hello")); // false
```

---

## 9. Explain Method Reference with code samples?

**Method reference** is a shorthand syntax for writing lambda expressions that **call an existing method**. It improves code readability and reusability.

---

### Types of Method References:

#### 1. Reference to a Static Method

```java
public class Utils {
    public static void print(String msg) {
        System.out.println(msg);
    }
}

// Usage
List<String> list = Arrays.asList("A", "B", "C");
list.forEach(Utils::print);
```

---

#### 2. Reference to an Instance Method of a Particular Object

```java
public class Printer {
    public void print(String s) {
        System.out.println(s);
    }
}

// Usage
Printer printer = new Printer();
list.forEach(printer::print);
```

---

#### 3. Reference to an Instance Method of an Arbitrary Object of a Class

```java
List<String> names = Arrays.asList("alice", "bob", "charlie");
names.forEach(String::toUpperCase); // won't print directly

// To print
names.stream()
     .map(String::toUpperCase)
     .forEach(System.out::println);
```

---

#### 4. Reference to a Constructor

```java
interface MessageCreator {
    Message create(String content);
}

class Message {
    Message(String content) {
        System.out.println("Message: " + content);
    }
}

// Usage
MessageCreator creator = Message::new;
creator.create("Hello!");
```

---

## 10. Explain "Lambda can use unchanged variable outside of lambda", with code snippet.

- In Java, a **lambda expression can access variables from the enclosing scope**, but only if those variables are **effectively final** — meaning their values do not change after they are assigned. This restriction ensures **thread safety and predictability**, since lambdas can be executed later (e.g., in streams or threads), and accessing mutable external variables could cause unexpected behavior.

```
public class LambdaScopeExample {
    public static void main(String[] args) {
        String greeting = "Hello"; // effectively final

        Runnable r = () -> {
            System.out.println(greeting + ", world!");
        };

        r.run();
    }
}
```

## 11. Can a functional interface extend/inherit another interface?

- **Yes**, a functional interface in Java **can extend another interface**, including another functional interface — as long as the resulting interface still has **only one abstract method**. This allows for interface reuse while preserving functional behavior.

## 12. What are Intermediate and Terminal operations?

- In Java 8's **Stream API**, operations are categorized as **intermediate** or **terminal**.

---

### Intermediate Operations

- Return a **new stream**.
- Are **lazy** — they don't process data until a terminal operation is invoked.
- Can be **chained** together.
- Common examples: `map()`, `filter()`, `sorted()`, `distinct()`, `limit()`.

```java
Stream<String> stream = Stream.of("a", "bb", "ccc");
Stream<String> upper = stream.map(String::toUpperCase).filter(s -> s.length() > 1);
```

> Above code won't execute until a terminal operation is added.

---

### Terminal Operations

- **Trigger the execution** of the stream pipeline.
- Return a **result** (e.g., a value or collection) or perform a **side effect**.
- After a terminal operation, the stream is **consumed** and can’t be reused.

Common examples:

- `forEach()`, `collect()`, `reduce()`, `count()`, `anyMatch()`, `allMatch()`

```java
List<String> result = Stream.of("apple", "banana", "cherry")
    .filter(s -> s.startsWith("b"))
    .map(String::toUpperCase)
    .collect(Collectors.toList());

System.out.println(result); // Output: [BANANA]
```

---

## 13. Demontrate the most commonly used Intermediate operations in Stream API, with code snippet.

**Intermediate operations** are used to transform or filter elements in a stream. They return a new stream and are **lazy**, meaning they only execute when a terminal operation is called.

---

### 1. `filter(Predicate<T>)`

Filters elements that match a condition.

```java
List<String> names = List.of("Alice", "Bob", "Anna", "David");

names.stream()
    .filter(name -> name.startsWith("A"))
    .forEach(System.out::println); // Output: Alice, Anna
```

---

### 2. `map(Function<T, R>)`

Transforms each element in the stream.

```java
List<String> names = List.of("apple", "banana", "cherry");

names.stream()
    .map(String::toUpperCase)
    .forEach(System.out::println); // Output: APPLE, BANANA, CHERRY
```

---

### 3. `sorted()`

Sorts the stream elements in natural order (or custom comparator).

```java
List<Integer> numbers = List.of(3, 1, 4, 1, 5);

numbers.stream()
    .sorted()
    .forEach(System.out::println); // Output: 1, 1, 3, 4, 5
```

---

### 4. `distinct()`

Removes duplicate elements.

```java
List<String> fruits = List.of("apple", "banana", "apple", "orange");

fruits.stream()
    .distinct()
    .forEach(System.out::println); // Output: apple, banana, orange
```

---

### 5. `limit(n)` and `skip(n)`

- `limit(n)` keeps only the first `n` elements.
- `skip(n)` ignores the first `n` elements.

```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

numbers.stream()
    .skip(2)
    .limit(3)
    .forEach(System.out::println); // Output: 3, 4, 5
```

---

### Summary Table

| Operation    | Purpose                             |
| ------------ | ----------------------------------- |
| `filter()`   | Selects elements based on condition |
| `map()`      | Transforms elements                 |
| `sorted()`   | Sorts the stream                    |
| `distinct()` | Removes duplicates                  |
| `limit()`    | Limits the number of elements       |
| `skip()`     | Skips the first N elements          |

## 14. How are Collections different from Stream?

- **Collections** store and manage data in memory (e.g., `List`, `Set`, `Map`), and can be modified.
- **Streams** are used to process data from collections in a **declarative**, **functional-style** pipeline, without modifying the original data.

## 15. Implement Stream API's filter and map methods by yourself.

You can mimic the behavior of `filter` and `map` using Java’s functional interfaces like `Predicate` and `Function`.

---

### Custom `filter` Implementation

```java
public static <T> List<T> myFilter(List<T> list, Predicate<T> predicate) {
    List<T> result = new ArrayList<>();
    for (T item : list) {
        if (predicate.test(item)) {
            result.add(item);
        }
    }
    return result;
}
```

**Usage:**

```java
List<String> names = List.of("Alice", "Bob", "Anna");
List<String> filtered = myFilter(names, name -> name.startsWith("A"));
System.out.println(filtered); // Output: [Alice, Anna]
```

---

### Custom `map` Implementation

```java
public static <T, R> List<R> myMap(List<T> list, Function<T, R> mapper) {
    List<R> result = new ArrayList<>();
    for (T item : list) {
        result.add(mapper.apply(item));
    }
    return result;
}
```

**Usage:**

```java
List<String> names = List.of("apple", "banana");
List<Integer> lengths = myMap(names, String::length);
System.out.println(lengths); // Output: [5, 6]
```

---

This demonstrates how the **functional programming concepts behind Stream API** can be implemented using basic Java features.
