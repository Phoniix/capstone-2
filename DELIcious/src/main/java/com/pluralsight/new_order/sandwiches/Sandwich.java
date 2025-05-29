package com.pluralsight.new_order.sandwiches;

import com.pluralsight.program.design.Design;
import com.pluralsight.new_order.Size;
import com.pluralsight.new_order.SizeInterface;
import com.pluralsight.new_order.sandwiches.sandwich_contents.Bread;
import com.pluralsight.new_order.sandwiches.sandwich_contents.Topping;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class Sandwich implements SizeInterface {
    protected Size sandwichSize;
    private double price;
    private Bread bread;
    private List<Topping> toppings;

    // Public Defined constructor
    public Sandwich(Size sandwichSize, Bread bread, List<Topping> toppings) {
        this.sandwichSize = sandwichSize;
        this.bread = bread;
        this.toppings = toppings;
        this.price = calcPriceFromSize(sandwichSize) + totalToppingPrice();
    }

    // Private empty constructor
    private Sandwich() {
    }

    // Size -> price conversion
    public double calcPriceFromSize (Size size) {
        return switch (this.sandwichSize) {
            case  SMALL -> 5.50;
            case MEDIUM -> 7.00;
            case LARGE -> 8.50;
        };
    }

    // Gets price for all toppings and adds it to total
    private double totalToppingPrice () {
        double sum = 0;
        for (Topping topping : this.toppings) {
            sum += topping.calcPriceFromSize(this.sandwichSize);
        } return sum;
    }

    // UI Prepared Methods
    private static LinkedHashMap<Integer, Sandwich> sigSandwichList (Bread bread, Size size) {
        LinkedHashMap<Integer, Sandwich> signatures = new LinkedHashMap<>();
        signatures.put(1, new Sandwich(size, bread, List.of(
                new Topping("MEAT", "STEAK", 1.00),
                new Topping("CHEESE", "CHEDDAR", 0.75),
                new Topping("REGULAR", "ONIONS", 0.00),
                new Topping("REGULAR", "MUSHROOMS", 0.00),
                new Topping("SAUCE", "AU JUS (GRAVY)", 0.00)
        )));
        signatures.put(2, new Sandwich(size, bread, List.of(
                new Topping("MEAT", "SALAMI", 1.00),
                new Topping("MEAT", "HAM", 1.00),
                new Topping("MEAT", "PEPPERONI", 1.00),
                new Topping("CHEESE", "PROVOLONE", 0.75),
                new Topping("REGULAR", "LETTUCE", 0.00),
                new Topping("REGULAR", "TOMATOES", 0.00),
                new Topping("SAUCE", "VINAIGRETTE", 0.00)
        )));
        signatures.put(3, new Sandwich(size, bread, List.of(
                new Topping("MEAT", "CHICKEN", 1.00),
                new Topping("MEAT", "BACON", 1.00),
                new Topping("CHEESE", "CHEDDAR", 0.75),
                new Topping("REGULAR", "LETTUCE", 0.00),
                new Topping("SAUCE", "RANCH", 0.00)
        )));
        signatures.put(4, new Sandwich(size, bread, List.of(
                new Topping("MEAT", "ROAST BEEF", 1.00),
                new Topping("CHEESE", "PEPPER JACK", 0.75),
                new Topping("CHEESE", "AMERICAN", 0.75),
                new Topping("REGULAR", "JALAPENOS", 0.00),
                new Topping("REGULAR", "JALAPENOS", 0.00),
                new Topping("SAUCE", "MAYO", 0.00)
        )));
        signatures.put(5, new Sandwich(size, bread, List.of(
                new Topping("REGULAR", "LETTUCE", 0.00),
                new Topping("REGULAR", "TOMATOES", 0.00),
                new Topping("REGULAR", "ONIONS", 0.00),
                new Topping("REGULAR", "CUCUMBERS", 0.00),
                new Topping("REGULAR", "PICKLES", 0.00),
                new Topping("SAUCE", "VINAIGRETTE", 0.00)
        )));
        signatures.put(6, new Sandwich(size, bread, List.of(
                new Topping("MEAT", "TURKEY", 1.00), // Not defined, substitute:
                new Topping("MEAT", "CHICKEN", 1.00),
                new Topping("MEAT", "BACON", 1.00),
                new Topping("CHEESE", "SWISS", 0.75),
                new Topping("REGULAR", "TOMATOES", 0.00),
                new Topping("SAUCE", "MAYO", 0.00)
        )));
        signatures.put(7, new Sandwich(size, bread, List.of(
                new Topping("MEAT", "HAM", 1.00),
                new Topping("MEAT", "SALAMI", 1.00),
                new Topping("MEAT", "ROAST BEEF", 1.00),
                new Topping("CHEESE", "PROVOLONE", 0.75)
        )));
        signatures.put(8, new Sandwich(size, bread, List.of(
                new Topping("MEAT", "CHICKEN", 1.00),
                new Topping("CHEESE", "CHEDDAR", 0.75),
                new Topping("REGULAR", "PICKLES", 0.00),
                new Topping("SAUCE", "MUSTARD", 0.00)
        )));
        signatures.put(9, new Sandwich(size, bread, List.of(
                new Topping("MEAT", "BACON", 1.00),
                new Topping("EXTRA_MEAT", "EXTRA BACON", 0.50),
                new Topping("CHEESE", "AMERICAN", 0.75),
                new Topping("SAUCE", "KETCHUP", 0.00)
        )));
        return signatures;
    }

    // UI Methods
    private static Sandwich makeSigSandwich (Scanner scanner, Size size, Bread bread, LinkedHashMap<Integer, Sandwich> sandwiches) {
        Design.titleNewLineTop();
        Design.systemMessage("""
                SIGNATURE SANDWICHES
                
                1) STEAKHOUSE SPECIAL
                2) ITALIAN
                3) CHICKEN, BACON, RANCH
                4) SPICY SOUTHWEST
                5) VEGGIE SUPREME
                6) THE CLUB SUB
                7) MEAT LOVERS
                8) CHICKEN AND CHEDDAR
                9) BACON BLAST""", false
        );
        Design.titleLineBottom();
        int choice = Design.getIntWithMinMax(scanner, false, "", true, 0, 9);
        return sigSandwichList(bread, size).get(choice);
    }
    public static Sandwich makeSandwich(Scanner scanner) {
        Sandwich sandwich = new Sandwich();
        List<Topping> toppings = new ArrayList<>();

        while (true) {
            boolean sigSandwich = Design.getYesNo(scanner, true, "Would you like one of our signature sandwiches?");
            Size size = Size.getSize(scanner);
            Bread bread = Bread.getBread(scanner);

            if (sigSandwich) sandwich = makeSigSandwich(scanner, size, bread, sigSandwichList(bread, size));
            else toppings = Topping.getToppings(scanner, size, false);

            boolean extra = Design.getYesNo(scanner, true, "Do you want to add extra toppings?");

            if (extra) toppings.addAll(Topping.getToppings(scanner, size, true));
            if (!sigSandwich) sandwich = new Sandwich(size, bread, toppings);

            break;
        }
        return sandwich;
    }

    // Getters //
    public double getPrice() {
        return price;
    }

    private String toppingsAdded () {
        boolean found = false;
        StringBuilder toppings = new StringBuilder();
        for (Topping topping : this.toppings) {
            toppings.append("|").append(topping);
            found = true;
        }
        if (!found) {
            toppings.append("|NO TOPPING");
        }
        return toppings.toString();
    }

   //toString
    public String toString() {
        return  "SANDWICH|" + sandwichSize + "|" + "SANDWICH" + "|" + bread + toppingsAdded() + "|" + price + "|";
    }
}
