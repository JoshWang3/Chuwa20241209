package com.chuwa.exercise.collection;

import org.junit.Test;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class CollectionsExerciseTest {

    /**
     * Collections.min(list))
     * min(Collection c, Comparator comp)
     *
     * Collections.max(list)
     * max(Collection c, Comparator comp)
     *
     * frequency(Collection c, object o)
     */

    @Test
    public void learn_common_collections_operations() {
        List<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, 42, 23, 16, 15, 8, 16, 4, 23, 42, 16);

        System.out.println("Numbers List: " + numbers);

        // Find minimum and maximum
        int min = Collections.min(numbers);
        int max = Collections.max(numbers);
        System.out.println("Min: " + min + ", Max: " + max);

        // Find frequency of number 16
        int freq16 = Collections.frequency(numbers, 16);
        System.out.println("Frequency of 16: " + freq16);
    }

    /**
     * Demonstrates creating and using a thread-safe ArrayList.
     */
    @Test
    public void learn_thread_safe_ArrayList() {
        // Regular ArrayList
        List<String> regularList = new ArrayList<>();
        regularList.add("Apple");
        regularList.add("Banana");
        regularList.add("Cherry");
        System.out.println("Regular List: " + regularList);

        // Synchronized (thread-safe) ArrayList
        List<String> synchronizedList = Collections.synchronizedList(new ArrayList<>());
        synchronizedList.add("Dog");
        synchronizedList.add("Elephant");
        synchronizedList.add("Fox");
        System.out.println("Synchronized List: " + synchronizedList);

        // Modify synchronized list
        synchronizedList.add("Giraffe");
        synchronizedList.remove("Dog");
        System.out.println("Modified Synchronized List: " + synchronizedList);
    }
}

