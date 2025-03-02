package CollectionsTest;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.*;

/**
 * @author b1go
 * @date 6/12/22 4:47 PM
 */
public class TreeMapExerciseTest {

    /**
     * e.g.
     * TreeMap<String, Integer> map = new TreeMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     * putAll(Map<? extends K, ? extends V> m)
     *
     * get(Object key)
     * firstKey()
     * lastKey()
     *
     * containsKey(Object key)
     * containsValue(Object value)
     *
     * keySet()
     * values()
     * isEmpty()
     */

    @Test
    public void learn_Inserting_And_Retrieving() {
        TreeMap<String, Integer> map = new TreeMap<>();

        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Cherry", 30);
        assertEquals(3, map.size());
        assertEquals((Integer) 10, map.get("Apple"));
        assertEquals((Integer) 20, map.get("Banana"));


        map.putIfAbsent("Apple", 50);
        map.putIfAbsent("Date", 40);
        assertEquals((Integer) 10, map.get("Apple"));
        assertEquals((Integer) 40, map.get("Date"));


        Map<String, Integer> additionalMap = Map.of("Elderberry", 60, "Fig", 70);
        map.putAll(additionalMap);
        assertEquals((Integer) 60, map.get("Elderberry"));
        assertEquals((Integer) 70, map.get("Fig"));

        assertEquals("Apple", map.firstKey());
        assertEquals("Fig", map.lastKey());


        assertTrue(map.containsKey("Banana"));
        assertFalse(map.containsKey("Grape"));


        assertTrue(map.containsValue(40));
        assertFalse(map.containsValue(100));

        assertEquals(6, map.keySet().size());
        assertTrue(map.keySet().contains("Elderberry"));
        assertFalse(map.keySet().contains("Grape"));

        assertEquals(6, map.values().size());
        assertTrue(map.values().contains(20));
        assertFalse(map.values().contains(100));


        assertFalse(map.isEmpty());
        map.clear();
        assertTrue(map.isEmpty());
    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     *
     * remove(Object key)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        treeMap.put("A", 1);
        treeMap.put("B", 2);
        treeMap.put("C", 3);

        boolean replaced = treeMap.replace("A", 1, 10);
        assertTrue(replaced);
        assertEquals(10, treeMap.get("A").intValue());

        replaced = treeMap.replace("B", 3, 20);
        assertFalse(replaced);
        assertEquals(2, treeMap.get("B").intValue());

        treeMap.replace("C", 30);
        assertEquals(30, treeMap.get("C").intValue());

        treeMap.replace("D", 40);
        assertNull(treeMap.get("D"));

        treeMap.remove("A");
        assertFalse(treeMap.containsKey("A"));

        boolean removed = treeMap.remove("B", 2);
        assertTrue(removed);
        assertFalse(treeMap.containsKey("B"));

        removed = treeMap.remove("C", 50);
        assertFalse(removed);
        assertEquals(30, treeMap.get("C").intValue());
    }
}
