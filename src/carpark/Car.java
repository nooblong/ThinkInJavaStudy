package carpark;

public class Car {
    public Car(int id) {
        this.id = id;
    }

    public int id;
    public int arriveTime;
    public int leaveTime;
    public int waitTime = 0;

    public Car setArriveTime(int arriveTime) {
        this.arriveTime = arriveTime;
        return this;
    }

    public Car setLeaveTime(int leaveTime) {
        this.leaveTime = leaveTime;
        return this;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", arriveTime=" + arriveTime +
                ", leaveTime=" + leaveTime +
                ", keepTime=" + waitTime +
                '}';
    }
}
