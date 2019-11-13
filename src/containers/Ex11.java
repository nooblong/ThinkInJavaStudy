package containers;

import java.util.PriorityQueue;
import java.util.Random;

class IntegerTest implements Comparable<IntegerTest>{
    Random r = new Random();
    Integer i = r.nextInt(100);
    @Override
    public int compareTo(IntegerTest integerTest) {
        int d = this.i - integerTest.i;
        return Integer.compare(d, 0);
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }
}

class Ex11{
    public static void main(String[] args) {
        PriorityQueue<IntegerTest> pt = new PriorityQueue<>();
        for (int i = 0; i < 20; i++) {
            pt.add(new IntegerTest());
        }
        int size = pt.size();
        for (int i = 0; i < size; i++) {
            System.out.print(pt.poll() + " ");
        }
    }
}