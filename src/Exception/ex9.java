package Exception;

public class ex9 {
    public static void f(int x) throws N1, N2, N3 {
        if (x < 0) throw new N1("x<0");
        if (x == 0) throw new N2("x==0");
        if (x > 0) throw new N3("x>0");
    }

    public static void main(String[] args) {
        for (int i = -1; i < 2; i++) {
            try {
                f(i);
            } catch (Exception e) {
                System.out.println("Caught Exception");
                e.printStackTrace();
                StackTraceElement[] b = e.getStackTrace();
                for (StackTraceElement a:b) {
                    System.out.println(a.getMethodName());
                }
            }
        }
    }
}

class N1 extends Exception {
    N1(String msg) {
        super(msg);
    }
}

class N2 extends Exception {
    N2(String msg) {
        super(msg);
    }
}

class N3 extends Exception {
    N3(String msg) {
        super(msg);
    }
}
