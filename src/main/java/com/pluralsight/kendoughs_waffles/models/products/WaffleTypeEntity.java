package com.pluralsight.kendoughs_waffles.models.products;

import com.pluralsight.kendoughs_waffles.models.enums.WaffleType;
import jakarta.persistence.*;

@Entity
public class WaffleTypeEntity {
    @Id
    @GeneratedValue
    private int id;

    @Enumerated(EnumType.STRING)
    private WaffleType waffleType;

    private int stockCount;
    private boolean isAvailable;

    public WaffleTypeEntity(){

    }

    public int getId() { return id; }
    public WaffleType getWaffleType() { return waffleType; }
    public int getStockCount() { return stockCount; }
    public boolean isAvailable() { return isAvailable; }
}
