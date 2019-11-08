package containers;

import net.mindview.util.*;

import java.util.Iterator;
import java.util.Map;

class Letters implements Generator<Pair<Integer,String >>, Iterable<Integer>{

    private int size = 9;
    private int number = 1;
    private char letter = 'A';

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return number < size;
            }

            @Override
            public Integer next() {
                return number++;
            }
        };
    }

    @Override
    public Pair<Integer, String> next() {
        return new Pair<>(number++, " " + letter++);
    }
}

public class MapDataTest{
    public static void main(String[] args) {
        System.out.println(MapData.map(new Letters(), 10));
        System.out.println(MapData.map(new CountingGenerator.Character(), new RandomGenerator.String(3), 8));
        System.out.println(MapData.map(new CountingGenerator.Character(), "value", 6));

    }
}