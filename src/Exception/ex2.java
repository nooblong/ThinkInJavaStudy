package Exception;

public class ex2 {
    public static void main(String[] args) {
        try {
            Integer a = null;
            Integer b = null;
            b.shortValue();
            a.shortValue();
        }catch (NullPointerException a){
            a.printStackTrace(System.out);
        }
    }
}
