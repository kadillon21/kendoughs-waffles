package com.pluralsight.kendoughs_waffles.models.products;

import com.pluralsight.kendoughs_waffles.models.enums.FillFlavor;
import jakarta.persistence.*;

// Marks this class as a JPA entity, mapping to the "fill_flavors" table
@Entity
public class FillFlavorEntity {
    // Primary key
    @Id
    // Automatically generates a unique ID for each new fill flavor
    @GeneratedValue
    private int id;

    // Stores the enum value as a string inside the database
    @Enumerated(EnumType.STRING)
    private FillFlavor fillFlavor;

    private int stockCount;
    private boolean isAvailable;

    public FillFlavorEntity() {

    }

    public int getId() {
        return id;
    }

    public FillFlavor getFillFlavor() {
        return fillFlavor;
    }

    public int getStockCount() {
        return stockCount;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
