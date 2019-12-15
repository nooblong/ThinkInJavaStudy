package JavaIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class BufferToText {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception {
        FileChannel fc = new FileOutputStream(new File("data2.txt")).getChannel();
        fc.write(ByteBuffer.wrap("Some text Some 中文".getBytes()));
        fc.close();
        fc = new FileInputStream("data2.txt").getChannel();
        ByteBuffer bf = ByteBuffer.allocate(BSIZE);
        fc.read(bf);
        bf.flip();
        System.out.println(bf.asCharBuffer());
        bf.rewind();
        String encoding = System.getProperty("file.encoding");
        System.out.println("decoded using " + encoding + ": " + Charset.forName(encoding).decode(bf));
        System.out.println(bf);

        fc = new FileOutputStream("data2.txt").getChannel();
        bf = ByteBuffer.allocate(4);
        fc.write(ByteBuffer.wrap("Some text哈哈".getBytes("UTF-16BE")));
        fc.close();
        fc = new FileInputStream("data2.txt").getChannel();
        bf.clear();
        fc.read(bf);
        bf.flip();
        System.out.println(bf.asCharBuffer());
    }
}
