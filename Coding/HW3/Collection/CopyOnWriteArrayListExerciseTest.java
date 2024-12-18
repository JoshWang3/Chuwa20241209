package Collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExerciseTest {
    /**
     * Demonstrates:
     * - CopyOnWriteArrayList add operations:
     *   add(E e), add(int index, E element), addAll(Collection c)
     *   addIfAbsent(E e), addAllAbsent(Collection c)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        // Creating a CopyOnWriteArrayList
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        // Adding elements
        list.add("Apple");
        list.add("Banana");

        // Adding an element at a specific index
        list.add(1, "Grapes");

        // Adding elements from another collection
        List<String> additionalList = new ArrayList<>();
        additionalList.add("Orange");
        additionalList.add("Mango");

        list.addAll(additionalList);

        // Using addIfAbsent() - avoids duplicates
        list.addIfAbsent("Banana"); // Duplicate, will not be added
        list.addIfAbsent("Pineapple");

        // Adding multiple elements using addAllAbsent()
        List<String> anotherList = new ArrayList<>();
        anotherList.add("Grapes");
        anotherList.add("Strawberry");
        list.addAllAbsent(anotherList); // "Grapes" won't be added as it already exists

        // Printing the final list
        System.out.println("Final CopyOnWriteArrayList: " + list);
    }

    /**
     * Demonstrates:
     * - CopyOnWriteArrayList's iterator (fail-safe behavior)
     * - hasNext(), next()
     * - Iterator does not support remove()
     */
    @Test
    public void learn_Iterator() {
        // Creating a CopyOnWriteArrayList
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        // Obtaining an iterator
        Iterator<String> itr = list.iterator();

        System.out.println("Iterating over CopyOnWriteArrayList:");
        while (itr.hasNext()) {
            String fruit = itr.next();
            System.out.println(fruit);

            // Attempting to modify the list while iterating
            // This is safe in CopyOnWriteArrayList
            if ("Banana".equals(fruit)) {
                list.add("Pineapple");
            }
        }

        // Printing the list after iteration
        System.out.println("List after iteration (modification allowed during iteration): " + list);
    }
}

