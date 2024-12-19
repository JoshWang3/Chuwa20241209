package collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author b1go
 * @date 6/12/22 4:45 PM
 */
public class LinkedListExerciseTest {

    /**
     * e.g.
     * List<Integer> list = new LinkedList<Integer>();
     * Inserting:
     * add(E e) or addLast(E e)
     * addFirst(E e)
     * add(int index, E element)
     * addAll(Collection c)
     * addAll(int index, Collection c)
     *
     * Retrieving:
     * getFirst()
     * getLast()
     * get(int index)
     *
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.addLast(12);
        list.add(1, 2);
        list.addAll(2, List.of(3, 4, 5, 6, 7, 8, 9, 10, 11));
        list.addAll(List.of(13, 14, 15));

        Assert.assertEquals(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15), list);

        Integer except = 1;
        Assert.assertEquals(except, list.getFirst());
        except = 15;
        Assert.assertEquals(except, list.getLast());
        except = 2;
        Assert.assertEquals(except, list.get(1));
    }

    /**
     * removeFirst()
     * removeLast()
     * remove(int index)
     * remove(Object o)
     * removeLastOccurrence()
     *
     * sort()
     */

    @Test
    public void learn_Remove_Sort() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.addLast(12);
        list.add(1, 2);
        list.addAll(2, List.of(3, 4, 5, 6, 7, 8, 9, 10, 11));
        list.addAll(List.of(13, 14, 15));

        Assert.assertEquals(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15), list);

        list.sort((a, b) -> {return b - a;});

        Integer except = 15;
        Assert.assertEquals(except, list.removeFirst());
        except = 1;
        Assert.assertEquals(except, list.removeLast());
        except = 14;
        Assert.assertEquals(except, list.remove(0));

        Assert.assertTrue(list.removeLastOccurrence(3));
    }
}
