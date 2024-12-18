package Collection;

import org.junit.Test;

import java.util.TreeMap;
import java.util.Set;
import java.util.Collection;

public class TreeMapExerciseTest {

    @Test
    public void learn_Inserting_And_Retrieving() {
        TreeMap<String, Integer> map = new TreeMap<>();

        map.put("Apple", 10);
        map.put("Banana", 20);
        map.putIfAbsent("Orange", 30);
        map.putIfAbsent("Apple", 40);

        TreeMap<String, Integer> anotherMap = new TreeMap<>();
        anotherMap.put("Grapes", 40);
        anotherMap.put("Pineapple", 50);
        map.putAll(anotherMap);

        System.out.println("Value for 'Banana': " + map.get("Banana"));
        System.out.println("First key: " + map.firstKey());
        System.out.println("Last key: " + map.lastKey());

        System.out.println("Contains key 'Orange': " + map.containsKey("Orange"));
        System.out.println("Contains value 50: " + map.containsValue(50));

        Set<String> keys = map.keySet();
        Collection<Integer> values = map.values();
        System.out.println("Keys: " + keys);
        System.out.println("Values: " + values);

        System.out.println("Is map empty? " + map.isEmpty());
        System.out.println("Final TreeMap: " + map);
    }

    @Test
    public void learn_Remove_Replacing_Updating() {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Orange", 30);

        map.replace("Banana", 25);
        map.replace("Apple", 10, 15);

        map.remove("Orange");
        map.remove("Apple", 25);

        System.out.println("After replacements and removals: " + map);
    }
}

