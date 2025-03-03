package Chuwa20241209.Coding.HW4.Q8.functional_interface;

@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}

public class Custom {
    public static void main(String[] args) {
        // Lambda
        Calculator add = (a, b) -> a + b;
        Calculator multiply = (a, b) -> a * b;

        System.out.println("Add: " + add.calculate(2, 3));
        System.out.println("Multiple: " + multiply.calculate(2, 3));
    }
}
