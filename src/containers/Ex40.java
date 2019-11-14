package containers;

import net.mindview.util.RandomGenerator;

import java.util.*;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

class Compare implements Comparable<Compare>{

    private String s1, s2;

    public Compare(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    public int compareTo(Compare o) {
        return s1.compareTo(o.s1);
    }

    public static class Comp2 implements Comparator<Compare>{

        @Override
        public int compare(Compare o1, Compare o2) {
            System.out.println("comparator");
            return o1.s2.compareTo(o2.s2);
        }
    }

    @Override
    public String toString() {
        return s1 + " & " + s2;
    }

    static void printArray(Compare[] sa){
        System.out.println();
        for (int i = 0; i < sa.length-1; i++) {
            System.out.print(sa[i] + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RandomGenerator.String rgs = new RandomGenerator.String(4);
        Compare[] array = new Compare[5];
        List<Compare> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            String s1, s2;
            s1 = rgs.next();
            s2 = rgs.next();
            array[i] = new Compare(s1,s2);
            list.add(new Compare(s1,s2));
        }
        printnb("Array: ");
        printArray(array);
        print("List: " + list);
        Arrays.sort(array);
        Collections.sort(list, null);
        print();
        print("Sorted by first word:");
        printnb("Array: ");
        printArray(array);
        print("List: " + list);
        Compare.Comp2 comp = new Compare.Comp2();
        Arrays.sort(array, comp);
        Collections.sort(list, comp);
        print();
        print("Sorted by second word:");
        printnb("Array: ");
        printArray(array);
        print("List: " + list);

    }
}