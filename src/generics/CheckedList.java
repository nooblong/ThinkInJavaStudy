package generics;

import typeinfo.pets.*;
import java.util.*;

public class CheckedList {
    @SuppressWarnings("unchecked")
    static void oldStyleMethod(List probablyDogs){
        probablyDogs.add(new Cat());
    }

    public static void main(String[] args) {
        List<Dog> dogs1 = new ArrayList<>();
        oldStyleMethod(dogs1);
        List<Dog> dogs2 = Collections.checkedList(
                new ArrayList<>(),
        Dog.class);
        oldStyleMethod(dogs2);

        List<Pet> pets = Collections.checkedList(
                new ArrayList<>()
        , Pet.class);
        pets.add(new Dog());
        pets.add(new Cat());
    }
}
