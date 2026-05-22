package com.pluralsight.kendoughs_waffles.models.enums;

public enum WaffleSize {
    MINI("Mini"),
    REGULAR("Regular"),
    LARGE("Large");

    private final String label;

    WaffleSize(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
