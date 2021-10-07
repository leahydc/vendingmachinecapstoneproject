package com.techelevator;

public class CoinBox {

    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public CoinBox() {
        balance = 0;
    }

    public void addFunds(int moneyIn) {
        balance = balance + moneyIn;
    }

    public void removeFunds(int moneyOut) {
        balance = balance - moneyOut;
    }

    public void giveChange() {

    }
}
