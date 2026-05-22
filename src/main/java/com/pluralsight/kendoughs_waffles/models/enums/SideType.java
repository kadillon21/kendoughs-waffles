package com.pluralsight.kendoughs_waffles.models.enums;

public enum SideType {
    HASH_BROWNS("Hash Browns", 1.50),
    WAFFLE_FRIES("Waffle Fries", 1.50),
    BACON("Bacon", 2.00),
    FRUIT_CUP("Fruit Cup", 2.00);

    private final String label;
    private final double price;

    SideType(String label, double basePrice) {
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
