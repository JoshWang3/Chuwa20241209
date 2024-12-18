package HW3.Collection;

import org.junit.Test;

import java.util.*;

public class CollectionsExerciseTest {

    /**
     * Collections.min(list))
     * min(Collection c, Comparator comp)
     *
     * Collections.max(list)
     * max(Collection c, Comparator comp)
     *
     * frequency(Collection c, object o)
     */

    @Test
    public void learn_common_collections_operations() {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 5, 6, 7, 8, 5);


        System.out.println("Min value: " + Collections.min(list));


        System.out.println("Max value: " + Collections.max(list));


        System.out.println("Frequency of 5: " + Collections.frequency(list, 5));

        Comparator<Integer> comparator = (a, b) -> a - b;
        System.out.println("Min with comparator: " + Collections.min(list, comparator));
        System.out.println("Max with comparator: " + Collections.max(list, comparator));
    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        List<Integer> synchronizedList = Collections.synchronizedList(new ArrayList<>());

        synchronizedList.add(10);
        synchronizedList.add(20);
        synchronizedList.add(30);

        System.out.println("Synchronized List: " + synchronizedList);

        synchronized (synchronizedList) {
            Iterator<Integer> iterator = synchronizedList.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }
    }
}