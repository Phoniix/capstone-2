package com.pluralsight.new_order.chips_drinks_sides;

import com.pluralsight.program.design.Design;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class Sides {
    String name;

    // Defined Constructor
    public Sides(String name) {
        this.name = name;
    }

    // Getters
    public String getName() {
        return name;
    }

    // Methods worked for UI use
    private static List<Sides> allSides () {
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
    private static LinkedHashMap<Integer, Sides> sidesMapAndPrint () {
        LinkedHashMap<Integer, Sides> sidesMap = new LinkedHashMap<>();
        int counter = 0;
        for (Sides side : allSides()) {
            counter++;
            System.out.println(counter + ") " + side.getName());
            sidesMap.put(counter, side);
        }
        return sidesMap;
    }
    private static Sides selectedSide (LinkedHashMap<Integer, Sides> sidesMap, int choice) {
        return sidesMap.get(choice);
    }

    // UI Methods
    public static Sides makeSide (Scanner scanner) {
        Design.titleNewLineTop();
        Design.systemMessage("What side would you like to add?", false);
        LinkedHashMap<Integer, Sides> availableSides = sidesMapAndPrint();
        Design.titleLineBottom();

        int choice = Design.getIntWithMinMax(scanner, false, "", true, 0, availableSides.size());

        return selectedSide(availableSides, choice);
    }

    //toString
    public String toString() {
        return "SIDE|" + name;
    }
}
