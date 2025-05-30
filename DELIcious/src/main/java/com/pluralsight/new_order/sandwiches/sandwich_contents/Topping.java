package com.pluralsight.new_order.sandwiches.sandwich_contents;

import com.pluralsight.program.design.Design;
import com.pluralsight.new_order.Size;
import com.pluralsight.new_order.SizeInterface;

import java.util.*;

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
            case MEDIUM -> 2 * this.unitCost;
            case LARGE -> 3 * this.unitCost;
        };
    }

    // Hardcoded Arraylist of ALL toppings
    public static List<Topping> allToppings () {
        List<Topping> allToppings = new ArrayList<>();
        allToppings.add(new Topping("MEAT", "STEAK", 1.00));
        allToppings.add(new Topping("MEAT", "HAM", 1.00));
        allToppings.add(new Topping("MEAT", "SALAMI", 1.00));
        allToppings.add(new Topping("MEAT", "PEPPERONI", 1.00));
        allToppings.add(new Topping("MEAT", "ROAST BEEF", 1.00));
        allToppings.add(new Topping("MEAT", "CHICKEN", 1.00));
        allToppings.add(new Topping("MEAT", "EGG", 1.00));
        allToppings.add(new Topping("MEAT", "BACON", 1.00));
        allToppings.add(new Topping("MEAT", "PULLED PORK", 1.00));

        allToppings.add(new Topping("EXTRA_MEAT", "EXTRA STEAK", 0.50));
        allToppings.add(new Topping("EXTRA_MEAT", "EXTRA HAM", 0.50));
        allToppings.add(new Topping("EXTRA_MEAT", "EXTRA SALAMI", 0.50));
        allToppings.add(new Topping("EXTRA_MEAT", "EXTRA PEPPERONI", 1.00));
        allToppings.add(new Topping("EXTRA_MEAT", "EXTRA ROAST BEEF", 0.50));
        allToppings.add(new Topping("EXTRA_MEAT", "EXTRA CHICKEN", 0.50));
        allToppings.add(new Topping("EXTRA_MEAT", "EXTRA EGG", 0.50));
        allToppings.add(new Topping("EXTRA_MEAT", "EXTRA BACON", 0.50));
        allToppings.add(new Topping("EXTRA_MEAT", "EXTRA PULLED PORK", 1.00));

        allToppings.add(new Topping("CHEESE", "AMERICAN", 0.75));
        allToppings.add(new Topping("CHEESE", "PROVOLONE", 0.75));
        allToppings.add(new Topping("CHEESE", "PEPPER JACK", 0.75));
        allToppings.add(new Topping("CHEESE", "CHEDDAR", 0.75));
        allToppings.add(new Topping("CHEESE", "SWISS", 0.75));

        allToppings.add(new Topping("EXTRA_CHEESE", "EXTRA AMERICAN", 0.30));
        allToppings.add(new Topping("EXTRA_CHEESE", "EXTRA PROVOLONE", 0.30));
        allToppings.add(new Topping("EXTRA_CHEESE", "EXTRA PEPPER JACK", 0.30));
        allToppings.add(new Topping("EXTRA_CHEESE", "EXTRA CHEDDAR", 0.30));
        allToppings.add(new Topping("EXTRA_CHEESE", "EXTRA AMERICAN", 0.30));

        allToppings.add(new Topping("REGULAR", "AVOCADO", 0.00));
        allToppings.add(new Topping("REGULAR", "LETTUCE", 0.00));
        allToppings.add(new Topping("REGULAR", "PEPPERS", 0.00));
        allToppings.add(new Topping("REGULAR", "ONIONS", 0.00));
        allToppings.add(new Topping("REGULAR", "ONION ", 0.00));
        allToppings.add(new Topping("REGULAR", "TOMATOES", 0.00));
        allToppings.add(new Topping("REGULAR", "JALAPENOS", 0.00));
        allToppings.add(new Topping("REGULAR", "CUCUMBERS", 0.00));
        allToppings.add(new Topping("REGULAR", "PICKLES", 0.00));
        allToppings.add(new Topping("REGULAR", "GUACAMOLE", 0.00));
        allToppings.add(new Topping("REGULAR", "MUSHROOMS", 0.00));

        allToppings.add(new Topping("EXTRA_REGULAR", "EXTRA AVOCADO", 0.00));
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
        allToppings.add(new Topping("SAUCE", "HUMMUS", 0.00));
        allToppings.add(new Topping("SAUCE", "BUFFALO", 0.00));
        allToppings.add(new Topping("SAUCE", "AU JUS (GRAVY)", 0.00));

        allToppings.add(new Topping("EXTRA_SAUCE", "EXTRA MAYO", 0.00));
        allToppings.add(new Topping("EXTRA_SAUCE", "EXTRA MUSTARD", 0.00));
        allToppings.add(new Topping("EXTRA_SAUCE", "EXTRA KETCHUP", 0.00));
        allToppings.add(new Topping("EXTRA_SAUCE", "EXTRA RANCH", 0.00));
        allToppings.add(new Topping("EXTRA_SAUCE", "EXTRA THOUSAND ISLAND", 0.00));
        allToppings.add(new Topping("EXTRA_SAUCE", "EXTRA VINAIGRETTE", 0.00));
        allToppings.add(new Topping("EXTRA_SAUCE", "EXTRA HUMMUS", 0.00));
        allToppings.add(new Topping("EXTRA_SAUCE", "EXTRA BUFFALO", 0.00));
        allToppings.add(new Topping("EXTRA_SAUCE", "EXTRA AU JUS (GRAVY)", 0.00));

        return allToppings;
    }

    // Methods worked for UI purposes
    private static List<String> allGroupTypes (boolean isExtra) {
        List<String> groups = new ArrayList<>();
        if (!isExtra) groups.add("MEAT");
        if (isExtra) groups.add("EXTRA_MEAT");
        if (!isExtra) groups.add("CHEESE");
        if (isExtra) groups.add("EXTRA_CHEESE");
        if (!isExtra) groups.add("REGULAR");
        if (isExtra) groups.add("EXTRA_REGULAR");
        if (!isExtra) groups.add("SAUCE");
        if (isExtra) groups.add("EXTRA_SAUCE");
        return groups;
    }
    private static LinkedHashMap<Integer, String> printGroupType(List<String> groupTypes) {
        LinkedHashMap <Integer, String> selectedTypes = new LinkedHashMap<>();
        int counter = 0;
            for (String group : groupTypes) {
                counter++;
                System.out.println(counter + ") "  + group);
                selectedTypes.put(counter, group);
            }
        return selectedTypes;
    }
    private static LinkedHashMap<Integer, Topping> printToppingFromGroupType (LinkedHashMap<Integer, String> groupTypes, int choice) {
        LinkedHashMap<Integer, Topping> toppingsByGroup = new LinkedHashMap<>();
        int counter = 0;
        for (Topping topping : allToppings()) {
            if (groupTypes.get(choice).equals(topping.getGroupType())) {
                counter++;
                System.out.println(counter + ") " + topping);
                toppingsByGroup.put(counter, topping);
            }
        }
         return toppingsByGroup;
    }
    private static Topping selectedTopping (int choice, LinkedHashMap<Integer, Topping> availableToppings) {
        return availableToppings.get(choice);
    }

    // UI Methods
    public static List<Topping> getToppings(Scanner scanner, boolean isExtra) {
        List<Topping> chosenToppings = new ArrayList<>();
        while (true) {
            Design.titleNewLineTop();
            Design.systemMessage("""
                    What toppings would you like?
                    Press 0 to finish.
                    
                    0) Finish Sandwich
                    """, false);
            LinkedHashMap<Integer, String> viewableTypes = printGroupType(allGroupTypes(isExtra));
            int choice =  Design.getIntWithMinMax(scanner, false, "", true, 0, viewableTypes.size());
            Design.titleLineBottom();
            if (choice == 0) break;

            Design.titleNewLineTop();
            Design.systemMessage("""
                    What toppings would you like?
                    Press 0 to finish.
                    
                    0) Finish Toppings
                    """, false
            );
            LinkedHashMap<Integer, Topping> viewableToppings = printToppingFromGroupType(viewableTypes, choice);
            choice = Design.getIntWithMinMax(scanner, false, "", true, 0, viewableToppings.size());
            Design.titleLineBottom();
            if (choice == 0) break;

            chosenToppings.add(selectedTopping(choice, viewableToppings));
        }
        return chosenToppings;
    }

    // Getters
    private String getGroupType() {
        return groupType;
    }

    // toString
    public String toString() {
        return name;
    }
}
