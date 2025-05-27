package com.pluralsight.new_order.sandwiches.sandwich_contents;

import com.pluralsight.design.Design;

import java.util.Scanner;

public enum Bread {
    WHITE,
    WHEAT,
    RYE,
    WRAP;

    public static Bread getBread (Scanner scanner) {
        while (true) {
            int choice = Design.getIntWithMaxMin(scanner, true, "Which bread would you like?\n" +
                    "1) WHITE\n" +
                    "2) WHEAT\n" +
                    "3) RYE\n" +
                    "4) WRAP", true, 1, 4);
            return switch (choice) {
                case 1 -> WHITE;
                case 2 -> WHEAT;
                case 3 -> RYE;
                case 4 -> WRAP;
                default -> null;
            };
        }
    }
}
