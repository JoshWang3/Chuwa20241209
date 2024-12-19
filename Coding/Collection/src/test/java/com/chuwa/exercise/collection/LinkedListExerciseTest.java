package com.chuwa.exercise.collection;

import org.junit.Test;
import java.util.*;

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
        list.add(20);
        list.addFirst(0);
        list.addLast(30);
        list.add(2, 15);

        Collection<Integer> collection1 = Arrays.asList(50, 60, 70);
        list.addAll(collection1);

        Collection<Integer> collection2 = Arrays.asList(40, 45);
        list.addAll(5, collection2);

        System.out.println("LinkedList: " + list);
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
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(30, 10, 20, 10, 40, 50));

        list.removeFirst();
        list.removeLast();
        list.remove(1);
        list.remove(Integer.valueOf(10));
        list.removeLastOccurrence(Integer.valueOf(10));

        System.out.println("LinkedList: " + list);

    }
}
