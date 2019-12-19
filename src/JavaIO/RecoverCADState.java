package JavaIO;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class RecoverCADState {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("CADState.out"));

//        List<Class<? extends Shape>> shapeTypes = (List<Class<? extends Shape>>)in.readObject();
        Line.deserializeStaticState(in);
        Square.deserializeStaticState(in);
        Circle.deserializeStaticState(in);
        List<Shape> shapes = (List<Shape>)in.readObject();
        System.out.println(shapes);
    }
}
