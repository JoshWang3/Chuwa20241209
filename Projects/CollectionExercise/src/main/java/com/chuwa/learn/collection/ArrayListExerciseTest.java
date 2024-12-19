package com.chuwa.learn.collection;

import org.junit.Test;

import java.util.*;

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
        list.add(0);
        int zero = list.get(0);
        int size = list.size();
        System.out.println("List: " + list);
        System.out.println("First element: " + zero);
        System.out.println("List size: " + size);

        Integer[] array = {1, 2, 3};
        list.addAll(Arrays.asList(array));
        System.out.println("List: " + list);
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
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        System.out.println("List: " + list);
        list.remove(0);
        System.out.println("List: " + list);
        list.remove(Integer.valueOf(3));
        System.out.println("List: " + list);
        List<Integer> toRemove = Arrays.asList(1, 2);
        list.removeAll(toRemove);
        System.out.println("List: " + list);
        list.clear();
        System.out.println("List: " + list);
        list.addAll(Arrays.asList(100, 25, 2, 4, 5));
        list.set(0, 1);
        System.out.println("List: " + list);
        list.replaceAll(x -> x * 2);
        System.out.println("List: " + list);
        boolean res1 = list.contains(4);
        int res2 = list.indexOf(50);
        int res3 = list.lastIndexOf(8);
        System.out.println("Contains 4: " + res1);
        System.out.println("Index of 50: " + res2);
        System.out.println("Last index of 8: " + res3);
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
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        System.out.println(list);
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next() + " ");
        }
        iterator = list.iterator();
        while(iterator.hasNext()) {
            Integer val = iterator.next();
            if(val.equals(1)) {
                iterator.remove();
            }
        }
        System.out.println(list);
        iterator = list.iterator();
        iterator.forEachRemaining(val -> System.out.println(val + " "));
    }


    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        List<Integer> list = Arrays.asList(1, 3, 2, 4);
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list, Comparator.reverseOrder());
        System.out.println(list);
        Collections.sort(list, (a, b) -> a - b);
        System.out.println(list);
    }
}
