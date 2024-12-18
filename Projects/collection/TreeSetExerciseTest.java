package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * Demonstrates basic TreeSet operations: inserting, retrieving, and removing elements.
 */
public class TreeSetExerciseTest {

    /**
     * Demonstrates inserting elements into a TreeSet, retrieving elements, and removing elements.
     */
    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        // Create a new TreeSet and add elements
        Set<Integer> set = new TreeSet<>();
        set.add(5);
        set.add(3);
        set.add(8);
        set.add(1);
        set.add(9);
        System.out.println("After adding elements: " + set);

        // Add all elements from another collection
        set.addAll(Arrays.asList(2, 7, 4));
        System.out.println("After addAll: " + set);

        // Check if the set contains specific elements
        System.out.println("Contains 5? " + set.contains(5));
        System.out.println("Contains 10? " + set.contains(10));

        // Retrieve the first and last elements
        System.out.println("First element: " + ((TreeSet<Integer>) set).first());
        System.out.println("Last element: " + ((TreeSet<Integer>) set).last());

        // Retrieve subsets
        System.out.println("SubSet (3 to 7): " + ((TreeSet<Integer>) set).subSet(3, 7));
        System.out.println("HeadSet (to 5): " + ((TreeSet<Integer>) set).headSet(5));
        System.out.println("TailSet (5 and above): " + ((TreeSet<Integer>) set).tailSet(5));

        // Remove an element
        set.remove(5);
        System.out.println("After removing 5: " + set);

        // Check the size and if the set is empty
        System.out.println("Size of the set: " + set.size());
        System.out.println("Is set empty? " + set.isEmpty());
    }
}
