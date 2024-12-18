package com.chuwa.learn;

import org.junit.Test;

import java.util.*;

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

        // put(K key, V value) - Add key-value pairs
        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Cherry", 30);

        assertEquals(3, map.size());
        assertEquals(20, (int) map.get("Banana"));

        // putIfAbsent(K key, V value) - Only add if key is absent
        map.putIfAbsent("Apple", 100); // Will not replace existing value
        map.putIfAbsent("Date", 40);

        assertEquals(4, map.size());
        assertEquals(10, (int) map.get("Apple"));
        assertEquals(40, (int) map.get("Date"));

        // putAll(Map<? extends K, ? extends V> m) - Add all from another map
        Map<String, Integer> anotherMap = new HashMap<>();
        anotherMap.put("Elderberry", 50);
        anotherMap.put("Fig", 60);

        map.putAll(anotherMap);
        assertEquals(6, map.size());
        assertTrue(map.containsKey("Fig"));
        assertTrue(map.containsValue(50));

        // firstKey() and lastKey() - Retrieve the first and last keys
        assertEquals("Apple", map.firstKey());
        assertEquals("Fig", map.lastKey());

        // containsKey() and containsValue()
        assertTrue(map.containsKey("Cherry"));
        assertFalse(map.containsKey("Grape"));

        assertTrue(map.containsValue(30));
        assertFalse(map.containsValue(70));

        // keySet() and values()
        Set<String> keys = map.keySet();
        Collection<Integer> values = map.values();

        assertTrue(keys.contains("Banana"));
        assertTrue(values.contains(60));

        // isEmpty()
        assertFalse(false);

    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     *
     * remove(Object key)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Cherry", 30);

        // replace(K key, V value) - Replace value for a key
        map.replace("Apple", 100);
        assertEquals(100, (int) map.get("Apple"));

        // replace(K key, V oldValue, V newValue) - Replace only if old value matches
        boolean replaced = map.replace("Banana", 20, 200);
        assertTrue(replaced);
        assertEquals(200, (int) map.get("Banana"));

        replaced = map.replace("Cherry", 50, 300); // Won't replace, old value doesn't match
        assertFalse(replaced);
        assertEquals(30, (int) map.get("Cherry"));

        // remove(Object key) - Remove a specific key
        map.remove("Banana");
        assertFalse(map.containsKey("Banana"));
        assertEquals(2, map.size());

        // Try removing a non-existent key
        map.remove("Date");
        assertEquals(2, map.size());

    }
}
