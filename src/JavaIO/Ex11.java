package JavaIO;

import InnerClass.controlFramwork.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class GreenHouseController11{
    public static Map<String, Long> readEvents(String filename) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(new File(filename)));
        String s;
        Map<String,Long> map = new HashMap<>();
        while ((s = in.readLine()) != null){
            String[] sa = s.split("[()]");
            map.put(sa[0], Long.valueOf(sa[1]));
        }
        in.close();
        return map;
    }
    private static Event makeEvent(GreenhouseControls gc, Map.Entry<String,Long> me){
        String key = me.getKey();
        Long value = me.getValue();
        if(key.equals("Bell")) return gc.new Bell(value);
        if(key.equals("LightOn")) return gc.new LightOn(value);
        if(key.equals("LightOff")) return gc.new LightOff(value);
        if(key.equals("WaterOn")) return gc.new WaterOn(value);
        if(key.equals("WaterOff")) return gc.new WaterOff(value);
        return null;
    }

    public static void main(String[] args) {
        GreenhouseControls gc = new GreenhouseControls();
        try {
            Map<String,Long> map = readEvents("Events.txt");
            System.out.println(map.keySet());
            Event[] events = new Event[map.size()];
            int i = 0;
            for (Map.Entry<String,Long> me : map.entrySet()){
                events[i++] = makeEvent(gc, me);
            }
            gc.addEvent(gc.new Restart(2000, events));
            gc.run();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}