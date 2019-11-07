package generics.mixins;

import generics.coffee.Coffee;
import generics.coffee.Latte;
import generics.coffee.Mocha;
import net.mindview.util.Generator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

interface Addable<T> {
    void add(T t);
}

class Fill2 {
    public static <T> void fill(Addable<T> addable,
                                Class<? extends T> classToken,
                                int size) {
        for (int i = 0; i < size; i++) {
            try {
                addable.add(classToken.getDeclaredConstructor().newInstance());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static <T> void fill(Addable<T> addable,
                                Generator<T> generator,
                                int size) {
        for (int i = 0; i < size; i++) {
            addable.add(generator.next());
        }
    }
}

class AddableCollectionAdapter<T> implements Addable<T> {
    private Collection<T> c;

    public AddableCollectionAdapter(Collection<T> c) {
        this.c = c;
    }

    @Override
    public void add(T t) {
        c.add(t);
    }
}

class Adapter {
    public static <T> Addable<T> collectionAdapter(Collection<T> c) {
        return new AddableCollectionAdapter<>(c);
    }
}

class AddableSimpleQueue<T> extends SimpleQueue<T> implements Addable<T> {
    public void add(T item) {
        super.add(item);
    }
}

class Fill2Test {
    public static void main(String[] args) {
        List<Coffee> carrier = new ArrayList<>();
        Fill2.fill(new AddableCollectionAdapter<>(carrier),
                Coffee.class, 3);
        Fill2.fill(Adapter.collectionAdapter(carrier),
                Latte.class, 2);
        for (Coffee c : carrier){
            System.out.println(c);
        }
        System.out.println("-------------------");
        AddableSimpleQueue<Coffee> coffeeAddableSimpleQueue =
                new AddableSimpleQueue<>();
        Fill2.fill(coffeeAddableSimpleQueue,
                Mocha.class, 4);
        Fill2.fill(coffeeAddableSimpleQueue, Latte.class, 1);
        for (Coffee c : coffeeAddableSimpleQueue){
            System.out.println(c);
        }
    }
}