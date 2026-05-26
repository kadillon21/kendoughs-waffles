package com.pluralsight.kendoughs_waffles.repositories;

import com.pluralsight.kendoughs_waffles.models.products.WaffleSizeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WaffleSizeRepository extends JpaRepository<WaffleSizeEntity, Integer> {
    List<WaffleSizeEntity> findAllByIsAvailable(boolean isAvailable);
}
