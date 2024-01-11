package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuScreen extends JFrame {

    static String x;
    static String y;

    static String userIDretainer;

    static String b;

    static int intUserNumber;


    private JPanel panel3;
    private JLabel lbWelcomeUserName;
    private JButton btCreateBusiness;
    private JButton byViewAccounts;
    private JButton btjoinCommunity;
    private JButton btjoinBusiness;
    private JButton btCreateCommunity;

    private JButton btCreateClient;


    public MenuScreen() {


        setContentPane(panel3);
        setTitle("Create, View or Join existing accounts.");
        setSize(400, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        //Create new business account and link the user number and account number to the user account table.
        btCreateBusiness.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {




                // create a new business account in database
                database BankDatabase = new database();

                BankDatabase.addAccount(0, "business");
                Account.BusinessAccount BUser = new Account.BusinessAccount(Integer.parseInt(y));
                System.out.println(BUser.getOverdraft());


                //link the user number and account number to the user account table.
                BankDatabase.addUserAccount(x, y);


            }
        });
        btCreateClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // create a new business account in database
                database BankDatabase = new database();

                BankDatabase.addAccount(0, "client");
                Account.ClientAccount CUser = new Account.ClientAccount(Integer.parseInt(y));

                //link the user number and account number to the user account table.
                BankDatabase.addUserAccount(x, y);

            }
        });
        btCreateCommunity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // create a new business account in database
                database BankDatabase = new database();

                BankDatabase.addAccount(0, "community");
                Account.CommunityAccount ComUser = new Account.CommunityAccount(Integer.parseInt(y));

                //link the user number and account number to the user account table.
                BankDatabase.addUserAccount(x, y);

            }
        });
        byViewAccounts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ViewMyAccounts viewMyAccountsScreen = new ViewMyAccounts();
                System.out.println(userIDretainer);
                database BankDatabase = new database();
                BankDatabase.viewAllAccounts(intUserNumber);


            }
        });
    }

    public void welcome(String result) {
        System.out.println(result);
        lbWelcomeUserName.setText(result);
        userIDretainer = result;
        intUserNumber = Integer.parseInt(userIDretainer);


    }

    public void transferUserNumber(String result) {

        x = result;
    }

    public void transferAccountNumber(String result) {
        y = result;
    }




}



