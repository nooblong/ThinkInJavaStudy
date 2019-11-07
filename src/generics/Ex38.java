//package generics;
//
//class BasicCoffee {
//    private static long counter = 0;
//    private final long id = counter++;
//    private String value;
//    public void set(String val) { value = val; }
//    public String get() { return value; }
//    public String toString() {
//        return getClass().getSimpleName() + " " + id;
//    }
//}
//
//class Decorator extends BasicCoffee{
//    protected BasicCoffee basicCoffee;
//    public Decorator(BasicCoffee basicCoffee){
//        this.basicCoffee = basicCoffee;
//    }
//
//    @Override
//    public void set(String val) {
//        basicCoffee.set(val);
//    }
//
//    @Override
//    public String get() {
//        return basicCoffee.get();
//    }
//}
//
//class SteamedMilk extends Decorator{
//
//    public SteamedMilk(BasicCoffee basicCoffee) {
//        super(basicCoffee);
//    }
//
//    private final String steamedMilk = "steamedMilk";
//
//    public String getSteamedMilk() {
//        return steamedMilk;
//    }
//}
//
//class Foam extends Decorator{
//
//    public Foam(BasicCoffee basicCoffee) {
//        super(basicCoffee);
//    }
//
//    private final String chocolate = "chocolate";
//
//    public String getChocolate() {
//        return chocolate;
//    }
//}
//
//class Ex38{
//    public static void main(String[] args) {
//        SteamedMilk sm = new SteamedMilk(new BasicCoffee());
//        SteamedMilk sm2 = new SteamedMilk(new Foam(new BasicCoffee()));
//        System.out.println(sm2);
//    }
//}