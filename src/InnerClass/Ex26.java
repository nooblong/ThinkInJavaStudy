package InnerClass;

class Outer26{
    Outer26(){
        System.out.println("Outer26()");
    }
    class Inner{
        Inner(String s){
            System.out.println("Inner()" + s);
        }
    }
}
class Test{
    Test(){
        System.out.println("Test()");
    }
    class InnerTest extends Outer26.Inner{

        InnerTest(String s, Outer26 outer26) {
            outer26.super(s);
            System.out.println("Test.InnerTest()");
        }
    }

    public static void main(String[] args) {
        Outer26 outer26 = new Outer26();
        Test test = new Test();
        InnerTest innerTest = test.new InnerTest("nihao", outer26);
    }
}
