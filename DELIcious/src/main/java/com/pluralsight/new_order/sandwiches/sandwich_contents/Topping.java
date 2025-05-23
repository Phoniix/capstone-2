package com.pluralsight.new_order.sandwiches.sandwich_contents;

import com.pluralsight.new_order.Size;
import com.pluralsight.new_order.SizeInterface;

import java.util.ArrayList;
import java.util.List;

public class Topping implements SizeInterface{
    double unitCost; // Cost when portion size is SMALL.
    String name;
    String groupType;

    // Defined Constructor
    public Topping(String groupType, String type, double unitCost) {
        this.unitCost = unitCost;
        this.name = type;
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
    public List<Topping> allToppings () {
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

        return allToppings;
    }
    public static List<String> allGroupTypes (boolean MEAT, boolean EXTRA_MEAT, boolean CHEESE, boolean EXTRA_CHEESE, boolean REGULAR, boolean EXTRA_REGULAR) {
        List<String> groups = new ArrayList<>();
        if (MEAT) groups.add("MEAT");
        if (EXTRA_MEAT) groups.add("EXTRA_MEAT");
        if (CHEESE) groups.add("CHEESE");
        if (EXTRA_CHEESE) groups.add("EXTRA_CHEESE");
        if (REGULAR) groups.add("REGULAR");
        if (EXTRA_REGULAR) groups.add("EXTRA_REGULAR");
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

}
