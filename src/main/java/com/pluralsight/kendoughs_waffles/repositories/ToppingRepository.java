package com.pluralsight.kendoughs_waffles.repositories;

import com.pluralsight.kendoughs_waffles.models.enums.ToppingName;
import com.pluralsight.kendoughs_waffles.models.products.Topping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

// Repository interface for Topping entities
public interface ToppingRepository extends JpaRepository<Topping, Integer> {
    // Returns all available toppings
    List<Topping> findAllByIsAvailable(boolean isAvailable);
    // Returns a topping by name and availability
    Optional<Topping> findByNameAndIsAvailable(ToppingName name, boolean isAvailable);
}
