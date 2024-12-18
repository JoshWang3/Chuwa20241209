package Collection;

import org.junit.Test;

import java.util.*;

/**
 * Demonstrates common operations using the Collections utility class.
 */
public class CollectionsExerciseTest {

    /**
     * Demonstrates:
     * - Collections.min()
     * - Collections.max()
     * - frequency()
     */
    @Test
    public void learn_common_collections_operations() {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50, 20, 30);

        // Finding the minimum element
        int min = Collections.min(numbers);
        System.out.println("Minimum element: " + min);

        // Finding the maximum element
        int max = Collections.max(numbers);
        System.out.println("Maximum element: " + max);

        // Finding the minimum element with a custom comparator (reverse order)
        int minReverse = Collections.min(numbers, Comparator.reverseOrder());
        System.out.println("Minimum element (reverse comparator): " + minReverse);

        // Finding the maximum element with a custom comparator (reverse order)
        int maxReverse = Collections.max(numbers, Comparator.reverseOrder());
        System.out.println("Maximum element (reverse comparator): " + maxReverse);

        // Finding frequency of an element
        int frequency = Collections.frequency(numbers, 20);
        System.out.println("Frequency of 20: " + frequency);
    }

    /**
     * Demonstrates:
     * - Collections.synchronizedList()
     * - Thread-safe ArrayList usage
     */
    @Test
    public void learn_thread_safe_ArrayList() {
        // Creating a thread-unsafe ArrayList
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        // Making the ArrayList thread-safe
        List<String> synchronizedList = Collections.synchronizedList(list);

        // Accessing the synchronized list (requires synchronization for iteration)
        synchronized (synchronizedList) {
            System.out.println("Thread-safe ArrayList:");
            for (String item : synchronizedList) {
                System.out.println(item);
            }
        }

        // Demonstrating safe add operation
        synchronizedList.add("Grapes");
        System.out.println("After adding 'Grapes': " + synchronizedList);
    }
}

