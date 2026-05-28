package com.pluralsight.kendoughs_waffles.models.products.order;

import com.pluralsight.kendoughs_waffles.models.products.Product;

import java.util.List;

public class Order {
    // Variables used to store the order details
    private int id;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private List<Product> products;

    // Constructor
    public Order(int id, String customerName, String customerEmail, String customerPhone, List<Product> products) {
        this.id = id;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
        this.products = products;
    }

    // Getters and Setters
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

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    // Methods to calculate the subtotal and total
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
        return total + salesTax;
    }

    // Method to print the order details
    public String printOrder() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for(Product product : products) {
            i++;
            sb.append(i).append(") ").append(product.printDetails());
            product.printDetails();
        }

        return sb.toString();
    }
}
