package Polymorphism.ex3;
import Polymorphism.ex1.Note;

import java.util.Random;

public class Music3 {
    public static void tune(Instrument i) {
        i.play(Note.MIDDLE_C);
        i.adjust();
    }
    public static void tuneAll(Instrument[] e){
        for(Instrument i : e){
            tune(i);
        }
    }
    public static void main(String[] args) {
        Instrument[] orchestra = new Instrument[8];
        RandNew rand = new RandNew();
        for (int i = 0; i < orchestra.length; i++) {
            orchestra[i] = rand.next();
        }
        //tuneAll(orchestra);
        for(Object i : orchestra){
            System.out.println(i);
        }
    }
}
class RandNew{
    private Random random = new Random(37);
    public Instrument next(){
        switch (random.nextInt(6)){
            case 0: return new Piano();
            case 1: return new KeeBoard();
            case 2: return new Wind();
            case 3: return new Brass();
            case 4: return new Percussion();
            case 5: return new Stringed();
            case 6: return new Woodwind();
            default: return new Instrument();
        }
    }
}
