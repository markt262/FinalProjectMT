package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntialScreen  extends JFrame{
    private JButton Login;
    private JPanel panel1;
    private JButton Register;
    private JButton clear;
    private JTextField tfUserName;
    private JTextField tfPassword;

    public IntialScreen(){
        setContentPane(panel1);
        setTitle("Welcome to Scen-Nario Banking system.");
        setSize(400,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        Register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Register RegisterForm = new Register();

            }
        });
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfUserName.setText("");
                tfPassword.setText("");
            }
        });
    }

    public void login() {
        Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String u = tfUserName.getText();
                String p = tfPassword.getText();

                database test = new database();
                test.verifyUser(u,p);



            }




        });

    }
}
