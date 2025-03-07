package com.chuwa.learn.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
        // Create a new HashSet and add elements
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println(set);

        set.addAll(Arrays.asList(4, 5, 6));
        System.out.println(set);

        System.out.println(set.contains(3));
        System.out.println(set.contains(7));

        set.remove(2);
        System.out.println(set);

        set.clear();
        System.out.println(set);

        System.out.println("Empty? " + set.isEmpty());
    }
}
