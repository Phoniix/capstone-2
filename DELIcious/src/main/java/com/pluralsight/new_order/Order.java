package com.pluralsight.new_order;

import com.pluralsight.program.design.Design;
import com.pluralsight.new_order.chips_drinks_sides.Chips;
import com.pluralsight.new_order.chips_drinks_sides.Drinks;
import com.pluralsight.new_order.chips_drinks_sides.Sides;
import com.pluralsight.new_order.sandwiches.Sandwich;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {
    private List<Sandwich> sandwiches;
    private List<Chips> chips;
    private List<Drinks> drinks;
    private List<Sides> sides;

    // Public Defined constructor
    public Order(List<Sandwich> sandwiches, List<Chips> chips, List<Drinks> drinks, List<Sides> sides) {
        this.sandwiches = sandwiches;
        this.chips = chips;
        this.drinks = drinks;
        this.sides = sides;
    }

    // Private Undefined constructor
    private Order() {
    }

    // Price calculation
    public double getTotalPrice () {
        double sum = 0;
        for (Sandwich sandwich : this.sandwiches)  {
            sum += sandwich.getPrice();
        }
        for (Drinks drinks : this.drinks) {
            sum += drinks.getPrice();
        }
        for (Chips chips : this.chips) {
            sum += chips.getPrice();
        }
        return sum;
    }

    // UI Methods
    public Order makeOrder(Scanner scanner) {
        List<Sandwich> sandwiches = new ArrayList<>();
        List<Chips> chips = new ArrayList<>();
        List<Drinks> drinks = new ArrayList<>();
        List<Sides> sides = new ArrayList<>();
        Order newOrder = new Order(sandwiches, chips, drinks, sides);
        while (true) {
            Design.systemMessage("""
                    What would you like to add?
                    0) Finish Order
                    
                    1) Add Sandwich
                    2) Add Drink
                    3) Add Chips
                    4) Add Side (SAUCE)
                    5) View Order
                    """, true
            );
            int choice = Design.getIntWithMaxMin(scanner, false, "", true, 0, 5);
            switch (choice) {
                case 0 -> {
                    return newOrder;
                }
                case 1 -> sandwiches.add(Sandwich.makeSandwich(scanner));
                case 2 -> drinks.add(Drinks.makeDrink(scanner));
                case 3 -> chips.add(Chips.makeChips(scanner));
                case 4 -> sides.add(Sides.makeSide(scanner));
                case 5 -> System.out.println(newOrder);

                default -> System.out.println("Please choose from listed options.");
            }
        }
    }
    public static char processOrder (Scanner scanner) {
        Order newOrder = new Order ();
        newOrder = newOrder.makeOrder(scanner);
        OrderFileManager.writeReceipt(newOrder);
        System.out.println("Here is your receipt!");
        System.out.println(newOrder);
        Design.timer1000();
        return '0';
    }

    // toString
    public String toString() {
        StringBuilder order = new StringBuilder();
        order.append("════════════════════════════════════════════════════════════════════════");
        for (Sandwich sandwiches : this.sandwiches) {
            order.append("\n").append(sandwiches.toString());
        }
        for (Drinks drinks : this.drinks) {
            order.append("\n").append(drinks.toString());
        }
        for (Chips chips : this.chips) {
            order.append("\n").append(chips.toString());
        }
        for (Sides side : this.sides) {
            order.append("\n").append(side.toString());
        }
        order.append("\nTotal Price: ").append(getTotalPrice());
        order.append("\n════════════════════════════════════════════════════════════════════════");

        return order.toString();
    }
}
