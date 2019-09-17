package HoldingYourObjects;

import java.util.LinkedList;
import java.util.Queue;

class Command {
    String s;

    Command(String s) {
        this.s = s;
    }

    void operation() {
        System.out.println(s);
    }
}

class Build {
    Queue<Command> makeQ() {
        Queue<Command> q = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            q.offer(new Command(i + " "));
        }
        return q;
    }
}
class Ex27{
    public static void comandEater(Queue<Command> qc){
        while (qc.peek() != null){
            qc.poll().operation();
        }
    }

    public static void main(String[] args) {
        Build b = new Build();
        comandEater(b.makeQ());
    }
}