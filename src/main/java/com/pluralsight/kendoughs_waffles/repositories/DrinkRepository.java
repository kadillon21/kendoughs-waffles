package com.pluralsight.kendoughs_waffles.repositories;

import com.pluralsight.kendoughs_waffles.models.enums.DrinkFlavor;
import com.pluralsight.kendoughs_waffles.models.enums.DrinkSize;
import com.pluralsight.kendoughs_waffles.models.products.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

// Repository interface for Drink entities
public interface DrinkRepository extends JpaRepository<Drink, Integer> {
    // Returns all available drinks
    List<Drink> findAllByIsAvailable(boolean isAvailable);

    // Returns a drink by flavor and size
    List<Drink> findByFlavorAndIsAvailable(DrinkFlavor flavor, boolean isAvailable);

    // Returns a drink by flavor, size, and availability
    Optional<Drink> findByFlavorAndSizeAndIsAvailable(DrinkFlavor flavor, DrinkSize size, boolean isAvailable);
}
