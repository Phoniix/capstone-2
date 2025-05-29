package com.pluralsight.new_order.chips_drinks_sides;

import com.pluralsight.program.design.Design;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

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

    // Methods worked for UI use
    private static List<Chips> allChips() {
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
    private static LinkedHashMap<Integer, Chips> chipsMapAndPrint () {
        LinkedHashMap<Integer, Chips> availableChips = new LinkedHashMap<>();
        int counter = 0;
        for (Chips chips: allChips()) {
            counter++;
            System.out.println(counter + ") " + chips.getName());
            availableChips.put(counter, chips);
        }return availableChips;
    }
    private static Chips selectedChips (int choice, LinkedHashMap<Integer, Chips> availableChips) {
        return availableChips.get(choice);
    }

    // UI Methods
    public static Chips makeChips(Scanner scanner) {
        Design.titleNewLineTop();
        Design.systemMessage("What drink would you like?", false);
        LinkedHashMap<Integer, Chips> availableChips = chipsMapAndPrint();
        Design.titleLineBottom();

        int choice = Design.getIntWithMinMax(scanner, false, "", true, 1, availableChips.size());

        return selectedChips(choice, availableChips);
    }

    @Override
    public String toString() {
        return "CHIPS|" + name + "|";
    }
}
