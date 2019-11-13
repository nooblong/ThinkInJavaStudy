package containers;

import java.util.*;

public class Ex7 {
    public static void main(String[] args) {
        List<String> al = new ArrayList<>(Countries.names(10));
        List<String> ll = new LinkedList<>(Countries.names(10));
        Iterator alIt = al.iterator();
        Iterator llIt = ll.iterator();
        while (alIt.hasNext()) {
            System.out.print(alIt.next() + " ");
        }
        System.out.println();
        while (llIt.hasNext()) {
            System.out.print(llIt.next() + " ");
        }
        ListIterator lIal = al.listIterator();
        ListIterator lIll = ll.listIterator();

        while (lIll.hasNext()){
            lIal.add((String)lIll.next());
            lIal.next();
        }
        System.out.println(al);
    }
}
