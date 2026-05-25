package com.pluralsight.kendoughs_waffles.controllers;

import com.pluralsight.kendoughs_waffles.models.products.Drink;
import com.pluralsight.kendoughs_waffles.models.products.Side;
import com.pluralsight.kendoughs_waffles.models.products.Topping;
import com.pluralsight.kendoughs_waffles.repositories.DrinkRepository;
import com.pluralsight.kendoughs_waffles.repositories.SideRepository;
import com.pluralsight.kendoughs_waffles.repositories.ToppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuRestController {

    @Autowired
    private DrinkRepository drinkRepository;

    @Autowired
    private SideRepository sideRepository;

    @Autowired
    private ToppingRepository toppingRepository;

    @GetMapping("/drinks")
    public List<Drink> getAvailableDrinks() {
        return drinkRepository.findAllByIsAvailable(true);
    }

    @GetMapping("/sides")
    public List<Side> getAvailableSides() {
        return sideRepository.findAllByIsAvailable(true);
    }

    @GetMapping("/toppings")
    public List<Topping> getAvailableToppings() {
        return toppingRepository.findAllByIsAvailable(true);
    }
}
