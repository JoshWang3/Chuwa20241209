package CollectionsTest;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

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

        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Cherry", 30);

        assertEquals(3, map.size());

        map.putIfAbsent("Apple", 50);
        map.putIfAbsent("Date", 40);

        assertEquals((Integer) 40, map.get("Date"));
        assertEquals((Integer) 10, map.get("Apple"));

        Map<String, Integer> newMap = new HashMap<>();
        newMap.put("Elderberry", 50);
        newMap.put("Fig", 60);
        map.putAll(newMap);

        assertEquals(5, map.size());


        assertEquals((Integer) 20, map.get("Banana"));
        assertNull(map.get("Grape"));

        assertEquals((Integer) 30, map.getOrDefault("Cherry", 0));
        assertEquals((Integer) 0, map.getOrDefault("Grape", 0));

        assertTrue(map.containsKey("Apple"));
        assertFalse(map.containsKey("Mango"));

        assertTrue(map.containsValue(10));
        assertFalse(map.containsValue(100));

        assertTrue(map.keySet().contains("Apple"));
        assertTrue(map.keySet().contains("Banana"));
        assertTrue(map.keySet().contains("Cherry"));

        assertTrue(map.values().contains(50));
        assertTrue(map.values().contains(60));

        assertFalse(map.isEmpty());
        map.clear();
        assertTrue(map.isEmpty());
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
        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Cherry", 30);

        assertTrue(map.replace("Apple", 10, 15));
        assertEquals((Integer) 15, map.get("Apple"));
        assertFalse(map.replace("Banana", 25, 35));
        assertEquals((Integer) 20, map.get("Banana"));


        map.replace("Cherry", 40);
        assertEquals((Integer) 40, map.get("Cherry"));
        assertNull(map.replace("Date", 50));


        map.replaceAll((key, value) -> value * 2);
        assertEquals((Integer) 30, map.get("Apple"));
        assertEquals((Integer) 40, map.get("Banana"));
        assertEquals((Integer) 80, map.get("Cherry"));


        assertEquals((Integer) 30, map.remove("Apple"));
        assertNull(map.remove("Date"));
        assertFalse(map.containsKey("Apple"));

        assertTrue(map.remove("Banana", 40));
        assertFalse(map.remove("Cherry", 70));
        assertTrue(map.containsKey("Cherry"));

        map.compute("Cherry", (key, value) -> value == null ? 100 : value + 10);
        assertEquals((Integer) 90, map.get("Cherry"));
        map.compute("Date", (key, value) -> 50);
        assertEquals((Integer) 50, map.get("Date"));


        map.computeIfAbsent("Elderberry", key -> 60);
        assertEquals((Integer) 60, map.get("Elderberry"));
        map.computeIfAbsent("Cherry", key -> 100);
        assertEquals((Integer) 90, map.get("Cherry"));


        map.computeIfPresent("Cherry", (key, value) -> value - 10);
        assertEquals((Integer) 80, map.get("Cherry"));
        map.computeIfPresent("Fig", (key, value) -> 100);
        assertFalse(map.containsKey("Fig"));


    }
}
