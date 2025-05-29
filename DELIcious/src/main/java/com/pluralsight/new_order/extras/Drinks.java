package com.pluralsight.new_order.extras;

import com.pluralsight.design.Design;
import com.pluralsight.new_order.Size;
import com.pluralsight.new_order.SizeInterface;

import java.util.*;

public class Drinks implements SizeInterface {
    private Size drinkSize;
    private String flavor;
    private double price;

    // Constructor
    public Drinks(Size drinkSize, String flavor) {
        this.drinkSize = drinkSize;
        this.flavor = flavor;
        this.price = calcPriceFromSize(drinkSize);
    }


    // Size -> price conversion
    public double calcPriceFromSize(Size size) {
        return switch (this.drinkSize) {
            case  SMALL -> 2.00;
            case MEDIUM -> 2.50;
            case LARGE -> 3.00;
            default -> 0;
        };
    }

    public String getFlavor() {
        return flavor;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "DRINK|" + flavor + "|";
    }

    // Methods worked for UI Use
    public static List<Drinks> allDrinks () {
        List<Drinks> allDrinks = new ArrayList<>();
        allDrinks.add(new Drinks(Size.LARGE, "Coca-Cola"));
        allDrinks.add(new Drinks(Size.MEDIUM, "Sweet Tea"));
        allDrinks.add(new Drinks(Size.SMALL, "Lemonade"));
        allDrinks.add(new Drinks(Size.LARGE, "Peach Iced Tea"));
        allDrinks.add(new Drinks(Size.MEDIUM, "Root Beer"));
        allDrinks.add(new Drinks(Size.SMALL, "Sparkling Water (Lime)"));
        allDrinks.add(new Drinks(Size.LARGE, "Cherry Dr. Pepper"));
        allDrinks.add(new Drinks(Size.MEDIUM, "Strawberry Fanta"));
        allDrinks.add(new Drinks(Size.SMALL, "Green Tea"));
        allDrinks.add(new Drinks(Size.LARGE, "Vanilla Cream Soda"));
        return allDrinks;
    }
    public static LinkedHashMap<Integer, Drinks> printDrinks () {
        LinkedHashMap<Integer, Drinks> drinkMap = new LinkedHashMap<>();
        int counter = 0;
        for (Drinks drink : allDrinks()) {
            counter++;
            System.out.println(counter + ") " + drink.toString());
            drinkMap.put(counter, drink);
        }return drinkMap;
    }
    public static Drinks selectedDrink (LinkedHashMap<Integer, Drinks> availableDrinks, int choice) {
        return availableDrinks.get(choice);
    }
    public static Drinks makeDrink (Scanner scanner)  {
        Size size = Size.getSize(scanner);
        Design.titleNewLineTop();
        Design.systemMessage("What drink would you like?", false);
        LinkedHashMap<Integer, Drinks> availableDrinks = printDrinks();
        Design.titleLineBottom();
        int choice = Design.getIntWithMaxMin(scanner, false, "", true, 1, availableDrinks.size());
        return new Drinks(size, selectedDrink(availableDrinks, choice).getFlavor());
    }

}
