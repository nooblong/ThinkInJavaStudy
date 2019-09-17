package HoldingYourObjects;

import java.util.*;

class Generate{
    int key = 0;
    public String next() {
        switch(key) {
            default:
            case 0 : key++; return "Snow White 1";
            case 1 : key++; return "Bashful 2";
            case 2 : key++; return "Doc 3";
            case 3 : key++; return "Dopey 4";
            case 4 : key++; return "Grumpy 5";
            case 5 : key++; return "Happy 6";
            case 6 : key++; return "Sleepy 7";
            case 7 : key = 0; return "Sneezy 8";
        }
    }
    void fillA(String[] a){
        for (int i = 0; i < a.length; i++) {
            a[i] = next();
        }
    }
    Collection fill(Collection<String > c, int n){
        for (int i = 0; i < n; i++) {
            c.add(next());
        }
        return c;
    }
}


public class Ex4 {
    public static void main(String[] args) {
        Generate generate = new Generate();
        String[] s = new String[10];
        generate.fillA(s);
        for (String s1 : s){
            System.out.print(s1 + " ");
        }
        System.out.println();
        ArrayList<String> a = new ArrayList<>();
        System.out.println(generate.fill(a,10));
        System.out.println(generate.fill(new LinkedList<>(),11));
        System.out.println(generate.fill(new HashSet<>(),12));
        System.out.println(generate.fill(new LinkedHashSet<>(),13));
        System.out.println(generate.fill(new TreeSet<>(), 14));
    }
}
