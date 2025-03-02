package CollectionsTest;

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
        List<Integer> list = Arrays.asList(5, 1, 9, 3, 7, 1, 3, 9);

        int min = Collections.min(list);
        assertEquals(1, min);

        int minReversed = Collections.min(list, Comparator.reverseOrder());
        assertEquals(9, minReversed);

        int max = Collections.max(list);
        assertEquals(9, max);

        int maxReversed = Collections.max(list, Comparator.reverseOrder());
        assertEquals(1, maxReversed);

        int frequencyOf1 = Collections.frequency(list, 1);
        int frequencyOf10 = Collections.frequency(list, 10);

        assertEquals(2, frequencyOf1);
        assertEquals(0, frequencyOf10);

    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());

        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(3, list.size());
        assertTrue(list.contains(1));


        list.set(0, 10);
        assertEquals((Integer) 10, list.get(0));

        Thread thread1 = new Thread(() -> list.add(4));
        Thread thread2 = new Thread(() -> list.add(5));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            fail("Threads interrupted unexpectedly");
        }

        assertEquals(5, list.size());

    }
}
