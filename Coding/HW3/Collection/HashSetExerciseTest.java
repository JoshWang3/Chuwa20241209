package Collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class HashSetExerciseTest {

    /**
     * Demonstrates:
     * - add(E e)
     * - addAll(Collection<? extends E> c)
     * - contains(Object o)
     * - remove(Object o)
     * - clear()
     * - isEmpty()
     */
    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        Set<Integer> set = new HashSet<>();

        set.add(10);
        set.add(20);
        set.add(30);
        set.add(10);

        System.out.println("HashSet after add operations: " + set);

        Collection<Integer> additionalElements = Arrays.asList(40, 50, 60, 20);
        set.addAll(additionalElements);
        System.out.println("HashSet after addAll operations: " + set);

        System.out.println("Does set contain 30? " + set.contains(30));
        System.out.println("Does set contain 100? " + set.contains(100));

        set.remove(20);
        System.out.println("HashSet after removing 20: " + set);

        set.clear();
        System.out.println("HashSet after clear operation: " + set);

        System.out.println("Is HashSet empty? " + set.isEmpty());
    }
}

