package com.pluralsight.kendoughs_waffles.models.enums;

public enum WaffleType {
    BUTTER_MILK("Butter Milk"),
    BELGIAN("Belgian"),
    LIEGE("Liege"),
    CHURRO("Churro"),
    RED_VELVET("Red Velvet");

    private final String label;

    WaffleType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
