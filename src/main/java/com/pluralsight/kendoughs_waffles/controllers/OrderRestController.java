package com.pluralsight.kendoughs_waffles.controllers;

import com.pluralsight.kendoughs_waffles.models.Order;
import com.pluralsight.kendoughs_waffles.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderRestController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/submit")
    public ResponseEntity<String> submitOrder(@RequestBody Order order) {
        orderService.updateStock(order);
        return ResponseEntity.ok("Order submitted successfully!");
    }
}