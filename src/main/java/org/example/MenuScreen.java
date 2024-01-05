package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuScreen extends JFrame {
    private JPanel panel3;
    private JLabel lbWelcomeUserName;
    private JButton btCreate;
    private JButton button2;
    private JButton button1;


    public MenuScreen() {
        setContentPane(panel3);
        setTitle("Welcome to Scen-Nario Banking system.");
        setSize(400, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        btCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    public void welcome(String result){
        System.out.println(result);
        lbWelcomeUserName.setText(result);

    }

}
