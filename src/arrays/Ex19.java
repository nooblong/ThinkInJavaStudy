package arrays;

import java.util.Arrays;

class A {
    protected int x;

    A(int x) {
        this.x = x;
    }

    @Override
    public boolean equals(Object obj) {
        return obj.getClass().getSimpleName().equals("A") && this.x == ((A) obj).x;
    }
}

public class Ex19 {
    public static void main(String[] args) {
        A[] a1 = {new A(1), new A(2), new A(3)};
        A[] a2 = {new A(1), new A(2), new A(3)};
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
        System.out.println(Arrays.equals(a1, a2));
    }
}
