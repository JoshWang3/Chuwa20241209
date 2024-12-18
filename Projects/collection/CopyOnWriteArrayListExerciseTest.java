package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
public class CopyOnWriteArrayListExerciseTest {

    /**
     * e.g.
     * List list = new CopyOnWriteArrayList();
     *
     * add(E e)
     * add(int index, E element)
     * addAll(Collection c)
     * addIfAbsent(E e)
     * addAllAbsent(Collection c)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        // Create a new CopyOnWriteArrayList
        List<String> list = new CopyOnWriteArrayList<>();

        // Add elements using add(E e)
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        System.out.println("After add operations: " + list);

        // Add element at a specific index using add(int index, E element)
        list.add(1, "Date");
        System.out.println("After add at index 1: " + list);

        // Add all elements from another collection using addAll(Collection c)
        List<String> additionalFruits = new CopyOnWriteArrayList<>();
        additionalFruits.add("Elderberry");
        additionalFruits.add("Fig");
        list.addAll(additionalFruits);
        System.out.println("After addAll operation: " + list);

        // Add an element if it's absent using addIfAbsent(E e)
        boolean added = list.addIfAbsent("Grape");
        System.out.println("After addIfAbsent 'Grape' (added: " + added + "): " + list);

        // Attempt to add an existing element using addIfAbsent(E e)
        added = list.addIfAbsent("Apple");
        System.out.println("After addIfAbsent 'Apple' (added: " + added + "): " + list);

        // Add all absent elements from another collection using addAllAbsent(Collection c)
        List<String> moreFruits = new CopyOnWriteArrayList<>();
        moreFruits.add("Honeydew");
        moreFruits.add("Banana"); // Already present
        list.addAllAbsent(moreFruits);
        System.out.println("After addAllAbsent operation: " + list);

        // Retrieve elements using get(int index)
        String firstFruit = list.get(0);
        System.out.println("First fruit: " + firstFruit);

        // Retrieve the size of the list using size()
        int size = list.size();
        System.out.println("Size of the list: " + size);

        // Check if the list contains a specific element using contains(Object o)
        boolean containsCherry = list.contains("Cherry");
        System.out.println("Contains 'Cherry': " + containsCherry);

        // Check if the list is empty using isEmpty()
        boolean isEmpty = list.isEmpty();
        System.out.println("Is the list empty?: " + isEmpty);
    }

    /**
     * Demonstrates iterating over a CopyOnWriteArrayList using an iterator.
     */
    @Test
    public void learn_Iterator() {
        // Initialize the CopyOnWriteArrayList with some elements
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");
        System.out.println("Initial list: " + list);

        // Create an iterator
        Iterator<String> itr = list.iterator();

        // Iterate over the list using the iterator
        System.out.println("Iterating over the list:");
        while (itr.hasNext()) {
            String fruit = itr.next();
            System.out.println("Fruit: " + fruit);

            // Attempt to remove an element (will throw UnsupportedOperationException)
            // Uncommenting the next line will cause an exception
            // itr.remove();
        }

        // Demonstrate that the list remains unchanged after iteration
        System.out.println("List after iteration: " + list);

        // Modify the list after creating the iterator
        list.add("Pineapple");
        System.out.println("After adding 'Pineapple': " + list);

        // Create a new iterator to see the updated list
        Iterator<String> newItr = list.iterator();
        System.out.println("Iterating over the updated list:");
        while (newItr.hasNext()) {
            String fruit = newItr.next();
            System.out.println("Fruit: " + fruit);
        }
    }
}