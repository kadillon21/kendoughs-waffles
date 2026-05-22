package com.pluralsight.kendoughs_waffles.models.enums;

public enum WaffleSize {
    MINI("Mini", 5.00),
    REGULAR("Regular", 7.00),
    LARGE("Large", 9.00);

    private final String label;
    private final double basePrice;

    WaffleSize(String label, double basePrice) {
        this.label = label;
        this.basePrice = basePrice;
    }

    public String getLabel() {
        return label;
    }
}
