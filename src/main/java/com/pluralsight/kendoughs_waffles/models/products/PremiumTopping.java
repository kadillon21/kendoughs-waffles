package com.pluralsight.kendoughs_waffles.models.products;

import com.pluralsight.kendoughs_waffles.models.enums.ToppingName;
import jakarta.persistence.Entity;

@Entity
public class PremiumTopping extends Topping{

    public PremiumTopping(ToppingName name, double price, int stockCount, boolean isAvailable) {
        super(name, price, stockCount, isAvailable);
    }

    @Override
    public double getExtraCost() {
        return getPrice();
    }
}
