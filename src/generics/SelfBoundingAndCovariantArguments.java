package generics;

interface SelfBoundSetter<T extends SelfBoundSetter<T>>{
    void set(T arg);
}

interface Setter extends SelfBoundSetter<Setter>{

}

public class SelfBoundingAndCovariantArguments{
    void testA(Setter s1, Setter s2, SelfBoundSetter sbs){
        s1.set(s2);
//        s1.set(sbs);

    }
}

class GenericSetter<T>{
    void set(T arg){
        System.out.println("GenericSetter.set");
    }
}
class DerivedGS extends GenericSetter<Base>{
    void set(Derived derived){
        System.out.println("DerivedGs.set(Derived)");
    }
}
class Test{
    public static void main(String[] args) {
        Base base = new Base();
        Derived derived = new Derived();
        DerivedGS derivedGS = new DerivedGS();
        derivedGS.set(derived);
        derivedGS.set(base);
    }
}
