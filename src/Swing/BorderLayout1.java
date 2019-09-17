package Swing;

import javax.swing.*;
import java.awt.*;

public class BorderLayout1 extends JFrame {
    public BorderLayout1(){
        add(BorderLayout.NORTH, new JButton("North"));
        add(BorderLayout.EAST, new JButton("EAST"));
        add(BorderLayout.SOUTH, new JButton("SOUTH"));
        add(BorderLayout.WEST, new JButton("WEST"));
    }
    public static void main(String[] args) {
        SwingConsole.run(
                new BorderLayout1(), 300, 250);
    }

}
class FlowLayout1 extends JFrame{
    public FlowLayout1(){
        setLayout(new FlowLayout());
        for (int i = 0; i < 20; i++) {
            add(new JButton("Button " + i));
        }
        setCursor(Toolkit.getDefaultToolkit().
                createCustomCursor(new ImageIcon("./test/qz.png").
                        getImage(),new Point(10,20), "stick"));
}
    public static void main(String[] args) {
        SwingConsole.run(
                new FlowLayout1(),400, 500);
    }
}
class GirdLayout1 extends JFrame{

    public GirdLayout1(){
        setLayout(new GridLayout(7,3));
        for (int i = 0; i < 20; i++) {
            add(new JButton("Button " + i));
        }
    }

    public static void main(String[] args) {
        SwingConsole.run(
                new GirdLayout1(), 300, 300);
    }
}
