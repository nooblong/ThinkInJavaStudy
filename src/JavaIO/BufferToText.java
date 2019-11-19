package JavaIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BufferToText {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception {
        FileChannel fc = new FileOutputStream(new File("data2.txt")).getChannel();
        fc.write(ByteBuffer.wrap("Some text ".getBytes()));
        fc.close();
        fc = new FileInputStream("data2.txt").getChannel();
        ByteBuffer bf = ByteBuffer.allocate(BSIZE);
        fc.read(bf);
        bf.flip();
        System.out.println(bf.asCharBuffer());
        bf.rewind();
        System.out.println(bf);
    }
}
