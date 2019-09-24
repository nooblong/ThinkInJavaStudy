package typeinfo;

import java.lang.reflect.Field;

public class ModifyingPrivateFields {
    public static void main(String[] args) throws Exception {
        WithPrivateFinalField pf = new WithPrivateFinalField();
        System.out.println(pf);
        Field f = pf.getClass().getDeclaredField("i");
        f.setAccessible(true);
        System.out.println("f.getInt(pf) " + f.getInt(pf));
    }
}

class WithPrivateFinalField{
    private int i = 1;
    private final String s = "I am totally safe";
    private String s2 = "Am I safe";
    public String toString(){
        return "i = " + i + ", " + s + ", " + s2;
    }
}