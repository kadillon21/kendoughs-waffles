package com.pluralsight.kendoughs_waffles.models.products.waffles;

import com.pluralsight.kendoughs_waffles.models.enums.FillFlavor;
import com.pluralsight.kendoughs_waffles.models.enums.ToppingName;
import com.pluralsight.kendoughs_waffles.models.enums.WaffleSize;
import com.pluralsight.kendoughs_waffles.models.enums.WaffleType;
import com.pluralsight.kendoughs_waffles.models.products.RegularTopping;
import com.pluralsight.kendoughs_waffles.models.products.Topping;

import java.util.ArrayList;
import java.util.List;

public class ClassicKen extends SignatureWaffle {


    public ClassicKen(List<Topping> toppings) {
        super(
                "The Classic Ken",
                6.49,
                WaffleType.BUTTER_MILK,
                WaffleSize.REGULAR,
                new ArrayList<>(),
                FillFlavor.NONE,
                "A golden buttermilk waffle kept simple and perfect — finished with creamy butter and a generous pour of maple syrup. The one that started it all."
        );
        RegularTopping mapleSyrup = new RegularTopping(ToppingName.MAPLE_SYRUP, 100, true);
        getToppings().add(mapleSyrup);
    }
}
