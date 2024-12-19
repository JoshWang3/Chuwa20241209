package org.example;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;

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
        HashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        System.out.println(map.get("one"));
        System.out.println(map.getOrDefault("four", 4));
        System.out.println(map.containsKey("one"));
        System.out.println(map.containsValue(2));
        System.out.println(map.keySet());
        System.out.println(map.values());
        System.out.println(map.isEmpty());


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
        HashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.replace("one", 1, 10);
        System.out.println(map);
        map.replace("two", 20);
        System.out.println(map);
        map.replaceAll((k, v) -> v * 10);
        System.out.println(map);
        map.remove("one");
        System.out.println(map);
        map.remove("two", 200);
        System.out.println(map);
        map.compute("three", (k, v) -> v * 10);
        System.out.println(map);
        map.computeIfAbsent("four", k -> 4);
        System.out.println(map);
        map.computeIfPresent("four", (k, v) -> v * 10);
        System.out.println(map);
    }
}
