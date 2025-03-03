package com.chuwa.exercise.collection;

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
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        System.out.println("List: " + list);
        System.out.println("Element at index 1: " + list.get(1));
        System.out.println("Size of list: " + list.size());

        List<String> anotherList = Arrays.asList("d", "e");
        list.addAll(anotherList);

        System.out.println("List after addAll: " + list);

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
        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));

        // remove
        list.remove(1);
        System.out.println("List after removing: " + list);

        list.remove("a");
        System.out.println("List after removing: " + list);

        list.subList(1, 3).clear();
        System.out.println("List after removing: " + list);

        list.clear();
        System.out.println("List after clearing: " + list);

        // update
        list.addAll(Arrays.asList("d", "e"));
        list.set(1, "a");
        System.out.println("List after updating: " + list);

        list.replaceAll(String::toUpperCase);
        System.out.println("List after updating: " + list);

        // check
        System.out.println("Contains 'D': " + list.contains("D"));
        System.out.println("Index of 'D': " + list.indexOf("D"));
        System.out.println("Last index of 'D': " + list.lastIndexOf("D"));
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
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println("Iterator next: " + element);
            if ("B".equals(element)) {
                iterator.remove();
            }
        }

        System.out.println("List after iterator remove: " + list);

//        list.forEachRemaining(System.out::println);
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        List<String> list = new ArrayList<>(Arrays.asList("B", "A", "C"));

        Collections.sort(list);
        System.out.println("Sorted list: " + list);

        list.sort(Comparator.reverseOrder());
        System.out.println("Sorted list (reverse order): " + list);
    }
}
