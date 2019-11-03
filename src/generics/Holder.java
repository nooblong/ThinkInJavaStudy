package generics;

import java.util.List;

public class Holder<T> {
    private T value;
    Holder(){}
    Holder(T val){
        value = val;
    }
    void set(T val){
        value = val;
    }
    T get(){
        return value;
    }
    public boolean equals(Object obj){
        return value.equals(obj);
    }

    public static void main(String[] args) {
        Holder<Apple> apple = new Holder<>(new Apple());
        Apple d = apple.get();
        apple.set(d);
//        Holder<Fruit> fruit = apple;
        Holder<? extends Fruit> fruit = apple;
        Fruit p = fruit.get();
        d = (Apple)fruit.get();
        try {
            Orange c = (Orange)fruit.get();
        } catch (Exception e){
            System.out.println(e);
        }
//        fruit.set(new Apple());
        System.out.println(fruit.equals(d));

    }
    static void writTo(List<? super Apple> apples){
        apples.add(new Apple());
//        apples.add(new Fruit());
//        apples.add(new Orange());
        apples.add(new Jonathan());
    }
}
