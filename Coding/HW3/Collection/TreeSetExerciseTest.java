package Collection;

import org.junit.Test;

import java.util.TreeSet;
import java.util.Arrays;
import java.util.Set;

public class TreeSetExerciseTest {

    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        TreeSet<Integer> set = new TreeSet<>();

        set.add(10);
        set.add(20);
        set.add(30);
        set.add(10);

        set.addAll(Arrays.asList(5, 15, 25, 35));

        System.out.println(set.contains(15));
        System.out.println(set.contains(50));

        System.out.println(set.first());
        System.out.println(set.last());

        Set<Integer> subSet = set.subSet(10, 30);
        System.out.println(subSet);

        Set<Integer> headSet = set.headSet(20);
        System.out.println(headSet);

        Set<Integer> tailSet = set.tailSet(20);
        System.out.println(tailSet);

        set.remove(15);
        System.out.println(set);

        System.out.println(set.size());
        System.out.println(set.isEmpty());

        System.out.println(set);
    }
}

