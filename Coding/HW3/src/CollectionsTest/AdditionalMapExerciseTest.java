package CollectionsTest;

import org.junit.Test;

import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.*;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
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
        ConcurrentHashMap<String, Integer> concurrentHashMap;
        concurrentHashMap = new ConcurrentHashMap<>();

        concurrentHashMap.put("A", 1);
        concurrentHashMap.put("B", 2);
        concurrentHashMap.put("C", 3);
        assertEquals(1, concurrentHashMap.get("A").intValue());
        assertEquals(2, concurrentHashMap.get("B").intValue());
        assertEquals(3, concurrentHashMap.get("C").intValue());

        concurrentHashMap.putIfAbsent("A", 10);
        concurrentHashMap.putIfAbsent("D", 4);
        assertEquals(1, concurrentHashMap.get("A").intValue());
        assertEquals(4, concurrentHashMap.get("D").intValue());

        Map<String, Integer> additionalMap = new HashMap<>();
        additionalMap.put("E", 5);
        additionalMap.put("F", 6);
        concurrentHashMap.putAll(additionalMap);
        assertEquals(5, concurrentHashMap.get("E").intValue());
        assertEquals(6, concurrentHashMap.get("F").intValue());


        assertEquals(6, concurrentHashMap.size());
        assertTrue(concurrentHashMap.containsKey("A"));
        assertTrue(concurrentHashMap.containsKey("D"));

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
        Map<DayOfWeek, Integer> identityMap = new IdentityHashMap<>();

        DayOfWeek monday1 = DayOfWeek.MONDAY;
        DayOfWeek tuesday = DayOfWeek.TUESDAY;

        identityMap.put(monday1, 1);
        identityMap.put(tuesday, 2);
        assertEquals(1, identityMap.get(monday1).intValue());
        assertEquals(2, identityMap.get(tuesday).intValue());


        identityMap.putIfAbsent(tuesday, 5);

        assertEquals(2, identityMap.get(tuesday).intValue());

        assertTrue(identityMap.containsKey(monday1));
        assertTrue(identityMap.containsKey(tuesday));

        Object obj1 = new Object();
        Object obj2 = new Object();

        assertNotSame(obj1, obj2);
        Map<Object, Integer> identityMap1 = new IdentityHashMap<>();
        identityMap1.put(obj1, 1);
        identityMap1.put(obj2, 2);

        assertEquals(1, identityMap1.get(obj1).intValue());
        assertEquals(2, identityMap1.get(obj2).intValue());
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
        assertEquals(1, enumMap.get(DayOfWeek.MONDAY).intValue());
        assertEquals(2, enumMap.get(DayOfWeek.TUESDAY).intValue());


        enumMap.put(DayOfWeek.MONDAY, 10);
        assertEquals(10, enumMap.get(DayOfWeek.MONDAY).intValue());


        enumMap.putIfAbsent(DayOfWeek.WEDNESDAY, 3);
        enumMap.putIfAbsent(DayOfWeek.TUESDAY, 5);
        assertEquals(3, enumMap.get(DayOfWeek.WEDNESDAY).intValue());
        assertEquals(2, enumMap.get(DayOfWeek.TUESDAY).intValue());


        assertEquals(3, enumMap.size());
        assertTrue(enumMap.containsKey(DayOfWeek.MONDAY));
        assertTrue(enumMap.containsKey(DayOfWeek.TUESDAY));
        assertTrue(enumMap.containsKey(DayOfWeek.WEDNESDAY));
        assertFalse(enumMap.containsKey(DayOfWeek.SUNDAY));

    }
}
