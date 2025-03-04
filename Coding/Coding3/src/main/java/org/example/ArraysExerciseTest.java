package org.example;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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
        // insert elements into arrays and retrieve elements from arrays
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        // insert elements into arrays
        numbers[9] = 11;
        // retrieve elements from arrays
        System.out.println(numbers[9]);
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
        // arrays containing unsorted random numbers
        int[] numbers = { 3, 1, 4, 1, 5, 9, 2, 6, 5, 3 };
        // binary search for a number in the array e.g. 4
        System.out.println(Arrays.binarySearch(numbers, 4));
        System.out.println("===============");
        // sort the array
        Arrays.sort(numbers);
        // print the sorted array
        for (int number : numbers) {
            System.out.println(number);
        }

        System.out.println("===============");
        int[] numbers2 = { 3, 1, 4, 1, 5, 9, 2, 6, 5, 3 };

        // parallel sort the array
        Arrays.parallelSort(numbers2);
        // print the sorted array
        for (int number : numbers2) {
            System.out.println(number);
        }

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
        // copy the entire array
        int[] numbers = { 2, 98, 23, 45, 1, 76, 34, 56, 89, 12 };
        int[] copiedNumbers = Arrays.copyOf(numbers, numbers.length);
        for (int number : copiedNumbers) {
            System.out.println(number);
        }

        System.out.println("===============");
        // copy a range of the array
        int[] numbers2 = { 234, 1, 23, -8, 45, 12, 67, 89, 23, 45 };
        int[] copiedNumbers2 = Arrays.copyOfRange(numbers2, 0, 5);
        for (int number : copiedNumbers2) {
            System.out.println(number);
        }
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

        // convert an array to a list
        List<Integer> list = Arrays.asList(2, 98, 23, 45, 1, 76, 34, 56, 89, 12);
        System.out.println(list);
        System.out.println("===============");

        // test if two arrays are equal
        int[] numbers1 = { 2, 98, 23, 45, 1, 76, 34, 56, 89, 12 };
        int[] numbers2 = { 2, 98, 23, 45, 1, 76, 34, 56, 89, 12 };
        System.out.println(Arrays.equals(numbers1, numbers2));
        System.out.println("===============");

        // fill an array with a specific value
        int[] numbers3 = { 2, 98, 23, 45, 1, 76, 34, 56, 89, 12 };
        Arrays.fill(numbers3, 20);
        for (int number : numbers3) {
            System.out.println(number);
        }


    }
}
