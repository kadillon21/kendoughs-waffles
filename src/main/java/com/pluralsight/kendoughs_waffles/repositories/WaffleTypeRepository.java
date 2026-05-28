package com.pluralsight.kendoughs_waffles.repositories;

import com.pluralsight.kendoughs_waffles.models.products.WaffleTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Repository interface for WaffleType entities
public interface WaffleTypeRepository extends JpaRepository<WaffleTypeEntity, Integer> {
    // Returns all available waffle types
    List<WaffleTypeEntity> findAllByIsAvailable(boolean isAvailable);
}
