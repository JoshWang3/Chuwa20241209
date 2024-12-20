package Chuwa20241209.Coding.HW4.Q8.functional_interface;

import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args) {
        Supplier<String> getMessage = () -> "Supplier's message";
        System.out.println(getMessage.get());
    }
}
