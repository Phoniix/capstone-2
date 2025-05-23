package com.pluralsight.program;

import com.pluralsight.design.Design;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainHandler {
    public char menuTemplate (Scanner scanner, String menuMessage, List<Object> menuOptions) {
        char userChoice;
        while (true) {
            Design.titleNewLineTop();
            System.out.println(menuMessage + "\n");

        }
    }
    public void printMenu (List<Object> menuOptions) {
        int counter = 0;
        for (Object option : menuOptions) {
            System.out.println(counter + ") " + option);
        }
    }
    public List<String> menuOptions (boolean op1, boolean op2, boolean op3) {
        List<String> menuOptions = new ArrayList<>();

    }
}
