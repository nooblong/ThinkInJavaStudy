package Generics.ex1;
class Automobile{}
public class Holder3 {
    public static void main(String[] args) {

    }
}
class holder2<T>{
    private T a;
    public holder2(T a){this.a = a;}
    public void setA(T a) {
        this.a = a;
    }

    public T get() {
        return a;
    }

    public static void main(String[] args) {
        holder2<Automobile> h = new holder2<Automobile>(new Automobile());
        Automobile a = h.get();
        //h.setA("Not an Automobile");
    }
}