package generics.ex2;

class Amphibian {
}

class Vehicle {
}

public class TupleTest {
    static TwoTuple<String, Integer> f() {
        //autoboxing converts the int to Integer
//        return new TwoTuple<>("hi", 47);
        return Tuple.tuple("hi",47);
    }
    static TwoTuple f2(){
        return Tuple.tuple("hi",47);
    }

    static ThreeTuple<Amphibian, String, Integer> g() {
//        return new ThreeTuple<>(new Amphibian(), "hi", 47);
        return Tuple.tuple(new Amphibian(), "hi", 47);
    }

    static FourTuple<Vehicle, Amphibian, String, Integer> h() {
//        return new FourTuple<>(new Vehicle(), new Amphibian(), "hi", 47);
        return Tuple.tuple(new Vehicle(), new Amphibian(), "hi", 47);
    }

    static FiveTuple<Vehicle, Amphibian, String, Integer, Double> k() {
//        return new FiveTuple<>(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
        return Tuple.tuple(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
    }

    static SixTuple<Vehicle, Amphibian, String, Integer, Double, Character> j() {
        return new SixTuple<>(new Vehicle(), new Amphibian(), "hi", 47, 11.1, 'a');
//        return Tuple.tuple()
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer> ttsi = f();
        TwoTuple<String, Integer> ttsi2 = f2();
        System.out.println(f2());
        System.out.println(ttsi);
        //ttsi.first = "there";
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
        System.out.println(j());
    }
}
