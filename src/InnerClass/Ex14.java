package InnerClass;

interface Monster{
    void menace();
}
interface DangerousMonster extends Monster{
    void destroy();
}
interface Lethal{
    void kill();
}
class DragonZilla implements DangerousMonster{

    @Override
    public void menace() {    }

    @Override
    public void destroy() {    }
}
interface Vampire extends DangerousMonster, Lethal{
    void drinkBlood();
}
class VeryBadVampire implements Vampire{

    @Override
    public void menace() { }

    @Override
    public void destroy() { }

    @Override
    public void kill() { }

    @Override
    public void drinkBlood() { }
}
class HorrorShow14{
    static void u(Monster b){ b.menace();}
    static void v(DangerousMonster d){ d.menace();d.destroy();}
    static void w(Lethal l){ l.kill();}
    public DangerousMonster monsterMaker(){
        return new DangerousMonster() {
            @Override
            public void destroy() {
                System.out.println("DangerousMonster Destroy");
            }

            @Override
            public void menace() {
                System.out.println("DangerousMonster Menace");
            }
        };
    }
    public Vampire vampireMaker(){
        return new Vampire() {
            public void menace() {
                System.out.println("Vampire Menace"); }
            public void destroy() {
                System.out.println("Vampire Destroy"); }
            public void kill() {
                System.out.println("Vampire Kill"); }
            public void drinkBlood() {
                System.out.println("Vampire DrinkBlood"); }
        };
    }

    public static void main(String[] args) {
        HorrorShow14 show = new HorrorShow14();
        show.u(show.monsterMaker());
        show.v(show.monsterMaker());
        show.u(show.vampireMaker());
        show.v(show.vampireMaker());
        show.w(show.vampireMaker());
    }
}