package com.pluralsight.kendoughs_waffles.controllers;

import com.pluralsight.kendoughs_waffles.models.OrderRequest;
import com.pluralsight.kendoughs_waffles.util.ReceiptWriter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Random;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @PostMapping("/submit")
    public int submitOrder(@RequestBody OrderRequest orderRequest) {
        Random random = new Random();
        int orderNumber = random.nextInt(9999);
        try {
            ReceiptWriter.writeReceipt(orderRequest);
        } catch (IOException e) {
            System.out.println("Error creating receipt file.");
        }
        return orderNumber;
    }
}
