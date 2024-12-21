package CollectionsTest;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
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

        assertTrue(set.add(1));
        assertTrue(set.add(2));
        assertTrue(set.add(3));

        Set<Integer> anotherSet = new HashSet<>();
        anotherSet.add(4);
        anotherSet.add(5);
        assertTrue(set.addAll(anotherSet));

        assertEquals(5, set.size());
        assertTrue(set.contains(1));
        assertTrue(set.contains(2));
        assertTrue(set.contains(5));

        assertTrue(set.remove(2));
        assertFalse(set.remove(6));
        assertEquals(4, set.size());

        set.clear();
        assertEquals(0, set.size());
        assertTrue(set.isEmpty());
    }
}
