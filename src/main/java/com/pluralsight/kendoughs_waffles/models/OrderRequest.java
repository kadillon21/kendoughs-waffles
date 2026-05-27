package com.pluralsight.kendoughs_waffles.models;

import java.util.List;

public class OrderRequest {
    private List<OrderItemRequest> items;
    private double total;

    public List<OrderItemRequest> getItems() { return items; }
    public void setItems(List<OrderItemRequest> items) { this.items = items; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
}
