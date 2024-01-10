package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public AccountsMenu(){
        setContentPane(mainPanel);
        setTitle("Welcome to Scen-Nario Banking system.");
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //setVisible(true);

        jLAccountNumberWelcome.setText(accNum);
        jlAccountType.setText(acctype);
        lbBalance.setText(accB);
        setVisible(true);


        buttonDeposit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonWithdraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonTransfer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
