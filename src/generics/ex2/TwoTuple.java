package generics.ex2;

public class TwoTuple<A,B> {
    public final A first;
    public final B second;
    public TwoTuple(A a, B b){ first = a; second = b;}
    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";

    }

    public static void main(String[] args) {
        String s1="a111";
        String s2="b222";
        TwoTuple<String,String> a = new TwoTuple<>(s1,s2);
        System.out.println(a);
    }
}
