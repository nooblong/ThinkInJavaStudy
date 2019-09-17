package Interface;
class bike {
    private int i = 0;
    void ride(){
        System.out.println("ride");
    }
}
interface car{
    void run();
    void stop();
}
interface ship{
    void go();
    void back();
}
interface plane{
    void high();
    void down();
}
interface Newfun extends car, ship, plane{
    void start();
}
class Use extends bike implements Newfun{
    private int j = 0;
    @Override
    public void run() {

    }
    @Override
    public void stop() {

    }
    @Override
    public void go() {

    }
    @Override
    public void back() {

    }
    @Override
    public void high() {

    }
    @Override
    public void down() {

    }
    @Override
    public void start() {

    }
}
class fun{
    Use use = new Use();
    public static void a(bike x){x.ride();}
    public static void b(car x){x.run();}
    public static void c(ship x){x.back();}
    public static void d(plane x){x.down();}
    public static void e(Newfun x){x.start();}

    public static void main(String[] args) {
        Use use = new Use();
        a(use);
        b(use);
        c(use);
        d(use);
        e(use);
    }
}
