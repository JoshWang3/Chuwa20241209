package Chuwa20241209.Coding.HW4.Q8.functional_interface;

import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> printUpperCase = s -> System.out.println(s.toUpperCase());

        printUpperCase.accept("tEsT312deMo");
    }
}
