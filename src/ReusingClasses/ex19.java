package ReusingClasses;

class WithFinals{
    private final void f(){
        System.out.println("withfinals.f()");
    }
    final private void g(){
        System.out.println("withFinals.g()");
    }
}
class OverridingPrivate extends WithFinals{
    private final void f(){
        System.out.println("ReusingClasses.OverridingPrivate.f()");
    }
    private void g(){
        System.out.println("ReusingClasses.OverridingPrivate.g()");
    }
}
class OverridingPrivate2 extends OverridingPrivate{
    public final void f(){
        System.out.println("ReusingClasses.OverridingPrivate2.f()");
    }

    public void g(){
        System.out.println("ReusingClasses.OverridingPrivate2.g()");
    }
}
public class ex19{
    public static void main(String[] args) {
        OverridingPrivate2 op2 = new OverridingPrivate2();
        op2.f();
        op2.g();
        OverridingPrivate op = op2;
        //op.f();Error:(31, 11) java: f() 在 ReusingClasses.OverridingPrivate 中是 private 访问控制
        //op.g();
        WithFinals wf = op2;
        //wf.f();Error:(34, 11) java: f() 在 ReusingClasses.WithFinals 中是 private 访问控制
        //wf.g();
    }
}
