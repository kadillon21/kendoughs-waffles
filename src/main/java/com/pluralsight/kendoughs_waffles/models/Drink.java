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

    @Override
    public void printDetails() {

    }
}
