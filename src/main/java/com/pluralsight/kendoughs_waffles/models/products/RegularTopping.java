package com.pluralsight.kendoughs_waffles.models.products;

import com.pluralsight.kendoughs_waffles.models.enums.ToppingName;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

// Marks class as a JPA entity, mapping to the "toppings" table
@Entity
// Tells JPA that this class is a subclass of Topping and to use the "REGULAR" discriminator value
@DiscriminatorValue("REGULAR")
public class RegularTopping extends Topping{

    public RegularTopping(ToppingName name, int stockCount, boolean isAvailable) {
        super(name, .5, stockCount, isAvailable);
    }

    protected RegularTopping() {
        super();
    }

    @Override
    public double getExtraCost() {
        return 0;
    }
}
