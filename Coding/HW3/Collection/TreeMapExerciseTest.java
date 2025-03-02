package HW3.Collection;

import org.junit.Test;

import java.util.TreeMap;

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
        TreeMap<String, Integer> map = new TreeMap<>();

        map.put("Apple", 3);
        map.put("Banana", 2);
        map.put("Orange", 5);
        map.put("Grapes", 4);

        System.out.println("TreeMap: " + map);

        System.out.println("Value for Apple: " + map.get("Apple"));
        System.out.println("First Key: " + map.firstKey());
        System.out.println("Last Key: " + map.lastKey());

        System.out.println("Contains key 'Banana': " + map.containsKey("Banana"));
        System.out.println("Contains value 5: " + map.containsValue(5));

        System.out.println("Key Set: " + map.keySet());
        System.out.println("Values: " + map.values());

        System.out.println("Is map empty: " + map.isEmpty());
    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     *
     * remove(Object key)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        TreeMap<String, Integer> map = new TreeMap<>();

        map.put("Apple", 3);
        map.put("Banana", 2);
        map.put("Orange", 5);
        map.put("Grapes", 4);

        System.out.println("Before update: " + map);

        map.replace("Apple", 3, 6);
        System.out.println("After replacing Apple value: " + map);

        map.replace("Banana", 2);
        System.out.println("After replacing Banana value: " + map);

        map.remove("Grapes");
        System.out.println("After removing Grapes: " + map);
    }
}
