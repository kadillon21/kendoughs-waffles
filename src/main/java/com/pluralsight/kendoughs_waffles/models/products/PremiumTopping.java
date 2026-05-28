package com.pluralsight.kendoughs_waffles.models.products;

import com.pluralsight.kendoughs_waffles.models.enums.ToppingName;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PREMIUM")
public class PremiumTopping extends Topping{

    public PremiumTopping(ToppingName name, int stockCount, boolean isAvailable) {
        super(name, 1, stockCount, isAvailable);

    }

    protected PremiumTopping() {
        super();
    }

    @Override
    public double getExtraCost() {
        return getPrice();
    }
}
