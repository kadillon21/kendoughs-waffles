package com.pluralsight.kendoughs_waffles.services;

import com.pluralsight.kendoughs_waffles.models.enums.FillFlavor;
import com.pluralsight.kendoughs_waffles.models.products.Drink;
import com.pluralsight.kendoughs_waffles.models.products.Product;
import com.pluralsight.kendoughs_waffles.models.products.Side;
import com.pluralsight.kendoughs_waffles.models.products.Topping;
import com.pluralsight.kendoughs_waffles.models.products.order.Order;
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
    private WaffleTypeRepository waffleTypeRepository;

    @Autowired
    private WaffleSizeRepository waffleSizeRepository;

    @Autowired
    private FillFlavorRepository fillFlavorRepository;

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
                waffleTypeRepository.findByWaffleTypeAndIsAvailable(waffle.getType(), true).ifPresent(wt -> {
                    wt.setStockCount(wt.getStockCount() - 1);
                    if (wt.getStockCount() <= 0) wt.setAvailable(false);
                    waffleTypeRepository.save(wt);
                });
                waffleSizeRepository.findByWaffleSizeAndIsAvailable(waffle.getSize(), true).ifPresent(ws -> {
                    ws.setStockCount(ws.getStockCount() - 1);
                    if (ws.getStockCount() <= 0) ws.setAvailable(false);
                    waffleSizeRepository.save(ws);
                });
                if (waffle.getFilling() != FillFlavor.NONE) {
                    fillFlavorRepository.findByFillFlavorAndIsAvailable(waffle.getFilling(), true).ifPresent(ff -> {
                        ff.setStockCount(ff.getStockCount() - 1);
                        if (ff.getStockCount() <= 0) ff.setAvailable(false);
                        fillFlavorRepository.save(ff);
                    });
                }
            }
        }
    }
}