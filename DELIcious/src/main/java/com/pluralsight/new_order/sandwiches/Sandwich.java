package com.pluralsight.new_order.sandwiches;

import com.pluralsight.new_order.Size;
import com.pluralsight.new_order.SizeInterface;
import com.pluralsight.new_order.sandwiches.sandwich_contents.Bread;
import com.pluralsight.new_order.sandwiches.sandwich_contents.Topping;

import java.util.List;


public class Sandwich implements SizeInterface {
    protected Size sandwichSize;
    private double price;
    private Bread bread;
    private List<Topping> toppings;

    // Public Defined constructor
    public Sandwich(Size sandwichSize, Bread bread, List<Topping> toppings) {
        this.sandwichSize = sandwichSize;
        this.bread = bread;
        this.toppings = toppings;
        this.price = calcPriceFromSize(sandwichSize) + totalToppingPrice();
    }

    // Private empty constructor
    public Sandwich() {
    }

    // Size -> price conversion
    public double calcPriceFromSize (Size size) {
        return switch (this.sandwichSize) {
            case  SMALL -> 5.50;
            case MEDIUM -> 7.00;
            case LARGE -> 8.50;
        };
    }

    // Gets price for all toppings and adds it to total
    private double totalToppingPrice () {
        double sum = 0;
        for (Topping topping : this.toppings) {
            sum += topping.calcPriceFromSize(this.sandwichSize);
        } return sum;
    }

    // Modifies topping arraylist for use in toString
    private String toppingsAdded () {
        boolean found = false;
        StringBuilder toppings = new StringBuilder();
        for (Topping topping : this.toppings) {
            toppings.append("|").append(topping);
            found = true;
        }
        if (!found) {
            toppings.append("|NO TOPPING");
        }
        return toppings.toString();
    }

    // Getters //
    public double getPrice() {
        return price;
    }



   //toString
    public String toString() {
        return  "SANDWICH|" + sandwichSize + "|" + "SANDWICH" + "|" + bread + toppingsAdded() + "|$" + price + "|";
    }
}
