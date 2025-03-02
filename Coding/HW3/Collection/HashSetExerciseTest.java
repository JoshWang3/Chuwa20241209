package HW3.Collection;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class HashSetExerciseTest {
    /**
     * e.g.
     * Set<Integer> set= new HashSet<>();
     *
     * add(E e)
     * addAll(Collection<> c)
     *
     * get()
     * contains()
     *
     * remove(Object o)
     * clear()
     *
     * isEmpty()
     *
     *
     */

    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        Set<Integer> set = new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(6);

        System.out.println("Set: " + set);
        System.out.println("Contains 3: " + set.contains(3));
        System.out.println("Contains 7: " + set.contains(7));

        set.remove(3);
        System.out.println("After remove 3: " + set);

        set.clear();
        System.out.println("After clear: " + set);
        System.out.println("Is set empty: " + set.isEmpty());
    }
}