package com.pluralsight.kendoughs_waffles.models;

import com.pluralsight.kendoughs_waffles.models.enums.SideType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Side extends Product{
    @Enumerated(EnumType.STRING)
    private SideType type;

    private int stockCount;
    private boolean isAvailable;

    @Override
    public void printDetails() {

    }
}
