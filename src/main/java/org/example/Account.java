package org.example;

public class Account {
    //attributes
    private int overdraft;
    private  String accountType;
    private int balance;

    private int accountNumber;

    //Constructor
    public Account(int overdraft,String accountType, int balance,int accountumber){
        this.overdraft = overdraft;
        this.accountType= accountType;
        this.balance = balance;
        this.accountNumber=accountumber;

    }
    //methods
    public  int getOverdraft(){
        return overdraft;
    }






    public static class BusinessAccount extends Account{
        //Constructor with arguments
        int overdraft= 1033;
        public BusinessAccount(int overdraft,String accountType,int balance, int accountNumber){


            super(overdraft,accountType,balance,accountNumber);
        }



        }
    public static class ClientAccount extends Account{
        //Constructor with arguments
        public ClientAccount(int overdraft,String accountType,int balance,int accountNumber){
            super(overdraft,accountType,balance,accountNumber);
        }


    }
    public static class CommunityAccount extends Account{
        //Constructor with arguments
        public CommunityAccount(int overdraft,String accountType,int balance,int accountNumber){
            super(overdraft,accountType,balance,accountNumber);
        }


    }



    }









