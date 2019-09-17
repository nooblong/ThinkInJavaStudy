package IOStream;

import java.io.*;

public class test1 {
    public static void main(String[] args) {
        StringBuffer s = new StringBuffer();
        File file = new File("AlwaysFinally.java");
        try {
            InputStream in = new FileInputStream(file);
            for (int i = 0; i < file.length(); i++) {
                s.append((char) in.read());
            }
            System.out.println(s);
            in.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
