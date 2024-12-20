### Learn Java generics by reading and practicing following code:
https://github.com/CTYue/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t01_basic/generic

### Read the follwoing code repo and type it one by one by yourself.
https://github.com/CTYue/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t06_java8/features

### Practice following stream API exercises at least 3 times
https://github.com/gavinklfong/stream-api-exercises/blob/main/src/test/java/space/gavinklfong/demo/streamapi/StreamApiTest.java

### Practice Optional methods at least 2 times
https://github.com/CTYue/chuwa-eij-tutorial/blob/main/02-java-core/src/main/java/com/chuwa/tutorial/t06_java8/exercise/ShoppingCartUtil.java

### Discuss best practices on nullptr exception prevention, provide code snippet for each practice that you mentioned.
```
// use this method 
Optional.ofNullable(null);

// do check before insert or get
List<String> list = new ArrayList<>();
String value = null;
if (value != null) {
    list.add(value);
}


// use try catch
try {
    String input = null;
    input.length();
} catch (NullPointerException e) {
    System.out.println("input is null");
}

```
### Discuss Java 8 new features with code snippet.
```
Interfaces default methods

interface Vehicle {
    default void test() {
        System.out.println("test...");
    }
}


Lambda Expressions

List<String> names = Arrays.asList("a", "b", "c");
names.forEach(name -> System.out.println(name));


Functional Interfaces

Function<String, Integer> function = str -> str.length();
function.apply("test")


Streams API

List<Integer> numbers = Arrays.asList(1, 2, 3);
numbers.stream().filter(num -> num > 2).map(num -> num * num).forEach(System.out::println)

```

### What are the advantages of the Optional class?
```
Prevents nullptr exception by providing methods to handle nullptr cases when value is null
Improves code readability, make code more easier to maintain

```
### Explain Functional Interface and Lambda with code samples.
```
Functional interface in Java has exactly one abstract method and can be implemented using a lambda expression

Lambda Expressions

List<String> names = Arrays.asList("a", "b", "c");
names.forEach(name -> System.out.println(name));


Functional Interfaces

Function<String, Integer> function = str -> str.length();
function.apply("test")
```

### Explain Method Reference with code samples?
```
Method Reference is a short syntax in Java 8 for calling a method by referencing it instead of invoking it directly

Arrays.stream(names).forEach(System.out::println);
```

### Explain "Lambda can use unchanged variable outside of lambda", with code snippet.
```
final int number = 10; 
Runnable lambda = () -> {
    System.out.println("The number is: " + number); 
};
lambda.run();
```
### Can a functional interface extend/inherit another interface?
```
Yes, a functional interface can extend/inherit another interface,but it must have exactly one abstract method after inherit
```
### What are Intermediate and Terminal operations?
```
Intermediate operations: operations that return another stream not return result
Terminal Operations: trigger the execution of the stream pipeline
```
### Demontrate the most commonly used Intermediate operations in Stream API, with code snippet.
```
// map is most commonly used
List<Integer> numbers = Arrays.asList(1, 2, 3);
numbers.stream().filter(num -> num > 2).map(num -> num * num).forEach(System.out::println)
```
### How are Collections different from Stream?
```
Collections manage data, while Streams process data. 
```
### Implement Stream API's filter and map methods by your self.
```
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class UDFStreamAPI<T> {
    private final List<T> data;

    public UDFStreamAPI(List<T> data) {
        this.data = data;
    }

    public UDFStreamAPI<T> filter(Predicate<T> predicate) {
        List<T> filteredList = new ArrayList<>();
        for (T element : data) {
            if (predicate.test(element)) {
                filteredList.add(element);
            }
        }
        return new UDFStreamAPI<>(filteredList);
    }

    public <R> UDFStreamAPI<R> map(Function<T, R> mapper) {
        List<R> mappedList = new ArrayList<>();
        for (T element : data) {
            mappedList.add(mapper.apply(element));
        }
        return new UDFStreamAPI<>(mappedList);
    }

    public static void main(String[] args) {
        List<Integer> numbers = new LinkedList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        UDFStreamAPI<Integer> map = new UDFStreamAPI<>(numbers)
                .filter(num -> num >= 2)
                .map(num -> num * num);
        System.out.println(map.data);
    }
}
```

