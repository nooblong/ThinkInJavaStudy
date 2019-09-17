package InnerClass;

class Outer{
    private String s = "hello";
    class Inner{
        public void f1(){
            System.out.println("Inner");
        }

        @Override
        public String toString() {
            return s;
        }
    }
    public Inner f(){
        return new Inner();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        Inner i = outer.f();
        i.f1();
        System.out.println(i);
    }
}