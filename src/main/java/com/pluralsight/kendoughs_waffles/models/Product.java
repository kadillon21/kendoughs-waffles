package com.pluralsight.kendoughs_waffles.models;

public abstract class Product implements Printable {
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
