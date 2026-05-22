package com.pluralsight.kendoughs_waffles.models.enums;

public enum DrinkFlavor {
    COFFEE("Coffee"),
    OJ("Orange Juice"),
    MILK("Milk"),
    LEMONADE("Lemonade"),
    APPLE_JUICE("Apple Juice"),
    CRANBERRY_JUICE("Cranberry Juice");

    private final String label;

    DrinkFlavor(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
