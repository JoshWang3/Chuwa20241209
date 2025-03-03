package Chuwa20241209.Coding.HW4.Q15;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;

public class filterAndMap {
    // Filter
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> filteredList = new ArrayList<>();
        for (T element : list) {
            // pass the predicate logic to decide add or pass
            if (predicate.test(element)) {
                filteredList.add(element);
            }
        }
        return filteredList;
    }

    // Map
    public static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> mappedList = new ArrayList<>();
        // use loop for every element
        for (T element : list) {
            mappedList.add(function.apply(element));
        }
        return mappedList;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);
        List<Integer> evenNumbers = filter(numbers, n -> n % 2 == 0);
        System.out.println("Even: " + evenNumbers);

        List<Integer> doubledNumbers = map(numbers, n -> n * 2);
        System.out.println("Map x 2: " + doubledNumbers);
    }
}
