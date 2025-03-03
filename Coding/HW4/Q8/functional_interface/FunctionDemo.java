package Chuwa20241209.Coding.HW4.Q8.functional_interface;

import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        Function<Integer, String> intToString = i -> "Number: " + i;
        System.out.println(intToString.apply(1));
    }
}
