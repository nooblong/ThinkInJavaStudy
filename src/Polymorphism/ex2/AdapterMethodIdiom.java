package Polymorphism.ex2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

class ReversibleArrayList<T> extends ArrayList<T>{
    public ReversibleArrayList(Collection<T> c){
        super(c);
    }
    public Iterator<T> reversed(){
        return new Iterator<T>() {
            private int current = size()-1;

            @Override
            public boolean hasNext() {
                return current>-1;
            }

            @Override
            public T next() {
                return get(current--);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
public class AdapterMethodIdiom {
    public static void main(String[] args) {
        ReversibleArrayList<String> ral =
                new ReversibleArrayList<>(
                        Arrays.asList("To be or not to be".split(" "))
                );
        for (String s : ral){
            System.out.print(s + " ");
        }
        System.out.println();
        for (Iterator<String> it = ral.reversed(); it.hasNext(); ) {
            String s = it.next();
            System.out.print(s + " ");

        }
    }

}
