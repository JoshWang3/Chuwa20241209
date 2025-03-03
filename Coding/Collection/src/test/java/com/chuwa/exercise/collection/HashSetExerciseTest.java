package com.chuwa.exercise.collection;

import org.junit.Test;
import java.util.*;

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

        set.add(10);
        set.add(20);
        set.add(30);

        Set<Integer> anotherSet = Set.of(40, 50, 20);
        set.addAll(anotherSet);

        System.out.println("Set: " + set);

        // can't use get method
        System.out.println("Contains 20? " + set.contains(20));

        set.remove(20);
        System.out.println("After removing 20: " + set);

        System.out.println("Is the set empty? " + set.isEmpty());

        set.clear();
        System.out.println("After clear: " + set);

        System.out.println("Is the set empty? " + set.isEmpty());

    }
}
