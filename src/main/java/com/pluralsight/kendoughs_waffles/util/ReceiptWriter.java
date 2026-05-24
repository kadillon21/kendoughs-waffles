package com.pluralsight.kendoughs_waffles.util;

import com.pluralsight.kendoughs_waffles.models.Order;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class ReceiptWriter {

    public static void writeReceipt(Order order) throws IOException {

        Random random = new Random();
        int cardNumber = random.nextInt(9999);

        try {
            FileWriter fileWriter = new FileWriter("receipts/" + "Order-Receipt-"+ generateTimestamp() + ".txt");
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write("Ken-dough's Waffles\n");
            writer.write("1134 Waffle Lane\n");
            writer.write("Waffle Ville, Tx 76554\n\n");
            writer.write("\tSale\n");
            writer.write("Date: "+ String.valueOf(LocalDate.now()) + "\tTime: " + String.valueOf(LocalTime.now()) + "\n\n");
            writer.write("Visa " + cardNumber + "\n\n");
            writer.write("Order Summary\n");
            writer.write(order.printOrder());
            writer.write("Subtotal: " + "\n");
            writer.write("Tax: " + "\n");
            writer.write("Total: " + "\n");
            writer.write("\n");
            writer.write("Thank you for shopping at Ken-dough's Waffles!\n");
            writer.write("We hope to see you again soon!");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error creating receipt file.");
        }

    }

    public static String generateTimestamp(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy-HH-mm-ss");

        return now.format(formatter);
    }
}
