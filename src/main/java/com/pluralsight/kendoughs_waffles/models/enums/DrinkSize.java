package com.pluralsight.kendoughs_waffles.models.enums;

public enum DrinkSize {
    SMALL("Small", 2.00),
    MEDIUM("Medium", 2.50),
    LARGE("Large", 3.00);

    private final String label;
    private final double price;

    DrinkSize(String label, double basePrice) {
        this.label = label;
        this.price = basePrice;
    }

    public String getLabel() {
        return label;
    }

    public double getPrice() {
        return price;
    }

}
