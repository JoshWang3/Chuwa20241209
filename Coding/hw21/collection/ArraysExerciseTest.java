package collection;

import org.junit.Assert;
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
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Assert.assertEquals(1, nums[0]);

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] - 1;
            Assert.assertEquals(i, nums[i]);
        }
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
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int idx = Arrays.binarySearch(nums, 5);
        Assert.assertEquals(4, idx);

        int[] nums1 = new int[]{2, 1, 5, 3, 6 ,8, 9, 7, 4, 10};
        Arrays.sort(nums1);
        Assert.assertArrayEquals(nums, nums1);

        int[] nums2 = new int[]{2, 1, 5, 3, 6 ,8, 9, 7, 4, 10};
        Arrays.sort(nums2, 0, 5);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 5, 6, 8, 9, 7, 4, 10}, nums2);

        Arrays.parallelSort(nums2);
        Assert.assertArrayEquals(nums, nums2);
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
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] nums1 = Arrays.copyOf(nums, nums.length);
        Assert.assertArrayEquals(nums, nums1);

        int[] nums2 = Arrays.copyOfRange(nums, 0, 5);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, nums2);
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
        Integer[] nums = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> list = Arrays.asList(nums);

        Integer[] nums2 = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
        boolean flag = Arrays.equals(nums, nums2);
        Assert.assertFalse(flag);

        int[] nums3 = new int[3];
        Arrays.fill(nums3, -1);
        Assert.assertArrayEquals(new int[]{-1, -1, -1}, nums3);
    }
}
