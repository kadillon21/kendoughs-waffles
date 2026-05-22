package com.pluralsight.kendoughs_waffles.models;

import com.pluralsight.kendoughs_waffles.models.enums.DrinkFlavor;
import com.pluralsight.kendoughs_waffles.models.enums.DrinkSize;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Drink extends Product{
    @Enumerated(EnumType.STRING)
    private DrinkFlavor flavor;

    @Enumerated(EnumType.STRING)
    private DrinkSize size;

    private int stockCount;
    private boolean isAvailable;

    // For JPA (no arguments constructor)
    protected Drink() {
        super();
    }

    public Drink(double price, DrinkFlavor flavor, DrinkSize size, int stockCount, boolean isAvailable) {
        super(flavor.getLabel(), price);
        this.flavor = flavor;
        this.size = size;
        this.stockCount = stockCount;
        this.isAvailable = isAvailable;
    }

    @Override
    public void printDetails() {

    }
}
