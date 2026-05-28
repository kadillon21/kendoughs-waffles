package com.pluralsight.kendoughs_waffles.models.products;

import com.pluralsight.kendoughs_waffles.models.enums.ToppingName;
import jakarta.persistence.*;

// Marks this class as a JPA entity mapped to the "toppings" table
@Entity
@Table(name = "toppings")

// Stores all topping subclasses (PremiumTopping, RegularTopping) in this single table
// The topping_type column determines which subclass to instantiate when reading from the database
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "topping_type")
public abstract class Topping {
    // Primary key
    @Id
    // Automatically generates a unique ID for each new topping
    @GeneratedValue
    private int id;

    // Stores the enum value as a string inside the database
    @Enumerated(EnumType.STRING)
    private ToppingName name;

    private double price;
    private int stockCount;
    private boolean isAvailable;

    public Topping(ToppingName name, double price, int stockCount, boolean isAvailable) {
        this.name = name;
        this.price = price;
        this.stockCount = stockCount;
        this.isAvailable = isAvailable;
    }

    public Topping() {

    }

    public int getStockCount() {
        return stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public double getPrice() {
        return price;
    }

    public abstract double getExtraCost();

    public Object getLabel() {
        return name.getLabel();
    }

    public int getId() {
        return id;
    }
}
