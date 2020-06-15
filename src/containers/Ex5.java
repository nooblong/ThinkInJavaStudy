package containers;

import java.util.*;

class CountingMapData5 extends AbstractMap<Integer, String> {
    private static String[] chars = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" ");

    private static Set<Map.Entry<Integer,String >> entries = new EntrySet(chars.length);

    @Override
    public Set<Map.Entry<Integer, String>> entrySet() {
        return entries;
    }

    static class Entry implements Map.Entry<Integer,String> {
        int index;
        Entry(int index) { this.index = index; }
        public boolean equals(Object o) {
            return Integer.valueOf(index).equals(o);
        }
        public Integer getKey() { return index; }
        public String getValue() {
            return chars[index % chars.length] + index / chars.length;
        }
        public String setValue(String value) {
            throw new UnsupportedOperationException();
        }
        public int hashCode() {
            return Integer.valueOf(index).hashCode();
        }
    }
    static class EntrySet extends AbstractSet<Map.Entry<Integer, String>>{
        private int size;

        EntrySet(int size){
            if (size<0)
                this.size = 0;
            else
                this.size = size;
        }

        public int size(){
            return size;
        }

        @Override
        public Iterator<Map.Entry<Integer, String>> iterator() {
            return new Iterator<Map.Entry<Integer, String>>() {
                private Entry entry = new Entry(-1);

                @Override
                public boolean hasNext() {
                    return entry.index < size() - 1;
                }

                @Override
                public Map.Entry<Integer, String> next() {
                    entry.index++;
                    return entry;
                }
            };
        }
    }

    static Map<Integer,String> select(final int size){
        return new CountingMapData5(){
            public Set<Map.Entry<Integer,String >> entrySet(){
                return new EntrySet(size);
            }
        };
    }

    public static void main(String[] args) {
        System.out.println(new CountingMapData5());
        System.out.println(select(40));
    }

}