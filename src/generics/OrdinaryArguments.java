package generics;

class Base{}
class Derived extends Base{}

public class OrdinaryArguments {
    void set(Base base){
        System.out.println("OrdinaryArguments.set(Base)");
    }
    void test(Derived d){

    }
}
class DerivedSetter extends OrdinaryArguments{
//    @Override
    void set(Derived derived) {
        System.out.println("DerivedSetter.set(Derived)");
    }

    void test(Base d) {

    }

    public static void main(String[] args) {
        Base base = new Base();
        Derived derived = new Derived();
        DerivedSetter derivedSetter = new DerivedSetter();
        derivedSetter.set(derived);
        derivedSetter.set(base);
    }
}
