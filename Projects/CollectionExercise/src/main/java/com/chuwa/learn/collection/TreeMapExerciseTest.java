package com.chuwa.learn.collection;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

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
        Map<String, Integer> map = new TreeMap<>();

        map.put("A", 1);
        map.put("B", 2);
        map.putIfAbsent("A", 10);
        map.putIfAbsent("C", 3);

        Map<String, Integer> anotherMap = new TreeMap<>();
        anotherMap.put("D", 4);
        anotherMap.put("E", 5);
        map.putAll(anotherMap);

        Integer valueA = map.get("A");
        String firstKey = ((TreeMap<String, Integer>) map).firstKey();
        String lastKey = ((TreeMap<String, Integer>) map).lastKey();

        boolean containsKeyA = map.containsKey("A");
        boolean containsValue5 = map.containsValue(5);

        boolean isEmpty = map.isEmpty();

        System.out.println(map.keySet());
        System.out.println(map.values());
        System.out.println(valueA);
        System.out.println(firstKey);
        System.out.println(lastKey);
        System.out.println(containsKeyA);
        System.out.println(containsValue5);
        System.out.println(isEmpty);
    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     *
     * remove(Object key)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        Map<String, Integer> map = new TreeMap<>();

        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        map.replace("A", 10);
        map.replace("B", 2, 20);

        map.remove("C");

        System.out.println(map);
    }
}
