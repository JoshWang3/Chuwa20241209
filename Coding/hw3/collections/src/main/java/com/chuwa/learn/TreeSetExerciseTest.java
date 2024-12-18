package com.chuwa.learn;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
public class TreeSetExerciseTest {
    /**
     * e.g.
     * Set<Integer> set= new TreeSet<>();
     *
     * add(E e)
     * addAll(Collection<> c)
     *
     * contains(Object o)
     *
     * first()
     * last()
     * subSet(E fromElement, E toElement)
     * headSet(E toElement)
     * tailSet(E fromElement)
     *
     * remove(Object o)
     *
     * size()
     * isEmpty()
     *
     *
     */

    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        Set<Integer> set = new TreeSet<>();

        // Add elements
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);

        assertEquals(4, set.size());
        assertTrue(set.contains(20));
        assertFalse(set.contains(50));

        // AddAll - Add a collection of elements
        List<Integer> additionalElements = Arrays.asList(50, 60, 70);
        set.addAll(additionalElements);

        assertEquals(7, set.size());
        assertTrue(set.contains(50));

        // Retrieve first and last elements
        TreeSet<Integer> treeSet = (TreeSet<Integer>) set; // Cast to TreeSet to access first() and last()
        assertEquals(10, (int) treeSet.first());
        assertEquals(70, (int) treeSet.last());

        // SubSet - Retrieve a subset of elements
        Set<Integer> subset = treeSet.subSet(20, 60); // From 20 (inclusive) to 60 (exclusive)
        assertEquals(Arrays.asList(20, 30, 40, 50), new ArrayList<>(subset));

        // HeadSet - Elements less than a given value
        Set<Integer> headSet = treeSet.headSet(40); // Elements < 40
        assertEquals(Arrays.asList(10, 20, 30), new ArrayList<>(headSet));

        // TailSet - Elements greater than or equal to a given value
        Set<Integer> tailSet = treeSet.tailSet(40); // Elements >= 40
        assertEquals(Arrays.asList(40, 50, 60, 70), new ArrayList<>(tailSet));

        // Remove an element
        assertTrue(set.remove(30));
        assertFalse(set.contains(30));
        assertEquals(6, set.size());

        // isEmpty() and clear()
        assertFalse(set.isEmpty());
        set.clear();
        assertTrue(set.isEmpty());
        assertEquals(0, set.size());

    }
}
