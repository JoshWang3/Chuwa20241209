package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Demonstrates basic LinkedList operations: inserting, retrieving, removing, and sorting elements.
 */
public class LinkedListExerciseTest {

    /**
     * Demonstrates inserting elements into a LinkedList and retrieving them.
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        // Create a new LinkedList
        List<Integer> list = new LinkedList<>();

        // Add elements using add(E e) and addLast(E e)
        list.add(10);
        list.add(20);
        ((LinkedList<Integer>) list).addLast(30);
        System.out.println("After adding elements: " + list);

        // Add element at the beginning using addFirst(E e)
        ((LinkedList<Integer>) list).addFirst(5);
        System.out.println("After addFirst(5): " + list);

        // Add element at a specific index using add(int index, E element)
        list.add(2, 15);
        System.out.println("After adding 15 at index 2: " + list);

        // Add all elements from another collection using addAll(Collection c)
        List<Integer> additionalList = Arrays.asList(40, 50);
        list.addAll(additionalList);
        System.out.println("After addAll: " + list);

        // Add all elements from another collection at a specific index using addAll(int index, Collection c)
        List<Integer> moreElements = Arrays.asList(25, 35);
        list.addAll(3, moreElements);
        System.out.println("After addAll at index 3: " + list);

        // Retrieve first and last elements
        Integer first = ((LinkedList<Integer>) list).getFirst();
        Integer last = ((LinkedList<Integer>) list).getLast();
        System.out.println("First element: " + first);
        System.out.println("Last element: " + last);

        // Retrieve element by index
        Integer elementAt4 = list.get(4);
        System.out.println("Element at index 4: " + elementAt4);
    }

    /**
     * Demonstrates removing elements and sorting the LinkedList.
     */
    @Test
    public void learn_Remove_Sort() {
        // Initialize the LinkedList with some elements
        List<Integer> list = new LinkedList<>(Arrays.asList(10, 20, 30, 40, 50, 20, 30));
        System.out.println("Original list: " + list);

        // Remove first and last elements using removeFirst() and removeLast()
        ((LinkedList<Integer>) list).removeFirst(); // Removes 10
        ((LinkedList<Integer>) list).removeLast();  // Removes 30
        System.out.println("After removeFirst() and removeLast(): " + list);

        // Remove element by index
        list.remove(2); // Removes 30
        System.out.println("After removing element at index 2: " + list);

        // Remove element by object
        list.remove(Integer.valueOf(20)); // Removes first occurrence of 20
        System.out.println("After removing first occurrence of 20: " + list);

        // Remove last occurrence of an element
        ((LinkedList<Integer>) list).removeLastOccurrence(30);
        System.out.println("After removing last occurrence of 30: " + list);

        // Sort the LinkedList in natural order
        Collections.sort(list);
        System.out.println("After sorting (natural order): " + list);

        // Sort the LinkedList in reverse order using Comparator.reverseOrder()
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("After sorting (reverse order): " + list);
    }
}
