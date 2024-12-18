package com.chuwa.learn;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class CollectionsExerciseTest {

    /**
     * Collections.min(list))
     * min(Collection c, Comparator comp)
     *
     * Collections.max(list)
     * max(Collection c, Comparator comp)
     *
     * frequency(Collection c, object o)
     */

    @Test
    public void learn_common_collections_operations() {
        List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6);

        // Find min and max without comparator
        int min = Collections.min(numbers);
        int max = Collections.max(numbers);

        assertEquals(1, min);
        assertEquals(9, max);

        // Find min and max with a comparator (reverse order)
        Comparator<Integer> reverseOrder = Comparator.reverseOrder();
        int minReverse = Collections.min(numbers, reverseOrder);
        int maxReverse = Collections.max(numbers, reverseOrder);

        assertEquals(9, minReverse);
        assertEquals(1, maxReverse);

        // Frequency of an element
        int frequencyOf1 = Collections.frequency(numbers, 1);
        int frequencyOf5 = Collections.frequency(numbers, 5);

        assertEquals(2, frequencyOf1);
        assertEquals(1, frequencyOf5);

    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        // Create a regular ArrayList
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");

        // Make it thread-safe
        List<String> synchronizedList = Collections.synchronizedList(list);

        // Access synchronized list safely
        synchronized (synchronizedList) {
            for (String element : synchronizedList) {
                System.out.println(element);
            }
        }

        // Perform operations on the synchronized list
        synchronizedList.add("JavaScript");
        synchronizedList.remove("C++");

        assertTrue(synchronizedList.contains("JavaScript"));
        assertFalse(synchronizedList.contains("C++"));

        // Verify the list size
        assertEquals(3, synchronizedList.size());

    }
}
