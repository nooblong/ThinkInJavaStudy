package Exception;

public class ex3 {
    private static int[] ia = new int[2];
    public static void main(String[] args) {
        try {
            ia[2] = 3;
        } catch(ArrayIndexOutOfBoundsException e) {
            System.err.println(
                    "Caught ArrayIndexOutOfBoundsException");
            e.printStackTrace();
        }
    }
}
