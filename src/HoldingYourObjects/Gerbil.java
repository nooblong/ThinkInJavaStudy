package HoldingYourObjects;

public class Gerbil {
    int gerbilNumber;

    Gerbil(int i) {
        gerbilNumber = i;
    }

    public void hop() {
        System.out.println("Gerbil " + gerbilNumber + " hops");
    }

    @Override
    public String toString() {
        return "Gerbil " + gerbilNumber;
    }
}
