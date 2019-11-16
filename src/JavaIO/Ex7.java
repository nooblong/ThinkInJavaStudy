package JavaIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Ex7 {
    public static String readAndReverse(String filename, List<String> find) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader(new File(filename)));
        String s;
        LinkedList<String> list = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        while ((s = in.readLine()) != null){
            List<String> line = Arrays.asList(s.split("\\W+"));
            if (!(Collections.disjoint(line, find)))
                list.add(s);
        }

        while (list.peekLast() != null)
            sb.append(list.pollLast() + "\n");
        in.close();
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(readAndReverse("test.txt", Arrays.asList("String")));
    }
}
