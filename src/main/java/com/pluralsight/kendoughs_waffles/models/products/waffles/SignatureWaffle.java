package com.pluralsight.kendoughs_waffles.models.products.waffles;

import com.pluralsight.kendoughs_waffles.models.enums.FillFlavor;
import com.pluralsight.kendoughs_waffles.models.enums.WaffleSize;
import com.pluralsight.kendoughs_waffles.models.enums.WaffleType;
import com.pluralsight.kendoughs_waffles.models.products.Topping;

import java.util.List;

public class SignatureWaffle extends Waffle{
    private final String description;

    public SignatureWaffle(String name, double price, WaffleType waffleType, WaffleSize waffleSize, List<Topping> toppings, FillFlavor fillFlavor, String description) {
        super(name, price, waffleType, waffleSize, toppings, fillFlavor);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
