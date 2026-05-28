package com.pluralsight.kendoughs_waffles.repositories;

import com.pluralsight.kendoughs_waffles.models.enums.WaffleSize;
import com.pluralsight.kendoughs_waffles.models.products.WaffleSizeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

// Repository interface for WaffleSize entities
public interface WaffleSizeRepository extends JpaRepository<WaffleSizeEntity, Integer> {
    // Returns all available waffle sizes
    List<WaffleSizeEntity> findAllByIsAvailable(boolean isAvailable);

    // Returns a waffle size entity by size enum value and availability
    Optional<WaffleSizeEntity> findByWaffleSizeAndIsAvailable(WaffleSize waffleSize, boolean isAvailable);
}
