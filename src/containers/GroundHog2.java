package containers;

public class GroundHog2 extends GroundHog {

    public GroundHog2(int n) {
        super(n);
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof GroundHog2 && (number == ((GroundHog2)obj).number);
    }
}

class SpringDetector2{
    public static void main(String[] args) throws Exception {
        SpringDetector.detectSpring(GroundHog2.class);
    }
}
