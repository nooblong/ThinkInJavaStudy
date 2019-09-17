package Polymorphism;

class AlertStatus{
    public void alert(){}
}
class NormalAlert extends AlertStatus{
    public void alert(){
        System.out.println("AlertStatus Normal");
    }
}
class HighAlert extends AlertStatus{
    @Override
    public void alert() {
        System.out.println("AlertStatus High");
    }
}
class MaximumAlert extends AlertStatus{
    @Override
    public void alert() {
        System.out.println("AlertStatus Maximum");
    }
}
public class Starship {
    private AlertStatus alertStatus = new NormalAlert();
    private void normalAlert() {alertStatus = new NormalAlert();}
    private void highAlert() {alertStatus = new NormalAlert();}
    private void maximumAlert() {alertStatus = new NormalAlert();}
}
