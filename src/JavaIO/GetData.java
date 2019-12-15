package JavaIO;

import java.nio.ByteBuffer;

public class GetData {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        bb.put((byte)'c');
        bb.flip();
        System.out.println(bb.get());
        bb.clear();
        int i = 0;
        while (i++ < bb.limit()){
            if (bb.get() != 0)
                System.out.println("nonzero");
        }
        System.out.println("i = " + i);
        bb.rewind();
        bb.asCharBuffer().put("Howdy!");
        char c;
        while ((c = bb.getChar()) != 0){
            System.out.print(c + " ");
        }
        System.out.println();
        bb.rewind();
        bb.asShortBuffer().put((short)142);
        System.out.println(bb.getShort());
        bb.rewind();
        bb.asIntBuffer().put(99471142);
        System.out.println(bb.getInt());
        bb.rewind();

    }
}
