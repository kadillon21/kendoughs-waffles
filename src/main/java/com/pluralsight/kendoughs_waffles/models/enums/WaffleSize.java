package com.pluralsight.kendoughs_waffles.models.enums;

public enum WaffleSize {
    // Enum values
    MINI("Mini", 0),
    REGULAR("Regular", 1.50),
    LARGE("Large", 3.00);

    // Declared label and price for enum values
    private final String label;
    private final double price;

    // Constructor
    WaffleSize(String label, double price) {
        this.label = label;
        this.price = price;
    }

    // Methods to get label and price
    public String getLabel() {
        return label;
    }

    public double getPrice() {
        return price;
    }
}
