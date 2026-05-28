package com.pluralsight.kendoughs_waffles.util;

import com.pluralsight.kendoughs_waffles.models.Order;
import com.pluralsight.kendoughs_waffles.models.OrderItemRequest;
import com.pluralsight.kendoughs_waffles.models.OrderRequest;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.stream.Stream;

public class ReceiptWriter {

    public static void writeReceipt(Order order) throws IOException {

        Random random = new Random();
        int cardNumber = random.nextInt(9999);
        NumberFormat money = NumberFormat.getCurrencyInstance();
        double subtotal = order.calcSubTotal();
        double total = order.calcTotal();
        double tax = total - subtotal;

        try {
            new File("receipts").mkdirs();
            FileWriter fileWriter = new FileWriter("receipts/" + generateOrderNumber() + generateTimestamp() + ".txt");
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write("Ken-dough's Waffles\n");
            writer.write("1134 Waffle Lane\n");
            writer.write("Waffle Ville, Tx 76554\n\n");
            writer.write("\tSale\n");
            writer.write("Date: "+ String.valueOf(LocalDate.now()) + "\tTime: " + String.valueOf(LocalTime.now().truncatedTo(ChronoUnit.SECONDS)) + "\n\n");
            writer.write("Visa " + cardNumber + "\n\n");
            writer.write("Order Summary\n");
            writer.write(order.printOrder());
            writer.write("\n");
            writer.write("Subtotal: " + money.format(subtotal) + "\n");
            writer.write("Tax: " + money.format(tax) + "\n");
            writer.write("Total: " + money.format(total) + "\n");
            writer.write("\n");
            writer.write("Thank you for shopping at Ken-dough's Waffles!\n");
            writer.write("We hope to see you again soon!");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error creating receipt file.");
        }

    }

    public static void writeReceipt(OrderRequest order) throws IOException {

        Random random = new Random();
        int cardNumber = random.nextInt(1000,10000);
        NumberFormat money = NumberFormat.getCurrencyInstance();
        double subtotal = order.getTotal();
        double tax = subtotal * 0.065;
        double total = subtotal + tax;

        try {
            new File("receipts").mkdirs();
            FileWriter fileWriter = new FileWriter("receipts/" +  generateOrderNumber()+ generateTimestamp() + ".txt");
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write("Ken-dough's Waffles\n");
            writer.write("1134 Waffle Lane\n");
            writer.write("Waffle Ville, Tx 76554\n\n");
            writer.write("\tSale\n");
            writer.write("Date: "+ String.valueOf(LocalDate.now()) + "\tTime: " + String.valueOf(LocalTime.now().truncatedTo(ChronoUnit.SECONDS)) + "\n\n");
            writer.write("Visa " + cardNumber + "\n\n");
            writer.write("Order Summary\n");
            for(OrderItemRequest item : order.getItems()) {
                writer.write(item.getName() + " - $" + money.format(item.getPrice()) + "\n");
            }
            writer.write("\n");
            writer.write("Subtotal: " + money.format(subtotal) + "\n");
            writer.write("Tax: " + money.format(tax) + "\n");
            writer.write("Total: " + money.format(total) + "\n");
            writer.write("\n");
            writer.write("Thank you for shopping at Ken-dough's Waffles!\n");
            writer.write("We hope to see you again soon!");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error creating receipt file.");
        }

    }

    public static String generateOrderNumber() throws IOException {
        new File("receipts").mkdirs();
        try(Stream<Path> files = Files.list(Paths.get("receipts"))) {
            long count = files.count();
            return "Order-" + String.format("%04d",count + 1) + "-";
        } catch (IOException e) {
            System.out.println("Error generating order number: " + e.getMessage());
        }
        return null;
    }

    private static String generateTimestamp(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy-HH-mm-ss");

        return now.format(formatter);
    }
}
