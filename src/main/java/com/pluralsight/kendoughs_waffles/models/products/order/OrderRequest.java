package com.pluralsight.kendoughs_waffles.models.products.order;

import java.util.List;

public class OrderRequest {
    // Variables used to store the order details
    private List<OrderItemRequest> items;
    private double total;

    // Getters and setters
    public List<OrderItemRequest> getItems() { return items; }
    public void setItems(List<OrderItemRequest> items) { this.items = items; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
}
