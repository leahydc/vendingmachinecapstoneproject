package com.techelevator;

public abstract class Item {


    private String name;
    private String price;
    private String location;
    private int currentStock;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }

    public Item(String location, String name, String price){
        this.name = name;
        this.price= price;
        this.location = location;
        currentStock = 5;

    }
}
