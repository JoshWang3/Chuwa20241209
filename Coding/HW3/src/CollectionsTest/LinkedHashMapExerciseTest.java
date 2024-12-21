package CollectionsTest;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class LinkedHashMapExerciseTest {
    /**
     * e.g.
     * HashMap<String, Integer> map = new LinkedHashMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     * putAll(Map<? extends K, ? extends V> m)
     *
     * get(Object key)
     * getOrDefault(Object key, V defaultValue)
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
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();

        linkedHashMap.put("A", 1);
        linkedHashMap.put("B", 2);
        linkedHashMap.put("C", 3);
        assertEquals(3, linkedHashMap.size());
        assertEquals(1, linkedHashMap.get("A").intValue());

        linkedHashMap.putIfAbsent("A", 10);
        linkedHashMap.putIfAbsent("D", 4);
        assertEquals(1, linkedHashMap.get("A").intValue());
        assertEquals(4, linkedHashMap.get("D").intValue());

        Map<String, Integer> newMap = new HashMap<>();
        newMap.put("E", 5);
        newMap.put("F", 6);
        linkedHashMap.putAll(newMap);
        assertEquals(6, linkedHashMap.size());
        assertEquals(5, linkedHashMap.get("E").intValue());

        assertEquals(2, linkedHashMap.get("B").intValue());
        assertNull(linkedHashMap.get("Z"));

        assertEquals(3, linkedHashMap.getOrDefault("C", -1).intValue());
        assertEquals(-1, linkedHashMap.getOrDefault("Z", -1).intValue());

        assertTrue(linkedHashMap.containsKey("A"));
        assertFalse(linkedHashMap.containsKey("Z"));

        assertTrue(linkedHashMap.containsValue(4));
        assertFalse(linkedHashMap.containsValue(10));

        Set<String> keys = linkedHashMap.keySet();
        assertEquals(6, keys.size());
        assertTrue(keys.contains("A"));
        assertFalse(keys.contains("Z"));

        Collection<Integer> values = linkedHashMap.values();
        assertEquals(6, values.size());
        assertTrue(values.contains(5));
        assertFalse(values.contains(10));

        assertFalse(linkedHashMap.isEmpty());
        linkedHashMap.clear();
        assertTrue(linkedHashMap.isEmpty());
    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     * replaceAll(BiFunction<? super K, ? super V, ? extends V> function)
     *
     * remove(Object key)
     * remove(Object key, Object value)
     *
     * compute(Key, BiFunction)
     * computeIfAbsent(Key, Function)
     * computeIfPresent(Key, BiFunction)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("A", 1);
        linkedHashMap.put("B", 2);
        linkedHashMap.put("C", 3);

        assertTrue(linkedHashMap.replace("A", 1, 10));
        assertEquals(10, linkedHashMap.get("A").intValue());
        assertFalse(linkedHashMap.replace("B", 3, 20));
        assertEquals(2, linkedHashMap.get("B").intValue());

        linkedHashMap.replace("C", 30);
        assertEquals(30, linkedHashMap.get("C").intValue());


        linkedHashMap.replaceAll((key, value) -> value * 2);
        assertEquals(20, linkedHashMap.get("A").intValue());
        assertEquals(4, linkedHashMap.get("B").intValue());
        assertEquals(60, linkedHashMap.get("C").intValue());


        linkedHashMap.remove("B");
        assertFalse(linkedHashMap.containsKey("B"));
        assertEquals(2, linkedHashMap.size());


        assertTrue(linkedHashMap.remove("C", 60));
        assertFalse(linkedHashMap.remove("A", 50));
        assertEquals(1, linkedHashMap.size());


        linkedHashMap.compute("A", (key, value) -> value + 5);
        assertEquals(25, linkedHashMap.get("A").intValue());
        linkedHashMap.compute("D", (key, value) -> 10);
        assertEquals(10, linkedHashMap.get("D").intValue());


        linkedHashMap.computeIfAbsent("E", key -> 50);
        assertEquals(50, linkedHashMap.get("E").intValue());
        linkedHashMap.computeIfAbsent("A", key -> 100);
        assertEquals(25, linkedHashMap.get("A").intValue());


        linkedHashMap.computeIfPresent("A", (key, value) -> value * 2);
        assertEquals(50, linkedHashMap.get("A").intValue());
        linkedHashMap.computeIfPresent("F", (key, value) -> 100);
        assertFalse(linkedHashMap.containsKey("F"));
    }
}
