package carpark;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Loop {

    public static int maxCar = 2;//停车场最大车辆

    public static Stack<Car> park = new Stack<>();
    public static Stack<Car> tmp = new Stack<>();
    public static Queue<Car> bd = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        for (String a : s.split(" ")) {
            //处理输入
            System.out.println("@" + a);
            String b = a.split("\\(")[1].split("\\)")[0];
            String c = b.split(",")[0].split("\'")[1];//状态
            String d = b.split(",")[1];//id
            String e = b.split(",")[2];//时间
            char statusChar = c.charAt(0);
            int id = Integer.parseInt(d);
            int time = Integer.parseInt(e);

            switch (statusChar) {
                //选择进入还是离开
                case 'A':
                    arrive(id, time);
                    break;
                case 'D':
                    leave(id, time);
                    break;
                default:
                    System.out.println("结束");
                    return;
            }
            //循环结束一次输出一次车辆情况
            printStack();
        }
    }

    public static void arrive(int id, int arriveTime) {
        //根据停车场情况判断他进入停车场还是便道等待，在进入时创建一个新的car对象
        if (!isParkFull()) {
            park.push(new Car(id).setArriveTime(arriveTime));
            System.out.println("车辆" + id + "进入停车场");
        } else {
            bd.add(new Car(id).setArriveTime(arriveTime));
            System.out.println("车辆" + id + "进入便道等待");
        }
    }

    public static void leave(int id, int leaveTime) {
        boolean flag = true;//是否需要继续循环,如果已经找到则不需要循环
        Car car;
        while (!park.empty() && flag) {
            //把停车场里的车拿出来比较是否为离开的车
            car = park.pop();
            if (car.id != id) {
                //如果不是要出去的那辆车，就让他到tmp里等着
                tmp.push(car);
            } else {
                //是那辆车的话就代表它要离开
                //收费时间为离去时间-到达时间-等待时间
                System.out.println("车辆" + car.id + "离开停车场,停车时间:" + (leaveTime - car.arriveTime - car.waitTime));
                //那辆车出去了,让tmp里的车回停车场,flag变为false,停止继续让停车场里的车出来做比较
                flag = false;
                Car tmpCar;
                while (!tmp.empty()) {
                    //循环让tmp回到停车场
                    tmpCar = tmp.pop();
                    park.push(tmpCar);
                }
            }
        }
        //走了一辆车之后，就可以让一辆便道的车就来
        if (!bd.isEmpty()) {
            car = bd.poll();
            park.push(car);
            System.out.println("车辆" + car.id + "从便道进停车场");
            //在便道不算时间，减去时间,设置为park中第一辆出去的车的时间-现在这辆车进来的时间
            car.waitTime += (leaveTime - car.arriveTime);
        }
    }

    public static boolean isParkFull() {
        //停车场是否有空位
        return park.size() >= maxCar;
    }

    public static void printStack() {
        //打印两个栈的情况
        System.out.print("便道中车辆: ");
        for (Car car : bd) {
            System.out.print(car.id + " ");
        }
        System.out.println();
        System.out.print("停车场中车辆: ");
        for (Car car : park) {
            System.out.print(car.id + " ");
        }
        System.out.println();
    }
}
