package collection;

import org.junit.Test;

import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class AdditionalMapExerciseTest {

    class ConcurrentHashMapAddThread1 extends Thread {
        private Map<String, Integer> map;

        public ConcurrentHashMapAddThread1(Map<String, Integer> map) {
            this.map = map;
        }

        @Override
        public void run() {
            Map<String, Integer> map1 = new HashMap<>();
            map1.put("11", 11);
            int end = (int) (Math.random() * 10);
            for (int i = 0; i < end; i++) {
                String key = String.valueOf(i);
                map.put(key, i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                map.putIfAbsent(key, i + i);
                map.putAll(map1);
            }
        }
    }

    class ConcurrentHashMapAddThread2 extends Thread {
        private Map<String, Integer> map;

        public ConcurrentHashMapAddThread2(Map<String, Integer> map) {
            this.map = map;
        }

        @Override
        public void run() {
            int end = (int) (Math.random() * 10);
            for (int i = 0; i < end; i++) {
                String key = String.valueOf(i);
                map.put(key, i + 100);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                map.putIfAbsent(key, i + 100);
            }
        }
    }
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

        ConcurrentHashMapAddThread1 t1 = new ConcurrentHashMapAddThread1(map);
        ConcurrentHashMapAddThread2 t2 = new ConcurrentHashMapAddThread2(map);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + ", " + entry.getValue());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


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
        Map<DayOfWeek, Integer> map = new IdentityHashMap<>();
        map.put(DayOfWeek.valueOf("TUESDAY"), 1);
        map.putIfAbsent(DayOfWeek.valueOf("THURSDAY"), 2);
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
        EnumMap<DayOfWeek, Integer> map = new EnumMap<>(DayOfWeek.class);
        map.put(DayOfWeek.valueOf("TUESDAY"), 1);
        map.putIfAbsent(DayOfWeek.valueOf("THURSDAY"), 2);
    }
}
