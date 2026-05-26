package com.pluralsight.kendoughs_waffles.repositories;

import com.pluralsight.kendoughs_waffles.models.products.WaffleTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WaffleTypeRepository extends JpaRepository<WaffleTypeEntity, Integer> {
    List<WaffleTypeEntity> findAllByIsAvailable(boolean isAvailable);
}
