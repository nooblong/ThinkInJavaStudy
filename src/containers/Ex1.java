package containers;

import java.util.*;

public class Ex1 {
    public static void main(String[] args) {
        List<String> countriesLinkedList = new LinkedList<>();
        List<String> countriesArrayList = new ArrayList<>();
        for (int i = 0; i < Countries.DATA.length; i++) {
            countriesArrayList.add(Countries.DATA[i][0]);
            countriesLinkedList.add(Countries.DATA[i][0]);
        }
        Collections.sort(countriesArrayList);
        Collections.sort(countriesLinkedList);
        System.out.println(countriesArrayList);
        System.out.println(countriesLinkedList);
        for (int i = 0; i < 2; i++) {
            Collections.shuffle(countriesArrayList);
            Collections.shuffle(countriesLinkedList);
            System.out.println("Countries " + i + ": " + countriesArrayList);
            System.out.println("Capitals " + i + ": " + countriesLinkedList);
        }

        List<String> al2 = new ArrayList<String>();
        List<String> ll2 = new LinkedList<String>();
        for(int i = 0; i < 10; i++) {
            al2.add(Countries.DATA[i][0]);
            ll2.add(Countries.DATA[i][1]);
        }
        for(int i = 0; i < 5; i++) {
            Collections.shuffle(al2);
            Collections.shuffle(ll2);
            System.out.println("Countries " + i + ": " + al2);
            System.out.println("Capitals " + i + ": " + ll2);
            Collections.sort(al2);
            Collections.sort(ll2);
        }
    }
}
