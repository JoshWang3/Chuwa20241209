package org.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        List<Integer> list = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5);

        // Testing Collections.min
        int min = Collections.min(list);
        System.out.println("Min: " + min);
        int max = Collections.max(list);
        System.out.println("Max: " + max);
        int frequency = Collections.frequency(list, 5);
        System.out.println("Frequency of 5: " + frequency);

    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));

        // Converting the ArrayList to a synchronized version
        List<String> synchronizedList = Collections.synchronizedList(list);

        // Performing synchronized operations
        synchronized (synchronizedList) {
            synchronizedList.add("D");
            synchronizedList.add("E");
        }

        // Verifying the contents of the synchronized list
        synchronized (synchronizedList) {
            System.out.println(synchronizedList);
        }
    }
}
