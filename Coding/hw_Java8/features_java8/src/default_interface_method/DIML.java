package default_interface_method;

@FunctionalInterface
public interface DIML {
    static final String BLOG = "DIML";

    // abstract method
    int add(int a, int b);

    // default method
    default int sub(int a, int b) {
        return a - b;
    }

    // default method
    default int mul(int a, int b) {
        return a * b;
    }

    // static method
    static String getBlog() {
        return BLOG;
    }
}
