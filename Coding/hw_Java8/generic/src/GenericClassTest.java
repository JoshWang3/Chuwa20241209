public class GenericClassTest {
    public static void main(String[] args) {
        GenericClass<Integer> objInt = new GenericClass<>(10);
        GenericClass<String> objStr = new GenericClass<>("Hello");
        GenericClass<Double> objDouble = new GenericClass<>(10.5);

        System.out.println(objInt.getT());
        System.out.println(objStr.getT());
        System.out.println(objDouble.getT());

    }
}
