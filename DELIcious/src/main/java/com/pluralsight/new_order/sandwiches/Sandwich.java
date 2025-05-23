package com.pluralsight.new_order.sandwiches;

import com.pluralsight.design.Design;
import com.pluralsight.new_order.Size;
import com.pluralsight.new_order.SizeInterface;
import com.pluralsight.new_order.sandwiches.sandwich_contents.Topping;

import java.util.List;

public class Sandwich implements SizeInterface {
    private final Size sandwichSize;
    private final double price;
    private final String breadType;
    private final List<Topping> toppings;

    public Sandwich(Size sandwichSize, String breadType, List<Topping> toppings) {
        this.sandwichSize = sandwichSize;
        this.price = calcPriceFromSize(sandwichSize) + totalToppingPrice();
        this.breadType = breadType;
        this.toppings = toppings;
    }

    // Size -> price conversion
    public double calcPriceFromSize (Size sandwichSize) {
        return switch (sandwichSize) {
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
    public Sandwich makeSandwich () {

    }

    // Getters //
    public Size getSandwichSize() {
        return sandwichSize;
    }
    public double getPrice() {
        return price;
    }
    public String getBreadType() {
        return breadType;
    }
    public List<Topping> getToppings() {
        return toppings;
    }
}
