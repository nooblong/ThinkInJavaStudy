package Junit;

public class CalTest {
    public static void main(String[] args) {
        Calaulator c = new Calaulator();
        int result = c.add(1, 2);
        System.out.println(result);

        int result2 = c.sub(1, 1);
        System.out.println(result2);

    }
}
