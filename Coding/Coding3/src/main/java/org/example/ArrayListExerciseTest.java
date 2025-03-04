package org.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author b1go
 * @date 6/12/22 4:43 PM
 */
public class ArrayListExerciseTest {
    /**
     * new ArrayList()
     * add elements
     * get element
     * get Size
     * list.addAll(anotherList)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.get(0));
        System.out.println(list.size());
        System.out.println("===============");
        List<Integer> anotherList = new ArrayList<>();
        anotherList.addAll(list);
        System.out.println(anotherList);
    }

    /**
     * remove(int index)
     * remove(Object o)
     * removeRange(int fromIndex, int toIndex)
     * removeAll(Collection<?> c)
     * clear()
     *
     * Update:
     * set(int index, E e)
     * replaceAll(UnaryOperator<E> operator)
     *
     * check:
     * contains(Object o)
     * indexOf(Object o)
     * lastIndexOf(Object o)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(0);
        System.out.println(list);
        list.remove(Integer.valueOf(2));
        System.out.println(list);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.remove(3);
        System.out.println(list);
        list.clear();
        System.out.println(list);
        System.out.println("===============");
        List<Integer> anotherList = new ArrayList<>();
        anotherList.add(1);
        anotherList.add(2);
        anotherList.add(3);
        anotherList.set(0, 4);
        System.out.println(anotherList);
        anotherList.replaceAll(e -> e * 2);
        System.out.println(anotherList);
        System.out.println(anotherList.contains(4));
        System.out.println(anotherList.indexOf(4));
        System.out.println(anotherList.lastIndexOf(4));
    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     * forEachRemaining(Consumer<? super E> action) -- from Java8
     */

    @Test
    public void learn_Iterator() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        for (Integer integer : list) {
            System.out.println(integer);
        }
        System.out.println("===============");
        list.iterator().forEachRemaining(System.out::println);
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(4);
        list.add(1);
        list.add(5);
        list.add(9);
        list.add(2);
        list.add(6);
        list.add(5);
        list.add(3);
        list.sort(Integer::compareTo);
        System.out.println(list);
        System.out.println("===============");
        List<Integer> anotherList = new ArrayList<>();
        anotherList.add(3);
        anotherList.add(1);
        anotherList.add(4);
        anotherList.add(1);
        anotherList.add(5);
        anotherList.add(9);
        anotherList.add(2);
        anotherList.add(6);
        anotherList.add(5);
        anotherList.add(3);
        anotherList.sort((o1, o2) -> o2 - o1);
        System.out.println(anotherList);
    }
}
