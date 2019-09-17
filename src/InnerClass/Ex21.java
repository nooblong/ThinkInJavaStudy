package InnerClass;

interface In{
    String f();
    String g();
    class Nested{
        static void testIn(In i){
            System.out.println(i.f() + i.g());
        }
    }
}
public class Ex21 implements In{

    @Override
    public String f() {
        return "Hello ";
    }

    @Override
    public String g() {
        return "friend";
    }

    public static void main(String[] args) {
        Ex21 ex21 = new Ex21();
        In.Nested.testIn(ex21);
    }
}