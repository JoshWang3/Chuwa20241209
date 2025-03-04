package com.chuwa.learn.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
public class CopyOnWriteArrayListExerciseTest {

    /**
     * e.g.
     * List list = new CopyOnWriteArrayList();
     *
     * add(E e)
     * add(int index, E element)
     * addAll(Collection c)
     * addIfAbsent(E e)
     * addAllAbsent(Collection c)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        System.out.println(list);
        list.add(10);
        System.out.println(list);
        list.add(1, 15);
        System.out.println(list);
        List<Integer> anotherList = Arrays.asList(30, 40, 50);
        list.addAll(anotherList);
        System.out.println(list);
        list.addIfAbsent(10);
        list.addAll(anotherList);
        List<Integer> absentList = Arrays.asList(10, 60, 70, 80);
        list.addAllAbsent(absentList);
        System.out.println(list);

        for (Integer num : list) {
            System.out.println(num);
        }
    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     */

    @Test
    public void learn_Iterator() {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        //Created an iterator
        Iterator<String> itr = list.iterator();
        while (itr.hasNext()) {
            String item = itr.next();
            System.out.println(item);

            if (item.equals("Banana")) {
                try {
                    itr.remove();
                } catch (UnsupportedOperationException e) {
                    System.out.println("Not supported for CopyOnWriteArrayList's iterator.");
                }
            }
        }
    }
}
