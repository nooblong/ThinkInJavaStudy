package typeinfo;

import static net.mindview.util.Print.*;

class Candy {
    static { print("Loading Candy"); }
}

class Gum {
    static { print("Loading Gum"); }
}

class Cookie {
    static { print("Loading Cookie"); }
}

public class SweetShop {
    public static void main(String[] args) {
        if (args.length < 1){
            System.out.println("use sweet Name");
            System.exit(0);
        }
        Class c = null;
        try {
            c = Class.forName(args[0]);
            System.out.println("enjoy your " + args[0]);
        } catch (ClassNotFoundException e) {
            System.out.println("cant find " + args[0]);
        }
    }
}