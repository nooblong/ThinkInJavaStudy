package generics;

public class Ex20 {

    public static  <T extends Interface> void f (T t){
        t.fun1();
        t.fun2();
    }

    public static void main(String[] args) {
        Cl cl = new Cl();
        f(cl);
    }
}

interface Interface{
    void fun1();
    void fun2();
}

class Cl implements Interface{

    @Override
    public void fun1() {
        System.out.println("fun1");
    }

    @Override
    public void fun2() {
        System.out.println("fun2");
    }

    public void fun3(){
        System.out.println("exact fun3");
    }
}