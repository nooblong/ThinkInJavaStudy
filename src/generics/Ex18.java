package generics;

import net.mindview.util.Generator;

import java.util.*;

//Ocean中BigFish吃LittleFish
public class Ex18 {
}

class BigFish {
    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return "big fish " + id;
    }

    public static Generator<BigFish> generator() {
        return new Generator<BigFish>() {
            @Override
            public BigFish next() {
                return new BigFish();
            }
        };
    }
}

class LittleFish {
    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return "little fish " + id;
    }

    public static Generator<LittleFish> generator() {
        return new Generator<LittleFish>() {
            @Override
            public LittleFish next() {
                return new LittleFish();
            }
        };
    }
}

class Ocean {
    public static void eating(LittleFish littleFish, BigFish bigFish) {
        System.out.println(bigFish + " eat " + littleFish);
    }

    public static void main(String[] args) {
        Random random = new Random(77);
        Queue<LittleFish> littleFish = new LinkedList<>();
        List<BigFish> bigFish = new ArrayList<>();
        Generators.fill(littleFish, LittleFish.generator(), 20);
        Generators.fill(bigFish, BigFish.generator(), 3);
        for (LittleFish fish : littleFish) {
            eating(fish, bigFish.get(random.nextInt(bigFish.size())));
        }
    }
}