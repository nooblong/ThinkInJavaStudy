package Swing;
import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class HelloSwing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,100);
        frame.setVisible(true);
    }
}
class HelloLabel{
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Hello swing");
        JLabel label = new JLabel("A label");
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setVisible(true);
        TimeUnit.SECONDS.sleep(1);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                label.setText("Hey! this is different");
            }
        });
    }
}
