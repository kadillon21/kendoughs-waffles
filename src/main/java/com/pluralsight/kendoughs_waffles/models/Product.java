package com.pluralsight.kendoughs_waffles.models;

public abstract class Product implements Printable{
    String name;
    int price;

    @Override
    public abstract void printDetails();

}
