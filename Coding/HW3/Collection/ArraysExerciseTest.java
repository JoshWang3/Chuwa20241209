package Collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ArraysExerciseTest {

    /**
     * Demonstrates:
     * - Array declaration
     * - Retrieving elements
     * - Inserting elements
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Retrieving elements
        System.out.println("Element at index 3: " + numbers[3]);

        // Inserting/Updating element
        numbers[3] = 100;
        System.out.println("Updated element at index 3: " + numbers[3]);

        // Printing entire array
        System.out.println("Updated Array: " + Arrays.toString(numbers));
    }

    /**
     * Demonstrates:
     * - Arrays.binarySearch()
     * - Arrays.sort()
     * - Arrays.parallelSort()
     */
    @Test
    public void learn_search_and_sort() {
        int[] numbers = {5, 2, 8, 1, 3, 7};

        // Sorting the array
        Arrays.sort(numbers);
        System.out.println("Sorted array: " + Arrays.toString(numbers));

        // Binary search for a value (requires sorted array)
        int index = Arrays.binarySearch(numbers, 3);
        System.out.println("Index of 3: " + index);

        // Parallel sort (Java 8 feature)
        int[] anotherArray = {9, 4, 6, 2, 8, 1};
        Arrays.parallelSort(anotherArray);
        System.out.println("Parallel sorted array: " + Arrays.toString(anotherArray));
    }

    /**
     * Demonstrates:
     * - Arrays.copyOf()
     * - Arrays.copyOfRange()
     */
    @Test
    public void learn_copy_of_array() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8};

        // Copy entire array
        int[] copy = Arrays.copyOf(numbers, numbers.length);
        System.out.println("Copy of array: " + Arrays.toString(copy));

        // Copy a range of the array
        int[] rangeCopy = Arrays.copyOfRange(numbers, 2, 6);
        System.out.println("Copy of range (index 2 to 5): " + Arrays.toString(rangeCopy));
    }

    /**
     * Demonstrates:
     * - Arrays.asList()
     * - Arrays.equals()
     * - Arrays.fill()
     */
    @Test
    public void learn_common_operations() {
        int[] numbers1 = {1, 2, 3, 4, 5};
        int[] numbers2 = {1, 2, 3, 4, 5};
        int[] numbers3 = {10, 20, 30};

        // Converting array to List
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("List from array: " + list);

        // Comparing arrays
        boolean isEqual = Arrays.equals(numbers1, numbers2);
        System.out.println("numbers1 equals numbers2: " + isEqual);

        // Filling an array with a constant value
        Arrays.fill(numbers3, 99);
        System.out.println("Array after fill: " + Arrays.toString(numbers3));
    }
}

