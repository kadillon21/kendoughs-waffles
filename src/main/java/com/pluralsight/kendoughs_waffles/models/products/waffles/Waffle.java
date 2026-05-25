package com.pluralsight.kendoughs_waffles.models.products.waffles;

import com.pluralsight.kendoughs_waffles.models.enums.FillFlavor;
import com.pluralsight.kendoughs_waffles.models.enums.WaffleSize;
import com.pluralsight.kendoughs_waffles.models.enums.WaffleType;
import com.pluralsight.kendoughs_waffles.models.products.Product;
import com.pluralsight.kendoughs_waffles.models.products.Topping;

import java.text.NumberFormat;
import java.util.List;

public class Waffle extends Product {
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

    public List<Topping> getToppings() {
        return toppings;
    }

    @Override
    public String printDetails() {
        NumberFormat money = NumberFormat.getCurrencyInstance();
        return waffleType.getLabel() + " - " + waffleSize.getLabel() + " - " + money.format(getPrice());
    }

    public WaffleType getType() {
        return waffleType;
    }

    public WaffleSize getSize() {
        return waffleSize;
    }

    public FillFlavor getFilling() {
        return fillFlavor;
    }
}
