package Polymorphism.ex2;

import Polymorphism.rodent.RandomRodentGenerator;

import java.util.Iterator;
import java.util.Random;

class Shape{
    public void draw(){}
    public void erase(){}
}
class Circle extends Shape{
    @Override
    public void draw() {
        System.out.println("Circle.draw()");
    }
    @Override
    public void erase() {
        System.out.println("Circle.erase");
    }
}
class Square extends Shape{
    @Override
    public void draw() {
        System.out.println("Square.draw()");
    }
    @Override
    public void erase() {
        System.out.println("Square.erase");
    }
}
class Ttriangle extends Shape{
    @Override
    public void draw() {
        System.out.println("Ttriangle.draw()");
    }
    @Override
    public void erase() {
        System.out.println("Ttriangle.erase");
    }
}
class RandomShapeGenerator implements Iterable<Shape> {
    private Random rand = new Random(478);
    public Shape next(){
        switch (rand.nextInt(3)){
            default:
            case 0: return new Circle();
            case 1: return new Square();
            case 2: return new Ttriangle();
        }
    }
    private Shape[] shapes;
    RandomShapeGenerator(int n){
        shapes = new Shape[n];
        for (int i = 0; i < n; i++) {
            shapes[i] = next();
        }
    }
    @Override
    public Iterator<Shape> iterator() {
        return new Iterator<Shape>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < shapes.length;
            }

            @Override
            public Shape next() {
                return shapes[index++];
            }
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }
}
class Shapes{
    private static RandomShapeGenerator gen = new RandomShapeGenerator(10);

    public static void main(String[] args) {
        for (Shape ss : gen){
            ss.draw();
        }
    }
}