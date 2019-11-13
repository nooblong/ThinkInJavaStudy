package containers;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class SpringDetector {
    public static <T extends GroundHog> void detectSpring(Class<T> type) throws Exception{
        Constructor<T> c = type.getDeclaredConstructor(int.class);
        Map<GroundHog,Prediction> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(c.newInstance(i), new Prediction());
        }
        System.out.println("map: " + map);
        GroundHog gh = c.newInstance(3);
        System.out.println("look up " + gh);
        if (map.containsKey(gh))
            System.out.println(map.get(gh));
        else
            System.out.println("not found " + gh);
    }

    public static void main(String[] args) throws Exception {
        detectSpring(GroundHog.class);
    }
}
