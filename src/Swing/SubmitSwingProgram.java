package Swing;
import Swing.SwingConsole.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubmitSwingProgram extends JFrame {
    private JLabel jLabel = new JLabel("A Label");
    SubmitSwingProgram(){
        add(jLabel);
    }

    public static void main(String[] args) {
        SwingConsole.run(new SubmitSwingProgram(),
                300,100);
    }
}
class Button1 extends JFrame{
    private JButton
        b1 = new JButton("Button 1"),
        b2 = new JButton("Button 2");
    public Button1(){
//        setLayout(new FlowLayout());
        add(b1);
        add(b2);
    }

    public static void main(String[] args) {
        SwingConsole.run(new Button1(), 200, 100);
    }
}
class Button2 extends JFrame{
    private JButton
        b1 = new JButton("Button1"),
        b2 = new JButton("Button2");
    private JTextField txt = new JTextField(10);
//    class ButtonListener implements ActionListener{
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            String name = ((JButton)e.getSource()).getText();//返回按钮上的文本
//            txt.setText(name);
//        }
//    }
    private ActionListener bl = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = ((JButton)e.getSource()).getText();
        txt.setText(name);
    }
};
//    private ButtonListener bl = new ButtonListener();
    public Button2(){
        b1.addActionListener(bl);
        b2.addActionListener(bl);
        setLayout(new FlowLayout());
        add(b1);
        add(b2);
        add(txt);
    }

    public static void main(String[] args) {
        SwingConsole.run(new Button2(),500,300);
    }
}