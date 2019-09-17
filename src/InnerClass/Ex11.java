package InnerClass;


interface Ex11Interface {
    void say();
}

public class Ex11 {
    private class Inner implements Ex11Interface{

        @Override
        public void say() {
            System.out.println("hello");
        }
    }
    Ex11Interface re(){
        return new Inner();
    }

    public static void main(String[] args) {
        Ex11 ex11 = new Ex11();
        Ex11Interface inner = ex11.re();
        inner.say();
//        (Inner)inner.say();
    }
}
