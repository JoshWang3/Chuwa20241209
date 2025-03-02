package HW3.Collection;

import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

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
        Set<Integer> set = new TreeSet<>();

        set.add(5);
        set.add(3);
        set.add(8);
        set.add(1);
        set.add(4);

        System.out.println("TreeSet: " + set);

        System.out.println("Contains 3: " + set.contains(3));
        System.out.println("First element: " + ((TreeSet<Integer>) set).first());
        System.out.println("Last element: " + ((TreeSet<Integer>) set).last());

        Set<Integer> subSet = ((TreeSet<Integer>) set).subSet(3, 8);
        System.out.println("SubSet from 3 to 8: " + subSet);

        Set<Integer> headSet = ((TreeSet<Integer>) set).headSet(8);
        System.out.println("HeadSet to 8: " + headSet);

        Set<Integer> tailSet = ((TreeSet<Integer>) set).tailSet(3);
        System.out.println("TailSet from 3: " + tailSet);

        set.remove(3);
        System.out.println("TreeSet after removing 3: " + set);

        System.out.println("Size of TreeSet: " + set.size());
        System.out.println("Is TreeSet empty: " + set.isEmpty());
    }
}