package com.pluralsight.kendoughs_waffles.models.products;

import com.pluralsight.kendoughs_waffles.models.interfaces.Printable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

// Tells JPA that this class is a parent class for all products
@MappedSuperclass
public abstract class Product implements Printable {
    // Marks this field as the primary key for the table
    @Id
    // Automatically generates a unique ID for each new product
    @GeneratedValue
    private int id;

    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // For JPA (no arguments constructor)
    public Product() {

    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    @Override
    public abstract String printDetails();


}
