package InnerClass;

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

class Sequence2 {
    private Object[] items;
    private int next = 0;

    public Sequence2(int size) {
        items = new Object[size];
    }

    public void add(Object x) {
        if (next < items.length) {
            items[next++] = x;
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    private class SequenceSelector implements Selector {
        private int i = 0;

        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length)
                i++;
        }

        public Sequence2 f() {
            return Sequence2.this;
        }
    }

    private class ReverseSequenceSelector implements Selector {
        private int i = 0;

        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[items.length - i - 1];
        }

        @Override
        public void next() {
            if (i < items.length)
                i++;
        }
    }

    public Selector reverseSelector() {
        return new ReverseSequenceSelector();
    }

    public static void main(String[] args) {
//        Sequence2 sequence = new Sequence2(10);
//        for(int i = 0; i < 10; i++)
//            sequence.add(new Word(Integer.toString(i)));
//        Selector selector = sequence.selector();
//        while(!selector.end()) {
//            System.out.print(selector.current() + " ");
//            selector.next();
//        }
//        Word w1 = new Word("Peace");
//        Word w2 = new Word("Love");
//        Word w3 = new Word("Easter");
//        Sequence2 message = new Sequence2(3);
//        message.add(w1);
//        message.add(w2);
//        message.add(w3);
//        Selector sel = message.selector();
//        while(!sel.end()) {
//            System.out.print(sel.current() + " ");
//            sel.next();
//        }
        //----Ex22----------------------------------------------------------------------------
        Sequence2 sequence2 = new Sequence2(10);
        for (int i = 0; i < 10; i++) {
            sequence2.add(new Word(Integer.toString(i)));
        }
        Selector selector1 = sequence2.reverseSelector();
        while (!selector1.end()) {
            System.out.print(selector1.current() + " ");
            selector1.next();
        }

    }
}