package com.pluralsight.program;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class MenuReferenceHandler {
    public static Scanner scanner = new Scanner(System.in);
    public static char mainMenu () {
        return MenuReference.menuTemplate(scanner, "Welcome to myApp.", "ESSENTIALS");
    }
    public static char exitApp() {
    System.out.println("Thank you for using myApp\nGoodbye!");
    return 'X';
}



}
