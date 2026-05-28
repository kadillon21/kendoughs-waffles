package com.pluralsight.kendoughs_waffles.models.products;

import com.pluralsight.kendoughs_waffles.models.enums.SideType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.text.NumberFormat;

// Marks this class as a JPA entity, mapping to the "sides" table
@Entity
public class Side extends Product {
    // Stores the enum value as a string inside the database
    @Enumerated(EnumType.STRING)
    private SideType sideType;
    private int stockCount;
    private boolean isAvailable;

    // For JPA (no arguments constructor)
    protected Side() {
        super();
    }

    public Side(double price, SideType sideType, int stockCount, boolean isAvailable) {
        super(sideType.getLabel(), price);
        this.sideType = sideType;
        this.stockCount = stockCount;
        this.isAvailable = isAvailable;
    }

    public int getStockCount() {
        return stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String printDetails() {
        StringBuilder sb = new StringBuilder();
        NumberFormat money = NumberFormat.getCurrencyInstance();
        sb.append(sideType.getLabel()).append(" - ").append(money.format(this.getPrice())).append("\n");

        return sb.toString();
    }
}
