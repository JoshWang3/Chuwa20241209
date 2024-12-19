package collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @author b1go
 * @date 6/12/22 4:43 PM
 */
public class ArrayListExerciseTest {
    /**
     * new ArrayList()
     * add elements
     * get element
     * get Size
     * list.addAll(anotherList)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        for (int i = 0; i < list.size(); i++) {
            Integer expected = i;
            Assert.assertEquals(expected, list.get(i));
        }

        Assert.assertEquals(10, list.size());

        list.addAll(Arrays.asList(new Integer[]{10, 11, 12, 13}));
        for (int i = 0; i < list.size(); i++) {
            Integer expected = i;
            Assert.assertEquals(expected, list.get(i));
        }
    }

    /**
     * remove(int index)
     * remove(Object o)
     * removeRange(int fromIndex, int toIndex)
     * removeAll(Collection<?> c)
     * clear()
     *
     * Update:
     * set(int index, E e)
     * replaceAll(UnaryOperator<E> operator)
     *
     * check:
     * contains(Object o)
     * indexOf(Object o)
     * lastIndexOf(Object o)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        // Remove
        list.remove(0);
        list.remove(0);
        Assert.assertArrayEquals(new int[]{2, 3, 4, 5, 6, 7, 8, 9}, list.stream().mapToInt(Integer::intValue).toArray());

        list.removeAll(Arrays.asList(new Integer[]{2, 3, 4}));
        Assert.assertArrayEquals(new int[]{5, 6, 7, 8, 9}, list.stream().mapToInt(Integer::intValue).toArray());

        list.clear();
        Assert.assertEquals(0, list.size());

        // Update
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        for (int i = 0; i < 10; i++) {
            list.set(i, list.get(i) + 10);
        }
        for (int i = 0; i < 10; i++) {
            Integer expected = i + 10;
            Assert.assertEquals(expected, list.get(i));
        }

        list.replaceAll( n -> n + 1);
        for (int i = 0; i < 10; i++) {
            Integer expected = i + 10 + 1;
            Assert.assertEquals(expected, list.get(i));
        }

        // check
        Assert.assertTrue(list.contains(12));
        Assert.assertEquals(1, list.indexOf(12));
        Assert.assertEquals(1, list.lastIndexOf(12));
    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     * forEachRemaining(Consumer<? super E> action) -- from Java8
     */

    @Test
    public void learn_Iterator() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        Iterator<Integer> iterator = list.iterator();
        Integer i = 0;
        while (iterator.hasNext()) {
            Integer cur = iterator.next();
            Assert.assertEquals(i, cur);
            if (cur == 5) {
                iterator.remove();
            }
            i++;
        }

        Assert.assertArrayEquals(new int[]{0, 1, 2, 3, 4, 6, 7, 8, 9}, list.stream().mapToInt(Integer::intValue).toArray());

        Iterator<Integer> iterator2 = list.iterator();
        iterator2.forEachRemaining(it -> System.out.print(it + ", "));
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        List<Integer> list = new ArrayList<>(List.of(4, 3, 5, 7, 8, 1, 2, 0, 6, 9));
        Collections.sort(list);

        Assert.assertEquals(new ArrayList<>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)), list);

        list.sort((a, b) -> {
            return b - a;
        });
        Assert.assertEquals(new ArrayList<>(List.of(9, 8, 7, 6, 5, 4, 3, 2, 1, 0)), list);

        list.set(0, 0);
        list.set(9, 9);
        Collections.sort(list, (a, b) -> {return b - a;});
        Assert.assertEquals(new ArrayList<>(List.of(9, 8, 7, 6, 5, 4, 3, 2, 1, 0)), list);
    }
}
