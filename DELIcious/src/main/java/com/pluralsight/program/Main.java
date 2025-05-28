package com.pluralsight.program;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException, ParseException, InterruptedException {
        char function = MenuReference.MAIN_MENU.getMenuCode();

        while (function != MenuReference.EXIT_APP.getMenuCode()) {

            function = MenuReference.fromCodeReturnAction(function, "ALL");

            if (function == MenuReference.EXIT_APP.getMenuCode()) { // 'X'
                MenuReference.fromCodeReturnAction('X', "ALL");
                break;
            }
        }
    }
}
