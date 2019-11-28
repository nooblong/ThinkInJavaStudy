package JavaIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class TransferTo {
    public static void main(String[] args) throws Exception {
        FileChannel in = new FileInputStream("test.txt").getChannel(),
                out = new FileOutputStream("data2.txt").getChannel();
        in.transferTo(0,in.size(), out);
    }
}
