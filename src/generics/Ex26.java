package generics;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex26 {
    public static void main(String[] args) {
        Number[] numbers = new Integer[3];
        numbers[0] = new Integer(0);
        numbers[1] = new Integer(1);
        numbers[2] = new Integer(2);
        // Number abstract, cannot instantiate:
        // numbers[0] = new Number();
        try { // compile OK; runtime ArrayStoreException:
            numbers[1] = new Double(3.4);
        } catch (Exception e) {
            System.out.println(e);
        }
        for (Number n : numbers)
            System.out.println(n);
        // compile errors: incompatible types:
//         Integer[] ints = numbers;
        // for(Integer n : numbers)
        //	System.out.println(n);
        // even though runtime type is Integer:
        for (Number n : numbers)
            System.out.println(n.getClass().getSimpleName());

        List<? extends Number> nlist = new ArrayList<>();
        List<Number> num = new ArrayList<>();
//        nlist.add(new Integer(0));
        nlist.add(null);
        Number x = nlist.get(0);
        System.out.println(nlist);


        List<? extends Fruit> fruits = new ArrayList<Apple>();
//        fruits.add(new Apple());
//        fruits.add(new Fruit());



    }



}
class Jonathan extends Apple{}
class Fruit{}
class Apple extends Fruit{}
class Orange extends Fruit{}