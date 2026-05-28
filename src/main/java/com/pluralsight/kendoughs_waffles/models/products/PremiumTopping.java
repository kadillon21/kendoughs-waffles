package com.pluralsight.kendoughs_waffles.models.products;

import com.pluralsight.kendoughs_waffles.models.enums.ToppingName;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

// Marks class as a JPA entity, mapping to the "toppings" table
@Entity
// Tells JPA that this class is a subclass of Topping and to use the "PREMIUM" discriminator value
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
