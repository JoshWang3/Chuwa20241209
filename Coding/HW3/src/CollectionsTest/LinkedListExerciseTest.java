package CollectionsTest;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author b1go
 * @date 6/12/22 4:45 PM
 */
public class LinkedListExerciseTest {

    /**
     * e.g.
     * List<Integer> list = new LinkedList<Integer>();
     * Inserting:
     * add(E e) or addLast(E e)
     * addFirst(E e)
     * add(int index, E element)
     * addAll(Collection c)
     * addAll(int index, Collection c)
     *
     * Retrieving:
     * getFirst()
     * getLast()
     * get(int index)
     *
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        assertEquals(Arrays.asList(10), list);

        list.addFirst(20);
        assertEquals(Arrays.asList(20, 10), list);

        list.addLast(30);
        assertEquals(Arrays.asList(20, 10, 30), list);

        list.add(1, 40);
        assertEquals(Arrays.asList(20, 40, 10, 30), list);

        List<Integer> elements = Arrays.asList(50, 60, 70);
        list.addAll(elements);
        assertEquals(Arrays.asList(20, 40, 10, 30, 50, 60, 70), list);

        List<Integer> moreElements = Arrays.asList(100, 110);
        list.addAll(1, moreElements);
        assertEquals(Arrays.asList(20, 100, 110, 40, 10, 30, 50, 60, 70), list);

        Integer firstElement = list.getFirst();
        assertEquals(Integer.valueOf(20), firstElement);

        Integer lastElement = list.getLast();
        assertEquals(Integer.valueOf(70), lastElement);

        Integer elementAtIndex = list.get(1);
        assertEquals(Integer.valueOf(100), elementAtIndex);
    }


    /**
     * removeFirst()
     * removeLast()
     * remove(int index)
     * remove(Object o)
     * removeLastOccurrence()
     *
     * sort()
     */

    @Test
    public void learn_Remove_Sort() {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(10, 20, 30, 40, 50));

        list.removeFirst();
        assertEquals(Arrays.asList(20, 30, 40, 50), list);

        list.removeLast();
        assertEquals(Arrays.asList(20, 30, 40), list);

        list.remove(1);
        assertEquals(Arrays.asList(20, 40), list);

        // Test remove(Object o)
        list.remove(Integer.valueOf(20));
        assertEquals(Arrays.asList(40), list);


        list.add(40);
        list.removeLastOccurrence(Integer.valueOf(40));
        assertEquals(Arrays.asList(40), list);


        list.add(10);
        list.add(30);
        list.add(20);
        Collections.sort(list);
        assertEquals(Arrays.asList(10, 20, 30, 40), list);
    }
}
