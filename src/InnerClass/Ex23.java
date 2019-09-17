package InnerClass;

interface U{
    void f1();
    void f2();
    void f3();
    String toString();
}

class A{
    public U getU(){
        return new U() {
            @Override
            public void f1() {
                System.out.println("A U f1()");
            }

            @Override
            public void f2() {
                System.out.println("A U f2()");
            }

            @Override
            public void f3() {
                System.out.println("A U f3()");
            }

            @Override
            public String toString(){
                return "I am a U";
            }
        };
    }
}
class B{
    private U[] us;
    int i;
    B(int i){
        us = new U[i];
        this.i = i;
    }
    void saveU(U u, int i){
        us[i] = u;
    }
    void testU(){
        for (int j = 0; j < i; j++) {
            System.out.println("us["+j+"]");
            us[j].f1();
            us[j].f2();
            us[j].f3();
        }
    }
    void showU(){
        for (U u : us){
            if (u != null)
                System.out.println(u.toString());
            else
                System.out.println("I am null");
        }
    }
    void delU(int i){
        us[i] = null;
    }

    public static void main(String[] args) {
        A[] as = new A[10];
        for (int i = 0; i < as.length; i++) {
            as[i] = new A();
        }
        B b = new B(10);
        for (int i = 0; i < as.length; i++) {
            b.saveU(as[i].getU(), i);
        }
        b.showU();
        b.testU();
//        for (int i = 0; i < 10; i++) {
//            b.saveU(as[i].getU(),i);
//        }
//        b.testU();

    }
}