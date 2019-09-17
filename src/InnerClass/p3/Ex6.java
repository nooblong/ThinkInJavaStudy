package InnerClass.p3;

import InnerClass.p1.Ex6Interface;
import InnerClass.p2.Ex6Base;

public class Ex6 extends Ex6Base {
    public Ex6Interface ex6Interface(){
        return this.new Ex6BaseInner();
    }

    public static void main(String[] args) {
        Ex6 ex = new Ex6();
        Ex6BaseInner ex6BaseInner = ex.new Ex6BaseInner();
        System.out.println(ex.ex6Interface().say());
        System.out.println(ex6BaseInner.say());
    }
}
