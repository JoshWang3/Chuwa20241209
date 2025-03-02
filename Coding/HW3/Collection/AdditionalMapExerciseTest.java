package HW3.Collection;


import org.junit.Test;

import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.assertEquals;

public class AdditionalMapExerciseTest {
    /**
     * e.g.
     * ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     * putAll(Map<? extends K, ? extends V> m)
     */
    @Test
    public void learn_ConcurrentHashMap() {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("chuwa", 1);
        System.out.println("ConcurrentHashMap after put and putIfAbsent: " + map);
        map.put("chuwa", 2);
        System.out.println("ConcurrentHashMap after updating chuwa: " + map);

    }

    /**
     * e.g.
     * Map<DayOfWeek, Integer> map = new IdentityHashMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */
    @Test
    public void learn_IdentityHashMap() {
        Map<String, Integer> map = new IdentityHashMap<>();
        String key1 = new String("Monday");
        String key2 = new String("Monday");
        map.put(key1, 1);
        map.put(key2, 2);
        //assertEquals(Optional.of(3), map.get(new String("Tuesday")));
    }

    /**
     * e.g.
     * EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */
    @Test
    public void learn_EnumMap() {
        EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
        enumMap.put(DayOfWeek.MONDAY, 1);
        enumMap.put(DayOfWeek.TUESDAY, 2);
        enumMap.putIfAbsent(DayOfWeek.WEDNESDAY, 3);

        System.out.println("EnumMap contents: " + enumMap);
        System.out.println("Value for MONDAY: " + enumMap.get(DayOfWeek.MONDAY));
        System.out.println("Size of EnumMap: " + enumMap.size());
    }
}
