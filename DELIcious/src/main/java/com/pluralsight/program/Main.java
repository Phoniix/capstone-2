package com.pluralsight.program;

import java.io.IOException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws IOException, ParseException, InterruptedException {
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
