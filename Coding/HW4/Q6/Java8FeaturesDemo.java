package Chuwa20241209.Coding.HW4.Q6;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Java8FeaturesDemo {
    public static void main(String[] args) {
        // 1. Lambda Expressions: short block of code which takes in parameters and returns a value
        List<Integer> numbers = Arrays.asList(1, 2, 3, 9);
        numbers.forEach(n -> System.out.println("Number: " + n));

        // 2. Stream API: computed on-demand and don't store data memory
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Even int: " + evenNumbers);

        // 3. Method_References
        evenNumbers.forEach(System.out::println);

        // 4. Default Methods in interface: shorthand syntax for a lambda expression with only one method call
        MyInterface obj = () -> "This is from Lambda";
        System.out.println(obj.sayHello());
        System.out.println(obj.defaultMethod());

        // 5. Optional - handle null ptr
        Optional<Integer> optional = numbers.stream().filter(n -> n > 2).findFirst();
        optional.ifPresent(n -> System.out.println("First int > 2: " + n));

        // 6. Functional Interfaces (Predicate)
        Predicate<Integer> isOdd = n -> n % 2 != 0;
        System.out.println("Is 3 odd? " + isOdd.test(3));
    }
}

// Interface with default method
@FunctionalInterface
interface MyInterface {
    String sayHello();

    default String defaultMethod() {
        return "Default method in interface";
    }
}
