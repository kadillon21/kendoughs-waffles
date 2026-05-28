package com.pluralsight.kendoughs_waffles.repositories;

import com.pluralsight.kendoughs_waffles.models.products.WaffleSizeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Repository interface for WaffleSize entities
public interface WaffleSizeRepository extends JpaRepository<WaffleSizeEntity, Integer> {
    // Returns all available waffle sizes
    List<WaffleSizeEntity> findAllByIsAvailable(boolean isAvailable);
}
