package com.pluralsight.program;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        char function = UserInterface.MAIN_MENU.getMenuCode();

        while (function != UserInterface.EXIT_APP.getMenuCode()) {

            function = UserInterface.fromCodeReturnAction(function, "ALL");

            if (function == UserInterface.EXIT_APP.getMenuCode()) { // 'X'
                Menu.SCANNER.close();
                UserInterface.fromCodeReturnAction('X', "ALL");
                break;
            }
        }
    }
}
