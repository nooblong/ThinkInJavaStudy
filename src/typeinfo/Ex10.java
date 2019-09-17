package typeinfo;

public class Ex10 {
    public static void main(String[] args) {
        char[] c = new char[10];
        System.out.println("super class of char[] c: " +
        c.getClass().getSuperclass());
        System.out.println("instance of Object : " + (c instanceof Object));
    }
}
