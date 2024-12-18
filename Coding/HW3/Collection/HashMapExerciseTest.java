package Collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Collection;
import java.util.function.BiFunction;
import java.util.function.Function;

public class HashMapExerciseTest {

    /**
     * Demonstrates:
     * - put(K key, V value)
     * - putIfAbsent(K key, V value)
     * - putAll(Map<? extends K, ? extends V> m)
     * - get(Object key), getOrDefault(Object key, V defaultValue)
     * - containsKey(Object key), containsValue(Object value)
     * - keySet(), values(), isEmpty()
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        // Creating a HashMap
        Map<String, Integer> map = new HashMap<>();

        // put() - Adding elements
        map.put("Apple", 10);
        map.put("Banana", 20);

        // putIfAbsent() - Add only if key does not exist
        map.putIfAbsent("Orange", 30);
        map.putIfAbsent("Apple", 40); // Won't update "Apple"

        // putAll() - Adding all elements from another map
        Map<String, Integer> anotherMap = new HashMap<>();
        anotherMap.put("Grapes", 40);
        anotherMap.put("Pineapple", 50);
        map.putAll(anotherMap);

        // get() and getOrDefault()
        System.out.println("Value for 'Banana': " + map.get("Banana"));
        System.out.println("Value for 'Mango' (default): " + map.getOrDefault("Mango", 100));

        // containsKey() and containsValue()
        System.out.println("Contains key 'Orange': " + map.containsKey("Orange"));
        System.out.println("Contains value 50: " + map.containsValue(50));

        // keySet() and values()
        Set<String> keys = map.keySet();
        Collection<Integer> values = map.values();
        System.out.println("Keys: " + keys);
        System.out.println("Values: " + values);

        // isEmpty()
        System.out.println("Is the map empty? " + map.isEmpty());

        // Printing the map
        System.out.println("Final map: " + map);
    }

    /**
     * Demonstrates:
     * - replace(K key, V oldValue, V newValue), replace(K key, V value)
     * - replaceAll(BiFunction<? super K, ? super V, ? extends V> function)
     * - remove(Object key), remove(Object key, Object value)
     * - compute(), computeIfAbsent(), computeIfPresent()
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        // Creating a HashMap
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Orange", 30);

        // replace() - Update value if key exists
        map.replace("Banana", 25);
        System.out.println("After replacing 'Banana' value: " + map);

        // replace(K, V, V) - Conditional replace
        map.replace("Apple", 10, 15); // Replaces only if old value matches
        System.out.println("After conditional replace for 'Apple': " + map);

        // replaceAll() - Replace all values using a BiFunction
        map.replaceAll((key, value) -> value + 10);
        System.out.println("After replaceAll: " + map);

        // remove(Object key)
        map.remove("Orange");
        System.out.println("After removing 'Orange': " + map);

        // remove(Object key, Object value)
        map.remove("Apple", 25); // Won't remove as value doesn't match
        System.out.println("After conditional remove for 'Apple': " + map);

        // compute() - Recompute value for the key
        map.compute("Banana", (key, value) -> value == null ? 0 : value * 2);
        System.out.println("After compute for 'Banana': " + map);

        // computeIfAbsent() - Compute if key is absent
        map.computeIfAbsent("Pineapple", key -> 50);
        System.out.println("After computeIfAbsent for 'Pineapple': " + map);

        // computeIfPresent() - Compute if key exists
        map.computeIfPresent("Banana", (key, value) -> value + 5);
        System.out.println("After computeIfPresent for 'Banana': " + map);

        // Final map
        System.out.println("Final map: " + map);
    }
}

