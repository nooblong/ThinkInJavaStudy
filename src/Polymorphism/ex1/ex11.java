package Polymorphism.ex1;

class Cycle{
    public void say(){
        System.out.println("cycle.say");
    }
    public void extend(){
        System.out.println("extend");
    }
    public int wheels(){
        return 4;
    }
}
class Unicycle extends Cycle{
    @Override
    public void say() {
        System.out.println("Unicycle.say");
    }
}
class Bicycle extends Cycle{
    @Override
    public void say() {
        System.out.println("Bicycle.say");
    }
    public void New(){
        System.out.println("Bicycle.new");
    }
}
class Tricycle extends Cycle{
    @Override
    public void say() {
        System.out.println("Tricycle.say");
    }
}
class main{
    static void ride(Cycle cycle){
        cycle.say();
        cycle.extend();
    }
    static void ridenew(Bicycle cycle){
        cycle.New();
    }
    public static void main(String[] args) {
        Unicycle unicycle = new Unicycle();
        Bicycle bicycle = new Bicycle();
        Tricycle tricycle = new Tricycle();
        ride(unicycle);
        ride(bicycle);
        ride(tricycle);
        ridenew(bicycle);
    }
}