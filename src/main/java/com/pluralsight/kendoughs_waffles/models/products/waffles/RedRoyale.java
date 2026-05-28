package com.pluralsight.kendoughs_waffles.models.products.waffles;

import com.pluralsight.kendoughs_waffles.models.enums.FillFlavor;
import com.pluralsight.kendoughs_waffles.models.enums.ToppingName;
import com.pluralsight.kendoughs_waffles.models.enums.WaffleSize;
import com.pluralsight.kendoughs_waffles.models.enums.WaffleType;
import com.pluralsight.kendoughs_waffles.models.products.PremiumTopping;


import java.util.ArrayList;

public class RedRoyale extends SignatureWaffle {

    public RedRoyale() {
        super(
                "The Red Royale",
                12.99,
                WaffleType.RED_VELVET,
                WaffleSize.REGULAR,
                new ArrayList<>(),
                FillFlavor.NONE,
                "A bold red velvet waffle stuffed with cream cheese, crowned with a scoop of ice cream, fresh blueberries, and cookie butter. Dessert for breakfast — no apologies."
        );
        PremiumTopping iceCream = new PremiumTopping(ToppingName.ICE_CREAM,  100, true);
        PremiumTopping freshBlueberries = new PremiumTopping(ToppingName.FRESH_BLUEBERRIES, 100, true);
        PremiumTopping cookieButter = new PremiumTopping(ToppingName.COOKIE_BUTTER, 100, true);
        getToppings().add(iceCream);
        getToppings().add(freshBlueberries);
        getToppings().add(cookieButter);
    }
}
