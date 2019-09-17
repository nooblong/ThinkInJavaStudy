package Polymorphism.ex1;

class Instrument{
    public void play(Note n){
        System.out.println("Instrument.play()");
    }
}
class Wind extends Instrument{
    @Override
    public void play(Note n){
        System.out.println("Wind.play() " + n);
    }
}
class Music{
    public static void tune(Instrument i){
        i.play(Note.MIDDLE_C);
    }

    public static void main(String[] args) {
        Wind flute = new Wind();
        tune(flute);
        Instrument instrument = new Instrument();
        tune(instrument);
    }
}
class Stringed extends Instrument{
    public void play(Note n){
        System.out.println("Stringed.play() "+n);
    }
}
class Brass extends Instrument{
    public void play(Note n){
        System.out.println("Brass.play() "+n);
    }
}
 class Music2{
    public static void tune(Wind i){
        i.play(Note.MIDDLE_C);
    }
    public static void tune(Stringed i){
        i.play(Note.MIDDLE_C);
    }
    public static void tune(Brass i){
        i.play(Note.MIDDLE_C);
    }

     public static void main(String[] args) {
         Wind flute = new Wind();
         Stringed violin = new Stringed();
         Brass frenchHorn = new Brass();
         tune(flute);
         tune(violin);
         tune(frenchHorn);
     }
 }