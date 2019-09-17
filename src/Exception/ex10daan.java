package Exception;

class GException extends Exception {
    GException(String s) { super(s); }
}

class HException extends Exception {
    HException(String s) { super(s); }
}

public class ex10daan {
    static void f() {
        try {
            try {
                g();
            } catch(GException ge) {
                System.out.println("Caught GException in f inner try");
                ge.printStackTrace();
                throw new HException("from f(), inner try");
            }
        } catch(HException he) {
            System.out.println("Caught HException in f() outer try");
            he.printStackTrace(System.out);
        }
    }
    static void g() throws GException {
        throw new GException("from g()");
    }
    public static void main(String[] args) {
        f();
    }
}
