package com.pluralsight.new_order.add_ons;

import com.pluralsight.new_order.Size;
import com.pluralsight.new_order.SizeInterface;

public class Drinks implements SizeInterface {
    private final Size drinkSize;
    private final String flavor;
    private final double price;

    // Constructor
    public Drinks(Size drinkSize, String flavor) {
        this.drinkSize = drinkSize;
        this.flavor = flavor;
        this.price = calcPriceFromSize(drinkSize);
    }


    // Size -> price conversion
    public double calcPriceFromSize(Size size) {
        return switch (this.drinkSize) {
            case  SMALL -> 2.00;
            case MEDIUM -> 2.50;
            case LARGE -> 3.00;
        };
    }

    // Getters
    public String getFlavor() {
        return flavor;
    }
    public double getPrice() {
        return price;
    }

    // toString
    public String toString() {
        return "DRINK|" + drinkSize + "|" + flavor + "|$" + price;
    }
}
