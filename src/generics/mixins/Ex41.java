package generics.mixins;

import generics.coffee.Coffee;
import generics.coffee.Latte;
import generics.coffee.Mocha;
import net.mindview.util.Generator;
import typeinfo.pets.Cymric;
import typeinfo.pets.Dog;
import typeinfo.pets.Hamster;
import typeinfo.pets.Pet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class Fill41 {
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

class Fill41Test {
    public static void main(String[] args) {
        List<Pet> pets = new ArrayList<>();
        Fill41.fill(new AddableCollectionAdapter<>(pets),
                Dog.class, 3);
        Fill41.fill(Adapter.collectionAdapter(pets),
                Cymric.class, 2);
        for (Pet p : pets){
            System.out.println(p);
        }
        System.out.println("-------------------");
        AddableSimpleQueue<Pet> petAddableSimpleQueue =
                new AddableSimpleQueue<>();
        Fill41.fill(petAddableSimpleQueue,
                Pet.class, 4);
        Fill41.fill(petAddableSimpleQueue, Hamster.class, 1);
        for (Pet c : petAddableSimpleQueue){
            System.out.println(c);
        }
    }
}