package com.pluralsight.new_order;

import com.pluralsight.design.Design;
import com.pluralsight.new_order.extras.Chips;
import com.pluralsight.new_order.extras.Drinks;
import com.pluralsight.new_order.sandwiches.Sandwich;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Order {
    private double totalPrice;
    private List<Sandwich> sandwiches;
    private List<Chips> chips;
    private List<Drinks> drinks;

    public Order(List<Sandwich> sandwiches, List<Chips> chips, List<Drinks> drinks) {
        this.sandwiches = sandwiches;
        this.chips = chips;
        this.drinks = drinks;
    }

    public void printOrder (List<Object> food) {
        food.stream()
                .forEach(item -> System.out.println(item.toString()));
    }

    public Order makeOrder(Scanner scanner) {
        while (true) {
            Design.systemMessage("What would you like to add?\n" +
                    "0) Finish Order\n" +
                    "1) Add Sandwich\n" +
                    "2) Add Drink\n" +
                    "3) Add Chips", true
            );
            int choice = Design.getIntWithMaxMin(scanner, false, "", true, 0, 4);
            switch (choice) {
                case 0 -> {break;}
                case 1 -> this.sandwiches.add(Sandwich.makeSandwich(scanner));
                case 2 -> this.drinks.add(Drinks.makeDrink(scanner));
                case 3 -> this.chips.add(Chips.makeChips(scanner));
                default -> System.out.println("Please choose from listed options.");
            }
        }
    }

    public static char processOrder (Scanner scanner) {
        Order newOrder = null;
        newOrder = newOrder.makeOrder(scanner);
    }


}
