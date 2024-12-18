package com.chuwa.exercise.collection;

import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

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
        // Create a new HashMap
        Map<String, Integer> map = new HashMap<>();

        // Insert key-value pairs using put method
        map.put("Apple", 3);
        map.put("Banana", 2);
        map.put("Cherry", 5);
        System.out.println("After put operations: " + map);

        // Insert using putIfAbsent; adds "Date" but not "Apple" since it already exists
        map.putIfAbsent("Date", 4);
        map.putIfAbsent("Apple", 10);
        System.out.println("After putIfAbsent operations: " + map);

        // Insert all entries from another map using putAll
        Map<String, Integer> additionalMap = new HashMap<>();
        additionalMap.put("Elderberry", 7);
        additionalMap.put("Fig", 6);
        map.putAll(additionalMap);
        System.out.println("After putAll operation: " + map);

        // Retrieve value using get method
        Integer appleCount = map.get("Apple");
        System.out.println("Value for 'Apple': " + appleCount);

        // Retrieve value using getOrDefault; returns 0 for "Grape" if not present
        Integer grapeCount = map.getOrDefault("Grape", 0);
        System.out.println("Value for 'Grape' (or default 0): " + grapeCount);

        // Check if a key exists using containsKey
        boolean hasBanana = map.containsKey("Banana");
        System.out.println("Contains key 'Banana': " + hasBanana);

        // Check if a value exists using containsValue
        boolean hasValue5 = map.containsValue(5);
        System.out.println("Contains value 5: " + hasValue5);

        // Retrieve all keys using keySet
        System.out.println("Keys: " + map.keySet());

        // Retrieve all values using values
        System.out.println("Values: " + map.values());

        // Check if the map is empty using isEmpty
        boolean isEmpty = map.isEmpty();
        System.out.println("Is map empty?: " + isEmpty);
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
        // Initialize the HashMap with some entries
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 3);
        map.put("Banana", 2);
        map.put("Cherry", 5);
        map.put("Date", 4);
        map.put("Elderberry", 7);
        map.put("Fig", 6);
        System.out.println("Initial map: " + map);

        // Replace the value for "Banana"
        map.replace("Banana", 20);
        System.out.println("After replacing 'Banana': " + map);

        // Replace all values by incrementing each by 1
        map.replaceAll((key, value) -> value + 1);
        System.out.println("After replaceAll (increment all values by 1): " + map);

        // Remove the entry for "Fig"
        map.remove("Fig");
        System.out.println("After removing 'Fig': " + map);

        // Attempt to remove "Elderberry" with an incorrect value; should not remove
        map.remove("Elderberry", 8);
        System.out.println("After attempting to remove 'Elderberry' with incorrect value: " + map);

        // Compute a new value for "Apple" by multiplying it by 2
        map.compute("Apple", (key, value) -> value * 2);
        System.out.println("After computing 'Apple': " + map);

        // Compute if absent: add "Grape" with value 1 if not present
        map.computeIfAbsent("Grape", key -> 1);
        System.out.println("After computeIfAbsent for 'Grape': " + map);

        // Compute if present: increment "Cherry" by 5 if it exists
        map.computeIfPresent("Cherry", (key, value) -> value + 5);
        System.out.println("After computeIfPresent for 'Cherry': " + map);
    }
}
