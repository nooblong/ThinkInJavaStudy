package InnerClass;

public class Parcel10 {
    public Destination destination(final String dest, final float price){
        System.out.println(dest);
//        dest = "a";
        return new Destination() {
            private int cost;
            {
                cost = Math.round(price);
                if (cost>100)
                    System.out.println("Over budget");
            }
            private String label = dest;
            public String readLabel(){
                return label;
            }
        };

    }

    public static void main(String[] args) {
        Parcel10 parcel10 = new Parcel10();
        Destination d = parcel10.destination("Tasmania", 101.395f);
    }
}
