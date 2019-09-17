package ReusingClasses;

class Insect {
    private int i = 9;
    protected int j;

    Insect() {
        System.out.println("i = " + i + ", j = " + j);
    }

    private static int x1 = printInit("static ReusingClasses.Insect.x1 initialized");

    static int printInit(String s) {
        System.out.println(s);
        return 47;
    }

    public static void main(String[] args) {

    }
}

class Beetle extends Insect {
    private int k = printInit("ReusingClasses.Beetle.k initialized");

    public Beetle() {
        System.out.println("k = " + k);
        System.out.println("j = " + j);
    }

    private static int x2 = printInit("static ReusingClasses.Beetle.x2 initialized");

    public static void main(String[] args) {
        System.out.println("ReusingClasses.Beetle constructor");
        Beetle b = new Beetle();
    }
}
class Scarab extends Beetle {
    private int n = printInit("ReusingClasses.Scarab.n initialized");
    public Scarab() {
        System.out.println("n = " + n);
        System.out.println("j = " + j);
    }
    private static int x3 = printInit("static ReusingClasses.Scarab.x3 initialized");
    public static void main(String[] args) {
        System.out.println("ReusingClasses.Scarab constructor");
        Scarab sc = new Scarab();
    }
}