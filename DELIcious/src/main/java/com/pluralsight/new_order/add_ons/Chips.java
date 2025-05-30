package com.pluralsight.new_order.add_ons;

public class Chips {
    double price;
    String name;

    public Chips(String name) {
        this.name = name;
        this.price = 1.50;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "CHIPS|" + name + "|$" + price + "|" ;
    }
}
