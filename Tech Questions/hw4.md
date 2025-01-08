### HW4: HW_Java8

##### 1. Learn Java generics by reading and practicing following code:
https://github.com/CTYue/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t01_basic/generic


##### 2. Read the follwoing code repo and type it one by one by yourself.
https://github.com/CTYue/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t06_java8/features


##### 3. Practice following stream API exercises at least 3 times
https://github.com/gavinklfong/stream-api-exercises/blob/main/src/test/java/space/gavinklfong/demo/streamapi/StreamApiTest.java


##### 4. Practice Optional methods at least 2 times
https://github.com/CTYue/chuwa-eij-tutorial/blob/main/02-java-core/src/main/java/com/chuwa/tutorial/t06_java8/exercise/ShoppingCartUtil.java


##### 5. Discuss best practices on nullptr exception prevention, provide code snippet for each practice that you mentioned.

	(1), Always check for null first

```	
	if (str != null) {
        return String.valueOf(str.length());
    } else {
        return "str is null";
    }
```

	(2), null check from parent object to nested/inner object

	Example:
```	
	public static String getCityName(Person person) {
        // Check for null at each level (Person -> Address -> City)
        if (person != null && person.getAddress() != null && person.getAddress().getCity() != null) {
            return person.getAddress().getCity().getName();
        } else if (person != null && person.getAddress() == null) {
            return "Address is null";
        } else if (person != null && person.getAddress() != null && person.getAddress().getCity() == null) {
            return "City is null";
        }

        return "Person is null";
    }
```

	(3), Use try-catch for Defensive Exception Handling
```
	try {
		System.out.println(input.length());
	} catch (NullPointerException e) {
		System.out.println("Input is null!");
	}
```

	(4), It it better to use second way than the first way in below code:
```
	String str1;
	str1.equals("abc"); // First way: If str1 is null, calling str1.equals("abc") will throw a NullPointerException.
	"abc".equals(str1); // Second way: better in terms of null safety.  If str1 is null, it just returns false without causing an exception.
```

	(5),Use Optional (Java 8 and Later)
	
```
	public String helper(Optional<String> input) {
		return input.map(String::length).map(String::valueOf).orElse("Input is null");
	}
```

	(6), Use Ternary Operator for Conditional Null Checks
	```
	(person != null) ? person.getName() : "Unknown";
	```
	(7),  Use @NonNull and @Nullable Annotations
	
	```
	import org.jetbrains.annotations.Nullable;
	import org.jetbrains.annotations.NotNull;

	public void processString(@NotNull String input) {
		// input is guaranteed to be non-null
		System.out.println(input.length());
	}

	public String getStringOrNull() {
		return null;  // Explicitly marked nullable
	}
	```

##### 6. Discuss Java 8 new features with code snippet.

	(1), Lambda Expressions:\
	Lambda expressions allow for more concise representation of anonymous classes with a single method.\
	Example:
	```
	List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
	numbers.forEach(n -> System.out.println(n));
	```

	(2),Functional Interfaces:\
	Functional interfaces are interfaces with a single abstract method, which can be implemented using lambda expressions.\
	Example:
	```
	@FunctionalInterface
	interface MyInterface {
		double getPiValue();
	}
	MyInterface ref = () -> 3.1415;
	System.out.println("Value of Pi = " + ref.getPiValue());
	```

	(3),Stream API:\
	The Stream API enables functional-style operations on streams of elements.
	```
	List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	int sum = numbers.stream()
					 .filter(n -> n % 2 == 0)
					 .mapToInt(Integer::intValue)
					 .sum();
	```

	(4),Method References\
	Method references provide a way to refer to methods without executing them.\
	Example:
	```
	List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
	names.forEach(System.out::println);
	```

	(5),Default Methods:\
	Default methods allow the addition of new methods to interfaces without breaking existing implementations.\
	Example:
	```
	interface MyInterface {
		default void newMethod() {
			System.out.println("New method");
		}
	}
	```

	(6),Optional Class:	The Optional class helps in handling null values more effectively.\
	Example:
	```
	Optional<String> optional = Optional.of("hello");
	optional.ifPresent(s -> System.out.println(s.length()));
	```
	
##### 7. What are the advantages of the Optional class?

	1, Avoid NullPointerException\
	Provides Defaults: Easily provides fallback values with orElse().
	
	```
	Optional<String> name = Optional.ofNullable(user.getName());
	name.ifPresent(n -> System.out.println("Name: " + n));
	```

	2, Improve code readability: \
	   Optional makes it clear when a value might be absent, improving code clarity.

	3, Functional programming support: \
	   It provides methods like map(), filter(), and flatMap() that align well with functional programming paradigms.
	
	4, Lazy evaluation: \
	   Methods like orElseGet() allow for lazy creation of default values, potentially improving performance.
	
	5, Explicit API design: \
	   Using Optional as a return type clearly communicates that a method may not always produce a value.
	
	6, Safer chaining: \
	   It allows for safer method chaining without the risk of NullPointerExceptions.
	
	7, Alternative actions: \
	   Optional provides methods like ifPresent() and ifPresentOrElse() to specify alternative actions when a value is present or absent.
	

