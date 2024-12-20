# hw4

---

### 1. Discuss best practices on `nullptr` exception prevention.
1. **Avoid `null` where possible**
   - Use `Optional` to represent a value that may or may not exist, eliminating the need for `null` checks.
   ```
    public Optional<String> getValue() {
        return Optional.ofNullable(null); // Return an Optional instead of null
    }
   
    public void printValue() {
        Optional<String> value = getValue();
        value.ifPresent(System.out::println); // Print the value if present
    }
   ```

2. **Use `Objects.requireNonNull`**
   - Validate method arguments to ensure `null` values are caught early.
   ```
    public void setName(String name) {
        this.name = Objects.requireNonNull(name, "Name cannot be null");
    }
   ```
3. **Default values**
   - Use `Optional.orElse` or `Optional.orElseGet` to provide fallback values.
   ```
    String name = Optional.ofNullable(inputName).orElse("Default Name");
    System.out.println(name); // Prints "Default Name" if inputName is null
   ```
4. **Annotations**
   - Use `@NotNull` and `@Nullable` annotations to make APIs self-documenting and avoid misuse.
   ```
    public void printMessage(@NotNull String message) {
        System.out.println(message);
    }

   ```

### 2. What are the advantages of the `Optional` class?
1. **Eliminates `null` checks**: Replaces traditional `if (x != null)` logic.
2. **Prevents `NullPointerException`**: Encapsulates nullable values safely.
3. **Functional-style handling**: Methods like `map`, `filter`, and `ifPresent` enable clean handling.
4. **Clear intent**: Makes it explicit when a value may be absent.

   ```
   Optional<String> optionalValue = Optional.ofNullable("Hello");
   optionalValue.ifPresent(System.out::println); // Prints "Hello"
   
   String fallback = optionalValue.orElse("Default");
   System.out.println(fallback); // Prints "Hello"
   ```

### 3. Explain Functional Interface and Lambda.
1. **Functional Interface**
- An interface with exactly one abstract method, which can be implemented using lambdas for simplicity.
```
@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}
Greeting greeting = name -> System.out.println("Hello, " + name);
greeting.sayHello("John"); // Prints "Hello, John"
```
2. **Lambda Expression**
- A lambda expression is a concise way to represent an anonymous function. It improves readability and reduces boilerplate code.
```
List<Integer> numbers = Arrays.asList(1, 2, 3);
numbers.forEach(n -> System.out.println(n * 2)); // Doubles each number
```

### 4. Explain Method Reference.
- Method references are a shorthand for writing lambdas that call a specific method.

1. **Types of method references**:

   - **Static method reference**: `ClassName::methodName`
   - **Instance method reference**: `instance::methodName`
   - **Constructor reference**: `ClassName::new`
```
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
names.forEach(System.out::println); // Prints each name

Function<String, Integer> parseInt = Integer::valueOf; // Converts String to Integer
Supplier<List<String>> listSupplier = ArrayList::new; // Creates a new ArrayList
```

### 5. Explain "Lambda can use unchanged variable outside of lambda".
- Lambda expressions can access variables from the enclosing scope, but those variables must be effectively final (unchanged after initialization).
```
int factor = 2; // Effectively final
List<Integer> numbers = Arrays.asList(1, 2, 3);
numbers.stream().map(n -> n * factor).forEach(System.out::println); // Prints 2, 4, 6
```

### 6. Can a functional interface extend/inherit another interface?
- Yes, a functional interface can extend another interface as long as it does not add new abstract methods.
```
@FunctionalInterface
interface BaseInterface {
    void print(String message);
}

@FunctionalInterface
interface ExtendedInterface extends BaseInterface {
    // No additional abstract methods
}
```

### 7. What are Intermediate and Terminal operations?
1. **Intermediate Operations**: Transform a stream into another stream, allowing chaining. They are lazy, executing only when a terminal operation is invoked.
   - **Examples**: `filter`, `map`, `sorted`.

2. **Terminal Operations**: Produce a result or a side effect and mark the end of the stream.
   - **Examples**: `collect`, `forEach`, `reduce`.
```
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

// Intermediate: filter and map
numbers.stream()
       .filter(n -> n % 2 == 0) // Filters even numbers
       .map(n -> n * n)        // Squares each number
       .forEach(System.out::println); // Terminal: Prints 4, 16
```

### 8. How are Collections different from Streams?
1. **Collections**:
   - In-memory data structure.
   - Eagerly loads and processes data.
   - Mutable (can add/remove elements).
```
List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
list.add("D"); // Adds "D" to the list
```
2. **Streams**:
   - Pipeline for functional operations on data.
   - Lazy (evaluates elements only when needed).
   - Immutable (cannot modify the source).
```
Stream<String> stream = list.stream();
stream.forEach(System.out::println); // Processes elements once
```