package com.chuwa.exercise.collection;

import org.junit.Test;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class ArraysExerciseTest {

    /**
     * Demonstrates inserting and retrieving elements in an array.
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        // Initialize an array
        int[] numbers = {1, 2, 3, 4, 5};

        // Retrieve elements
        System.out.println("Original array: " + Arrays.toString(numbers));
        System.out.println("Element at index 2: " + numbers[2]);

        // Insert/Modify an element
        numbers[2] = 30;
        System.out.println("After modification: " + Arrays.toString(numbers));
    }

    /**
     * Demonstrates searching and sorting operations on an array.
     */
    @Test
    public void learn_search_and_sort() {
        int[] numbers = {5, 3, 8, 1, 9, 2, 7, 4, 6};

        // Sort the array
        Arrays.sort(numbers);
        System.out.println("Sorted array: " + Arrays.toString(numbers));

        // Binary search for an element
        int index = Arrays.binarySearch(numbers, 4);
        System.out.println("Index of 4 after sorting: " + index);

        // Parallel sort
        int[] unsorted = {10, 9, 8, 7, 6, 5};
        Arrays.parallelSort(unsorted);
        System.out.println("Parallel sorted array: " + Arrays.toString(unsorted));
    }

    /**
     * Demonstrates copying arrays using copyOf and copyOfRange.
     */
    @Test
    public void learn_copy_of_array() {
        int[] original = {1, 2, 3, 4, 5};

        // Copy the entire array
        int[] copy = Arrays.copyOf(original, original.length);
        System.out.println("Copied array: " + Arrays.toString(copy));

        // Copy a range of the array
        int[] rangeCopy = Arrays.copyOfRange(original, 1, 4);
        System.out.println("Range copied array (index 1 to 3): " + Arrays.toString(rangeCopy));
    }

    /**
     * Demonstrates common array operations: asList, equals, and fill.
     */
    @Test
    public void learn_common_operations() {
        Integer[] numbers1 = {1, 2, 3, 4, 5};
        Integer[] numbers2 = {1, 2, 3, 4, 5};
        Integer[] numbers3 = {5, 4, 3, 2, 1};

        // Convert array to list
        List<Integer> list = Arrays.asList(numbers1);
        System.out.println("List from array: " + list);

        // Check equality
        boolean isEqual = Arrays.equals(numbers1, numbers2);
        System.out.println("numbers1 equals numbers2: " + isEqual);

        boolean isEqualReverse = Arrays.equals(numbers1, numbers3);
        System.out.println("numbers1 equals numbers3: " + isEqualReverse);

        // Fill the array with a specific value
        Arrays.fill(numbers3, 20);
        System.out.println("numbers3 after fill: " + Arrays.toString(numbers3));
    }
}