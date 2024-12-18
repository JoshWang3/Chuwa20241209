package HW3.Collection;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

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
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        map.put("One", 1);
        map.put("Two", 2);
        map.putIfAbsent("Three", 3);
        map.put("Four", 4);
        map.put("Five", 5);

        System.out.println("Map: " + map);
        System.out.println("Get value for key 'Two': " + map.get("Two"));
        System.out.println("Get value for key 'Six' with default value 6: " + map.getOrDefault("Six", 6));
        System.out.println("Contains key 'Three': " + map.containsKey("Three"));
        System.out.println("Contains value 4: " + map.containsValue(4));

        System.out.println("Key Set: " + map.keySet());
        System.out.println("Values: " + map.values());
        System.out.println("Is map empty: " + map.isEmpty());
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
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);

        System.out.println("Original Map: " + map);

        map.replace("Two", 22);
        System.out.println("After replace 'Two': " + map);

        map.replace("Three", 3, 33);
        System.out.println("After replace 'Three': " + map);

        map.replaceAll((key, value) -> value * 2);
        System.out.println("After replaceAll: " + map);

        map.remove("One");
        System.out.println("After remove 'One': " + map);

        map.remove("Three", 33);
        System.out.println("After remove 'Three' with value 33: " + map);

        map.compute("Two", (key, value) -> value + 10);
        System.out.println("After compute 'Two': " + map);

        map.computeIfAbsent("Four", key -> 40);
        System.out.println("After computeIfAbsent 'Four': " + map);

        map.computeIfPresent("Two", (key, value) -> value * 2);
        System.out.println("After computeIfPresent 'Two': " + map);
    }
}