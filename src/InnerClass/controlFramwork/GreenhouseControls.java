package InnerClass.controlFramwork;

public class GreenhouseControls extends Controller {
    private boolean light = false;
    public class LightOn extends Event {
        public LightOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            //put hardware control code here to physically turn on the light
            light = true;
        }

        public String toString() {
            return "Light is On";
        }
    }

    public class LightOff extends Event {
        public LightOff(long dealyTime) {
            super(dealyTime);
        }

        @Override
        public void action() {
            //put hardware control code here to physically turn on the light
            light = false;
        }

        public String toString() {
            return "Light is off";
        }
    }

    private boolean water = false;

    public class WaterOn extends Event {
        public WaterOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            water = true;
        }

        @Override
        public String toString() {
            return "Greenhouse water is on";
        }
    }

    public class WaterOff extends Event {
        public WaterOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            water = false;
        }

        @Override
        public String toString() {
            return "Greenhouse water is off";
        }
    }

    public class Bell extends Event {
        public Bell(long delayTime){
            super(delayTime);
        }
        @Override
        public void action() {
            addEvent(new Bell(delayTime));
        }

        @Override
        public String toString() {
            return "Bing!";
        }
    }
    public class Restart extends Event{
        private Event[] eventList;
        public Restart(long delayTime, Event[] eventList){
            super(delayTime);
            this.eventList = eventList;
            for (Event e : eventList){
                addEvent(e);
            }
        }
        @Override
        public void action() {
            for (Event e : eventList){
                e.start();//run each event
                addEvent(e);
            }
            start();
//            addEvent(this);
        }
        public String toString(){
            return "Restarting System";
        }
    }
    public static class Terminate extends Event{
        public Terminate(long delayTime){
            super(delayTime);
        }
        @Override
        public void action() {
            System.exit(0);
        }

        @Override
        public String toString() {
            return "Terminating";
        }
    }
    boolean fun = false;
    public class FunOn extends Event{
        FunOn(long delay){
            super(delay);
        }
        @Override
        public void action() {
            fun = true;
        }

        @Override
        public String toString() {
            return "Fun is on";
        }
    }
    public class FunOff extends Event{
        public FunOff(long delay){
            super(delay);
        }
        @Override
        public void action() {
            fun = false;
        }

        @Override
        public String toString() {
            return "Fun is off";
        }
    }
}
