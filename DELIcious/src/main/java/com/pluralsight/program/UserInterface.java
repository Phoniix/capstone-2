package com.pluralsight.program;

import com.pluralsight.program.design.Design;

import java.util.Scanner;

public enum UserInterface {



    //FORBIDDEN CODES: 'X' '0' 'Z'

    // Essential Functions
    MAIN_MENU("ESSENTIAL", '0', "MAIN MENU", Menu::mainMenu),
    EXIT_APP("ESSENTIAL", 'X', "EXIT APP", Menu::exitApp),

    // Order options //
    MAKE_NEW_ORDER("ORDER_ACTION", '1', "MAKE NEW ORDER", Menu::processOrder);

    // Enum Variables // ----------------------------------------------------------------------------------------------
    private final char MENU_CODE;
    private final MenuReturnType<Character> ACTION;
    private final String MENU_TITLE;
    private final String ACTION_TYPE;

    // Enum Constructor // --------------------------------------------------------------------------------------------
     UserInterface(String actionType, char menuCode, String menuTitle, MenuReturnType<Character> action) {
        this.MENU_CODE = menuCode;
        this.ACTION = action;
        this.MENU_TITLE = menuTitle;
        this.ACTION_TYPE = actionType;
    }



    // Basic Getters for each variable // -----------------------------------------------------------------------------
    public char getMenuCode() {
        return MENU_CODE;
    } // Char enum reference
    public String getMenuTitle() {
        return MENU_TITLE;
    } // String menu name (EX: "DISPLAY ALL TRANSACTIONS")
    public String getACTION_TYPE() {
        return ACTION_TYPE;
    } // String menu item type (MAIN_DISPLAY || MAIN_FUNCTION)
    public char runAction () throws InterruptedException {
        return ACTION.get();
    } // Char return type, can pass other
    // variables using R in ThrowingSupplier to remote method (ONLY T = t.get() || T apply R (variableType) = t.apply(R) ).

    //region
    // Custom Functions for menu // -----------------------------------------------------------------------------------
//    public String fromCodeReturnTitle (char code, String actionTypeSplitByPipe) {
//       for (MenuReference menuList : MenuReference.values()) {
//           if (menuList.getMenuCode() == code) {
//               return menuList.getMenuTitle();
//           }
//       }
//       return null;
//    }
//    public char manualCallAction (MenuReference label) throws IOException, ParseException, InterruptedException {
//        for (MenuReference menuList : MenuReference.values()) {
//            if (menuList == label) {
//                return menuList.runAction();
//            }
//        }
//        return 'Z';
//    }
//    public char screenChange (Scanner scanner, String messageToDisplay, String actionTypeSplitByPipe) {
//        char userChoice = '0';
//        boolean properChoiceMade = false;
//        Scanner userInput = new Scanner(System.in);
//        while (!properChoiceMade) {
//            Design.titleNewLineTop();
//            System.out.println(messageToDisplay + "\n");
//            MenuReference.printMenu(actionTypeSplitByPipe);
//            Design.titleLineBottom();
//            String userChoiceInput = Design.getGeneralStringNoPrompt(scanner);
//            userChoice = MenuReference.getCodeFromUserInputString(userChoiceInput, actionTypeSplitByPipe);
//            return userChoice;
//        }
//        return userChoice;
//    }
    //endregion
    // Statics //
    public static char menuTemplate(Scanner scanner, String menuMessage, String actionTypeSplitByPipes) {
        char userSelection = '0';
        boolean keepGoing = true;
        while (keepGoing) {
            Design.titleNewLineTop();
            System.out.println(menuMessage + "\n");
            UserInterface.printMenu(actionTypeSplitByPipes);
            Design.titleLineBottom();
            String userSelectionInput = Design.getGeneralStringNoPrompt(scanner);
            userSelection = UserInterface.getCodeFromUserInputString(userSelectionInput, actionTypeSplitByPipes);
            keepGoing = false;
        }
        return userSelection;
    }
    public static char fromCodeReturnAction(char code, String actionTypeSplitByPipe) throws  InterruptedException {
        for (UserInterface menuList : UserInterface.values()) {
            if (!actionTypeSplitByPipe.equalsIgnoreCase("ALL")) { // Only use ALL for MASTER MENU
                if (menuList.getMenuCode() == code && menuList.getACTION_TYPE().toUpperCase().contains(actionTypeSplitByPipe.toUpperCase())) {
                    return menuList.runAction(); // Will find and run any menu action from code & code group name (code, actionSplitByPipe).
                }
            } else { // Master list Access (KEYWORD: "ALL")
                if (menuList.getMenuCode() == code) {
                    return menuList.runAction();
                }
            }
        }
        return '0';
    }
    public static char getCodeFromUserInputString(String input, String checkActionTypeSplitByPipe) {
        if (Design.isEmpty(input)) {Design.thisFieldCantBeEmpty(); return 'Z';}
        if (input.matches("^[a-zA-Z\\d]$")) {
            char inputToChar = input.toUpperCase().charAt(0);
            if (!UserInterface.checkStringForCode(inputToChar, checkActionTypeSplitByPipe)) {
                return 'Z';
            }
            return inputToChar;
        } else return 'Z';
    }
    public static boolean checkStringForCode(char code, String actionTypeSplitByPipe) {
        for (UserInterface menuList : UserInterface.values()) {
            if (!actionTypeSplitByPipe.equalsIgnoreCase("ALL")) {
                if (menuList.getMenuCode() == code && actionTypeSplitByPipe.toUpperCase().contains(menuList.getACTION_TYPE().toUpperCase())) {
                    return true;
                }
            } else {
                if (menuList.getMenuCode() == code) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void printMenu(String actionTypeSplitByPipe) {
        String [] actions = actionTypeSplitByPipe.split("\\|");
        for (String action : actions) {
            for (UserInterface menuList : UserInterface.values()) {
                if (menuList.getACTION_TYPE().toUpperCase().contains(action.trim().toUpperCase()))
                    System.out.println("(" + menuList.getMenuCode() + ") " + menuList.getMenuTitle());
            }
            System.out.println();
        }
    }

    //region
    //Custom Menus for this.Program // --------------------------------------------------------------------------------
//    public char mainMenu(Scanner scanner, String appWelcomeMessage, String actionTypeSplitByPipe) {
//        return menuTemplate(scanner, appWelcomeMessage, actionTypeSplitByPipe);
//    }
//    public char entryScreen (Scanner scanner, String appWelcomeMessage, String actionTypeSplitByPipe) {
//        return menuTemplate(scanner, appWelcomeMessage, actionTypeSplitByPipe);
//    }
//    public char exitApp (String message) {
//        Design.titleNewLineTop();
//        System.out.println(message + ", \n" +
//                "Goodbye!");
//        Design.titleLineBottom();
//        Design.timer1000();
//        return 'X';
//    }
    //endregion

}
