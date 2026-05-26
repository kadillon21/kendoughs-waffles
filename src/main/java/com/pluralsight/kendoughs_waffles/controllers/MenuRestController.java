package com.pluralsight.kendoughs_waffles.controllers;

import com.pluralsight.kendoughs_waffles.models.products.*;
import com.pluralsight.kendoughs_waffles.repositories.*;
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

    @Autowired
    private WaffleTypeRepository waffleTypeRepository;

    @Autowired
    private WaffleSizeRepository waffleSizeRepository;

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

    @GetMapping("/waffle-types")
    public List<WaffleTypeEntity> getAvailableWaffleTypes() {
        return waffleTypeRepository.findAllByIsAvailable(true);
    }

    @GetMapping("/waffle-sizes")
    public List<WaffleSizeEntity> getAvailableWaffleSizes() {
        return waffleSizeRepository.findAllByIsAvailable(true);
    }
}
