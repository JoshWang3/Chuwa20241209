package com.chuwa.learn.collection;

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
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int first = nums[0];
        int second = nums[1];
        System.out.println(first + " " + second);
        nums[0] = 1000;
        nums[1] = 10000;
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
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
        int[] nums = {1, 2, 4, 5, 6, 3, 8, 7, 9, 10};
        System.out.println(Arrays.toString(nums));
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int index = Arrays.binarySearch(nums, 6);
        System.out.println(index);
        int[] nums1 = {1, 2, 4, 5, 6, 3, 8, 7, 9, 10};
        Arrays.sort(nums1, 1, 3);
        System.out.println(Arrays.toString(nums1));
        int[] nums2 = {1, 2, 4, 5, 6, 3, 8, 7, 9, 10};
        Arrays.parallelSort(nums2);
        System.out.println(Arrays.toString(nums2));
    };


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
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(nums));
        int[] copy1 = Arrays.copyOf(nums, nums.length);
        System.out.println(Arrays.toString(copy1));
        int[] copy2 = Arrays.copyOf(nums, 3);
        System.out.println(Arrays.toString(copy2));
        int[] copy3 = Arrays.copyOfRange(nums, 1, 6);
        System.out.println(Arrays.toString(copy3));
        int[] copy4 = Arrays.copyOf(nums, nums.length + 10);
        System.out.println(Arrays.toString(copy4));
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
        Integer[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> list = Arrays.asList(nums);
        System.out.println(list);

        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {1, 2, 3, 4};
        System.out.println(Arrays.equals(nums1, nums2));

        int[] numsFill = new int[10];
        Arrays.fill(numsFill, 11);
        System.out.println(Arrays.toString(numsFill));

        int[] numsFill2 = {1, 2, 3, 4};
        Arrays.fill(numsFill2, 1, 3, 100);
        System.out.println(Arrays.toString(numsFill2));
    }
}
