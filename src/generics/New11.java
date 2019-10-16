package generics;

import net.mindview.util.New;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class A { public String toString(){return "A";}}
class B { public String toString(){return "B";}}
class C extends B { public String toString(){return "C";}}


public class New11 {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        List<C> lc = New.list();
        lc.add(new C());
        Map<A, List<? extends B>> mab = new HashMap<>();
        mab.put(a,lc);
    }
}
