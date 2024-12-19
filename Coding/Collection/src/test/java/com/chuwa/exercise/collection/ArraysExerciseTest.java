package com.chuwa.exercise.collection;

import org.junit.Test;
import java.util.*;

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

        System.out.println("Element at index 3: " + numbers[3]);

        numbers[3] = 40;

        System.out.println("Element at index 3: " + numbers[3]);


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

        int[] numbers = {9, 5, 1, 4, 3, 2, 8, 6, 10, 7};

        Arrays.sort(numbers);
        System.out.println("Sorted array: " + Arrays.toString(numbers));

        int index = Arrays.binarySearch(numbers, 4);
        System.out.println("Index of 4: " + index); // 输出 3

        int[] numbersPartial = {9, 5, 1, 4, 3, 2, 8, 6, 10, 7};
        Arrays.sort(numbersPartial, 2, 7);
        System.out.println("Partially sorted array: " + Arrays.toString(numbersPartial));

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
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int[] copiedArray = Arrays.copyOf(numbers, numbers.length);
        System.out.println("Copied array: " + Arrays.toString(copiedArray));

        int[] copiedRange = Arrays.copyOfRange(numbers, 3, 8);
        System.out.println("Copied range: " + Arrays.toString(copiedRange));
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
        int[] numbers2 = {1, 2, 3, 4, 5};

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("List: " + list);

        boolean areEqual = Arrays.equals(numbers, numbers2);
        System.out.println("Arrays are equal: " + areEqual);

        Arrays.fill(numbers, 20);
        System.out.println("Filled array: " + Arrays.toString(numbers));

    }
}
