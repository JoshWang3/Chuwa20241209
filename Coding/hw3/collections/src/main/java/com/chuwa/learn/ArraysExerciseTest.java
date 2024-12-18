package com.chuwa.learn;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class ArraysExerciseTest {

    /**
     * e.g.
     * int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
     * numbers[?]
     *
     * numbers[?] = #
     */

    @Test
    public void learn_Inserting_And_Retrieving() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Retrieve elements
        assertEquals(1, numbers[0]);
        assertEquals(10, numbers[9]);

        // Insert/Update elements
        numbers[0] = 99;
        numbers[5] = 55;

        assertEquals(99, numbers[0]);
        assertEquals(55, numbers[5]);

    }

    /**
     * binarySearch()
     * e.g.
     * Arrays.binarySearch(numbers, 4);
     *
     * sort(array)
     * sort(array, fromIndex, toIndex)
     * e.g.
     * Arrays.sort(numbers);
     *
     * Arrays.parallelSort(numbers);
     */
    @Test
    public void learn_search_and_sort() {
        int[] numbers = {5, 2, 9, 1, 5, 6};

        // Sort the array
        Arrays.sort(numbers);
        assertArrayEquals(new int[]{1, 2, 5, 5, 6, 9}, numbers);

        // Binary search
        int index = Arrays.binarySearch(numbers, 5);
        assertEquals(2, index);

        // Sort part of the array
        int[] partialArray = {10, 8, 6, 4, 2, 0};
        Arrays.sort(partialArray, 1, 4); // Sort from index 1 to 3
        assertArrayEquals(new int[]{10, 4, 6, 8, 2, 0}, partialArray);

        // Parallel sort
        int[] parallelArray = {7, 3, 1, 9, 5};
        Arrays.parallelSort(parallelArray);
        assertArrayEquals(new int[]{1, 3, 5, 7, 9}, parallelArray);

    }

    /**
     * copyOf()
     * e.g.
     * Arrays.copyOf(numbers, numbers.length);
     *
     * copyOfRange()
     * e.g.
     * Arrays.copyOfRange(numbers, 0, 5);
     */
    @Test
    public void learn_copy_of_array() {
        int[] numbers = {1, 2, 3, 4, 5};

        // Copy an entire array
        int[] copy = Arrays.copyOf(numbers, numbers.length);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, copy);

        // Copy part of the array
        int[] partialCopy = Arrays.copyOfRange(numbers, 0, 3);
        assertArrayEquals(new int[]{1, 2, 3}, partialCopy);

        // Copy with larger length
        int[] extendedCopy = Arrays.copyOf(numbers, 7);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 0, 0}, extendedCopy);

    }

    /**
     * asList()
     * e.g.
     * List<Integer> list = Arrays.asList(numbers);
     *
     * equals()
     * e.g.
     * Arrays.equals(numbers1, numbers2);
     *
     * fill()
     * e.g.
     * Arrays.fill(numbers, 20);
     *
     */

    @Test
    public void learn_common_operations() {
        int[] numbers = {1, 2, 3, 4, 5};

        // Convert array to List
        Integer[] numberObjects = {1, 2, 3, 4, 5};
        List<Integer> list = Arrays.asList(numberObjects);
        assertEquals(5, list.size());
        assertTrue(list.contains(3));

        // Check equality of arrays
        int[] numbers1 = {1, 2, 3, 4, 5};
        int[] numbers2 = {1, 2, 3, 4, 5};
        assertTrue(Arrays.equals(numbers1, numbers2));

        // Fill the array with a specific value
        Arrays.fill(numbers, 20);
        assertArrayEquals(new int[]{20, 20, 20, 20, 20}, numbers);

    }
}
