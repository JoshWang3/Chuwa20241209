package collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Set<Integer> set= new HashSet<>();
        for (int i = 0; i < 10; i++) set.add(i);
        set.addAll(List.of(1,2,10,11,12));

        Assert.assertTrue(set.contains(1));

        set.remove(1);
        Assert.assertFalse(set.contains(1));

        set.clear();
        Assert.assertTrue(set.isEmpty());

    }
}
