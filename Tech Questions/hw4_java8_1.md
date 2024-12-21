### Learn and Exercises

1. Learn Java generics by reading and practicing following code:
   [Java Generics Basic Example](https://github.com/CTYue/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t01_basic/generic)

2. Read the following code repo and type it one by one by yourself:
   [Java 8 Features Code Repo](https://github.com/CTYue/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t06_java8/features)

3. Practice following stream API exercises at least 3 times:
   [Stream API Exercises](https://github.com/gavinklfong/stream-api-exercises/blob/main/src/test/java/space/gavinklfong/demo/streamapi/StreamApiTest.java)

4. Practice Optional methods at least 2 times:
   [Optional Methods Exercise](https://github.com/CTYue/chuwa-eij-tutorial/blob/main/02-java-core/src/main/java/com/chuwa/tutorial/t06_java8/exercise/ShoppingCartUtil.java)

---

#### 5. Discuss best practices on `null`/`NullPointerException` prevention, provide code snippet for each practice that you mentioned.

**Best Practices:**

- **Use `Optional` to Avoid Nulls:**
  ```java
  Optional<String> optional = Optional.ofNullable(value);
  optional.ifPresent(System.out::println);
  ```

- **Default Values for Null:**
  ```java
  String result = Optional.ofNullable(value).orElse("Default Value");
  ```

- **Check for Null Explicitly:**
  ```java
  if (value != null) {
      System.out.println(value);
  }
  ```

- **Avoid Returning Null from Methods:**
  ```java
  public Optional<String> getName() {
      return Optional.ofNullable(name);
  }
  ```

#### 6. Discuss Java 8 new features with code snippet.

- **Lambda Expressions:**
  ```java
  List<String> names = Arrays.asList("John", "Jane", "Doe");
  names.forEach(name -> System.out.println(name));
  ```

- **Stream API:**
  ```java
  List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
  List<Integer> squares = numbers.stream()
                                 .map(n -> n * n)
                                 .collect(Collectors.toList());
  ```

- **Optional Class:**
  ```java
  Optional<String> optional = Optional.ofNullable("Hello");
  optional.ifPresent(System.out::println);
  ```

- **Default and Static Methods in Interfaces:**
  ```java
  interface MyInterface {
      default void show() {
          System.out.println("Default Method");
      }
  }
  ```

#### 7. What are the advantages of the `Optional` class?

- Eliminates NullPointerException.
- Provides methods to handle missing values safely.
- Improves code readability and maintainability.
- Provides flexibility with methods like `orElse`, `ifPresent`, and `map`.

#### 8. Explain Functional Interface and Lambda with code samples.

- **Functional Interface:**
  ```java
  @FunctionalInterface
  interface MyFunction {
      int apply(int x, int y);
  }
  ```

- **Lambda Expression:**
  ```java
  MyFunction add = (a, b) -> a + b;
  System.out.println(add.apply(5, 3));
  ```

#### 9. Explain Method Reference with code samples.

- **Static Method Reference:**
  ```java
  Function<String, Integer> parseInt = Integer::parseInt;
  System.out.println(parseInt.apply("123"));
  ```

- **Instance Method Reference:**
  ```java
  List<String> names = Arrays.asList("John", "Jane", "Doe");
  names.forEach(System.out::println);
  ```

#### 10. Explain "Lambda can use unchanged variable outside of lambda" with code snippet.

- **Example:**
  ```java
  int num = 10;
  Runnable r = () -> System.out.println(num);
  r.run();
  ```

#### 11. Can a functional interface extend/inherit another interface?

- Yes, it can inherit another interface as long as it still has only one abstract method.
  ```java
  interface ParentInterface {
      void parentMethod();
  }

  @FunctionalInterface
  interface ChildInterface extends ParentInterface {
      void parentMethod();
  }
  ```

#### 12. What are Intermediate and Terminal operations?

- **Intermediate Operations:** Transform the stream (e.g., `filter`, `map`).
- **Terminal Operations:** Produce a result or side-effect (e.g., `collect`, `forEach`).

#### 13. Demonstrate the most commonly used Intermediate operations in Stream API, with code snippet.

- **`filter`:**
  ```java
  List<String> filtered = names.stream()
                               .filter(name -> name.startsWith("J"))
                               .collect(Collectors.toList());
  ```

- **`map`:**
  ```java
  List<Integer> lengths = names.stream()
                                .map(String::length)
                                .collect(Collectors.toList());
  ```

#### 14. How are Collections different from Stream?

- **Collections:**
    - In-memory data structure.
    - Can be iterated multiple times.
    - Eager computation.

- **Stream:**
    - Lazily evaluated.
    - One-time use.
    - Supports functional-style operations.

#### 15. Implement Stream API's `filter` and `map` methods by yourself.

- **Custom Implementation:**
  ```java
  public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
      List<T> result = new ArrayList<>();
      for (T t : list) {
          if (predicate.test(t)) {
              result.add(t);
          }
      }
      return result;
  }

  public static <T, R> List<R> map(List<T> list, Function<T, R> function) {
      List<R> result = new ArrayList<>();
      for (T t : list) {
          result.add(function.apply(t));
      }
      return result;
  }
  
