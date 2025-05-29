package com.pluralsight.new_order.sandwiches.sandwich_contents;

import com.pluralsight.program.design.Design;

import java.util.Scanner;

public enum Bread {
    WHITE,
    WHEAT,
    RYE,
    WRAP;

    // UI Methods
    public static Bread getBread (Scanner scanner) {
        int choice = Design.getIntWithMaxMin(scanner, true, """
                Which bread would you like?
                1) WHITE
                2) WHEAT
                3) RYE
                4) WRAP""", true, 1, 4);
        return switch (choice) {
            case 1 -> WHITE;
            case 2 -> WHEAT;
            case 3 -> RYE;
            case 4 -> WRAP;
            default -> null;
        };
    }
}
