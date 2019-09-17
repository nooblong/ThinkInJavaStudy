package HoldingYourObjects;
import java.util.*;
public class Ex24 {
    public static void main(String[] args) {
        Map<String,Integer> m =
                new LinkedHashMap<String,Integer>();
        m.put("ten", 10);
        m.put("nine", 9);
        m.put("eight", 8);
        m.put("seven", 7);
        m.put("six", 6);
        m.put("five", 5);
        m.put("four", 4);
        m.put("three", 3);
        m.put("two", 2);
        m.put("one", 1);
        m.put("zero", 0);
        System.out.println("Map to sort: " + m);
        Map<String, Integer> mtmp =
                new LinkedHashMap<>();
        Set<String> ss = new TreeSet<>(m.keySet());
        Iterator<String> itss = ss.iterator();
        while (itss.hasNext()){
            String s = (String)itss.next();
            Integer i = m.get(s);
            m.remove(s);
            mtmp.put(s, i);
        }
        Set<String> ssTemp =
                new TreeSet<String>(mtmp.keySet());
        // move sorted entrys back to map:
        Iterator<String> itssTemp = ssTemp.iterator();
        while(itssTemp.hasNext()) {
            String s = (String)itssTemp.next();
            Integer i = mtmp.get(s);
            mtmp.remove(s);
            m.put(s, i);
        }
        // done with temp:
        mtmp.clear();
        System.out.println("Sorted map: " + m);
    }
}
