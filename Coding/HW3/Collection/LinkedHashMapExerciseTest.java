package Collection;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExerciseTest {

    @Test
    public void learn_Inserting_And_Retrieving() {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Apple", 10);
        map.put("Banana", 20);
        map.putIfAbsent("Orange", 30);
        map.putIfAbsent("Apple", 40);

        Map<String, Integer> anotherMap = new LinkedHashMap<>();
        anotherMap.put("Grapes", 40);
        anotherMap.put("Pineapple", 50);
        map.putAll(anotherMap);

        System.out.println(map.get("Banana"));
        System.out.println(map.getOrDefault("Mango", 100));
        System.out.println(map.containsKey("Orange"));
        System.out.println(map.containsValue(50));
        System.out.println(map.keySet());
        System.out.println(map.values());
        System.out.println(map.isEmpty());
        System.out.println(map);
    }

    @Test
    public void learn_Remove_Replacing_Updating() {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Orange", 30);

        map.replace("Banana", 25);
        map.replace("Apple", 10, 15);
        map.replaceAll((key, value) -> value + 10);

        map.remove("Orange");
        map.remove("Apple", 25);

        map.compute("Banana", (key, value) -> value == null ? 0 : value * 2);
        map.computeIfAbsent("Pineapple", key -> 50);
        map.computeIfPresent("Banana", (key, value) -> value + 5);

        System.out.println(map);
    }
}

