package com.pluralsight.kendoughs_waffles.models.products;

import com.pluralsight.kendoughs_waffles.models.enums.ToppingName;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
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
