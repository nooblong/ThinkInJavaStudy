package HoldingYourObjects;


import java.util.*;

public class Ex18 {
    public static void main(String[] args) {
        Map<String, Gerbil> gerbils = new HashMap<>();
        gerbils.put("Fuzzy", new Gerbil(0));
        gerbils.put("Spot", new Gerbil(1));
        gerbils.put("Speedy", new Gerbil(2));
        gerbils.put("Dopey", new Gerbil(3));
        gerbils.put("Sleepy", new Gerbil(4));
        gerbils.put("Happy", new Gerbil(5));
        gerbils.put("Funny", new Gerbil(6));
        gerbils.put("Silly", new Gerbil(7));
        gerbils.put("Goofy", new Gerbil(8));
        gerbils.put("Wowee", new Gerbil(9));
//        System.out.println(gerbils);
//        Set<String> sortedKeys =
//                new TreeSet<>(gerbils.keySet());
//        System.out.println(sortedKeys);
//        System.out.println();
//        Map<String, Gerbil> sortedGerbils =
//                new LinkedHashMap<>();
//        for (String s : sortedKeys){
//            System.out.print("Adding " + s + ", ");
//            sortedGerbils.put(s, gerbils.get(s));
//        }
//        System.out.println();
//        System.out.println();
//        System.out.println(sortedGerbils);
//        Map<String, Gerbil> sorted = new TreeMap<>(gerbils);
//        System.out.println(sorted);
        Set<String> set1 = new HashSet<>(gerbils.keySet());
        System.out.println(gerbils);
        System.out.println(set1);
        Map<String, Gerbil> hashed1 = new HashMap<>();
        for (String s : set1){
            hashed1.put(s,gerbils.get(s));
        }
        System.out.println("hashmap " + hashed1);
        System.out.println();
        Set<String> linkedHashedKeys =
                new LinkedHashSet<String>(gerbils.keySet());
        System.out.println("LinkedHashSet: " + linkedHashedKeys);
        System.out.println();
        Map<String, Gerbil> linkedHashedGerbils =
                new LinkedHashMap<String, Gerbil>();
        for(String s : linkedHashedKeys) {
            System.out.print("Adding " + s + ", ");
            linkedHashedGerbils.put(s, gerbils.get(s));
        }
        System.out.println();
        System.out.println();
        System.out.println("From LinkedHashSet: "
                + linkedHashedGerbils);

    }
}
