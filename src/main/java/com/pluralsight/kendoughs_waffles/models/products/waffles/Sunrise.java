package com.pluralsight.kendoughs_waffles.models.products.waffles;

import com.pluralsight.kendoughs_waffles.models.enums.FillFlavor;
import com.pluralsight.kendoughs_waffles.models.enums.ToppingName;
import com.pluralsight.kendoughs_waffles.models.enums.WaffleSize;
import com.pluralsight.kendoughs_waffles.models.enums.WaffleType;
import com.pluralsight.kendoughs_waffles.models.products.PremiumTopping;
import com.pluralsight.kendoughs_waffles.models.products.RegularTopping;

import java.util.ArrayList;

public class Sunrise extends SignatureWaffle{

    public Sunrise() {
        super(
                "The Sunrise",
                12.99,
                WaffleType.CHURRO,
                WaffleSize.REGULAR,
                new ArrayList<>(),
                false,
                FillFlavor.NONE,
                "A warm churro waffle dusted with powdered sugar, drizzled with maple syrup, and topped with savory bacon crumbles. Sweet, salty, and everything in between."
        );
        PremiumTopping baconCrumbles = new PremiumTopping(ToppingName.BACON_CRUMBLES, 1, 100, true);
        RegularTopping mapleSyrup = new RegularTopping(ToppingName.FRESH_STRAWBERRIES, 1, 100, true);
        RegularTopping powderedSugar = new RegularTopping(ToppingName.POWDERED_SUGAR, 1, 100, true);
        getToppings().add(baconCrumbles);
        getToppings().add(mapleSyrup);
        getToppings().add(powderedSugar);
    }
}
