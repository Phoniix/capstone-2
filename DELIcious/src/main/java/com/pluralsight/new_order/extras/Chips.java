package com.pluralsight.new_order.extras;

import java.util.ArrayList;
import java.util.List;

public class Chips {
    double price;
    String name;

    public Chips(String name) {
        this.name = name;
        this.price = 1.50;
    }

    List<Chips> allChips () {
        List<Chips> allChips = new ArrayList<>();
        allChips.add(new Chips("Lay's Classic"));
        allChips.add(new Chips("Doritos Nacho Cheese"));
        allChips.add(new Chips("Cheetos Crunchy"));
        allChips.add(new Chips("Ruffles Sour Cream & Onion"));
        allChips.add(new Chips("Pringles Original"));
        allChips.add(new Chips("Takis Fuego"));
        allChips.add(new Chips("SunChips Harvest Cheddar"));
        allChips.add(new Chips("Kettle Cooked Jalapeño"));
        allChips.add(new Chips("Bugles"));
        allChips.add(new Chips("Frito's Chili Cheese"));
        return allChips;
    }

    @Override
    public String toString() {
        return "Chips: " + name;
    }
}
