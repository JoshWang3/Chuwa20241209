package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Demonstrates basic HashSet operations: inserting, retrieving, and removing elements.
 */
public class HashSetExerciseTest {

    /**
     * Demonstrates inserting elements into a HashSet, retrieving elements, and removing elements.
     */
    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        // Create a new HashSet and add elements
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println("After adding elements: " + set);

        // Add all elements from another collection
        set.addAll(Arrays.asList(4, 5, 6));
        System.out.println("After addAll: " + set);

        // Check if the set contains specific elements
        System.out.println("Contains 3? " + set.contains(3));
        System.out.println("Contains 7? " + set.contains(7));

        // Remove an element
        set.remove(2);
        System.out.println("After removing 2: " + set);

        // Clear the set
        set.clear();
        System.out.println("After clear: " + set);

        // Check if the set is empty
        System.out.println("Is set empty? " + set.isEmpty());
    }
}
