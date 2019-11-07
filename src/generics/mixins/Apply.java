package generics.mixins;

import java.lang.reflect.Method;
import java.util.*;

public class Apply {
    public static <T, S extends Iterable<? extends T>> void apply(S seq, Method method, Object... args) {
        try {
            for (T t : seq) {
                method.invoke(t, args);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class Shape{
    public void rotate(){
        System.out.println(this + " rotate");
    }
    public void resize(int newSize){
        System.out.println(this + " resize " + newSize);
    }
}
class Square extends Shape{

}
class FilledList<T> extends ArrayList<T>{
    public FilledList(Class<? extends T> type, int size){
        try {
            for (int i = 0; i < size; i++) {
                add(type.getDeclaredConstructor().newInstance());
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}

class ApplyTest{
    public static void main(String[] args) throws Exception {
        List<Shape> shapes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            shapes.add(new Shape());
        }
        Apply.apply(shapes, Shape.class.getMethod("rotate"));
        Apply.apply(shapes, Shape.class.getMethod("resize", int.class), 5);
        List<Square> squares = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            squares.add(new Square());
        }
        Apply.apply(squares, Shape.class.getMethod("rotate"));
        Apply.apply(squares, Shape.class.getMethod("resize", int.class), 5);
        Queue<Shape> shapeQ = new ArrayDeque<>();
        for (int i = 0; i < 5; i++) {
            shapeQ.add(new Shape());
            shapeQ.add(new Square());
        }
        Apply.apply(shapeQ, Shape.class.getMethod("rotate"));
        System.out.println("\n\n");
        SimpleQueue<Shape> shapes1 = new SimpleQueue<>();
        for (int i = 0; i < 5; i++) {
            shapes1.add(new Shape());
            shapes1.add(new Square());
        }
        Apply.apply(shapes1, Shape.class.getMethod("rotate"));

    }
}

class SimpleQueue<T> implements Iterable<T>{
    private LinkedList<T> storage = new LinkedList<>();
    public void add(T t){storage.offer(t);}
    public T get(){return storage.poll();}

    @Override
    public Iterator<T> iterator() {
        return storage.iterator();
    }
}
