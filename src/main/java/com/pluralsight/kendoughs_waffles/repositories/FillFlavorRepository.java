package com.pluralsight.kendoughs_waffles.repositories;

import com.pluralsight.kendoughs_waffles.models.enums.FillFlavor;
import com.pluralsight.kendoughs_waffles.models.products.FillFlavorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

// Repository interface for FillFlavor entities
public interface FillFlavorRepository extends JpaRepository<FillFlavorEntity, Integer> {
    // Returns all available fill flavors
    List<FillFlavorEntity> findAllByIsAvailable(boolean isAvailable);

    // Returns a fill flavor entity by flavor enum value and availability
    Optional<FillFlavorEntity> findByFillFlavorAndIsAvailable(FillFlavor fillFlavor, boolean isAvailable);
}
