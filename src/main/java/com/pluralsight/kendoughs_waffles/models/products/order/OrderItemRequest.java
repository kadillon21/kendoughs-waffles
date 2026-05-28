package com.pluralsight.kendoughs_waffles.models.products.order;

public class OrderItemRequest {
    // Variables used to store the order item details
    private String name;
    private double price;
    private String description;

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
