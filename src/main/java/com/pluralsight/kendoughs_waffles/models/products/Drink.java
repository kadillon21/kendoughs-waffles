package com.pluralsight.kendoughs_waffles.models.products;

import com.pluralsight.kendoughs_waffles.models.enums.DrinkFlavor;
import com.pluralsight.kendoughs_waffles.models.enums.DrinkSize;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.text.NumberFormat;

@Entity
public class Drink extends Product {
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
    public String printDetails() {
        StringBuilder sb = new StringBuilder();
        NumberFormat money = NumberFormat.getCurrencyInstance();
        sb.append(flavor.getLabel()).append(" - ").append(money.format(this.getPrice())).append("\n");
        sb.append("\tSize: ").append(size.getLabel()).append("\n");

        return sb.toString();
    }
}
