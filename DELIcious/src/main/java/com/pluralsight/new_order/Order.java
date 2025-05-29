package com.pluralsight.new_order;

import com.pluralsight.design.Design;
import com.pluralsight.new_order.extras.Chips;
import com.pluralsight.new_order.extras.Drinks;
import com.pluralsight.new_order.sandwiches.Sandwich;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Order {
    private double totalPrice;
    private List<Sandwich> sandwiches;
    private List<Chips> chips;
    private List<Drinks> drinks;

    // Defined constructor
    public Order(List<Sandwich> sandwiches, List<Chips> chips, List<Drinks> drinks) {
        this.sandwiches = sandwiches;
        this.chips = chips;
        this.drinks = drinks;
    }

    // Undefined constructor
    public Order() {
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

    // Methods worked for UI use
    public Order makeOrder(Scanner scanner) {
        List<Sandwich> sandwiches = new ArrayList<>();
        List<Chips> chips = new ArrayList<>();
        List<Drinks> drinks = new ArrayList<>();
        Order newOrder = new Order(sandwiches, chips, drinks);
        while (true) {
            Design.systemMessage("What would you like to add?\n" +
                    "0) Finish Order\n\n" +
                    "1) Add Sandwich\n" +
                    "2) Add Drink\n" +
                    "3) Add Chips\n" +
                    "4) View Order", true
            );
            int choice = Design.getIntWithMaxMin(scanner, false, "", true, 0, 4);
            switch (choice) {
                case 0 -> {
                    return newOrder;
                }
                case 1 -> sandwiches.add(Sandwich.makeSandwich(scanner));
                case 2 -> drinks.add(Drinks.makeDrink(scanner));
                case 3 -> chips.add(Chips.makeChips(scanner));
                case 4 -> {
                    Design.newLineTop();
                    System.out.println(newOrder);
                    Design.lineBottom();
                }
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


    public String toString() {
        StringBuilder order = new StringBuilder();
        order.append("════════════════════════════════════════════════════════════════════════");
        for (Sandwich sandwiches : this.sandwiches) {
            order.append("\n" + sandwiches.toString());
            //System.out.println(sandwiches);
        }
        for (Drinks drinks : this.drinks) {
            order.append("\n" + drinks.toString());
            //System.out.println(drinks);
        }
        for (Chips chips : this.chips) {
            order.append("\n" + chips.toString());
            //System.out.println(chips);
        }
        order.append("════════════════════════════════════════════════════════════════════════");
        return order.toString();
    }
}
