package com.pluralsight.new_order.sandwiches.sandwich_contents;

import com.pluralsight.design.Design;
import com.pluralsight.new_order.Size;
import com.pluralsight.new_order.SizeInterface;
import com.pluralsight.new_order.sandwiches.Sandwich;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Topping implements SizeInterface {
    private final double unitCost; // Cost when portion size is SMALL.
    private final String name;
    String groupType;

    // Defined Constructor
    public Topping (String groupType, String name, double unitCost) {
        this.unitCost = unitCost;
        this.name = name;
        this.groupType = groupType;
    }

    // Size -> price conversion
    public double calcPriceFromSize(Size sandwichSize) {
        return switch (sandwichSize) {
            case SMALL -> 1 * this.unitCost;
            case MEDIUM -> 2 * this.unitCost * 2;
            case LARGE -> 3 * this.unitCost * 3;
        };
    }
    public double totalToppingPrice (List<Topping> toppings, Size sandwichSize) {
        double sum = 0;
        for (Topping topping : toppings) {
            sum += topping.calcPriceFromSize(sandwichSize);
        } return sum;
    }


    // Hardcoded Arraylist of ALL toppings
    public static List<Topping> allToppings () {
        List<Topping> allToppings = new ArrayList<>();
        allToppings.add(new Topping("MEAT", "STEAK", 1.00));
        allToppings.add(new Topping("MEAT", "HAM", 1.00));
        allToppings.add(new Topping("MEAT", "SALAMI", 1.00));
        allToppings.add(new Topping("MEAT", "ROAST BEEF", 1.00));
        allToppings.add(new Topping("MEAT", "CHICKEN", 1.00));
        allToppings.add(new Topping("MEAT", "BACON", 1.00));

        allToppings.add(new Topping("EXTRA_MEAT", "EXTRA STEAK", 0.50));
        allToppings.add(new Topping("EXTRA_MEAT", "EXTRA HAM", 0.50));
        allToppings.add(new Topping("EXTRA_MEAT", "EXTRA SALAMI", 0.50));
        allToppings.add(new Topping("EXTRA_MEAT", "EXTRA ROAST BEEF", 0.50));
        allToppings.add(new Topping("EXTRA_MEAT", "EXTRA CHICKEN", 0.50));
        allToppings.add(new Topping("EXTRA_MEAT", "EXTRA BACON", 0.50));

        allToppings.add(new Topping("CHEESE", "AMERICAN", 0.75));
        allToppings.add(new Topping("CHEESE", "PROVOLONE", 0.75));
        allToppings.add(new Topping("CHEESE", "CHEDDAR", 0.75));
        allToppings.add(new Topping("CHEESE", "SWISS", 0.75));

        allToppings.add(new Topping("EXTRA_CHEESE", "EXTRA AMERICAN", 0.30));
        allToppings.add(new Topping("EXTRA_CHEESE", "EXTRA PROVOLONE", 0.30));
        allToppings.add(new Topping("EXTRA_CHEESE", "EXTRA CHEDDAR", 0.30));
        allToppings.add(new Topping("EXTRA_CHEESE", "EXTRA AMERICAN", 0.30));

        allToppings.add(new Topping("REGULAR", "LETTUCE", 0.00));
        allToppings.add(new Topping("REGULAR", "PEPPERS", 0.00));
        allToppings.add(new Topping("REGULAR", "ONIONS", 0.00));
        allToppings.add(new Topping("REGULAR", "TOMATOES", 0.00));
        allToppings.add(new Topping("REGULAR", "JALAPENOS", 0.00));
        allToppings.add(new Topping("REGULAR", "CUCUMBERS", 0.00));
        allToppings.add(new Topping("REGULAR", "PICKLES", 0.00));
        allToppings.add(new Topping("REGULAR", "GUACAMOLE", 0.00));
        allToppings.add(new Topping("REGULAR", "MUSHROOMS", 0.00));

        allToppings.add(new Topping("EXTRA_REGULAR", "EXTRA LETTUCE", 0.00));
        allToppings.add(new Topping("EXTRA_REGULAR", "EXTRA PEPPERS", 0.00));
        allToppings.add(new Topping("EXTRA_REGULAR", "EXTRA ONIONS", 0.00));
        allToppings.add(new Topping("EXTRA_REGULAR", "EXTRA TOMATOES", 0.00));
        allToppings.add(new Topping("EXTRA_REGULAR", "EXTRA JALAPENOS", 0.00));
        allToppings.add(new Topping("EXTRA_REGULAR", "EXTRA CUCUMBERS", 0.00));
        allToppings.add(new Topping("EXTRA_REGULAR", "EXTRA PICKLES", 0.00));
        allToppings.add(new Topping("EXTRA_REGULAR", "EXTRA GUACAMOLE", 0.00));
        allToppings.add(new Topping("EXTRA_REGULAR", "EXTRA MUSHROOMS", 0.00));

        allToppings.add(new Topping("SAUCE", "MAYO", 0.00));
        allToppings.add(new Topping("SAUCE", "MUSTARD", 0.00));
        allToppings.add(new Topping("SAUCE", "KETCHUP", 0.00));
        allToppings.add(new Topping("SAUCE", "RANCH", 0.00));
        allToppings.add(new Topping("SAUCE", "THOUSAND ISLAND", 0.00));
        allToppings.add(new Topping("SAUCE", "VINAIGRETTE", 0.00));

        allToppings.add(new Topping("EXTRA_SAUCE", "EXTRA MAYO", 0.00));
        allToppings.add(new Topping("EXTRA_SAUCE", "EXTRA MUSTARD", 0.00));
        allToppings.add(new Topping("EXTRA_SAUCE", "EXTRA KETCHUP", 0.00));
        allToppings.add(new Topping("EXTRA_SAUCE", "EXTRA RANCH", 0.00));
        allToppings.add(new Topping("EXTRA_SAUCE", "EXTRA THOUSAND ISLAND", 0.00));
        allToppings.add(new Topping("EXTRA_SAUCE", "EXTRA VINAIGRETTE", 0.00));

        allToppings.add(new Topping("SIDE", "AU JUS (GRAVY)", 0.00));
        allToppings.add(new Topping("SIDE", "AU JUS (GRAVY)", 0.00));

        return allToppings;
    }
    public static List<String> allGroupTypes (boolean MEAT, boolean EXTRA_MEAT, boolean CHEESE, boolean EXTRA_CHEESE, boolean REGULAR, boolean EXTRA_REGULAR, boolean SAUCE, boolean EXTRA_SAUCE) {
        List<String> groups = new ArrayList<>();
        if (MEAT) groups.add("MEAT");
        if (EXTRA_MEAT) groups.add("EXTRA_MEAT");
        if (CHEESE) groups.add("CHEESE");
        if (EXTRA_CHEESE) groups.add("EXTRA_CHEESE");
        if (REGULAR) groups.add("REGULAR");
        if (EXTRA_REGULAR) groups.add("EXTRA_REGULAR");
        if (SAUCE) groups.add("SAUCE");
        if (EXTRA_SAUCE) groups.add("EXTRA_SAUCE");
        return groups;
    }
    public void getToppingMenuNoPrice (List<String> groupTypes) {
        int counter = 0;
        for (Topping topping : allToppings()) {
            for (String group : groupTypes) {
                if (topping.getGroupType().equals(group)) {
                    System.out.println(counter + ")" + topping.getName());
                    counter ++;
                }
            }
        }
    }
    public void printToppings () {
        for (Topping topping : allToppings()) {
            System.out.println(topping.toString());
        }
    }

    // Getters
    public String getGroupType() {
        return groupType;
    }
    public double getUnitCost() {
        return unitCost;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
