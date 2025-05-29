package com.pluralsight.program;

import com.pluralsight.new_order.Order;

import java.util.Scanner;

public class MenuReferenceHandler {
    public static final Scanner SCANNER = new Scanner(System.in);

    // Essential Functions
    public static char mainMenu () {
        return MenuReference.menuTemplate(SCANNER, "Welcome to myApp.", "ESSENTIAL|ORDER_ACTION");
    }
    public static char exitApp() {
    System.out.println("Thank you for using myApp\nGoodbye!");
    return 'X';
}

    // App Function
    public static char processOrder() {
        return Order.processOrder(SCANNER);
    }



}
