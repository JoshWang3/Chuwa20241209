package HW3.Collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

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

        System.out.println(numbers[1]);
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
        int[] numbers = {5, 3, 8, 1, 2, 7, 4, 6};
        Arrays.sort(numbers, 0, 3);
        System.out.println(Arrays.toString(numbers));

        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.binarySearch(numbers, 3));

        int[] numbersCopy = {5, 3, 8, 1, 2, 7, 4, 6};
        System.out.println(Arrays.toString(numbersCopy));
        Arrays.parallelSort(numbersCopy);
        System.out.println(Arrays.toString(numbersCopy));
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
        int[] copiedNumbers = Arrays.copyOf(numbers, numbers.length);
        System.out.println(Arrays.toString(copiedNumbers));

        int[] copiedRange = Arrays.copyOfRange(numbers, 0, 5);

        System.out.println(Arrays.toString(copiedRange));
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
        int[] numbers1 = {1, 2, 3, 4, 5};
        int[] numbers2 = {1, 2, 3, 4, 5};
        int[] numbers3 = {5, 4, 3, 2, 1};

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(5, list.size());


        System.out.println((Arrays.equals(numbers1, numbers2)));


        Arrays.fill(numbers1, 20);
        System.out.println(Arrays.toString(numbers1));
    }
}