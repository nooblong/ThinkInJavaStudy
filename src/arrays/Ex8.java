package arrays;

import java.util.Arrays;

public class Ex8<T> {
    T[] a = (T[])new Object[2];

    public static void main(String[] args) {
        String[] sa = new String[2];
//        sa[0] = new Integer(0);
        Object[] oa = new Object[3];
        oa = sa;
//        oa[0] = 3;

        BerylliumSphere[] bsa1 = new BerylliumSphere[3];
        for(int i = 0; i < bsa1.length; i++)
            bsa1[i] = new BerylliumSphere();
        // Arrays.fill(bsa1, new BerylliumSphere());
        System.out.println(Arrays.toString(bsa1));
        BerylliumSphere[] bsa2 = new BerylliumSphere[4];
        System.out.println(Arrays.toString(bsa2));
        System.arraycopy(bsa1, 0, bsa2, 0, bsa1.length);
        bsa1[0].i = 2;
        System.out.println(Arrays.toString(bsa2));
        System.out.println(bsa2[0].i);
        // no new BerylliumSpheres created in bsa2,
        // just new references to those in bsa1
    }

    private static class BerylliumSphere {
        public int i = 1;
    }
}
