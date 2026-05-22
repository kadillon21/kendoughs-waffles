package com.pluralsight.kendoughs_waffles.repositories;

import com.pluralsight.kendoughs_waffles.models.Side;

import java.util.List;

public interface SideRepository {
    List<Side> findAllByIsAvailable(boolean isAvailable);
}
