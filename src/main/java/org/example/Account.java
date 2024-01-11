package org.example;

public class Account {
    //attributes
    private int overdraft;
    private  String accountType;
    private int balance;

    private int accountNumber;

    //Constructor
    public Account(int overdraft,String accountType, int balance,int accountNumber){
        this.overdraft = overdraft;
        this.accountType= accountType;
        this.balance = balance;
        this.accountNumber=accountNumber;

    }
    //methods
    public  int getOverdraft(){
        return overdraft;
    }



    public static class BusinessAccount extends Account{
        //Constructor with arguments

        public BusinessAccount(int accountNumber){
            super(1000,"business",0,accountNumber);

        }

        }
    public static class ClientAccount extends Account{
        //Constructor with arguments
        public ClientAccount(int accountNumber){
            super(1500,"client",0,accountNumber);
        }


    }
    public static class CommunityAccount extends Account{
        //Constructor with arguments
        public CommunityAccount(int accountNumber){
            super(2500,"community",0,accountNumber);
        }


    }



    }









