package generics;

import typeinfo.pets.Cat;
import typeinfo.pets.Pet;

class Generic1<T>{
    T t;
    void f1(T t){
        this.t = t;
    }
}

class Generic2<T>{
    T t;
    T get(){
        return t;
    }

    static <T> void contra(Generic1<? super T> g1t, T t){
        g1t.f1(t);
    }

    static <T> T co(Generic2<? extends T> g2t){
        return g2t.get();
    }

    public static void main(String[] args) {
        contra(new Generic1<>(), new Cat("kitty"));
        co(new Generic2<Pet>());
    }
}
