5. null point check:
   1. check for null before dereferencing:
      1. if (str != null)
   2. optional:
      1. Optional<String> str = Optional.ofNullable(null);
   3. requireNonNull:
      1. String str = Objects.requireNonNull()
6. Java8
   1. Lambda
   2. Stream API
   3. Optional
7. Optional:
   1. avoid null
   2. improves readability
   3. functional programming
8. functional interface and lambda
   1. functional interface is an interface with a single abstract method
      1. "@FunctionInterface
          interface ...{
                void printA();
          }"
   2. lambda is a short block of code that takes in parameters and returns a value. 
      1. names.forEach(name -> System.out.println(name));
9. Method references are shorthand for a lambda expression:
   1. names.forEach(System,out::println);
10. Lambda expressions can use vairables that are not modified after they are defined. 
    1. "String str = "Hello";
        Runnanle r = () -> System.out.println(str);
        r.run();
       "
11. Yes. Functional interface can extend another interface if it does not introduce new methods. 
12. intermediate and terminal operations:
    1. intermediate operations transform streams and are lazy.
    2. terminal operations trigger computation.
13. intermediate operations:
    1. filter:
       1. "strs.stream().filter(str -> str.startWith("A")"
    2. map:
       1. nums.stream().map(num -> num * num);
14. collections vs stream:
    1. Collections: store data in memory, mutable
    2. Streams: process data on demand, immutable
15. filter and map:

filter :

public static <T> List<T> filter(List<T> list, predicate<T> predicate){
    List<T> result = new ArrayList<>();
    for (T item : list) {
        if (predicate.test(iteam)) {
            result.add(item);
        }
    }
    return result;
}

public static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {
    List<R> result = new ArrayList<>();
    for (T item : list) {
        result.add(mapper.apply(item));
    }
    return result;
}