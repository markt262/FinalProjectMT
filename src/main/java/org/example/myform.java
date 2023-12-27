package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class myform extends JFrame{
    private JButton Login;
    private JPanel panel1;
    private JButton Register;

    public myform(){
        setContentPane(panel1);
        setTitle("Welcome to Scen-Nario Banking system.");
        setSize(400,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void buttons() {
        Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("hello");
            }
        });
    }
}
