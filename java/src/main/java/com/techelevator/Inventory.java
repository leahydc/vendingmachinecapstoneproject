package com.techelevator;

import java.io.File;
import java.util.Map;
import java.util.Scanner;

public class Inventory {
    private String name;
    private String price;
    private String location;
    private String itemGroup;


        File inventoryFile = new File(" vendingmachine.csv");
        try(Scanner fileScanner = new Scanner(inventoryFile)){
            while(fileScanner.hasNextLine()){
                String line = fileScanner.nextLine();
                String [] itemDetails = line.split("|");
                name = itemDetails[1];
                if (itemDetails[3].equals("Candy")){
                    Candy name = new Candy;
                }

            }
    }


}
