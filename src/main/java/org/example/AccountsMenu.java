package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.example.MenuScreen.intUserNumber;

public class AccountsMenu extends JFrame {


    static String accNum;

    static String acctype;

    static String accB;
    private JPanel mainPanel;
    private  JLabel jLAccountNumberWelcome;
    private JLabel lbDeposit;
    private JLabel lbWithdraw;
    private JLabel lbTransfer;
    private JTextField textFieldDeposit;
    private JTextField textFieldWithdraw;
    private JTextField textFieldTransfer;
    private JTextField textField4;
    private JButton buttonDeposit;
    private JButton buttonWithdraw;
    private JButton buttonTransfer;
    private JLabel jlAccountType;
    private JLabel lbBalance;
    private JButton jBAllAccounts;

    private String balance;



    public AccountsMenu(){
        setContentPane(mainPanel);
        setTitle("Deposit, Withdraw, Transfer menu.");
        setSize(800,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //setVisible(true);

        jLAccountNumberWelcome.setText(accNum);
        jlAccountType.setText(acctype);
        lbBalance.setText(accB);
        setVisible(true);



        buttonDeposit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if (acctype.equals("business")) {
                    Account.BusinessAccount bAcc= new Account.BusinessAccount(Integer.parseInt(accNum));
                    database myDatabase = new database();
                    String balance=lbBalance.getText();
                    myDatabase.balance(Integer.parseInt(balance));
                    String deposit= textFieldDeposit.getText();
                    bAcc.deposit(Integer.parseInt(deposit),Integer.parseInt(accNum),Integer.parseInt(balance));
                    } else if (acctype.equals("client")) {
                    Account.ClientAccount bAcc= new Account.ClientAccount(Integer.parseInt(accNum));
                    database myDatabase = new database();
                    String balance=lbBalance.getText();
                    myDatabase.balance(Integer.parseInt(balance));
                    String deposit= textFieldDeposit.getText();
                    bAcc.deposit(Integer.parseInt(deposit),Integer.parseInt(accNum),Integer.parseInt(balance));
                    } else if (acctype.equals("community")){
                    Account.CommunityAccount bAcc= new Account.CommunityAccount(Integer.parseInt(accNum));
                    database myDatabase = new database();
                    String balance=lbBalance.getText();
                    myDatabase.balance(Integer.parseInt(balance));
                    String deposit= textFieldDeposit.getText();
                    bAcc.deposit(Integer.parseInt(deposit),Integer.parseInt(accNum),Integer.parseInt(balance));
                    }


                    database myDatabase = new database();
                    balance = jLAccountNumberWelcome.getText();
                    myDatabase.balance(Integer.parseInt(balance));

            }
        });
        buttonWithdraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (acctype.equals("business")){
                    Account.BusinessAccount bAcc= new Account.BusinessAccount(Integer.parseInt(accNum));
                    database myDatabase = new database();
                    String balance=lbBalance.getText();
                    myDatabase.balance(Integer.parseInt(balance));
                    String withdraw= textFieldWithdraw.getText();
                    bAcc.withdraw(Integer.parseInt(withdraw),Integer.parseInt(accNum),Integer.parseInt(balance));
                } else if (acctype.equals("client")){
                    Account.ClientAccount bAcc= new Account.ClientAccount(Integer.parseInt(accNum));
                    database myDatabase = new database();
                    String balance=lbBalance.getText();
                    myDatabase.balance(Integer.parseInt(balance));
                    String withdraw= textFieldWithdraw.getText();
                    bAcc.withdraw(Integer.parseInt(withdraw),Integer.parseInt(accNum),Integer.parseInt(balance));
                }else if (acctype.equals("community")){
                    Account.CommunityAccount bAcc= new Account.CommunityAccount(Integer.parseInt(accNum));
                    database myDatabase = new database();
                    String balance=lbBalance.getText();
                    myDatabase.balance(Integer.parseInt(balance));
                    String withdraw= textFieldWithdraw.getText();
                    bAcc.withdraw(Integer.parseInt(withdraw),Integer.parseInt(accNum),Integer.parseInt(balance));}

                    database databaseBalance = new database();
                    String balance1=jLAccountNumberWelcome.getText();
                    databaseBalance.balance(Integer.parseInt(balance1));





            }
        });
        buttonTransfer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        jBAllAccounts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.remove(mainPanel);
                ViewMyAccounts viewMyAccountsScreen = new ViewMyAccounts();
                database BankDatabase = new database();
                BankDatabase.viewAllAccounts(intUserNumber);
            }
        });
    }



    public static void welcome(Object selectedItem) {
        System.out.println(selectedItem);
        accNum= (String) selectedItem;
    }

    public static void accountType (String r){
        System.out.println(r);
        acctype = r;

    }
    public static void balance (String b){
        accB=b;

    }


} // end of classs
