package JavaIO;

import java.io.*;

public class FormattedMemoryInput {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new ByteArrayInputStream(BufferedInputFile.read("test.txt").getBytes()));
        while (true)
            System.out.print((char)in.readByte());
    }
}

class TestEOF{
    public static void main(String[] args) throws Exception {
        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("test.txt")));
        while (in.available() != 0){
            System.out.print((char)in.readByte());
        }
    }
}
