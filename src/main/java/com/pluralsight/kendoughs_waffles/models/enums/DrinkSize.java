package com.pluralsight.kendoughs_waffles.models.enums;

public enum DrinkSize {
    // Enum values
    SMALL("Small", 2.00),
    MEDIUM("Medium", 2.50),
    LARGE("Large", 3.00);

    // Declared label for enum values
    private final String label;
    private final double price;

    DrinkSize(String label, double basePrice) {
        this.label = label;
        this.price = basePrice;
    }

    // Method to get label
    public String getLabel() {
        return label;
    }

    // Method to get price
    public double getPrice() {
        return price;
    }

}
