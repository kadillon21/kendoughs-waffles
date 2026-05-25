package com.pluralsight.kendoughs_waffles.repositories;

import com.pluralsight.kendoughs_waffles.models.enums.SideType;
import com.pluralsight.kendoughs_waffles.models.products.Side;

import java.util.List;
import java.util.Optional;

public interface SideRepository {
    List<Side> findAllByIsAvailable(boolean isAvailable);
    Optional<Side> findBySideTypeAndIsAvailable(SideType sideType, boolean isAvailable);
}
