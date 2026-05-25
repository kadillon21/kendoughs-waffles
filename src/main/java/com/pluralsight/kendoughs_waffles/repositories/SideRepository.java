package com.pluralsight.kendoughs_waffles.repositories;

import com.pluralsight.kendoughs_waffles.models.products.Side;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SideRepository extends JpaRepository<Side, Integer> {
    List<Side> findAllByIsAvailable(boolean isAvailable);
}
