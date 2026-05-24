package com.pluralsight.kendoughs_waffles.models;

import java.util.List;

public class Order {
    private int id;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private List<Product> products;

    public Order(int id, String customerName, String customerEmail, String customerPhone, List<Product> products) {
        this.id = id;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double calcSubTotal() {
        double total = 0;
        for(Product product : products) {
            total += product.getPrice();
        }
        return total;
    }


    public double calcTotal() {
        double total = 0;
        for(Product product : products) {
            total += product.getPrice();
        }
        double salesTax = total * 0.065;
        total += (total*salesTax);
        return total;
    }

    public String printOrder() {
        StringBuilder sb = new StringBuilder();
        for(Product product : products) {
            sb.append("1  ").append(product.getName()).append(" - $").append(product.getPrice()).append("\n");
            sb.append(product.printDetails());
            product.printDetails();
        }

        return sb.toString();
    }
}