##### 8. Explain Functional Interface and Lambda with code samples.

	A functional interface is an interface that contains exactly one abstract method. It can have multiple default or static methods, but only one abstract method. 
	Functional interfaces are often used as the basis for lambda expressions.

	```
	@FunctionalInterface
	interface MyFunctionalInterface {
		void run();
	}
	```

	Lambda Expressions
	Lambda expressions provide a concise way to represent instances of single-method interfaces (functional interfaces). 
	They allow you to treat functionality as a method argument, or code as data.
	
	Examples:
	```
	(parameters) -> expression
	(parameters) -> { statements; }
	
	ArrayList<Integer> numbers = new ArrayList<>();
	numbers.add(5);
	numbers.add(9);
	numbers.add(8);
	numbers.add(1);

	Consumer<Integer> method = (n) -> System.out.println(n);
	numbers.forEach(method);		
	```

##### 9. Explain Method Reference with code samples?

	Method references in Java 8 provide a concise way to refer to methods or constructors. 
	They are essentially shorthand notations for lambda expressions that call a specific method.
	
	There are four types of method references:
	
	(1),Reference to a static method:
	```
	List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
	numbers.forEach(System.out::println);
	```

	(2),Reference to an instance method of a particular object:
	```
	String str = "Hello";
	Predicate<String> startsWithH = str::startsWith;
	boolean result = startsWithH.test("Hi"); // returns true
	```

	(3), Reference to an instance method of an arbitrary object of a particular type:
	```
	List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
	names.sort(String::compareToIgnoreCase);
	```

	This is equivalent to:
	```
	names.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
	```

	(4),Reference to a constructor:
	```
	Supplier<List<String>> listSupplier = ArrayList::new;
	List<String> list = listSupplier.get(); // Creates a new ArrayList
	```	

##### 10. Explain "Lambda can use unchanged variable outside of lambda", with code snippet.

	Lambdas can access variables that are effectively final from the surrounding scope. \
	Variables outside the lambda expression are not modified within the lambda.\
	We can access and use variables from the surrounding scope in a lambda, but those variables must be "effectively final". 
	
	Effectively final means that the variable's value is not modified after initialization, even though it might not be explicitly declared as final.\
	Lambda expressions can capture and use such variables from the enclosing scope.
	
	Example:
	
	```
	import java.util.Arrays;
	import java.util.List;

	public class LambdaExample {
		public static void main(String[] args) {
			int multiplier = 2;  // Unchanged variable outside the lambda
			
			List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
			
			// Lambda expression accessing the multiplier variable
			numbers.forEach(number -> {
				int result = number * multiplier;
				System.out.println(result);
			});
		}
	}
	```

##### 11. Can a functional interface extend/inherit another interface?

	Yes, a functional interface in Java can extend or inherit from another interface.\
	But the resulting interface must still have exactly one abstract method. \
	The core principle of a functional interface is that it can only have one abstract method. 
	
	Functional interfaces can also extend non-functional interfaces, \
	but they must adhere to the rule of having only one abstract method in total after inheritance.
	
	Example:
	
	```
	// Parent interface with no abstract methods
	interface MyInterface {
		default void defaultMethod() {
			System.out.println("Default method in MyInterface");
		}

		static void staticMethod() {
			System.out.println("Static method in MyInterface");
		}
	}

	// Functional interface extending MyInterface
	@FunctionalInterface
	interface MyFunctionalInterface extends MyInterface {
		void abstractMethod(); 
	}
	
	MyInterface has no abstract methods, only a default and a static method.	
	```

##### 12. What are Intermediate and Terminal operations?
	
	(1),Intermediate Operations:\
    Lazy Evaluation: Intermediate operations are not executed immediately when invoked. \
	They are only executed when a terminal operation is called.\
    Return a New Stream: They return a new stream, which means that multiple intermediate operations can be chained together to build a pipeline of operations.	\
    Stateful or Stateless: Some intermediate operations are stateless (e.g., map(), filter()) while others may require maintaining some state (e.g., distinct(), sorted()).
	
	Examples of Intermediate Operations:\
    filter(): Filters elements based on a condition.\
    map(): Transforms each element of the stream.\
    flatMap(): Flattens nested structures, returning a stream of elements.\
    distinct(): Removes duplicates.\
    sorted(): Sorts elements in the stream.\
    peek(): Allows you to perform a side-effect (like logging or debugging) without modifying the stream.\
	
	(2),Terminal Operations:\
	They perform an action on the stream and produce a result \
	They trigger the execution of all preceding intermediate operations.\
	Terminal operations mark the end of the stream pipeline, and the stream cannot be used further after a terminal operation is executed.

	Examples:\
	forEach(): Performs an action on each element of the stream.\
	collect(): Collects the elements of the stream into a collection.\
	reduce(): Reduces the elements of the stream to a single value.\
	count(): Counts the number of elements in the stream.\
	findFirst(): Returns the first element of the stream.\
	anyMatch(): Checks if any element in the stream matches a predicate.\
	allMatch(): Checks if all elements in the stream match a predicate.
	

