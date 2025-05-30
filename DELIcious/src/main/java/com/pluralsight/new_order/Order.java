package com.pluralsight.new_order;

import com.pluralsight.new_order.add_ons.Chips;
import com.pluralsight.new_order.add_ons.Drinks;
import com.pluralsight.new_order.add_ons.Sides;
import com.pluralsight.new_order.sandwiches.Sandwich;

import java.util.List;

public class Order {
    private final List<Sandwich> sandwiches;
    private final List<Chips> chips;
    private final List<Drinks> drinks;
    private final List<Sides> sides;

    // Public Defined constructor
    public Order(List<Sandwich> sandwiches, List<Chips> chips, List<Drinks> drinks, List<Sides> sides) {
        this.sandwiches = sandwiches;
        this.chips = chips;
        this.drinks = drinks;
        this.sides = sides;
    }

    // Price calculation
    private double getTotalPrice () {
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
