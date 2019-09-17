package Exception;

class Rethrowing{
    public static void f() throws Exception{
        System.out.println("originating the exception in f()");
        throw new Exception("throw from f()");
    }
    public static void g() throws Exception{
        try{
            f();
        } catch (Exception e){
            System.out.println("Inside g(), e.printStackTrace()");
            throw e;
        }
    }
    public static void h() throws Exception{
        try {
            f();
        } catch (Exception e){
            System.out.println("Inside h(), e.printStackTrace()");
            throw (Exception)e.fillInStackTrace();
        }
    }
    public static void main(String args[]){
        try {
            g();
        } catch (Exception e){
            System.out.println("main: printStackTrace()");
            e.printStackTrace(System.out);
        }
        System.out.println("\n");
        try {
            h();
        } catch (Exception e){
            System.out.println("main: printStackTrace()");
            e.printStackTrace();
        }
    }
}
