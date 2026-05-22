package com.pluralsight.kendoughs_waffles.models;

import com.pluralsight.kendoughs_waffles.models.enums.DrinkFlavor;
import com.pluralsight.kendoughs_waffles.models.enums.DrinkSize;
import com.pluralsight.kendoughs_waffles.models.enums.SideType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Side extends Product{
    @Enumerated(EnumType.STRING)
    private SideType type;

    private int stockCount;
    private boolean isAvailable;

    // For JPA (no arguments constructor)
    protected Side() {
        super();
    }

    public Side(double price, SideType sideType, int stockCount, boolean isAvailable) {
        super(sideType.getLabel(), price);
        this.type = sideType;
        this.stockCount = stockCount;
        this.isAvailable = isAvailable;
    }


    @Override
    public void printDetails() {

    }
}
