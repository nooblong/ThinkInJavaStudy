package typeinfo;

import net.mindview.util.*;

interface Interface{
    void doSomething();
    void somethingElse(String arg);
}

class RealObject implements Interface{
    @Override
    public void doSomething() {
        System.out.println("do something");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);
    }
}

class SimpleProxy implements Interface{
    public static int num;
    private Interface proxied;
    public SimpleProxy(Interface proxied){
        this.proxied = proxied;
    }
    @Override
    public void doSomething() {
        System.out.println("SimpleProxy doSomething");
        proxied.doSomething();
        num++;
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("SimpleProxy someThing Else " + arg);
        proxied.somethingElse(arg);
    }
}

public class SimpleProxyDemo {
    public static void consumer(Interface iface){
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        for (int i = 0; i < 10; i++) {
            consumer(new SimpleProxy(new RealObject()));
        }
        System.out.println(SimpleProxy.num);
    }
}
