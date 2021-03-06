package JavaIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class GetChannel {
    public static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception {
        FileChannel fc = new FileOutputStream("test.txt").getChannel();
        fc.write(ByteBuffer.wrap(("Some text " + "一些中文").getBytes(StandardCharsets.UTF_8)));
        fc.close();
        //add to end
        fc = new RandomAccessFile("test.txt", "rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("Some more".getBytes()));
        fc.close();
        //read
        fc = new FileInputStream("test.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        while (buff.hasRemaining())
            System.out.print((char)buff.get());

    }
}
