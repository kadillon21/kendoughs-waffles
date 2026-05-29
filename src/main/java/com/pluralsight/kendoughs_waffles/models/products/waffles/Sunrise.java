package com.pluralsight.kendoughs_waffles.models.products.waffles;

import com.pluralsight.kendoughs_waffles.models.enums.FillFlavor;
import com.pluralsight.kendoughs_waffles.models.enums.ToppingName;
import com.pluralsight.kendoughs_waffles.models.enums.WaffleSize;
import com.pluralsight.kendoughs_waffles.models.enums.WaffleType;
import com.pluralsight.kendoughs_waffles.models.products.PremiumTopping;
import com.pluralsight.kendoughs_waffles.models.products.RegularTopping;
import com.pluralsight.kendoughs_waffles.models.products.Topping;

import java.util.ArrayList;
import java.util.List;

public class Sunrise extends SignatureWaffle {

    public Sunrise(List<Topping> toppings) {
        super(
                "The Sunrise",
                8.49,
                WaffleType.CHURRO,
                WaffleSize.REGULAR,
                new ArrayList<>(),
                FillFlavor.NONE,
                "A warm churro waffle dusted with powdered sugar, drizzled with maple syrup, and topped with savory bacon crumbles. Sweet, salty, and everything in between."
        );
        PremiumTopping baconCrumbles = new PremiumTopping(ToppingName.BACON_CRUMBLES, 100, true);
        RegularTopping mapleSyrup = new RegularTopping(ToppingName.MAPLE_SYRUP, 100, true);
        RegularTopping powderedSugar = new RegularTopping(ToppingName.POWDERED_SUGAR, 100, true);
        getToppings().add(baconCrumbles);
        getToppings().add(mapleSyrup);
        getToppings().add(powderedSugar);
    }
}
