package com.chuwa.learn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
public class CopyOnWriteArrayListExerciseTest {

    /**
     * e.g.
     * List list = new CopyOnWriteArrayList();
     *
     * add(E e)
     * add(int index, E element)
     * addAll(Collection c)
     * addIfAbsent(E e)
     * addAllAbsent(Collection c)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        // Add elements
        list.add("Apple");
        list.add("Banana");
        list.add(1, "Orange"); // Insert at index 1

        assertEquals(3, list.size());
        assertEquals("Orange", list.get(1));

        // Add all elements from another collection
        List<String> otherList = Arrays.asList("Grapes", "Pineapple");
        list.addAll(otherList);

        assertEquals(5, list.size());
        assertTrue(list.contains("Grapes"));

        // Add element if absent
        list.addIfAbsent("Apple"); // Already exists
        list.addIfAbsent("Mango"); // New element

        assertEquals(6, list.size());
        assertTrue(list.contains("Mango"));

        // Add all absent elements
        List<String> newList = Arrays.asList("Banana", "Strawberry", "Blueberry");
        list.addAllAbsent(newList);

        assertEquals(8, list.size()); // "Strawberry" and "Blueberry" are added
        assertTrue(list.contains("Strawberry"));
        assertTrue(list.contains("Blueberry"));

    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     */

    @Test
    public void learn_Iterator() {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        // Create an iterator
        Iterator<String> itr = list.iterator();

        // Iterate through the list
        List<String> result = new ArrayList<>();
        while (itr.hasNext()) {
            String fruit = itr.next();
            result.add(fruit);

            // Modifying the list during iteration (safe in CopyOnWriteArrayList)
            if (fruit.equals("Banana")) {
                list.add("Mango");
            }
        }

        // Verify the original elements were iterated
        assertEquals(Arrays.asList("Apple", "Banana", "Orange"), result);

        // Verify the modification occurred after the iteration
        assertTrue(list.contains("Mango"));
        assertEquals(4, list.size());

    }
}
