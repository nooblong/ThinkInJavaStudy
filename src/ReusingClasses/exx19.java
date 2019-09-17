package ReusingClasses;

class WithFinal {
    final void f() { System.out.println("ReusingClasses.WithFinal.f()"); }
    void g() { System.out.println("ReusingClasses.WithFinal.g()"); }
    final void h() { System.out.println("WitFinal.h()"); }
}

class OverrideFinal extends WithFinal {
    // attempt to override:
    // public final void f() { System.out.println("ReusingClasses.OverrideFinal.f()"); } // no can do
    @Override public void g() { System.out.println("ReusingClasses.OverrideFinal.g()"); } // OK, not final
    // final void h(); { System.out.println("OVerrideFinal.h()"); } // cannot override final 	
}

public class exx19 {
    public static void main(String[] args) {
        OverrideFinal of = new OverrideFinal();
        of.f();
        of.g();
        of.h();
        // Upcast:
        WithFinal wf = of;
        wf.f();
        wf.g();
        wf.h();
    }
}