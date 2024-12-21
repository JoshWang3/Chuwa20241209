package CollectionsTest;

import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.*;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
public class TreeSetExerciseTest {
    /**
     * e.g.
     * Set<Integer> set= new TreeSet<>();
     *
     * add(E e)
     * addAll(Collection<> c)
     *
     * contains(Object o)
     *
     * first()
     * last()
     * subSet(E fromElement, E toElement)
     * headSet(E toElement)
     * tailSet(E fromElement)
     *
     * remove(Object o)
     *
     * size()
     * isEmpty()
     *
     *
     */

    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        TreeSet<Integer> set = new TreeSet<>();

        assertTrue(set.add(10));
        assertTrue(set.add(20));
        assertTrue(set.add(30));

        Set<Integer> anotherSet = new TreeSet<>();
        anotherSet.add(5);
        anotherSet.add(25);
        assertTrue(set.addAll(anotherSet));

        assertEquals(5, set.size());
        assertTrue(set.contains(5));
        assertTrue(set.contains(10));
        assertTrue(set.contains(20));
        assertTrue(set.contains(25));
        assertTrue(set.contains(30));

        assertTrue(set.contains(20));
        assertFalse(set.contains(15));

        assertEquals((Integer) 5, set.first());

        assertEquals((Integer) 30, set.last());

        Set<Integer> subset = set.subSet(10, 30);
        assertEquals(3, subset.size());
        assertTrue(subset.contains(10));
        assertTrue(subset.contains(20));
        assertTrue(subset.contains(25));
        assertFalse(subset.contains(5));
        assertFalse(subset.contains(30));

        Set<Integer> headSet = set.headSet(20);
        assertEquals(2, headSet.size());
        assertTrue(headSet.contains(5));
        assertTrue(headSet.contains(10));
        assertFalse(headSet.contains(20));

        Set<Integer> tailSet = set.tailSet(20);
        assertEquals(3, tailSet.size());
        assertTrue(tailSet.contains(20));
        assertTrue(tailSet.contains(25));
        assertTrue(tailSet.contains(30));
        assertFalse(tailSet.contains(10));

        assertTrue(set.remove(25));
        assertFalse(set.remove(50));
        assertEquals(4, set.size());


        assertEquals(4, set.size());

        assertFalse(set.isEmpty());
        set.clear();
        assertTrue(set.isEmpty());
    }
}

