package Chuwa20241209.Coding.HW5.Q18;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
    public static void main(String[] args) {
        // AtomicInteger
        AtomicInteger atomicInteger = new AtomicInteger(0);
            // Increment and get
        System.out.println("Incremented Value: " + atomicInteger.incrementAndGet());
            // Add a value
        System.out.println("Add 5: " + atomicInteger.addAndGet(5));
            // get
        System.out.println("Updated Value: " + atomicInteger.get()); // Output: 10

        // AtomicBoolean
        AtomicBoolean flag = new AtomicBoolean(false);
        // Set
        flag.set(true);
        System.out.println("set(true): " + flag.get()); // Output: true

    }
}
