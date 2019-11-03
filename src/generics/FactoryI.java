package generics;

public interface FactoryI<T> {
    T create(Integer i);
}

class Foo2<T> {
    private T x;

    public <F extends FactoryI<T>> Foo2(F factory, Integer i) {
        x = factory.create(i);
    }

    void get(){
        System.out.println(x);
    }
}

class IntegerFactory implements FactoryI<Integer> {
    @Override
    public Integer create(Integer i) {
        return i;
    }
}

class Widget {
    private int i;
    public static class Factory implements FactoryI<Widget>{
        @Override
        public Widget create(Integer i) {
            Widget widget = new Widget();
            widget.i = i;
            return widget;
        }
    }
}

class FactoryConstraint{
    public static void main(String[] args) {
        new Foo2<>(new IntegerFactory(),1).get();
        new Foo2<>(new Widget.Factory(),2).get();
    }
}
