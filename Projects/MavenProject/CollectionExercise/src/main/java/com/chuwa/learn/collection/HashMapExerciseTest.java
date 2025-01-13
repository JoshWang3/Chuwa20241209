package com.chuwa.learn.collection;

import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
        map.put("a", 10);
        System.out.println(map);

        map.putIfAbsent("c", 30);
        System.out.println(map);

        Map<String, Integer> anotherMap = new HashMap<>();
        anotherMap.put("d", 40);
        anotherMap.put("e", 50);
        map.putAll(anotherMap);
        System.out.println(map);

        Integer val1 = map.get("a");
        System.out.println(val1);

        Integer defaultValue = map.getOrDefault("aaaa", 0);
        System.out.println(defaultValue);

        System.out.println("Contains key abc" + map.containsKey("abc"));
        System.out.println("Contains value abc" + map.containsKey("abc"));

        Set<String> keys = map.keySet();
        System.out.println(keys);

        Collection<Integer> values = map.values();
        System.out.println(values);

        System.out.println("Empty? " + map.isEmpty());
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
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        System.out.println(map);
        map.replace("a", 1000);
        System.out.println(map);
        boolean replace = map.replace("b", 2, 200);
        System.out.println(map + " " + replace);

        map.replaceAll((key, value) -> value * 2);
        System.out.println(map);

        map.remove("c");
        System.out.println(map);

        map.compute("a", (key, value) -> value == null ? 0 : value + 1000);
        System.out.println(map);

        map.computeIfAbsent("g", key -> 100);
        System.out.println(map);

        map.computeIfPresent("a", (key, value) -> value - 20);
        System.out.println(map);
    }
}
