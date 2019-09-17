package InnerClass.controlFramwork;

public class GreenhouseController {
    public static void main(String[] args) {
        GreenhouseControls gc = new GreenhouseControls();
//        gc.addEvent(gc.new Bell(1000000000));
        Event[] eventList = {
                gc.new LightOn(2000),
                gc.new LightOff(4000),
                gc.new WaterOn(6000),
                gc.new WaterOff(8000),
                gc.new FunOn(100),
                gc.new FunOff(2000)
        };
        gc.addEvent(gc.new Restart(2000, eventList));
//        if (args.length == 1){
//            gc.addEvent(
//                    new GreenhouseControls.Terminate(
//                            new Integer(args[0])
//                    )
//            );
//        }
        gc.run();
        Ex25 ex25 = new Ex25();
        ex25.addEvent(ex25.new WaterOn(2000));
        ex25.addEvent(ex25.new WaterOff(2000));
    }
}
