package Exception;

public class ex4 {
    public static void f() throws MyE{
        System.out.println("f()");
        throw new MyE("nihaoa1");
    }
    public static void main(String[] args) {
        try{
            f();
        }catch (MyE m){
            m.getS();
        }
    }
}
class MyE extends Exception{
    String s;
    MyE(String s){
        super(s);
        System.out.println("MyE");
        this.s = s;
    }
    void getS(){
        System.out.println(s);
    }
}
