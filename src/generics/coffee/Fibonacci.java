package generics.coffee;

import net.mindview.util.Generator;

import java.util.Iterator;

public class Fibonacci implements Generator<Integer>, Iterable<Integer> {
    private int count = 0;
    private int m = 0;
    @Override
    public Integer next() {
        return fib(count++);
    }
    private int fib(int n){
        if (n < 2)
            return 1;
        return fib(n-2) + fib(n-1);
    }
    public Fibonacci(){}
    public Fibonacci(int m){
        this.m = m;
    }

    public static void main(String[] args) {
        Fibonacci gen = new Fibonacci();
        for (int i = 0; i < 18; i++) {
            System.out.print(gen.next() + " ");
        }
        System.out.println();
        Iterator it = new Fibonacci(20).iterator();
        while (it.hasNext())
            System.out.print(it.next() + " ");
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return m > 0;
            }

            @Override
            public Integer next() {
                m--;
                return Fibonacci.this.next();
            }
            public void remove() { // Not implemented
                throw new UnsupportedOperationException();
            }
        };
    }
}
