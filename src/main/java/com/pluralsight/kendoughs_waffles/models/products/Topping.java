package com.pluralsight.kendoughs_waffles.models.products;

import com.pluralsight.kendoughs_waffles.models.enums.ToppingName;
import jakarta.persistence.*;

@Entity
@Table(name = "toppings")
public abstract class Topping {
    @Id
    @GeneratedValue
    private int id;

    @Enumerated(EnumType.STRING)
    private ToppingName name;

    private double price;
    private int stockCount;
    private boolean isAvailable;

    public Topping(ToppingName name, double price, int stockCount, boolean isAvailable) {
        this.price = price;
        this.stockCount = stockCount;
        this.isAvailable = isAvailable;
    }

    public double getPrice() {
        return price;
    }

    public abstract double getExtraCost();
}
