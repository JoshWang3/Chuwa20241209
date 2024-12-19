package collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
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
        HashMap<String, Integer> map = new LinkedHashMap<>(), map1 = new HashMap<>();
        map1.put("ccc", 333);
        map.put("aaa", 111);
        map.putIfAbsent("bbb", 222);
        map.putAll(map1);

        map.replace("ccc", 333, 444);
        Integer expect = 444;
        Assert.assertEquals(expect, map.get("ccc"));

        map.replace("ccc", 333);
        expect = 333;
        Assert.assertEquals(expect, map.get("ccc"));

        map.replaceAll((key, value) -> value + 1);
        expect = 334;
        Assert.assertEquals(expect, map.get("ccc"));

        map.remove("ccc");
        Assert.assertFalse(map.containsKey("ccc"));
        map.remove("aaa", 111);
        Assert.assertTrue(map.containsKey("aaa"));

        map.put("aaa", 111);
        map.put("ccc", 333);

        map.compute("aaa", (key, val)
                -> val + 1);
        expect = 112;
        Assert.assertEquals(expect, map.get("aaa"));

        map.computeIfAbsent("ddd", s -> s.length());
        expect = 3;
        Assert.assertEquals(expect, map.get("ddd"));

        map.computeIfPresent("aaa", (key, value) -> value + 1);
        expect = 113;
        Assert.assertEquals(expect, map.get("aaa"));

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
        Map<String, Integer> map = new HashMap<>(), map1 = new HashMap<>();
        map1.put("ccc", 333);

        map.put("aaa", 111);
        map.putIfAbsent("bbb", 222);
        map.putAll(map1);

        map.replace("ccc", 333, 444);
        Integer expect = 444;
        Assert.assertEquals(expect, map.get("ccc"));

        map.replace("ccc", 333);
        expect = 333;
        Assert.assertEquals(expect, map.get("ccc"));

        map.replaceAll((key, value) -> value + 1);
        expect = 334;
        Assert.assertEquals(expect, map.get("ccc"));

        map.remove("ccc");
        Assert.assertFalse(map.containsKey("ccc"));
        map.remove("aaa", 111);
        Assert.assertTrue(map.containsKey("aaa"));

        map.put("aaa", 111);
        map.put("ccc", 333);

        map.compute("aaa", (key, val)
                -> val + 1);
        expect = 112;
        Assert.assertEquals(expect, map.get("aaa"));

        map.computeIfAbsent("ddd", s -> s.length());
        expect = 3;
        Assert.assertEquals(expect, map.get("ddd"));

        map.computeIfPresent("aaa", (key, value) -> value + 1);
        expect = 113;
        Assert.assertEquals(expect, map.get("aaa"));
    }
}
