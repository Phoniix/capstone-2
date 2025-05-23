package com.pluralsight.new_order.extras;

import com.pluralsight.new_order.Size;
import com.pluralsight.new_order.SizeInterface;

public class Drinks implements SizeInterface {
    Size drinkSize;
    double price;

    // Constructor
    public Drinks(Size drinkSize) {
        this.drinkSize = drinkSize;
        this.price = calcPriceFromSize(drinkSize);
    }

    // Size -> price conversion
    public double calcPriceFromSize(Size drinkSize) {
        return switch (drinkSize) {
            case  SMALL -> 2.00;
            case MEDIUM -> 2.50;
            case LARGE -> 3.00;
            default -> 0;
        };
    }
}
