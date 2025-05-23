package com.pluralsight.new_order;

import com.pluralsight.new_order.extras.Chips;
import com.pluralsight.new_order.extras.Drinks;
import com.pluralsight.new_order.sandwiches.Sandwich;

import java.util.List;

public class Order {
    private double price;
    private List<Sandwich> sandwiches;
    private List<Chips> chips;
    private List<Drinks> drinks;

    public Order(List<Sandwich> sandwiches, List<Chips> chips, List<Drinks> drinks) {
        this.sandwiches = sandwiches;
        this.chips = chips;
        this.drinks = drinks;
    }


}
