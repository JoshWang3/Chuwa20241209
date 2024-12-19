package com.chuwa.exercise.collection;

import org.junit.Test;
import java.util.*;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class CollectionsExerciseTest {

    /**
     * Collections.min(list)
     * min(Collection c, Comparator comp)
     *
     * Collections.max(list)
     * max(Collection c, Comparator comp)
     *
     * frequency(Collection c, object o)
     */

    @Test
    public void learn_common_collections_operations() {
        List<Integer> list = Arrays.asList(10, 20, 30, 10, 40, 20);

        int min = Collections.min(list);
        int max = Collections.max(list);
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);

        Comparator<Integer> descendingOrder = (a, b) -> b - a;
        int minDesc = Collections.min(list, descendingOrder);
        int maxDesc = Collections.max(list, descendingOrder);
        System.out.println("Min (Descending): " + minDesc);
        System.out.println("Max (Descending): " + maxDesc);

        int frequency = Collections.frequency(list, 10);
        System.out.println("Frequency of 10: " + frequency);

    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        List<Integer> synchronizedList = Collections.synchronizedList(list);

        synchronized (synchronizedList) {
            for (Integer num : synchronizedList) {
                System.out.println("Element: " + num);
            }
        }

        synchronizedList.add(6);
        System.out.println("Updated List: " + synchronizedList);

    }
}
