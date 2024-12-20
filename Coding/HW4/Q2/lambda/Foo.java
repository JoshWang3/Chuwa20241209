package Chuwa20241209.Coding.HW4.Q2.lambda;

@FunctionalInterface
public interface Foo {
    // only one non-default method
    String aMethod(String string);

    default String defaultBar() {
        String s = "default Bar method";
        System.out.println(s);
        return s;
    }

    default String defaultCommon() {
        String s = "defaultCommon from Bar";
        System.out.println(s);
        return s;
    }
}
