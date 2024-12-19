package design_pattern.singleton;

public class LazySingletonInner {
    private LazySingletonInner() {
    }

    private static class LazySingletonInnerHolder {
        private static final LazySingletonInner instance = new LazySingletonInner();
    }

    public static LazySingletonInner getInstance() {
        return LazySingletonInnerHolder.instance;
    }

    public static void main(String[] args) {
        LazySingletonInner es1 = LazySingletonInner.getInstance();
        LazySingletonInner es2 = LazySingletonInner.getInstance();
        System.out.println(es1 == es2);
    }
}
