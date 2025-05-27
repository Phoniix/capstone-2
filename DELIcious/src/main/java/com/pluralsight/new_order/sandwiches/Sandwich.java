package com.pluralsight.new_order.sandwiches;

import com.pluralsight.design.Design;
import com.pluralsight.new_order.Size;
import com.pluralsight.new_order.SizeInterface;
import com.pluralsight.new_order.sandwiches.sandwich_contents.Bread;
import com.pluralsight.new_order.sandwiches.sandwich_contents.Topping;

import java.util.List;
import java.util.Scanner;

import static com.pluralsight.new_order.sandwiches.sandwich_contents.Topping.allToppings;

public class Sandwich implements SizeInterface {
    protected final Size sandwichSize;
    private final double price;
    private final Bread bread;
    private final List<Topping> toppings;

    public Sandwich(Size sandwichSize, Bread bread, List<Topping> toppings) {
        this.sandwichSize = sandwichSize;
        this.price = calcPriceFromSize(sandwichSize) + totalToppingPrice();
        this.bread = bread;
        this.toppings = toppings;
    }


    // Size -> price conversion
    public double calcPriceFromSize (Size size) {
        return switch (this.sandwichSize) {
            case  SMALL -> 5.50;
            case MEDIUM -> 7.00;
            case LARGE -> 8.50;
            default -> 0;
        };
    }

    // Gets price for all toppings and adds it to total
    public double totalToppingPrice () {
        double sum = 0;
        for (Topping topping : this.toppings) {
            if (this.toppings == null || topping == null) break;
            sum += topping.calcPriceFromSize(this.sandwichSize);
        } return sum;
    }

    // UI Prepared Methods
    public char makeSandwich (Scanner scanner) {
        Size size = Size.getSize(scanner);
        Bread bread = Bread.getBread(scanner);
        for (Topping topping : allToppings()) {

        }
    }

    // Getters //
    public Size getSandwichSize() {
        return sandwichSize;
    }
    public double getPrice() {
        return price;
    }
    public Bread getBreadType() {
        return bread;
    }
    public List<Topping> getToppings() {
        return toppings;
    }

    public String toppingsAdded () {
        boolean found = false;
        StringBuilder toppings = new StringBuilder();
        for (Topping topping : this.toppings) {
            toppings.append("|" + topping);
            found = true;
        }
        if (!found) {
            toppings.append("| NO TOPPING");
        }
        return toppings.toString();
    }

    @Override
    public String toString() {
        return sandwichSize + "|" + "Sandwich" + "|" + bread + toppingsAdded();
    }
}
