package JavaIO;

import java.io.StringReader;

public class MemoryInput {
    public static void main(String[] args) throws Exception {
        StringReader in = new StringReader(BufferedInputFile.read("test.txt"));
        int c;
        while ((c = in.read()) != -1)
            System.out.print((char)c );
    }
}
