package InnerClass;

public class ex5 {
    class T{
        public void print(){
            System.out.println("print");
        }
    }
}
class TestT{
    public static void main(String[] args) {
        ex5 e = new ex5();
        ex5.T test = e.new T();
        test.print();
    }
}
