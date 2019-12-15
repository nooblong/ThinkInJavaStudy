package JavaIO;

import java.nio.CharBuffer;

public class Ex23 {
    public static void printCharBuffer(CharBuffer charBuffer){
        charBuffer.clear();
        while (charBuffer.hasRemaining()){
            char c = charBuffer.get();
            if (c >= '!' && c <= '~')
                System.out.print(c);
        }
    }

    public static void main(String[] args) {
        char[] ca = {'w','x','y','z'};
        CharBuffer cb = CharBuffer.wrap(ca);
        printCharBuffer(cb);
    }
}
