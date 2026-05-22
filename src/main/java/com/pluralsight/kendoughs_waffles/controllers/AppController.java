package com.pluralsight.kendoughs_waffles.controllers;

import com.pluralsight.kendoughs_waffles.models.Drink;
import com.pluralsight.kendoughs_waffles.models.Order;
import com.pluralsight.kendoughs_waffles.models.Product;
import com.pluralsight.kendoughs_waffles.models.Side;
import com.pluralsight.kendoughs_waffles.models.enums.DrinkFlavor;
import com.pluralsight.kendoughs_waffles.models.enums.DrinkSize;
import com.pluralsight.kendoughs_waffles.models.enums.SideType;
import com.pluralsight.kendoughs_waffles.ui.Menus;
import com.pluralsight.kendoughs_waffles.util.UserInput;

import java.util.ArrayList;
import java.util.List;

public class AppController {

    public void run() {
        handleMainMenu();


        Drink drink = new Drink(10, DrinkFlavor.COFFEE, DrinkSize.LARGE, 10, true);
        Side side = new Side(10, SideType.FRUIT_CUP, 10, true);

        List<Product> products = new ArrayList<>();
        products.add(drink);
        products.add(side);

        Order testOrder = new Order(1, "Kendall", "kendall@test.com", "555-1234", products);

        Menus.checkoutMenu(testOrder);
    }

    private void handleMainMenu() {
        boolean onMainMenu = true;
        while(onMainMenu) {
            Menus.mainMenu();
            switch (UserInput.promptForChar("What would you like to do? ", "1234X")) {
                case '1':
                    handleOrderMenu();
                    break;
                case '2':
                    break;
                case '3':
                    Menus.displayStoreMenu();
                    break;
                case '4':
                    Menus.displayAboutUs();
                    break;
                case 'X':
                    onMainMenu = false;
            }
        }
    }

    private void handleOrderMenu() {
    }
}
