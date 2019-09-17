package InnerClass;

public class Parcel11 {
    private int a = 1;
    private static class ParcelContents implements Contents{
        private int i = 11;
        @Override
        public int value() {
            return i;
        }
    }
    protected static class ParcelDestination implements Destination{
        private String label;

        @Override
        public String readLabel() {
            return label;
        }
        private ParcelDestination(String whereTo){
            label = whereTo;
        }
        public static void f(){ }
        static int x = 10;
        static class AnotherLevel{
            public static void f(){  }
            static int x = 10;
        }
    }
    public static Destination destination(String s){
        return new ParcelDestination(s);
    }
    public static Contents contents(){
        return new ParcelContents();
    }

    public static void main(String[] args) {
        Contents c = contents();
        Destination d = destination("Tasmania");
    }
}
