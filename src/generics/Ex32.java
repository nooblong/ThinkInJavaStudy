package generics;

class FixedSizeStack<T> {
    private int index = 0;
    private Object[] storage;
    FixedSizeStack(int size) {
        storage = new Object[size];
    }
    int getIndex() { return index; }
    void push(T item) { storage[index++] = item; }
    T pop() { return (T)storage[--index]; }
}

class GenericCast32 {
    private static final int SIZE = 10;
    public static void main(String[] args) {
        FixedSizeStack<String> strings =
                new FixedSizeStack<>(SIZE);
        for(String s : "A B C D E F G H I J".split(" "))
            strings.push(s);
        // Runtime ArrayIndexOutOfBoundsException:
         strings.push("oops"); // Bounds-checking required:
        if(strings.getIndex() < SIZE) strings.push("oops");
        for(int i = 0; i < SIZE; i++) {
            String s = strings.pop();
            System.out.print(s + " ");
        }
    }

}
