package com.pluralsight.new_order.extras;

import com.pluralsight.design.Design;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class Sides {
    String name;

    public Sides(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<Sides> allSides () {
        List<Sides> allSides = new ArrayList<>();
        allSides.add(new Sides("MAYO"));
        allSides.add(new Sides("MUSTARD"));
        allSides.add(new Sides("KETCHUP"));
        allSides.add(new Sides("RANCH"));
        allSides.add(new Sides("THOUSAND ISLAND"));
        allSides.add(new Sides("VINAIGRETTE"));
        allSides.add(new Sides("HUMMUS"));
        allSides.add(new Sides("BUFFALO"));
        allSides.add(new Sides("AU JUS (GRAVY)"));
        return allSides;
    }
    public static LinkedHashMap<Integer, Sides> printSides () {
        LinkedHashMap<Integer, Sides> sidesMap = new LinkedHashMap<>();
        int counter = 0;
        for (Sides side : allSides()) {
            counter++;
            System.out.println(counter + ") " + side.getName());
            sidesMap.put(counter, side);
        }
        return sidesMap;
    }
    public static Sides selectedSide (LinkedHashMap<Integer, Sides> sidesMap, int choice) {
        return sidesMap.get(choice);
    }
    public static Sides makeSide (Scanner scanner) {
        Design.titleNewLineTop();
        Design.systemMessage("What side would you like to add?", false);
        LinkedHashMap<Integer, Sides> availableSides = printSides();
        Design.titleLineBottom();
        int choice = Design.getIntWithMaxMin(scanner, false, "", true, 0, availableSides.size());
        return selectedSide(availableSides, choice);
    }

    @Override
    public String toString() {
        return "SIDE|" + name;
    }
}
