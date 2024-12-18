package Collection;

import org.junit.Test;

import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AdditionalMapExerciseTest {
    /**
     * Example usage of ConcurrentHashMap.
     * Methods demonstrated:
     * - put(K key, V value)
     * - putIfAbsent(K key, V value)
     * - putAll(Map<? extends K, ? extends V> m)
     */
    @Test
    public void learn_ConcurrentHashMap() {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // Adding elements using put()
        map.put("Alice", 30);
        map.put("Bob", 25);

        // Adding elements using putIfAbsent()
        map.putIfAbsent("Charlie", 35);
        map.putIfAbsent("Alice", 40); // Will not overwrite existing key

        // Adding multiple elements using putAll()
        Map<String, Integer> additionalEntries = new HashMap<>();
        additionalEntries.put("David", 28);
        additionalEntries.put("Eve", 22);
        map.putAll(additionalEntries);

        // Printing the map
        System.out.println("ConcurrentHashMap contents: " + map);
    }

    /**
     * Example usage of IdentityHashMap.
     * Methods demonstrated:
     * - put(K key, V value)
     * - putIfAbsent(K key, V value)
     */
    @Test
    public void learn_IdentityHashMap() {
        IdentityHashMap<DayOfWeek, Integer> map = new IdentityHashMap<>();

        // Adding elements using put()
        map.put(DayOfWeek.MONDAY, 1);
        map.put(DayOfWeek.TUESDAY, 2);

        // Adding elements using putIfAbsent()
        map.putIfAbsent(DayOfWeek.WEDNESDAY, 3);
        map.putIfAbsent(DayOfWeek.MONDAY, 10); // Will not overwrite existing key

        // Printing the map
        System.out.println("IdentityHashMap contents: " + map);
    }

    /**
     * Example usage of EnumMap.
     * Methods demonstrated:
     * - put(K key, V value)
     * - putIfAbsent(K key, V value)
     */
    @Test
    public void learn_EnumMap() {
        EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);

        // Adding elements using put()
        enumMap.put(DayOfWeek.MONDAY, 100);
        enumMap.put(DayOfWeek.TUESDAY, 200);

        // Adding elements using putIfAbsent()
        enumMap.putIfAbsent(DayOfWeek.WEDNESDAY, 300);
        enumMap.putIfAbsent(DayOfWeek.MONDAY, 400); // Will not overwrite existing key

        // Printing the map
        System.out.println("EnumMap contents: " + enumMap);
    }
}
