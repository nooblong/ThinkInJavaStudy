package HoldingYourObjects;

import java.util.*;

public class CollectionSequence extends AbstractCollection<String> {
    private String[] string = {"F", "U", "C", "K"};
    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < string.length;
            }

            @Override
            public String next() {
                return string[index++];
            }
        };
    }
    @Override
    public int size() {
        return string.length;
    }

    public static void display(Collection<String> collection){
        for (String s : collection){
            System.out.print(s + " ");
        }
    }
    public static void main(String[] args) {
        CollectionSequence collectionSequence = new CollectionSequence();
        display(collectionSequence);
    }

}
