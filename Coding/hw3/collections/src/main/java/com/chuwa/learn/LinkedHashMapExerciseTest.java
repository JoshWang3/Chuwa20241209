package com.chuwa.learn;

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
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        // put(K key, V value) - Add elements
        map.put("Java", 1);
        map.put("Python", 2);
        map.put("C++", 3);

        assertEquals(3, map.size());
        assertEquals(2, (int) map.get("Python"));

        // putIfAbsent(K key, V value) - Add only if absent
        map.putIfAbsent("Java", 10); // Key already exists
        map.putIfAbsent("JavaScript", 4);

        assertEquals(4, map.size());
        assertEquals(1, (int) map.get("Java"));
        assertEquals(4, (int) map.get("JavaScript"));

        // putAll(Map<? extends K, ? extends V> m) - Merge another map
        Map<String, Integer> otherMap = new HashMap<>();
        otherMap.put("Ruby", 5);
        otherMap.put("Go", 6);
        map.putAll(otherMap);

        assertEquals(6, map.size());
        assertTrue(map.containsKey("Ruby"));
        assertTrue(map.containsValue(6));

        // getOrDefault(Object key, V defaultValue)
        assertEquals(3, (int) map.getOrDefault("C++", 0));
        assertEquals(0, (int) map.getOrDefault("Kotlin", 0));

        // containsKey() and containsValue()
        assertTrue(map.containsKey("Go"));
        assertTrue(map.containsValue(5));
        assertFalse(map.containsKey("Scala"));

        // keySet() and values()
        Set<String> keys = map.keySet();
        Collection<Integer> values = map.values();

        assertTrue(keys.contains("Java"));
        assertTrue(values.contains(2));

        // isEmpty()
        assertFalse(map.isEmpty());

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
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("Java", 1);
        map.put("Python", 2);
        map.put("C++", 3);

        // replace(K key, V value) - Replace value for a key
        map.replace("Java", 10);
        assertEquals(10, (int) map.get("Java"));

        // replace(K key, V oldValue, V newValue) - Replace if old value matches
        boolean replaced = map.replace("Python", 2, 20);
        assertTrue(replaced);
        assertEquals(20, (int) map.get("Python"));

        replaced = map.replace("C++", 5, 30); // Won't replace, old value doesn't match
        assertFalse(replaced);
        assertEquals(3, (int) map.get("C++"));

        // replaceAll(BiFunction) - Update all values
        map.replaceAll((key, value) -> value * 2);
        assertEquals(20, (int) map.get("Java"));
        assertEquals(40, (int) map.get("Python"));

        // remove(Object key) - Remove by key
        map.remove("C++");
        assertFalse(map.containsKey("C++"));

        // remove(Object key, Object value) - Remove if value matches
        map.put("Go", 5);
        boolean removed = map.remove("Go", 10); // Won't remove, value doesn't match
        assertFalse(removed);

        removed = map.remove("Go", 5);
        assertTrue(removed);
        assertFalse(map.containsKey("Go"));

        // compute(Key, BiFunction) - Compute a new value for the key
        map.compute("Java", (key, value) -> value + 10);
        assertEquals(30, (int) map.get("Java"));

        // computeIfAbsent(Key, Function) - Compute and add if key is absent
        map.computeIfAbsent("Ruby", key -> 50);
        assertEquals(50, (int) map.get("Ruby"));

        // computeIfPresent(Key, BiFunction) - Compute and update if key is present
        map.computeIfPresent("Python", (key, value) -> value / 2);
        assertEquals(20, (int) map.get("Python"));

    }
}
