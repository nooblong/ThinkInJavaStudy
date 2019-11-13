package containers;

public class GroundHog {
    protected int number;
    public GroundHog(int n){
        number = n;
    }

    @Override
    public String toString() {
        return "GroundHog #" + number;
    }
}
