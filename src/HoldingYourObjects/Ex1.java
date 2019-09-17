package HoldingYourObjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

//class Gerbil {
//    int gerbilNumber;
//
//    Gerbil(int i) {
//        gerbilNumber = i;
//    }
//
//    public void hop() {
//        System.out.println("Gerbil " + gerbilNumber + " hops");
//    }
//
//}

public class Ex1 {
    public static void main(String[] args) {
        Map<String, Gerbil> map = new TreeMap<>();
        map.put("NHB", new Gerbil(1));
        map.put("LYL", new Gerbil(2));
        map.put("YMH", new Gerbil(3));
        map.put("WEYOUNG", new Gerbil(4));
//        for (String s : map.keySet()) {
//            System.out.print(s + "  ");
//            map.get(s).hop();
//            System.out.println();
//        }
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()){
            String s = it.next();
            System.out.println(s + ": ");
            map.get(s).hop();
        }
    }
}
