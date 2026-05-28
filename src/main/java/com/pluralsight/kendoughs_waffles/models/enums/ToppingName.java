package com.pluralsight.kendoughs_waffles.models.enums;

public enum ToppingName {
    // Enum values
    // Regular toppings
    WHIPPED_CREAM("Whipped Cream"),
    POWDERED_SUGAR("Powdered Sugar"),
    MAPLE_SYRUP("Maple Syrup"),
    CINNAMON("Cinnamon"),
    BUTTER("Butter"),
    CARAMEL_DRIZZLE("Caramel Drizzle"),
    // Premium toppings
    NUTELLA("Nutella"),
    FRESH_STRAWBERRIES("Fresh Strawberries"),
    BACON_CRUMBLES("Bacon Crumbles"),
    ICE_CREAM("Ice Cream Scoop"),
    FRESH_BLUEBERRIES("Fresh Blueberries"),
    COOKIE_BUTTER("Cookie Butter");

    // Declared label for enum values
    private final String label;

    // Constructor
    ToppingName(String label) {
        this.label = label;
    }

    // Method to get label
    public String getLabel() {
        return label;
    }
}
