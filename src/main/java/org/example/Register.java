package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Register extends JFrame {
    private JLabel FirstName;
    private JTextField tfFirstName;
    private JLabel LastName;
    private JTextField tfSecondName;
    private JLabel DOB;
    private JTextField tfDOB;
    private JLabel UserName;
    private JTextField tfUserName;
    private JLabel Password;
    private JTextField tfPassword;
    private JButton Enter;
    private JButton Clear;
    private JLabel FeedbackText;
    private JPanel panel2;
    private JButton button1;
    private JButton button2;

    public Register() {
        setContentPane(panel2);
        setTitle("Welcome to Scen-Nario Banking system.");
        setSize(600, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        Enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = tfFirstName.getText();
                String lastName = tfSecondName.getText();
                String dob = tfDOB.getText();
                String userName = tfUserName.getText();
                String password = tfPassword.getText();

                database BankDatabase = new database();
                BankDatabase.addUser(firstName,lastName,dob,userName,password);
                setVisible(false);



            }
        });


        Clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfFirstName.setText("");
                tfSecondName.setText("");
                tfDOB.setText("");
                tfUserName.setText("");
                tfPassword.setText("");

            }
        });
    }
}
