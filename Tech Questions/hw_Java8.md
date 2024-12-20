## Learn Java generics by reading and practicing following code: https://github.com/CTYue/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t01_basic/generic
## Read the following code repo and type it one by one by yourself: https://github.com/CTYue/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t06_java8/features
## Practice following stream API exercises at least 3 times: https://github.com/gavinklfong/stream-api-exercises/blob/main/src/test/java/space/gavinklfong/demo/streamapi/StreamApiTest.java
## Practice Optional methods at least 2 times: https://github.com/CTYue/chuwa-eij-tutorial/blob/main/02-java-core/src/main/java/com/chuwa/tutorial/t06_java8/exercise/ShoppingCartUtil.java
## Discuss best practices on nullptr exception prevention, provide code snippet for each practice that you mentioned.
```java
import org.apache.commons.lang3.StringUtils;
import java.util.Collections;
import java.util.Optional;

// 1. use the ternary operator
String input = null;
String res = (input != null) ? input : "default";

// 2. StringUtils
boolean isBlank = StringUtils.isBlank(input);

// 3. Use Primitives over objects;
int primitiveInt = 0;
Integer objectInt = null;

// 4. Avoid returning null in methods
public List<String> getStrings() {
    return Collections;
}

// 5. Use .equal() safely 
boolean isEqual = "hello".equals(input);

// 6. Prevent passing null as a method argument
public void doSomething(@NotNull String input) {
    // Method impl.
}

// 7. Use null object pattern
public interface Animal {
    void makeSound();
}
public class Dog implements Animal { 
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
}
public class NullAnimal implements Animal {
    @Override
    public void makeSound() {
        // Do nothing
    }
}
public class AnimalFactory {
    public Animal getAnimal(String type) {
        if ("Dog".equalsIgnoreCase(type)) {
            return new Dog();
        }
        return new NullAnimal();
    }
}

// Use the Java Stream API to handle null values in collections
public class Main {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Hello", null, "World");
        strings = strings.stream().filter(Objects::nonNull).collect(Collectors.toList());
    }
}

// Validate method arguments with a dedicated utility method
public static <T> T checkNotNull(T reference, String errorMessage) {
    if (reference == null) {
        throw new IllegalArgumentException(errorMessage);
    }
    return reference;
}
public void doSomething(String input) {
    input = checkNotNull(input, "Input should not be null");
    // Method implementation
}

// Use the Optional class
public class OptionalExample {
    private String someString;
    public OptionalExample(String str) {
        this.someString = str;
    }
    
    public Optional<String> getString() {
        return Optional.ofNullable(someString);
    }
    
    public static void main(String[] args) {
        //Usage
        OptionalExample example1 = new OptionalExample("Hello, World!");
        Optional<String> optString1 = example1.getString();
        String value1 = optString1.orElse("default");
        System.out.println(value1); // Output: Hello, World!
        OptionalExample example2 = new OptionalExample(null);
        Optional<String> optString2 = example2.getString();
        String value2 = optString2.orElse("default");
        System.out.println(value2); // Output: default
    }
}

// Assert
public class MyClass() {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        List<String> result = obj.getStrings();
        assertNotNull(result); // Ensure the result is not null
    }
}
```

## Discuss Java 8 new features with code snippet.

