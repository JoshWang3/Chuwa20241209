package CollectionsTest;

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
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        assertEquals(1, numbers[0]);
        assertEquals(10, numbers[9]);

        numbers[4] = 15;
        assertEquals(15, numbers[4]);


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
        int[] numbers = {10, 3, 7, 1, 4, 6, 8, 2, 9, 5};
        Arrays.sort(numbers);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, numbers);

        int binarySearchResult = Arrays.binarySearch(numbers, 4);
        assertEquals(3, binarySearchResult);


        int[] partialNumbers = {10, 3, 7, 1, 4, 6, 8, 2, 9, 5};
        Arrays.sort(partialNumbers, 2, 6); // Sort index 2 to 5
        assertArrayEquals(new int[]{10, 3, 1, 4, 6, 7, 8, 2, 9, 5}, partialNumbers);

        int[] numbersParallelSort = {10, 3, 7, 1, 4, 6, 8, 2, 9, 5};
        Arrays.parallelSort(numbersParallelSort);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, numbersParallelSort);


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

        int[] copyFull = Arrays.copyOf(numbers, numbers.length);
        assertArrayEquals(numbers, copyFull);

        int[] copyPartial = Arrays.copyOf(numbers, 5);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, copyPartial);

        int[] rangeCopy = Arrays.copyOfRange(numbers, 0, 5);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, rangeCopy);


        int[] emptyCopy = Arrays.copyOf(numbers, 0);
        assertArrayEquals(new int[]{}, emptyCopy);

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
        Integer[] numbers = {1, 2, 3, 4, 5};
        List<Integer> list = Arrays.asList(numbers);
        assertEquals(numbers.length, list.size());
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), list);

        assertThrows(UnsupportedOperationException.class, () -> {
            list.add(6);
        });

        int[] numbers1 = {1, 2, 3, 4, 5};
        int[] numbers2 = {1, 2, 3, 4, 5};
        int[] numbers3 = {1, 2, 3, 4, 6};
        assertTrue(Arrays.equals(numbers1, numbers2));
        assertFalse(Arrays.equals(numbers1, numbers3));

        int[] numbersToFill = new int[5];
        Arrays.fill(numbersToFill, 20);
        assertArrayEquals(new int[]{20, 20, 20, 20, 20}, numbersToFill);

        Arrays.fill(numbersToFill, 1, 3, 10);
        assertArrayEquals(new int[]{20, 10, 10, 20, 20}, numbersToFill);

        int[] emptyArray = new int[0];
        Arrays.fill(emptyArray, 42);
        assertArrayEquals(new int[]{}, emptyArray);

    }
}
