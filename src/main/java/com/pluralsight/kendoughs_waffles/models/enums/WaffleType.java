package com.pluralsight.kendoughs_waffles.models.enums;

public enum WaffleType {
    // Enum values
    BUTTER_MILK("Butter Milk", 4.99),
    BELGIAN("Belgian", 5.49),
    LIEGE("Liege", 5.99),
    CHURRO("Churro", 5.99),
    RED_VELVET("Red Velvet", 6.49);

    // Declared label and price for enum values
    private final String label;
    private final double price;

    // Constructor
    WaffleType(String label, double price) {
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
