package collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
        for (int i = 0; i < 10; i++) set.add(i);
        set.addAll(List.of(1,2,10,11,12));

        Assert.assertTrue(set.contains(1));
        Integer except = 0;
        Assert.assertEquals(except, set.first());
        except = 12;
        Assert.assertEquals(except, set.last());
        except = 13;
        Assert.assertEquals(except.intValue(), set.size());

        Set<Integer> newSet1 = set.subSet(1, 5);
        Assert.assertEquals(new TreeSet<>(List.of(1, 2, 3, 4)), newSet1);

        Set<Integer> newSet2 = set.headSet(2);
        Assert.assertEquals(new TreeSet<>(List.of(0, 1)), newSet2);

        Set<Integer> newSet3 = set.tailSet(11);
        Assert.assertEquals(new TreeSet<>(List.of(11, 12)), newSet3);

        set.remove(1);
        Assert.assertFalse(set.contains(1));

        set.clear();
        Assert.assertTrue(set.isEmpty());
    }
}
