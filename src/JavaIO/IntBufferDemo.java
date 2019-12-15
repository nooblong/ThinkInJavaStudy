package JavaIO;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class IntBufferDemo {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        IntBuffer ib = bb.asIntBuffer();

        ib.put(new int[]{11,22,33,444,555,6666,7777});

        System.out.println(ib.get(3));

        ib.put(3,1811);

        ib.flip();

        while (ib.hasRemaining()){
            int i = ib.get();
            System.out.print(i + " ");
        }
    }
}
