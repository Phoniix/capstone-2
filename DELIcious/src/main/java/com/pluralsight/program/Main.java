package com.pluralsight.program;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MenuReference function = MenuReference.MAIN_MENU;
        while (function.getMenuCode() != MenuReference.EXIT_APP.getMenuCode()) {

            function = MenuReference.

            if (function.getMenuCode() == MenuReference.EXIT_APP.getMenuCode()) { // 'X'
                MenuReference.EXIT_APP.getMenuCode();
                break;
            }
        }
    }
}
