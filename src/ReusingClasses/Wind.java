package ReusingClasses;

class Amphibian{
    void A(){
        System.out.println("ReusingClasses.Amphibian A");
    }
    protected void speak(){
        System.out.println("ReusingClasses.Amphibian speak");
    }
    static void grow(Amphibian amphibian){
        System.out.println("Ammphibian grow");
        amphibian.A();
        amphibian.speak();
    }
}
class Frog extends Amphibian{
    @Override
    public void A(){
        System.out.println("ReusingClasses.Frog B");
    }

    @Override
    protected void speak() {
        System.out.println("ReusingClasses.Frog speak");
    }
    static void grow(Amphibian amphibian){
        System.out.println("ReusingClasses.Frog grow");
        amphibian.speak();
    }

    public static void main(String[] args) {
        Frog frog = new Frog();
        frog.A();
        frog.speak();
        Amphibian.grow(frog);
    }
}