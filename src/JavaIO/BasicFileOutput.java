package JavaIO;

import java.io.*;

public class BasicFileOutput {
    static String file = "out.txt";
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read("test.txt")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null){
            out.println(lineCount++ + ": " + s);
        }
        out.close();
        System.out.println(BufferedInputFile.read(file));
    }
}

//class FileOutputShortcut{
//    public static void main(String[] args) throws Exception {
//        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read("test.txt")));
//        PrintWriter out = new PrintWriter(BasicFileOutput.file);
//        int lineCount = 1;
//        String s;
//        while ((s = in.readLine())!=null)
//            out.println(lineCount++ + ": " + s);
//        out.close();
//        System.out.println(BufferedInputFile.read(BufferedInputFile.read("test.txt")));
//    }
//}
