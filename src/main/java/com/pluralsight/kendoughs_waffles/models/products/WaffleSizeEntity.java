package com.pluralsight.kendoughs_waffles.models.products;

import com.pluralsight.kendoughs_waffles.models.enums.WaffleSize;
import jakarta.persistence.*;

// Marks this class as a JPA entity, mapping to the "waffle_sizes" table
@Entity
public class WaffleSizeEntity {
    // Primary key
    @Id
    // Automatically generates a unique ID for each new waffle size
    @GeneratedValue
    private int id;

    // Stores the enum value as a string inside the database
    @Enumerated(EnumType.STRING)
    private WaffleSize waffleSize;

    private int stockCount;
    private boolean isAvailable;

    public WaffleSizeEntity(){

    }

    public int getId() { return id; }
    public WaffleSize getWaffleSize() { return waffleSize; }
    public int getStockCount() { return stockCount; }
    public boolean isAvailable() { return isAvailable; }
}