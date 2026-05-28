package com.pluralsight.kendoughs_waffles.services;

import com.pluralsight.kendoughs_waffles.models.products.order.Order;
import com.pluralsight.kendoughs_waffles.models.products.Drink;
import com.pluralsight.kendoughs_waffles.models.products.Product;
import com.pluralsight.kendoughs_waffles.models.products.Side;
import com.pluralsight.kendoughs_waffles.models.products.Topping;
import com.pluralsight.kendoughs_waffles.models.products.waffles.Waffle;
import com.pluralsight.kendoughs_waffles.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Marks the class as a service class containing business logic
@Service
public class OrderService {

    // @Autowired tells Spring to inject the repository
    @Autowired
    private DrinkRepository drinkRepository;

    @Autowired
    private SideRepository sideRepository;

    @Autowired
    private ToppingRepository toppingRepository;

    @Autowired
    private WaffleSizeRepository waffleSizeRepository;

    @Autowired
    private WaffleTypeRepository waffleTypeRepository;

    @Transactional
    public void updateStock(Order order) {
        for (Product product : order.getProducts()) {
            if (product instanceof Drink drink) {
                drink.setStockCount(drink.getStockCount() - 1);
                if (drink.getStockCount() <= 0) drink.setAvailable(false);
                drinkRepository.save(drink);
            } else if (product instanceof Side side) {
                side.setStockCount(side.getStockCount() - 1);
                if (side.getStockCount() <= 0) side.setAvailable(false);
                sideRepository.save(side);
            } else if (product instanceof Waffle waffle) {
                for (Topping topping : waffle.getToppings()) {
                    toppingRepository.findById(topping.getId()).ifPresent(t -> {
                        t.setStockCount(t.getStockCount() - 1);
                        if (t.getStockCount() <= 0) t.setAvailable(false);
                        toppingRepository.save(t);
                    });
                }
            } else if (product instanceof Waffle waffle) {
                // Decrement topping stock
                for (Topping topping : waffle.getToppings()) {
                    toppingRepository.findById(topping.getId()).ifPresent(t -> {
                        t.setStockCount(t.getStockCount() - 1);
                        if (t.getStockCount() <= 0) t.setAvailable(false);
                        toppingRepository.save(t);
                    });
                }
                // Decrement waffle type stock
                waffleTypeRepository.findByWaffleTypeAndIsAvailable(waffle.getType(), true).ifPresent(t -> {
                    t.setStockCount(t.getStockCount() - 1);
                    if (t.getStockCount() <= 0) t.setAvailable(false);
                    waffleTypeRepository.save(t);
                });
                // Decrement waffle size stock
                waffleSizeRepository.findByWaffleSizeAndIsAvailable(waffle.getSize(), true).ifPresent(s -> {
                    s.setStockCount(s.getStockCount() - 1);
                    if (s.getStockCount() <= 0) s.setAvailable(false);
                    waffleSizeRepository.save(s);
                });
            }
        }
    }
}