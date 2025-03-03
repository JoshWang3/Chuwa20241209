package Chuwa20241209.Coding.HW4.Q8.functional_interface;

import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<String> isLongerThan5 = s -> s.length() > 5;

        // false
        System.out.println(isLongerThan5.test("Test"));

        // true
        System.out.println(isLongerThan5.test("Testtttttt"));
    }
}
