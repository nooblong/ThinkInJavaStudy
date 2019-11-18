package JavaIO;

import java.io.*;

public class Redirecting {
    public static void main(String[] args) throws IOException {
        PrintStream console = System.out;
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("test.txt"));
        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("out.txt")));
        System.setIn(in);
        System.setOut(out);
        System.setErr(out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null){
            s = s.toUpperCase();
            System.out.println(s);
        }
        System.err.println("难道这就是你分手的借口");
        out.close();
        System.setOut(console);
    }
}
