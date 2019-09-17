package InnerClass;

abstract class Base{
    public Base(int i){
        System.out.println("Base construcotr, i = " + i);
    }
    public abstract void f();
}
public class AnonymousConstructor {
    public static Base getBase(int i){
        return new Base(i) {
            {
                System.out.println("inside instance initializer");
            }
            @Override
            public void f() {
                System.out.println("In Anony f()");
            }
        };
    }

    public static void main(String[] args) {
        getBase(10).f();
    }
}
