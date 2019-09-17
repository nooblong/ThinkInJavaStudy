package Exception;

public class ex10{}
class A {
    void f() {
        try {
            try {
                g();
            } catch (E1 e) {
                e.printStackTrace();
                throw new E2("from f()");
            }
        } catch (E2 e){
            System.out.println("E2");
            RuntimeException r = new RuntimeException();
            r.initCause(e);
            throw r;
        }
    }

    void g() throws E1 {
        throw new E1("from g()");
    }

    public static void main(String[] args) {
        A a = new A();
        a.f();
    }
}

class E1 extends Exception {
    E1(String s) {
        super(s);
    }
}

class E2 extends Exception {
    E2(String s){
        super(s);
    }
}