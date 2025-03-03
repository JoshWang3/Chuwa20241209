package Chuwa20241209.Coding.HW4.Q10;

@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}

public class LambdaScopeDemo {
        public static void main(String[] args) {
            // The message variable must be final or effectively final, be as the unchanged variable outside of lambda
            String message = "Hello from outside of lambda: ";
            Greeting greeting = (name) -> System.out.println(message + " " + name);
            greeting.sayHello("A");
            greeting.sayHello("B");
            greeting.sayHello("C");
        }
}
