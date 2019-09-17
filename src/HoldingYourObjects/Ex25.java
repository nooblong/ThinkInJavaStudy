package HoldingYourObjects;

import net.mindview.util.TextFile;

import java.util.*;

public class Ex25 {
    public static void main(String[] args) {
        Map<String,ArrayList<Integer>> m =
                new LinkedHashMap<>();
        List<String> words = new LinkedList<>();
        words.addAll(new TextFile("test1.java","\\W+"));
        System.out.println("Words in file: " + words);
        Iterator itWords = words.iterator();
        int count = 0;
        while(itWords.hasNext()) {
            String s = (String)itWords.next();
            count++;
            if(!m.keySet().contains(s)) {
                ArrayList<Integer> ai =
                        new ArrayList<Integer>();
                ai.add(0, count);
                m.put(s, ai);
            }
            else {
                m.get(s).add(count);
                m.put(s, m.get(s));
            }
        }
        System.out.println("Map of word locations: " + m);
        Map<Integer,String> replay = new TreeMap<>();
        //获得m的迭代器
        Iterator<Map.Entry<String,ArrayList<Integer>>> it =
                m.entrySet().iterator();
        //
        while(it.hasNext()){
            Map.Entry<String,ArrayList<Integer>> me = it.next();
            for (int i = 0; i < me.getValue().size();//出现的次数
                 i++) {
                //利用TreeMap的特性，把后面的数据提取放到key中，对应的放到value中
                replay.put(me.getValue().get(i),me.getKey());
            }
        }
        System.out.println();
        System.out.println("TreeMap of ordered locations  "+ replay.values()
        );

    }
}
