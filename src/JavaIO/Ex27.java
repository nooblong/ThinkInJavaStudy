package JavaIO;

import java.io.*;

class Outer implements Serializable{
    String i;
    Inner inner;
    public Outer(String i, Inner inner) {
        this.i = i;
        this.inner = inner;
    }

    @Override
    public String toString() {
        return "Outer{" +
                "i='" + i + '\'' +
                ", inner=" + inner +
                '}';
    }

    public static void main(String[] args) throws Exception {
        Outer outer = new Outer("这个样子", new Inner(233));
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ex27.out"));
        oos.writeObject(outer);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ex27.out"));
        Outer outer2 = (Outer) ois.readObject();
        System.out.println(outer2);
    }
}

class Inner implements Serializable{
    int i;
    public Inner(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "Inner{" +
                "i=" + i +
                '}';
    }
}
