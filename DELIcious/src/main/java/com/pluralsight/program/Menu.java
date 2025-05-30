package com.pluralsight.program;

import com.pluralsight.new_order.Order;
import com.pluralsight.new_order.OrderFileManager;
import com.pluralsight.new_order.Size;
import com.pluralsight.new_order.add_ons.Chips;
import com.pluralsight.new_order.add_ons.Drinks;
import com.pluralsight.new_order.add_ons.Sides;
import com.pluralsight.new_order.sandwiches.Sandwich;
import com.pluralsight.new_order.sandwiches.sandwich_contents.Bread;
import com.pluralsight.new_order.sandwiches.sandwich_contents.Topping;
import com.pluralsight.program.design.Design;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static final Scanner SCANNER = new Scanner(System.in);

    ///  --------------------------------------- MASTER-MENU-SECTION ---------------------------------------------------------------------------------///

    // Essential Functions
    public static char mainMenu () {
        return UserInterface.menuTemplate(SCANNER, "Welcome to myApp.", "ORDER_ACTION|ESSENTIAL");
    }
    public static char exitApp() {
    System.out.println("Thank you for using myApp\nGoodbye!");
    return 'X';
}

    ///  --------------------------------------- ORDER-SECTION -------------------------------------------------------------------------------------- ///

    // High Level Method for use through Master Menu
    public static char processOrder () {
        Order newOrder = Menu.makeOrder(SCANNER);
        try {
            if (newOrder == null) {
                System.out.println("Order Cancelled");
            } else {
                OrderFileManager.writeReceipt(newOrder);
                System.out.println("Here is your receipt!");
                System.out.println(newOrder);
            }
        } catch (NullPointerException ignored) {
            System.out.println("Order Cancelled");
        }
        Design.timer1000();
        return '0';
    }

    // Chips Methods worked for UI use
    private static List<Chips> allChips() {
        List<Chips> allChips = new ArrayList<>();
        allChips.add(new Chips("Lay's Classic"));
        allChips.add(new Chips("Doritos Nacho Cheese"));
        allChips.add(new Chips("Cheetos Crunchy"));
        allChips.add(new Chips("Ruffles Sour Cream & Onion"));
        allChips.add(new Chips("Pringles Original"));
        allChips.add(new Chips("Takis Fuego"));
        allChips.add(new Chips("SunChips Harvest Cheddar"));
        allChips.add(new Chips("Kettle Cooked Jalapeño"));
        allChips.add(new Chips("Bugles"));
        allChips.add(new Chips("Frito's Chili Cheese"));
        return allChips;
    }
    private static LinkedHashMap<Integer, Chips> chipsMapAndPrint () {
        LinkedHashMap<Integer, Chips> availableChips = new LinkedHashMap<>();
        int counter = 0;
        for (Chips chips: allChips()) {
            counter++;
            System.out.println(counter + ") " + chips.getName());
            availableChips.put(counter, chips);
        }return availableChips;
    }
    private static Chips selectedChips (int choice, LinkedHashMap<Integer, Chips> availableChips) {
        return availableChips.get(choice);
    }

    // Chips UI Methods
    public static Chips makeChips(Scanner scanner) {
        Design.titleNewLineTop();
        Design.systemMessage("What drink would you like?", false);
        LinkedHashMap<Integer, Chips> availableChips = chipsMapAndPrint();
        Design.titleLineBottom();

        int choice = Design.getIntWithMinMax(scanner, false, "", true, 1, availableChips.size());

        return selectedChips(choice, availableChips);
    }

    // Drinks Methods worked for UI Use
    private static List<Drinks> allDrinks () {
        List<Drinks> allDrinks = new ArrayList<>();
        allDrinks.add(new Drinks(Size.LARGE, "Dr. Pepper"));
        allDrinks.add(new Drinks(Size.LARGE, "Coca-Cola"));
        allDrinks.add(new Drinks(Size.MEDIUM, "Sweet Tea"));
        allDrinks.add(new Drinks(Size.SMALL, "Lemonade"));
        allDrinks.add(new Drinks(Size.LARGE, "Peach Iced Tea"));
        allDrinks.add(new Drinks(Size.MEDIUM, "Root Beer"));
        allDrinks.add(new Drinks(Size.SMALL, "Sparkling Water (Lime)"));
        allDrinks.add(new Drinks(Size.LARGE, "Cherry Dr. Pepper"));
        allDrinks.add(new Drinks(Size.MEDIUM, "Strawberry Fanta"));
        allDrinks.add(new Drinks(Size.SMALL, "Green Tea"));

        return allDrinks;
    }
    private static LinkedHashMap<Integer, Drinks> drinkMapAndPrint() {
        LinkedHashMap<Integer, Drinks> drinkMap = new LinkedHashMap<>();
        int counter = 0;
        for (Drinks drink : allDrinks()) {
            counter++;
            System.out.println(counter + ") " + drink.getFlavor());
            drinkMap.put(counter, drink);
        }return drinkMap;
    }
    private static Drinks selectedDrink (LinkedHashMap<Integer, Drinks> availableDrinks, int choice) {
        return availableDrinks.get(choice);
    }

    // Drinks UI Methods
    public static Drinks makeDrink (Scanner scanner)  {
        Size size = Size.getSize(scanner);
        Design.titleNewLineTop();
        Design.systemMessage("What drink would you like?", false);
        LinkedHashMap<Integer, Drinks> availableDrinks = drinkMapAndPrint();
        Design.titleLineBottom();

        int choice = Design.getIntWithMinMax(scanner, false, "", true, 1, availableDrinks.size());

        return new Drinks(size, selectedDrink(availableDrinks, choice).getFlavor());


    }

    // Sandwich Methods worked for UI use
    private static LinkedHashMap<Integer, Sandwich> sigSandwichList (Bread bread, Size size) {
        LinkedHashMap<Integer, Sandwich> signatures = new LinkedHashMap<>();
        signatures.put(1, new Sandwich(size, bread, List.of(
                new Topping("MEAT", "STEAK", 1.00),
                new Topping("CHEESE", "CHEDDAR", 0.75),
                new Topping("REGULAR", "ONIONS", 0.00),
                new Topping("REGULAR", "MUSHROOMS", 0.00),
                new Topping("SAUCE", "AU JUS (GRAVY)", 0.00)
        )));
        signatures.put(2, new Sandwich(size, bread, List.of(
                new Topping("MEAT", "SALAMI", 1.00),
                new Topping("MEAT", "HAM", 1.00),
                new Topping("MEAT", "PEPPERONI", 1.00),
                new Topping("CHEESE", "PROVOLONE", 0.75),
                new Topping("REGULAR", "LETTUCE", 0.00),
                new Topping("REGULAR", "TOMATOES", 0.00),
                new Topping("SAUCE", "VINAIGRETTE", 0.00)
        )));
        signatures.put(3, new Sandwich(size, bread, List.of(
                new Topping("MEAT", "CHICKEN", 1.00),
                new Topping("MEAT", "BACON", 1.00),
                new Topping("CHEESE", "CHEDDAR", 0.75),
                new Topping("REGULAR", "LETTUCE", 0.00),
                new Topping("SAUCE", "RANCH", 0.00)
        )));
        signatures.put(4, new Sandwich(size, bread, List.of(
                new Topping("MEAT", "ROAST BEEF", 1.00),
                new Topping("CHEESE", "PEPPER JACK", 0.75),
                new Topping("CHEESE", "AMERICAN", 0.75),
                new Topping("REGULAR", "JALAPENOS", 0.00),
                new Topping("REGULAR", "JALAPENOS", 0.00),
                new Topping("SAUCE", "MAYO", 0.00)
        )));
        signatures.put(5, new Sandwich(size, bread, List.of(
                new Topping("REGULAR", "LETTUCE", 0.00),
                new Topping("REGULAR", "TOMATOES", 0.00),
                new Topping("REGULAR", "ONIONS", 0.00),
                new Topping("REGULAR", "CUCUMBERS", 0.00),
                new Topping("REGULAR", "PICKLES", 0.00),
                new Topping("SAUCE", "VINAIGRETTE", 0.00)
        )));
        signatures.put(6, new Sandwich(size, bread, List.of(
                new Topping("MEAT", "TURKEY", 1.00), // Not defined, substitute:
                new Topping("MEAT", "CHICKEN", 1.00),
                new Topping("MEAT", "BACON", 1.00),
                new Topping("CHEESE", "SWISS", 0.75),
                new Topping("REGULAR", "TOMATOES", 0.00),
                new Topping("SAUCE", "MAYO", 0.00)
        )));
        signatures.put(7, new Sandwich(size, bread, List.of(
                new Topping("MEAT", "HAM", 1.00),
                new Topping("MEAT", "SALAMI", 1.00),
                new Topping("MEAT", "ROAST BEEF", 1.00),
                new Topping("CHEESE", "PROVOLONE", 0.75)
        )));
        signatures.put(8, new Sandwich(size, bread, List.of(
                new Topping("MEAT", "CHICKEN", 1.00),
                new Topping("CHEESE", "CHEDDAR", 0.75),
                new Topping("REGULAR", "PICKLES", 0.00),
                new Topping("SAUCE", "MUSTARD", 0.00)
        )));
        signatures.put(9, new Sandwich(size, bread, List.of(
                new Topping("MEAT", "BACON", 1.00),
                new Topping("EXTRA_MEAT", "EXTRA BACON", 0.50),
                new Topping("CHEESE", "AMERICAN", 0.75),
                new Topping("SAUCE", "KETCHUP", 0.00)
        )));
        return signatures;
    }

    // Sandwich UI Methods
    private static Sandwich makeSigSandwich (Scanner scanner, Size size, Bread bread) {
        Design.titleNewLineTop();
        Design.systemMessage("""
                SIGNATURE SANDWICHES
                
                1) STEAKHOUSE SPECIAL
                2) ITALIAN
                3) CHICKEN, BACON, RANCH
                4) SPICY SOUTHWEST
                5) VEGGIE SUPREME
                6) THE CLUB SUB
                7) MEAT LOVERS
                8) CHICKEN AND CHEDDAR
                9) BACON BLAST""", false
        );
        Design.titleLineBottom();
        int choice = Design.getIntWithMinMax(scanner, false, "", true, 0, 9);
        return sigSandwichList(bread, size).get(choice);
    }
    public static Sandwich makeSandwich(Scanner scanner) {
        Sandwich sandwich = new Sandwich();
        List<Topping> toppings = new ArrayList<>();

        boolean sigSandwich = Design.getYesNo(scanner, true, "Would you like one of our signature sandwiches?");
        Size size = Size.getSize(scanner);
        Bread bread = Bread.getBread(scanner);

        if (sigSandwich) sandwich = makeSigSandwich(scanner, size, bread);
        else toppings = Topping.getToppings(scanner, false);

        boolean extra = Design.getYesNo(scanner, true, "Do you want to add extra toppings?");

        if (extra) toppings.addAll(Topping.getToppings(scanner, true));
        if (!sigSandwich) sandwich = new Sandwich(size, bread, toppings);


        return sandwich;
    }

    // Order UI Methods
    public static Order makeOrder(Scanner scanner) {
        List<Sandwich> sandwiches = new ArrayList<>();
        List<Chips> chips = new ArrayList<>();
        List<Drinks> drinks = new ArrayList<>();
        List<Sides> sides = new ArrayList<>();
        Order newOrder = new Order(sandwiches, chips, drinks, sides);
        while (true) {
            Design.systemMessage("""
                    What would you like to add?
                    0) Finish Order
                    
                    1) Add Sandwich
                    2) Add Drink
                    3) Add Chips
                    4) Add Side (SAUCE)
                    5) View Order
                    6) Cancel Order
                    """, true
            );
            int choice = Design.getIntWithMinMax(scanner, false, "", true, 0, 6);
            switch (choice) {
                case 0 -> {
                    return newOrder;
                }
                case 1 -> sandwiches.add(Menu.makeSandwich(scanner));
                case 2 -> drinks.add(Menu.makeDrink(scanner));
                case 3 -> chips.add(Menu.makeChips(scanner));
                case 4 -> sides.add(Sides.makeSide(scanner));
                case 5 -> System.out.println(newOrder);
                case 6 -> {
                    return null;
                }

                default -> System.out.println("Please choose from listed options.");
            }
        }
    }
}
