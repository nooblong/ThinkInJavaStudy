package Exception;

public class ex8 {
    public static void main(String[] args) {
        try {
            Test8 t = new Test8();
            t.f();
            System.out.println("nininini");
        } catch (Exception4 e) {
            System.err.println("Caught Exception4");
            e.printStackTrace();
            e.showS();
        } catch (Exception e){
            System.out.println("diunie");
        }
    }
}

class Exception4 extends Exception {
    private String msg;

    Exception4(String msg) {
        super(msg);
        System.out.println("Exception4()");
        this.msg = msg;
    }

    protected void showS() {
        System.out.println("Message from Exception4: " + msg);
    }
}

class Test8 {
    public static void f() throws Exception4, MyException2 {
        System.out.println("f()");
        if (false)
            throw new Exception4("Ouch from f()");
        else
            throw new MyException2();
    }
}