package InnerClass;

interface Ex13interface{
    String say(String s);
}
public class Ex13 {
    Ex13interface ex13interface(){
        return new Ex13interface() {
            @Override
            public String say(String s) {
                return s;
            }
        };
    }

    public static void main(String[] args) {
        Ex13 ex13 = new Ex13();
        String nihao = ex13.ex13interface().say("nihao");
        System.out.println(nihao);
    }
}
