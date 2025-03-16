package com.chuwa.learn.collection;

import org.junit.Test;

import java.util.Collections;
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
        LinkedList<Integer> list = new LinkedList<>();

        list.add(10);
        list.add(20);
        list.addFirst(5);
        list.add(1, 15);

        List<Integer> additionalList = new LinkedList<>();
        additionalList.add(25);
        additionalList.add(30);
        list.addAll(additionalList);
        list.addAll(2, additionalList);

        Integer firstElement = list.get(0);
        Integer lastElement = list.get(list.size() - 1);
        Integer elementAtIndex = list.get(2);

        System.out.println(list);
        System.out.println(firstElement);
        System.out.println(lastElement);
        System.out.println(elementAtIndex);
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
        List<Integer> list = new LinkedList<>();

        list.add(10);
        list.add(20);
        list.add(15);
        list.add(20);
        list.add(5);

        list.remove(1);
        list.remove(Integer.valueOf(20));
        ((LinkedList<Integer>) list).removeFirst();
        ((LinkedList<Integer>) list).removeLast();
        ((LinkedList<Integer>) list).removeLastOccurrence(20);

        Collections.sort(list);

        System.out.println(list);
    }
}
