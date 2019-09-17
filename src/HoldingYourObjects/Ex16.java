package HoldingYourObjects;

import net.mindview.util.*;

import java.util.*;

public class Ex16 {
    public static void vowelCounter(Set<String> st) {
        Set<Character> vowels = new TreeSet<>();
        Collections.addAll(vowels, 'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u');
        int allVowels = 0;
        for (String s : st){
            int count = 0;
            for (Character v : s.toCharArray()){
                if (vowels.contains(v)){
                    count++;
                    allVowels++;
                }
            }
            System.out.println(s + ": " + count + ", ");
        }
        System.out.println();
        System.out.println("Total vowels: " + allVowels);
    }

    public static void main(String[] args) {
        Set<String >words = new TreeSet<>(
                new TextFile("test.txt", "\\w+"));
        System.out.println(words);
        System.out.println();
        vowelCounter(words);
        Map<String, String> map = new TreeMap<>();
        map.put("nihao", "fuck");
        System.out.println(map.keySet());
    }
}
