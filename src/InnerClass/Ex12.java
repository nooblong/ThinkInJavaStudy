package InnerClass;

interface Ex12Inner{
    void modifyOutor();
}
public class Ex12 {
    private String s = "ggg";
    private int oi = 1;
    private String getGetS() {
        return s;
    }
    private void hi(){
        System.out.println("Outer hi");
    }
//    class Inner {
//        private int i = 10;
//        private int i2 = 20;
//
//        void changeS(String s) {
//            Ex12.this.s = s;
//            i2 = 1;
//        }
//
//        private void showI2() {
//            System.out.println(i2);
//        }
//    }

    public Ex12Inner inner() {
        return new Ex12Inner(){
            @Override
            public void modifyOutor() {
                oi *= 2;
                hi();
            }

        };
    }

    void showOi() {
        System.out.println(oi);
    }

    public static void main(String[] args) {
        Ex12 ex12 = new Ex12();
        ex12.showOi();
        ex12.inner().modifyOutor();
        ex12.showOi();
    }
}
