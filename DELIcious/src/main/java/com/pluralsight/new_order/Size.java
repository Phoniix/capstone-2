package com.pluralsight.new_order;

import com.pluralsight.program.design.Design;

import java.util.Scanner;

public enum Size {
    SMALL,
    MEDIUM,
    LARGE;

    public static Size getSize(Scanner scanner) {
        int choice = Design.getIntWithMinMax(scanner, true, """
                What size would you like?
                1) SMALL
                2) MEDIUM
                3) LARGE""", true, 1, 3
        );
        return switch (choice) {
            case 1 -> SMALL;
            case 2 -> MEDIUM;
            case 3 -> LARGE;
            default -> null;
        };
    }
}
