package com.techelevator;

import com.sun.source.tree.Tree;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class VendingMachine {
    Inventory vendingInventory = new Inventory();
    TreeMap<String,Item> newInventory =  new TreeMap<>();

    public void  printInventory(){
            for(Map.Entry<String,Item> item: newInventory.entrySet()){
                System.out.println(item.getValue().getLocation() + " " + item.getValue().getName() + " " + item.getValue().getPrice());
            }

        }



    public VendingMachine(){
    newInventory = vendingInventory.makeInventory();
    }


}
