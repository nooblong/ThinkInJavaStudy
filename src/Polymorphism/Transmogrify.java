package Polymorphism;

class Actor{
    public void act(){}
}
class HappyActor extends Actor{
    public void act(){
        System.out.println("HappyActor");
    }
}
class SadActor extends Actor{
    @Override
    public void act() {
        System.out.println("SadActor");
    }
}
class Stage{
    private Actor actor = new HappyActor();
    public void change(){ actor = new SadActor();}
    public void performplay(){ actor.act();}
}
public class Transmogrify{
    public static void main(String[] args) {
        Stage stage = new Stage();
        stage.performplay();
        stage.change();
        stage.performplay();
    }
}