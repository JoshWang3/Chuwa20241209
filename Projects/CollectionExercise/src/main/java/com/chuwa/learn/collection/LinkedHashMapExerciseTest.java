package com.chuwa.learn.collection;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

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
        Map<String, Integer> map = new LinkedHashMap<>();

        map.put("A", 1);
        map.put("B", 2);
        map.putIfAbsent("A", 10);
        map.putIfAbsent("C", 3);

        Map<String, Integer> anotherMap = new LinkedHashMap<>();
        anotherMap.put("D", 4);
        anotherMap.put("E", 5);
        map.putAll(anotherMap);

        Integer valueA = map.get("A");
        Integer valueD = map.getOrDefault("D", 0);
        Integer valueF = map.getOrDefault("F", 0);

        boolean containsKeyA = map.containsKey("A");
        boolean containsValue5 = map.containsValue(5);

        boolean isEmpty = map.isEmpty();

        System.out.println(map.keySet());
        System.out.println(map.values());
        System.out.println(valueA);
        System.out.println(valueD);
        System.out.println(valueF);
        System.out.println(containsKeyA);
        System.out.println(containsValue5);
        System.out.println(isEmpty);
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
        Map<String, Integer> map = new LinkedHashMap<>();

        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        map.replace("A", 10);
        map.replace("B", 2, 20);
        map.replaceAll((k, v) -> v * 2);

        map.remove("C");
        map.remove("B", 40);

        map.compute("D", (k, v) -> (v == null) ? 1 : v + 1);
        map.computeIfAbsent("E", k -> 5);
        map.computeIfPresent("D", (k, v) -> v + 5);

        System.out.println(map);
    }
}
