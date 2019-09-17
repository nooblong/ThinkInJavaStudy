package Polymorphism;

class Glyph{
    void draw(){
        System.out.println("Glyph.draw()");
    }
    Glyph(){
        System.out.println("Glyph() before draw");
        draw();
        System.out.println("Glyph() after draw");
    }
}
class RoundGlyph extends Glyph{
    private int radius = 1;
    RoundGlyph(int r){
        radius = r;
        System.out.println("RoundGlyph.RoundGlyph(), radius = "+radius);
    }
    void draw(){
        System.out.println("RoundGlyph.draw(), radius = "+radius);
    }
}
class RectangluarGlyph extends Glyph{
    int i;
    RectangluarGlyph(){
        i = 1;
        draw();
    }
    @Override
    void draw() {
        System.out.println("Rect.draw" + i);
    }
}
public class polyConstructors{
    public static void main(String[] args) {
        RectangluarGlyph a = new RectangluarGlyph();
        a.draw();
    }
}