package com.pluralsight.kendoughs_waffles.models.enums;

public enum FillFlavor {
    // Enum values
    NONE("None", 0),
    NUTELLA("Nutella", 1.5),
    CREAM_CHEESE("Cream Cheese", 1.5),
    JAM("Strawberry Jam", 1.5),
    STRAWBERRY("Strawberry", 1.5);

    // Declared label and price for enum values
    public final String label;
    public final double price;

    // Constructor
    FillFlavor(String label, double price) {
        this.label = label;
        this.price = price;
    }

    // Method to get label and price
    public double getPrice() {
        return price;
    }

    public String getLabel() {
        return label;
    }
}
