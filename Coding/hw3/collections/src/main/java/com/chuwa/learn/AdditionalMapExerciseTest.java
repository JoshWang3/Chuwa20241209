package com.chuwa.learn;

import org.junit.Test;

import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.assertEquals;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class AdditionalMapExerciseTest {

    /**
     * e.g.
     * ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     * putAll(Map<? extends K, ? extends V> m)
     */
    @Test
    public void learn_ConcurrentHashMap() {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // put() method
        map.put("Java", 1);
        map.put("Python", 2);

        assertEquals(1, (int) map.get("Java"));
        assertEquals(2, (int) map.get("Python"));

        // putIfAbsent() method
        map.putIfAbsent("Java", 10); // Will not replace existing value
        map.putIfAbsent("C++", 3);

        assertEquals(1, (int) map.get("Java"));
        assertEquals(3, (int) map.get("C++"));

        // putAll() method
        Map<String, Integer> anotherMap = new HashMap<>();
        anotherMap.put("JavaScript", 4);
        anotherMap.put("Ruby", 5);

        map.putAll(anotherMap);

        assertEquals(4, (int) map.get("JavaScript"));
        assertEquals(5, (int) map.get("Ruby"));

    }

    /**
     * e.g.
     * Map<DayOfWeek, Integer> map = new IdentityHashMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */
    @Test
    public void learn_IdentityHashMap() {
        IdentityHashMap<String, Integer> map = new IdentityHashMap<>();

        // Using two different String objects with same value
        String key1 = new String("Day");
        String key2 = new String("Day");

        // put() method
        map.put(key1, 1);
        map.put(key2, 2); // Will treat key1 and key2 as different keys (reference equality)

        assertEquals(2, map.size());
        assertEquals(1, (int) map.get(key1));
        assertEquals(2, (int) map.get(key2));

        // putIfAbsent() method
        map.putIfAbsent(key1, 10); // Does not replace key1's value
        assertEquals(1, (int) map.get(key1));

    }

    /**
     * e.g.
     * EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */
    @Test
    public void learn_EnumMap() {
        EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);

        // put() method
        enumMap.put(DayOfWeek.MONDAY, 1);
        enumMap.put(DayOfWeek.TUESDAY, 2);

        assertEquals(1, (int) enumMap.get(DayOfWeek.MONDAY));
        assertEquals(2, (int) enumMap.get(DayOfWeek.TUESDAY));

        // putIfAbsent() method
        enumMap.putIfAbsent(DayOfWeek.MONDAY, 10); // Will not replace existing value
        enumMap.putIfAbsent(DayOfWeek.WEDNESDAY, 3);

        assertEquals(1, (int) enumMap.get(DayOfWeek.MONDAY));
        assertEquals(3, (int) enumMap.get(DayOfWeek.WEDNESDAY));

        // Verify size
        assertEquals(3, enumMap.size());

    }
}
