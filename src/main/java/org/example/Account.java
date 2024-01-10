package org.example;

public class Account {
    //attributes
    private int overdraft;
    private  String accountType;
    private int balance;

    //Constructor
    public Account(int overdraft,String accountType, int balance){
        this.overdraft = overdraft;
        this.accountType= accountType;
        this.balance = balance;

    }
    //methods
    public  int getOverdraft(){
        return overdraft;
    }






    public static class BusinessAccount extends Account{
        //Constructor with arguments
        public BusinessAccount(int overdraft,String accountType,int balance){
            super(overdraft,accountType,balance);
        }


        }
    public static class ClientAccount extends Account{
        //Constructor with arguments
        public ClientAccount(int overdraft,String accountType,int balance){
            super(overdraft,accountType,balance);
        }


    }
    public static class CommunityAccount extends Account{
        //Constructor with arguments
        public CommunityAccount(int overdraft,String accountType,int balance){
            super(overdraft,accountType,balance);
        }


    }



    }









