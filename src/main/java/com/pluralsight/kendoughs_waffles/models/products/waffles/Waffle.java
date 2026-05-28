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

    public Waffle(String name, double price, WaffleType waffleType, WaffleSize waffleSize, List<Topping> toppings, FillFlavor fillFlavor) {
        super(name, price);
        this.waffleType = waffleType;
        this.waffleSize = waffleSize;
        this.toppings = toppings;
        this.fillFlavor = fillFlavor;
    }

    public double calcPrice(){
        double totalPrice = waffleSize.getPrice() + waffleType.getPrice() + fillFlavor.getPrice();
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
        StringBuilder sb = new StringBuilder();
        NumberFormat money = NumberFormat.getCurrencyInstance();
        sb.append(this.getName()).append(" - ").append(money.format(this.getPrice())).append("\n");
        sb.append("\tType: ").append(waffleType.getLabel()).append(" ").append(money.format(waffleType.getPrice())).append("\n");
        sb.append("\tSize: ").append(waffleSize.getLabel()).append(" ").append(money.format(waffleSize.getPrice())).append("\n");
        sb.append("\tFilling: ").append(fillFlavor.getLabel()).append(" ").append(money.format(fillFlavor.getPrice())).append("\n");
        sb.append("\tToppings: \n");
        for (Topping topping : toppings) {
            sb.append("\t    ").append(topping.getLabel()).append(" ").append(money.format(topping.getExtraCost())).append("\n");
        }
        return sb.toString();
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

    public void setWaffleType(WaffleType waffleType) {
        this.waffleType = waffleType;
    }

    public void setWaffleSize(WaffleSize waffleSize) {
        this.waffleSize = waffleSize;
    }

    public void setFillFlavor(FillFlavor fillFlavor) {
        this.fillFlavor = fillFlavor;
    }
}
