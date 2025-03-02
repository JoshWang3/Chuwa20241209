package CollectionsTest;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

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
        List<String> list = new ArrayList<>();
        assertTrue(list.isEmpty());

        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        assertEquals(3, list.size());

        String firstElement = list.get(0);
        assertEquals("Apple", firstElement);

        List<String> anotherList = new ArrayList<>();
        anotherList.add("Date");
        anotherList.add("Evan");

        list.addAll(anotherList);
        assertEquals(5, list.size());
        assertTrue(list.containsAll(anotherList));

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
        List<String> list = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry", "Date", "Elderberry"));

        list.remove(1);
        assertEquals(4, list.size());
        assertFalse(list.contains("Banana"));

        boolean removed = list.remove("Cherry");
        assertTrue(removed);
        assertEquals(3, list.size());

        list.subList(1, 3).clear();
        assertEquals(1, list.size());
        assertEquals("Apple", list.get(0));

        List<String> toRemove = Arrays.asList("Apple", "Nonexistent");
        list.removeAll(toRemove);
        assertTrue(list.isEmpty());

        list.addAll(Arrays.asList("Apple", "Banana"));
        list.clear();
        assertTrue(list.isEmpty());

        List<String> list2 = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry"));

        list2.set(1, "Blueberry");
        assertEquals("Blueberry", list2.get(1));

        list2.replaceAll(String::toUpperCase);
        assertEquals(Arrays.asList("APPLE", "BLUEBERRY", "CHERRY"), list2);

        List<String> list3 = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry", "Banana"));

        assertTrue(list3.contains("Banana"));
        assertFalse(list3.contains("Date"));

        assertEquals(1, list3.indexOf("Banana"));

        assertEquals(3, list3.lastIndexOf("Banana"));
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
        List<String> list = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry", "Date"));

        Iterator<String> iterator = list.iterator();
        assertNotNull(iterator);

        assertTrue(iterator.hasNext());
        assertEquals("Apple", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("Banana", iterator.next());

        iterator.remove(); // removes the element that was most recently
        assertEquals(Arrays.asList("Apple", "Cherry", "Date"), list);


        assertTrue(iterator.hasNext());
        assertEquals("Cherry", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("Date", iterator.next());

        assertFalse(iterator.hasNext());

        List<String> list2 = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry", "Date"));

        Iterator<String> iterator2 = list2.iterator();

        iterator2.next(); // "Apple"

        List<String> processed = new ArrayList<>();
        iterator2.forEachRemaining(processed::add);

        assertEquals(Arrays.asList("Banana", "Cherry", "Date"), processed);
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5, 9, 2));
        list.sort(Comparator.naturalOrder());

        List<Integer> expected = Arrays.asList(1, 1, 2, 3, 4, 5, 9);
        assertEquals(expected, list);

        List<Integer> list2 = new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5, 9, 2));
        Collections.sort(list2);

        List<Integer> expected2 = Arrays.asList(1, 1, 2, 3, 4, 5, 9);
        assertEquals(expected2, list2);

        List<String> list3 = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry", "Date"));
        Collections.sort(list3, Comparator.reverseOrder());

        List<String> expected3 = Arrays.asList("Date", "Cherry", "Banana", "Apple");
        assertEquals(expected3, list3);
    }
}
