package com.chuwa.learn;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

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

        // Add elements
        list.add("Java");
        list.add("Python");
        list.add("C++");

        // Retrieve elements
        assertEquals("Java", list.get(0));
        assertEquals("Python", list.get(1));

        // Get the size
        assertEquals(3, list.size());

        // Merge another list
        List<String> anotherList = Arrays.asList("JavaScript", "Ruby");
        list.addAll(anotherList);
        assertEquals(5, list.size());
        assertTrue(list.containsAll(anotherList));

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
        List<String> list = new ArrayList<>(Arrays.asList("Java", "Python", "C++", "JavaScript", "Ruby"));

        // Remove by index
        list.remove(2);
        assertFalse(list.contains("C++"));

        // Remove by object
        list.remove("Ruby");
        assertFalse(list.contains("Ruby"));

        // Replace element
        list.set(1, "Go");
        assertEquals("Go", list.get(1));

        // Replace all elements
        list.replaceAll(e -> e.toUpperCase());
        assertEquals("JAVA", list.get(0));

        // Check element existence
        assertTrue(list.contains("GO"));

        // Get index of elements
        assertEquals(0, list.indexOf("JAVA"));
        assertEquals(-1, list.lastIndexOf("Ruby"));

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
        List<String> list = new ArrayList<>(Arrays.asList("Java", "Python", "C++"));

        // Iterate using Iterator
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            if (element.equals("C++")) {
                iterator.remove(); // Remove element
            }
        }

        assertFalse(list.contains("C++"));
        assertEquals(2, list.size());

        // Use forEachRemaining
        iterator = list.iterator();
        List<String> upperCaseList = new ArrayList<>();
        iterator.forEachRemaining(e -> upperCaseList.add(e.toUpperCase()));
        assertEquals(Arrays.asList("JAVA", "PYTHON"), upperCaseList);
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5, 9));

        // Sort in ascending order
        list.sort(Integer::compareTo);
        assertEquals(Arrays.asList(1, 1, 3, 4, 5, 9), list);

        // Sort in descending order using Collections.sort
        list.sort(Comparator.reverseOrder());
        assertEquals(Arrays.asList(9, 5, 4, 3, 1, 1), list);

    }
}