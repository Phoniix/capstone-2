package com.pluralsight.program.design;

import java.util.*;


//@SuppressWarnings("unused")

public class Design {

    //Styles //
    public static void titleNewLineTop () {
        System.out.println("\n════════════════════════════════════════════════════════════════════════");
    }
    public static void titleLineBottom () {
        System.out.println("════════════════════════════════════════════════════════════════════════");
    }
    public static void timer1000 () {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }
    private static String autoCap (String input) {
        String [] inputParts = input.toLowerCase().split(" ");
        for (int i = 0; i < inputParts.length; i++) {
            inputParts [i] = inputParts [i].substring(0, 1).toUpperCase() + inputParts [i].substring(1);
        }
        return String.join(" ", inputParts);
    }

    //Booleans //
    public static boolean isEmpty (String input) {
        return input.isEmpty();
    }
    private static boolean isInt (String input, boolean isPositive) {
        try {
            if (input.matches("\\d+")) {
                Integer.parseInt(input);
                if (isPositive) {if (Integer.parseInt(input) < 0) {System.out.println("Input must be a positive number"); return false;}}
                return true;
            } else {
                System.out.println("Incorrect number: " + input);
            }
        } catch (NumberFormatException e) {
            System.out.println("Number not in correct format. Please use whole numbers.");
            return false;
        }
        return false;
    }

    // System Messages //
    public static void thisFieldCantBeEmpty () {
        System.out.println("This Field Cannot Be Empty!");
    }
    private static void enterPrompt () {
        System.out.print("\n\nEnter:  ");
    }
    public static void systemMessage (String message, boolean visualSpacers) {
        if (visualSpacers) Design.titleNewLineTop();
        System.out.println(message);
        if (visualSpacers) Design.titleNewLineTop();
    }

    // User Input //
    public static int getIntFromPrompt(Scanner scanner, boolean prompt, String question, boolean isPositive) {
        boolean keepGoing = true;
        String userInput = null;

        while (keepGoing) {
            if (prompt) {
                titleNewLineTop();
                System.out.println(question);
                titleLineBottom();
            }
            enterPrompt();
            userInput = scanner.nextLine().trim().replaceAll("\\s+", " ");
            if (isEmpty(userInput))  {thisFieldCantBeEmpty(); continue;}
            if (!isInt(userInput, isPositive)) {System.out.println("Please use correct number format."); continue;}
            keepGoing = false;
        }
        return Integer.parseInt(userInput);
    }
    public static int getIntWithMinMax(Scanner scanner, boolean prompt, String question, boolean isPositive, int min, int max) {
        boolean keepGoing = true;
        int i = 0;
        while (keepGoing) {
            i = Design.getIntFromPrompt(scanner, prompt, question, isPositive);
            if (min > i || max < i) {
                System.out.println("Please choose a number in range.");
                continue;
            }
            keepGoing = false;
        }
        return i;
    }
    public static String getNounPrompt(Scanner scanner, boolean prompt ,String question, boolean autoCapitalize) {
        while (true) {
            if (prompt) {
                titleNewLineTop();
                System.out.println(question);
                titleLineBottom();
            }
            enterPrompt();
            String userInput = scanner.nextLine().trim().replaceAll("\\s+", " ");
            if (isEmpty(userInput)) {thisFieldCantBeEmpty(); continue;}
            if (autoCapitalize) {userInput = autoCap(userInput);}
            return userInput;
        }
    }
    public static String getGeneralStringNoPrompt (Scanner scanner) {
        boolean keepGoing = true;
        String userInput = null;

        while (keepGoing) {
            enterPrompt();
            userInput = scanner.nextLine().trim().replaceAll("\\s+", " ");
            if (isEmpty(userInput)) {thisFieldCantBeEmpty(); continue;}
            keepGoing = false;

        }
        return userInput;
    }
    public static boolean getYesNo (Scanner scanner, boolean prompt, String message) {
        String input;
        while (true) {
            if (prompt) {
                Design.titleNewLineTop();
                if (!message.isEmpty()) System.out.println(message);
                System.out.println("Yes or No? (Y) ? (N)");
                Design.titleLineBottom();
            }
            input = Design.getNounPrompt(scanner, false, "", false).toUpperCase();
            switch (input.charAt(0)) {
                case 'Y' -> {return true;}
                case 'N' -> {return false;}
                default -> System.out.println("Please enter (Y) for yes (N) for no.");
            }
        }
    }
}
