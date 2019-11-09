package containers;

import java.util.*;

import net.mindview.util.*;

public class Ex4 {
    static Collection<String> CollectFromText(String fileName) {
        String[] sa = TextFile.read(fileName).split(" ");
        return Arrays.asList(sa);
    }

    static Collection<String> CollectFromText2(String fileName) {
        String[] sa = TextFile.read(fileName).split(" ");
        return new TreeSet<String>(new TextFile(fileName, "\\W+"));
    }

    public static void main(String[] args) {
        System.out.println(CollectFromText("src/containers/Ex4.java"));
        System.out.println(CollectFromText2("src/containers/Ex4.java"));
    }
}
