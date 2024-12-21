package CollectionsTest;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.junit.Assert.*;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
public class CopyOnWriteArrayListExerciseTest {

    /**
     * e.g.
     * List list = new CopyOnWriteArrayList();
     *
     * add(E e)
     * add(int index, E element)
     * addAll(Collection c)
     * addIfAbsent(E e)
     * addAllAbsent(Collection c)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>(Arrays.asList("Apple", "Banana"));

        list.add("Cherry");
        assertEquals(Arrays.asList("Apple", "Banana", "Cherry"), list);

        list.add(1, "Date");
        assertEquals(Arrays.asList("Apple", "Date", "Banana", "Cherry"), list);

        List<String> additionalItems = Arrays.asList("Elderberry", "Fig");
        list.addAll(additionalItems);
        assertEquals(Arrays.asList("Apple", "Date", "Banana", "Cherry", "Elderberry", "Fig"), list);

        list.addIfAbsent("Grape");
        assertEquals(Arrays.asList("Apple", "Date", "Banana", "Cherry", "Elderberry", "Fig", "Grape"), list);

        list.addIfAbsent("Banana");
        assertEquals(Arrays.asList("Apple", "Date", "Banana", "Cherry", "Elderberry", "Fig", "Grape"), list);

        List<String> moreItems = Arrays.asList("Honeydew", "Apple", "Jackfruit");
        list.addAllAbsent(moreItems);
        assertEquals(Arrays.asList("Apple", "Date", "Banana", "Cherry", "Elderberry", "Fig", "Grape", "Honeydew", "Jackfruit"), list);
    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     */

    @Test
    public void learn_Iterator() {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        Iterator<String> iterator = list.iterator();

        assertTrue(iterator.hasNext());
        assertEquals("Apple", iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals("Banana", iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals("Cherry", iterator.next());

        assertFalse(iterator.hasNext());

//CopyOnWriteArrayList uses a snapshot iterator,
// which iterates over a copy of the list at the time the iterator was created.
// Any structural modification to the list during iteration is not allowed
// and will throw an UnsupportedOperationException.
        try {
            iterator.remove();
            fail("Expected UnsupportedOperationException");
        } catch (UnsupportedOperationException e) {
            assertTrue(true);
        }
    }
}
