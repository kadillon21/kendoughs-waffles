package com.pluralsight.kendoughs_waffles.models.enums;

public enum DrinkFlavor {
    // enum values
    COFFEE("Coffee"),
    OJ("Orange Juice"),
    MILK("Milk"),
    LEMONADE("Lemonade"),
    APPLE_JUICE("Apple Juice"),
    CRANBERRY_JUICE("Cranberry Juice");

    // declared label for enum values
    private final String label;

    // constructor
    DrinkFlavor(String label) {
        this.label = label;
    }

    // method to get label
    public String getLabel() {
        return label;
    }
}
