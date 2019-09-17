package HoldingYourObjects;

import net.mindview.util.TextFile;

import java.util.*;

public class Ex21 {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(new
                TextFile("test1.java", "\\W+"));
        System.out.println("WOrds to count " + words);
        Collections.sort(words, String.CASE_INSENSITIVE_ORDER);
        Map<String, Integer> wordCount =
                new LinkedHashMap<>();
        Iterator it = words.iterator();
        int totalWords = 0;
        while (it.hasNext()) {
            String s = (String) it.next();
            if (words.contains(s)) {
                Integer count = wordCount.get(s);
                wordCount.put(s,
                        count == null ? 1 : count + 1);
                totalWords++;
            }
        }
        System.out.println();
        System.out.println("world count" + wordCount);
        System.out.println("total " + totalWords);
    }
}
