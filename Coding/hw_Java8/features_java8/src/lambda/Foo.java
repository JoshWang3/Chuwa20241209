package lambda;

@FunctionalInterface
public interface Foo {
    String aMethod(String s);

    default String aDefaultCommon() {
        String s = "defaultCommon from Bar";
        System.out.println(s);
        return s;
    }

    default String aDefaultBar() {
        String s = "defaultBar from Bar";
        System.out.println(s);
        return s;
    }
}
