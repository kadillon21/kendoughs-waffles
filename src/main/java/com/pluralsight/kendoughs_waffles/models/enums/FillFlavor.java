package com.pluralsight.kendoughs_waffles.models.enums;

public enum FillFlavor {
    NONE("None", 0),
    NUTELLA("Nutella", 1.5),
    CREAM_CHEESE("Cream Cheese", 1.5),
    JAM("Strawberry Jam", 1.5),
    STRAWBERRY("Strawberry", 1.5);

    public final String label;
    public final double price;

    FillFlavor(String label, double price) {
        this.label = label;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getLabel() {
        return label;
    }
}
