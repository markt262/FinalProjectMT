package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class jointAccounts extends JFrame {

    private JPanel mainPanel;
    private JPanel panel11;
    private JComboBox comboBox12;
    private JTextPane pleaseSelectTheAccountTextPane;
    private JButton ENTERButton;

    private String userNumber1;

    public jointAccounts(){
        setContentPane(mainPanel);
        setTitle("Select A Busineess or Community Account To Join....");
        setSize(700, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


        ENTERButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                database myDatabase = new database();

                myDatabase.addUserAccount( userNumber1,(String) comboBox12.getSelectedItem());
            }
        });
    }


    public void returnAllBusinessAccounts(DefaultComboBoxModel myModel,int userNumber) {

        comboBox12.setModel(myModel);
        userNumber1= String.valueOf(userNumber);
        System.out.println(userNumber);


    }
}
