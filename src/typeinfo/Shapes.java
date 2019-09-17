package typeinfo;

import java.util.Arrays;
import java.util.List;


class Rhomboid extends Shape{

    @Override
    public String toString() {
        return "Rhomboid";
    }
}



abstract class Shape {
    void draw(){
        System.out.println(this + ".draw()");
    }
    abstract public String toString();
}
class Circle extends Shape {
    @Override
    public String toString() {
        return "Circle";
    }
}
class Square extends Shape{

    @Override
    public String toString() {
        return "Square";
    }
}
class Triangle extends Shape{

    @Override
    public String toString() {
        return "Triangle";
    }
}

public class Shapes{
    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(
                new Circle(), new Square(), new Triangle()
        );
        for (Shape shape:shapeList){
            shape.draw();
        }

        Rhomboid rhomboid = new Rhomboid();
        ((Shape)rhomboid).draw();
//        ((Circle)rhomboid).draw();

    }
}
