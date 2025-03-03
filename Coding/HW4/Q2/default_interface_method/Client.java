package Chuwa20241209.Coding.HW4.Q2.default_interface_method;

public class Client {
    public static void main(String[] args) {
        DIMImpl dim = new DIMImpl();
        System.out.println("Override method: " + dim.add(1, 2));
        System.out.println("default method: " + dim.substract(1, 2));
        // static: class level - no need to instantiate
        System.out.println("static method: " + DIML.blogName());
    }
}
