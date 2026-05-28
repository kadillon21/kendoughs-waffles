package com.pluralsight.kendoughs_waffles.repositories;

import com.pluralsight.kendoughs_waffles.models.enums.SideType;
import com.pluralsight.kendoughs_waffles.models.products.Side;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

// Repository interface for Side entities
public interface SideRepository extends JpaRepository<Side, Integer> {
    // Returns all available sides
    List<Side> findAllByIsAvailable(boolean isAvailable);

    // Returns a side by type and availability
    Optional<Side> findBySideTypeAndIsAvailable(SideType sideType, boolean isAvailable);
}
