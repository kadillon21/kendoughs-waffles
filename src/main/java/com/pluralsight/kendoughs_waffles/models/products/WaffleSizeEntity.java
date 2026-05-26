package com.pluralsight.kendoughs_waffles.models.products;

import com.pluralsight.kendoughs_waffles.models.enums.WaffleSize;
import jakarta.persistence.*;

@Entity
public class WaffleSizeEntity {
    @Id
    @GeneratedValue
    private int id;

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