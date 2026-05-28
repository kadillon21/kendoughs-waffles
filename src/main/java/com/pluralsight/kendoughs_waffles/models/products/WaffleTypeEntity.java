package com.pluralsight.kendoughs_waffles.models.products;

import com.pluralsight.kendoughs_waffles.models.enums.WaffleType;
import jakarta.persistence.*;

// Marks this class as a JPA entity, mapping to the "waffle_types" table
@Entity
public class WaffleTypeEntity {
    // Primary key
    @Id
    // Automatically generates a unique ID for each new waffle type
    @GeneratedValue
    private int id;

    // Stores the enum value as a string inside the database
    @Enumerated(EnumType.STRING)
    private WaffleType waffleType;

    private int stockCount;
    private boolean isAvailable;

    public WaffleTypeEntity() {

    }

    public int getId() {
        return id;
    }

    public WaffleType getWaffleType() {
        return waffleType;
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
