package design_pattern.factory.config_factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CoffeeFactory {

    private static Map<String, Coffee> map = new HashMap<>();

    static {
        Properties p = new Properties();
        InputStream is = CoffeeFactory.class.getClassLoader().getResourceAsStream("beans.properties");
        try {
            p.load(is);
            Set<Object> sets = p.keySet();
            for (Object key : sets) {
                String className = p.getProperty((String) key);
                Class clazz = Class.forName(className);
                Coffee coffee = (Coffee) clazz.newInstance();
                map.put((String) key, coffee);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Coffee produceCoffee(String type) {
        return null;
    }
}
