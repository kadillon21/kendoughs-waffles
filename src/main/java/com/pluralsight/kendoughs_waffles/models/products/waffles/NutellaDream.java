package com.pluralsight.kendoughs_waffles.models.products.waffles;

import com.pluralsight.kendoughs_waffles.models.enums.FillFlavor;
import com.pluralsight.kendoughs_waffles.models.enums.ToppingName;
import com.pluralsight.kendoughs_waffles.models.enums.WaffleSize;
import com.pluralsight.kendoughs_waffles.models.enums.WaffleType;
import com.pluralsight.kendoughs_waffles.models.products.PremiumTopping;
import com.pluralsight.kendoughs_waffles.models.products.RegularTopping;

import java.util.ArrayList;
import java.util.List;

public class NutellaDream extends SignatureWaffle{
    public NutellaDream() {
        super(
                "The Nutella Dream",
                12.99,
                WaffleType.BELGIAN,
                WaffleSize.REGULAR,
                new ArrayList<>(),
                FillFlavor.NONE,
                "A Belgian waffle stuffed with rich Nutella, topped with fresh strawberries and whipped cream. Warning: this one is dangerously good."
        );
        PremiumTopping nutella = new PremiumTopping(ToppingName.NUTELLA, 100, true);
        PremiumTopping freshStrawberries = new PremiumTopping(ToppingName.FRESH_STRAWBERRIES, 100, true);
        RegularTopping whippedCream = new RegularTopping(ToppingName.WHIPPED_CREAM, 100, true);
        getToppings().add(nutella);
        getToppings().add(freshStrawberries);
        getToppings().add(whippedCream);
    }
}
