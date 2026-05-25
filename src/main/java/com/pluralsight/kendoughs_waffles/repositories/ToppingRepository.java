package com.pluralsight.kendoughs_waffles.repositories;

import com.pluralsight.kendoughs_waffles.models.enums.ToppingName;
import com.pluralsight.kendoughs_waffles.models.products.Topping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ToppingRepository extends JpaRepository<Topping, Integer> {
    List<Topping> findAllByIsAvailable(boolean isAvailable);
    Optional<Topping> findByNameAndIsAvailable(ToppingName name, boolean isAvailable);
}
