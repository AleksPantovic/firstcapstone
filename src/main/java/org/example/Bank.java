package org.example;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String account;
    private double balance;
    private List<String> transactions;
    public Bank(String account,double balance)
    {
        this.account=account;
        this.balance=balance;
        this.transactions=new ArrayList<>();
        this.transactions.add("Created account with balance "+balance);
    }
    public double CheckBalance(){
        return balance;
    }
    public void deposit(double money){
        if(money>0) {
            balance += money;
            transactions.add("Added " + money + " to the account, current balance is " + balance);
        }
        else
            System.out.println("Cant deposit negative money");
    }
    public boolean withdraw(double money)
    {
        if(money>0 && money <= balance) {
            balance -= money;
            transactions.add("Withdrew " + money + " from the account, current balance is " + balance);
            return true;
        }
        else {
            return false;
        }
    }

    public List<String> getTransactions() {
        return transactions;
    }
}
