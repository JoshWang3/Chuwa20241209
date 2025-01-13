package com.chuwa.learn.collection;

import org.junit.Test;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
        map.put("a", 1);
        map.put("b", 2);
        map.putIfAbsent("c", 3);
        map.forEach((key, value) -> System.out.println(key + " -> " + value));
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("d", 4);
        map.putAll(map1);
        map.forEach((key, value) -> System.out.println(key + " -> " + value));

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

        String key1 = new String("a");
        String key2 = new String("a");

        map.put(key1, 1);
        map.put(key2, 2);
        map.forEach((key, value) -> System.out.println(key + "->" + value));
        System.out.println("Whether key1 equals key2: " + (key1 == key2));

        map.putIfAbsent("b", 3);
        map.forEach((key, value) -> System.out.println(key + "->" + value));
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
        EnumMap<TaskStatus, String> enumMap = new EnumMap<>(TaskStatus.class);
        enumMap.put(TaskStatus.PENDING, "pending");
        enumMap.put(TaskStatus.IN_PROGRESS, "in progress.");
        enumMap.putIfAbsent(TaskStatus.COMPLETED, "finished.");
        enumMap.put(TaskStatus.PENDING, "pending");
        enumMap.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}

enum TaskStatus {
    PENDING,
    IN_PROGRESS,
    COMPLETED
}