```java
import java.util.Comparator;
import java.util.Arrays;
/**
 * 1. Default method and static method in interface
 * @FunctionalInterface Not required. 
 *  -- functional interface only has one single abstract method
 *  -- can have many default and static methods
 */
@FunctionalInterface
public interface someAPI {

    static final String BLOG = "Hello Interface";

    int add(int a, int b);

    default int substract(int a, int b) {
        return a - b;
    }

    default int adder(int a, int b) {
        return a + b;
    }

    static String getBlog() {
        return BLOG;
    }
}

/**
 * 2. Lambda
 *  -- To replace anonymous inner class
 *  -- work with functional interface
 *  -- Lambda can use unchanged variable outside of lambda -> final variable 
 */
public class Main {
    public static void main(String[] args) {
        // Anonymous
        Comparator<Integer> comparator1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        // Lambda
        Comparator<Integer> comparator2 = (o1, o2) -> Integer.compare(o1, o2);
    }
}

/**
 * 3. Method Reference
 */
public class Main {
    public static void main(String[] args) {
        Arrays.sort(stringsArray,(s1,s2) -> s1.compareToIgnoreCase(s2));
        Arrays.sort(stringsArray, String::compareToIgnoreCase);
    }
}


/**
 * 4. Optional 
 *  -- To avoid Null checks and run time NullPointerExceptions
 */
public class Main {
    public static void main(String[] args) {
        Map<Integer, User> userMap = new HashMap<>();
        userMap.put(1, new User("Alice", new Address("Main Street")));
        userMap.put(2, new User("Bob", null));
        String streetName = Optional.ofNullable(userMap.get(2))
                .map(User::getAddress)
                .map(Address::getStreet)
                .orElse("Unknown");
    }
}

/**
 * 5. Stream API
 *  -- once create, does not change its source
 *  -- can't be reused. close is closed
 *  -- does not store values
 *  three parts:
 *      1. create stream
 *      2. intermediate operation: filer, map, sort
 *      3. terminate operation: foreach, groupby
 */
public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eva",
                "Frank");
        List<String> filteredNames = names.stream() // Convert the list to a stream
                .filter(name -> name.length() >= 4) // Keep only the names with at  least 4 characters
                .map(String::toUpperCase) // Convert all names to uppercase
                .sorted((name1, name2) -> name2.length() - name1.length()) // Sort names by decreasing length
                .collect(Collectors.toList()); // Collect the result back to a list
        System.out.println("Filtered names: " + filteredNames);
    }
}
```

## What are the advantages of the Optional class?
    1. Avoid NullPointerExceptions
    2. Codes are easy to read and consised

## Explain Functional Interface and Lambda with code samples.
```java
/**
 * 1. FunctionalInterface
 *  -- functional interface only has one single abstract method
 *  -- can have many default and static methods
 */
@FunctionalInterface
public interface someAPI {
    static final String BLOG = "Hello Interface";

    int add(int a, int b);

    default int substract(int a, int b) {
        return a - b;
    }

    default int adder(int a, int b) {
        return a + b;
    }

    static String getBlog() {
        return BLOG;
    }
}

/**
 * 2. Lambda
 *  -- To replace anonymous inner class
 *  -- work with functional interface
 *  -- Lambda can use unchanged variable outside of lambda -> final variable 
 */
public class Main {
    public static void main(String[] args) {
        SomeAPI api = (a1, a2) -> a1 + a2;
        int sum = api.add(1, 2);
        System.out.println(sum);
    }
}
```

## Explain Method Reference with code samples?
```java
class Person {
    private String name;
    private int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public static int compareByName(Person p1, Person p2) {
        return p1.name.compareTo(p2.name);
    }
    
    public int getAge() {
        return age;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

public class MethodReferenceExample {
    public static void main(String[] args) {
        // 1. 静态⽅法引⽤
        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35));
        // 使⽤Lambda表达式
        people.sort((p1, p2) -> Person.compareByName(p1, p2));
        // 使⽤静态⽅法引⽤
        people.sort(Person::compareByName);

        // 2. 实例⽅法引⽤（特定对象的实例⽅法）
        Comparator<Person> byAgeComparator = Comparator.comparingInt(Person::getAge);
        people.sort(byAgeComparator);
        
        // 3. 类的实例⽅法引⽤
        // 将会被stream使⽤。
        Function<Person, String> getNameFunction = Person::getName;
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        names.sort(String::compareToIgnoreCase);
        
        // 4. 构造方法引用
        // 将会被stream使用。
        BiFunction<String, Integer, Person> personCreator = Person::new;
        Person newPerson = personCreator.apply("David", 40);

        System.out.println(people);
    }
}
```

## Explain "Lambda can use unchanged variable outside of lambda", with code snippet.
```java
public interface SomeApi {
    String modifyName(String modifyValue);
}

public class Main {
    public static void main(String[] args) {
        final String version = "v1.0";
        SomeApi api = apiName -> apiName + "_" + modifyValue1;
        System.out.println(api.modifyName("test"));
    }
}
```

## Can a functional interface extend/inherit another interface?
    Yes, a functional interface in Java can extend another interface, but with certain restrictions:
    Rules:
        Single Abstract Method (SAM): A functional interface must have exactly one abstract method.
        Inheritance: It can extend other interfaces, but it must ensure that it does not inherit more than one abstract method.
        Default Methods: It can include default methods from other interfaces.
