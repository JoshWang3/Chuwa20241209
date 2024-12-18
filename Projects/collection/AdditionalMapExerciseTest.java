package com.chuwa.exercise.collection;

import org.junit.Test;

import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Demonstrates basic operations on additional Map implementations: ConcurrentHashMap, IdentityHashMap, and EnumMap.
 */
public class AdditionalMapExerciseTest {

    /**
     * Demonstrates basic operations on ConcurrentHashMap.
     */
    @Test
    public void learn_ConcurrentHashMap() {
        Map<String, Integer> map = new ConcurrentHashMap<>();

        // put operations
        map.put("Apple", 3);
        map.put("Banana", 2);
        System.out.println("After put operations: " + map);

        // putIfAbsent operation
        map.putIfAbsent("Cherry", 5);
        map.putIfAbsent("Apple", 10); // Won't overwrite existing value
        System.out.println("After putIfAbsent operations: " + map);

        // putAll operation
        Map<String, Integer> anotherMap = new ConcurrentHashMap<>();
        anotherMap.put("Date", 4);
        anotherMap.put("Elderberry", 7);
        map.putAll(anotherMap);
        System.out.println("After putAll operation: " + map);
    }

    /**
     * Demonstrates basic operations on IdentityHashMap.
     */
    @Test
    public void learn_IdentityHashMap() {
        Map<String, Integer> map = new IdentityHashMap<>();

        String key1 = new String("Apple");
        String key2 = new String("Apple"); // Different object

        map.put(key1, 1);
        map.put(key2, 2); // Treated as a different key
        map.put("Banana", 3); // String literals are interned

        System.out.println("IdentityHashMap contents:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " | Value: " + entry.getValue());
        }

        // Demonstrate putIfAbsent
        map.putIfAbsent("Banana", 4); // Won't overwrite
        System.out.println("After putIfAbsent 'Banana': " + map);
    }

    /**
     * Demonstrates basic operations on EnumMap.
     */
    @Test
    public void learn_EnumMap() {
        EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);

        // put operations
        enumMap.put(DayOfWeek.MONDAY, 1);
        enumMap.put(DayOfWeek.TUESDAY, 2);
        System.out.println("After put operations: " + enumMap);

        // putIfAbsent operation
        enumMap.putIfAbsent(DayOfWeek.WEDNESDAY, 3);
        enumMap.putIfAbsent(DayOfWeek.MONDAY, 10); // Won't overwrite existing value
        System.out.println("After putIfAbsent operations: " + enumMap);
    }
}