package org.example;

import javax.swing.*;
import java.awt.event.ActionListener;

public class whichBusinessAccount extends JFrame {

    private JPanel mainPanel;
    private JPanel panel11;
    private JComboBox comboBox11;

    public whichBusinessAccount(){
        setContentPane(mainPanel);
        setTitle("elect Business Account");
        setSize(700, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);



    }


    public void returnAllBusinessAccounts(DefaultComboBoxModel myModel) {

        comboBox11.setModel(myModel);


    }
}
