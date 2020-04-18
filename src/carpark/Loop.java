package carpark;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Loop {

    public static int maxCar = 3;//停车场最大车辆

    public static Stack<Car> park = new Stack<>();
    public static Stack<Car> tmp = new Stack<>();
    public static Queue<Car> bd = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        for (String a : s.split(" ")) {
            System.out.println("@@"+a);
            String b = a.split("\\(")[1].split("\\)")[0];
            String c = b.split(",")[0].split("\'")[1];//状态
            String d = b.split(",")[1];//id
            String e = b.split(",")[2];//时间
            char statusChar = c.charAt(0);
            int id = Integer.parseInt(d);
            int time = Integer.parseInt(e);
            switch (statusChar) {
                case 'A':
                    arrive(id, time);
                    break;
                case 'D':
                    leave(id, time);
                    break;
                default:
                    return;
            }

        }
    }

    public static void arrive(int id, int arriveTime) {
        if (!isParkFull()){
            park.push(new Car(id).setArriveTime(arriveTime));
            printStack(park);
        } else {
            bd.add(new Car(id).setArriveTime(arriveTime));
            System.out.println("满了");
            printStack(park);
        }
    }

    public static void leave(int id, int leaveTime) {
        boolean flag = true;//是否需要继续循环,如果已经找到则不需要循环
        Car car;
        while (!park.empty() && flag){
            car = park.pop();
            if (car.id != id){
                //如果不是要出去的那辆车，就让他到tmp里等着
                tmp.push(car);
            } else {
                System.out.println("车辆" + car.id + "离开");
                //是那辆车，出去了,让tmp里的车回来,flag变为false
                flag = false;
                Car tmpCar;
                while (!tmp.empty()){
                    tmpCar = tmp.pop();
                    park.push(tmpCar);
                    System.out.println("车辆" + tmpCar.id + "回来");
                }
                printStack(park);
            }
        }
        //走了一辆车之后，可以让一辆便道的车就来
        if (!bd.isEmpty()) {
            car = bd.poll();
            park.push(car);
            System.out.println("Car " + car.id + "in");
            printStack(park);
        }
    }

    public static boolean isParkFull() {
        return park.size() >= maxCar;
    }

    public static void printStack(Stack<Car> stack){
        System.out.println(stack.getClass().getSimpleName() + "------------------");
        for (Car car : stack){
            System.out.println(car);
        }
    }
}
