package com.techelevator;

public class CoinBox {

    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public CoinBox() {
        balance = 0;
    }

    public void addFunds(double moneyIn) {
        balance = balance + moneyIn;
    }

    public void removeFunds(double moneyOut) {
        balance = balance - moneyOut;
    }

    public void giveChange() {

    }
}
