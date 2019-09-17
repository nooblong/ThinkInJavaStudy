package Swing;

import net.mindview.util.Countries;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class TextArea extends JFrame {
    private JButton
        b = new JButton("Add Data"),
        c = new JButton("Clear Data");
    private JTextArea t = new JTextArea(20, 40);
    private Map<String, String> m = new HashMap<>();
    public TextArea(){
        m.putAll(Countries.capitals());
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Map.Entry me : m.entrySet()){
                    t.append(me.getKey() + ": " + me.getValue() + "\n");
                }
            }
        });
        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t.setText("");
            }
        });
        setLayout(new FlowLayout());
//        add(new JScrollPane(t));
        add(b);
        add(c);
        setCursor(Toolkit.getDefaultToolkit().
                createCustomCursor(new ImageIcon("./test/qz.png").
                        getImage(),new Point(10,20), "stick"));
    }

    public static void main(String[] args) {
        SwingConsole.run(new TextArea(), 475, 425);
    }
}
