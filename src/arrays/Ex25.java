package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

class MyList extends ArrayList {
    List myList = new ArrayList();
    MyList(List l) { myList = l; }
    @SuppressWarnings("unchecked")
    MyList getReversed() {
        ListIterator lit = myList.listIterator(myList.size());
        List reverseMyList = new ArrayList();
        while(lit.hasPrevious()) {
            reverseMyList.add(lit.previous());
        }
        return new MyList(reverseMyList);
    }
}

class Ex25{
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        System.out.println(list);
        System.out.println(list.get(4));
        list.addAll(new ArrayList<>(Arrays.asList(7,8)));
        System.out.println(list);
        System.out.println(list.subList(2, 4));
        MyList ml = new MyList(list);
        System.out.println((ml.getReversed()).myList);
    }
}