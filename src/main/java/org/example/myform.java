package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class myform extends JFrame{
    private JButton testButton;
    private JPanel panel1;

    public myform(){
        setContentPane(panel1);
        setTitle("welcome");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void myform() {
        testButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("hello");
            }
        });
    }
}
