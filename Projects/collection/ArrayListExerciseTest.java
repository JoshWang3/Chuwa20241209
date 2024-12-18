package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Demonstrates basic ArrayList operations: inserting, retrieving, removing, replacing, updating, iterating, and sorting.
 */
public class ArrayListExerciseTest {

    /**
     * Demonstrates inserting elements into an ArrayList and retrieving them.
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        // Create a new ArrayList and add elements
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        System.out.println("Initial list: " + list);

        // Retrieve an element by index
        String secondElement = list.get(1);
        System.out.println("Element at index 1: " + secondElement);

        // Get the size of the list
        int size = list.size();
        System.out.println("Size of the list: " + size);

        // Add all elements from another list
        List<String> anotherList = Arrays.asList("Date", "Elderberry");
        list.addAll(anotherList);
        System.out.println("After addAll: " + list);
    }

    /**
     * Demonstrates removing, replacing, and updating elements in an ArrayList.
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        // Initialize the ArrayList
        List<String> list = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry", "Date", "Elderberry"));
        System.out.println("Original list: " + list);

        // Remove element by index
        list.remove(2); // Removes "Cherry"
        System.out.println("After removing element at index 2: " + list);

        // Remove element by object
        list.remove("Date");
        System.out.println("After removing 'Date': " + list);

        // Remove all elements in another collection
        List<String> toRemove = Arrays.asList("Apple", "Elderberry");
        list.removeAll(toRemove);
        System.out.println("After removeAll: " + list);

        // Clear the list
        list.clear();
        System.out.println("After clear: " + list);

        // Re-initialize the list for further operations
        list.addAll(Arrays.asList("Fig", "Grape", "Honeydew", "Fig"));
        System.out.println("Re-initialized list: " + list);

        // Update an element using set
        list.set(1, "Guava");
        System.out.println("After setting index 1 to 'Guava': " + list);

        // Replace all elements using replaceAll
        list.replaceAll(String::toUpperCase);
        System.out.println("After replaceAll to uppercase: " + list);

        // Check for containment
        boolean containsFIG = list.contains("FIG");
        System.out.println("List contains 'FIG': " + containsFIG);

        // Find index of an element
        int indexOfFIG = list.indexOf("FIG");
        System.out.println("Index of 'FIG': " + indexOfFIG);

        // Find last index of an element
        int lastIndexOfFIG = list.lastIndexOf("FIG");
        System.out.println("Last index of 'FIG': " + lastIndexOfFIG);
    }

    /**
     * Demonstrates iterating over an ArrayList using an Iterator.
     */
    @Test
    public void learn_Iterator() {
        // Initialize the ArrayList
        List<String> list = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry"));
        System.out.println("Initial list: " + list);

        // Create an iterator
        Iterator<String> iterator = list.iterator();

        // Iterate using the iterator
        System.out.println("Iterating over the list:");
        while (iterator.hasNext()) {
            String fruit = iterator.next();
            System.out.println("Fruit: " + fruit);
            if (fruit.equals("Banana")) {
                iterator.remove(); // Removes "Banana"
            }
        }
        System.out.println("List after iteration and removal: " + list);

        // Using forEachRemaining (Java 8+)
        System.out.println("Adding 'Date' and using forEachRemaining:");
        list.add("Date");
        Iterator<String> newIterator = list.iterator();
        newIterator.forEachRemaining(fruit -> System.out.println("Fruit: " + fruit));
    }

    /**
     * Demonstrates sorting operations on an ArrayList.
     */
    @Test
    public void learn_Sorting() {
        // Initialize the ArrayList
        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 9, 2, 7, 4, 6));

        // Sort using List's sort method with natural order
        numbers.sort(Comparator.naturalOrder());
        System.out.println("Sorted list (natural order): " + numbers);

        // Sort using Collections.sort
        Collections.sort(numbers, Comparator.reverseOrder());
        System.out.println("Sorted list (reverse order) using Collections.sort: " + numbers);

        // Sort using Collections.sort without a comparator (natural order)
        Collections.sort(numbers);
        System.out.println("Sorted list (natural order) using Collections.sort: " + numbers);

        // Parallel sort
        int[] array = {10, 9, 8, 7, 6, 5};
        Arrays.parallelSort(array);
        System.out.println("Parallel sorted array: " + Arrays.toString(array));
    }
}