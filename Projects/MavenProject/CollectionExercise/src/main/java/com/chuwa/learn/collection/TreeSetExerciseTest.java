package com.chuwa.learn.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

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

        set.add(10);
        set.add(20);
        set.add(15);

        set.addAll(Arrays.asList(5, 25, 30));

        boolean contains10 = set.contains(10);
        Integer firstElement = ((TreeSet<Integer>) set).first();
        Integer lastElement = ((TreeSet<Integer>) set).last();
        Set<Integer> subset = ((TreeSet<Integer>) set).subSet(10, 25);
        Set<Integer> headset = ((TreeSet<Integer>) set).headSet(20);
        Set<Integer> tailset = ((TreeSet<Integer>) set).tailSet(15);

        set.remove(15);

        int size = set.size();
        boolean isEmpty = set.isEmpty();

        System.out.println(set);
        System.out.println(contains10);
        System.out.println(firstElement);
        System.out.println(lastElement);
        System.out.println(subset);
        System.out.println(headset);
        System.out.println(tailset);
        System.out.println(size);
        System.out.println(isEmpty);
    }
}
