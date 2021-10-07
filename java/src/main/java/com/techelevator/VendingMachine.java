package com.techelevator;

import com.sun.source.tree.Tree;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class VendingMachine {

    Inventory vendingInventory = new Inventory();
    CoinBox vendingCoinBox = new CoinBox();

    TreeMap<String,Item> newInventory =  new TreeMap<>();

    public void  printInventory(){

        for(Map.Entry<String,Item> item: newInventory.entrySet()){
            if (item.getValue().getCurrentStock() == 0) {
                System.out.println(item.getValue().getLocation() + " : " + item.getValue().getName() + " costs $" + item.getValue().getPrice() + " - SOLD OUT");
            }
            else System.out.println(item.getValue().getLocation() + " : " + item.getValue().getName() + " costs $" + item.getValue().getPrice() + " - " + item.getValue().getCurrentStock() + " remaining");
            }
    }


    public void printBalanceInDollars() {

        System.out.println();
//        System.out.println("Current Money Provided: $" + (vendingCoinBox.getBalance() / 100) + "." + (vendingCoinBox.getBalance() % 100));
        System.out.println("$" + String.format("%.2f", (vendingCoinBox.getBalance() / 100)));
    }

    public void feedMoney(int moneyIn) {
        moneyIn = moneyIn *100;
        vendingCoinBox.addFunds(moneyIn);
    }

    public VendingMachine(){
    newInventory = vendingInventory.makeInventory();
    }


}
