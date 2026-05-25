package com.pluralsight.kendoughs_waffles.repositories;

import com.pluralsight.kendoughs_waffles.models.enums.DrinkFlavor;
import com.pluralsight.kendoughs_waffles.models.enums.DrinkSize;
import com.pluralsight.kendoughs_waffles.models.products.Drink;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DrinkRepository extends JpaRepository<Drink, Integer> {
    List<Drink> findAllByIsAvailable(boolean isAvailable);
    List<Drink> findByFlavorAndIsAvailable(DrinkFlavor flavor, boolean isAvailable);
    Optional<Drink> findByFlavorAndSizeAndIsAvailable(DrinkFlavor flavor, DrinkSize size, boolean isAvailable);
}
