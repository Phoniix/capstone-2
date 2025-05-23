package com.pluralsight.new_order;

public enum Size implements SizeInterface {
    SMALL,
    MEDIUM,
    LARGE;


    public double calcPriceFromSize(Size size) {
        return 0;
    }
}
