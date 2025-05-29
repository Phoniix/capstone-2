package com.pluralsight.program;

import com.pluralsight.new_order.Order;
import com.pluralsight.new_order.sandwiches.Sandwich;

import java.util.Scanner;

public class MenuReferenceHandler {
    public static Scanner scanner = new Scanner(System.in);
    public static char mainMenu () {
        return MenuReference.menuTemplate(scanner, "Welcome to myApp.", "ESSENTIAL|ORDER_ACTION");
    }
    public static char exitApp() {
    System.out.println("Thank you for using myApp\nGoodbye!");
    return 'X';
}

    public static char processOrder() {
        return Order.processOrder(scanner);
    }



}
