package Chuwa20241209.Coding.HW4.Q13;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntermediateOperationDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> names = Arrays.asList("Arron", "Baron", "Caron");

        // 1. filter() lambda + condition
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Even Numbers: " + evenNumbers);

        // 2. map() for every element check length
        List<Integer> nameLengths = names.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println("Name Lengths: " + nameLengths);

        // 3. distinct(): like set
        List<Integer> distinctNumbers = Arrays.asList(1, 2, 2, 3, 3, 4).stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Distinct Numbers: " + distinctNumbers);

        // 4. sorted():
        List<String> sortedNames = names.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Sorted Names: " + sortedNames);

        // 5. limit()
        List<Integer> limitedNumbers = numbers.stream()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("Limited Numbers: " + limitedNumbers);

        // 6. min():
        numbers.stream()
                .min(Integer::compareTo)
                .ifPresent(min -> System.out.println("Minimum int: " + min));
    }
}
