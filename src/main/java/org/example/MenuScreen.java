package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuScreen extends JFrame {

    static String x;
    static String y;



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

        //Create new business account and link the user number and account number to the user account table.
        btCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           // Account userAccount = new Account(1000);
            //userAccount.create(1000)
                Account.BusinessAccount BUser = new Account.BusinessAccount(1000,"Business",0);
                System.out.println(BUser.getOverdraft());

                // create a new business account in database
               database BankDatabase = new database();

               BankDatabase.addAccount(0,"business");
               //BankDatabase.accountNumber();


               //link the user number and account number to the user account table.
               BankDatabase.addUserAccount(x,y);

                System.out.println(x);




            }
        });
    }
    public void welcome(String result){
        System.out.println(result);
        lbWelcomeUserName.setText(result);

    }

    public void transferUserNumber(String result) {

        x = result;
    }
    public void transferAccountNumber(String result){
        y = result;


    }
}
