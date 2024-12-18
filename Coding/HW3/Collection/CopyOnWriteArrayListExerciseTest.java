package HW3.Collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

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
        List<String> list = new CopyOnWriteArrayList<>();


        list.add("Apple");
        list.add("Banana");
        list.add("Orange");


        list.add(1, "Grapes");


        List<String> additionalFruits = Arrays.asList("Mango", "Pineapple");
        list.addAll(additionalFruits);


        System.out.println("List after additions: " + list);

        System.out.println("Element at index 2: " + list.get(2));
        System.out.println("Size of list: " + list.size());
    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     */

    @Test
    public void learn_Iterator() {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        Iterator<String> itr = list.iterator();

        System.out.println("Iterating through the list:");
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        itr = list.iterator();
        while (itr.hasNext()) {
            String fruit = itr.next();
            if ("Banana".equals(fruit)) {
                list.remove(fruit);
                break;
            }
        }

        System.out.println("List after removal: " + list);
    }
}