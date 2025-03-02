package HW3.Collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExerciseTest {

    /**
     * e.g.
     * List<Integer> list = new LinkedList<Integer>();
     * Inserting:
     * add(E e) or addLast(E e)
     * addFirst(E e)
     * add(int index, E element)
     * addAll(Collection c)
     * addAll(int index, Collection c)
     *
     * Retrieving:
     * getFirst()
     * getLast()
     * get(int index)
     *
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        List<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2, 4);
        list.addAll(Arrays.asList(5, 6, 7));

        System.out.println("LinkedList after adding elements: " + list);

        System.out.println("Element at index 2: " + list.get(2));

        System.out.println("Size of LinkedList: " + list.size());
    }


    /**
     * removeFirst()
     * removeLast()
     * remove(int index)
     * remove(Object o)
     * removeLastOccurrence()
     *
     * sort()
     */

    @Test
    public void learn_Remove_Sort() {
        List<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println("LinkedList before removal: " + list);


        list.remove(1);
        list.remove((Integer) 4);

        System.out.println("LinkedList after removals: " + list);

        Collections.sort(list);
        System.out.println("LinkedList after sorting: " + list);
    }
}