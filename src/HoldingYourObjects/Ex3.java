package HoldingYourObjects;

import java.util.ArrayList;

class Word {
    private String word;

    public Word(String s) {
        word = s;
    }

    @Override
    public String toString() {
        return word;
    }
}

interface Selector {
    boolean end();

    Object current();

    void next();
}

public class Ex3 {
    private ArrayList<Object> items = new ArrayList<>();
    private int next = 0;

    public void add(Object x) {
        items.add(x);
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    private class SequenceSelector implements Selector {
        private int i = 0;

        @Override
        public boolean end() {
            return i == items.size();
        }

        @Override
        public Object current() {
            return items.get(i);
        }

        @Override
        public void next() {
//            if (i < items.size())
                i++;
        }
    }

    public static void main(String[] args) {
        Word[] words = new Word[10];
        Ex3 e = new Ex3();
        Selector selector = e.selector();
        for (int i = 0; i < 10; i++) {
            words[i] = new Word(i + "fuck");
            e.add(words[i]);
        }
        e.add(1);
        e.add("ddddd");
        while (!selector.end()){
            System.out.println(selector.current() + " ");
            selector.next();
        }

    }
}