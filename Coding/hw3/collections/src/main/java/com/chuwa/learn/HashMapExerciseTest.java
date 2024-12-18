package com.chuwa.learn;

import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @author b1go
 * @date 6/12/22 4:47 PM
 */
public class HashMapExerciseTest {

    /**
     * e.g.
     * Map<String, Integer> map = new HashMap<>();
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
        Map<String, Integer> map = new HashMap<>();

        // put() - Add key-value pairs
        map.put("Java", 1);
        map.put("Python", 2);
        map.put("C++", 3);

        assertEquals(3, map.size());
        assertEquals(2, (int) map.get("Python"));

        // putIfAbsent() - Only add if key is absent
        map.putIfAbsent("Java", 10); // Key already exists, value won't change
        map.putIfAbsent("JavaScript", 4);

        assertEquals(4, map.size());
        assertEquals(1, (int) map.get("Java"));
        assertEquals(4, (int) map.get("JavaScript"));

        // putAll() - Merge another map
        Map<String, Integer> anotherMap = new HashMap<>();
        anotherMap.put("Ruby", 5);
        anotherMap.put("Go", 6);
        map.putAll(anotherMap);

        assertEquals(6, map.size());
        assertTrue(map.containsKey("Ruby"));
        assertTrue(map.containsValue(6));

        // getOrDefault() - Get value or default if key doesn't exist
        assertEquals(3, (int) map.getOrDefault("C++", 0));
        assertEquals(0, (int) map.getOrDefault("Scala", 0));

        // keySet() and values()
        Set<String> keys = map.keySet();
        Collection<Integer> values = map.values();

        assertTrue(keys.contains("Go"));
        assertTrue(values.contains(5));

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
        Map<String, Integer> map = new HashMap<>();
        map.put("Java", 1);
        map.put("Python", 2);
        map.put("C++", 3);

        // replace(K key, V value)
        map.replace("Java", 10);
        assertEquals(10, (int) map.get("Java"));

        // replace(K key, V oldValue, V newValue)
        boolean replaced = map.replace("Python", 2, 20);
        assertTrue(replaced);
        assertEquals(20, (int) map.get("Python"));

        replaced = map.replace("C++", 5, 30); // Won't replace as oldValue doesn't match
        assertFalse(replaced);
        assertEquals(3, (int) map.get("C++"));

        // replaceAll(BiFunction)
        map.replaceAll((key, value) -> value * 2);
        assertEquals(20, (int) map.get("Java"));
        assertEquals(40, (int) map.get("Python"));

        // remove(Object key)
        map.remove("C++");
        assertFalse(map.containsKey("C++"));

        // remove(Object key, Object value)
        map.put("Go", 5);
        boolean removed = map.remove("Go", 10); // Won't remove as value doesn't match
        assertFalse(removed);

        removed = map.remove("Go", 5);
        assertTrue(removed);
        assertFalse(map.containsKey("Go"));

        // compute(Key, BiFunction)
        map.compute("Java", (key, value) -> value + 10);
        assertEquals(30, (int) map.get("Java"));

        // computeIfAbsent(Key, Function)
        map.computeIfAbsent("Ruby", key -> 50);
        assertEquals(50, (int) map.get("Ruby"));

        // computeIfPresent(Key, BiFunction)
        map.computeIfPresent("Python", (key, value) -> value / 2);
        assertEquals(20, (int) map.get("Python"));

    }
}
