package generics;

import generics.ex2.FourTuple;

import java.util.ArrayList;

public class TupleList<A,B,C,D> extends ArrayList<FourTuple<A,B,C,D>> {
    public static void main(String[] args) {
        TupleList<String, Integer, String, Integer> t1 = new TupleList<>();

    }
}
