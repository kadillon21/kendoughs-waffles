package com.pluralsight.kendoughs_waffles.models.enums;

public enum WaffleSize {
    MINI("Mini", 0),
    REGULAR("Regular", 1.50),
    LARGE("Large", 3.00);

    private final String label;
    private final double price;

    WaffleSize(String label, double price) {
        this.label = label;
        this.price = price;
    }

    public String getLabel() {
        return label;
    }

    public double getPrice() {
        return price;
    }
}
