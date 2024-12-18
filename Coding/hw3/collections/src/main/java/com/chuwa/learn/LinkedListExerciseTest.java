package com.chuwa.learn;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

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

        // Add elements
        list.add(1);
        list.addLast(2); // Add to the end
        list.addFirst(0); // Add to the beginning
        list.add(1, 100); // Insert at index 1

        assertEquals(Arrays.asList(0, 100, 1, 2), list);

        // Add a collection
        List<Integer> anotherList = Arrays.asList(3, 4, 5);
        list.addAll(anotherList);

        assertEquals(Arrays.asList(0, 100, 1, 2, 3, 4, 5), list);

        // Add a collection at an index
        list.addAll(2, Arrays.asList(200, 300));
        assertEquals(Arrays.asList(0, 100, 200, 300, 1, 2, 3, 4, 5), list);

        // Retrieve elements
        assertEquals(0, (int) list.getFirst());
        assertEquals(5, (int) list.getLast());
        assertEquals(300, (int) list.get(3));

        // Verify size
        assertEquals(9, list.size());

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
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(5, 1, 3, 2, 4, 3, 6));

        // Remove first and last elements
        list.removeFirst();
        list.removeLast();
        assertEquals(Arrays.asList(1, 3, 2, 4, 3), list);

        // Remove by index
        list.remove(2); // Remove element at index 2
        assertEquals(Arrays.asList(1, 3, 4, 3), list);

        // Remove by object
        list.remove(Integer.valueOf(4));
        assertEquals(Arrays.asList(1, 3, 3), list);

        // Remove last occurrence
        list.add(3);
        list.removeLastOccurrence(3);
        assertEquals(Arrays.asList(1, 3, 3), list);

        // Sort the list
        list.add(2);
        list.add(0);
        list.sort(Comparator.naturalOrder());
        assertEquals(Arrays.asList(0, 1, 2, 3, 3), list);

    }
}
