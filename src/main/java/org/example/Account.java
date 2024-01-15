package org.example;
public class Account {
    //attributes
    private static int overdraft;
    private String accountType;
    private int balance;

    private static int accountNumber;

    //Constructor
    public Account(int overdraft, String accountType, int balance, int accountNumber) {
        this.overdraft = overdraft;
        this.accountType = accountType;
        this.balance = balance;
        this.accountNumber = accountNumber;

    }

    //methods
    public void deposit(int x, int accountNumber, int balance2) {
        System.out.println(x);
        database deposit = new database();
        deposit.deposit((balance2 + x), accountNumber);
    }

    public void withdraw(int x, int accountNumber, int balance) {

    }

    public int getOverdraft() {
        return overdraft;
    }


    public static class BusinessAccount extends Account {

        //Constructor with arguments

        public BusinessAccount(int accountNumber) {
            super(-1000, "business", 0, accountNumber);

        }
        @Override
        public void withdraw(int x, int accountNumber, int balance) {
            if ((balance - x) < overdraft) {
                System.out.println("cant withdraw this amount as you go over your Client account overdraft ");

            } else {
                database withdraw = new database();
                withdraw.deposit((balance - x), accountNumber);

            }
        }

    }

    public static class ClientAccount extends Account {


        //Constructor with arguments
        public ClientAccount(int accountNumber) {
            super(-1500, "client", 0, accountNumber);
        }
        @Override
        public void withdraw(int x, int accountNumber, int balance) {
            if ((balance - x) < overdraft) {
                System.out.println("cant withdraw this amount as you go over your Client account overdraft ");
            } else {

                database withdraw = new database();
                withdraw.deposit((balance - x), accountNumber);
            }
        }


    }

    public static class CommunityAccount extends Account {
        //Constructor with arguments
        public CommunityAccount(int accountNumber) {
            super(-2500, "community", 0, accountNumber);
        }
        @Override
        public void withdraw(int x, int accountNumber, int balance) {
            if ((balance - x) < overdraft) {
                System.out.println("cant withdraw this amount as you go over your Community account overdraft ");
            } else {

                database withdraw = new database();
                withdraw.deposit((balance - x), accountNumber);
            }
        }


    }

} //end of class











