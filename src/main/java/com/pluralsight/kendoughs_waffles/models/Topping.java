package com.pluralsight.kendoughs_waffles.models;

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

    public abstract double getExtraCost();
}
