package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

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
        List<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println("===============");
        System.out.println(list.get(0));
        System.out.println(list.get(list.size()-1));

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
        List<Integer> list = new LinkedList<Integer>();
        list.add(9);
        list.add(1);
        list.add(3);
        list.add(7);
        list.add(5);
        list.remove(0);
        System.out.println(list);
        list.remove(Integer.valueOf(3));
        System.out.println(list);
        list.add(2);
        list.removeIf(e -> e % 2 == 0);
        System.out.println(list);
        System.out.println("===============");

        List<Integer> anotherList = new LinkedList<Integer>();
        anotherList.add(9);
        anotherList.add(1);
        anotherList.add(3);
        anotherList.add(7);
        anotherList.add(5);
        anotherList.sort((a, b) -> a - b);

    }
}
