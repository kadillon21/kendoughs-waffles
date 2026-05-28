package com.pluralsight.kendoughs_waffles.services;

import com.pluralsight.kendoughs_waffles.models.Order;
import com.pluralsight.kendoughs_waffles.models.products.Drink;
import com.pluralsight.kendoughs_waffles.models.products.Product;
import com.pluralsight.kendoughs_waffles.models.products.Side;
import com.pluralsight.kendoughs_waffles.models.products.Topping;
import com.pluralsight.kendoughs_waffles.models.products.waffles.Waffle;
import com.pluralsight.kendoughs_waffles.repositories.DrinkRepository;
import com.pluralsight.kendoughs_waffles.repositories.SideRepository;
import com.pluralsight.kendoughs_waffles.repositories.ToppingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private DrinkRepository drinkRepository;

    @Autowired
    private SideRepository sideRepository;

    @Autowired
    private ToppingRepository toppingRepository;

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
            }
        }
    }
}