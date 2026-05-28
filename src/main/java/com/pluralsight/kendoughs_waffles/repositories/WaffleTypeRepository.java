package com.pluralsight.kendoughs_waffles.repositories;

import com.pluralsight.kendoughs_waffles.models.enums.WaffleType;
import com.pluralsight.kendoughs_waffles.models.products.WaffleTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

// Repository interface for WaffleType entities
public interface WaffleTypeRepository extends JpaRepository<WaffleTypeEntity, Integer> {
    // Returns all available waffle types
    List<WaffleTypeEntity> findAllByIsAvailable(boolean isAvailable);
    // Returns a waffle type entity by type enum value and availability
    Optional<WaffleTypeEntity> findByWaffleTypeAndIsAvailable(WaffleType waffleType, boolean isAvailable);
}
