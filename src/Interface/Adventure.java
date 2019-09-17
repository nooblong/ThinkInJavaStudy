package Interface;

public class Adventure {
    public static void t(CanFight x){x.fight();}
    public static void u(CanSwim x){x.swim();}
    public static void v(CanFly x){x.fly();}
    public static void m(ActionCharacter x){x.fight();}
    public static void main(String[] args) {
        Hero h = new Hero();
        t(h);
        h.climb();
    }
}
interface CanClimb{
    void climb();
}
interface CanFight{
    void fight();
}
interface CanSwim{
    void swim();
}
interface CanFly{
    void fly();
}
class ActionCharacter{
    public void fight(){}
}
class Hero extends ActionCharacter implements CanFight, CanFly, CanSwim, CanClimb{
    @Override
    public void fly() { }
    @Override
    public void swim() { }
    @Override
    public void climb() { }
}