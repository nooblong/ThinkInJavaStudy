package InnerClass.ex16;

interface Cycle {
    void ride();
}

interface CycleFactory {
    Cycle getCycle();
}

class Unicycle implements Cycle {

    @Override
    public void ride() {
        System.out.println("Ride Unicycle");
    }

    public static CycleFactory getCycle() {
        return new CycleFactory() {
            @Override
            public Cycle getCycle() {
                return new Unicycle();
            }
        };
    }
}

//class UnicycleFactory implements CycleFactory{
//
//    @Override
//    public Cycle getCycle() {
//        return new Unicycle();
//    }
//}
class Bicycle implements Cycle {

    @Override
    public void ride() {
        System.out.println("Ride Bicycle");
    }

    public static CycleFactory getCycle() {
        return new CycleFactory() {
            @Override
            public Cycle getCycle() {
                return new Bicycle();
            }
        };
    }
}

//class BicycleFactory implements CycleFactory{
//
//    @Override
//    public Cycle getCycle() {
//        return new Bicycle();
//    }
//}
class Tricycle implements Cycle {
    Tricycle() {
        System.out.println("Tricycle()");
    }

    public void ride() {
        System.out.println("Ride Tricycle");
    }
    public static CycleFactory cycleFactory = new CycleFactory() {
        @Override
        public Cycle getCycle() {
            return new Tricycle();
        }
    };
}

//class TricycleFactory implements CycleFactory {
//    public Cycle getCycle() {
//        return new Tricycle();
//    }
//}
public class Cycles {
    public static void rideCycle(CycleFactory factory) {
        Cycle c = factory.getCycle();
        c.ride();
    }

    public static void main(String[] args) {
        rideCycle(Unicycle.getCycle());
        rideCycle(Bicycle.getCycle());
        rideCycle(Tricycle.cycleFactory);
    }
}