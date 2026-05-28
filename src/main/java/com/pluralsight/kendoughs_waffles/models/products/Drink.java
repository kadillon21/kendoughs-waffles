package com.pluralsight.kendoughs_waffles.models.products;

import com.pluralsight.kendoughs_waffles.models.enums.DrinkFlavor;
import com.pluralsight.kendoughs_waffles.models.enums.DrinkSize;
import jakarta.persistence.*;

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

    // Constructor
    public Drink(double price, DrinkFlavor flavor, DrinkSize size, int stockCount, boolean isAvailable) {
        super(flavor.getLabel(), price);
        this.flavor = flavor;
        this.size = size;
        this.stockCount = stockCount;
        this.isAvailable = isAvailable;
    }

    // Getters and Setters
    public int getStockCount() { return stockCount; }
    public void setStockCount(int stockCount) { this.stockCount = stockCount; }
    public void setAvailable(boolean isAvailable) { this.isAvailable = isAvailable; }

    // Method to print details of the drink
    @Override
    public String printDetails() {
        StringBuilder sb = new StringBuilder();
        NumberFormat money = NumberFormat.getCurrencyInstance();
        sb.append(flavor.getLabel()).append(" - ").append(money.format(this.getPrice())).append("\n");
        sb.append("\tSize: ").append(size.getLabel()).append("\n");

        return sb.toString();
    }
}
