package com.pluralsight.kendoughs_waffles.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Product implements Printable {
    @Id
    @GeneratedValue
    private int id;

    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public abstract void printDetails();

}
