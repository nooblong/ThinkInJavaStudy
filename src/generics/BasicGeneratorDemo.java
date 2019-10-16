package generics;

import net.mindview.util.Generator;

public class BasicGeneratorDemo {
    public static void main(String[] args) {
//        Generator<CountedObject> gen = BasicGenerator.create(CountedObject.class);
        Generator<CountedObject> gen = new BasicGenerator<>(CountedObject.class);
        for (int i = 0; i < 10; i++) {
            System.out.println(gen.next());
        }
    }
}
