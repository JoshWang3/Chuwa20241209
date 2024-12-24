# Homework 4
## Questions
### 1. Learn Java generics by reading and practicing following code: https://github.com/CTYue/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/tO1_basic/generic

### 2. Read the follwoing code repo and type it one by one by yourself. https://github.com/CTYue/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/tO6_java8/features

### 3. Practice following stream API exercises at least 3 times https://github.com/gavink|fong/stream-api-exercises/blob/main/src/test/java/space/gavinklfong/demo/streamapi/StreamApiTest.java

### 4. Practice Optional methods at least 2 times https://github.com/CTYue/chuwa-eij-tutorial/blob/main/02-java-core/src/main/java/com/chuwa/tutorial/to6_java8/exercise/ShoppingCartUtil.java

### 5. Discuss best practices on nullptr exception prevention, provide code snippet for each practice that you mentioned.
Avoiding npr:
 
1. Always null check first
2. null check from parent object to nested/inner object
3. try catch
4.
 
String str1;
str1.equals("Chuwa");
"Chuwa".equals(str1);
 
5. Optional
...
 
 
{1,2,3,4,5,6,7,8...}
1. filter out odd
2. 在上述数字中选出xxxxxxx (very large number)的质数
3. 生成一个string，用于打印结果，string当中得包含足够的解释说明
4. 将上述结果打包成一个map, key: Integer, value: String
 
 
Assuming the given array has a length of Integer.MAX_VALUE
the array has a size of xxxxxxx byte
 
you may need to copy it, or partially copy

1. Avoid Using Null Whenever Possible
2. Check for Null Before Accessing an Object
3. Use Objects.requireNonNull
4. Use Ternary Operator for Default Values
5. Avoid Returning Null Collections or Arrays
6. Use the Optional Class for Method Returns
7. Use Try-Catch for Critical Null Safety

### 6. Discuss Java 8 new features with code snippet.

Java 8 new features are lambda expressions, method references, streams, and default methods.

1. Lambda expressions are used in writing concise, anonymous functions especially when working with collections and functional interfaces.
```java
Collections.sort(inventory, new Comparator<Apple>() {
    public int compare(Apple a1, Apple a2){
        return a1.getWeight().compareTo(a2.getWeight());
    }
});

// Using lambda expression
inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));
// comibining with method reference
inventory.sort(comparing(Apple::getWeight));
```

2. Method references are a special type of lambda expressions to create simple lambda expressions by referencing existing methods.
```java
// capitalizing and printing a list of Strings
List<String> messages = Arrays.asList("hello", "world!");
messages.forEach(word -> StringUtils.capitalize(word));

// using method references
messages.forEach(StringUtils::capitalize);
```

3. Stream API are for processing collections of data in a functional and parallelizable way.
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

// Calculate the sum of even numbers using the Stream API
int sum = numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();

System.out.println("Sum of even numbers: " + sum);

```

4. Default and static methods

Default methods are added to Java 8 largely to support library designers by enabling them to write more evolvable interfaces.

```java
interface Interface {
    void doSomething();

    default void defaultMethod() {
        System.out.println("Default method implementation");
    }

    static void staticMethod() {
        System.out.println("Static method implementation");
    }
}
```

### 7. What are the advantages of the Optional class?

In Java, "Optional" is a wrapper class that encapsulates an optional value. It supports many methods such as map, flatMap, and filter, which are conceptually similar to the methods of a stream. Using Optional forces us to actively unwrap an optional to deal with the absence of a value, and as a result, we protect our code against unintended null pointer exceptions. It can help us design better APIs in which, just by reading the signature of a method, users can tell whether to expect an optional value.

### 8. Explain Functional Interface and Lambda with code samples.

In Java, functional interface is an interface that contains exactly one abstract method. It can have any number of default and static methods, but only one abstract method makes it functional. Functional interfaces are used as the target for lambda expressions and method references.

```java
@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}

// Lambda Expression for Functional Interface
Greeting greeting = (name) -> System.out.println("Hello, " + name + "!");
greeting.sayHello("Alice"); // Output: Hello, Alice!
```

### 9. Explain Method Reference with code samples?

Method references are a special type of lambda expressions which are often used to create simple lambda expressions by referencing existing methods. There are four kinds of method references:
1. Static methods
```java
Function<String, Integer> parseInt = Integer::parseInt;
Integer number = parseInt.apply("123");
```
2. Instance methods of particular objects
```java
String instance = "hello";
Supplier<String> toUpperCase = instance::toUpperCase;
System.out.println(toUpperCase.get());
```
3. Instance methods of an arbitrary object of a particular type
```java
names.sort(String::compareToIgnoreCase);
```
4. Constructor
```java
Supplier<List<String>> listSupplier = ArrayList::new;
List<String> newList = listSupplier.get();
```

### 10. Explain "Lambda can use unchanged variable outside of lambda", with code snippet.
In Java, lambda expressions can access variables defined outside their scope provided that the variables are effectively final, which means it is not modified after it is assigned a value even if it is not explicitly declared with "final" keyword. This ensures thread-safety and avoids ambiguity in lambda expressions.

```java
 String greeting = "Hello";

// Lambda using the variable
Consumer<String> greeter = (name) -> System.out.println(greeting + ", " + name);

greeter.accept("Alice"); // Output: Hello, Alice
```

### 11. Can a functional interface extend/inherit another interface?
Yes, a functional interface can extend/inherit another interface if it follows "Single Abstract Method Rule". If it inherits multiple abstract methods, it cannot be considered a functional interface unless all inherited abstract methods have the same signature (method name, return type, and parameter list).
```java
@FunctionalInterface
interface Parent {
    void greet(String message);
}

@FunctionalInterface
interface Child extends Parent {
    // Inherits the abstract method `greet(String message)` from Parent
}

// demo
Child child = (msg) -> System.out.println("Child says: " + msg);
child.greet("Hello!"); // Output: Child says: Hello!
```

### 12. What are Intermediate and Terminal operations?

In Java's Streams API, operations are classified into two categories: Intermediate operations and Terminal operations.

1. Intermediate operations transform a stream into another stream. They return a new stream and are not executed until a terminal operation is invoked. They are chained to build a processing pipeline. Commonly used operations are `filter(Predicate)`, `map(Function)`, `distinct()`, and `sorted()`.

2. Terminal operations produce a result or a side effect from a stream. They trigger the execution of the intermediate operations pipeline. They are eager, meaning they execute the entire pipeline of operations. After a terminal operation is invoked, the stream is consumed and cannot be reused. Some examples are `forEach(Consumer)`, `collect(Collector)`, `reduce(BinaryOperator)`, and `count()`.

### 13. Demontrate the most commonly used Intermediate operations in Stream API, with code snippet.
```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Alice");
// intermediate operations: filter, map, and distinct
Stream<String> intermediateStream = names.stream()
                                            .filter(name -> name.startsWith("A"))
                                            .map(String::toUpperCase)            
                                            .distinct();   
// terminal operation: forEach
intermediateStream.forEach(System.out::println); // Output: ALICE
```

### 14. How are Collections different from Stream?
Collections are used to store and manage data in memory, supporting direct modification and eager execution of operations like adding or removing elements. Streams are used for functional-style data processing through pipelines, offering lazy evaluation and immutable operations, executed only with a terminal operation. They are complement each other: Collections handle data storage, while Streams provide efficient and declarative processing capabilities.

### 15. Implement Stream APl's filter and map methods by your self.