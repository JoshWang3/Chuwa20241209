package com.chuwa.learn;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
public class HashSetExerciseTest {
    /**
     * e.g.
     * Set<Integer> set= new HashSet<>();
     *
     * add(E e)
     * addAll(Collection<> c)
     *
     * get()
     * contains()
     *
     * remove(Object o)
     * clear()
     *
     * isEmpty()
     *
     *
     */

    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        Set<Integer> set = new HashSet<>();

        // add(E e) - Add elements
        set.add(1);
        set.add(2);
        set.add(3);

        assertEquals(3, set.size());
        assertTrue(set.contains(1));
        assertTrue(set.contains(2));

        // addAll(Collection<? extends E> c) - Add all elements from another collection
        Collection<Integer> anotherCollection = Arrays.asList(4, 5, 6);
        set.addAll(anotherCollection);

        assertEquals(6, set.size());
        assertTrue(set.contains(4));
        assertTrue(set.contains(6));

        // contains(Object o) - Check if element exists
        assertTrue(set.contains(3));
        assertFalse(set.contains(10));

        // remove(Object o) - Remove a specific element
        set.remove(2);
        assertFalse(set.contains(2));
        assertEquals(5, set.size());

        // isEmpty() - Check if set is empty
        assertFalse(set.isEmpty());

        // clear() - Remove all elements
        set.clear();
        assertTrue(set.isEmpty());
        assertEquals(0, set.size());

    }
}