##### 13. Demontrate the most commonly used Intermediate operations in Stream API, with code snippet.

	(1),filter():	Filters elements of the stream based on a given predicate (a boolean-valued function).
	```
	List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	List<Integer> evenNumbers = numbers.stream()
			.filter(n -> n % 2 == 0)
			.collect(Collectors.toList()); 

	System.out.println("Even numbers: " + evenNumbers); // Output: Even numbers: [2, 4, 6, 8, 10]
	```
	
	(2), map():	Transforms each element of the stream into another object.

	```
	List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
	List<String> upperCaseNames = names.stream()
			.map(String::toUpperCase)
			.collect(Collectors.toList());

	System.out.println("Uppercase names: " + upperCaseNames); // Output: Uppercase names: [ALICE, BOB, CHARLIE]
	```
	
	(3), sorted(): Sorts the elements of the stream in natural order or according to a custom comparator.
	
	```
	List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9);
	List<Integer> sortedNumbers = numbers.stream()
			.sorted() // Sort in ascending order
			.collect(Collectors.toList());

	System.out.println("Sorted numbers: " + sortedNumbers);	// Output: Sorted numbers: [1, 2, 5, 8, 9]
	```

	(4), distinct():	Removes duplicate elements from the stream.
		
	```
	List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 5, 5);

	List<Integer> distinctNumbers = numbers.stream()
			.distinct() 
			.collect(Collectors.toList());

	System.out.println("Distinct numbers: " + distinctNumbers);		// Output: Distinct numbers: [1, 2, 3, 4, 5]
	```

	(5), limit():	Limits the number of elements in the stream to a specified count.
	
	```
	List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	List<Integer> firstThreeNumbers = numbers.stream()
			.limit(3) // Limit to the first three numbers
			.collect(Collectors.toList());

	System.out.println("First three numbers: " + firstThreeNumbers);		// Output: First three numbers: [1, 2, 3]
	```

	(6), skip(): Skips the first n elements of the stream.
	
	```
	List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

	List<Integer> numbersAfterTwo = numbers.stream()
			.skip(2) // Skip the first two numbers
			.collect(Collectors.toList());

	System.out.println("Numbers after two: " + numbersAfterTwo);	// Output: Numbers after two: [3, 4, 5, 6, 7, 8, 9, 10]
	```

##### 14. How are Collections different from Stream?
	
	Collections are containers for storing data.\
	Streams are a way to process data from a source (often a collection) in a declarative and efficient manner.
	
	Collections:\
	Data Structures: Collections are data structures that hold a group of objects.
	They store elements in memory.
	It is mutable. We can add, remove, and modify elements within a collection.
	Iteration: Collections can be iterated over using traditional loops (for, foreach).
	Examples: List, Set, Map, Queue
	
	Streams:\
	Streams represent a sequence of elements from a source, often a collection.
	Streams do not store elements.
	It is immutable. Once a stream operation has been performed, the stream cannot be reused.
	Intermediate operations (like filter, map) are not executed immediately. They are chained together and only executed when a terminal operation (like collect, forEach) is encountered.
	Streams can be easily parallelized for performance gains, especially with large datasets.
	

##### 15. Implement Stream API's filter  and map  methods by your self

	```
	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.List;
	import java.util.function.Function;
	import java.util.function.Predicate;

	class CustomStream<T> {
		private List<T> list;

		public CustomStream(List<T> list) {
			this.list = list;
		}

		public CustomStream<T> filter(Predicate<T> predicate) {
			List<T> result = new ArrayList<>();
			for (T item : list) {
				if (predicate.test(item)) {
					result.add(item);
				}
			}
			return new CustomStream<>(result);
		}

		public <R> CustomStream<R> map(Function<T, R> mapper) {
			List<R> result = new ArrayList<>();
			for (T item : list) {
				result.add(mapper.apply(item));
			}
			return new CustomStream<>(result);
		}

		public List<T> collect() {
			return new ArrayList<>(list);
		}
	}

	public class Main {
		public static void main(String[] args) {
			List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
			CustomStream<Integer> stream = new CustomStream<>(numbers);

			List<Integer> result = stream
				.filter(n -> n % 2 == 0)
				.map(n -> n * 2)
				.collect();

			System.out.println("Original numbers: " + numbers);
			System.out.println("Filtered and mapped result: " + result);
		}
	}
	```

	Original numbers: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]\
	Filtered and mapped result: [4, 8, 12, 16, 20]