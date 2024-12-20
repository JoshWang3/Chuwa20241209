package Chuwa20241209.Coding.HW4.Q9;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MethodReferenceDemo {
    public static void main(String[] args) {
    // 1. Reference: Static Method
    Function<String, Integer> stringToLength = String::length;
        System.out.println("Length of " + stringToLength +" : " + stringToLength.apply("abcdefg"));

    // 2. Reference: Instance Method of a Specific Object
    String text = "Instance Method text";
    Predicate<String> startsWithHello = text::startsWith;
        System.out.println("Starts with Instance: " + startsWithHello.test("Instance")); // Output: true
        System.out.println("Starts with Method: " + startsWithHello.test("Method")); // Output: false

    // 3. Reference to the Constructor
    Supplier<StringBuilder> createBuilder = StringBuilder::new;
    StringBuilder sb = createBuilder.get();
        sb.append("Method References constructor");
        System.out.println(sb.toString());

    // 4. Reference to an Instance Method of an Arbitrary Object
    List<String> dates = Arrays.asList("12/09", "12/16", "12/23");
        dates.forEach(System.out::println);

    // 5. Static Method in a Custom Class
    BiFunction<Integer, Integer, Integer> maxFunction = Math::max;
        System.out.println("Max of 1 and 2: " + maxFunction.apply(1, 2));
    }
}
