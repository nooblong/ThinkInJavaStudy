package HoldingYourObjects;

import java.util.PriorityQueue;
import java.util.Random;

public class Ex28 {
    public static void main(String[] args) {
        Random random = new Random(47);
        PriorityQueue<Double> integers = new PriorityQueue<>();
        for (int i = 0; i < 10; i++) {
            integers.offer(random.nextDouble());
        }
        System.out.println(integers);
        while (integers.peek() != null){
            System.out.print(integers.poll() + " ");
        }

    }
}
