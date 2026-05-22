package com.pluralsight.kendoughs_waffles.models.enums;

public enum FillFlavor {
    NUTELLA("Nutella"),
    CREAM_CHEESE("Cream Cheese"),
    JAM("Strawberry Jam"),
    STRAWBERRY("Strawberry");

    public final String label;

    FillFlavor(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
