package Collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ArrayListExerciseTest {
    /**
     * Demonstrates:
     * - new ArrayList()
     * - add elements
     * - get element
     * - get Size
     * - list.addAll(anotherList)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        List<String> list = new ArrayList<>();

        // Adding elements
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        // Retrieving elements
        System.out.println("First element: " + list.get(0));

        // Getting size
        System.out.println("List size: " + list.size());

        // Adding all elements from another list
        List<String> anotherList = new ArrayList<>();
        anotherList.add("Grapes");
        anotherList.add("Pineapple");

        list.addAll(anotherList);

        // Printing final list
        System.out.println("Final list: " + list);
    }

    /**
     * Demonstrates:
     * - remove(int index)
     * - remove(Object o)
     * - removeRange(int fromIndex, int toIndex) - requires subclassing
     * - removeAll(Collection<?> c)
     * - clear()
     * - set(int index, E e)
     * - replaceAll(UnaryOperator<E> operator)
     * - contains(Object o), indexOf(Object o), lastIndexOf(Object o)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");
        list.add("Apple");

        // Removing by index
        list.remove(1); // Removes "Banana"
        System.out.println("After removing index 1: " + list);

        // Removing by object
        list.remove("Orange");
        System.out.println("After removing 'Orange': " + list);

        // Updating an element
        list.set(0, "Grapes");
        System.out.println("After updating index 0: " + list);

        // Replacing all elements
        list.replaceAll(s -> s.toUpperCase());
        System.out.println("After replacing all elements: " + list);

        // Checking contains, indexOf, and lastIndexOf
        System.out.println("Contains 'GRAPES': " + list.contains("GRAPES"));
        System.out.println("Index of 'GRAPES': " + list.indexOf("GRAPES"));
        System.out.println("Last Index of 'APPLE': " + list.lastIndexOf("APPLE"));

        // Clearing the list
        list.clear();
        System.out.println("After clearing: " + list);
    }

    /**
     * Demonstrates:
     * - iterator()
     * - hasNext()
     * - next()
     * - remove()
     * - forEachRemaining(Consumer<? super E> action)
     */
    @Test
    public void learn_Iterator() {
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        Iterator<String> iterator = list.iterator();

        System.out.println("Iterating through list using iterator:");
        while (iterator.hasNext()) {
            String fruit = iterator.next();
            System.out.println(fruit);

            // Removing "Banana"
            if ("Banana".equals(fruit)) {
                iterator.remove();
            }
        }

        System.out.println("After iterator removal: " + list);

        // Using forEachRemaining (Java 8)
        System.out.println("Using forEachRemaining:");
        list.iterator().forEachRemaining(System.out::println);
    }

    /**
     * Demonstrates:
     * - sort(List<T> list)
     * - Collections.sort(List<T> t)
     * - Comparator.reverseOrder()
     */
    @Test
    public void learn_Sorting() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(1);
        numbers.add(3);
        numbers.add(8);

        // Natural order sorting
        Collections.sort(numbers);
        System.out.println("Sorted in natural order: " + numbers);

        // Reverse order sorting
        Collections.sort(numbers, Comparator.reverseOrder());
        System.out.println("Sorted in reverse order: " + numbers);

        // Using sort() with a lambda expression
        numbers.sort((a, b) -> a - b); // Ascending order
        System.out.println("Sorted using lambda (ascending): " + numbers);

        numbers.sort((a, b) -> b - a); // Descending order
        System.out.println("Sorted using lambda (descending): " + numbers);
    }
}