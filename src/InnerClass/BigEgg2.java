package InnerClass;

class Egg2{
    protected class York{
        public York(){
            System.out.println("Egg2.York");
        }
        public void f(){
            System.out.println("Egg2.York.f()");
        }
    }
    private York y = new York();
    public Egg2(){
        System.out.println("Egg2()");
    }
    public void insertYork(York yy){
        y = yy;
    }
    public void g(){
        y.f();
    }
}
class BigEgg2 extends Egg2{
    class York extends Egg2.York{
        public York(){
            System.out.println("bigEgg2.York()");
        }
        public void f(){
            System.out.println("bigEgg2.York().f()");
        }
    }
    public BigEgg2(){
        insertYork(new York());
    }

    public static void main(String[] args) {
        Egg2 e2 = new BigEgg2();
        e2.g();
    }
}