```java
// Valid
@FunctionalInterface
interface MyInterface extends AnotherInterface {
    void doSomething(); // Only one abstract method
    default void myMethod() {
        // special impl.
    }
}

interface AnotherInterface {
    default void defaultMethod() {
        // Implementation
    }
}

// Invalid
@FunctionalInterface
interface MyInterface extends AnotherInterface {
    void doSomething();
    void doSomethingElse(); // More than one abstract method
}
```

## What are Intermediate and Terminal operations?
    1. Intermediate:
        * ⼀，筛选
            * 1. filter(Predicate p) - 接受lambda, 从流中排出某些元素
            * 2. limit(n) - 截断流，使其元素不超过给定的数量
            * 3. skip(n) - 跳过前n个元素
            * 4. distinct() - 筛选，通过元素的hashcode(), equals()去除重复元素
        * ⼆，映射
            * 1, map(function f) element -> black box(f) -> return new element
            * 2, flatMap(function f)
        * 三， 排序
            * 1, sort
      2. Terminal: 
        * ⼀， 匹配与查找
            * 1， allMatch(Predicate p) - 检查是否匹配所有的元素
            * 2， anyMatch(Predicate p) - 检查是否⾄少匹配⼀个元素
            * 3， noneMatch(Predicate p) - 检查是否没有匹配的元素
            * 4, findFirst - 返回第⼀个元素
            * 5， findAny - 返回当前流中的任意元素
            * 6, count - 返回流中元素的个数
            * 7, max(Comparator c) - 返回流中的最⼤值
            * 8, min(Comparator c) - 返回流中的最⼩值   
            * 9, forEach(Consumer c) - 内部迭代
        * ⼆，归约
            * 1, reduce(T identity, BinaryOperator) - 可以将流中的元素反复结合起来，得到⼀个值
            * 2, reduce(BinaryOperator) - 可以将流中的元素反复结合起来，得到⼀个值
        * 三， 收集
            * 1, collect(Collectors c)

## Demonstrate the most commonly used Intermediate operations in Stream API, with code snippet.
```java
public class Main {
    public static void main(String[] args) {
        List<String> list = List.of("Eric", "Alex", "Alex", "White", "White", "Black", "Lambda", "Nutrition", "Nutrition", "Carbon");
        final String modifier = "LastName";
        List<String> modList = list.stream()
                .filter(s -> s.length() > 5)  // filter by string length > 5, Predicate function accepted
                .distinct()                         // get distinct values
                .map(s -> s + " " + modifier) // map string to s + " " + LastName, Functional function accepted
                .sorted()                           // sort
                .toList();                          // terminate signal

        System.out.println(modList);
    }
}
```

## How are Collections different from Stream?
| Collections                                                               |Stream                                                                                   |
|---------------------------------------------------------------------------|------------------------------------------------------------------------------------------|
| Data structure holds all the data elements                                |No data is stored. Have the capacity to process an infinite number of elements on demand |
| External Iteration                                                        |Internal Iteration                                                                      |
| Can be processed any number of times                                      |Traversed only once                                                                    |
| Elements are easy to access No direct way of accessing specific elements  |Is a data store Is an API to process the data                                         |

## Implement Stream API's filter and map methods by your self.
    see folder: Coding/hw_Java8/personalized_stream_api
```java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyStreamApi<T> {

    private final List<T> list;

    public MyStreamApi(List<T> list) {
        this.list = list;
    }

    public MyStreamApi<T> filter(Predicate<T> predicate) {
        List<T> res = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                res.add(t);
            }
        }

        return new MyStreamApi<>(res);
    }

    public MyStreamApi<T> map(Function<T, T> function) {
        List<T> res = new ArrayList<>();
        for (T t : list) {
            res.add(function.apply(t));
        }

        return new MyStreamApi<>(res);
    }

    public MyStreamApi<T> sort(Comparator<T> comparator) {
        List<T> res = new ArrayList<>(list);
        res.sort(comparator);
        return new MyStreamApi<>(res);
    }

    public List<T> toList() {
        return new ArrayList<>(list);
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> evens = new MyStreamApi<>(numbers).filter(n -> n % 2 == 0).sort((a, b) -> b - a).toList();
        System.out.println(evens);

        List<Integer> odds = new MyStreamApi<>(numbers).filter(n -> n % 2 != 1).toList();
        System.out.println(odds);
    }
}
```