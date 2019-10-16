package generics;

import net.mindview.util.New;

public class GenericMethods {
    public <T,U,V> void f(T x, U u, Integer integer){
        System.out.println(x.getClass().getName());
        System.out.println(u.getClass().getName());
        System.out.println(integer.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods genericMethods = new GenericMethods();
        genericMethods.f(" ", 1, 1);


    }
}
