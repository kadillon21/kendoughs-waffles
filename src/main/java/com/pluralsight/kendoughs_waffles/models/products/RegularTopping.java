package com.pluralsight.kendoughs_waffles.models.products;

import com.pluralsight.kendoughs_waffles.models.enums.ToppingName;
import jakarta.persistence.Entity;

@Entity
public class RegularTopping extends Topping{

    public RegularTopping(ToppingName name, double price, int stockCount, boolean isAvailable) {
        super(name, price, stockCount, isAvailable);
    }

    @Override
    public double getExtraCost() {
        return 0;
    }
}
