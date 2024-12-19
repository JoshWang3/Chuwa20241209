package collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @author b1go
 * @date 6/12/22 4:47 PM
 */
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
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("ccc", 333);

        map.put("aaa", 111);
        map.putIfAbsent("bbb", 222);
        map.putAll(map1);

        Integer expect = 111;
        Assert.assertEquals(expect, map.get("aaa"));
        Assert.assertEquals("aaa", map.firstKey());
        Assert.assertEquals("ccc", map.lastKey());

        map.remove("ccc");
        Assert.assertFalse(map.containsKey("ccc"));
        Assert.assertTrue(map.containsKey("aaa"));

        Set<String> set = map.keySet();
        Set<String> exceptSet = new HashSet<String>(List.of("aaa", "bbb"));
        Assert.assertEquals(exceptSet, set);

        ArrayList<Integer> list = new ArrayList<>(map.values());
        Assert.assertEquals(List.of(111, 222), list);

        Assert.assertFalse(map.isEmpty());
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
        Map<String, Integer> map1 = new HashMap<>();
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

        map.remove("ccc");
        Assert.assertFalse(map.containsKey("ccc"));
    }
}
