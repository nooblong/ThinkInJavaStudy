package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Button3 extends JFrame{
    private JButton
        b1 = new JButton("b1"),
        b2 = new JButton("b2"),
        b3 = new JButton("b3");
    private JTextField txt = new JTextField(10);
    private ActionListener bl = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = ((JButton)e.getSource()).getText();
            txt.setText(name);
        }
    };
    public Button3(){
        b1.addActionListener(bl);
        b2.addActionListener(bl);
        b3.addActionListener(bl);
        setLayout(new FlowLayout());
        add(b1);
        add(b2);
        add(b3);
        add(txt);
    }

    public static void main(String[] args) {
        SwingConsole.run(new Button3(),500,300);
    }

}