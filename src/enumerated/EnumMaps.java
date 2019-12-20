package enumerated;

import java.util.EnumMap;
import java.util.Map;

interface Command{
    void action();
}

public class EnumMaps {
    public static void main(String[] args) {
        EnumMap<AlarmPoints, Command> em = new EnumMap<>(AlarmPoints.class);
        em.put(AlarmPoints.KITCHEN, () -> System.out.println("KITCHEN fire!"));
        em.put(AlarmPoints.BATHROOM, () -> System.out.println("BATHROOM fire"));
        for (Map.Entry<AlarmPoints,Command> e : em.entrySet()){
            System.out.println(e.getKey() + ": ");
            e.getValue().action();
        }

        try {
            em.get(AlarmPoints.UTILITY).action();
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
