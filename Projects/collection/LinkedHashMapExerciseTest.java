package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Demonstrates basic LinkedHashMap operations: inserting, retrieving, removing, replacing, and updating elements.
 */
public class LinkedHashMapExerciseTest {

    /**
     * Demonstrates inserting elements into a LinkedHashMap and retrieving them.
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        // Create a new LinkedHashMap
        Map<String, Integer> map = new LinkedHashMap<>();

        // Insert key-value pairs using put
        map.put("Apple", 3);
        map.put("Banana", 2);
        map.put("Cherry", 5);
        System.out.println("After put operations: " + map);

        // Insert using putIfAbsent; adds "Date" but not "Apple" since it already exists
        map.putIfAbsent("Date", 4);
        map.putIfAbsent("Apple", 10);
        System.out.println("After putIfAbsent operations: " + map);

        // Insert all elements from another map using putAll
        Map<String, Integer> anotherMap = new LinkedHashMap<>();
        anotherMap.put("Elderberry", 7);
        anotherMap.put("Fig", 6);
        map.putAll(anotherMap);
        System.out.println("After putAll operation: " + map);

        // Retrieve an element using get
        Integer appleCount = map.get("Apple");
        System.out.println("Value for 'Apple': " + appleCount);

        // Retrieve an element with a default value using getOrDefault
        Integer grapeCount = map.getOrDefault("Grape", 0);
        System.out.println("Value for 'Grape' (or default 0): " + grapeCount);

        // Check if the map contains specific keys and values
        System.out.println("Contains key 'Banana': " + map.containsKey("Banana"));
        System.out.println("Contains value 5: " + map.containsValue(5));

        // Retrieve all keys and values
        System.out.println("Keys: " + map.keySet());
        System.out.println("Values: " + map.values());

        // Check if the map is empty
        System.out.println("Is map empty?: " + map.isEmpty());
    }

    /**
     * Demonstrates removing, replacing, and updating elements in a LinkedHashMap.
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        // Initialize the LinkedHashMap with some entries
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Apple", 3);
        map.put("Banana", 2);
        map.put("Cherry", 5);
        map.put("Date", 4);
        map.put("Elderberry", 7);
        map.put("Fig", 6);
        System.out.println("Original map: " + map);

        // Replace the value for "Banana"
        map.replace("Banana", 20);
        System.out.println("After replacing 'Banana': " + map);

        // Replace the value for "Cherry" only if it is currently mapped to 5
        boolean replaced = map.replace("Cherry", 5, 50);
        System.out.println("Attempt to replace 'Cherry' from 5 to 50: " + replaced);
        System.out.println("After conditional replace: " + map);

        // Replace all values by incrementing each by 1
        map.replaceAll((key, value) -> value + 1);
        System.out.println("After replaceAll (increment all values by 1): " + map);

        // Remove an element by key
        map.remove("Date");
        System.out.println("After removing 'Date': " + map);

        // Remove an element by key and value
        boolean removed = map.remove("Elderberry", 8); // Incorrect value; should not remove
        System.out.println("Attempt to remove 'Elderberry' with value 8: " + removed);
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
