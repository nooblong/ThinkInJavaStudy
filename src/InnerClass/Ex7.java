package InnerClass;

public class Ex7 {
    private String s = "ggg";

    private String getGetS() {
        return s;
    }

    class Inner {
        private int i = 10;
        private int i2 = 20;
        void changeS(String s) {
            Ex7.this.s = s;
            i2 = 1;
        }
        private void showI2(){
            System.out.println(i2);
        }
    }

    public Inner inner() {
        return new Inner();
    }
    int oi = new Inner().i;
    void showOi(){
        System.out.println(oi);
    }
    void showIi2(){
        new Inner().showI2();
    }
    public static void main(String[] args) {
        Ex7 ex7 = new Ex7();
        Inner inner = ex7.inner();
        System.out.println(ex7.getGetS());
        inner.changeS("sss");
        System.out.println(ex7.getGetS());
        ex7.showOi();
        ex7.showIi2();
        inner.changeS("a");
        ex7.showIi2();
        System.out.println(ex7.getGetS());
    }
}
