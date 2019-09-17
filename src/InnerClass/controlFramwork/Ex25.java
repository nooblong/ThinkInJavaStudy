package InnerClass.controlFramwork;

public class Ex25 extends GreenhouseControls {
    private boolean waterMist = false;
    public class WaterMistOn extends Event {
        public WaterMistOn(long delayTime) {
            super(delayTime);
        }
        public void action() {
            // Put hardware control code here to
            // physically turn on water mist generator
            waterMist = true;
        }
        public String toString() {
            return "Water mist generator on";
        }
    }
    public class WaterMistOff extends Event {
        public WaterMistOff(long delayTime) {
            super(delayTime);
        }
        public void action() {
            // Put hardware control code here to
            // physically turn off water mist generator
            waterMist = false;
        }
        public String toString() {
            return "Water mist generator off";
        }
    }
}
