package com.techelevator;

public abstract class Item {


    private String name;
    private String price;
    private String location;
    private String itemGroup;
    private int currentStock;

    public Item(String location, String name,String price, String itemGroup){
        this.name = name;
        this.price= price;
        this.location = location;
        this.itemGroup = itemGroup;
        currentStock = 5;

    }
}
