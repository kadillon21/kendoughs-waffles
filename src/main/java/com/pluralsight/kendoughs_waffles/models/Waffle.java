package com.pluralsight.kendoughs_waffles.models;

import com.pluralsight.kendoughs_waffles.models.enums.FillFlavor;
import com.pluralsight.kendoughs_waffles.models.enums.WaffleSize;
import com.pluralsight.kendoughs_waffles.models.enums.WaffleType;

import java.util.List;

public class Waffle extends Product{
    private WaffleType waffleType;
    private WaffleSize waffleSize;
    private List<Topping> toppings;
    private boolean isStuffed;
    private FillFlavor fillFlavor;

    public Waffle(String name, double price, WaffleType waffleType, WaffleSize waffleSize, List<Topping> toppings, boolean isStuffed, FillFlavor fillFlavor) {
        super(name, price);
        this.waffleType = waffleType;
        this.waffleSize = waffleSize;
        this.toppings = toppings;
        this.isStuffed = isStuffed;
        this.fillFlavor = fillFlavor;
    }

    public double calcPrice(){
        double totalPrice = waffleSize.getPrice();
        if (isStuffed) { totalPrice += 1.5;}
        for (Topping topping : toppings) {
            totalPrice += topping.getExtraCost();
        }
        return totalPrice;
    }

    @Override
    public String printDetails() {
        return waffleType.getLabel() + " - " + waffleSize.getLabel() + " - " + getPrice();
    }
}
