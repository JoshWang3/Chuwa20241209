package Chuwa20241209.Coding.HW4.Q1;

public class GenericClassTest {
    public static void main(String[] args) {

        GenericClass<Integer> obj1 = new GenericClass<>(3);
        System.out.println(obj1.getObj());

        GenericClass<Double> obj2 = new GenericClass<>(11.11111111111);
        System.out.println(obj2.getObj());

        GenericClass<String> obj3 = new GenericClass<>("String type generic class");
        System.out.println(obj3.getObj());
    }
}
