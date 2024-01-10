package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewMyAccounts extends JFrame {

    private JPanel mainPanel;
    private JPanel panel5;
    private JPanel panel4;
    private JScrollPane AllAccountsTable;
    private JComboBox comboBox5;
    private JButton btSelectAccount;


    public ViewMyAccounts(){
        setContentPane(mainPanel);
        setTitle("All Accounts I own");
        setSize(700, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       // setVisible(true);


        btSelectAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                AccountsMenu.welcome(comboBox5.getSelectedItem());
                AccountsMenu newAccountMenu = new AccountsMenu();
                database myDatabase = new database();
                myDatabase.returnAccountType(comboBox5.getSelectedItem());
                myDatabase.balance(comboBox5.getSelectedItem());





            }
        });
    }
        public void returnTable(JTable table) {
        AllAccountsTable.setViewportView(table);
        setVisible(true);

        }

        public void returnAccountNumber( DefaultComboBoxModel myModel) {

            comboBox5.setModel(myModel);
            myModel.addElement("nesarly thetre"); // if i can get a list into here

        }


}
