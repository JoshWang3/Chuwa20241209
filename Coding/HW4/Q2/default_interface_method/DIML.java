package Chuwa20241209.Coding.HW4.Q2.default_interface_method;

public interface  DIML {
    static final String BLOG = "Static Blog Name";

    // abstract
    int add(int a, int b);

    // default
    default int substract(int a, int b) {
        return a - b;
    }

    // static
    static String blogName() {
        return BLOG;
    }
}
