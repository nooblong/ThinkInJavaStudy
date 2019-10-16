package typeinfo;

import java.lang.reflect.InvocationTargetException;

public class Ex8 {
    public static void Hierarchy(Object o) {
        if (o.getClass().getSuperclass() != null) {
            System.out.println(o.getClass().getSimpleName());
            try {
                Hierarchy(o.getClass().getSuperclass().getDeclaredConstructor().newInstance());
            } catch (InstantiationException e) {
                System.out.println("无法实例化");
            } catch (IllegalAccessException e) {
                System.out.println("Unable to access");
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Hierarchy(new C());
    }
}

class A {
}

class B extends A {
}

class C extends B {
}
