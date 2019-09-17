package Polymorphism.ex3;
import Polymorphism.ex1.Note;

import java.text.Normalizer;

import static thinkprint.thinkprint.println;
class Instrument{
    void play(Note n){println("Instrument.play() " + n);}
    public String toString(){return "Instrument";}
    void adjust(){println("Adjusting Instrument");}
}
class Wind extends Instrument{
    void play(Note n){println("Wind.play() " + n);}
    public String toString(){return "Wind";}
    void adjust(){println("Adjusting Wind");}
}
class Percussion extends Instrument{
    void play(Note n){println("Percussion.play() " + n);}
    public String toString(){return "Percussion";}
    void adjust(){println("Adjusting Percussion");}
}
class Stringed extends Instrument{
    void play(Note n){println("Stringed.play() " + n);}
    public String toString(){return "Stringed";}
    void adjust(){println("Adjusting Stringed");}
}
class Brass extends Wind{
    void play(Note n){println("Brass.play() " + n);}
    void adjust(){println("Adjusting Brass");}
}
class Woodwind extends Wind{
    void play(Note n){println("Woodwind.play() " + n);}
    void adjust(){println("Adjusting Woodwind");}
}
class KeeBoard extends Instrument{
    void play(Note n){println("KeeBoard.play() " + n);}
    public String toString(){return "KeeBoard";}
    void adjust(){println("Adjusting KeeBoard");}
}
class Piano extends KeeBoard{
    void play(Note n){println("Piano.play() "+ n);}
    public String toString(){return "Piano";}
}