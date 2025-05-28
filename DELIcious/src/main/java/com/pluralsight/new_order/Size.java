package com.pluralsight.new_order;

import com.pluralsight.design.Design;

import java.util.Scanner;

public enum Size {
    SMALL,
    MEDIUM,
    LARGE;


    public double calcPriceFromSize(Size size) {
        return 0;
    }

    public static Size getSize(Scanner scanner) {
        int choice = Design.getIntWithMaxMin(scanner, true, "What size would you like?\n" +
                "1) SMALL\n" +
                "2) MEDIUM\n" +
                "3) LARGE", true, 1, 3
        );
        return switch (choice) {
            case 1 -> SMALL;
            case 2 -> MEDIUM;
            case 3 -> LARGE;
            default -> null;
        };
    }
}
