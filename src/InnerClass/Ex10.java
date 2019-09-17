package InnerClass;

interface Ex10interface{
    void say(String s);
}
public class Ex10 {
    Ex10interface f(boolean b){
        if (b){
            class Inner implements Ex10interface{

                @Override
                public void say(String s) {
                    System.out.println(s);
                }
            }
            return new Inner();
        }
        return null;
    }

    public static void main(String[] args) {
        Ex10 ex10 = new Ex10();
        ex10.f(true).say("hi");
    }
}
